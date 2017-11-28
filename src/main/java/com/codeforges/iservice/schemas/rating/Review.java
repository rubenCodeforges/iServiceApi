package com.codeforges.iservice.schemas.rating;


import com.codeforges.iservice.schemas.common.Thing;

public class Review extends CreativeWork {
    Thing itemReviewed;
    String reviewBody;
    Rating reviewRating;
}
