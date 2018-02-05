
import java.awt.*;
public class Rectangle extends BoundedShape {

	private boolean full;
	private double Area;

	public Rectangle(int x1,int y1,int R,Color color, boolean full)
	{	super(x1,y1,R,color);
		this.full=full;
	}
	
	public void setFull(boolean full)
	{
		this.full=full;
	}
		
	public boolean getFull()
	{
		return full;
	}
	public double Area()
	{
		return Area;	
	}
	
	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;  
		g2D.setColor(this.getColor());	
		g2D.setStroke(new BasicStroke(4F));
		g2D.drawRect(getX1(), getY1(), getX2(), getX2());
		
		if (full==false)
		{}
		else
		{
			g2D.fillRect(getX1(), getY1(), getX2(), getY2());		
		}
	}
//Area calculation		
	public double area()
	{	
		return Area=getX2()*getY2();
	}
}
