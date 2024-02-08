package loja.api.rest.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Product  implements Serializable {
	

	private static final long serialVersionUID = 1L;
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String name;
	    private String price;
	    private String description;
	    private int quantity; 
	    private String photo;
	    
	    
	    
	    public String getPhoto() {
			return photo;
		}


		public void setPhoto(String photo) {
			this.photo = photo;
		}

    



		// Mapeamento da chave estrangeira
	    @ManyToOne
	    @JoinColumn(name = "category_id") // Nome da coluna na tabela Product que é a chave estrangeira
	    private Category category_id;

	    
		 public Category getCategory_id() {
				return category_id;
			}


			public void setCategory_id(Category category_id) {
				this.category_id = category_id;
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


		public String getPrice() {
			return price;
		}


		public void setPrice(String price) {
			this.price = price;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public int getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


	


	
}
