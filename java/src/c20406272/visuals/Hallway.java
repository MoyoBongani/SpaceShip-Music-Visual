package c20406272.visuals;

import processing.core.*;

public class Hallway {
    newVisual nv;

    float add;

    public Hallway(newVisual nv)
    {
        this.nv = nv; 
    }

    public void render()
    {
        add = add + nv.getSmoothedBands()[0] * 0.2f;

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

        for(int i = -1500; i <= 10; i++)
        {

            nv.pushMatrix();
            nv.translate(nv.width/2, nv.height/2, i * 1000 + add);
            nv.box(1000);
            nv.popMatrix();

        }

        //ship
        nv.fill(255,127,0);
        nv.stroke(255);
        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -100);
        nv.box(50, 50, 100);
        nv.popMatrix();

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -175);
        nv.box(35, 35, 35);
        nv.popMatrix();

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -200);
        nv.box(30, 30, 30);
        nv.popMatrix();

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -175);
        nv.box(25, 25, 25);
        nv.popMatrix();
    }
}
