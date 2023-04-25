package com.example.service;

import com.example.dao.IProductDao;
import com.example.modelo.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServicioImpl implements ProductService{
    @Autowired
    private IProductDao productDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Product> listAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product create(Product product) {
        return productDao.save(product);
    }
    
    
    @Override
    public Product update(Product product) {
        return productDao.save(product);
    }
    
    
    @Override
    public void erase(Product product) {
        productDao.delete(product);
    }

    @Override
    public List<Product> getListProductByCodigoEAN(Long codigoean) {
        return (List<Product>)productDao.getListProductByCodigoEAN(codigoean);
    }
    
    @Override
    public List<Product> getListProductByName(String nombre){
        return (List<Product>)productDao.getListProductByName(nombre);
    }
    
    @Override
    public List<Product> getListProductByBrand(String marca){
        return (List<Product>)productDao.getListProductByBrand(marca);
    }
    
    @Override
    public List<Product> getListProductByDescription(String descripcion){
        return (List<Product>)productDao.getListProductByDescription(descripcion);
    }
    
    @Override
    public List<Product> getListProductByUnits(Integer unidades){
        return (List<Product>)productDao.getListProductByUnits(unidades);
    }
 
}
