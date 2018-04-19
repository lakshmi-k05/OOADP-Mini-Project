package OOADPMiniProject;
import javax.swing.*;
import java.awt.event.*;

import OOADPMiniProject.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;
public class MainClient extends JPanel implements ActionListener{
	
	ShapeColor linecolor, fillcolor, color;
	int chooseColor = 0;
	Shape shape;
	Dimension coldim = new Dimension(60,20);
	static JTextField txt;
	static JButton btnblue, btnred, btngreen, btnyellow, btnblack, btnwhite;
	static JButton btnsquare, btnborder, btnfill, btntriangle, btncircle;
	static Canvas can;
	Icon blueicon = new ImageIcon("/Images/blue.png");
	MainClient()
	{
		
        btnblue = new JButton("Blue");
        btnblue.setIcon(blueicon);
        btnblue.setBounds(30,10,60,20);
        btnred = new JButton("Red");
        btnred.setBounds(90,10,60,20);
        btngreen= new JButton("Green");
        btngreen.setBounds(150,10,60,20);
        btnyellow= new JButton("Yellow");
        btnyellow.setBounds(210,10,60,20);
        btnblack= new JButton("Black");
        btnblack.setBounds(270,10,60,20);
        btnwhite= new JButton("White");
        btnwhite.setBounds(330,10,60,20);
        btnsquare = new JButton("Square");
        btnsquare.setBounds(450,10,60,20);
        btntriangle = new JButton("Triangle");
        btntriangle.setBounds(510,10,60,20);
        btncircle = new JButton("Circle");
        btncircle.setBounds(570,10,60,20);
        btnfill= new JButton("Fill");
        btnfill.setBounds(700,10,60,20);
        btnborder= new JButton("Border");
        btnborder.setBounds(760,10,60,20);
        addListeners();	
	}
		public void paint(Graphics g)
		{
			//ShapeColor c = new Red("red");
	    	//ShapeColor c2 = new Blue("blue");
	    	//shape = new Rectangle(600,100,300, 300);
	    	//shape.setColor(c,c2);
			super.paint(g);
	    	System.out.println("Actually drawing");
	    	if(shape!=null)
	    	{
	    		System.out.println(fillcolor.getColor());
	    		System.out.println(linecolor.getColor());
	    		shape.setColor(linecolor,fillcolor);
	    		shape.draw(g);
	    		System.out.println(chooseColor);
	    	}
		}
	void addListeners()
	{
		btnred.addActionListener(this);
        btnblue.addActionListener(this);
        btngreen.addActionListener(this);
        btnyellow.addActionListener(this);
        btnblack.addActionListener(this);
        btnwhite.addActionListener(this);
        btnsquare.addActionListener(this);
        btntriangle.addActionListener(this);
        btncircle.addActionListener(this);
        btnfill.addActionListener(this);
        btnborder.addActionListener(this);
	}
	public void actionPerformed(ActionEvent actEv)
	{
		if(actEv.getSource()==btnborder)
		{
			//if(color!=null)
			chooseColor = 1;
			System.out.println("BOrder");
		}
		if(actEv.getSource()==btnfill)
		{
			//if(color!=null)
			chooseColor = 2;
			System.out.println("BOrder");
		}
		if(actEv.getSource()==btnred)
		{
			if(chooseColor==2)
				fillcolor = new Red("Red");
			else if(chooseColor==1)
				linecolor = new Red("Red");
			System.out.println("Red");
		}
		else if(actEv.getSource()==btnblue)
		{
			if(chooseColor==2)
				fillcolor = new Blue("Blue");
			else if(chooseColor==1)
				linecolor = new Blue("Blue");
			System.out.println("Blue");
		}
		else if(actEv.getSource()==btngreen)
		{
			if(chooseColor==2)
				fillcolor = new Green("Green");
			else if(chooseColor==1)
				linecolor = new Green("Green");
			System.out.println("Green");
		}
		else if(actEv.getSource()==btnyellow)
		{
			if(chooseColor==2)
				fillcolor = new Yellow("Yellow");
			else if(chooseColor==1)
				linecolor = new Yellow("Yellow");
			System.out.println("Yellow");
		}
		else if(actEv.getSource()==btnblack)
		{
			if(chooseColor==2)
				fillcolor = new Black("Black");
			else if(chooseColor==1)
				linecolor = new Black("Black");
			System.out.println("Black");
		}
		else if(actEv.getSource()==btnwhite)
		{
			if(chooseColor==2)
				fillcolor = new White("White");
			else if(chooseColor==1)
				linecolor = new White("White");
			System.out.println("White");
		}
		else if(actEv.getSource()==btnsquare)
		{
			//if(color!=null)
			//shape = null;
			shape = new Square(600,100,300);
			//txt.setText("square");
			if(linecolor==null)
				linecolor = new Black("black");
			if(fillcolor==null)
				fillcolor = new White("white");
				
			System.out.println("Square");
			repaint();
		}
		else if(actEv.getSource()==btntriangle)
		{
			//if(color!=null)
			shape = new Triangle(600,100,300, 300);
			//txt.setText("square");
			if(linecolor==null)
				linecolor = new Black("black");
			if(fillcolor==null)
				fillcolor = new White("white");
			System.out.println("Triangle");
			repaint();
		}
		else if(actEv.getSource()==btncircle)
		{
			//if(color!=null)
			shape = new Circle(600,100,300);
			//txt.setText("square");
			if(linecolor==null)
				linecolor = new Black("black");
			if(fillcolor==null)
				fillcolor = new White("white");
			System.out.println("Circle");
			repaint();
		}
	}
	
	public static void main(String ad[])
    {
        JFrame frm = new JFrame("Why Ani, Why");
        MainClient pc = new MainClient();
        frm.setContentPane(pc);
        frm.getContentPane().setLayout(null);
        frm.add(btnsquare, BorderLayout.PAGE_START);
        pc.add(btntriangle, BorderLayout.PAGE_START);
        pc.add(btncircle, BorderLayout.PAGE_START);
        pc.add(btnblue, BorderLayout.PAGE_START);
        pc.add(btnyellow, BorderLayout.PAGE_START);
        frm.add(btnred, BorderLayout.PAGE_START);
        pc.add(btngreen, BorderLayout.PAGE_START);
        pc.add(btnblack, BorderLayout.PAGE_START);
        pc.add(btnwhite, BorderLayout.PAGE_START);
        pc.add(btnborder, BorderLayout.PAGE_START);
        pc.add(btnfill, BorderLayout.PAGE_START);
        frm.setSize(1500,1000);
        frm.setVisible(true);
    }
}
