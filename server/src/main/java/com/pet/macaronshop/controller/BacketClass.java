package com.pet.macaronshop.controller;

import com.pet.macaronshop.dto.ItemRequest;
import com.pet.macaronshop.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.model.BacketItem;
import com.pet.macaronshop.service.BacketService;
import com.pet.macaronshop.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/backets")
@AllArgsConstructor
public class BacketClass {

    private final BacketService backetService;
    private final ItemService itemService;

    @PostMapping("/createBacket")
    public Backet createBacket(@RequestBody List<BacketItem> items) {
        Backet backet = Backet.builder()
                .backetItems(items)
                .build();
        return backetService.createBacket(backet);
    }

    @PostMapping("/createItem")
    public Item createItem(@RequestBody ItemRequest req) {
        Item item = Item.builder()
                .name(req.getName())
                .title(req.getTitle())
                .price(req.getPrice())
                .build();

        return itemService.createItem(item);
    }

    @GetMapping("/readItem")
    public List<Item> findAllItem() {
        return itemService.findAllItem();
    }
}
