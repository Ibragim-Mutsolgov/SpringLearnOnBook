package com.example.springlearnonbook.restcontroller;

import com.example.springlearnonbook.domain.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TacoControllerRestTemplate {

    private final RestTemplate restTemplate = new RestTemplate();


    public Ingredient getIngredientById(){
        return restTemplate.getForObject("http://localhost:8087/ingredients",
                Ingredient.class, 1);
    }


    public Ingredient getIngredientsById(){
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        return restTemplate.getForObject("http://localhost:8087/ingredients/{id}",
                Ingredient.class, map);
    }


    public Ingredient getIngredients(){
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8087/ingredients/{id}")
                .build(map);
        return restTemplate.getForObject(uri, Ingredient.class);
    }

    public Ingredient getIngredientFromResponse(){
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8087/ingredients/{id}",
                        Ingredient.class, 1);
        return responseEntity.getBody();
    }

    public void put(Ingredient ingredient){
        restTemplate.put("http://localhost:8087/ingredients/{id}",
                ingredient, ingredient.getId());
    }

    public void delete(Ingredient ingredient){
        restTemplate.delete("http:localhost:8087/ingredients/{id}",
                ingredient.getId());
    }

    public Ingredient post(Ingredient ingredient){
        return restTemplate.postForObject("http://localhost:8087/ingredients",
                ingredient, Ingredient.class);
    }

    public URI postForLocation(Ingredient ingredient){
        return restTemplate.postForLocation("http://localhost:8087/ingredients",
                ingredient);
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.postForEntity("http://localhost:8087/ingredients",
                        ingredient,
                        Ingredient.class);
        return responseEntity.getBody();
    }
}