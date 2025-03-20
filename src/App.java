import java.awt.Dimension;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setTitle("BouncingBall");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(260, 280));

        BouncingBallPanel mainPanel = new BouncingBallPanel();
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);

        long nanosecondsElapsed = System.nanoTime();
        while (true) {
            mainPanel.repaint();
            if ((System.nanoTime()-nanosecondsElapsed) >= Math.pow(10, 9)) {
                mainPanel.displayFPS();
                nanosecondsElapsed = System.nanoTime();
            }
        }
    }
}
