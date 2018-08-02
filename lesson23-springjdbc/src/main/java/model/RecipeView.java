package model;


import java.util.*;

public class RecipeView {

    private Recipe recipe;
    private List<IngredientsRecipeView> ingredientsRecipeViewList;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<IngredientsRecipeView> getIngredientsRecipeViewList() {
        return ingredientsRecipeViewList;
    }

    public void setIngredientsRecipeViewList(List<IngredientsRecipeView> ingredientsRecipeViewList) {
        this.ingredientsRecipeViewList = ingredientsRecipeViewList;
    }
}
