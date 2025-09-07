package com.wiproo.order_ms.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.wiproo.order_ms.service.PaymentConnectService;

import com.wiproo.order_ms.dto.*;
import com.wiproo.order_ms.entity.*;
import com.wiproo.order_ms.repo.*;
import com.wiproo.order_ms.service.*;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
	RestTemplate restTemplate;
    
    @Autowired
	PaymentConnectService paymentConnectService;

    @Override
    public void save(Order order) {
        order.setOrderStatus("I");
        orderRepo.save(order);
        
       // RestTemplate  rest= new RestTemplate();
		//String url="http://localhost:9012/payment";
        String url="http://paymentms/payment";
        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setPaymentAmount(order.getOrderValue());
        payment.setPaymentStatus(true);

        try {
        //	ResponseEntity<Payment>   response= restTemplate.postForEntity(url, payment, Payment.class);
        	
        ResponseEntity<Payment> response = paymentConnectService.savePaymentData(payment);

        if (response.getStatusCode()== HttpStatusCode.valueOf(200)) {
            order.setOrderStatus("P");
        } 
        }catch(Exception ex){
        	order.setOrderStatus("C");
        }
        orderRepo.save(order);
    }

//    @Override
//    public List<Order> findAll() {
//        return orderRepo.findAll();
//    }
    
    @Override
    public List<OrderResponse> findAll() {
        List<Order> orders = orderRepo.findAll();
        List<OrderResponse> responses = new ArrayList<>();
        System.out.println("findall");
        for (Order order : orders) {
            String url = "http://paymentms/payment/order/" + order.getId();
            
            Payment payment = null;
            try {
            //	ResponseEntity<Payment> response = paymentConnectService.findPaymentByOrderId(order.getId());
                payment = restTemplate.getForObject(url, Payment.class);
            } catch (Exception e) {
                System.out.println("Payment service not available for orderId: " + order.getId());
            }
            
            OrderResponse response = new OrderResponse();
            response.setOrder(order);
            response.setPayment(payment);
            responses.add(response);
        }

        return responses;
    }

  
   
}