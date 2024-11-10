package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "\"Order Details\"")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @MapsId("orderID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "OrderID", nullable = false)
    private entities.Order orderID;

    @MapsId("productID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProductID", nullable = false)
    private entities.Product productID;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Quantity", nullable = false)
    private Short quantity;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "Discount", nullable = false)
    private Float discount;

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    public entities.Order getOrderID() {
        return orderID;
    }

    public void setOrderID(entities.Order orderID) {
        this.orderID = orderID;
    }

    public entities.Product getProductID() {
        return productID;
    }

    public void setProductID(entities.Product productID) {
        this.productID = productID;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

}