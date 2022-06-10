package Main.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ProductEntity {
    private int id;
    private String Title;
    private String ProductType;
    private String Description;
    private String ImagePath;

    public ProductEntity(String title, String productType, String description, String imagePath) {
        this(-1,title,productType,description,imagePath);
    }
}
