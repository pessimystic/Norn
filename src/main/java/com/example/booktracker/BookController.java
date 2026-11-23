package com.example.booktracker;

import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String list(@RequestParam (required=false) String q,Model model) {
        model.addAttribute("books",bookService.search(q));
        model.addAttribute("q",q);
        if(!model.containsAttribute("bookForm")){
            model.addAttribute("bookForm",new BookForm());

        }
        return "books";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("bookForm") BookForm form,BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("books",bookService.search(null));
            model.addAttribute("q","");
            return "books";
        }
        bookService.create(form);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books";
    }
}
