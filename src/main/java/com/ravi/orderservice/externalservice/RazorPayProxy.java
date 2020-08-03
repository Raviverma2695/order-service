package com.ravi.orderservice.externalservice;

import com.google.gson.Gson;
import com.ravi.orderservice.dto.CustomerRazorPay;
import com.ravi.orderservice.dto.PaymentRequestRazorPay;
import com.ravi.orderservice.dto.PaymentResponseRazorPay;
import lombok.extern.java.Log;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @author Ravi Verma at 03/08/20 2:42 PM
 */
@Service
@Log
public class RazorPayProxy {
    @Autowired
    private RestTemplate restTemplate;
    private Gson gson = new Gson();

    public PaymentResponseRazorPay generatePaymentLink(Integer amount) {
        String url = "https://api.razorpay.com/v1/invoices";
        String body = createBody(amount);
        HttpHeaders basicAuthHeaders = createBasicAuthHeaders();
        basicAuthHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(body, basicAuthHeaders);
        PaymentResponseRazorPay paymentDetails = null;
        try {
            ResponseEntity<PaymentResponseRazorPay> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, PaymentResponseRazorPay.class);
            System.out.println(responseEntity);
//            String jpay = responseEntity.getBody();
            paymentDetails = responseEntity.getBody();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return paymentDetails;

    }

    private String createBody(Integer amount) {
        CustomerRazorPay customerRazorPay = new CustomerRazorPay();
        customerRazorPay.setName("Ravi");
        customerRazorPay.setEmail("Ravi@gmail.com");
        customerRazorPay.setContact("9989990077");
        PaymentRequestRazorPay paymentRequest = new PaymentRequestRazorPay();
        paymentRequest.setCustomer(customerRazorPay);

        paymentRequest.setType("link");
        paymentRequest.setView_less(1);
        paymentRequest.setAmount(amount);
        paymentRequest.setCurrency("INR");
        paymentRequest.setDescription("Payment Link for this purpose - cvb.");
        paymentRequest.setReceipt("TS98");
        paymentRequest.setReminder_enable(true);
        paymentRequest.setSms_notify(1);
        paymentRequest.setEmail_notify(1);
        paymentRequest.setExpire_by(1793630556);
        paymentRequest.setCallback_url("https://example-callback-url.com");
        paymentRequest.setCallback_method("get");
//        paymentRequest.setCustomer(customerRazorPay);
//        paymentRequest.setCustomer(customerRazorPay);
//        paymentRequest.setCustomer(customerRazorPay);
//        paymentRequest.setCustomer(customerRazorPay);


        return gson.toJson(paymentRequest);
    }

    HttpHeaders createBasicAuthHeaders() {
        return new HttpHeaders() {{
            String auth = "rzp_test_Toye7b7E9HDQjz" + ":" + "hM0nSbMg0beKlDKWwqZ3QhDg";
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(StandardCharsets.US_ASCII));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}
