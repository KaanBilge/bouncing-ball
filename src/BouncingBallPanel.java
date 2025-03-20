import java.awt.*;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BouncingBallPanel extends JPanel{
    private float enclosingRadius;
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private long nanosecondsElapsed;
    private int noOfFrames;
    private JLabel fpsLabel;

    public BouncingBallPanel() {
        super();
        Ball ball1 = new Ball(Color.BLUE, 30);
        balls.add(ball1);
        enclosingRadius = 120.00f;
        this.setPreferredSize(new Dimension((int) enclosingRadius*2, (int) enclosingRadius*2));
        setBackground (Color.black);
        nanosecondsElapsed = System.nanoTime();

        noOfFrames = 0;
        fpsLabel = new JLabel();
        this.add(fpsLabel);
    }

    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        //divide by 10^9 to get seconds
        float dt =  ((float)(System.nanoTime()-nanosecondsElapsed))/1000000;
        int i=0;
        for (Ball ball : balls) { //not implemented yet, for multiple balls
            ball.move(dt);
            checkBorderCollision(ball);
            //for (int j = i+1; j<balls.size(); j++) {
            //    checkBallsCollision(ball, balls.get(j));
            //}
            page.setColor(ball.color);
            page.fillOval((int) (ball.x + enclosingRadius - ball.radius), (int) (ball.y + enclosingRadius - ball.radius), (int) (2*ball.radius), (int) (2*ball.radius));
            i++;
        }
        
        nanosecondsElapsed = System.nanoTime();

        page.setColor(Color.RED);
        page.drawOval(0,0,(int) enclosingRadius*2, (int) enclosingRadius*2);
        noOfFrames += 1;
    }

    private void checkBorderCollision(Ball ball) {
        if (ball.x*ball.x + ball.y*ball.y >= (enclosingRadius-ball.radius)*(enclosingRadius-ball.radius)) {
            ball.bounce((float) Math.atan2(ball.y, ball.x));
        }
    }

    private void checkBallsCollision(Ball ball1, Ball ball2) {
        //to be implemented
    }

    public void displayFPS() {
        fpsLabel.setText("fps: " + noOfFrames);
        noOfFrames = 0;
    }
}
