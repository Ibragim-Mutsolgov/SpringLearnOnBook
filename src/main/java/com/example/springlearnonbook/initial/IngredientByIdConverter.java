package com.example.springlearnonbook.initial;

import com.example.springlearnonbook.domain.Ingredient;
import com.example.springlearnonbook.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Ingredient, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
