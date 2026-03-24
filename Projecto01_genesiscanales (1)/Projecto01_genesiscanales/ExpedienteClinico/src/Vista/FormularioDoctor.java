package Vista;

import Modelo.Doctor;
import Controlador.PacienteControlador;

import javax.swing.*;
import java.awt.*;

public class FormularioDoctor extends JFrame {

    private JTextField txtNombre, txtTelefono, txtDomicilio, txtEmail;
    private JComboBox<String> comboSexo, comboEspecialidad;
    private JButton btnGuardar;

    public FormularioDoctor() {
        setTitle("Registrar Doctor");
        setSize(500, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Agrega icono en la barra del formulario
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/doctor.png"));
        setIconImage(icon.getImage());

        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // Inicialización de campos de texto y combos
        txtNombre = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtDomicilio = new JTextField(20);
        txtEmail = new JTextField(20);

        comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});
        comboEspecialidad = new JComboBox<>(new String[]{
                "Cardiología", "Pediatría", "Dermatología", "Neurología", "Medicina General"
        });

        btnGuardar = new JButton("Guardar");

        // Añade campos con etiquetas al panel usando GridBagLayout
        int fila = 0;
        agregarCampo(panelCentral, gbc, fila++, "Nombre:", txtNombre);
        agregarCampo(panelCentral, gbc, fila++, "Teléfono:", txtTelefono);
        agregarCampo(panelCentral, gbc, fila++, "Sexo:", comboSexo);
        agregarCampo(panelCentral, gbc, fila++, "Domicilio:", txtDomicilio);
        agregarCampo(panelCentral, gbc, fila++, "Email:", txtEmail);
        agregarCampo(panelCentral, gbc, fila++, "Especialidad:", comboEspecialidad);

        // Botón guardar centrado y ocupando 2 columnas
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(btnGuardar, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // Evento botón guardar con validación y registro
        btnGuardar.addActionListener(e -> {
            if (txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()
                    || txtDomicilio.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            Doctor doctor = new Doctor(
                    txtNombre.getText(),
                    txtTelefono.getText(),
                    (String) comboSexo.getSelectedItem(),
                    txtDomicilio.getText(),
                    txtEmail.getText(),
                    (String) comboEspecialidad.getSelectedItem()
            );

            PacienteControlador controlador = new PacienteControlador();
            controlador.agregarDoctor(doctor);

            JOptionPane.showMessageDialog(this, "Doctor registrado:\n" + doctor.getNombre());
            dispose();
        });
    }

    // Método auxiliar para agregar campos con etiqueta
    private void agregarCampo(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, JComponent campo) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(campo, gbc);
    }
}
