
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.math.*;

public class Oval extends BoundedShape 
{
	private boolean full;
	private double Area;

	public Oval(int x1,int y1,int R,Color color, boolean full)
	{		
		super(x1,y1,R,color);
		this.full=full;
	}
	
	public void setFull(boolean full){
		this.full=full;
	}
		
	public boolean getFull(){
		return full;
	}
	
	public double Area(){
		return Area;	
	}
	
	@Override
	public void draw(Graphics g){
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(getColor());
		g2D.setStroke(new BasicStroke(4F));
		g2D.drawOval(getX1(), getY1(), getX2(), getY2());		
		
		if (full==false)
		{}
		else
		{
		g2D.fillOval(getX1(), getY1(), getX2(), getY2());	
		}
	}
	
		
	
	public double area(){
		return Area=Math.PI*getX2()*getY2();
	}

	
	
}
