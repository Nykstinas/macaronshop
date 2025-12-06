package com.pet.macaronshop.service.Impl;

import com.pet.macaronshop.model.BacketItem;
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

    private final BacketRepository repository;

    @Override
    @Transactional
    public Backet createBacket(Backet backet) {
        return repository.save(backet);
    }


    @Transactional
    public Backet updateBacket(Long backetId, List<BacketItem> items) {
        Backet existing = repository.findById(backetId)
                .orElseThrow(() -> new RuntimeException("Backet not found"));
        existing.setBacketItems(items);
        return repository.save(existing);
    }
}
