package com.ceiba.demo.port;

import com.ceiba.demo.entity.Category;
import java.util.Collection;

public interface CategoryRepository {

	Collection<Category> findAll();

}
