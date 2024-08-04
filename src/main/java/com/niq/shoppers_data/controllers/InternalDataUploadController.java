package com.niq.shoppers_data.controllers;

import com.niq.shoppers_data.model.input.Product;
import com.niq.shoppers_data.model.input.SaveEntitiesResult;
import com.niq.shoppers_data.model.input.ShopperShelf;
import com.niq.shoppers_data.services.ProductsService;
import com.niq.shoppers_data.services.ShopperToProductDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/internal")
public class InternalDataUploadController {

    private final ProductsService productsService;
    private final ShopperToProductDataService shopperToProductDataService;

    public InternalDataUploadController(ProductsService productsService, ShopperToProductDataService shopperToProductDataService) {
        this.productsService = productsService;
        this.shopperToProductDataService = shopperToProductDataService;
    }

    @PostMapping("/saveShopperProductsData")
    public ResponseEntity<SaveEntitiesResult> saveShopperProductsData(@RequestBody List<ShopperShelf> shopperShelfList) {
        SaveEntitiesResult saveEntitiesResult = shopperToProductDataService.saveShopperProductsData(shopperShelfList);
        return ResponseEntity.ok(saveEntitiesResult);
    }

     @PostMapping("/saveProducts")
        public ResponseEntity<SaveEntitiesResult> saveProducts(@RequestBody List<Product> productList) {
         SaveEntitiesResult saveEntitiesResult = productsService.saveProductList(productList);
         return ResponseEntity.ok(saveEntitiesResult);
     }
}
