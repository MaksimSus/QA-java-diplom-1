import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void testConstructorAndGetName() {
        // Проверяем соответствие названия указанному при сборке
        String name = "С кунжутом";
        float price = 1.5f;
        // Создаем объект булочки
        Bun bun = new Bun(name, price);
        // Проверяем название
        Assert.assertEquals("The price of the bun should match the provided name.", name, bun.getName());
    }

    @Test
    public void testConstructorAndGetPrice() {
        // Проверяем соответствие цены указанной при сборке
        String name = "С кунжутом";
        float price = 1.5f;
        // Создаем объект булочки
        Bun bun = new Bun(name, price);
        // Проверяем цену
        Assert.assertEquals("The price of the bun should match the provided price.", price, bun.getPrice(), 0.0f);
    }

}

