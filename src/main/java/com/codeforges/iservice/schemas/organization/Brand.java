package com.codeforges.iservice.schemas.organization;


import com.codeforges.iservice.schemas.common.Thing;
import com.codeforges.iservice.schemas.media.Image;

public class Brand extends Thing {
    AggregateRating aggregateRating;
    Image logo;
    Review review;
}
