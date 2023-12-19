package org.java.spring.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotEmpty(message = "Devi inserire un nome")
	@Length(min = 3, max = 50, message = "Il nome deve essere lungo almeno 3 caratteri e non più lungo di 50")
	private String name;
	
	@Column(columnDefinition = "TEXT")
	@Length(max = 600, message = "La descrizione può essere lunga al massimo 600 caratteri")
	private String description;
	
	@NotEmpty(message = "Devi inserire un url")
	@Column(columnDefinition = "TEXT")
	private String url;
	
	private boolean visible;
	
	@ManyToMany
	@Size(min = 1, message = "Devi selezionare almeno una categoria")
	private List<Category> categories;

	public Photo() {};
	
	public Photo(String name, String description, String url, boolean visible, Category... categories) {
		
		setName(name);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void setCategories(Category... categories) {
        setCategories(Arrays.asList(categories));
    }

}
