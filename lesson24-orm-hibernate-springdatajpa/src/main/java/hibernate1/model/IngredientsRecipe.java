package hibernate1.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
/*@NamedQueries(
        {@NamedQuery(name="IngredientsRecipe.getIngredientsRecipeViewByNameRecipe",
                query = "SELECT temp.name AS name_ingredient, temp.amount, temp.id_unit,  recipes.units.name AS name_unit FROM " +
                        "(SELECT recipes.ingredients_recipes.id_unit , recipes.ingredients.name, recipes.ingredients_recipes.amount " +
                        "FROM recipes.ingredients_recipes JOIN recipes.ingredients ON recipes.ingredients_recipes.id_ingredients = recipes.ingredients.id " +
                        "WHERE recipes.ingredients_recipes.id_recipes=?) temp JOIN recipes.units ON temp.id_unit = recipes.units.id")
        }
)*/
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

    //@Column(name = "id_unit")
//    @ManyToOne
//    @JoinColumn(name = "id_unit" , insertable = false, updatable = false)
    @Transient
    private Unit unit;

    //@Transient
    @Column(name = "id_unit")
    private Integer unitId;
    //private Unit unit;


    public IngredientsRecipe() {
    }

    public IngredientsRecipe(Recipe recipe,
                             Ingredient ingredient,
                             Double amount,
                             Unit unit) {
        this.amount = amount;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.unitId = unit.getId();
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
