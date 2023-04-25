/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.modelo.Product;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roger
 */


@Repository
public interface ProductService {
    public List<Product> listAll();
    public Product create(Product product);
    public Product update(Product product);
    public void erase(Product product);
    public List<Product> getListProductByCodigoEAN(@Param("codigoean")Long codigoean);
    public List<Product> getListProductByName(@Param("nombre")String nombre);
    public List<Product> getListProductByBrand(@Param("marca")String marca);
    public List<Product> getListProductByDescription(@Param("descripcion")String descripcion);
    public List<Product> getListProductByUnits(@Param("unidades")Integer unidades);
    
    
}
