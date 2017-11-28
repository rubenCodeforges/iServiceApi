package com.codeforges.iservice.schemas.product;

import com.codeforges.iservice.schemas.common.Thing;

import java.util.Collection;

public class Category extends Thing {
    Collection<Product> products;
}
