package org.podgotovka.app;

import org.podgotovka.app.entity.Product;
import org.podgotovka.app.manager.ProductManager;
import org.podgotovka.app.ui.MainForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MainForm();
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pop", "root", "1234");
    }
}

/*
    CREATE TABLE IF NOT EXISTS `test` (
        `product` VARCHAR(256) NOT NULL,
        `materialtitle` VARCHAR(256) NOT NULL,
        `countmaterial` INT NOT NULL,
        );


        INSERT INTO productmaterial(ProductID, MaterialID, Count)
        SELECT product.ID as ProductID, material.ID as MaterialID, test.countmaterial as Count
        FROM test
        INNER JOIN product on product.Title = test.product
        INNER JOIN material on material.Title = test.materialtitle




        git init
        git remote add origin всатвить ссылку из гокса
        git add -A
        git commit -m "commit"
        git branch session 1
        git checkout session 1
        git push и потом то что предложит
*/
