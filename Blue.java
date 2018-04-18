package Paint;
import java.awt.Graphics;
import java.awt.Color;

public class Blue extends ShapeColor{  
	Blue(String s)
	{
		super(s);
	}
	void lineColor(Graphics g)
	{
		g.setColor(Color.blue);
	}
	void colorPolygon(Graphics g, int x[], int y[], int n)
	{
		g.setColor(Color.blue);
		g.fillPolygon(x, y, n);
		
	}
	void colorCircle(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.blue);
		g.fillOval(x, y, width, height);
	}

}
