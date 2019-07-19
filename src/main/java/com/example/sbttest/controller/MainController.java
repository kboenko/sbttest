package com.example.sbttest.controller;

import com.example.sbttest.entity.*;
import com.example.sbttest.repository.PeriodRepository;
import com.example.sbttest.repository.ProductRepository;
import com.example.sbttest.repository.PurchaseRepository;
import com.example.sbttest.repository.UnitRepository;
import com.example.sbttest.services.PeriodService;
import com.example.sbttest.services.ProductService;
import com.example.sbttest.services.PurchaseService;
import com.example.sbttest.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private PeriodService periodService;

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String login() {
        System.out.println("SUCCESS!");
        return "test!";
    }

    @RequestMapping(value="/purchase/list", method = RequestMethod.GET)
    public @ResponseBody List<Purchase> purchaseList() {
        return purchaseService.getList();
    }

    @RequestMapping(value="/purchase/{id}", method = RequestMethod.GET)
    public @ResponseBody Purchase getPurchaseById (@PathVariable("id") Long purchaseId) {
        return purchaseService.getPurchaseById(purchaseId);
    }

    @RequestMapping(value="/purchase/period/remove/{id}", method = RequestMethod.GET)
    public @ResponseBody String setNonPeriodical (@PathVariable("id") Long purchaseId) {
        Purchase purchase = purchaseService.getPurchaseById(purchaseId);
        purchase.setPeriodQty(null);
        return purchaseService.savePurchase(purchase);
    }

    @PostMapping(path= "/purchase/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(
            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", defaultValue = "ASIA") String headerLocation,
            @RequestBody MetaPurchase metaPurchase)

    {
        Product product = productService.getProductById(metaPurchase.getProductId());
        Unit unit = unitService.getUnitById(metaPurchase.getUnitId());
        Period period = periodService.getPeriodById(metaPurchase.getPeriodId());

        Purchase newPurchase = new Purchase();
        newPurchase.setProduct(product);
        newPurchase.setPurchaseDate(metaPurchase.getPurchaseDate());
        newPurchase.setPeriod(period);
        newPurchase.setPeriodQty(metaPurchase.getPeriodQty());
        newPurchase.setUnit(unit);
        newPurchase.setUnitQty(metaPurchase.getUnitQty());

        purchaseService.savePurchase(newPurchase);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPurchase.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
