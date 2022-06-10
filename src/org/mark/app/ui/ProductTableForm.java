package org.mark.app.ui;

import org.mark.app.App;
import org.mark.app.entity.Product;
import org.mark.app.manager.Product_Manager;
import org.mark.app.util.BaseForm;
import org.mark.app.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ProductTableForm extends BaseForm {
    private JTable table;
    private JPanel manepanel;
    private JButton addbutton;
    private CustomTableModel<Product> model;

    public ProductTableForm() {
        super(1200, 800);
        setContentPane(manepanel);
        initField();
        initButton();
        setVisible(true);
    }

    private void initField(){
        table.getTableHeader().setReorderingAllowed(false);
        try {
            model = new CustomTableModel(
                    Product.class,
                    new String[]{"ID", "Title", "ProductType", "ArticleNumber", "Description", "Image", "ProductionPersonCount", "ProductionWorkshopNumber", "MinCostForAgent"},
                    Product_Manager.selectall()
            );
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(App.IS_ADMIN){
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount() == 2){
                        int row = table.rowAtPoint(e.getPoint());
                        if(row != -1){
                            dispose();
                            new UpdateForm(model.getRows().get(row));
                        }
                    }
                }
            });
        }

    }

    private void initButton(){
        if (App.IS_ADMIN){
            addbutton.addActionListener(e -> {
                dispose();
                new InsertForm();
            });
        } else {
            addbutton.setEnabled(false);
        }

    }
}
