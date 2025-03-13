import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    @Test
    void shouldRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(2, "Молоко", 100);

        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] expected = {product2};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldThrowNotFoundExceptionWhenRemovingNonExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 50);
        Product product2 = new Product(2, "Молоко", 100);

        repository.add(product1);
        repository.add(product2);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}
