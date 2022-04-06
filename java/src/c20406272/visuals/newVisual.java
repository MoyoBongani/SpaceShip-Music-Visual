package c20406272.visuals;

import ie.tudublin.*;

public class newVisual extends Visual 
{
    AudioBandsVisual abv;
    boolean titleScreen = true;
    
    ///////////////////////////////


    public void settings()
    {
        //size(1024, 500);
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
                textSize(displayWidth/20);

                //Shadow
                fill(0,0,0,70);
                text("Press Space to begin", displayWidth/4+5, displayHeight/3+5);
                //Text
                fill(0);
                text("Press Space to begin", displayWidth/4, displayHeight/3);

                //          CONTROLS
                textSize(displayWidth/30);

                //Shadow
                fill(0,0,0,70);
                text("-Press P to pause/play", displayWidth/6+5, displayHeight/2+5);
                //Text
                fill(0);
                text("-Press P to pause/play", displayWidth/6, displayHeight/2);
                


                
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
