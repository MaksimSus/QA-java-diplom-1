import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        // Настройка моков
        Mockito.when(mockBun.getName()).thenReturn("Mock Bun");
        Mockito.when(mockBun.getPrice()).thenReturn(5.0f);

        Mockito.when(mockIngredient1.getName()).thenReturn("Mock Ingredient 1");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(2.5f);

        Mockito.when(mockIngredient2.getName()).thenReturn("Mock Ingredient 2");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(3.0f);
    }

    @Test
    public void testSetBuns() {
        // Устанавливаем булки и проверяем
        burger.setBuns(mockBun);
        assertEquals("Mock Bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        // Добавляем ингредиенты и проверяем
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Mock Ingredient 1", burger.ingredients.get(0).getName());
    }

    @Test
    public void testGetPrice() {
        // Устанавливаем булки и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемая цена: (цена булки * 2) + стоимость ингредиентов
        float expectedPrice = (5.0f * 2) + 2.5f + 3.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void testGetReceipt() {
        // Устанавливаем булки и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемое описание
        String expectedReceipt = "(==== Mock Bun ====)\n" +
                "= Mock Ingredient 1 =\n" +
                "= Mock Ingredient 2 =\n" +
                "(==== Mock Bun ====)\n" +
                "\nPrice: 15,00\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
