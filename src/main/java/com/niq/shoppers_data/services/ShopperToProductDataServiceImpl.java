package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.ShopperShelf;
import com.niq.shoppers_data.model.ShopperToProduct;
import com.niq.shoppers_data.persistance.repositories.ProductRepository;
import com.niq.shoppers_data.persistance.repositories.ShopperToProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class ShopperToProductDataServiceImpl implements ShopperToProductDataService {
    private final Logger logger = Logger.getLogger(ShopperToProductDataServiceImpl.class.getName());
    private final ShopperToProductRepository shopperToProductRepository;
    private final ProductRepository productRepository;

    public ShopperToProductDataServiceImpl(ShopperToProductRepository shopperToProductRepository, ProductRepository productRepository) {
        this.shopperToProductRepository = shopperToProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void saveShopperProductsData(List<ShopperShelf> shopperShelfList) {
        Set<String> allProductIds = productRepository.getAllProductIds();

        List<ShopperToProduct> shopperToProductList = new ArrayList<>();
        for (ShopperShelf shopperShelf : shopperShelfList) {
            String shopperId = shopperShelf.getShopperId();
            for (int i = 0; i < shopperShelf.getShelf().size(); i++) {
                if (!allProductIds.contains(shopperShelf.getShelf().get(i).getProductId())) {
                    logger.warning("Product with id " + shopperShelf.getShelf().get(i).getProductId() + " does not exist in the database");
                    continue;
                }

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
