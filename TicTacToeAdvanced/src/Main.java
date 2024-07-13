import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static boolean xTurn = true;
    private static Queue<JButton> xButtons = new ArrayDeque<>();
    private static Queue<JButton> oButtons = new ArrayDeque<>();
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 3));
        JButton[][] buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = createButton();
                buttons[i][j] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (button.getText().equals("")) {
                            if (xTurn) {
                                button.setText("X");
                                xButtons.add(button);
                                if (xButtons.size() > 3) {
                                    JButton oldestX = xButtons.poll();
                                    oldestX.setText("");
                                }
                            } else {
                                button.setText("O");
                                oButtons.add(button);
                                if (oButtons.size() > 3) {
                                    JButton oldestO = oButtons.poll();
                                    oldestO.setText("");
                                }
                            }
                            xTurn = !xTurn;
                            checkWinner(buttons);
                        }
                    }
                });
                panel.add(button);
            }
        }

        frame.add(panel);
        frame.setSize(400, 400);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width / 2 - frame.getSize().width / 2,
                screenSize.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    private static JButton createButton() {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }
                g.fillRect(0, 0, getWidth(), getHeight());

                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, getBackground().brighter(), 0, getHeight(), getBackground().darker()));
                g2d.fillRect(0, 0, getWidth(), getHeight());

                super.paintComponent(g);
            }
        };

        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.setBackground(new Color(60, 60, 60)); // Matte black
        button.setForeground(Color.WHITE); // Set initial text color to white
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        return button;
    }

    private static void checkWinner(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if (checkLine(buttons[i][0], buttons[i][1], buttons[i][2]) ||
                    checkLine(buttons[0][i], buttons[1][i], buttons[2][i])) {
                return;
            }
        }
        if (checkLine(buttons[0][0], buttons[1][1], buttons[2][2]) ||
                checkLine(buttons[0][2], buttons[1][1], buttons[2][0])) {
            return;
        }
    }

    private static boolean checkLine(JButton b1, JButton b2, JButton b3) {
        if (!b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())) {
            JOptionPane optionPane = new JOptionPane("Winner is " + b1.getText(), JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog("Game Over");
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    frame.dispose();
                }
            });
            dialog.setVisible(true);
            return true;
        }
        return false;
    }
}
