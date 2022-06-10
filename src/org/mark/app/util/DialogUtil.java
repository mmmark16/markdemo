package org.mark.app.util;

import javax.swing.*;
import java.awt.*;

public class DialogUtil extends JOptionPane {
    public static void showerror(Component component, String text){
        JOptionPane.showMessageDialog(component, text, "ошибка", ERROR_MESSAGE);
    }
    public static void showinfo(Component component, String text){
        JOptionPane.showMessageDialog(component, text, "информация", INFORMATION_MESSAGE);
    }
}
