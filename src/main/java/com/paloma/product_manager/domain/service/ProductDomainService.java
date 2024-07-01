package com.paloma.product_manager.domain.service;

import com.paloma.product_manager.adapters.repository.ProductRepository;
import com.paloma.product_manager.domain.exception.ProductNotFoundException;
import com.paloma.product_manager.domain.model.ProductEntity;
import com.paloma.product_manager.domain.respository.ProductModelUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

    @Slf4j
    @Service
    @Transactional
    public class ProductDomainService implements ProductModelUseCase{

        @Autowired
        private ProductRepository repository;


    @Override
    public ProductEntity findById(Long id) {
        log.info("M findById, id-{}", id);
        return repository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id));
    }

    @Override
    public Optional<ProductEntity> findByName(String name) {
        log.info("M findByName, name-{}", name);
        return repository.findByName(name);
    }

    @Override
    public List<ProductEntity> findAll() {
        log.info("M findAll");
        return repository.findAll();
    }

    @Override
    public ProductEntity create(ProductEntity entity) {
        log.info("M create, entity-{}", entity);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        log.info("M delete, id-{}", id);
        ProductEntity entity = findById(id);
        repository.delete(entity);
    }

    @Override
    public ProductEntity update(Long id, ProductEntity newData) {
        log.info("M update, id-{} and updated product={}", id, newData);
        ProductEntity entity = findById(id);

        entity.setName(newData.getName());
        entity.setDescription(newData.getDescription());
        entity.setPrice(newData.getPrice());

        return repository.save(entity);
    }
}
