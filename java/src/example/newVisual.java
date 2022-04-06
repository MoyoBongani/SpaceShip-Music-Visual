package example;

import ie.tudublin.*;

public class newVisual extends Visual 
{
    AudioBandsVisual abv;

    ///////////////////////////////


    public void settings()
    {
        size(1024, 500);
        //fullScreen(P3D, SPAN);

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
            textMode(0);
        }
        
    }

    public void draw()
    {
        background(0);

        ///////////////////////////////

       // Draw the letter to the center of the screen
        textSize(36);
        text("Press Space to begin", 50, 120, 540, 300);

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
