package it.academy.paymentSystem.controller;

import it.academy.paymentSystem.model.Payment;
import it.academy.paymentSystem.model.Response;
import it.academy.paymentSystem.service.PaymentService;
import it.academy.paymentSystem.utils.Confirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    private List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    private Payment getOnePayment(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Payment addPayment(@RequestBody Payment c){
        return paymentService.addPayment(c);
    }

    @PostMapping("/confirm")
    @ResponseStatus(HttpStatus.OK)
    private Response confirmPayment(@RequestBody Confirmation confirmation){
        try{
            return new Response(paymentService.confirmPayment(confirmation.getId(), confirmation.getConfirmationCode()), "Successfully confirmed", this.getOnePayment(confirmation.getId()));

        } catch (Exception ex) {
            return new Response(false, ex.toString(), null);
        }
        //return paymentService.confirmPayment(confirmation.getId(), confirmation.getConfirmationCode());
    }


}

