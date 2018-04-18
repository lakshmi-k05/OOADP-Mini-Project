package Paint;
import java.awt.Graphics;
import java.awt.Color;

public class Yellow extends ShapeColor{  
	Yellow(String s)
	{
		super(s);
	}
	void lineColor(Graphics g)
	{
		g.setColor(Color.yellow);
	}
	void colorPolygon(Graphics g, int x[], int y[], int n)
	{
		g.setColor(Color.yellow);
		g.fillPolygon(x, y, n);
		
	}
	void colorCircle(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
}
