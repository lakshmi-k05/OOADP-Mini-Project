package Paint;
import java.awt.Graphics;
import java.awt.Color;

public class Red extends ShapeColor{  
	Red(String s)
	{
		super(s);
	}
	void lineColor(Graphics g)
	{
		g.setColor(Color.red);
	}
	void colorPolygon(Graphics g, int x[], int y[], int n)
	{
		g.setColor(Color.red);
		g.fillPolygon(x, y, n);
		
	}
	void colorCircle(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.red);
		g.fillOval(x, y, width, height);
	}
}
