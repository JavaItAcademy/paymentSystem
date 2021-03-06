package it.academy.paymentSystem.service;

import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.model.Payment;
import it.academy.paymentSystem.enums.Status;
import it.academy.paymentSystem.repository.ClientRepository;
import it.academy.paymentSystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Payment addPayment(Payment p) {
        return this.paymentRepository.save(p);
    }

    @Override
    public List<Payment> getAllPayments() {
        return this.paymentRepository.findAll();
    }
    @Override
    public List<Payment> getAllPayments(Long id, String passCode) {
        return this.paymentRepository.getAllPaymentsByPassCode(id, passCode);
    }

    @Override
    public Payment getPaymentById(Long id, String passCode) {
        Payment payment = this.paymentRepository.findById(id).get();
        if (payment.getClient().getPassword().equals(passCode))
            return payment;
        return null;
    }

    private Payment getPaymentById(Long id) {
        return this.paymentRepository.findById(id).get();
    }

    @Override
    public boolean confirmPayment(Long id, Integer confirmationCode) {
        Payment p = getPaymentById(id);
        if (p == null) return false;
        if (p.getConfirmationCode().equals(confirmationCode)) {
            p.setStatus(Status.OK);
            this.paymentRepository.save(p);
            return true;
        }
        return false;
    }
}
