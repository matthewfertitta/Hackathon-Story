import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    public static int StoryCount;

    JButton button;
    JPanel panel;
    GridBagConstraints gbc;

    public GUI() {
        // frame init
        this.setTitle("Hackathon Story");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(720, 720);
        this.setResizable(true);

        // makes the panel with the grid manager
        panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.add(panel);

        // inits the boundaries for the buttons so that they're not touching together if they're next to one another
        gbc.insets = new Insets(10, 10, 10, 10);

        // inits the main button
        button = new JButton("...");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(this);
        button.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(button, gbc);

        JLabel label = new JLabel("...");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label, gbc);

        this.setVisible(true);
        panel.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button)
        {
            StoryCount++;
            button.setText("");


            //try {
            //    ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("SPOILER_unknown.png")));
            //    JLabel imageLabel = new JLabel(image);
            //    gbc.gridx = 0;
            //    gbc.gridy = 2;
            //    panel.add(imageLabel, gbc);
            //    panel.updateUI();
            //} catch (Exception ex) {
            //    System.out.println("Image cannot be found");
            //}
        }
    }
}
