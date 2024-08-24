package com.example.custom_context_holder.sub.model.entity;

import com.example.custom_context_holder.base.model.entity.BaseEntityUUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "reports")
@EntityListeners(AuditingEntityListener.class)
public class Report extends BaseEntityUUID {
    @Column(nullable = false, name = "unit_price")
    private BigDecimal unitPrice;

    @Column(nullable = false, name = "total_summa")
    private BigDecimal totalSumma;

    @Column(nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(nullable = false, name = "order_last_time")
    private LocalDateTime orderLastTime;

    public static final String _id="id";
    public static final String _createdAt="createdAt";
    public static final String _unitPrice="unitPrice";
    public static final String _totalSumma="totalSumma";
    public static final String _productName="productName";
    public static final String _quantity="quantity";
    public static final String _orderLastTime="orderLastTime";
}
