package example;

import ie.tudublin.*;

public class newVisual extends Visual 
{
    AudioBandsVisual abv;
    boolean titleScreen = true;
    boolean pauseplay = false;
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

        if (key == 'p')
        {
            if (pauseplay == false)
            { 
                getAudioPlayer().pause();
                pauseplay = true;
            }
            else
            {
                getAudioPlayer().play();
                pauseplay = false;
            }
        }
    }

    public void draw()
    {
        background(255);

        if (key == ' ')
        {
            textSize(0);
            titleScreen = false;
        }
        if (key == 'p')
        {
            textSize(0);
            titleScreen = false;
        }
        else
        {
            if(titleScreen == true)
            {
                background(255);
                textSize(displayWidth/20);
                fill(0,0,0);
                text("Press Space to begin", displayWidth/4+5, displayHeight/2+5);
                fill(255, 0, 0);
                text("Press Space to begin", displayWidth/4, displayHeight/2);
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

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();

        abv.render();
    }
}
