package com.dalvikmx.criteriapattern;


import java.util.ArrayList;
import java.util.List;

public class VegetarianFilter implements Filter {

    @Override
    public List<Ingredient> meetCriteria(List<Ingredient> ingredients) {

        List<Ingredient> vegetarian = new ArrayList<>();
        for (Ingredient i : ingredients) {
            if(i.isVegetarian())
                vegetarian.add(i);
        }
        return vegetarian;
    }
}
