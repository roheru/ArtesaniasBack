package com.example.modelo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="products")
public class Product implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="codigoean")
    private Long codigoean;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="marca")
    private String marca;
    @Column(name="unidades")
    private Integer unidades;
    
    @Lob
    @Column(name="file_data")
    private byte[] fileData;
    
    @OneToMany(
            mappedBy = "product"
    )
    private List<Comment> comments;
    
    public Product(){
    
    }
    
    public Product(Long codigoean,String nombre,String descripcion,String marca,Integer unidades,byte[] fileData){
        this.codigoean=codigoean;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.marca=marca;
        this.unidades=unidades;
        this.fileData=fileData;
    }
	
	
    
    public String getNombre() {
            return nombre;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
    public String getDescripcion() {
            return descripcion;
    }
    public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
    }
    public String getMarca() {
            return marca;
    }
    public void setMarca(String marca) {
            this.marca = marca;
    }
    public Integer getUnidades() {
            return unidades;
    }
    public void setUnidades(Integer unidades) {
            this.unidades = unidades;
    }

    /**
     * @return the codigoean
     */
    public Long getCodigoean() {
        return codigoean;
    }

    /**
     * @param codigoean the codigoean to set
     */
    public void setCodigoean(Long codigoean) {
        this.codigoean = codigoean;
    }

    /**
     * @return the fileData
     */
    public byte[] getFileData() {
        return fileData;
    }

    /**
     * @param fileData the fileData to set
     */
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
    
    public void addComment(Comment comment){
        comments.add(comment);
        comment.setProduct(this);
    }
    
    public void removeComment(Comment comment){
        comments.remove(comment);
        comment.setProduct(null);
    }
	
}
