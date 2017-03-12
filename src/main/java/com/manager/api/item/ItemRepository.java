package com.manager.api.item;

import org.springframework.data.mongodb.repository.MongoRepository;

interface ItemRepository extends MongoRepository<Item, String>{

}
