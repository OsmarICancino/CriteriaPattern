package com.dalvikmx.criteriapattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);


        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient("Queso", "Producido en Chiapas", true));
        ingredients.add(new Ingredient("Tomate", "Producido en Oaxaca", true));
        ingredients.add(new Ingredient("Jamón", "Producido en Ensenada", false));
        ingredients.add(new Ingredient("Pavo", "Producido en Chiapas", false));
        ingredients.add(new Ingredient("Lechuga", "Producido en Chiapas", true));
        ingredients.add(new Ingredient("Chorizo", "Producido en Veracruz", false));


        Filter vegetarian = new VegetarianFilter();
        Filter local = new LocalFilter();
        Filter nonLocal = new NonLocalFilter();
        Filter localAndVegetarin = new AndCriteria(local, vegetarian);
        Filter localOrVegetarin = new OrCriteria(local, vegetarian);

        printIngredients(local.meetCriteria(ingredients), "Local");
        printIngredients(nonLocal.meetCriteria(ingredients), "\nNonLocal");
        printIngredients(vegetarian.meetCriteria(ingredients), "\nVegetarian");
        printIngredients(localAndVegetarin.meetCriteria(ingredients), "\nLocal and Vegetarian");
        printIngredients(localOrVegetarin.meetCriteria(ingredients), "\nEnviromentally Friendly");


    }


    public void printIngredients(List<Ingredient> ingredients, String header) {
        textView.append(header + "\n");

        for(Ingredient i : ingredients) {
            textView.append(new StringBuilder()
            .append(i.getName())
            .append(" ")
            .append(i.getLocal())
            .append("\n")
            .toString());
        }
    }
}
