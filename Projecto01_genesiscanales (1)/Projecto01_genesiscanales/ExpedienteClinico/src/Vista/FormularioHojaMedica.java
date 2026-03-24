package Vista;

import Controlador.PacienteControlador;
import Modelo.Doctor;
import Modelo.HojaMedica;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioHojaMedica extends JFrame {
    private JComboBox<String> comboDoctores;
    private JDateChooser dateChooser;
    private JComboBox<String> comboHora, comboMinutos;
    private JTextField txtMotivo, txtDiagnostico, txtTratamiento;
    private JButton btnGuardar;

    public FormularioHojaMedica() {
        setTitle("Hoja Médica");
        setSize(550, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Establecer icono en la barra del formulario
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/hojamedica.png"));
        setIconImage(icon.getImage());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        comboDoctores = new JComboBox<>();
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        comboHora = new JComboBox<>();
        comboMinutos = new JComboBox<>();
        for (int h = 0; h < 24; h++) {
            comboHora.addItem(String.format("%02d", h));
        }
        for (int m = 0; m < 60; m += 5) {
            comboMinutos.addItem(String.format("%02d", m));
        }

        txtMotivo = new JTextField(20);
        txtDiagnostico = new JTextField(20);
        txtTratamiento = new JTextField(20);
        btnGuardar = new JButton("Guardar");

        // Cargar doctores al combo
        for (Doctor d : PacienteControlador.doctores) {
            comboDoctores.addItem(d.getNombre());
        }

        // Agregar etiquetas y componentes al formulario usando GridBagLayout

        // Fila 0 - Doctor
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Doctor:"), gbc);
        gbc.gridx = 1;
        add(comboDoctores, gbc);

        // Fila 1 - Fecha
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Fecha:"), gbc);
        gbc.gridx = 1;
        add(dateChooser, gbc);

        // Fila 2 - Hora (panel con hora y minutos)
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Hora:"), gbc);
        gbc.gridx = 1;
        JPanel panelHora = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelHora.add(comboHora);
        panelHora.add(new JLabel(":"));
        panelHora.add(comboMinutos);
        add(panelHora, gbc);

        // Fila 3 - Motivo
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Motivo:"), gbc);
        gbc.gridx = 1;
        add(txtMotivo, gbc);

        // Fila 4 - Diagnóstico
        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Diagnóstico:"), gbc);
        gbc.gridx = 1;
        add(txtDiagnostico, gbc);

        // Fila 5 - Tratamiento
        gbc.gridx = 0; gbc.gridy = 5;
        add(new JLabel("Tratamiento:"), gbc);
        gbc.gridx = 1;
        add(txtTratamiento, gbc);

        // Fila 6 - Botón guardar centrado
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnGuardar, gbc);

        // Acción para guardar la hoja médica
        btnGuardar.addActionListener(e -> {
            Date fecha = dateChooser.getDate();
            String hora = (String) comboHora.getSelectedItem();
            String minutos = (String) comboMinutos.getSelectedItem();

            // Validar campos obligatorios
            if (comboDoctores.getSelectedIndex() == -1 || fecha == null ||
                    txtMotivo.getText().isEmpty() || txtDiagnostico.getText().isEmpty() ||
                    txtTratamiento.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaTexto = sdf.format(fecha) + " " + hora + ":" + minutos;

            Doctor doctor = PacienteControlador.doctores.get(comboDoctores.getSelectedIndex());

            HojaMedica hoja = new HojaMedica(
                    fechaTexto,
                    hora + ":" + minutos,
                    txtMotivo.getText(),
                    txtDiagnostico.getText(),
                    txtTratamiento.getText(),
                    doctor
            );

            PacienteControlador controlador = new PacienteControlador();
            controlador.agregarHojaMedica(hoja);

            JOptionPane.showMessageDialog(this, "Hoja médica registrada.");
            dispose();
        });
    }
}
