package org.podgotovka.app.ui;

import org.podgotovka.app.entity.Product;
import org.podgotovka.app.manager.ProductManager;
import org.podgotovka.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class SelectForm extends BaseForm {
    private JButton backbutton;
    private JPanel mainpanel;
    private JTextArea textArea1;

    public SelectForm() {
        super(800, 600);
        setContentPane(mainpanel);
        initfied();
        initbutton();
        setVisible(true);
    }

    private void initfied() {
        try {
            List<Product> list = ProductManager.selectAll();
            String s = "";
            for (Product p : list){
                s += p;
                s += "\n";
            }
            textArea1.setText(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initbutton() {
        backbutton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
    }
}
