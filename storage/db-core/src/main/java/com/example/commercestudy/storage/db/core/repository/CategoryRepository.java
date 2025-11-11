package com.example.commercestudy.storage.db.core.repository;

import com.example.commercestudy.storage.db.core.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
