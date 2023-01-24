# Music Visualiser Project
Name: Bongani Moyo
Student Number: C20309081
Name: Nelson Ude
Student Number: C20479276
Name: David Davita
Student Number: C20406272

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
In this assignment we have 2 visualisations using java processing, We all helped each other for the visuals and different aspects of the coding and also the thought process of each idea and how we layed it out. Our visuals respond to the amplitude of the music and the user is given options on what they want to do presented by a menu at the start of the program run and it changes colours, shapes etc.

# Instructions
Run main.java file in C20406272

# How it works
Each visualisation has its own java file and class which is all connected to the main class called mula (our song choice), we used the method calclatingAverageAmplitude from the isual class along with getSmoothedBands for some visuals and went from there.

each visualisation has the method called render which allows it to run

```
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
```

*** Visual One ***
Hallway Visual is a pathway for the apceship to fly through


# What I am most proud of in the assignment
We are mostly proud of how well our team worked regardless of how different our skills in coding were and also how well the visuals turned out especially the hallway visual,

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

