package c20406272.visuals;

import processing.core.*;
import java.lang.Math;

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
        float hallSize = nv.height/2.0f + nv.height/5.0f;

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

        //rocket
        nv.fill(255,127,0);
        nv.stroke(255);
        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -100);
        nv.box(Math.round(hallSize/20), Math.round(hallSize/20), Math.round(hallSize/10));
        nv.popMatrix();

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -175);
        nv.box(Math.round(hallSize/28));
        nv.popMatrix();

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -200);
        nv.box(Math.round(hallSize/34));
        nv.popMatrix();

        nv.pushMatrix();
        nv.translate(nv.mouseX, nv.mouseY, -175);
        nv.box(Math.round(hallSize/40));
        nv.popMatrix();
    }
}
