package main.com.wd.payroll.integration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.com.wd.payroll.integration.exception.BadDataException;
import main.com.wd.payroll.integration.model.Payment;
import main.com.wd.payroll.integration.util.PaymentType;

public class PaymentController {

    public Boolean initPayment(String input) {
        if ("abc".equalsIgnoreCase(input)) {
            return true;
        }
        return false;
    }

    public Map<PaymentType, Integer> getTotalPayment(List<Payment> payments) {

        Map<PaymentType, Integer> paymentTypeToAmount = new HashMap<>();

        if (payments == null || payments.size() == 0) {
            throw new BadDataException("payments data collection is either null or empty");
        }
        else {
            for (Payment payment : payments) {
                if (paymentTypeToAmount.containsKey(payment.getPaymentType())) {
                    paymentTypeToAmount.put(payment.getPaymentType(),
                            paymentTypeToAmount.get(payment.getPaymentType()) + payment.getAmount());
                }
                else {
                    paymentTypeToAmount.put(payment.getPaymentType(), payment.getAmount());
                }
            }
        }

        return paymentTypeToAmount;
    }

}
