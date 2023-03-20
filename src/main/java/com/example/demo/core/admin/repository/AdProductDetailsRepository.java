package com.example.demo.core.admin.repository;

import com.example.demo.core.admin.model.response.ProductDetailsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdProductDetailsRepository extends JpaRepository<ProductDetailsResponse,Long> {

    @Query(value = "SELECT p.id, p.description, p.import_prices, p.price, p.quantity_in_stock, p.warranty_year, \n" +
            "c.name as color_name, ca.name as category_name, product.name as product_name, producer.name as producer_name\n" +
            "FROM asm_java4.product_details p \n" +
            "left join color c on p.color_id = c.id \n" +
            "left join category ca on ca.id = p.category_id\n" +
            "left join product on product.id = p.product_id\n" +
            "left join producer  on producer.id = p.producer_id where p.status = 1",nativeQuery = true)
    List<ProductDetailsResponse> findAllProductDetailsResponse();


}
