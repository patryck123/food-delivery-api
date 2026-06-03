package com.patryck.food.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Entity @Table(name = "menu_items") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MenuItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String name;
    @Column(columnDefinition = "TEXT") private String description;
    @Column(nullable = false, precision = 8, scale = 2) private BigDecimal price;
    @Column(nullable = false) private String category;
    @Builder.Default private Boolean available = true;
    private String imageUrl;
}
