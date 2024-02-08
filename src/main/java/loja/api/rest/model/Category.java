package loja.api.rest.model;

import java.io.Serializable;
import java.lang.Integer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Category implements Serializable{
	
	
	 private static final long serialVersionUID = 1L;
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String name;
	    
	 

	    // Construtor padrão sem parâmetros
	    public Category() {
	        // Deixe o corpo vazio ou inicialize os atributos com valores padrão se necessário
	    }

	    // Construtor que recebe o id como parâmetro
	    public Category(Long id) {
	        this.id = id;
	    }
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
	    
	
	
	

}
