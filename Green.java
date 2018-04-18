package Paint;
import java.awt.Graphics;
import java.awt.Color;

public class Green extends ShapeColor{  
	Green(String s)
	{
		super(s);
	}
	void lineColor(Graphics g)
	{
		g.setColor(Color.green);
	}
	void colorPolygon(Graphics g, int x[], int y[], int n)
	{
		g.setColor(Color.green);
		g.fillPolygon(x, y, n);
		
	}
	void colorCircle(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.green);
		g.fillOval(x, y, width, height);
	}
}
