package c20406272.visuals;

//import processing.core.*;
import java.lang.Math;

public class Hallway {
    newVisual nv;

    float add;
    float ballZ;

    public Hallway(newVisual nv)
    {
        this.nv = nv; 
    }

    public void render()
    {
        add = add + nv.getSmoothedBands()[0] * 0.2f;
        float hallSize = nv.height/2.0f + nv.height/5.0f;
        //ballZ = -hallSize/4.3f - 10f;
        //boolean locked = false;

        //rectangle fog
        nv.fill(nv.lightToDark);
        nv.noStroke();
        //nv.pushMatrix();
        //nv.translate(nv.width/2, nv.height/2, -100000);
        //nv.box(1600);
        //nv.popMatrix();

        //hallway
        nv.noFill();
        nv.stroke(nv.map(255,0,nv.getSmoothedBands()[0]*3,0,255),0,nv.map(255,0,nv.getSmoothedBands()[0]*7,255,0));

        for(int i = -1500; i <= 15; i++)
        {

            nv.pushMatrix();
            nv.translate(nv.width/2, nv.height/2, i * hallSize + add);
            nv.box(hallSize);
            nv.popMatrix();

        }

        //particles
        

        /*
        for(int i = -1500; i <= 15; i++)
        {

            nv.pushMatrix();
            nv.translate(nv.width/2, nv.height/2, i * hallSize + add);
            nv.popMatrix();
        }
        */

        /////////////////////ROCKET SHIP/////////////////////////////

        nv.stroke(255);

        //body
        nv.fill(75);
        
        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -hallSize/10);
        nv.box(Math.round(hallSize/20), Math.round(hallSize/20), hallSize/10);
        nv.popMatrix();

        //middle 1
        nv.fill(100);

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -hallSize/6);
        nv.box(Math.round(hallSize/28));
        nv.popMatrix();

        //middle 2
        nv.fill(125);

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, Math.round(-hallSize/5));
        nv.box(Math.round(hallSize/34));
        nv.popMatrix();

        //nose
        nv.fill(200,0,0);

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -hallSize/4.3f);
        nv.box(Math.round(hallSize/50));
        nv.popMatrix();

        //right wing
        nv.fill(255,0,0);

        nv.pushMatrix();
        nv.translate(nv.mouseX + Math.round(hallSize/20), nv.mouseY, -hallSize/10);
        nv.box(Math.round(hallSize/20),Math.round(hallSize/60),Math.round(hallSize/20));
        nv.popMatrix();

        //left wing
        nv.fill(200,0,0);

        nv.pushMatrix();
        nv.translate(nv.mouseX - Math.round(hallSize/20), nv.mouseY, -hallSize/10);
        nv.box(Math.round(hallSize/20),Math.round(hallSize/60),Math.round(hallSize/20));
        nv.popMatrix();

        //tail
        nv.fill(125);
        
        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -hallSize/25);
        nv.rotateZ(nv.radians(45));
        nv.box(Math.round(hallSize/40), Math.round(hallSize/40), hallSize/70);
        nv.popMatrix();

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -hallSize/25);
        nv.box(Math.round(hallSize/40), Math.round(hallSize/40), hallSize/70);
        nv.popMatrix();

        nv.fill(255);
        nv.noStroke();
        
                
        
    }
}
