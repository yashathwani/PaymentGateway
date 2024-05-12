package com.example.paymentservicesst.paymentgateways;

import org.springframework.stereotype.Component;

@Component
public interface PaymentGateway {
    public String generatePaymentLink(Long orderId,String email) throws Exception;
}
