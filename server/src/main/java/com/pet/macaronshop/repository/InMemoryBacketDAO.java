package com.pet.macaronshop.repository;

import com.pet.macaronshop.model.Item;
import com.pet.macaronshop.model.Backet;
import com.pet.macaronshop.model.BacketItem;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBacketDAO {

    private final DataSource dataSource;

    public InMemoryBacketDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final List<Backet> BACKETS = new ArrayList<>();

    public List<Backet> findAllBackets() {
        return BACKETS;
    }

    public Backet saveBacket(Backet backet) {
        BACKETS.add(backet);
        return backet;
    }

    public Item saveItem(Item item) throws SQLException {
        String sql = "INSERT INTO item (name, price) VALUES (?, ?)";

        // Берём соединение из DataSource
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getPrice());
            stmt.executeUpdate();

            // Получаем сгенерированный ID
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setItemId(rs.getLong(1));
                }
            }

            return item;
        }
    }


    public Backet findById(Long backetId) {
        return BACKETS.stream()
                .filter(b -> b.getBacketId().equals(backetId))
                .findFirst()
                .orElse(null);
    }

    public void deleteBacket(Long backetId) {
        var backet = findById(backetId);
        if (backet != null) {
            BACKETS.remove(backet);
        }
    }

    public BacketItem addItemToBacket(Long backetId, BacketItem item) {
        var backet = findById(backetId);
        if (backet != null) {
            if (backet.getBacketItems() == null) {
                backet.setBacketItems(new ArrayList<>());
            }

            // Если элемент уже есть — увеличиваем quantity
            backet.getBacketItems().stream()
                    .filter(i -> i.getItemId().equals(item.getItemId()))
                    .findFirst()
                    .ifPresentOrElse(
                            existing -> existing.setQuantity(existing.getQuantity() + item.getQuantity()),
                            () -> backet.getBacketItems().add(item)
                    );

            return item;
        }
        return null;
    }

    public boolean removeItemFromBacket(Long backetId, Long itemId) {
        var backet = findById(backetId);
        if (backet != null && backet.getBacketItems() != null) {
            return backet.getBacketItems().removeIf(i -> i.getItemId().equals(itemId));
        }
        return false;
    }

    public boolean updateItemQuantity(Long backetId, Long itemId, int quantity) {
        var backet = findById(backetId);
        if (backet != null && backet.getBacketItems() != null) {
            for (BacketItem item : backet.getBacketItems()) {
                if (item.getItemId().equals(itemId)) {
                    item.setQuantity(quantity);
                    return true;
                }
            }
        }
        return false;
    }
}
