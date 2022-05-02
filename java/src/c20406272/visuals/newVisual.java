package c20406272.visuals;

//import com.jogamp.newt.Screen;

import ie.tudublin.*;
//import processing.core.PApplet;

//import java.text.FieldPosition;


public class newVisual extends Visual 
{
    AudioBandsVisual abv;
    boolean titleScreen = true;
    boolean pauseplay = false;
    ///////////////////////////////


    public void settings()
    {
        size(800, 800);
        //fullScreen(P3D, SPAN);
        smooth();
        //size(800, 800);
        
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
            pauseplay = false;
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

        if (key == 'p' && titleScreen == true)
        {
            pauseplay = false;
        }
    }

    public void startMenu()
    {
        //          TITLE
        textSize(width/15);
        textAlign(CENTER, CENTER);

        //Shadow
        fill(0,0,0,70);
        text("Press Space to begin song", width/2+width/205, height/5+height/205);
        //Text
        fill(0);
        text("Press Space to begin song" , width/2, height/5);

        //          CONTROLS
        textSize(width/20);

        //Shadow
        fill(0,0,0,70);
        text("-Press P to pause/play", width/2+width/205, height/2+height/205);
        //Text
        fill(0);
        text("-Press P to pause/play", width/2, height/2);
    }

    public void pauseMenu()
    {
        //          TITLE
        textSize(width/15);
        textAlign(CENTER, CENTER);

        //Shadow
        fill(0,0,0,70);
        text("Press Space to restart song", width/2+width/205, height/5+height/205);
        //Text
        fill(0);
        text("Press Space to restart song" , width/2, height/5);

        //          CONTROLS
        textSize(width/20);

        //Shadow
        fill(0,0,0,70);
        text("-Press P to continue", width/2+width/205, height/2+height/205);
        //Text
        fill(0);
        text("-Press P to continue", width/2, height/2);
    }

    public void getMenu()
    {
        background(255);

        if (key == ' ')
        {
            textSize(0);
            titleScreen = false;
        }
        else
        {
            if (titleScreen == true)
            {
                startMenu();
            }
        }

        if (pauseplay == true)
        {
            pauseMenu();
        }
    }

    public void draw()
    {
        getMenu();

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
        //calculateAverageAmplitude();

        abv.render();
    }
}
