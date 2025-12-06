package com.pet.macaronshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Backet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long backetId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "backet_id")
    private List<BacketItem> backetItems;
}
