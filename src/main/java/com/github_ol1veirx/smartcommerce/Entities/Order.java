package com.github_ol1veirx.smartcommerce.Entities;

import com.github_ol1veirx.smartcommerce.Enum.OrderStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {}

    public Order(Instant moment, UUID id, OrderStatus status, User client) {
        this.moment = moment;
        this.id = id;
        this.status = status;
        this.client = client;
    }
}
