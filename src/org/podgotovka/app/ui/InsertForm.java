package org.podgotovka.app.ui;

import org.podgotovka.app.entity.Product;
import org.podgotovka.app.manager.ProductManager;
import org.podgotovka.app.util.BaseForm;
import org.podgotovka.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class InsertForm extends BaseForm {
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
    private JTextField idspinner;
    private JButton deletebutton;

    private Product product;

    public InsertForm(Product product) {
        super(800, 600);
        this.product = product;
        setContentPane(manepanel);
        initfield();
        initbutton();
        setVisible(true);
    }

    private void initfield() {
        idspinner.setText(String.valueOf(product.getId()));
        titlefield.setText(product.getTitle());
        ProductTypeField.setText(product.getProductType());
        ArticleNumberspinner.setValue(product.getArticleNumber());
        DescriptionField.setText(product.getDescription());
        imageField.setText(product.getImage());
        ProductionPersonCountspinner.setValue(product.getProductionPersonCount());
        ProductionWorkshopNumberspinner.setValue(product.getProductionWorkshopNumber());
        MinCostForAgentspinner.setValue(product.getMinCostForAgent());
    }

    public void initbutton(){
        insertbutton.addActionListener(e -> {
             String Title = titlefield.getText();
             String ProductType = ProductTypeField.getText();
             int ArticleNumber = (int) ArticleNumberspinner.getValue();
             String Description = DescriptionField.getText();
             String Image = imageField.getText();
             int ProductionPersonCount = (int) ProductionPersonCountspinner.getValue();
             int ProductionWorkshopNumber = (int) ProductionWorkshopNumberspinner.getValue();
             int MinCostForAgent = (int) MinCostForAgentspinner.getValue();

            product.setTitle(Title);
            product.setProductType(ProductType);
            product.setArticleNumber(ArticleNumber);
            product.setDescription(Description);
            product.setImage(Image);
            product.setMinCostForAgent(MinCostForAgent);
            product.setProductionPersonCount(ProductionPersonCount);
            product.setProductionWorkshopNumber(ProductionWorkshopNumber);

            try {
                ProductManager.update(product);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            dispose();
            new MainForm();

        });
        backbutton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
        deletebutton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "удалить?", "удаление", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                try {
                    DialogUtil.showInfo(this, "успешно удален");
                    ProductManager.delete(product);
                    dispose();
                    new MainForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return;
        });
    }
}
