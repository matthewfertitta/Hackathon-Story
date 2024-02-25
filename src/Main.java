import java.io.IOException;

public class Main {

    public static int StoryCount;
    public static boolean atBottom;
    public static int ySpeed = 0;

    public static void main(String[] args) throws InterruptedException, IOException {
        GUI mainButton = new GUI();

        StoryCount = 0;

        while(true)
        {
            GUI.panel.updateUI();

            switch (StoryCount) {
                case 1 -> {
                    GUI.supressClicks = true;
                    mainButton.setButtonLabel(">:(");
                    Thread.sleep(2000);
                    StoryCount++;
                }
                case 2 -> {
                    mainButton.setButtonLabel(":l");
                    GUI.supressClicks = false;
                    StoryCount++;
                }
                case 4 -> {
                    GUI.supressClicks = true;
                    mainButton.setButtonLabel(">:(");
                    mainButton.setLabel("You're really pushing my buttons!");
                    Thread.sleep(1000);
                    GUI.supressClicks = false;
                    StoryCount++;
                }
                case 9 -> mainButton.setButtonLabel(">:l");
                case 10 -> {
                    GUI.supressClicks = true;
                    mainButton.setLabel("Look bud.");
                    Thread.sleep(1000);
                    mainButton.setLabel("I'm not gonna be playing these games with you.");
                    Thread.sleep(4000);
                    mainButton.setLabel("If you keep this up you'll end up breaking something.");
                    Thread.sleep(4000);
                    mainButton.setButtonLabel(":l");
                    GUI.supressClicks = false;
                    mainButton.setLabel("");
                    StoryCount++;
                }
                case 12 -> {

                    fallToBottom(mainButton);
                    GUI2 broken = new GUI2();
                    Thread.sleep(1000);
                    StoryCount++;
                }
                case 13 -> {
                    GUI.supressClicks = true;
                    mainButton.setButtonLabel(">:l");
                    Thread.sleep(1000);
                    mainButton.setLabel("Alright dude what the flip.");
                    StoryCount++;
                }
                case 15 -> {
                    mainButton.setButtonLabel(":o");
                    mainButton.setLabel("Wait dont touch that!");
                    Thread.sleep(3000);
                    mainButton.setButtonLabel(">:O");
                    mainButton.setLabel("stop!");
                    Thread.sleep(3000);
                    GUI2.closeWindow();
                    mainButton.setButtonLabel(">:(");
                    mainButton.setLabel("hey man");
                    Thread.sleep(1000);
                    mainButton.setLabel("you shouldn't mess with other people's stuff!");
                    Thread.sleep(4000);
                    mainButton.mitosis();
                    mainButton.setButtonLabel(":o");
                    mainButton.setLabel("...");
                    GUI mitosisedButton = new GUI(GUI.wWidth + mainButton.getX(), mainButton.getY());
                    Thread.sleep(500);
                    mitosisedButton.setLabel("yeah you tell them!");
                    Thread.sleep(2000);
                    mainButton.setButtonLabel(":)");
                    Thread.sleep(1000);
                    mainButton.setLabel("thanks dawg.");
                    Thread.sleep(2000);
                    mainButton.setButtonLabel(":l");
                    mainButton.setLabel("");
                    mitosisedButton.closeWindow();
                    GUI.supressClicks = false;
                    StoryCount++;
                }
                case 17 -> {
                    GUI.supressClicks = true;
                    mainButton.setButtonLabel(":|");
                    mainButton.setLabel("seriously?");
                    BouncingGUI2 bouncy = new BouncingGUI2();
                    Thread.sleep(1000);
                    mainButton.setLabel("haven't you learned your lesson?");
                    Thread.sleep(5000);
                    mainButton.setLabel("welp if you can't control yourself then I'll be on my way.");
                    Thread.sleep(5000);
                    mainButton.setLabel("Goodbye.");
                    System.exit(0);
                }
                case 9999 -> {
                    System.out.println();
                }
            }
        }
    }

    public static void fallToBottom(GUI mainButton) throws InterruptedException {
        ySpeed = 0;
        do {
            int lowerYpos = mainButton.getY() + mainButton.getHeight();
            if (lowerYpos >= GUI.SCREEN_HEIGHT) {
                mainButton.setLocation(mainButton.getX(), GUI.SCREEN_HEIGHT - mainButton.getHeight());
                ySpeed = 0;
                atBottom = true;
                Thread.sleep(10);
            } else {
                atBottom = false;
                if (ySpeed <= 30) {
                    ySpeed++;
                }
                mainButton.setLocation(mainButton.getX(), mainButton.getY() + ySpeed);
                Thread.sleep(10);
            }
        } while (!atBottom);
    }

}
