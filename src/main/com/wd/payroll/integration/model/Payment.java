package main.com.wd.payroll.integration.model;

import main.com.wd.payroll.integration.util.PaymentType;

public class Payment {

    private PaymentType paymentType;
    private Integer amount;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
