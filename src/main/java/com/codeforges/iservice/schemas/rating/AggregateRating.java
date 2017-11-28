package com.codeforges.iservice.schemas.rating;


import com.codeforges.iservice.schemas.common.Thing;

public class AggregateRating extends Rating {
    private Thing itemReviewed;
    private Integer ratingCount;
    private Integer reviewCount;
}
