package com.ravi.orderservice.dto;

import lombok.Data;

/**
 * @author Ravi Verma at 03/08/20 2:44 PM
 */
@Data
public class PaymentDetails {
    String id;
    String order_id;
    String status;
}
