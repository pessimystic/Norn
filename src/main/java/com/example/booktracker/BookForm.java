package com.example.booktracker;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookForm {

    @NotBlank(message="Title is required")
    @Size(max=255, message="Title can be at most 255 characters")
    private String title;

    @NotBlank(message="Author is required")
    @Size(max=255, message="Author can be at most 255 characters")
    private String author;

    @Size(max=100, message="Genre can be at most 100 characters")
    private String genre;

    @NotNull(message="Please choose a status")
    private BookStatus status = BookStatus.TBR;

    @Min(value=1, message="Rating must be Between 1 and 5")
    @Max(value=5, message="Rating must be Between 1 and 5")
    private Integer rating;

    @Size(max=5000,message="Review can be at most 5000 characters")
    private String review;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
