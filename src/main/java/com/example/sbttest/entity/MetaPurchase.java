package com.example.sbttest.entity;

import java.util.Date;

/**
 * Промежуточный объект для передачи данных о покупке POST-запросом
 */

public class MetaPurchase {

    private Long productId;
    private Date purchaseDate;
    private Long periodId;
    private Integer periodQty;
    private Long unitId;
    private Integer unitQty;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Integer getPeriodQty() {
        return periodQty;
    }

    public void setPeriodQty(Integer periodQty) {
        this.periodQty = periodQty;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Integer getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(Integer unitQty) {
        this.unitQty = unitQty;
    }
}
