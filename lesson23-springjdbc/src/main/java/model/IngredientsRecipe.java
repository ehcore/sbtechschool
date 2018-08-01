package model;


public class IngredientsRecipe {
    private Integer recipeId;
    private Integer ingredientId;
    private Double amount;
    private Integer unitId;

    public IngredientsRecipe(Integer recipeId, Integer ingredientId, Double amount, Integer unitId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.unitId = unitId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public String toString() {
        return "IngredientsRecipe{" +
                "recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                ", amount=" + amount +
                ", unitId=" + unitId +
                '}';
    }
}
