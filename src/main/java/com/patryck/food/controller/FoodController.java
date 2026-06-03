package com.patryck.food.controller;
import com.patryck.food.entity.*;
import com.patryck.food.repository.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
@RestController @RequiredArgsConstructor
@Tag(name = "Food Delivery", description = "Pedidos e cardápio")
public class FoodController {
    private final MenuItemRepository menuRepo;
    private final OrderRepository orderRepo;
    @GetMapping("/api/menu") public ResponseEntity<List<MenuItem>> getMenu() { return ResponseEntity.ok(menuRepo.findByAvailableTrue()); }
    @GetMapping("/api/menu/category/{cat}") public ResponseEntity<List<MenuItem>> byCategory(@PathVariable String cat) { return ResponseEntity.ok(menuRepo.findByCategory(cat)); }
    @PostMapping("/api/menu") public ResponseEntity<MenuItem> addItem(@RequestBody MenuItem item) { return ResponseEntity.status(HttpStatus.CREATED).body(menuRepo.save(item)); }
    @PostMapping("/api/orders") public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        BigDecimal total = order.getItems().stream().map(i -> menuRepo.findById(i.getId()).map(MenuItem::getPrice).orElse(BigDecimal.ZERO)).reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalAmount(total);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderRepo.save(order));
    }
    @GetMapping("/api/orders") public ResponseEntity<List<Order>> getOrders() { return ResponseEntity.ok(orderRepo.findAll()); }
    @GetMapping("/api/orders/status/{status}") public ResponseEntity<List<Order>> byStatus(@PathVariable OrderStatus status) { return ResponseEntity.ok(orderRepo.findByStatus(status)); }
    @PatchMapping("/api/orders/{id}/status") public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return orderRepo.findById(id).map(o -> { o.setStatus(status); return ResponseEntity.ok(orderRepo.save(o)); }).orElse(ResponseEntity.notFound().build());
    }
}
