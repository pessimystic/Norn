package com.example.booktracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private BookStatus status=BookStatus.TBR;

    private String genre;
    private Integer rating;

    @Column(columnDefinition="TEXT")
    private String review;

    @CreationTimestamp
    @Column(nullable=false,updatable = false)
    private LocalDateTime createdAt;


    public Book(){

    }
    public Long getId(){
        return Id;
    }
    public void setId(Long Id){
        this.Id=Id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(){
        this.author=author;
    }

    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating){
        this.rating=rating;
    }

    public String getReview(){
        return review;
    }
    public void setReview(String review){
        this.review=review;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
//getters and setters hehe
}