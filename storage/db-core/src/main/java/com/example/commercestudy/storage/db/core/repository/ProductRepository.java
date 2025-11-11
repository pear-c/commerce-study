package com.example.commercestudy.storage.db.core.repository;

import com.example.commercestudy.storage.db.core.entity.ProductEntity;
import enums.EntityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//    List<ProductEntity> findByIdInAndStatus(Collection<Long> ids, EntityStatus status);
}
