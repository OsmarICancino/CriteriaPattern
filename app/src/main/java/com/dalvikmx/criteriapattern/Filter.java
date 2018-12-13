package com.dalvikmx.criteriapattern;

import java.util.List;

public interface Filter {

    List<Ingredient> meetCriteria(List<Ingredient> ingredients);

}
