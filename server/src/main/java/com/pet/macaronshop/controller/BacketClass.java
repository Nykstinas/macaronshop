package com.pet.macaronshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.model.BacketItem;
import com.pet.macaronshop.service.BacketService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/backet")
@AllArgsConstructor
public class BacketClass {

    private final BacketService backetService;

    @PostMapping("/createBacket")
    public Backet createBacket(@RequestBody List<BacketItem> items) {
        Backet backet = Backet.builder()
                .backetItems(items)
                .build();
        return backetService.createBacket(backet);
    }

}
