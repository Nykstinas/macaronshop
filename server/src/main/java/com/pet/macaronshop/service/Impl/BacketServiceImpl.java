package com.pet.macaronshop.service.Impl;

import com.pet.macaronshop.model.BacketItem;
import com.pet.macaronshop.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.repository.BacketRepository;
import com.pet.macaronshop.service.BacketService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class BacketServiceImpl implements BacketService {

    private final BacketRepository backetRepository;

    @Override
    @Transactional
    public Backet createBacket(Backet backet) {
        return backetRepository.save(backet);
    }


    @Transactional
    public Backet updateBacket(Long backetId, List<BacketItem> items) {
        Backet existing = backetRepository.findById(backetId)
                .orElseThrow(() -> new RuntimeException("Backet not found"));
        existing.setBacketItems(items);
        return backetRepository.save(existing);
    }
}
