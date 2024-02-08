package loja.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loja.api.rest.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}