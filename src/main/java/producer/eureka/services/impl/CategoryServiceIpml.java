package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import producer.eureka.model.Category;
import producer.eureka.repository.CategoryRepository;
import producer.eureka.services.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceIpml implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category update(int id, Category category) {
        category.setId(id);
        categoryRepository.save(category);
        return category;
    }

    @Override
    @Transactional
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }


}
