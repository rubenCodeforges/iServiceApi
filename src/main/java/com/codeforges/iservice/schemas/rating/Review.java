package com.codeforges.iservice.schemas.rating;


import com.codeforges.iservice.schemas.common.Thing;

public class Review extends CreativeWork {
    private Thing itemReviewed;
    private String reviewBody;
    private Rating reviewRating;
}
