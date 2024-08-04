package com.niq.shoppers_data.controllers;

import com.niq.shoppers_data.model.ProductByShopper;
import com.niq.shoppers_data.services.ProductsByShopperService;
import com.niq.shoppers_data.services.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/external")
public class ExternalECommerceController {
    private final ProductsByShopperService productsByShopperService;
    private final ProductsService productsService;

    public ExternalECommerceController(ProductsByShopperService productsByShopperService, ProductsService productsService) {
        this.productsByShopperService = productsByShopperService;
        this.productsService = productsService;
    }

    @GetMapping("/productsByShopper")
    public List<ProductByShopper> getProductsByShopper(@RequestParam("shopperId") String shopperId,
                                                       @RequestParam(value = "category", required = false) String category,
                                                       @RequestParam(value = "brand", required = false) String brand,
                                                       @RequestParam(value = "limit", defaultValue = "10") int limit) {
        return productsByShopperService.getProductsByShopper(shopperId, category, brand, limit);
    }

    @GetMapping("/categories")
    public Set<String> getCategories() {
        return productsService.getAllCategories();
    }

    @GetMapping("/brands")
    public Set<String> getBrands() {
        return productsService.getAllBrands();
    }
}
