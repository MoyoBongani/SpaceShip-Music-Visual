package c20406272.visuals;

import com.jogamp.newt.Screen;

import ie.tudublin.*;

public class newVisual extends Visual 
{
    AudioBandsVisual abv;
    boolean titleScreen = true;
    
    ///////////////////////////////


    public void settings()
    {
        smooth();
        //size(800, 800);
        
        fullScreen(P3D, SPAN);

    }

    public void setup()
    {        
        startMinim();

        loadAudio("mula.mp3");  
        
        abv = new AudioBandsVisual(this);

        //textFont(createFont("SourceCodePro-Regular.ttf", 36));
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        
    }

    public void draw()
    {
        background(255);

        ///////////////////////////////
        ///////////////

        if (key == ' ')
        {
            textSize(0);
            titleScreen = false;
        }
        else
        {
            if(titleScreen == true)
            {
                //          TITLE
                textSize(width/15);
                textAlign(CENTER, CENTER);

                //Shadow
                fill(0,0,0,70);
                text("Press Space to begin", width/2+width/205, height/5+height/205);
                //Text
                fill(0);
                text("Press Space to begin" , width/2, height/5);

                //          CONTROLS
                textSize(width/20);

                //Shadow
                fill(0,0,0,70);
                text("-Press P to pause/play", width/2+width/205, height/2+height/205);
                //Text
                fill(0);
                text("-Press P to pause/play", width/2, height/2);
                


                
            }
        }

        ///////////////
        ///////////////////////////////
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        abv.render();
    }
}
