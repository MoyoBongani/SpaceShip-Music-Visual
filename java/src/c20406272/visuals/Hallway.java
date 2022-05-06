package c20406272.visuals;

import processing.core.PApplet;

public class Hallway {
    Mula mula;

    float add; 
    float bulletZ;
    
    

    boolean mouseClicked = false;
    int bulletTime = 0;

    public Hallway(Mula mula)
    {
        this.mula = mula; 
    }

    public void drawHallway(float hallSize)
    {
        
        for(int i = -1500; i <= 15; i++)
        {
            mula.pushMatrix();
            mula.translate(mula.width/2, mula.height/2, i * hallSize + add);
            mula.box(hallSize);
            mula.popMatrix();
        }
    }

    public void drawBars(float hallSize)
    {
        for(int i = -1500; i <= 15; i++)
        {
            mula.fill(PApplet.map(255,0,mula.getSmoothedBands()[0]*4,255,0),PApplet.map(255,0,mula.getSmoothedBands()[0]*4,255,0),0);
            mula.stroke(0);

            if(i % 2 == 0)
            {
                mula.pushMatrix();
                mula.translate(mula.width/2-hallSize/4, mula.height/2+hallSize/12, i * hallSize + add);
                mula.rotateZ(PApplet.radians(-25));
                mula.box(hallSize/50,hallSize/2,hallSize/50);
                mula.popMatrix();
    
                mula.pushMatrix();
                mula.translate(mula.width/2+hallSize/4, mula.height/2+hallSize/12, i * hallSize + add);
                mula.rotateZ(PApplet.radians(25));
                mula.box(hallSize/50,hallSize/2,hallSize/50);
                mula.popMatrix();
            }
            else
            {
                mula.pushMatrix();
                mula.translate(mula.width/2-hallSize/4, mula.height/2-hallSize/12, i * hallSize + add);
                mula.rotateZ(PApplet.radians(25));
                mula.box(hallSize/50,hallSize/2,hallSize/50);
                mula.popMatrix();
    
                mula.pushMatrix();
                mula.translate(mula.width/2+hallSize/4, mula.height/2-hallSize/12, i * hallSize + add);
                mula.rotateZ(PApplet.radians(-25));
                mula.box(hallSize/50,hallSize/2,hallSize/50);
                mula.popMatrix();
            }

        }
    }

    public void drawCubes(float hallSize)
    {
        mula.noFill();
        mula.stroke(PApplet.map(255,0,mula.getSmoothedBands()[0]*3,0,255),0,PApplet.map(255,0,mula.getSmoothedBands()[0]*7,255,0));

        mula.pushMatrix();
        mula.translate(mula.width/2, mula.height/2, -5000);
        mula.rotateX(add*0.001f);
        mula.rotateY(-add*0.001f);
        mula.rotateZ(add*0.001f);
        mula.box(hallSize/6);
        mula.popMatrix();

        mula.fill(255);

        mula.pushMatrix();
        mula.translate(mula.width/2, mula.height/2, -5000);
        mula.rotateX(add*0.001f);
        mula.rotateY(-add*0.001f);
        mula.rotateZ(add*0.001f);
        mula.box(hallSize/15);
        mula.popMatrix();
    }

    public void drawBullets(float hallSize)
    {
        if(!mula.mousePressed)
        {
            //mula.stroke(0,0,0);
            bulletZ = 0;
            bulletZ = bulletZ + 1f;
        }

        if(mula.mousePressed)
        {
            mula.pushMatrix();
            mula.stroke(255);
            mula.translate(0,0,-bulletZ*400);
            mula.line(mula.mouseX,mula.mouseY, -hallSize/24,mula.mouseX,mula.mouseY,-hallSize/2);
            mula.popMatrix();
        }
    }

