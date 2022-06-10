package Main.util;

import javax.swing.*;
import java.awt.*;

public class DialogUtils {

    public static void ShowError(Component parentComponent, String text){
        JOptionPane.showMessageDialog(parentComponent, text, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }


    public static void ShowError(String text){
        ShowError(null,text);
    }
}
