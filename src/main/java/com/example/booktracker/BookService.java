package com.example.booktracker;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }

    public List<Book> search(String query){
        if(query==null||query.isBlank()){
            return bookRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));
        }
        return bookRepository.findByTitleContainingIgnoreCase(query.trim());
    }
}
