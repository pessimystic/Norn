package com.example.booktracker;

import java.util.List;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByStatus(BookStatus status);
    List<Book> findByTitleContainingIgnoreCase(String text);
}
