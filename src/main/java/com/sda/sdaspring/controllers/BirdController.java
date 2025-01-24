package com.sda.sdaspring.controllers;

import com.sda.sdaspring.models.Bird;
import com.sda.sdaspring.models.Food;
import com.sda.sdaspring.services.BirdService;
import com.sda.sdaspring.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class BirdController {

    private final BirdService birdService;
    private final FoodService foodService;

    @Autowired
    public BirdController(BirdService birdService, FoodService foodService) {
        this.birdService = birdService;
        this.foodService = foodService;
    }

    @GetMapping("/")
    public String getMainPage(Model model,
                              @RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "sortBy", required = false) String sortBy) {
        model.addAttribute("welcomeString", "Welcome to the Charming Birdhouse");
        if (Objects.nonNull(search)) {
            model.addAttribute("birds", birdService.getBirdsByName(search));
        } else if (Objects.nonNull(sortBy)) {
            model.addAttribute("birds", birdService.findAllSorted(sortBy));
        } else {
            model.addAttribute("birds", birdService.getBirds());
        }
        return "index";
    }

    @GetMapping("/add-bird")
    public String getBirdForm() {
        return "add-bird";
    }

    @PostMapping("/add-bird")
    public String createBird(@RequestParam String name,
                             @RequestParam(required = false, defaultValue = "false") boolean canFly,
                             @RequestParam int weight) {
        Bird bird = new Bird(name, canFly, weight);
        birdService.createBird(bird);
        return "redirect:/";
    }

    @GetMapping("/bird-details/{bird}")
    public String showDetails(@PathVariable("bird") Long birdOrder, Model model) {
        model.addAttribute("bird", birdService.getBirdById(birdOrder));
        model.addAttribute("foods", foodService.getAllFoods());
        return "bird-details";
    }

    @PostMapping("/bird-details/{birdId}/add-food")
    public String addFoodToBird(@PathVariable Long birdId, @RequestParam Long foodId) {
        Bird bird = birdService.getBirdById(birdId);
        Food food = foodService.getFoodById(foodId);

        if (!bird.getFoods().contains(food)) {
            bird.getFoods().add(food);
            birdService.createBird(bird);
        }
        return "redirect:/bird-details/" + birdId;
    }


    @GetMapping("/delete/{id}")
    public String deleteBird(@PathVariable("id") Long birdOrder) {
        birdService.deleteBird(birdOrder);
        return "redirect:/";
    }

    @GetMapping("/increase/{id}")
    public String increaseBirdWeight(@PathVariable("id") Long birdOrder) {
        birdService.updateBird(birdOrder);
        return "redirect:/";
    }

    @GetMapping("/flying-jpql")
    public String findFlyingJPQL(Model model) {
        model.addAttribute("birds", birdService.findFlyingJPQL());
        return "index";
    }

    @GetMapping("/flying-native")
    public String findFlyingNative(Model model) {
        model.addAttribute("birds", birdService.findFlyingNative());
        return "index";
    }
}