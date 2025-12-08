package com.pet.macaronshop.service;

import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.model.BacketItem;
import com.pet.macaronshop.model.Item;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BacketService {
    @Transactional
    Backet createBacket(Backet backet);

    @Transactional
    Backet updateBacket(Long backetId, List<BacketItem> items);
}

