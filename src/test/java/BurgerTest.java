import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Mock
    private Ingredient mockIngredient3;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        // Настройка моков
        Mockito.when(mockBun.getName()).thenReturn("Bun");
        Mockito.when(mockBun.getPrice()).thenReturn(5.0f);

        Mockito.when(mockIngredient1.getName()).thenReturn("SAUCE");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(2f);
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);

        Mockito.when(mockIngredient2.getName()).thenReturn("FILLING");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(3.0f);
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(mockIngredient3.getName()).thenReturn("VEGGIES");
        Mockito.when(mockIngredient3.getPrice()).thenReturn(1.5f);
        Mockito.when(mockIngredient3.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBuns() {
        // Устанавливаем булки и проверяем
        burger.setBuns(mockBun);
        assertEquals("Bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        // Добавляем ингредиенты и проверяем
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals("SAUCE", burger.ingredients.get(0).getName());
    }

    @Test
    public void testRemoveIngredient() {
        // Добавляем ингредиенты
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Удаляем первый ингредиент
        burger.removeIngredient(0);

        // Проверяем, что остался только один ингредиент
        assertEquals(1, burger.ingredients.size());
        assertEquals("FILLING", burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        // Добавляем ингредиенты
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);

        // Перемещаем ингредиенты: SAUCE -> в конец
        burger.moveIngredient(0, 2);

        // Проверяем порядок ингредиентов
        assertEquals("FILLING", burger.ingredients.get(0).getName());
        assertEquals("VEGGIES", burger.ingredients.get(1).getName());
        assertEquals("SAUCE", burger.ingredients.get(2).getName());
    }

    @Test
    public void testGetPrice() {
        // Устанавливаем булки и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемая цена: (цена булки * 2) + стоимость ингредиентов
        float expectedPrice = (5.0f * 2) + 2f + 3.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void testGetReceipt() {
        // Устанавливаем булки и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемое описание
        String expectedReceipt = "(==== Bun ====)" + System.lineSeparator() +
                "= sauce SAUCE =" + System.lineSeparator() +
                "= filling FILLING =" + System.lineSeparator() +
                "(==== Bun ====)" + System.lineSeparator() +
                System.lineSeparator() + "Price: 15.000000" + System.lineSeparator();

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
