
import javax.swing.*;
import java.awt.*;

public class SwingEnvironment extends JFrame {

    private final Color BG_DARK = new Color(24, 24, 27);

    public SwingEnvironment() {

        setTitle("Scientific Calculator");
        setSize(440, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_DARK);

        JLabel label = new JLabel("Java Swing Environment Configured");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        add(label, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(() -> new SwingEnvironment());
    }
}