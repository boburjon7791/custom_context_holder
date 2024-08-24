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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "payment")
@EntityListeners(AuditingEntityListener.class)
public class Payment extends BaseEntityUUID {
    @Column(nullable = false)
    private BigDecimal payment;

    @Column(nullable = false)
    private Boolean success;

    @Column(nullable = false, name = "cashier_name")
    private String cashierName;

    public static final String _payment="payment";
    public static final String _success="success";
    public static final String _cashierName="cashierName";
}
