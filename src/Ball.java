import java.awt.Color;

public class Ball {
    float x,y;
    float vx, vy;
    float ax, ay;
    float radius;
    Color color;

    Ball(Color color, float radius, float startingX, float startingY) {
        this.radius = radius;
        this.x = startingX; //the center of the screen is (0,0) for this x,y
        this.y = startingY;
        this.vx = 0;
        this.vy = 0;
        this.ax = 0;
        this.ay = Physics.gravity;
        this.color = color;
    }

    void move(float dt) {
        x += vx * dt;
        y += vy * dt;
        vx += ax * dt;
        vy += ay * dt;
    }

    void bounce(float direction) {//fix this function
        //collides and bounces with an object at the angle of "direction" (right is 0, down is pi/2, ...)
        float vx2 = (float) (-vx*Math.cos(2*direction) - vy*Math.sin(2*direction));
        float vy2 = (float) (-vx*Math.sin(2*direction) + vy*Math.cos(2*direction));
        vx=vx2;
        vy=vy2;
        x-=0.00002f*x;//these values should keep them from getting stuck in the border
        y-=0.00002f*y;//but this is bad practise because depends on the fps of the app
    }
}
