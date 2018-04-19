package OOADPMiniProject;
import java.awt.Graphics;
import java.awt.Color;

public class White extends ShapeColor{  
	White(String s)
	{
		super(s);
	}
	void lineColor(Graphics g)
	{
		g.setColor(Color.white);
	}
	void colorPolygon(Graphics g, int x[], int y[], int n)
	{
		g.setColor(Color.white);
		g.fillPolygon(x, y, n);
		
	}
	void colorCircle(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
	}

}
