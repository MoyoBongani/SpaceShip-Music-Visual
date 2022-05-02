package c20406272.visuals;

import ie.tudublin.*;
//import processing.core.PApplet;

//import java.text.FieldPosition;


public class newVisual extends Visual 
{
    AudioBandsVisual abv;
    boolean titleScreen = true;
    boolean pauseplay = false;

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

    public void menu()
    {
        String pressStart = "Press Space to begin";

        //          TITLE
        //textSize(displayWidth/pressStart.length()*1.5f);
        

        //Shadow
        //fill(0,0,0,70);
        //text("Press Space to begin/restart song", displayWidth/4+5, displayHeight/3+5);

        fill(0);
        //text(pressStart, displayWidth/pressStart.length()*4, displayHeight/pressStart.length());

        //Text
        //fill(0);
        //text("Press Space to begin/restart song", displayWidth/4, displayHeight/3);

        //          CONTROLS
        textSize(displayWidth/30);
        textAlign(CENTER, CENTER);

        //Shadow
        fill(0,0,0,70);
        text("-Press P to pause/play", displayWidth/6+5, displayHeight/2+5);
        //Text
        fill(0);
        text("-Press P to pause/play", displayWidth/6, displayHeight/2);
        
        //Shadow
        fill(0,0,0,70);
        text("THAT IS NOT HOW YOU SPELL BROCCOLI", displayWidth/6+5, displayHeight/1.5f+5);
        //Text
        fill(0);
        text("THAT IS NOT HOW YOU SPELL BROCCOLI", displayWidth/6, displayHeight/1.5f);
    }
    

    public void draw()
    {
        background(255);

        if(key == ' ' || key == 'p')
        {
            textSize(0);
            titleScreen = false;
        }
        else
        {
            if(titleScreen == true)
            {
                menu();
            }
        }

        if(pauseplay == true)
        {
            menu();
        }

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
        //calculateAverageAmplitude();

        abv.render();
    }
}
