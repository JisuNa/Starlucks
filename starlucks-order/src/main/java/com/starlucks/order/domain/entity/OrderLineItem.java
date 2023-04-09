package com.starlucks.order.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_line_item")
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private String name;
    private String size;
    private Long price;
    @Column(insertable = false, updatable = false)
    private LocalDateTime createDtm;
    @Column(insertable = false, updatable = false)
    private LocalDateTime updateDtm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    private Order order;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderLineItem")
    private List<OrderOptionGroup> orderOptionGroups = List.of();

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDateTime getCreateDtm() {
        return createDtm;
    }

    public LocalDateTime getUpdateDtm() {
        return updateDtm;
    }

    public Order getOrder() {
        return order;
    }

    public List<OrderOptionGroup> getOrderOptionGroups() {
        return orderOptionGroups;
    }
}
