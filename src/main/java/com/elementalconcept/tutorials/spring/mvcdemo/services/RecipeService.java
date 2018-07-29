package com.elementalconcept.tutorials.spring.mvcdemo.services;

import java.util.Set;

public interface RecipeService {

    Set<String> getRecipes();

    String findById(Integer l);

}
