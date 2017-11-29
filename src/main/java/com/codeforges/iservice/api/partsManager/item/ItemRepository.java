package com.codeforges.iservice.api.partsManager.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

interface ItemRepository extends JpaRepository<Item, Long> {
    Collection<Item> findByOrders_Id(Long orderId);
    Collection<Item> findByTitleContaining(String title);
}
