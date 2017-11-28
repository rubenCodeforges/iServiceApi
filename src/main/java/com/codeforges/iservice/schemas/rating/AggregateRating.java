package com.codeforges.iservice.schemas.rating;


import com.codeforges.iservice.schemas.common.Thing;

public class AggregateRating extends Rating {
    Thing itemReviewed;
    Integer ratingCount;
    Integer reviewCount;
}
