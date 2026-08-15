import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderSection extends JFrame {

    private final Color BG_DARK = new Color(24, 24, 27);
    private final Color TEXT_MAIN = new Color(250, 250, 250);
    private final Color TEXT_MUTED = new Color(161, 161, 170);
    private final Color ACCENT_GREEN = new Color(34, 197, 94);

    public HeaderSection() {

        setTitle("Header Section");
        setSize(500, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(BG_DARK);
        setLayout(new BorderLayout());

        add(buildHeader(), BorderLayout.NORTH);

        setVisible(true);
    }

    private JPanel buildHeader() {

        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(BG_DARK);
        p.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel info = new JPanel(new BorderLayout());
        info.setBackground(BG_DARK);

        JLabel title = new JLabel("SCIENTIFIC CALCULATOR");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(TEXT_MAIN);

        JLabel sub = new JLabel(" Md Omor Faruk | 11240321755");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        sub.setForeground(TEXT_MUTED);

        info.add(title, BorderLayout.NORTH);
        info.add(sub, BorderLayout.SOUTH);

        JToggleButton powerBtn = new JToggleButton("ON");
        powerBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        powerBtn.setBackground(ACCENT_GREEN);
        powerBtn.setForeground(Color.WHITE);
        powerBtn.setFocusPainted(false);

        p.add(info, BorderLayout.CENTER);
        p.add(powerBtn, BorderLayout.EAST);

        return p;
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(() -> new HeaderSection());
    }
}