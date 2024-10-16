package org.example.assignment02.dao;

import org.example.assignment02.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
}
