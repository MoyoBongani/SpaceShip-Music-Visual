package c20309081;

import ie.tudublin.*;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import example.*;

public class testVisual extends Visual{
    
    WaveForm wf;
    AudioBandsVisual abv;
    
    public void settings()
    {
        size(1024, 500);
        
    }

    public void setup()
    {
        startMinim();
                
        loadAudio("mula.mp3");   
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }
 
    float theta;   

    public void draw() {
        background(0);
        frameRate(30);
        stroke(255);
        // Let's pick an angle 0 to 90 degrees based on the mouse position
        float a = (mouseX / (float) width) * 90f;
        // Convert it to radians
        theta = radians(a);
        // Start the tree from the bottom of the screen
        translate(width/2,height);
        // Draw a line 120 pixels
        line(0,0,0,-120);
        // Move to the end of that line
        translate(0,-120);
        // Start the recursive branching!
        branch(120);

        }

        void branch(float h) {
            h *= 0.66;

            if (h > 2) {
            pushMatrix();    // Save the current state of transformation (i.e. where are we now)
            rotate(theta);   // Rotate by theta
            line(0, 0, 0, -h);  // Draw the branch
            translate(0, -h); // Move to the end of the branch
            branch(h);       // Ok, now call myself to draw two new branches!!
            popMatrix();     // Whenever we get back here, we "pop" in order to restore the previous matrix state

            // Repeat the same thing, only branch off to the "left" this time!
            pushMatrix();
            rotate(-theta);
            line(0, 0, 0, -h);
            translate(0, -h);
            branch(h);
            popMatrix();
        }
    }


}
