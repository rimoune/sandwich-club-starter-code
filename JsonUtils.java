package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject reader = new JSONObject(json);
            //Retrieving all tags
            JSONObject name = reader.getJSONObject("name");

            String mainName = name.getString("mainName");

            JSONArray alsoKnownAsJArr = name.getJSONArray("alsoKnownAs");

            List<String> alsoKnownAs = new ArrayList<>();
            for (int i=0; i<alsoKnownAsJArr.length(); i++) {
                alsoKnownAs.add( alsoKnownAsJArr.getString(i) );
            }
            System.out.println("*************Also...." + alsoKnownAs.toString());

            String placeOfOrigin = reader.getString("placeOfOrigin");
            String description = reader.getString("description");
            String image = reader.getString("image");

            JSONArray ingredientsJArr = reader.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i=0; i<ingredientsJArr.length(); i++) {
                ingredients.add( ingredientsJArr.getString(i) );
            }
            //Setting all properties of a sandwich
            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredients);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return sandwich;
    }
}