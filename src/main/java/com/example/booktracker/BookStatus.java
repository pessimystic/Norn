package com.example.booktracker;

public enum BookStatus {
    TBR("To Be Read"),
    READING("Currently Reading"),
    FINISHED("Finished");

    private final String label;

    BookStatus(String label){
        this.label=label;
    }

    public String getLabel(){
        return label;
    }
}
