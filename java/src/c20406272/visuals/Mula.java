package c20406272.visuals;

import ie.tudublin.*;

public class Mula extends Visual 
{
    Hallway hw;
    City ct;
    AudioBandsVisual abv;

    boolean titleScreen = true;
    float lightToDark = 255;

    int drawMode = 1;    
    boolean pause = true;
    ///////////////////////////////


    public void settings()
    {
        //size(800, 800);
        smooth();
        fullScreen(P3D, 1);
    }

    public void setup()
    {        
        startMinim();

        loadAudio("mula.mp3");  

        hw = new Hallway(this);
        ct = new City(this);
        abv = new AudioBandsVisual(this);

        //textFont(createFont("SourceCodePro-Regular.ttf", 36));
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            if(pause)
            {
                getAudioPlayer().play();
            
                titleScreen = false;
                pause = false;
            }
            else
            {
                getAudioPlayer().pause();
                pause = true;

                
            }
        }

        if(key == 'r')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

            titleScreen = true;
            pause = true;
        }

        switch(key)
        {
            case '1':
            {
                drawMode = 1;
                break;
            }
            case '2':
            {
                drawMode = 2;
                break;
            }
            case '3':
            {
                drawMode = 3;
                break;
            }
            default:
            {

                break;
            }
        }
    }

    public void menu()
    {
        background(255);

        drawTarget(width/50, height/40, width/4, 10);
        drawTarget(width/20, height+height/10, width/2, 15);
        drawTarget(width-width/10, height/15, width/15, 8);
        drawTarget(width, height/40, width/6, 5);
        drawTarget(width+width/10, height-height/10, width/2, 20);
        

        //          TITLE
        textSize(width/15);
        textAlign(CENTER, CENTER);

        //Shadow
        fill(0,0,0,70);
        text("Press space to begin song", width/2+width/205, height/5+height/205);
        //Text
        fill(0);
        text("Press space to begin song" , width/2, height/5);

        //          CONTROLS
        textSize(width/25);

        //Shadow
        fill(0,0,0,70);
        text("Use 1,2,3 to change scenes", width/2+width/205, height/2+height/205);
        //Text
        fill(0);
        text("Use 1,2,3 to change scenes", width/2, height/2);

        //Shadow
        fill(0,0,0,70);
        text("Use r to restart song", width/2+width/205, height/2+height/10+height/205);
        //Text
        fill(0);
        text("Use r to restart song", width/2, height/2+height/10);

        
        
    }

    void drawTarget(float xloc, float yloc, int size, int num) 
    {
        float grayvalues = 255/num;
        float steps = size/num;

        for (int i = 0; i < num; i++) 
        {
            noStroke();
            fill(0,127-i*grayvalues*0.7f,255-i*grayvalues*0.7f);
            ellipse(xloc, yloc, size - i*steps, size - i*steps);
        }
    }

    public void playVisuals()
    {
        if(lightToDark > 0)
        {
            background(255);
            lightToDark = lightToDark - 2f;
            background(lightToDark);
        }
        else if(lightToDark < 0)
        {
            background(0);
        }
        

        if(pause)
        {
            fill(255);
            textSize(width/5);
            text("PAUSED", width/2, height/2);
        }

        textSize(0);
        
        try
        {
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        
        calculateFrequencyBands();

        switch(drawMode)
        {
            case 1:
            {
                fill(255);
                noStroke();
                textSize(width/90);
                textAlign(CENTER, CENTER);
                text("Move mouse to move ship. Hold mouse click to shoot.",width/6,height/22);
                
                colorMode(RGB);
                hw.render();

                break;
            }
            case 2:
            {
                abv.render();
                
                break;
            }
            case 3:
            {
                colorMode(HSB);
                ct.render();

                break;
            }
        }
    }

    public void draw()
    {
        

        if(titleScreen == false)
        {
            
            playVisuals();
        }
        else
        {
            menu();
            
        }
    }

    public void circleMode(int center) {
    }
}