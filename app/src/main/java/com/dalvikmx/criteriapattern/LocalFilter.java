package com.dalvikmx.criteriapattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocalFilter implements Filter{

    @Override
    public List<Ingredient> meetCriteria(List<Ingredient> ingredients) {
        List<Ingredient> local = new ArrayList<>();

        for (Ingredient i : ingredients) {
            if(Objects.equals(i.getLocal(), "Producido en Chiapas"))
                local.add(i);
        }

        return local;
    }

}
