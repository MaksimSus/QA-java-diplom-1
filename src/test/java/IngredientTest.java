import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameter(0)
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters(name = "Type: {0}, Name: {1}, Price: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Cheese", 2.0f},
                {IngredientType.SAUCE, "Ketchup", 1.5f},
                {IngredientType.FILLING, "Meat", 3.0f}
        });
    }

    @Test
    public void testGetName() {
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем название
        Assert.assertEquals("The ingredient name should match the specified one.", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем цену
        Assert.assertEquals("The ingredient price should match the specified one.", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testGetType() {
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем тип
        Assert.assertEquals("The ingredient type should match the specified one.", type, ingredient.getType());
    }
}


