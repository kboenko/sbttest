package com.example.sbttest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Покупка
 */

@Entity
@Table(name = "purchases")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Purchase {

    /**
     * id
     */
    private Long id;
    /**
     * Покупаемый продукт
     */
    private Product product;
    /**
     * Дата совершения покупки (может быть в будущем)
     */
    private Date purchaseDate;
    /**
     * Период, через который будет совершаться покупка (если требуется сделать покупку периодичной): день, неделя, месяц, год
     */
    private Period period;
    /**
     * Количество периодов, через которые будет совершаться покупка (если она периодичная). Для разовых покупок не задается
     */
    private Integer periodQty;
    /**
     * Единица измерения покупки (шт, кг, г, л)
     */
    private Unit unit;
    /**
     * Количество покупаемых единиц измерения
     */
    private Integer unitQty;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @MapsId
    @JsonManagedReference
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "purchasedate")
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @MapsId
    @JsonManagedReference
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Column(name = "periodqty")
    public Integer getPeriodQty() {
        return periodQty;
    }

    public void setPeriodQty(Integer periodQty) {
        this.periodQty = periodQty;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @MapsId
    @JsonManagedReference
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Column(name = "unitqty")
    public Integer getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(Integer unitQty) {
        this.unitQty = unitQty;
    }
}
