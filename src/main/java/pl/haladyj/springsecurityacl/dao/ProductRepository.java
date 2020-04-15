package pl.haladyj.springsecurityacl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.haladyj.springsecurityacl.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @PostFilter("hasPermission(filterObject, 'WRITE')")
    List<Product> findAll();

    @PostAuthorize("hasPermission(returnObject, 'READ'")
    Optional<Product> findById(Long id);

}
