import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mark.app.testing.Calcilation;

public class CalculationTest {

    private final Calcilation calculation = new Calcilation();


    @Test
    @DisplayName("Проверка входящего типа материала")
    public void test1(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(1,10, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящего типа продукта")
    public void test2(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящего количесвта продуктов")
    public void test3(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящей длинны продукта")
    public void test4(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящей ширины продукта")
    public void test5(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящего типа продукта")
    public void test6(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящего типа продукта")
    public void test7(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящего типа продукта")
    public void test8(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }
    @Test
    @DisplayName("Проверка входящего типа продукта")
    public void test9(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }

    @Test
    @DisplayName("Проверка входящего типа продукта")
    public void test10(){
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10,1, 1, 1, 1));
    }
}
