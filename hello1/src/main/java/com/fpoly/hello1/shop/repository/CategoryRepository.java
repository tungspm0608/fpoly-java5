package com.fpoly.hello1.shop.repository;

import com.fpoly.hello1.shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
