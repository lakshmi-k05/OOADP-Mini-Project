package Paint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Shape{
	int hwidth, height;
	Graphics2D gr;
	Triangle(int x, int y, int w, int h)
	{
		super(x,y);
		hwidth = w;
		height = h;
	}
	void draw(Graphics gr)
	{
		
		bcolor.lineColor(gr);
		gr.drawLine(x, y, x+hwidth, y+height);
		gr.drawLine(x+hwidth, y+height, x-hwidth, y+height);
		gr.drawLine(x-hwidth, y+height, x, y);
		
		int xPoints[] = {x+1, x+hwidth, x-hwidth};
		int yPoints[] = {y+1, y+height, y+height};
		
		fcolor.colorPolygon(gr, xPoints, yPoints, 3);
		
	}
}
