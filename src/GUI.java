import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GUI extends JFrame implements ActionListener {

    JButton button;
    static JPanel panel;
    JLabel label;
    static boolean supressClicks;
    GridBagConstraints gbc;

    static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_WIDTH = (int) size.getWidth();
    public static final int SCREEN_HEIGHT = (int) size.getHeight();

    public static final int wWidth = 512;
    public static final int wHeight = 512;

    public GUI() throws IOException {
        // frame init
        BufferedImage img = ImageIO.read(new File("src\\Mr. Button.png"));
        this.setIconImage(img);
        this.setTitle("Mr. Button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(wWidth, wHeight);
        this.setLocation(695, 250);
        this.setResizable(false);

        // makes the panel with the grid manager
        panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.add(panel);

        // inits the boundaries for the buttons so that they're not touching together if they're next to one another
        gbc.insets = new Insets(20, 20, 20, 20);

        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                JLabel voidLabel = new JLabel();
                gbc.gridx = x;
                gbc.gridy = y;
                panel.add(voidLabel, gbc);
            }
        }

        // inits the main button
        button = new JButton(":l");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(this);
        button.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button, gbc);

        label = new JLabel("");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(label, gbc);

        this.setVisible(true);
        panel.updateUI();
    }

    public GUI(int x, int y) {
        // frame init
        this.setTitle("Mr. Button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(wWidth, wHeight);
        this.setLocation(x, y);
        this.setResizable(false);

        // makes the panel with the grid manager
        panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.add(panel);

        // inits the boundaries for the buttons so that they're not touching together if they're next to one another
        gbc.insets = new Insets(20, 20, 20, 20);

        for (int gridx = 0; gridx < 3; gridx++)
        {
            for (int gridy = 0; gridy < 3; gridy++)
            {
                JLabel voidLabel = new JLabel();
                gbc.gridx = gridx;
                gbc.gridy = gridy;
                panel.add(voidLabel, gbc);
            }
        }

        // inits the main button
        button = new JButton(":)");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(this);
        button.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button, gbc);

        label = new JLabel("");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(label, gbc);

        this.setVisible(true);
        panel.updateUI();
    }

    public void setLabel(String s)
    {
        label.setText(s);
    }

    public void setButtonLabel(String s)
    {
        button.setText(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button)
        {
            if (!supressClicks) {
                Main.StoryCount++;
            }
        }
    }

    public void mitosis() throws InterruptedException
    {
        GUI gui = (GUI) SwingUtilities.getWindowAncestor(button);
        int extendedWidth = wWidth;
        while(extendedWidth < wWidth * 2)
        {
            extendedWidth += 1;
            gui.setSize(extendedWidth, wHeight);
            Thread.sleep(5);
        }
        gui.setSize(wWidth, wHeight);
    }

    public void closeWindow()
    {
        GUI gui = (GUI) SwingUtilities.getWindowAncestor(button);
        gui.dispose();
    }
}
