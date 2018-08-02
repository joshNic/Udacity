package info.sandwichclub.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.sandwichclub.model.Sandwich;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichDetails = new JSONObject(json);
            JSONObject name = sandwichDetails.getJSONObject("name");
            sandwich.setMainName(name.getString("mainName"));
            sandwich.setPlaceOfOrigin(sandwichDetails.getString("placeOfOrigin"));
            sandwich.setDescription(sandwichDetails.getString("description"));
            sandwich.setImage(sandwichDetails.getString("image"));
            JSONArray alsoKnownAsDetails = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<String>(alsoKnownAsDetails.length());
            for (int i = 0; i < alsoKnownAsDetails.length(); i++) {
                alsoKnownAs.add(alsoKnownAsDetails.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);
            JSONArray ingredientsDetails = sandwichDetails.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>(ingredientsDetails.length());
            for (int i = 0; i < ingredientsDetails.length(); i++) {
                ingredients.add(ingredientsDetails.getString(i));
            }
            sandwich.setIngredients(ingredients);
        } catch (JSONException e) {
            // return what was achieved so far
        }
        return sandwich;
    }
}
