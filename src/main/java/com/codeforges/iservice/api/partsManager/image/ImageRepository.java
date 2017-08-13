package com.codeforges.iservice.api.partsManager.image;

import com.codeforges.iservice.api.partsManager.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

interface ImageRepository extends JpaRepository<Image, Long> {
    Collection<Item> findByItems_Id(Long orderId);
}