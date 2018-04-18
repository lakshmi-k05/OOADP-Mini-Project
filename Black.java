package Paint-Java.Paint;
import java.awt.Graphics;
import java.awt.Color;

public class Black extends ShapeColor{  
	Black(String s)
	{
		super(s);
	}
	void lineColor(Graphics g)
	{
		g.setColor(Color.black);
	}
	void colorPolygon(Graphics g, int x[], int y[], int n)
	{
		g.setColor(Color.black);
		g.fillPolygon(x, y, n);
		
	}
	void colorCircle(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.black);
		g.fillOval(x, y, width, height);
	}
}
