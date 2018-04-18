package Paint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape{
	int width, height;
	Graphics2D gr;
	Circle(int x, int y, int w)
	{
		super(x,y);
		width = w;
		height = w;
	}
	void draw(Graphics gr)
	{
		bcolor.lineColor(gr);
		gr.drawOval(x, y, width, height);
		x++;
		y++;
		fcolor.colorCircle(gr, x, y, width-1, height-1);	
	}
}
