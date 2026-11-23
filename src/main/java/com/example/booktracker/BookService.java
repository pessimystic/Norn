package com.example.booktracker;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
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

    private void apply(BookForm form, Book book){
        book.setTitle(form.getTitle().trim());
        book.setAuthor(form.getAuthor().trim());
        book.setGenre(blankToNull(form.getGenre()));
        book.setStatus(form.getStatus());
        book.setRating(form.getRating());
        book.setReview(blankToNull(form.getReview()));
    }

    public Book create(BookForm form) {
        Book book = new Book();
        apply(form,book);
        return bookRepository.save(book);
    }

    public Book get(Long id){
        return bookRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not Found"));//first time looking at lambda heh
    }

    public BookForm toForm(Book book){
        BookForm form = new BookForm();
        form.setTitle(book.getTitle());
        form.setAuthor(book.getAuthor());
        form.setGenre(book.getGenre());
        form.setStatus(book.getStatus());
        form.setRating(book.getRating());
        form.setReview(book.getReview());
        return form;
    }
    public void update(Long id, BookForm form){
        Book book = get(id);
        apply(form,book);
        bookRepository.save(book);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    private String blankToNull(String text){
        return (text == null || text.isBlank() ? null : text.trim());
    }
}
