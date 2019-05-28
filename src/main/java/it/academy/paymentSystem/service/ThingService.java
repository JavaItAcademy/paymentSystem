package it.academy.paymentSystem.service;

import it.academy.paymentSystem.model.Thing;

import java.util.List;

public interface ThingService {
    Thing addThing(Thing t);
    List<Thing> getAllThings();
    Thing getThingById(Long id);
}
