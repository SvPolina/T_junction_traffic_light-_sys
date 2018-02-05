import java.awt.Color;
import java.awt.Graphics;

public abstract class BoundedShape extends Shape{
	
public	BoundedShape(int x1,int y1,int R,Color color){
	super(x1,y1,R,color);
}
	public abstract double area();

}
