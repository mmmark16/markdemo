package org.mark.app.util;

import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame {
    public BaseForm(int width, int height){
        setTitle("My APP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(width, height));
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width/2 - width/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - height/2
        );
    }
}
