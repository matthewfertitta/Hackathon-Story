import java.io.IOException;

public class BouncingGUI2 {
    private int xSpeed;
    private int ySpeed;

    private int xPos;
    private int yPos;

    private int timer = 0;

    public BouncingGUI2() throws InterruptedException, IOException {
        xPos = (int)(Math.random() * (GUI.SCREEN_WIDTH));
        yPos = (int)(Math.random() * (GUI.SCREEN_HEIGHT));

        xSpeed = (int)(Math.random() * (5) + 1);
        ySpeed = (int)(Math.random() * (5) + 1);

        GUI2 bouncy = new GUI2(xPos, yPos);

        // make it so that it doesnt spawn off screen
        if (bouncy.getX() + GUI2.wWidth > GUI.SCREEN_WIDTH)
        {
            bouncy.setLocation(bouncy.getX() - GUI2.wWidth, bouncy.getY());
        }
        if (bouncy.getY() + GUI2.wHeight > GUI.SCREEN_HEIGHT)
        {
            bouncy.setLocation(bouncy.getX(), bouncy.getY() - GUI2.wHeight);
        }

        // move loop for bounce
        while (timer <= 1000)
        {
            if(bouncy.getX() < 0)
            {
                xSpeed *= -1;
            }
            if(bouncy.getX() + bouncy.getWidth() > GUI.SCREEN_WIDTH)
            {
                xSpeed *= -1;
            }
            if(bouncy.getY() < 0)
            {
                ySpeed *= -1;
            }
            if(bouncy.getY() + bouncy.getHeight() > GUI.SCREEN_HEIGHT)
            {
                ySpeed *= -1;
            }
            bouncy.setLocation(bouncy.getX() + xSpeed, bouncy.getY() + ySpeed);
            Thread.sleep(1);
            timer++;
        }
        bouncy.dispose();
    }
}