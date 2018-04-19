package OOADPMiniProject;
import java.awt.*;
import javax.swing.*;

public class PaintClient{

    public static void main(String ad[])
    {
        JFrame jp1 = new JFrame("Dew It!!!");
        //WindowCreator a=new WindowCreator();
        WindowCreatorNew a = new WindowCreatorNew();
        //jp1.getContentPane().add(a, BorderLayout.CENTER);
        jp1.add(a.DrawLineOnPanel());
        jp1.setSize(new Dimension(1000,1000));
        jp1.setVisible(true);
        
    }
}