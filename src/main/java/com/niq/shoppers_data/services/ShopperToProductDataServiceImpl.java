package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.ShopperShelf;
import com.niq.shoppers_data.model.ShopperToProduct;
import com.niq.shoppers_data.persistance.repositories.ShopperToProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopperToProductDataServiceImpl implements ShopperToProductDataService {
    private final ShopperToProductRepository shopperToProductRepository;

    public ShopperToProductDataServiceImpl(ShopperToProductRepository shopperToProductRepository) {
        this.shopperToProductRepository = shopperToProductRepository;
    }

    @Override
    public void saveShopperProductsData(List<ShopperShelf> shopperShelfList) {
        List<ShopperToProduct> shopperToProductList = new ArrayList<>();
        for (ShopperShelf shopperShelf : shopperShelfList) {
            String shopperId = shopperShelf.getShopperId();
            for (int i = 0; i < shopperShelf.getShelf().size(); i++) {
                ShopperToProduct shopperToProduct = new ShopperToProduct();
                shopperToProduct.setShopperId(shopperId);
                shopperToProduct.setProductId(shopperShelf.getShelf().get(i).getProductId());
                shopperToProduct.setRelevancyScore(shopperShelf.getShelf().get(i).getRelevancyScore());
                shopperToProductList.add(shopperToProduct);
            }
        }
        shopperToProductRepository.saveOrUpdateShopperToProductList(shopperToProductList);
    }
}
