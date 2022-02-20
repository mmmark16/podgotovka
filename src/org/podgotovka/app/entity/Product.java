package org.podgotovka.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int Id;
    private String Title;
    private String ProductType;
    private int ArticleNumber;
    private String Description;
    private String Image;
    private int ProductionPersonCount;
    private int ProductionWorkshopNumber;
    private int MinCostForAgent;


    public Product(String title, String productType, int articleNumber, String description, String image, int productionPersonCount, int productionWorkshopNumber, int minCostForAgent) {
        this(-1, title, productType, articleNumber, description, image, productionPersonCount, productionWorkshopNumber, minCostForAgent);
    }
}
