package Main.ui;

import Main.entities.ProductEntity;
import Main.manager.ProductEntityManager;
import Main.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class ProductAddForm extends BaseForm {
    private JTextField titleField;
    private JTextField typeField;
    private JTextField descriptionField;
    private JTextField imageField;
    private JButton saveButton;
    private JPanel mainPanel;

    public ProductAddForm() {
        super(800, 600);
        setContentPane(mainPanel);
        initButtons();
        setVisible(true);
    }
    public void initButtons(){
        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            String type = typeField.getText();
            String description = descriptionField.getText();
            String image = imageField.getText();

            ProductEntity product = new ProductEntity(
                    title,
                    type,
                    description,
                    image
            );
            try {
                ProductEntityManager.insert(product);
                dispose();
                new ProductTableForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}
