package Paint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Shape{
	int width, height;
	Graphics2D gr;
	Square(int x, int y, int w)
	{
		super(x,y);
		width = w;
		height = w;
	}
	void draw(Graphics gr)
	{
		
		bcolor.lineColor(gr);
		gr.drawLine(x, y, x+width, y);
		gr.drawLine(x+width, y, x+width, y+height);
		gr.drawLine(x, y+height, x+width, y+height);
		gr.drawLine(x, y, x, y+height);
		
		int xPoints[] = {x+1, x+width, x+width, x+1};
		int yPoints[] = {y+1, y+1, y+height, y+height};
	
		fcolor.colorPolygon(gr, xPoints, yPoints, 4);
	}
}
