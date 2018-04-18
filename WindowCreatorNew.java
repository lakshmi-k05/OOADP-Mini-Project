package OOADPMiniProject; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
  
public class WindowCreatorNew extends JPanel implements ActionListener
{
    DrawingPanel myDrawingPanel;
    JPanel buttonPanel;
    JButton  blackButton;
    JButton clearButton, upSize, downSize;
  
    public JPanel DrawLineOnPanel()
    {
        myDrawingPanel = new DrawingPanel();
        //myDrawingPanel.setLayout(new GridLayou);
        myDrawingPanel.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.blue));
  
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4, 2, 2));
        buttonPanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.blue));
  
        blackButton = addButton(Color.black);
        addButton(Color.red);
        addButton(Color.green.darker());
        addButton(Color.blue);
        clearButton = addButton(null);
        clearButton.setText("New");
        setLayout(new BorderLayout());
        add("Center", myDrawingPanel);
        add("South", buttonPanel);
        return this;
}
  
    private JButton addButton(Color color)
    {
        JButton button = new JButton();
        button.setBackground(new Color(230,240,250));
        button.setBorder(BorderFactory.createEtchedBorder());
        if (color != null)
        {
            button.setForeground(Color.white);
            button.setBackground(color);
        }
  
        button.setText("Paint");
        buttonPanel.add(button);
        button.addActionListener(this);
  
        return(button);
    }
  
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
         
        if (s.equals("Paint"))
        {
            JButton button = (JButton)e.getSource();
            myDrawingPanel.setPaintColor(button.getBackground());
        }
        if (s.equals("New"))
        {
            myDrawingPanel.clearPaint();
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
  
            Rectangle r = g.getClipBounds();
            g.drawImage(image, r.x, r.y, r.width+r.x, r.height+r.y,
            r.x, r.y, r.width+r.x, r.height+r.y, null);
        }
  
    }
}
