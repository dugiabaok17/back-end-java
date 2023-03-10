package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
@Data
public class Bill {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_of_payment")
    private Date dateOfPayment;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "date_of_receipt_of_goods")
    private Date dateOfReceiptOfGoods;

    @Column(name = "status")
    private Integer status;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff Staff;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private Set<BillDetails> listBillDetails;

}
