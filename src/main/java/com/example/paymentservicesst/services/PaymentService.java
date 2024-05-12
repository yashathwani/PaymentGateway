package com.example.paymentservicesst.services;

import com.example.paymentservicesst.paymentgateways.PaymentGateway;
import com.example.paymentservicesst.paymentgateways.StripePaymentGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentGateway paymentGateway;
    PaymentService( StripePaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    public String initiatePayment(Long orderId,String email) throws Exception{
        return paymentGateway.generatePaymentLink(orderId,email);
    }
}
