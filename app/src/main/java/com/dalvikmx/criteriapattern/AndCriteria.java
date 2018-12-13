package com.dalvikmx.criteriapattern;

import java.util.List;

public class AndCriteria implements Filter{

    Filter criteria, criteria2;

    public AndCriteria(Filter f1, Filter f2) {
        this.criteria = f1;
        this.criteria2 = f2;
    }

    @Override
    public List<Ingredient> meetCriteria(List<Ingredient> ingredients) {

        List<Ingredient> fisrtIngredient = criteria.meetCriteria(ingredients);
        List<Ingredient> secondIngredient = criteria2.meetCriteria(fisrtIngredient);

        return secondIngredient;
    }
}
