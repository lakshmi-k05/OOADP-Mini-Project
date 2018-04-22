package OOADPMiniProject; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
  
public class Demo extends JPanel implements ActionListener
{
    //CanvasPanel myCanvasPanel;
	Canvas myCanvas;
	ShapeColor fillcolor, linecolor;
	Shape shape;
	int chooseColor = 0;	//For fill,border or freehand
    JPanel buttonPanel, shapePanel;
    JButton btnblue, btnred, btngreen, btnyellow, btnblack, btnwhite;
    JButton btnclear;
    JButton btnIncSize,btnDecSize;				//Brush Size
    JButton btnsquare, btnborder, btnfill, btntriangle, btncircle, btnfreehand;
    Demo()
    {
    	DrawFreeHand();
    }
    public JPanel DrawFreeHand()
    {
    	myCanvas = new Canvas();
        
    	myCanvas.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.blue));
    	
    	buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 6, 2, 2));
        buttonPanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.blue));
  
  
    	shapePanel = new JPanel();
    	shapePanel.setLayout(new GridLayout(0, 6, 2, 2));
        shapePanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.blue));
        
        
        btnblack = insertButton(Color.black, null);
        btnred = insertButton(Color.red, null);
        btngreen = insertButton(Color.green.darker(), null);
        btnblue = insertButton(Color.blue, null);
        btnyellow = insertButton(Color.yellow, null);
        btnwhite = insertButton(Color.white, null);
        
        btnsquare = insertButton(null, "Square");
        btntriangle = insertButton(null, "Triangle");
        btncircle = insertButton(null, "Circle");
        
        btnfill = insertButton(null,"FIll");
        btnborder = insertButton(null, "Border");
        btnfreehand = insertButton(null,"FreeHand");
        
        btnIncSize = insertButton(null,"Increase Brush Size");
        btnDecSize = insertButton(null,"Decrease Brush Size");
        
        setLayout(new BorderLayout());
        btnclear = new JButton("Clear");
        btnclear.setBackground(new Color(230,240,250));
        btnclear.setBorder(BorderFactory.createEtchedBorder());
        btnclear.setForeground(Color.white);
        btnclear.setBackground(Color.black);
        btnclear.setText("New");
        btnclear.addActionListener(this);
        add("South", btnclear);
        
        add("Center", myCanvas);
        add("North", buttonPanel);
        add("North", shapePanel);
        return this;
}
  
    private JButton insertButton(Color color, String str)
    {
        JButton button = new JButton();
        button.setBackground(new Color(230,240,250));
        button.setBorder(BorderFactory.createEtchedBorder());
        if (color != null)
        {
            button.setForeground(Color.white);
            button.setBackground(color);
            str = "Paint";
            button.setText(str);
            buttonPanel.add(button);
        }
        else
        	button.setText(str);
        	shapePanel.add(button);
  
        
        button.addActionListener(this);
  
        return(button);
    }
    public void paint(Graphics g)
	{
		super.paint(g);
    	if(shape!=null)
    	{
    		shape.setColor(linecolor,fillcolor);
    		shape.draw(g);
    	}
	}
    public void actionPerformed(ActionEvent actEv)
    {
    	if (actEv.getSource()==btnclear)
        {
            myCanvas.clearPaint();
        }
    	String s = actEv.getActionCommand();
    	if (s.equals("Paint") && chooseColor==3)
        {
            JButton button = (JButton)actEv.getSource();
            myCanvas.setPaintColor(button.getBackground());
        }
    	if(actEv.getSource() == btnIncSize)
    		myCanvas.increaseBrushSize();
    	if(actEv.getSource() == btnDecSize)
    		myCanvas.decreaseBrushSize();
    	
    	if(actEv.getSource()==btnborder)
		{
			chooseColor = 1;
		}
		if(actEv.getSource()==btnfill)
		{
			chooseColor = 2;
		}
		if(actEv.getSource()==btnfreehand)
		{
			chooseColor = 3;
		}
		if(actEv.getSource()==btnred)
		{
			if(chooseColor==2)
				fillcolor = new Red("Red");
			else if(chooseColor==1)
				linecolor = new Red("Red");
		}
		else if(actEv.getSource()==btnblue)
		{
			if(chooseColor==2)
				fillcolor = new Blue("Blue");
			else if(chooseColor==1)
				linecolor = new Blue("Blue");
		}
		else if(actEv.getSource()==btngreen)
		{
			if(chooseColor==2)
				fillcolor = new Green("Green");
			else if(chooseColor==1)
				linecolor = new Green("Green");
		}
		else if(actEv.getSource()==btnyellow)
		{
			if(chooseColor==2)
				fillcolor = new Yellow("Yellow");
			else if(chooseColor==1)
				linecolor = new Yellow("Yellow");
		}
		else if(actEv.getSource()==btnblack)
		{
			if(chooseColor==2)
				fillcolor = new Black("Black");
			else if(chooseColor==1)
				linecolor = new Black("Black");
		}
		else if(actEv.getSource()==btnwhite)
		{
			if(chooseColor==2)
				fillcolor = new White("White");
			else if(chooseColor==1)
				linecolor = new White("White");
		}
		else if(actEv.getSource()==btnsquare)
		{
			shape = new Square(600,100,300);
			if(linecolor==null)
				linecolor = new Black("black");
			if(fillcolor==null)
				fillcolor = new White("white");
			repaint();
		}
		else if(actEv.getSource()==btntriangle)
		{
			shape = new Triangle(600,100,300, 300);
			if(linecolor==null)
				linecolor = new Black("black");
			if(fillcolor==null)
				fillcolor = new White("white");
			repaint();
		}
		else if(actEv.getSource()==btncircle)
		{
			shape = new Circle(600,100,300);
			if(linecolor==null)
				linecolor = new Black("black");
			if(fillcolor==null)
				fillcolor = new White("white");
			repaint();
		}
    }
    public class Canvas extends JPanel implements MouseListener, MouseMotionListener
    {
        Image image;
        Graphics2D myGraphics;
        int brushSize = 3;
        Point last;
  
        public Canvas()
        {
            setPreferredSize( new Dimension(300, 300) );
            addMouseListener(this);
            addMouseMotionListener(this);
        }
  
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
  
        public void mousePressed(MouseEvent e)
        {
            last = e.getPoint();
            draw( last );
        }
  
        public void mouseDragged(MouseEvent e)
        {
            double delX = e.getX() - last.getX();
            double delY = e.getY() - last.getY();
            double delta = Math.max(Math.abs(delX), Math.abs(delY));
            double xIncrement = delX / delta;
            double yIncrement = delY / delta;
  
            double xStart = last.getX();
            double yStart = last.getY();
  
            for (int i = 0; i < delta; i++)
            {
                Point interpolated = new Point((int)xStart, (int)yStart);
                draw( interpolated );
                xStart += xIncrement;
                yStart += yIncrement;
            }
  
            draw(e.getPoint());
            last = e.getPoint();
        }
  
        private void draw(Point start)
        {
            int x = start.x - (brushSize/2) + 1;
            int y = start.y - (brushSize/2) + 1;
            myGraphics.fillOval(x, y, brushSize, brushSize);
            repaint(x, y, brushSize, brushSize);
        }
  
        public void setPaintColor(Color color)
        {
            myGraphics.setColor(color);
        }
  
        public void clearPaint()
        {
            myGraphics.setColor( Color.white );
            myGraphics.fillRect(0, 0, getWidth(), getHeight());
            repaint();
            myGraphics.setColor( Color.black );
        }
  
        public void increaseBrushSize()
        {
            brushSize = brushSize + 2;
        }
  
        public void decreaseBrushSize()
        {
            brushSize = brushSize - 2;
  
            if (brushSize <= 0)
                brushSize = 1;
        }
  
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
  
            if (image == null)
            {
                image = createImage(getWidth(), getHeight());
                myGraphics = (Graphics2D)image.getGraphics();
                myGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
                myGraphics.setColor(Color.white);
                myGraphics.fillRect(0, 0, getWidth(), getHeight());
                myGraphics.setColor(Color.black);
            }
  
            java.awt.Rectangle r = g.getClipBounds();
            g.drawImage(image, r.x, r.y, r.width+r.x, r.height+r.y,
            r.x, r.y, r.width+r.x, r.height+r.y, null);
        }
  
    }
}
