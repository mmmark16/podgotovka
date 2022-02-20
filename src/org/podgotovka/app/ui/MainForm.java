package org.podgotovka.app.ui;

import org.podgotovka.app.entity.Product;
import org.podgotovka.app.manager.ProductManager;
import org.podgotovka.app.util.BaseForm;
import org.podgotovka.app.util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainForm extends BaseForm {
    private JButton updateButton;
    private JButton insertButton;
    private JButton selectButton;
    private JPanel mainpanel;

    public MainForm() {
        super(800, 600);
        setContentPane(mainpanel);
        initButton();
        setVisible(true);
    }

    private void initButton() {
        insertButton.addActionListener(e -> {
            dispose();
            new UpdateForm();
        });
        selectButton.addActionListener(e -> {
            dispose();
            new SelectForm();
        });
        updateButton.addActionListener(e -> {
            String s = JOptionPane.showInputDialog(this,  "введите id", "ввод", JOptionPane.QUESTION_MESSAGE);
            if (s == null){
                return;
            }

            int id = -1;
            try {
                id = Integer.parseInt(s);
            } catch (Exception ex){
                DialogUtil.showError(this, "id не введен или введен не коректно");
                return;
            }


            Product product = null;
            try {
                product = ProductManager.selectById(id);
                dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "ошибка получения данных: " + ex.getMessage());
                return;
            }

            if (product == null){
                DialogUtil.showError(this, "продукта с таким id не существует");
                dispose();
                new MainForm();
                return;
            }
                dispose();
                new InsertForm(product);

        });
    }
}
