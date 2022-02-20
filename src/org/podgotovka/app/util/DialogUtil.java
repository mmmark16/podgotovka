package org.podgotovka.app.util;

import javax.swing.*;
import java.awt.*;

public class DialogUtil {
    public static void showInfo(Component parentcomponent, String text){
        JOptionPane.showMessageDialog(parentcomponent, text, "информация", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showInfo( String text){
        JOptionPane.showMessageDialog(null, text, "информация", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showError(Component parentcomponent, String text){
        JOptionPane.showMessageDialog(parentcomponent, text, "ошибка", JOptionPane.ERROR_MESSAGE);
    }
    public static void showError(String text){
        JOptionPane.showMessageDialog(null, text, "ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
