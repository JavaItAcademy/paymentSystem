package it.academy.paymentSystem.controller;

import it.academy.paymentSystem.model.Payment;
import it.academy.paymentSystem.service.PaymentService;
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
    private boolean confirmPayment(@RequestBody Confirmation confirmation){
        return paymentService.confirmPayment(confirmation.getId(), confirmation.getConfirmationCode());
    }


}

class Confirmation{
    private Long id;
    private Integer confirmationCode;

    public Confirmation(Long id, Integer confirmationCode) {
        this.id = id;
        this.confirmationCode = confirmationCode;
    }

    public Confirmation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
