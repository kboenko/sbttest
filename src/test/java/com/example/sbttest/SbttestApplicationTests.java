package com.example.sbttest;

import com.example.sbttest.entity.Period;
import com.example.sbttest.entity.Product;
import com.example.sbttest.entity.Purchase;
import com.example.sbttest.entity.Unit;
import com.example.sbttest.repository.PurchaseRepository;
import com.example.sbttest.services.PeriodService;
import com.example.sbttest.services.ProductService;
import com.example.sbttest.services.PurchaseService;
import com.example.sbttest.services.UnitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbttestApplicationTests {

	@Test
	public void contextLoads() {
	}

	@MockBean
	private PurchaseRepository purchaseRepository;

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UnitService unitService;

	@Autowired
	private PeriodService periodService;


	@Test
	public void testGetPurchaseById() {
		Purchase purchase = purchaseService.getPurchaseById(1L);
		assertThat(purchase.getId()).isEqualTo(1L);
	}

	@Test
	public void testGetPurchasesList() {
		List<Purchase> purchaseList = purchaseService.getList();
		assertThat(purchaseList.size() > 0);
	}

	@Test
	public void testGetProductById() {
		Product product = productService.getProductById(1L);
		assertThat(product.getId()).isEqualTo(1L);
		assertThat(product.getName()).isEqualTo("bread");
		assertThat(product.getPrice()).isEqualTo(30);
	}

	@Test
	public void testGetUniById() {
		Unit unit = unitService.getUnitById(1L);
		assertThat(unit.getId()).isEqualTo(1L);
		assertThat(unit.getName()).isEqualTo("itm");
	}

	@Test
	public void testGetPeriodById() {
		Period period = periodService.getPeriodById(1L);
		assertThat(period.getId()).isEqualTo(1L);
		assertThat(period.getName()).isEqualTo("day");
	}

}
