package py.com.daas.adamspayintegration.services;

import java.util.List;

import py.com.daas.adamspayintegration.entities.ProductCategory;

public interface CategoryService {

    List<ProductCategory> findAll();

    ProductCategory findByCategoryType(Integer categoryType);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
