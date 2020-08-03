package com.ravi.orderservice.dto;

import lombok.Data;

/**
 * @author Ravi Verma at 03/08/20 3:34 PM
 */
@Data
public class CustomerRazorPay {
    private String id;

    private String name;

    private String email;

    private String contact;

    private String gstin;

    private String billing_address;

    private String shipping_address;

    private String customer_name;

    private String customer_email;

    private String customer_contact;
}
