package com.blancspace.posservice.repository;

import com.blancspace.posservice.entity.MenuItem;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

//    @NamedQuery(Se)
}
