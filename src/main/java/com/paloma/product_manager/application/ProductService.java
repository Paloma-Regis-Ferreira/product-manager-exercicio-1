package com.paloma.product_manager.application;

import com.paloma.product_manager.adapters.dto.ProductDTO;
import com.paloma.product_manager.adapters.mapper.ProductMapper;
import com.paloma.product_manager.domain.exception.ProductAlreadyExistsException;
import com.paloma.product_manager.domain.model.ProductEntity;
import com.paloma.product_manager.domain.respository.ProductModelUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.paloma.product_manager.adapters.mapper.ProductMapper.convertDtoToEntity;
import static com.paloma.product_manager.adapters.mapper.ProductMapper.convertEntityToDto;

@Slf4j
@Service
public class ProductService implements ProductServiceUseCase {

    @Autowired
    private ProductModelUseCase useCase;

    @Override
    public ProductDTO getProductById(Long id) {
        log.info("M getProductById, id={}", id);
        ProductEntity entity = useCase.findById(id);
        return convertEntityToDto(entity);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("M getAllProducts");
        return useCase.findAll().stream()
                .map(ProductMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO newProduct) {
        log.info("M createProduct, ProductDTO={}", newProduct);
        String treatedProductName = treatmentString(newProduct.getName());
        Optional<ProductEntity> entity = useCase.findByName(treatedProductName);
        if (entity.isPresent()){
            log.error("M createProduct, product with name={} already exists", newProduct.getName());
            throw new ProductAlreadyExistsException(entity.get().getId(), convertEntityToDto(entity.get()));
        }
        newProduct.setName(treatedProductName);
        return convertEntityToDto(useCase.create(
                convertDtoToEntity(newProduct)));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO updateProduct) {
        log.info("M updateProduct, ProductDTO={} and id={}", updateProduct, id);
        String treatedProductName = treatmentString(updateProduct.getName());
        updateProduct.setName(treatedProductName);
        return convertEntityToDto(useCase.update(
                id, convertDtoToEntity(updateProduct)));
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("M deleteProduct, id={}", id);
        useCase.delete(id);
    }

    protected String treatmentString(String productName){
        String normalized = Normalizer.normalize(productName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String treatedName = pattern.matcher(normalized).replaceAll("");
        treatedName = treatedName.replaceAll("[^a-zA-Z0-9]", " ");
        treatedName = treatedName.replaceAll("\\s+", " ");
        treatedName = treatedName.trim();
        log.info("M treatmentString, string received={} and string treated={}", productName, treatedName);
        return treatedName;
    }
}
