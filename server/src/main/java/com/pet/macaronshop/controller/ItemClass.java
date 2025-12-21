package com.pet.macaronshop.controller;
import com.pet.macaronshop.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.pet.macaronshop.service.ItemService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class ItemClass {

    private final ItemService itemService;

    @PostMapping(
            value = "/createItem",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public Item createItem(
            @RequestParam("name") String name,
            @RequestParam("title") String title,
            @RequestParam("price") Integer price,
            @RequestParam(value = "images", required = false) MultipartFile[] images
    ) throws IOException {

        List<String> imageNames = new ArrayList<>();

        if (images != null) {
            String uploadDir = new File("server/src/main/resources/static/").getAbsolutePath();
            Files.createDirectories(Paths.get(uploadDir));

            for (MultipartFile file : images) {
                if (!file.isEmpty()) {
                    String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
                    String randomFileName = UUID.randomUUID().toString()
                            + (extension != null ? "." + extension : "");

                    Path filePath = Paths.get(uploadDir, randomFileName);
                    Files.write(filePath, file.getBytes());

                    imageNames.add(randomFileName);
                }
            }
        }

        Item item = Item.builder()
                .name(name)
                .title(title)
                .price(price)
                .images(imageNames)
                .build();

        return itemService.createItem(item);
    }


    @GetMapping("/findItem/{itemId}")
    public Item findItemById(@PathVariable Long itemId) {
        return itemService.findItemById(itemId);
    }

    @GetMapping("/readItem")
    public List<Item> findAllItem() {
        return itemService.findAllItem();
    }
}
