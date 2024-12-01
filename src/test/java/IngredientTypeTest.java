import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class IngredientTypeTest {

    @Test
    public void testEnumContainsCorrectValues() {
        // Проверяем, что перечисление содержит правильные значения
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void testValueOfWorksCorrectly() {
        // Проверяем, что метод valueOf возвращает правильные значения
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void testValueOfThrowsExceptionForInvalidValue() {
        // Проверяем, что передача некорректного значения выбрасывает исключение
        assertThrows(IllegalArgumentException.class, () -> IngredientType.valueOf("INVALID"));
    }

    @Test
    public void testEnumValuesAreNotNull() {
        // Проверяем, что все значения перечисления не null
        for (IngredientType type : IngredientType.values()) {
            assertNotNull(type);
        }
    }

}
