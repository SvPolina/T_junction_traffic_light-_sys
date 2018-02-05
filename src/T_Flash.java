import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.Timer;

//class creating and initializing the rectangle of the 
//green light for pedestrians (bottom rectangle for each t.light)
public class T_Flash 
{
	private static final boolean True = false;
	public static ArrayList<Shape> ShapeArray = new ArrayList<Shape>();	
	
	private int X_right;
	private int Y_right;
	private int R_light;
	private int Dist;
	private boolean T;
	
	public  Shape shape;
	
	public  T_Flash(int x_right,int y_right,int r_light,boolean traf)
	{
	this.X_right=x_right;
	this.Y_right=y_right;
	this.R_light=r_light;
	this.T=traf;	

	shape=new Rectangle( x_right,y_right+3*R_light+11,r_light,Color.GREEN ,!T);		
	ShapeArray.add(shape);		
	}
		
}

