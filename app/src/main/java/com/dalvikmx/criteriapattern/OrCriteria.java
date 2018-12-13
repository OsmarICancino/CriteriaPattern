package com.dalvikmx.criteriapattern;

import java.util.List;

public class OrCriteria implements Filter{

    Filter criteria, criteria2;

    public OrCriteria(Filter f1, Filter f2) {
        this.criteria = f1;
        this.criteria2 = f2;
    }

    @Override
    public List<Ingredient> meetCriteria(List<Ingredient> ingredients) {

        List<Ingredient> fisrtIngredients = criteria.meetCriteria(ingredients);
        List<Ingredient> secondIngredients = criteria2.meetCriteria(ingredients);

        for(Ingredient i : fisrtIngredients) {
            if(!secondIngredients.contains(i)) {
                secondIngredients.add(i);
            }
        }

        return secondIngredients;
    }
}
