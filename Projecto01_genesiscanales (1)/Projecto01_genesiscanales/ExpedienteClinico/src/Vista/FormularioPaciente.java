package Vista;

import Modelo.Paciente;
import Controlador.PacienteControlador;

import javax.swing.*;
import java.awt.*;

public class FormularioPaciente extends JFrame {

    private JTextField txtNombre, txtTelefono, txtDomicilio, txtEmail;
    private JComboBox<String> comboSexo;
    private JButton btnGuardar;

    public FormularioPaciente() {
        setTitle("Registrar Paciente");
        // Establecer icono en la barra del formulario
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/paciente.png"));
        setIconImage(icon.getImage());

        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        txtNombre = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtDomicilio = new JTextField(20);
        txtEmail = new JTextField(20);
        comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});
        btnGuardar = new JButton("Guardar");

        int fila = 0;
        agregarCampo(panelCentral, gbc, fila++, "Nombre:", txtNombre);
        agregarCampo(panelCentral, gbc, fila++, "Teléfono:", txtTelefono);
        agregarCampo(panelCentral, gbc, fila++, "Sexo:", comboSexo);
        agregarCampo(panelCentral, gbc, fila++, "Domicilio:", txtDomicilio);
        agregarCampo(panelCentral, gbc, fila++, "Email:", txtEmail);

        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(btnGuardar, gbc);

        add(panelCentral, BorderLayout.CENTER);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String sexo = (String) comboSexo.getSelectedItem();
            String domicilio = txtDomicilio.getText();
            String email = txtEmail.getText();

            if (nombre.isEmpty() || telefono.isEmpty() || domicilio.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            Paciente p = new Paciente(nombre, telefono, sexo, domicilio, email);
            PacienteControlador controlador = new PacienteControlador();
            controlador.agregarPaciente(p);

            JOptionPane.showMessageDialog(this, "Paciente registrado con éxito:\n" + nombre);
            dispose();
        });
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, JComponent campo) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(campo, gbc);
    }
}
