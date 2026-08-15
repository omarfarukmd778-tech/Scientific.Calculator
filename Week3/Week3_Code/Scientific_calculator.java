import javax.swing.*;
import java.awt.*;

public class Scientific_calculator extends JFrame {

    public Scientific_calculator() {

        setTitle("Scientific Calculator");
        setSize(440, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Scientific Calculator");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        add(title, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(() -> new Scientific_calculator());
    }
}