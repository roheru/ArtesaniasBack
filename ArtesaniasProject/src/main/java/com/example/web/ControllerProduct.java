package com.example.web;

import com.example.modelo.Product;
import com.example.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200/") 
@RestController
@RequestMapping("/products")
public class ControllerProduct {
    
    @Autowired
    private ProductService productDao;
    
    @GetMapping()
    public List<Product> listar(@RequestParam(required = false) String atributo,@RequestParam(required = false) String valor){
        
        if(atributo==null || valor==null){
            return productDao.listAll();
        }
        
        if(atributo.equals("*") ){
            return productDao.listAll();
        }
        
        if(atributo.equals("ean")){
            return productDao.getListProductByCodigoEAN(Long.parseLong(valor));
        }
        
        if(atributo.equals("nombre")){
            return productDao.getListProductByName(valor);
        }
        
        if(atributo.equals("marca")){
            return productDao.getListProductByBrand(valor);
        }
        
        if(atributo.equals("descripcion")){
            return productDao.getListProductByDescription(valor);
        }
        
        if(atributo.equals("unidades")){
            return productDao.getListProductByUnits(Integer.parseInt(valor));
        }
        
        
        return null;
         
        
    }
    
    @PostMapping(value="/saveproduct",consumes = {"multipart/form-data"})
    public Product create(  @RequestPart("nombre") String nombre,
                            @RequestPart("codigoean") String codigoean,
                            @RequestPart("descripcion") String descripcion,
                            @RequestPart("marca") String marca,
                            @RequestPart("cantidad") String cantidad,
                            @RequestPart("file_data") MultipartFile file
                            ){
        try {
            Product p=new Product(Long.parseLong(codigoean),nombre,descripcion,marca,Integer.parseInt( cantidad),file.getBytes());
            p=productDao.create(p);
            System.out.println("Entro 1....");
            return p;
        } catch (Exception e) {
            System.out.println("Entro 2....");
            e.printStackTrace();
        }
       return new Product();
        
    }
    
    @PutMapping
    public Product update(@RequestBody Product p){
        return productDao.update(p);
    }
    
    @DeleteMapping
    public void erase(@RequestBody Product p){
        productDao.erase(p);
    }
    
    
    
    
    /*public Persona createPerson(Persona p){
        return personaDao.create(p);
    }*/
    
    /*
    @GetMapping("/")
    public String start(Model model){
        
        Iterable<Persona> personas=personaDao.listaPersonas();
        
        Persona p=new Persona();
        p.setNombre("Roger");
        
        model.addAttribute("personas", personas);
        return "login";
    }
    @GetMapping("/anexar")
    public String anexar(Persona persona){
        return "cambiar";
    }
    @PostMapping("/guardar")
    public String salvar(Persona p){
        personaDao.save(p);
        return "redirect:/";
    }
    
    @GetMapping("/modificar/{idp}")
    public String modificar(Persona p,Model m){
        p=personaDao.search(p);
        m.addAttribute("persona",p);
        return "cambiar";
    }
    
    @GetMapping("/borrar/{idp}")
    public String borrar(Persona p,Model m){
        personaDao.delete(p);
        return "redirect:/";
    }
    */
}
