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

//class constructing the upper part of the each traffic light
//2 round lights for cars and one (red light) for pedestrians.
public class T_Light1 
{
	private static final boolean True = false;
	public static ArrayList<Shape> ShapeArray = new ArrayList<Shape>();	
	
	private int X_right;
	private int Y_right;
	private int R_light;
	private int Dist;
	private boolean T;
	
	public  Shape shape1;
	public  Shape shape2;
	public  Shape shape3;
	public  Shape shape4;
	
	public  T_Light1(int x_right,int y_right,int r_light,boolean traf)
	{	
	this.X_right=x_right;
	this.Y_right=y_right;
	this.R_light=r_light;
	this.T=traf;
	
	shape1=new Oval( x_right,y_right,r_light,Color.RED,!T);
	shape2=new Oval( x_right,y_right+R_light+4,r_light,Color.GREEN ,T);
	shape3=new Rectangle( x_right,y_right+2*R_light+9,r_light,Color.RED,T);
			
	ShapeArray.add(shape1);
	ShapeArray.add(shape2);
	ShapeArray.add(shape3);			
	}

	
}
