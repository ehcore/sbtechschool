package hibernate1.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipes.ingredients_recipes")
public class IngredientsRecipe {
/*
    private Integer recipeId;
    private Integer ingredientId;
    private Double amount;
    private Integer unitId;
*/


    @Embeddable
    private static class Id implements Serializable {
        @Column(name = "id_recipes")
        protected Integer recipeId;

        @Column(name = "id_ingredients")
        protected Integer ingredientId;

        public Id(){}

        public Id(Integer recipeId, Integer ingredientId) {
            this.recipeId = recipeId;
            this.ingredientId = ingredientId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;

            Id id = (Id) o;

            if (!recipeId.equals(id.recipeId)) return false;
            return ingredientId.equals(id.ingredientId);
        }

        @Override
        public int hashCode() {
            int result = recipeId.hashCode();
            result = 31 * result + ingredientId.hashCode();
            return result;
        }
    }


    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    @JoinColumn(name = "id_recipes", insertable = false, updatable = false)
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "id_ingredients" , insertable = false, updatable = false)
    private Ingredient ingredient;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "id_unit")
    private Unit unit;

    // private

    public IngredientsRecipe(Recipe recipe,
                             Ingredient ingredient,
                             Double amount,
                             Unit unit) {
        this.amount = amount;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.unit = unit;

        this.id.recipeId = recipe.getId();
        this.id.ingredientId = ingredient.getId();


    }




    @Override
    public String toString() {
        return "IngredientsRecipe{" +
                //  "id=" + id +
                ", recipe=" + recipe.getName() +
                ", ingredient=" + ingredient.getName() +
                ", amount=" + amount +
                ", unit=" + unit.getName() +
                '}';
    }

  /*  public IngredientsRecipe(Integer recipeId, Integer ingredientId, Double amount, Integer unitId) {
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
    }*/
}
