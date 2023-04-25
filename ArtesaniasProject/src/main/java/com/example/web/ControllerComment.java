package com.example.web;

import com.example.modelo.Comment;
import com.example.modelo.Product;
import com.example.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/listProducts") 
@RestController
@RequestMapping("/comments")
public class ControllerComment {
    @Autowired
    private CommentService commentDao;
    
    
    @CrossOrigin(origins = "*") 
    @GetMapping(value = "/listcomments")
    public List<Comment> listCommentsByEanCode(@RequestParam(required = false) String atributo){
        return commentDao.getListCommentsByCodigoEAN(Long.parseLong(atributo));     
    }
    
    @CrossOrigin(origins = "*") 
    @GetMapping()
    public List<Comment> listComments(){
        return commentDao.listAll();
    }
    
    @CrossOrigin(origins = "*") 
    @PostMapping(value = "/saveComment")
    public Comment insertComment(@RequestPart("comentario") String comentario,
                            @RequestPart("codigoean") String codigoean,
                            @RequestPart("fechacreacion") String fechacreacion){
        Comment c=new Comment();
        Product p=new Product();
        
        try {
            p.setCodigoean(Long.parseLong(codigoean));
            c.setComentario(comentario);
            c.setFechaCreacion(new Date());
            System.out.println("com.example.web.ControllerComment.insertComment()");
            System.out.println("date:"+fechacreacion);
            c.setProduct(p);
            return commentDao.create(c);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        
    }
    
    
}
