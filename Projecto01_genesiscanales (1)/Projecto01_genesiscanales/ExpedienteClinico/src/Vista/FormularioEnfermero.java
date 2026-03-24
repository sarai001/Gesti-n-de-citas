package Vista;

import Modelo.Enfermero;
import Controlador.PacienteControlador;

import javax.swing.*;
import java.awt.*;

public class FormularioEnfermero extends JFrame {

    private JTextField txtNombre, txtTelefono, txtDomicilio, txtEmail;
    private JComboBox<String> comboSexo;
    private JButton btnGuardar;

    public FormularioEnfermero() {
        setTitle("Registrar Enfermero");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Agregar icono en la barra del formulario
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/enfermero.png"));
        setIconImage(icon.getImage());

        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // Inicialización de campos y combo para sexo
        txtNombre = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtDomicilio = new JTextField(20);
        txtEmail = new JTextField(20);
        comboSexo = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});
        btnGuardar = new JButton("Guardar");

        // Añadir campos con etiquetas
        int fila = 0;
        agregarCampo(panelCentral, gbc, fila++, "Nombre:", txtNombre);
        agregarCampo(panelCentral, gbc, fila++, "Teléfono:", txtTelefono);
        agregarCampo(panelCentral, gbc, fila++, "Sexo:", comboSexo);
        agregarCampo(panelCentral, gbc, fila++, "Domicilio:", txtDomicilio);
        agregarCampo(panelCentral, gbc, fila++, "Email:", txtEmail);

        // Botón guardar centrado
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(btnGuardar, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // Acción botón guardar con validación de campos
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

            Enfermero enfermero = new Enfermero(nombre, telefono, sexo, domicilio, email);
            PacienteControlador controlador = new PacienteControlador();
            controlador.agregarEnfermero(enfermero);

            JOptionPane.showMessageDialog(this, "Enfermero registrado:\n" + nombre);
            dispose();
        });
    }

    // Método auxiliar para añadir campos con su etiqueta correspondiente
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
