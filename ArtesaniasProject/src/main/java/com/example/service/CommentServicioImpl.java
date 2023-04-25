package com.example.service;

import com.example.dao.ICommentDao;
import com.example.modelo.Comment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServicioImpl implements CommentService{
    
    @Autowired
    private ICommentDao commentDao;
    
    @Override
    public List<Comment> listAll() {
        return (List<Comment>) commentDao.findAll();
    }
    
    @Override
    public List<Comment> getListCommentsByCodigoEAN(Long codigoean) {
        return commentDao.getListCommentsByCodigoEAN(codigoean);
    }
    
    

    @Override
    public Comment create(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment update(Comment product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void erase(Comment product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
