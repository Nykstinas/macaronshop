package com.pet.macaronshop.service;

import com.pet.macaronshop.model.Item;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ItemService {
    @Transactional
    Item createItem(Item item);



    List<Item> findAllItem();

}

