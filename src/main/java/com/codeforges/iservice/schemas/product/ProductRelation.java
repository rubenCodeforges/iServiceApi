package com.codeforges.iservice.schemas.product;


import java.util.Collection;
import java.util.UUID;

public class ProductRelation {
    private UUID uuid;

    private Product mainProduct;
    private Collection<Product> reltadedProducts;
    private RelationShipType relationShipType;
}
