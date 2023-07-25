package com.board.testboard;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Store {
    private String storeName;
    private String storeAddress;
//    private String store


    public Store(String storeName, String storeAddress) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }
}
