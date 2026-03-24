package Vista;

import Controlador.PacienteControlador;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Persona;
import Modelo.Vacuna;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioVacuna extends JFrame {

    private JDateChooser dateChooser;
    private JComboBox<String> comboHora, comboMinutos;
    private JTextField txtNombreVacuna;
    private JComboBox<String> comboAplicadoPor;
    private JButton btnGuardar;

    public FormularioVacuna() {
        setTitle("Control de Vacunas");
        // Ícono de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/images/vacuna.png")).getImage());
        setSize(500, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        comboHora = new JComboBox<>();
        comboMinutos = new JComboBox<>();
        for (int h = 0; h < 24; h++) comboHora.addItem(String.format("%02d", h));
        for (int m = 0; m < 60; m += 5) comboMinutos.addItem(String.format("%02d", m));

        txtNombreVacuna = new JTextField(20);
        comboAplicadoPor = new JComboBox<>();
        btnGuardar = new JButton("Guardar");

        for (Doctor d : PacienteControlador.doctores)
            comboAplicadoPor.addItem("Doctor: " + d.getNombre());
        for (Enfermero e : PacienteControlador.enfermeros)
            comboAplicadoPor.addItem("Enfermero: " + e.getNombre());

        int fila = 0;
        agregarCampo(panelCentral, gbc, fila++, "Fecha:", dateChooser);

        JPanel panelHora = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelHora.add(comboHora);
        panelHora.add(new JLabel(":"));
        panelHora.add(comboMinutos);
        agregarCampo(panelCentral, gbc, fila++, "Hora:", panelHora);

        agregarCampo(panelCentral, gbc, fila++, "Nombre de la vacuna:", txtNombreVacuna);
        agregarCampo(panelCentral, gbc, fila++, "Aplicada por:", comboAplicadoPor);

        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(btnGuardar, gbc);

        add(panelCentral, BorderLayout.CENTER);

        btnGuardar.addActionListener(e -> {
            Date fecha = dateChooser.getDate();
            String hora = (String) comboHora.getSelectedItem();
            String minutos = (String) comboMinutos.getSelectedItem();
            String nombreVacuna = txtNombreVacuna.getText();

            if (fecha == null || nombreVacuna.isEmpty() || comboAplicadoPor.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaTexto = sdf.format(fecha) + " " + hora + ":" + minutos;

            Persona aplicador;
            int index = comboAplicadoPor.getSelectedIndex();
            if (index < PacienteControlador.doctores.size()) {
                aplicador = PacienteControlador.doctores.get(index);
            } else {
                aplicador = PacienteControlador.enfermeros.get(index - PacienteControlador.doctores.size());
            }

            Vacuna vacuna = new Vacuna(fechaTexto, nombreVacuna, aplicador);
            PacienteControlador controlador = new PacienteControlador();
            controlador.agregarVacuna(vacuna);

            JOptionPane.showMessageDialog(this, "Vacuna registrada.");
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
