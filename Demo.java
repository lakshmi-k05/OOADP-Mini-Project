package OOADPMiniProject; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
  
public class Demo extends JPanel implements ActionListener
{
    //CanvasPanel myCanvasPanel;
	DrawingPanel myDrawingPanel;
	ShapeColor fillcolor, linecolor;
	Shape shape;
	int chooseColor = 0;
    JPanel buttonPanel, shapePanel;
    JButton btnblue, btnred, btngreen, btnyellow, btnblack, btnwhite;
    JButton btnclear;
    JButton btnsquare, btnborder, btnfill, btntriangle, btncircle, btnfreehand;
    Demo()
    {
    	DrawLineOnPanel();
    }
    public JPanel DrawLineOnPanel()
    {
    	myDrawingPanel = new DrawingPanel();
        //myDrawingPanel.setLayout(new GridLayou);
    	myDrawingPanel.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.blue));
  
    	shapePanel = new JPanel();
    	shapePanel.setLayout(new GridLayout(0, 6, 2, 2));
        shapePanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.blue));
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 6, 2, 2));
        buttonPanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.blue));
  
        btnblack = addButton(Color.black, null);
        btnred = addButton(Color.red, null);
        btngreen = addButton(Color.green.darker(), null);
        btnblue = addButton(Color.blue, null);
        btnyellow = addButton(Color.yellow, null);
        btnwhite = addButton(Color.white, null);
        
        btnsquare = addButton(null, "Square");
        btntriangle = addButton(null, "Triangle");
        btncircle = addButton(null, "Circle");
        
        btnfill = addButton(null,"FIll");
        btnborder = addButton(null, "Border");
        btnfreehand = addButton(null,"FreeHand");
        
        
        
        setLayout(new BorderLayout());
        btnclear = new JButton("Clear");
        btnclear.setBackground(new Color(230,240,250));
        btnclear.setBorder(BorderFactory.createEtchedBorder());
        btnclear.setForeground(Color.white);
        btnclear.setBackground(Color.black);
        btnclear.setText("New");
        btnclear.addActionListener(this);
        add("South", btnclear);
        
        add("Center", myDrawingPanel);
        add("North", buttonPanel);
        add("North", shapePanel);
        return this;
}
  
    private JButton addButton(Color color, String str)
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
            myDrawingPanel.clearPaint();
        }
    	String s = actEv.getActionCommand();
    	if (s.equals("Paint") && chooseColor==3)
        {
            JButton button = (JButton)actEv.getSource();
            myDrawingPanel.setPaintColor(button.getBackground());
        }
    	
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
    public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener
    {
        Image image;
        Graphics2D g2d;
        int brushSize = 3;
        Point lastPoint;
  
        public DrawingPanel()
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
            lastPoint = e.getPoint();
            draw( lastPoint );
        }
  
        public void mouseDragged(MouseEvent e)
        {
            double xDelta = e.getX() - lastPoint.getX();
            double yDelta = e.getY() - lastPoint.getY();
            double delta = Math.max(Math.abs(xDelta), Math.abs(yDelta));
            double xIncrement = xDelta / delta;
            double yIncrement = yDelta / delta;
  
            double xStart = lastPoint.getX();
            double yStart = lastPoint.getY();
  
            for (int i = 0; i < delta; i++)
            {
                Point interpolated = new Point((int)xStart, (int)yStart);
                draw( interpolated );
                xStart += xIncrement;
                yStart += yIncrement;
            }
  
            draw(e.getPoint());
            lastPoint = e.getPoint();
        }
  
        private void draw(Point start)
        {
            int x = start.x - (brushSize/2) + 1;
            int y = start.y - (brushSize/2) + 1;
            g2d.fillOval(x, y, brushSize, brushSize);
            repaint(x, y, brushSize, brushSize);
        }
  
        public void setPaintColor(Color color)
        {
            g2d.setColor(color);
        }
  
        public void clearPaint()
        {
            g2d.setColor( Color.white );
            g2d.fillRect(0, 0, getWidth(), getHeight());
            repaint();
            g2d.setColor( Color.black );
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
                g2d = (Graphics2D)image.getGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.white);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setColor(Color.black);
            }
  
            java.awt.Rectangle r = g.getClipBounds();
            g.drawImage(image, r.x, r.y, r.width+r.x, r.height+r.y,
            r.x, r.y, r.width+r.x, r.height+r.y, null);
        }
  
    }
}
