package ie.tudublin;

//testing branch 

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import ie.tudublin.Visual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public void test()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.test();			
	}
}