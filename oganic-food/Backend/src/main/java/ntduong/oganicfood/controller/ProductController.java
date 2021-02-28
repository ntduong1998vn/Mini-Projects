package ntduong.oganicfood.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import ntduong.oganicfood.model.Category;
import ntduong.oganicfood.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Product Api")
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final CategoryRepository categoryRepository;

    @ApiOperation("Hello World")
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @ApiOperation("/Add new category")
    @GetMapping("/new-category")
    public void insertNewCategory() {
        Category category = new Category();
        category.setName("Duong" + System.nanoTime());
        categoryRepository.save(category);
    }

    @ApiOperation("/Get all list category")
    @GetMapping("/category-list")
    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }
}
