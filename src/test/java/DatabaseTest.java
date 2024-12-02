import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database(); // Инициализируем объект Database
    }

    @Test
    public void testAvailableBunsNotNull() {
        // Проверяем, что метод availableBuns возвращает не null
        List<Bun> buns = database.availableBuns();
        assertNotNull("List of buns should not be null", buns);
    }

    @Test
    public void testAvailableBunsSize() {
        // Проверяем, что список булок содержит ожидаемое количество элементов
        List<Bun> buns = database.availableBuns();
        assertEquals("List of buns should contain 3 elements", 3, buns.size());
    }

    @Test
    public void testAvailableBunsContents() {
        // Проверяем, что список булок содержит ожидаемые объекты
        List<Bun> buns = database.availableBuns();
        assertEquals("First bun should be 'black bun'", "black bun", buns.get(0).getName());
        assertEquals("Second bun should be 'white bun'", "white bun", buns.get(1).getName());
        assertEquals("Third bun should be 'red bun'", "red bun", buns.get(2).getName());
    }

    @Test
    public void testAvailableIngredientsNotNull() {
        // Проверяем, что метод availableIngredients возвращает не null
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull("List of ingredients should not be null", ingredients);
    }

    @Test
    public void testAvailableIngredientsSize() {
        // Проверяем, что список ингредиентов содержит ожидаемое количество элементов
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals("List of ingredients should contain 6 elements", 6, ingredients.size());
    }

    @Test
    public void testAvailableIngredientsContents() {
        // Проверяем, что список ингредиентов содержит ожидаемые объекты
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals("First ingredient should be 'hot sauce'", "hot sauce", ingredients.get(0).getName());
        assertEquals("Second ingredient should be 'sour cream'", "sour cream", ingredients.get(1).getName());
        assertEquals("Third ingredient should be 'chili sauce'", "chili sauce", ingredients.get(2).getName());
        assertEquals("Fourth ingredient should be 'cutlet'", "cutlet", ingredients.get(3).getName());
        assertEquals("Fifth ingredient should be 'dinosaur'", "dinosaur", ingredients.get(4).getName());
        assertEquals("Sixth ingredient should be 'sausage'", "sausage", ingredients.get(5).getName());
    }
}
