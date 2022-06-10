package org.mark.app.ui;

import org.mark.app.App;
import org.mark.app.manager.UserManager;
import org.mark.app.util.BaseForm;
import org.mark.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class AuthForm extends BaseForm {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton guestButton;
    private JPanel manepanel;

    public AuthForm() {
        super(250, 400);
        setContentPane(manepanel);
        initButton();
        setVisible(true);
    }

    private void initButton(){
        guestButton.addActionListener(e -> {
            dispose();
            new ProductTableForm();
        });

        loginButton.addActionListener(e -> {
            String login = loginField.getText();
            String pass = new String(passwordField.getPassword());
            System.out.println(login + pass);

            try {
                String role = UserManager.getUserRole(login, pass);
                System.out.println(role);
                if (role == null){
                    DialogUtil.showerror(this, "неверные логин или пароль");
                    return;
                }
                if(role.equalsIgnoreCase("Администратор")){
                    App.IS_ADMIN = true;
                }

                dispose();
                new ProductTableForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}
