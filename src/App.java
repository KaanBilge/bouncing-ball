import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setTitle("BouncingBall");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(500, 520));

        BouncingBallPanel mainPanel = new BouncingBallPanel();
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);

        for (int i=0; i<25; i++) {
            mainPanel.addBall(new ColorBall(7, 10*i-100, 10*i-100));
        }

        //mainPanel.addBall(new Ball(Color.WHITE, 20, -40, 10));
        
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
