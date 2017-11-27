package com.codeforges.iservice.schemas;


import java.util.Date;

public class Product extends Thing {
    String productID;
    AggregateRating aggregateRating;
    Audience audience;
    String award;
    Brand brand;
    Thing category;
    //    String color;
//    Number number;
//    Number heigth;
//    Number width;
//    Number weight;
    //String logo;
    Product isAccessoryOrSparePartFor;
    Product isConsumableFor;
    Product isRelatedTo;
    Product isSimilarTo;
    Object itemCondition;
    Organization manufacturer;
    Product material;
    ProductModel model;
    Date productionDate;
    Date purchaseDate;
    Date releaseDate;
}
