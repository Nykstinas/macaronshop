package com.pet.macaronshop.repository;

import org.springframework.stereotype.Repository;
import com.pet.macaronshop.model.Backet;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBacketDAO {

    private final List<Backet> BACKETS = new ArrayList<>();

    public List<Backet> findAllBacket() {
        return BACKETS;
    }

    public Backet saveBacket(Backet backet) {
        BACKETS.add(backet);
        return backet;
    }
}
