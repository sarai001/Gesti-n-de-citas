package Vista;

import Controlador.PacienteControlador;
import Modelo.Cita;
import Modelo.Doctor;
import Modelo.Paciente;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioCita extends JFrame {
    private JComboBox<String> comboPacientes;
    private JComboBox<String> comboDoctores;
    private JDateChooser dateChooser;
    private JComboBox<String> comboHora;
    private JComboBox<String> comboMinutos;
    private JButton btnGuardar;

    public FormularioCita() {
        setTitle("Registrar Cita");
        setSize(500, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Establece el icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/cita.png"));
        setIconImage(icon.getImage());

        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        comboPacientes = new JComboBox<>();
        comboDoctores = new JComboBox<>();
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        // Llena combos de hora y minutos
        comboHora = new JComboBox<>();
        comboMinutos = new JComboBox<>();
        for (int h = 0; h < 24; h++) {
            comboHora.addItem(String.format("%02d", h));
        }
        for (int m = 0; m < 60; m += 5) {
            comboMinutos.addItem(String.format("%02d", m));
        }

        btnGuardar = new JButton("Guardar");

        // Carga pacientes y doctores en los combos
        for (Paciente p : PacienteControlador.pacientes)
            comboPacientes.addItem(p.getNombre());

        for (Doctor d : PacienteControlador.doctores)
            comboDoctores.addItem(d.getNombre());

        // Agrega los campos al panel con etiquetas
        int fila = 0;
        agregarCampo(panelCentral, gbc, fila++, "Paciente:", comboPacientes);
        agregarCampo(panelCentral, gbc, fila++, "Doctor:", comboDoctores);
        agregarCampo(panelCentral, gbc, fila++, "Fecha:", dateChooser);

        // Panel especial para seleccionar hora:minutos
        JPanel panelHora = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelHora.add(comboHora);
        panelHora.add(new JLabel(":"));
        panelHora.add(comboMinutos);
        agregarCampo(panelCentral, gbc, fila++, "Hora:", panelHora);

        // Botón Guardar centrado y con ancho para las dos columnas
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(btnGuardar, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // Acción botón guardar
        btnGuardar.addActionListener(e -> {
            int indexP = comboPacientes.getSelectedIndex();
            int indexD = comboDoctores.getSelectedIndex();
            Date fecha = dateChooser.getDate();

            // Validación simple de campos
            if (indexP == -1 || indexD == -1 || fecha == null) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            // Formatea la fecha y hora seleccionadas
            String hora = comboHora.getSelectedItem().toString() + ":" + comboMinutos.getSelectedItem().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Crea la cita y la registra en el controlador
            Paciente paciente = PacienteControlador.pacientes.get(indexP);
            Doctor doctor = PacienteControlador.doctores.get(indexD);
            Cita cita = new Cita(paciente, doctor, sdf.format(fecha), hora);

            PacienteControlador controlador = new PacienteControlador();
            controlador.agregarCita(cita);

            JOptionPane.showMessageDialog(this, "Cita registrada.");
            dispose();
        });
    }

    // Método auxiliar para agregar etiquetas y campos al GridBagLayout
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
