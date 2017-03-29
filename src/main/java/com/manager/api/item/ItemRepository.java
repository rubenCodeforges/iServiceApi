package com.manager.api.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

interface ItemRepository extends JpaRepository<Item, Long> {
    Collection<Item> findByOrders_Id(Long orderId);
}
