import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
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

    @Parameterized.Parameter(0)
    public float bunPrice; // Цена булки

    @Parameterized.Parameter(1)
    public float ingredient1Price; // Цена первого ингредиента

    @Parameterized.Parameter(2)
    public float ingredient2Price; // Цена второго ингредиента

    @Parameterized.Parameter(3)
    public float ingredient3Price; // Цена третьего ингредиента

    @Parameterized.Parameter(4)
    public float expectedPrice; // Ожидаемая цена

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5.0f, 2.0f, 3.0f, 1.5f, 16.5f},
                {3.0f, 1.5f, 2.0f, 5.0f, 14.5f},
                {4.0f, 3.0f, 2.0f, 2.0f, 15.0f}
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        // Настройка моков
        Mockito.when(mockBun.getName()).thenReturn("Bun");
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);

        Mockito.when(mockIngredient1.getName()).thenReturn("SAUCE");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(ingredient1Price);
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);

        Mockito.when(mockIngredient2.getName()).thenReturn("FILLING");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(ingredient2Price);
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(mockIngredient3.getName()).thenReturn("VEGGIES");
        Mockito.when(mockIngredient3.getPrice()).thenReturn(ingredient3Price);
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
        // Добавляем ингредиенты и перемещаем
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
        // Устанавливаем булку и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);

        // Проверяем расчет цены
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        // Устанавливаем булки и добавляем ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);

        // Устанавливаем ожидаемую итоговую стоимость
        float expectedPrice = (mockBun.getPrice() * 2) + mockIngredient1.getPrice() + mockIngredient2.getPrice() + mockIngredient3.getPrice();

        // Форматируем стоимость в строку с шестью знаками после запятой
        String formattedPrice = String.format("%.6f", expectedPrice);

        // Ожидаемое описание
        String expectedReceipt = "(==== Bun ====)" + System.lineSeparator() +
                "= sauce SAUCE =" + System.lineSeparator() +
                "= filling FILLING =" + System.lineSeparator() +
                "= filling VEGGIES =" + System.lineSeparator() +
                "(==== Bun ====)" + System.lineSeparator() +
                System.lineSeparator() + "Price: " + formattedPrice + System.lineSeparator();

        // Проверяем
        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientWithInvalidIndex() {
        burger.removeIngredient(10); // Удаление по некорректному индексу
    }

    @Test
    public void testAddMultipleIngredients() {
        // Проверяем соответствие количесва ингредиентов
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testGetPriceWithNoBunAndIngredients() {
        // Проверяем подсчет с нулевой стоимостью всего
        burger.setBuns(mockBun); // Устанавливаем булку
        Mockito.when(mockBun.getPrice()).thenReturn(0f); // Указываем, что её цена = 0
        assertEquals(0.0f, burger.getPrice(), 0.0);
    }

}
