package OOADPMiniProject;
import java.awt.*;
import javax.swing.*;

public class WindowCreator{

    public static void main(String ad[])
    {
    	JFrame jf = new JFrame("Just Paint It");
        Demo wcn = new Demo();
        //wcn.DrawLineOnPanel();
        jf.setContentPane(wcn);
        jf.setSize(new Dimension(1500,1000));
        jf.setVisible(true);
        
    }
}
