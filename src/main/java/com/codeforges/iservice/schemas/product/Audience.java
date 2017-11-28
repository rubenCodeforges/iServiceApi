package com.codeforges.iservice.schemas.product;

import com.codeforges.iservice.schemas.common.Thing;
import com.codeforges.iservice.schemas.place.Place;

/**
 * Created by codeforges on 11/23/2017.
 */
public class Audience extends Thing {
    String audienceType;
    Place geographicArea;
}
