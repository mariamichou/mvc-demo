package com.elementalconcept.tutorials.spring.mvcdemo.services;

import com.elementalconcept.tutorials.spring.mvcdemo.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private static final Map<Integer, String> myMap = new HashMap<Integer, String>() {
        {
            put(1, "Greek Salad");
            put(2, "Souvlaki");
            put(3, "Tzatziki");
        }
    };

    private static final Map<Integer, String> recipeMap = Collections.unmodifiableMap(myMap);

    @Override
    public Set<String> getRecipes() {
        return new HashSet<>(recipeMap.values());
    }

    @Override
    public String findById(Integer id) {

        String recipe = recipeMap.get(id);
        if(recipe == null) {
            throw new NotFoundException(String.format("Recipe with ID %d Not Found!", id));
        }

        return recipe;
    }
}
