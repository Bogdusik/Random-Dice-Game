import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RollingDiceGui extends JFrame {

    private static final int ROLL_TIME_MS = 3000;
    private static final String RESOURCE_PATH = "resources/";

    public RollingDiceGui() {
        super("Rolling Double Dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 700));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);


        addGuiComponents();
    }

    private void addGuiComponents(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        // 1. Banner
        JLabel bannerImg = ImgService.loadImage(RESOURCE_PATH + "banner.png");
        bannerImg.setBounds(45,25,600,100);
        jPanel.add(bannerImg);

        // 2. Dice images
        JLabel diceOneImg = ImgService.loadImage(RESOURCE_PATH + "dice1.png");
        diceOneImg.setBounds(100, 200,200, 200);
        jPanel.add(diceOneImg);

        JLabel diceTwoImg = ImgService.loadImage(RESOURCE_PATH + "dice2.png");
        diceTwoImg.setBounds(390, 200,200, 200);
        jPanel.add(diceTwoImg);

        //3. Roll Button
        Random rand = new Random();
        JButton rollButton = new JButton("Roll");
        rollButton.setBounds(250,550, 200, 50);
        rollButton.addActionListener(e -> {
            rollButton.setEnabled(false);

            long startTime = System.currentTimeMillis();
            Thread rollThread = new Thread(() -> {
                try {
                    while (System.currentTimeMillis() - startTime < ROLL_TIME_MS) {
                        int diceOne = rand.nextInt(6) + 1;
                        int diceTwo = rand.nextInt(6) + 1;

                        ImgService.updateImage(diceOneImg, RESOURCE_PATH + "dice" + diceOne + ".png");
                        ImgService.updateImage(diceTwoImg, RESOURCE_PATH + "dice" + diceTwo + ".png");

                        repaint();
                        revalidate();

                        Thread.sleep(60);
                    }
                } catch (InterruptedException ex) {
                    System.err.println("Threading Error: " + ex.getMessage());
                    Thread.currentThread().interrupt();
                } finally {
                    rollButton.setEnabled(true);
                }
            });

            rollThread.start();
        });
        jPanel.add(rollButton);

        this.getContentPane().add(jPanel);
    }
}
