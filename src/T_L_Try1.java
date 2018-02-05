
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
//Class that makes the four configurations of the 4 traffic lights

public class T_L_Try1 extends JPanel

{	private int x1;
	private int y1;
	
	public static T_Light1 first;
	public static T_Flash Second;
	public static T_Light1 first2;
	public static T_Flash Second2;
	public static T_Light1 first3;
	public static T_Flash Second3;
	public static T_Light1 first4;
	public static T_Flash Second4;
	
	//two arrays constructing the horizontal_right	t.light
	public static ArrayList<Shape> H_R = new ArrayList<Shape>();//	
	public static ArrayList<Shape> H_R_F = new ArrayList<Shape>();//flashing pedestrian
	
	//two arrays constructing the horizontal_left	t.light
	public static ArrayList<Shape> H_L= new ArrayList<Shape>();	
	public static ArrayList<Shape> H_L_F = new ArrayList<Shape>();//flashing pedestrian
	
	//two arrays constructing the vertical top	t.light
	public static ArrayList<Shape> V_T = new ArrayList<Shape>();	
	public static ArrayList<Shape> V_T_F = new ArrayList<Shape>();//flashing pedestrian
	
	//two arrays constructing the vertical bottom	t.light
	public static ArrayList<Shape> V_B = new ArrayList<Shape>();	
	public static ArrayList<Shape> V_B_F = new ArrayList<Shape>();//flashing pedestrian
	
	//constructor that initializes the the location of the four t.lights and the 8 array lists.
	T_L_Try1(int x1, int y1,int D,boolean H)
	{
	setBackground(Color.WHITE);	
	this.x1=x1;
	this.y1=y1;		
		
	first=new T_Light1( x1,y1,D,H);
  	Second=new T_Flash( x1,y1,D, H);
  	
  	first2=new T_Light1( x1-300,y1,D,H);
  	Second2=new T_Flash( x1-300,y1,D, H);
  	
  	first3=new T_Light1( x1-150,y1-150,D,!H);
  	Second3=new T_Flash( x1-150,y1-150,D, !H);
  	
  	first4=new T_Light1( x1-150,y1+150,D,!H);
  	Second4=new T_Flash( x1-150,y1+150,D, !H);
  	
//t.light horizontal right 	
  	H_R =first.ShapeArray;
  	H_R_F =Second.ShapeArray;
//t.light horizontal left  	
  	H_L =first2.ShapeArray;
  	H_L_F =Second2.ShapeArray;  
//t.light vertical top   	
  	V_T =first3.ShapeArray;
  	V_T_F =Second3.ShapeArray;  
//t.light vertical bottom  	
  	V_B =first4.ShapeArray;
  	V_B_F =Second4.ShapeArray; 	  	
	}
	
	public void paintComponent(Graphics g)
	{   
		super.paintComponent(g);
		
		for(Shape sh:H_R)  
		{sh.draw(g); }	
		
		for(Shape sh:H_R_F)  
		{sh.draw(g); }	
		
		for(Shape sh1:H_L)  
		{sh1.draw(g); }	
		
		for(Shape sh2:H_L_F)  
		{sh2.draw(g); }	
		
		for(Shape sh1:V_T)  
		{sh1.draw(g); }	
		
		for(Shape sh2:V_T_F)  
		{sh2.draw(g); }	
		
		for(Shape sh1:V_B)  
		{sh1.draw(g); }	
		
		for(Shape sh2:V_B_F)  
		{sh2.draw(g); }			
	}
	
//horizontal lights			
	public static void SetL1(boolean T) 
	{  
		((Oval)H_R.get(0)).setFull(T);
		((Oval)H_R.get(1)).setFull(!T);
		((Rectangle)H_R.get(2)).setFull(T);
		
		((Oval)H_L.get(3)).setFull(T);
		((Oval)H_L.get(4)).setFull(!T);
		((Rectangle)H_L.get(5)).setFull(T);	
	}	
	
	
	public static void SetL2(boolean T)
	{	
		((Rectangle)H_R_F.get(0)).setFull(T);	
		((Rectangle)H_L_F.get(1)).setFull(T);
	}
	
	
 //vertical lights	
	public static void SetL3(boolean T) 
	{		
		((Oval)H_R.get(6)).setFull(!T);
		((Oval)H_R.get(7)).setFull(T);
		((Rectangle)H_R.get(8)).setFull(!T);
		
		((Oval)H_L.get(9)).setFull(!T);
		((Oval)H_L.get(10)).setFull(T);
		((Rectangle)H_L.get(11)).setFull(!T);	
	}	
	
	
	public static void SetL4(boolean T)
	{			
		((Rectangle)H_R_F.get(2)).setFull(T);	
		((Rectangle)H_L_F.get(3)).setFull(T);			
	}


}
