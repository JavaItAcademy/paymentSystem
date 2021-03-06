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

    //TODO add Response as return object
    @GetMapping("/client/{id}")
    private List<Payment> getAllPayments(@PathVariable Long id, @RequestHeader String passCode){
        return paymentService.getAllPayments(id, passCode);
    }

    @GetMapping("/{id}")
    private Payment getOnePayment(@PathVariable Long id, @RequestHeader String passCode){
        return paymentService.getPaymentById(id, passCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Payment addPayment(@RequestBody Payment c){
        return paymentService.addPayment(c);
    }

    @PostMapping("/confirm")
    @ResponseStatus(HttpStatus.OK)
    private Response confirmPayment(@RequestBody Confirmation confirmation, @RequestHeader String passCode){
        try{
            return new Response(
                    paymentService.confirmPayment(confirmation.getId(), confirmation.getConfirmationCode()),
                    "Successfully confirmed",
                    this.getOnePayment(confirmation.getId(), passCode));

        } catch (Exception ex) {
            return new Response(false, ex.toString(), null);
        }
        //return paymentService.confirmPayment(confirmation.getId(), confirmation.getConfirmationCode());
    }


}

