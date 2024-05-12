package com.example.paymentservicesst.paymentgateways;

import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StripePaymentGateway implements PaymentGateway{
    @Value("${stripe.key.secret}")
    private String stripeKeyId;
    @Value("${stripe.key.secret}")
    private String stripeKeySecret;
    public String generatePaymentLink(Long orderId,String email) throws Exception{

        Stripe.apiKey = stripeKeySecret;
        Map<String, Object> productParams = new HashMap<>();
        productParams.put("name", "Product");
        Product product = Product.create(productParams);

        Map<String, Object> priceParams = new HashMap<>();
        priceParams.put("currency", "inr");
        priceParams.put("unit_amount", 1000);
        priceParams.put("product", product.getId());
        Price price = Price.create(priceParams);

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.toString();
    }
}
