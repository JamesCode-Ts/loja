package loja.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loja.api.rest.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
