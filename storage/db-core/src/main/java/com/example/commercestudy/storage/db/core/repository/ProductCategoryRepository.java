package com.example.commercestudy.storage.db.core.repository;

import com.example.commercestudy.storage.db.core.entity.ProductCategoryEntity;
import enums.EntityStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
//    Slice<ProductCategoryEntity> findByCategoryIdAndStatus(Long categoryId, EntityStatus status, Pageable pageable);
//    List<ProductCategoryEntity> findByProductIdInAndStatus(Collection<Long> productIds, EntityStatus status);
}
