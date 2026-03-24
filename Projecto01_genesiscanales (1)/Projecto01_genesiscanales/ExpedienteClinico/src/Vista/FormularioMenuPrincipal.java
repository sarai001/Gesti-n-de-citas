package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormularioMenuPrincipal extends JFrame {

    public FormularioMenuPrincipal() {
        setTitle("Clínica Vida Sana | Menú Principal");

        // Icono (puedes cambiar por otro más neutral tipo logo médico)
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/logo.png"));
        setIconImage(icon.getImage());

        setSize(600, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Colores estilo moderno
        Color fondo = new Color(245, 245, 245);
        Color azulPrincipal = new Color(30, 70, 140);
        Color grisHover = new Color(50, 50, 50);
        Color grisBoton = new Color(220, 220, 220);
        Color rojoSuave = new Color(200, 60, 60);

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 28);
        Font fuenteSubtitulo = new Font("Segoe UI", Font.PLAIN, 16);
        Font fuenteBoton = new Font("Segoe UI", Font.BOLD, 18);
        Font fuenteFooter = new Font("Segoe UI", Font.ITALIC, 12);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(fondo);

        // Encabezado
        JPanel encabezado = new JPanel(new GridLayout(2, 1));
        encabezado.setBackground(fondo);

        JLabel lblTitulo = new JLabel("Clínica Vida Feliz", SwingConstants.CENTER);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(azulPrincipal);

        JLabel lblSubtitulo = new JLabel("Bienvenido", SwingConstants.CENTER);
        lblSubtitulo.setFont(fuenteSubtitulo);
        lblSubtitulo.setForeground(Color.DARK_GRAY);
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        encabezado.add(lblTitulo);
        encabezado.add(lblSubtitulo);

        panelPrincipal.add(encabezado, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(fondo);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));

        panelBotones.add(crearBoton("Registrar Paciente", () -> new Vista.FormularioPaciente().setVisible(true), fuenteBoton, grisBoton, azulPrincipal));
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(crearBoton("Registrar Doctor", () -> new Vista.FormularioDoctor().setVisible(true), fuenteBoton, grisBoton, azulPrincipal));
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(crearBoton("Registrar Enfermero", () -> new Vista.FormularioEnfermero().setVisible(true), fuenteBoton, grisBoton, azulPrincipal));
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(crearBoton("Registrar Cita", () -> new Vista.FormularioCita().setVisible(true), fuenteBoton, grisBoton, azulPrincipal));
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(crearBoton("Vacunas", () -> new Vista.FormularioVacuna().setVisible(true), fuenteBoton, grisBoton, azulPrincipal));
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(crearBoton("Hoja Médica", () -> new Vista.FormularioHojaMedica().setVisible(true), fuenteBoton, grisBoton, azulPrincipal));
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(crearBoton("Hoja de Enfermería", () -> new Vista.FormularioHojaEnfermeria().setVisible(true), fuenteBoton, grisBoton, azulPrincipal));
        panelBotones.add(Box.createRigidArea(new Dimension(0, 25)));
        panelBotones.add(crearBoton("Salir", () -> System.exit(0), fuenteBoton, new Color(240, 200, 200), rojoSuave));

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Footer
        JLabel lblFooter = new JLabel("© 2025 Clínica Vida Feliz By Gene", SwingConstants.CENTER);
        lblFooter.setFont(fuenteFooter);
        lblFooter.setForeground(Color.GRAY);
        lblFooter.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        panelPrincipal.add(lblFooter, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }

    private JButton crearBoton(String texto, Runnable accion, Font fuente, Color colorNormal, Color colorHover) {
        JButton boton = new JButton(texto);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        boton.setFont(fuente);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBackground(colorNormal);
        boton.setForeground(Color.BLACK);
        boton.setBorder(BorderFactory.createLineBorder(colorNormal.darker(), 1));
        boton.setOpaque(true);

        boton.addActionListener(e -> accion.run());

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorHover);
                boton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorNormal);
                boton.setForeground(Color.BLACK);
            }
        });

        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioMenuPrincipal().setVisible(true));
    }
}
