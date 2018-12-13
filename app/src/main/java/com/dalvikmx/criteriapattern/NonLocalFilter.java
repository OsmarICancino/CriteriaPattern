package com.dalvikmx.criteriapattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NonLocalFilter implements Filter{

    @Override
    public List<Ingredient> meetCriteria(List<Ingredient> ingredients) {
        List<Ingredient> nonLocal = new ArrayList<>();

        for (Ingredient i : ingredients) {
            if(i.getLocal() != "Producido en Chiapas"){
                nonLocal.add(i);
            }
        }

        return nonLocal;
    }

}
