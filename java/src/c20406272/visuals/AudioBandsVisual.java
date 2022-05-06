package c20406272.visuals;

import processing.core.*;

// This is an example of a visual that uses the audio bands
public class AudioBandsVisual
{
    Mula mula;
    float rotZ = 0;

    public AudioBandsVisual(Mula mula)
    {
        this.mula = mula; 
    }

    public void render()
    {
        float gap = mula.width / (float) mula.getBands().length;

        mula.stroke(255,0,0);

        rotZ += 0.5f;

        for(int i = 0 ; i < mula.getBands().length ; i ++)
        {
            mula.fill(PApplet.map(i, 0, mula.getBands().length, 255, 0), 255, 255);
            //mula.rect(i * gap, mula.height, gap,-mula.getSmoothedBands()[i] * 0.2f); 

            mula.pushMatrix();
            mula.rotateY(mula.radians(45));
            mula.rotateX(mula.radians(45));
            
            mula.translate(mula.width/6+i * gap,mula.height/2,0);
            mula.rotateX(mula.radians(rotZ));
            mula.rotateY(mula.radians(45));
            mula.box(gap,mula.getSmoothedBands()[i] * 0.2f,mula.height/10);
            mula.popMatrix();
        }
    }
}