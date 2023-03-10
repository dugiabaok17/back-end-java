package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
@Data
public class ProductDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "warranty_year")
    private Integer warrantyYear;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "import_prices")
    private BigDecimal importPrices;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "producer_id",nullable = false)
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "color_id",nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "productDetails")
    private Set<BillDetails> listBillDetails;

}
