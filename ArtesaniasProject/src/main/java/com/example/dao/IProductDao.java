/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dao;

import com.example.modelo.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface IProductDao extends CrudRepository<Product, String>{
    
   
    @Query("SELECT p FROM Product p WHERE codigoean=:codigoean")
    List<Product> getListProductByCodigoEAN(@Param("codigoean")Long codigoean);
    
    @Query("SELECT p FROM Product p WHERE nombre=:nombre")
    List<Product> getListProductByName(@Param("nombre")String nombre);
    
    @Query("SELECT p FROM Product p WHERE nombre=:marca")
    List<Product> getListProductByBrand(@Param("marca")String marca);
    
    @Query("SELECT p FROM Product p WHERE descripcion=:descripcion")
    List<Product> getListProductByDescription(@Param("descripcion")String descripcion);
    
    @Query("SELECT p FROM Product p WHERE unidades=:unidades")
    List<Product> getListProductByUnits(@Param("unidades")Integer unidades);
}
