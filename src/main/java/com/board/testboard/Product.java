package com.board.testboard;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private int productNumber;
    private String productName;
    private int productPrice;

    public Product(int productNumber, String productName, int productPrice) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
