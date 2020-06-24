package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorsReporsitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorsReporsitory authorsReporsitory;

    public AuthorController(AuthorsReporsitory authorsReporsitory) {
        this.authorsReporsitory = authorsReporsitory;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorsReporsitory.findAll());
        return "authors/list";
    }
}
