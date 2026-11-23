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
    public Book create(BookForm form) {
        Book book = new Book();
        book.setTitle(form.getTitle().trim());
        book.setAuthor(form.getAuthor().trim());
        book.setGenre(blankToNull(form.getGenre()));
        book.setStatus(form.getStatus());
        book.setRating(form.getRating());
        book.setReview(blankToNull(form.getReview()));

        return bookRepository.save(book);
    }

    private String blankToNull(String text){
        return (text == null || text.isBlank() ? null : text.trim());
    }
}
