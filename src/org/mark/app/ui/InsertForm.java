package org.mark.app.ui;

import org.mark.app.entity.Product;
import org.mark.app.manager.Product_Manager;
import org.mark.app.util.BaseForm;
import org.mark.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class InsertForm extends BaseForm {
    private JTextField ProductTypefield;
    private JTextField titlefield;
    private JSpinner ArticleNumberspinner;
    private JTextField DescriptionField;
    private JTextField ImageField;
    private JSpinner ProductionPersonCountspinner;
    private JSpinner ProductionWorkshopNumberspinner;
    private JSpinner MinCostForAgentspinner;
    private JButton addButton;
    private JButton backButton;
    private JPanel manepanel;

    public InsertForm() {
        super(600, 400);
        setContentPane(manepanel);
        initButton();
        setVisible(true);
    }

    private void initButton(){
        addButton.addActionListener(e -> {
            String Title = titlefield.getText();
            if(Title.isEmpty() || Title.length() > 100){
                DialogUtil.showerror(this, "Введите коректное название");
                return;
            }
            String ProductType = ProductTypefield.getText();
            if(ProductType.isEmpty() || ProductType.length() > 100){
                DialogUtil.showerror(this, "Введите коректный тип продукта");
                return;
            }
            int ArticleNumber = (int) ArticleNumberspinner.getValue();
            if(ArticleNumber > 1000000000){
                DialogUtil.showerror(this, "Введите коректный артикль");
                return;
            }
            String Description = DescriptionField.getText();
            String Image = ImageField.getText();
            int ProductionPersonCount = (int) ProductionPersonCountspinner.getValue();
            int ProductionWorkshopNumber = (int) ProductionWorkshopNumberspinner.getValue();
            int MinCostForAgent = (int) MinCostForAgentspinner.getValue();

            Product product = new Product(Title, ProductType, ArticleNumber, Description, Image, ProductionPersonCount, ProductionWorkshopNumber, MinCostForAgent);

            try {
                Product_Manager.insert(product);
                DialogUtil.showinfo(this, "продукт успешно добавлен");
                dispose();
                new ProductTableForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new ProductTableForm();
        });
    }
}
