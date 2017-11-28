package com.codeforges.iservice.schemas.rating;

import com.codeforges.iservice.schemas.common.Thing;
import com.codeforges.iservice.schemas.person.Person;

public class Rating extends Thing {
    Person author;
    Number ratingValue;
    Number bestRating;
    Number worstRaing;
}
