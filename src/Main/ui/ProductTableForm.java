package Main.ui;

import Main.entities.ProductEntity;
import Main.manager.ProductEntityManager;
import Main.util.BaseForm;
import Main.util.CustomTableModel;

import javax.swing.*;
import java.sql.SQLException;

public class ProductTableForm extends BaseForm {
    private JTable table;
    private JPanel mainPanel;
    private JButton addButton;
    private CustomTableModel<ProductEntity> model;

    public ProductTableForm() {
        super(800, 600);
        setContentPane(mainPanel);
        initTable();
        initButton();
        setVisible(true);
    }

    public void initTable(){
        table.getTableHeader().setReorderingAllowed(false);
        try {
            model = new CustomTableModel<>(
                    ProductEntity.class,
                    new String[]{"ID","Title", "ProductType", "Description", "Image"},
                    ProductEntityManager.SelectAll()
            );
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  initButton(){
        addButton.addActionListener(e -> {
            dispose();
            new ProductAddForm();
        });
    }
}
