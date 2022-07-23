package com.example.springlearnonbook.web.restcontroller;

import com.example.springlearnonbook.domain.Taco;
import com.example.springlearnonbook.domain.TacoOrder;
import com.example.springlearnonbook.web.repository.OrderRepository;
import com.example.springlearnonbook.web.repository.TacoRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8087")
public class TacoController {

    private TacoRepository tacoRepository;
    private OrderRepository orderRepository;

    @GetMapping(params = "recent")
    public Iterable<Taco> findAll(){
        PageRequest pageRequest = PageRequest.of(
                0, 12, Sort.by("createdAt").descending()
        );
        return tacoRepository.findAll(pageRequest).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> findDyId(@PathVariable("id") Long id){
        Optional<Taco> taco = tacoRepository.findById(id);
        return taco.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)
                ).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return tacoRepository.save(taco);
    }

    @PutMapping(path="/{orderId}", consumes="application/json")
    public TacoOrder putOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody TacoOrder order) {
        order.setId(orderId);
        return orderRepository.save(order);
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("id") Long id,
                              @RequestBody TacoOrder patch){
        TacoOrder order = orderRepository.findById(id).get();
        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long id){
        try{
            orderRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){

        }
    }
}
