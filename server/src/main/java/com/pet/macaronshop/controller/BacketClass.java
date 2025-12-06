package com.pet.macaronshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.model.BacketItem;
import com.pet.macaronshop.service.BacketService;

import java.util.List;

@RestController
@RequestMapping("/api/backets")
@AllArgsConstructor
public class BacketClass {

    private final BacketService service;

    @PostMapping("/createBacket")
    public Backet createBacket(@RequestBody List<BacketItem> items) {
        Backet backet = Backet.builder()
                .backetItems(items)
                .build();
        return service.createBacket(backet);
    }
}
