package com.board.testboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Product prod = new Product(i, "Book_" + Integer.toString(i), i * 1000);

            products.add(prod);
        }
        Store store = new Store("Blank Store", "Seoul");
//        model.addAttribute("data", "blank");
        model.addAttribute("store", store);
        model.addAttribute("list", products);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
