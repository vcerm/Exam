package Main.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame {
    public static String APP_TITLE = "DEMOEX";
    public static Image APP_ICON = null;
    static {try { APP_ICON = ImageIO.read(BaseForm.class.getClassLoader().getResource("icon.png"));} catch (Exception e) {e.printStackTrace();}}

    public BaseForm(int width, int height){
        setTitle(APP_TITLE);

        setMinimumSize(new Dimension(width,height));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width/2 - width/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - height/2
        );
        if(APP_ICON != null) {setIconImage(APP_ICON);}
    }
}
