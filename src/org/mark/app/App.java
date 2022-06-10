package org.mark.app;

import org.mark.app.manager.Product_Manager;
import org.mark.app.ui.AuthForm;
import org.mark.app.ui.ProductTableForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static boolean IS_ADMIN = false;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new AuthForm();


    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lol", "root", "1234");
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

        git config --global user.name "Pa4ok"
        git config --global user.email "pa4ok228@mail.ru"
        git init
        git remote add origin всатвить ссылку из гокса
        git add -A
        git commit -m "commit"
        git branch session 1
        git checkout session 1
        git push и потом то что предложит

*/
