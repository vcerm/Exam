package Main.ui;

import Main.App;
import Main.manager.UserEntityManager;
import Main.util.BaseForm;
import Main.util.DialogUtils;

import javax.swing.*;
import java.sql.SQLException;

public class AuthForm extends BaseForm {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton guestButton;
    private JButton authButton;
    private JPanel mainPanel;

    public AuthForm() {
        super(800, 600);
        setContentPane(mainPanel);
        initButtons();
        setVisible(true);
    }

    public void initButtons(){
        authButton.addActionListener(e -> {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());
            try {
                String role = UserEntityManager.getUserRole(login,password);

                if(role == null){
                    DialogUtils.ShowError("Неверное имя пользователя или пароль");
                }

                if("Администратор".equalsIgnoreCase(role)){
                    App.IS_ADMIN = true;

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            dispose();
            new ProductTableForm();
        });
        guestButton.addActionListener(e -> {
            dispose();
            new ProductTableForm();
        });
    }
}
