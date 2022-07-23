package com.example.springlearnonbook.webflux.reactiverestcontroller;
/*
import com.example.springlearnonbook.domain.Taco;
import com.example.springlearnonbook.webflux.reactiverepository.TacoReactiveRepository;
import lombok.AllArgsConstructor;
import org.apache.el.stream.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/fluxtacos", produces = "application/json")
public class FluxTacoController {

    private TacoReactiveRepository tacoRepository;

    @GetMapping(params = "recent")
    public Flux<Taco> recentTaco(){
        return tacoRepository.findAll().take(5);
    }

    @GetMapping("/{id}")
    public Mono<Taco> tacoById(@PathVariable("id") Long id){
        return tacoRepository.findById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> save(@RequestBody Mono<Taco> taco){
        return tacoRepository.saveAll(taco).next();
    }
}
*/