package org.podgotovka.app.util;

import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame {
    public BaseForm (int widht, int height){
        setTitle("Podgotovka");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(widht, height));
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width/2 - widht/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - height/2
        );
    }
}
