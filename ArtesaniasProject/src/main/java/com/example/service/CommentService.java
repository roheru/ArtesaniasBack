package com.example.service;

import com.example.modelo.Comment;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentService {
     public List<Comment> listAll();
    public Comment create(Comment comment);
    public Comment update(Comment comment);
    public void erase(Comment comment);
    public List<Comment> getListCommentsByCodigoEAN(@Param("codigoean")Long codigoean);
}
