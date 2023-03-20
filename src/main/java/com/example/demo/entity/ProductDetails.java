package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
@Data
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;
//
//    @Column(name = "warranty_year")
    private Integer warrantyYear;

//    @Column(name = "description")
    private String description;

//    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

//    @Column(name = "import_prices")
    private BigDecimal importPrices;

//    @Column(name = "price")
    private BigDecimal price;

//    @Column(name = "date_created")
    private Date dateCreated;

//    @Column(name = "date_updated")
    private Date dateUpdated;

    private Long productId;

    private Long producerId;

    private Long colorId;

    private Long categoryId;

    private Integer status;
//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
//    private Product product;
//
//    @ManyToOne
//    @JoinColumn(name = "producer_id", nullable = false)
//    private Producer producer;
//
//    @ManyToOne
//    @JoinColumn(name = "color_id", nullable = false)
//    private Color color;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category category;
//
//    @OneToMany(mappedBy = "productDetails")
//    private Set<BillDetails> listBillDetails;

}
