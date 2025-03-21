import java.awt.Color;
import java.util.Random;

public class ColorBall extends Ball{
    Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    Random rand = new Random();
    ColorBall(float radius, float startingX, float startingY) {
        super(Color.GRAY, radius, startingX, startingY);
    }

    @Override
    void bounce(float direction) {//fix this function
        //collides and bounces with an object at the angle of "direction" (right is 0, down is pi/2, ...)
        float vx2 = (float) (-vx*Math.cos(2*direction) - vy*Math.sin(2*direction));
        float vy2 = (float) (-vx*Math.sin(2*direction) + vy*Math.cos(2*direction));
        vx=vx2;
        vy=vy2;
        x-=0.00002f*x;//these values should keep them from getting stuck in the border
        y-=0.00002f*y;//but this is bad practise because depends on the fps of the app
        this.color = colors[rand.nextInt(0,colors.length)];
    }
}