    public void drawRocketShip(float hallSize)
    {
        mula.stroke(0);

        //body
        mula.fill(75);
        
        mula.pushMatrix();
        mula.translate(mula.mouseX, mula.mouseY, -hallSize/10);
        mula.box(hallSize/20,hallSize/20,hallSize/10);
        mula.popMatrix();

        //middle 1
        mula.fill(100);

        mula.pushMatrix();
        mula.translate(mula.mouseX, mula.mouseY, -hallSize/6);
        mula.box(hallSize/28);
        mula.popMatrix();

        //middle 2
        mula.fill(125);

        mula.pushMatrix();
        mula.translate(mula.mouseX, mula.mouseY, -hallSize/5);
        mula.box(hallSize/34);
        mula.popMatrix();

        //nose
        mula.fill(200,0,0);

        mula.pushMatrix();
        mula.translate(mula.mouseX, mula.mouseY, -hallSize/4.3f);
        mula.box(hallSize/50);
        mula.popMatrix();

        //right wing
        mula.fill(255,0,0);

        mula.pushMatrix();
        mula.translate(mula.mouseX + hallSize/20, mula.mouseY, -hallSize/10);
        mula.box(hallSize/20,hallSize/60,hallSize/20);
        mula.popMatrix();

        //left wing
        mula.fill(200,0,0);

        mula.pushMatrix();
        mula.translate(mula.mouseX -hallSize/20, mula.mouseY, -hallSize/10);
        mula.box(hallSize/20,hallSize/60,hallSize/20);
        mula.popMatrix();

        //tail
        mula.fill(125);
        
        mula.pushMatrix();
        mula.translate(mula.mouseX, mula.mouseY, -hallSize/25);
        mula.rotateZ(PApplet.radians(45));
        mula.box(hallSize/40,hallSize/40, hallSize/70);
        mula.popMatrix();

        mula.pushMatrix();
        mula.translate(mula.mouseX, mula.mouseY, -hallSize/25);
        mula.box(hallSize/40,hallSize/40, hallSize/70);
        mula.popMatrix();

        
        /////////////////////////////FIRE////////////////////////
        if(mula.frameCount % 3 == 0)
        {
            mula.fill(255,0,0);
            mula.noStroke();

            mula.pushMatrix();
            mula.translate(mula.mouseX, mula.mouseY, 0);
            mula.box(hallSize/60);
            mula.popMatrix();

            mula.pushMatrix();
            mula.translate(mula.mouseX, mula.mouseY, 0);
            mula.rotateZ(PApplet.radians(45));
            mula.box(hallSize/60);
            mula.popMatrix();

            mula.fill(255,127,0);

            mula.pushMatrix();
            mula.translate(mula.mouseX, mula.mouseY, hallSize/50);
            mula.box(hallSize/80);
            mula.popMatrix();

            mula.pushMatrix();
            mula.translate(mula.mouseX, mula.mouseY, hallSize/50);
            mula.rotateZ(PApplet.radians(45));
            mula.box(hallSize/80);
            mula.popMatrix();

            mula.fill(255,255,0);

            mula.pushMatrix();
            mula.translate(mula.mouseX, mula.mouseY, hallSize/30);
            mula.box(hallSize/110);
            mula.popMatrix();

            mula.pushMatrix();
            mula.translate(mula.mouseX, mula.mouseY, hallSize/30);
            mula.rotateZ(PApplet.radians(45));
            mula.box(hallSize/110);
            mula.popMatrix();
        }
    }

    public void render()
    {
        add = add + mula.getSmoothedBands()[0] * 0.3f;
        bulletZ = bulletZ + 1f;
        float hallSize = mula.height/2.0f + mula.height/5.0f;

        mula.noFill();
        mula.strokeWeight(2.2f);
        mula.stroke(PApplet.map(255,0,mula.getSmoothedBands()[0]*3,0,255),0,PApplet.map(255,0,mula.getSmoothedBands()[0]*7,255,0));

        ////////////////////////HALLWAY///////////////////////////////
        drawHallway(hallSize);

        ////////////////////////BARS//////////////////////////////
        drawBars(hallSize);

        //////////////////////////CUBES////////////////////////////
        drawCubes(hallSize);

        /////////////////////////BULLETS///////////////////////////////
        drawBullets(hallSize);

        /////////////////////ROCKET SHIP/////////////////////////////
        drawRocketShip(hallSize);
        
    }
}
