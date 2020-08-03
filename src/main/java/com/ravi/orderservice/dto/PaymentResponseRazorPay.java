package com.ravi.orderservice.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Ravi Verma at 03/08/20 4:18 PM
 */
@Data
public class PaymentResponseRazorPay {
    private String id;

    private String entity;

    private String receipt;

    private String invoice_number;

    private String customer_id;

    private CustomerRazorPay customer_details;

    private String order_id;

    private List<String> line_items;

    private String payment_id;

    private String status;

    private int expire_by;

    private int issued_at;

    private String paid_at;

    private String cancelled_at;

    private String expired_at;

    private String sms_status;

    private String email_status;

    private int date;

    private String terms;

    private boolean partial_payment;

    private int gross_amount;

    private int tax_amount;

    private int taxable_amount;

    private int amount;

    private int amount_paid;

    private int amount_due;

    private String currency;

    private String description;

    private List<String> notes;

    private String comment;

    private String short_url;

    private boolean view_less;

    private String billing_start;

    private String billing_end;

    private String type;

    private boolean group_taxes_discounts;

    private int created_at;

}
