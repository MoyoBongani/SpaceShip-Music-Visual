package example;

import ie.tudublin.*;

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

    float radius = 200;

    float smoothedBoxSize = 5;

    float rot = 0;

    public void draw()
    {
        background(255);

        if (key == ' ' || key == 'p')
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

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();
        background(255);
        //noFill();
        fill(255, 0, 0);
        stroke(255);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, -500, 500, 0, 0, 0, 0, 1, 0);
        //translate(0, 0, -250);

        rot += getAmplitude() / 8.0f;

        rotateY(rot);
        float[] bands = getSmoothedBands();
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float theta = map(i, 0, bands.length, 0, TWO_PI);

            stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            float x = sin(theta) * radius;
            float z = cos(theta) * radius;
            float h = bands[i];
            pushMatrix();
            translate(x, - h / 2 , z);
            rotateY(theta);
            box(50, h, 50);
            popMatrix();
        }

    }
    float angle = 0;

}
