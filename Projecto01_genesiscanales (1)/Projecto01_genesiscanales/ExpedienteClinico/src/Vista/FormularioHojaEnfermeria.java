package Vista;

import Controlador.PacienteControlador;
import Modelo.Enfermero;
import Modelo.HojaEnfermeria;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioHojaEnfermeria extends JFrame {

    private JComboBox<String> comboEnfermeros;
    private JDateChooser dateChooser;
    private JComboBox<String> comboHora, comboMinutos;
    private JTextField txtSignos, txtObservaciones, txtEvolucion;
    private JButton btnGuardar;

    public FormularioHojaEnfermeria() {
        setTitle("Hoja de Enfermería");
        setSize(550, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Agregar icono en la barra del formulario
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/enfermeria.png"));
        setIconImage(icon.getImage());

        setLayout(new BorderLayout());

        // Panel principal con GridBagLayout para organizar componentes
        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Inicializar componentes
        comboEnfermeros = new JComboBox<>();
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

        txtSignos = new JTextField(20);
        txtObservaciones = new JTextField(20);
        txtEvolucion = new JTextField(20);
        btnGuardar = new JButton("Guardar");

        // Cargar nombres de enfermeros en el combo
        for (Enfermero e : PacienteControlador.enfermeros) {
            comboEnfermeros.addItem(e.getNombre());
        }

        // Añadir componentes al panel con etiquetas
        int fila = 0;
        agregarCampo(panelCentral, gbc, fila++, "Enfermero:", comboEnfermeros);
        agregarCampo(panelCentral, gbc, fila++, "Fecha:", dateChooser);

        // Panel para seleccionar hora y minutos juntos
        JPanel panelHora = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelHora.add(comboHora);
        panelHora.add(new JLabel(":"));
        panelHora.add(comboMinutos);
        agregarCampo(panelCentral, gbc, fila++, "Hora:", panelHora);

        agregarCampo(panelCentral, gbc, fila++, "Signos Vitales:", txtSignos);
        agregarCampo(panelCentral, gbc, fila++, "Observaciones:", txtObservaciones);
        agregarCampo(panelCentral, gbc, fila++, "Evolución:", txtEvolucion);

        // Botón guardar centrado
        gbc.gridx = 1;
        gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(btnGuardar, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // Acción para guardar la hoja de enfermería
        btnGuardar.addActionListener(e -> {
            Date fecha = dateChooser.getDate();
            String hora = (String) comboHora.getSelectedItem();
            String minutos = (String) comboMinutos.getSelectedItem();

            // Validar que no haya campos vacíos
            if (comboEnfermeros.getSelectedIndex() == -1 ||
                    fecha == null ||
                    txtSignos.getText().isEmpty() ||
                    txtObservaciones.getText().isEmpty() ||
                    txtEvolucion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            // Formatear fecha y hora
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaTexto = sdf.format(fecha) + " " + hora + ":" + minutos;

            Enfermero enf = PacienteControlador.enfermeros.get(comboEnfermeros.getSelectedIndex());

            // Crear objeto HojaEnfermeria con datos del formulario
            HojaEnfermeria hoja = new HojaEnfermeria(
                    fechaTexto,
                    hora + ":" + minutos,
                    txtSignos.getText(),
                    txtObservaciones.getText(),
                    txtEvolucion.getText(),
                    enf
            );

            PacienteControlador controlador = new PacienteControlador();
            controlador.agregarHojaEnfermeria(hoja);

            JOptionPane.showMessageDialog(this, "Hoja de enfermería registrada.");
            dispose();
        });
    }

    // Método auxiliar para agregar etiqueta y campo al panel
    private void agregarCampo(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, JComponent campo) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        gbc.gridy = fila;
        panel.add(campo, gbc);
    }
}
