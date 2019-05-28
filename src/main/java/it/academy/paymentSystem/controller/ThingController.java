package it.academy.paymentSystem.controller;

import it.academy.paymentSystem.model.Client;
import it.academy.paymentSystem.model.Payment;
import it.academy.paymentSystem.model.Thing;
import it.academy.paymentSystem.service.ClientService;
import it.academy.paymentSystem.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/things")
public class ThingController {
    @Autowired
    private ThingService thingService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    private List<Thing> getAllThings(){
        return thingService.getAllThings();
    }

    @GetMapping("/{id}")
    private Thing getOneThing(@PathVariable Long id){
        return thingService.getThingById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Thing addThing(@RequestBody Thing t){
        return thingService.addThing(t);
    }

}
