package com.teamtreehouse.giflib_tutorial.data;

import com.teamtreehouse.giflib_tutorial.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ovidiu on 02-Mar-18.
 */

@Component
public class CategoryRepository {
    public static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Technology"),
            new Category(2, "People"),
            new Category(3, "Destruction")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for (Category c: ALL_CATEGORIES) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
