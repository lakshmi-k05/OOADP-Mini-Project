package Paint;
import java.awt.Graphics;

public abstract class ShapeColor {
	String color;
	ShapeColor(String s)
	{
		color = s;
	}
	abstract void lineColor(Graphics g);
	abstract void colorPolygon(Graphics g, int x[], int y[], int n);
	abstract void colorCircle(Graphics g, int x, int y, int w, int h);
}
	