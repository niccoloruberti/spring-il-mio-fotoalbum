package org.java.spring.db.pojo;




import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "Il nome non può essere vuoto")
    private String name;
    
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Photo> photos;
    
	public Category() { }
    public Category (String name) {
        setName(name);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @JsonIgnore
    public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
    
    @Override
    public String toString() {
        return "[" + getId() + "] " + getName();
    }
}