package com.manager.api.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

interface ItemRepository extends JpaRepository<Item, Long> {
    public Collection<Item> findByOrderId(Long orderId);
}
