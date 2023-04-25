/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.modelo.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author roger
 */
public interface ICommentDao extends CrudRepository<Comment, Long>{
    @Query("SELECT c FROM Comment c WHERE codigoean=:codigoean")
    List<Comment> getListCommentsByCodigoEAN(@Param("codigoean")Long codigoean);
}
