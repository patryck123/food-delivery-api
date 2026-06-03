package com.patryck.food.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Entity @Table(name = "orders") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String customerName;
    @Column(nullable = false) private String customerPhone;
    @Column(nullable = false) private String deliveryAddress;
    @ManyToMany @JoinTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<MenuItem> items;
    @Column(nullable = false, precision = 10, scale = 2) private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING) @Builder.Default private OrderStatus status = OrderStatus.PENDING;
    private String notes;
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
}
