package com.fatec.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.product.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
