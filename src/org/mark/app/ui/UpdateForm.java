package org.mark.app.ui;

import org.mark.app.entity.Product;
import org.mark.app.manager.Product_Manager;
import org.mark.app.ui.ProductTableForm;
import org.mark.app.util.BaseForm;
import org.mark.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class UpdateForm extends BaseForm {
    private JTextField ProductTypefield;
    private JTextField titlefield;
    private JSpinner ArticleNumberspinner;
    private JTextField DescriptionField;
    private JTextField ImageField;
    private JSpinner ProductionPersonCountspinner;
    private JSpinner ProductionWorkshopNumberspinner;
    private JSpinner MinCostForAgentspinner;
    private JButton updateButton;
    private JButton backButton;
    private JPanel manepanel;
    private JButton deletebutton;
    private JTextField idField;
    private Product product;

    public UpdateForm(Product product) {
        super(600, 400);
        this.product = product;
        setContentPane(manepanel);
        initField(product);
        initButton();
        setVisible(true);
    }

    private void initField(Product product){
        idField.setText(String.valueOf(product.getID()));
        titlefield.setText(product.getTitle());
        ProductTypefield.setText(product.getProductType());
        ArticleNumberspinner.setValue(product.getArticleNumber());
        DescriptionField.setText(product.getDescription());
        ImageField.setText(product.getImage());
        ProductionPersonCountspinner.setValue(product.getProductionPersonCount());
        ProductionWorkshopNumberspinner.setValue(product.getProductionWorkshopNumber());
        MinCostForAgentspinner.setValue(product.getMinCostForAgent());
    }

    private void initButton(){
        updateButton.addActionListener(e -> {
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

            product.setTitle(Title);
            product.setProductType(ProductType);
            product.setArticleNumber(ArticleNumber);
            product.setDescription(Description);
            product.setImage(Image);
            product.setProductionPersonCount(ProductionPersonCount);
            product.setProductionWorkshopNumber(ProductionWorkshopNumber);
            product.setMinCostForAgent(MinCostForAgent);

            try {
                Product_Manager.update(product);
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

        deletebutton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "Вы уверены что хотите удалить данную запись?","Удаление продукта", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                try {
                    Product_Manager.delete(product);
                    dispose();
                    new ProductTableForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
