import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void testConstructorAndGetName() {
        // Подготовка данных
        String name = "Сыр";
        float price = 2.0f;
        IngredientType type = IngredientType.FILLING;
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем название
        Assert.assertEquals("Название ингредиента должно совпадать с указанным.", name, ingredient.getName());
    }

    @Test
    public void testConstructorAndGetPrice() {
        // Подготовка данных
        String name = "Сыр";
        float price = 2.0f;
        IngredientType type = IngredientType.FILLING;
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем цену
        Assert.assertEquals("Цена ингредиента должна совпадать с указанной.", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testConstructorAndGetType() {
        // Подготовка данных
        String name = "Сыр";
        float price = 2.0f;
        IngredientType type = IngredientType.FILLING;
        // Создаем объект ингредиента
        Ingredient ingredient = new Ingredient(type, name, price);
        // Проверяем тип
        Assert.assertEquals("Тип ингредиента должен совпадать с указанным.", type, ingredient.getType());
    }
}

