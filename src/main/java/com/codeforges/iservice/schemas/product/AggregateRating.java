package com.codeforges.iservice.schemas.product;


public class AggregateRating extends Rating {
    Thing itemReviewed;
    Integer ratingCount;
    Integer reviewCount;
}
