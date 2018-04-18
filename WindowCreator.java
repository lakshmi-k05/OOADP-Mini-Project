package OOADPMiniProject;
import java.awt.Graphics;
import javax.swing.*;
public class WindowCreator extends JPanel{
	WindowCreator()
	{
		
	}
	public void paint(Graphics g)
	{
		ShapeColor c = new Red("red");
    	ShapeColor c2 = new Blue("blue");
    	Shape sq = new Rectangle(600,100,344, 800);
    	sq.setColor(c,c2);
    	sq.draw(g);
	}
}
