package c20406272.visuals;

import processing.core.PApplet;
import processing.core.PConstants;
import ie.tudublin.*;
//import java.lang.Math;

public class City extends Visual{
    Mula mula;
    float theta = 0;
    
    public City(Mula mula)
    {
        this.mula = mula;
    }

    public void render()
    {
        //setting
        mula.colorMode(RGB);
        mula.background(20, 20, 80);
        mula.stroke(200,200,800);
        
        //code for moon
        mula.stroke(Mula.map(255,0,mula.getSmoothedBands()[1]*3,0,255),0,Mula.map(255,0,mula.getSmoothedBands()[1]*7,255,0));
        mula.fill(162, 172, 177);
        mula.smooth();
        mula.circle(mula.width-mula.width/10f, mula.height/10.0f, mula.width/4f);

        //code for buildings
        mula.rect(mula.width/2.5f,mula.height/2.0f,mula.width/9.0f,mula.height/2.0f+mula.getSmoothedBands()[5]*2f);
        mula.fill(200);
        mula.rect(mula.width/2.4f,mula.height/1.15f,mula.width/35f, mula.height/21.0f);
        mula.rect(mula.width/2.15f,mula.height/1.15f,mula.width/35f, mula.height/21.0f);
        mula.rect(mula.width/2.4f,mula.height/1.3f,mula.width/35f, mula.height/21.0f);
        mula.rect(mula.width/2.15f,mula.height/1.3f,mula.width/35f, mula.height/21.0f);
        mula.rect(mula.width/2.4f,mula.height/1.52f,mula.width/35f, mula.height/21.0f);
        mula.rect(mula.width/2.15f,mula.height/1.52f,mula.width/35f, mula.height/21.0f);
        mula.rect(mula.width/2.4f,mula.height/1.8f,mula.width/35f, mula.height/21.0f);
        mula.rect(mula.width/2.15f,mula.height/1.8f,mula.width/35f, mula.height/21.0f);
        
        mula.fill(130,85,85);
        mula.rect(mula.width/1.5f,mula.height/1.6f,mula.width/7.0f,mula.height/2.0f);
        mula.fill(200);
        mula.rect(mula.width/1.33f,mula.height/1.4f,mula.width/30f, mula.height/25.0f);
        mula.rect(mula.width/1.45f,mula.height/1.4f,mula.width/30f, mula.height/25.0f);
        mula.rect(mula.width/1.33f,mula.height/1.15f,mula.width/30f, mula.height/25.0f);
        mula.rect(mula.width/1.45f,mula.height/1.15f,mula.width/30f, mula.height/25.0f);

        mula.fill(110,130,85);
        mula.rect(mula.width/12f,mula.height/1.25f,mula.width/4.0f,mula.height/2.0f);
        mula.fill(255);
        mula.rect(mula.width/4f,mula.height/1.17f,mula.width/25f, mula.height/25.0f);
        mula.rect(mula.width/8f,mula.height/1.17f,mula.width/25f, mula.height/25.0f);
    } 
}
