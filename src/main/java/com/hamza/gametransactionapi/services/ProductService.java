package com.hamza.gametransactionapi.services;

import com.hamza.gametransactionapi.models.Product;
import com.hamza.gametransactionapi.models.Transaction;
import com.hamza.gametransactionapi.repositories.ProductRepo;
import com.hamza.gametransactionapi.repositories.TransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepoRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepoRepo = productRepo;
    }
    public Product saveProduct(Product product){
        return productRepoRepo.save(product);
    }
}
