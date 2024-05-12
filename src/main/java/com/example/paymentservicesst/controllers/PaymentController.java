package com.example.paymentservicesst.controllers;

import com.example.paymentservicesst.dtos.InitiatePaymentRequestDto;
import com.example.paymentservicesst.services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController
{
    private final PaymentService paymentService;
    PaymentController( PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }
    @PostMapping("/")
        public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws Exception
        {
           return paymentService.initiatePayment(requestDto.getOrderId(),requestDto.getEmail());
        }
}
