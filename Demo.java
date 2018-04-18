package Paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo{
	public static void main(String args[])
	{
		Shape sh = new Square(400,400,200,200);
		JFrame frm = new JFrame("Paint This Shit");
		WindowCreator wc = new WindowCreator();
		frm.setContentPane(wc);
		frm.setSize(1000,1000);
		frm.setVisible(true);
		
		WindowListener listener = new WindowAdapter() 
		{
			public void windowClosing(WindowEvent win)
			{
				System.exit(0);
			}
		};
	}
	
}
