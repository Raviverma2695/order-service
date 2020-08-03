package com.ravi.orderservice.dto;

/**
 * @author Ravi Verma at 03/08/20 3:29 PM
 */
public class PaymentRequestRazorPay {
    private CustomerRazorPay customer;

    private String type;

    private int view_less;

    private int amount;

    private String currency;

    private String description;

    private String receipt;

    private boolean reminder_enable;

    private int sms_notify;

    private int email_notify;

    private int expire_by;

    private String callback_url;

    private String callback_method;

    public void setCustomer(CustomerRazorPay customer) {
        this.customer = customer;
    }

    public CustomerRazorPay getCustomer() {
        return this.customer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setView_less(int view_less) {
        this.view_less = view_less;
    }

    public int getView_less() {
        return this.view_less;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceipt() {
        return this.receipt;
    }

    public void setReminder_enable(boolean reminder_enable) {
        this.reminder_enable = reminder_enable;
    }

    public boolean getReminder_enable() {
        return this.reminder_enable;
    }

    public void setSms_notify(int sms_notify) {
        this.sms_notify = sms_notify;
    }

    public int getSms_notify() {
        return this.sms_notify;
    }

    public void setEmail_notify(int email_notify) {
        this.email_notify = email_notify;
    }

    public int getEmail_notify() {
        return this.email_notify;
    }

    public void setExpire_by(int expire_by) {
        this.expire_by = expire_by;
    }

    public int getExpire_by() {
        return this.expire_by;
    }

    public void setCallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public String getCallback_url() {
        return this.callback_url;
    }

    public void setCallback_method(String callback_method) {
        this.callback_method = callback_method;
    }

    public String getCallback_method() {
        return this.callback_method;
    }
}

