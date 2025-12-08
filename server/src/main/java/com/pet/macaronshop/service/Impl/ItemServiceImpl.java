package com.pet.macaronshop.service.Impl;

import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.model.Item;
import com.pet.macaronshop.repository.BacketRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pet.macaronshop.repository.ItemRepository;
import com.pet.macaronshop.service.ItemService;

import java.util.List;


@Service
@AllArgsConstructor
@Primary

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }


    @Transactional
    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

}
