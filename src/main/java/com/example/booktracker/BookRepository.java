package com.example.booktracker;

import java.util.List;
import org.springframework.data.domain.Sort;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByStatus(BookStatus status, Sort sort);
    List<Book> findByTitleContainingIgnoreCase(String text, Sort sort);
    List<Book> findByStatusAndTitleContainingIgnoreCase(BookStatus status, String text, Sort sort);
}
