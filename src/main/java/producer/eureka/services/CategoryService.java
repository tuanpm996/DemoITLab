package producer.eureka.services;

import producer.eureka.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Category update(int id, Category category);

    void delete(int id);

    Iterable<Category> findAllCategory();
}
