package model.product;


import lombok.Data;
import model.category.Category;
@Data
public class Product {
    private Integer productId;
    private String productName;

    private String quantityPerUnit;
    private Integer unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;
    private Category category;

    public Product() {
    }

    public Product(Integer productId, String productName, String quantityPerUnit, Integer unitPrice, Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel, Boolean discontinued, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
        this.category = category;
    }



}

