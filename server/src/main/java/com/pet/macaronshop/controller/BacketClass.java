package com.pet.macaronshop.controller;

import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.model.BacketItem;
import com.pet.macaronshop.repository.InMemoryBacketDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backets")
public class BacketClass {

    private final InMemoryBacketDAO backetDAO;

    public BacketController(InMemoryBacketDAO backetDAO) {
        this.backetDAO = backetDAO;
    }

    // Получить все корзины
    @GetMapping
    public List<Backet> getAllBackets() {
        return backetDAO.findAllBackets();
    }

    // Найти корзину по ID
    @GetMapping("/{id}")
    public ResponseEntity<Backet> getBacketById(@PathVariable Long id) {
        Backet backet = backetDAO.findById(id);
        if (backet != null) return ResponseEntity.ok(backet);
        return ResponseEntity.notFound().build();
    }

    // Создать новую корзину
    @PostMapping
    public Backet createBacket(@RequestBody Backet backet) {
        return backetDAO.saveBacket(backet);
    }

    // Удалить корзину
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBacket(@PathVariable Long id) {
        backetDAO.deleteBacket(id);
        return ResponseEntity.noContent().build();
    }

    // Добавить элемент в корзину
    @PostMapping("/{id}/items")
    public ResponseEntity<BacketItem> addItem(
            @PathVariable Long id,
            @RequestBody BacketItem item) {

        BacketItem added = backetDAO.addItemToBacket(id, item);
        if (added != null) return ResponseEntity.ok(added);
        return ResponseEntity.notFound().build();
    }

    // Удалить элемент из корзины
    @DeleteMapping("/{id}/items/{itemId}")
    public ResponseEntity<Void> removeItem(
            @PathVariable Long id,
            @PathVariable Long itemId) {

        boolean removed = backetDAO.removeItemFromBacket(id, itemId);
        if (removed) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    // Обновить количество элемента
    @PutMapping("/{id}/items/{itemId}")
    public ResponseEntity<Void> updateItemQuantity(
            @PathVariable Long id,
            @PathVariable Long itemId,
            @RequestParam int quantity) {

        boolean updated = backetDAO.updateItemQuantity(id, itemId, quantity);
        if (updated) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
