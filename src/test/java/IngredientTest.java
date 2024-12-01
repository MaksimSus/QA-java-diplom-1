import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void testGetName() {
        // Подготовка данных
        String name = "Сыр";
        float price = 2.0f;
        IngredientType type = IngredientType.FILLING;
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем название
        Assert.assertEquals("The ingredient name should match the specified one.", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        // Подготовка данных
        String name = "Сыр";
        float price = 2.0f;
        IngredientType type = IngredientType.FILLING;
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем цену
        Assert.assertEquals("The ingredient price should match the specified one.", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testGetType() {
        // Подготовка данных
        String name = "Сыр";
        float price = 2.0f;
        IngredientType type = IngredientType.FILLING;
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем тип
        Assert.assertEquals("The ingredient type should match the specified one.", type, ingredient.getType());
    }
}

