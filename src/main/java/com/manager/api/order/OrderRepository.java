package com.manager.api.order;

import org.springframework.data.mongodb.repository.MongoRepository;

interface OrderRepository extends MongoRepository <Order, String>{
}
