package com.codeforges.iservice.schemas.rating;

import com.codeforges.iservice.schemas.common.Thing;
import com.codeforges.iservice.schemas.person.Person;

public class Rating extends Thing {
    private Person author;
    private Number ratingValue;
    private Number bestRating;
    private Number worstRaing;
}
