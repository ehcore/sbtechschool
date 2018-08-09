package hibernate1.model;


import java.math.BigDecimal;

public class IngredientsRecipeView {
    private String ingredient;
    private BigDecimal amount;
    private String unit;

    public IngredientsRecipeView() {
    }

    public IngredientsRecipeView(String ingredient, BigDecimal amount, String unit) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
