package it.academy.paymentSystem.service;

import it.academy.paymentSystem.model.Thing;
import it.academy.paymentSystem.repository.PaymentRepository;
import it.academy.paymentSystem.repository.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingServiceImpl implements ThingService {
    @Autowired
    private ThingRepository thingRepository;

    @Override
    public Thing addThing(Thing t) {
        return thingRepository.save(t);
    }

    @Override
    public List<Thing> getAllThings() {
        return thingRepository.findAll();
    }

    @Override
    public Thing getThingById(Long id) {
        return thingRepository.findById(id).get();
    }
}
