package com.niq.shoppers_data.controllers;

import com.niq.shoppers_data.model.Product;
import com.niq.shoppers_data.model.ShopperShelf;
import com.niq.shoppers_data.services.ProductsService;
import com.niq.shoppers_data.services.ShopperToProductDataService;
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
    public void saveShopperProductsData(@RequestBody List<ShopperShelf> shopperShelfList) {
         shopperToProductDataService.saveShopperProductsData(shopperShelfList);
     }

     @PostMapping("/saveProducts")
        public void saveProducts(@RequestBody List<Product> productList) {
            productsService.saveProductList(productList);
        }
}
