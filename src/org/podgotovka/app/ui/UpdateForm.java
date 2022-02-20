package org.podgotovka.app.ui;

import org.podgotovka.app.entity.Product;
import org.podgotovka.app.manager.ProductManager;
import org.podgotovka.app.ui.MainForm;
import org.podgotovka.app.util.BaseForm;
import org.podgotovka.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class UpdateForm extends BaseForm {
    private JTextField titlefield;
    private JTextField imageField;
    private JTextField DescriptionField;
    private JTextField ProductTypeField;
    private JSpinner ArticleNumberspinner;
    private JSpinner ProductionPersonCountspinner;
    private JSpinner ProductionWorkshopNumberspinner;
    private JSpinner MinCostForAgentspinner;
    private JButton insertbutton;
    private JButton backbutton;
    private JPanel manepanel;

    public UpdateForm() {
        super(800, 600);
        setContentPane(manepanel);
        initbutton();
        setVisible(true);
    }
    public void initbutton(){
        insertbutton.addActionListener(e -> {
             String Title = titlefield.getText();
             if (Title.isEmpty() || Title.length() > 100){
                 DialogUtil.showError(this, "не корректно введено название");
                 return;
             }
             String ProductType = ProductTypeField.getText();
            if (ProductType.isEmpty() || ProductType.length() > 100){
                DialogUtil.showError(this, "не корректно введен тип");
                return;
            }
             int ArticleNumber = (int) ArticleNumberspinner.getValue();
             String Description = DescriptionField.getText();
            if (Description.isEmpty() || Description.length() > 100){
                DialogUtil.showError(this, "не корректно введено описание");
                return;
            }
             String Image = imageField.getText();
             int ProductionPersonCount = (int) ProductionPersonCountspinner.getValue();
             int ProductionWorkshopNumber = (int) ProductionWorkshopNumberspinner.getValue();
             int MinCostForAgent = (int) MinCostForAgentspinner.getValue();

            Product product = new Product(
                    Title,
                    ProductType,
                    ArticleNumber,
                    Description,
                    Image,
                    ProductionPersonCount,
                    ProductionWorkshopNumber,
                    MinCostForAgent
            );

            try {
                ProductManager.insert(product);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            DialogUtil.showInfo(this, "успешно добавлен");
            dispose();
            new MainForm();

        });
        backbutton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
    }
}
