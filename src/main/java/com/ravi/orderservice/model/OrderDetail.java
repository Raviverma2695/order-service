package com.ravi.orderservice.model;

import com.ravi.orderservice.enums.OrderStatus;
import com.ravi.orderservice.enums.PaymentStatus;
import com.ravi.orderservice.enums.ProductType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ravi Verma at 01/08/20 10:50 PM
 */
@Entity
@Table(name = "order_detail")
@Data
public class OrderDetail extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductType productType;

    @Column(name = "is_notified")
    private Boolean isNotified;

    @Column(name = "is_payment_failed")
    private Boolean isPaymentFailed;


    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;


    @Column(name = "txn_req_id")
    private String txnReqId;

}