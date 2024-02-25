import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// I probably shoud've fixed the GUI class so I could make another instance but I got lazy :l
public class GUI2 extends JFrame implements ActionListener {

    static JButton button;
    static JPanel panel;
    GridBagConstraints gbc;
    public static final int wWidth = 256;
    public static final int wHeight = 256;

    public int evasionCount;
    public static boolean keepEvading = true;

    public static boolean clickAttempt = false;

    final String[] weirdNames = {
            "sÎyÎ¹ûâå³ç�æð«‹\u0004\u0006\u001C$%\u00061$\u0090¹§\u001E¨‡ÅpË",
            "®i¸XÀ¢ƒ«\u0012KvYÇ\u000F\t\u0017pÚVj\u001AÛÛ5‰ëð¨ã\n",
            "VüGä", "¤…Y²^\u001F€9Ì“Ïa\u0081ÈúÍ\u0011!,ò“¯pêOÈõh)¯(Ô{\u0018=Ú|ÆØ",
            "Ý9ÃHlBIÕ\u009Dw½qE#²þè¼8¿\u001D\u007FØ@.Æ\u0090!\u001D\u001F gÿ˜\u001Fý»Y\u008D‰_œ",
            "ƒîù#¼wœú©",
            "Ü\u001Cc/þ¯R¥½‡¾"
    };

    public GUI2() throws InterruptedException, IOException {
        // frame init
        //BufferedImage img = ImageIO.read(new File("src\\Mr. Button.png"));
        //this.setIconImage(img);
        this.setTitle(weirdNames[(int)(Math.random() * (weirdNames.length))]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(wWidth, wHeight);
        this.setLocation(1664, -256);
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        // makes the panel with the grid manager
        panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.add(panel);

        // inits the boundaries for the buttons so that they're not touching together if they're next to one another
        gbc.insets = new Insets(5, 5, 5, 5);

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
        button = new JButton("!");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(this);
        button.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button, gbc);

        this.setVisible(true);
        panel.updateUI();

        // mouse evader
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!clickAttempt)
                {
                    clickAttempt = true;
                    Main.StoryCount++;
                }
                if (evasionCount < 10)
                {
                    GUI2 gui = (GUI2) SwingUtilities.getWindowAncestor(button);
                    int x = (int) (Math.random() * (GUI.SCREEN_WIDTH));
                    int y = (int) (Math.random() * (GUI.SCREEN_HEIGHT));

                    if (x + gui.getX() > GUI.SCREEN_WIDTH) {
                        x -= wWidth;
                    }
                    if (y + gui.getY() > GUI.SCREEN_HEIGHT) {
                        y -= wHeight;
                    }
                    gui.setLocation(x, y);

                    if (!keepEvading)
                    {
                        evasionCount++;
                    }
                }
            }
        });

        fallOut();
    }

    public GUI2(int xPos, int yPos) throws InterruptedException, IOException {
        // frame init
        //BufferedImage img = ImageIO.read(new File("src\\Mr. Button.png"));
        //this.setIconImage(img);
        this.setTitle(weirdNames[(int)(Math.random() * (weirdNames.length))]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(wWidth, wHeight);
        this.setLocation(xPos, yPos);
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        // makes the panel with the grid manager
        panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.add(panel);

        // inits the boundaries for the buttons so that they're not touching together if they're next to one another
        gbc.insets = new Insets(5, 5, 5, 5);

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
        button = new JButton("!");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(this);
        button.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button, gbc);

        this.setVisible(true);
        panel.updateUI();

        // mouse evader
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!clickAttempt)
                {
                    clickAttempt = true;
                    Main.StoryCount++;
                }
                if (evasionCount < 10)
                {
                    GUI2 gui = (GUI2) SwingUtilities.getWindowAncestor(button);
                    int x = (int) (Math.random() * (GUI.SCREEN_WIDTH));
                    int y = (int) (Math.random() * (GUI.SCREEN_HEIGHT));

                    if (x + gui.getX() > GUI.SCREEN_WIDTH) {
                        x -= wWidth;
                    }
                    if (y + gui.getY() > GUI.SCREEN_HEIGHT) {
                        y -= wHeight;
                    }
                    gui.setLocation(x, y);

                    if (!keepEvading)
                    {
                        evasionCount++;
                    }
                }
            }
        });
    }

    // fall from top of screen
    public void fallOut() throws InterruptedException {
        int ySpeed = 0;
        int lowerYpos;
        do {
            lowerYpos = this.getY() + this.getHeight();
            if (lowerYpos >= wWidth) {
                this.setLocation(this.getX(), 256 - this.getHeight());
                ySpeed = 0;
                Thread.sleep(10);
            } else {
                if (ySpeed <= 30) {
                    ySpeed++;
                }
                this.setLocation(this.getX(), this.getY() + ySpeed);
                Thread.sleep(10);
            }
        } while (lowerYpos <= wHeight);

        int shake = 8;
        int delay = 30;
        for (int x = 0; x < 10; x++)
        {
            shake *= -1;
            this.setLocation(this.getX() + shake, this.getY());
            Thread.sleep(delay);
            if (x % 2 == 1)
            {
                shake--;
                delay += 10;
            }
        }
        this.setLocation(1664, 0);
    }

    public static void closeWindow()
    {
        GUI2 gui = (GUI2) SwingUtilities.getWindowAncestor(button);
        int xSpeed = 0;
        while (gui.getX() < GUI.SCREEN_WIDTH)
        {
            gui.setLocation(gui.getX() + xSpeed, gui.getY());
            xSpeed += 1;
        }
        gui.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button)
        {
            if (!GUI.supressClicks) {
                this.dispose();
            }
        }
    }
}
