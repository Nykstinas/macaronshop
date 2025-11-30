package com.pet.macaronshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item  {

    private Long itemId;
    private String name;
    private String title;
    private Integer price;
}
