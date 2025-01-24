package com.sda.sdaspring.controllers;

import com.sda.sdaspring.models.Bird;
import com.sda.sdaspring.models.Food;
import com.sda.sdaspring.models.dtos.BirdDTO;
import com.sda.sdaspring.services.BirdService;
import com.sda.sdaspring.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birds")
@CrossOrigin(origins = "http://localhost:8081")
public class BirdRestController {

    private final BirdService birdService;
    private final FoodService foodService;

    @Autowired
    public BirdRestController(BirdService birdService, FoodService foodService) {
        this.birdService = birdService;
        this.foodService = foodService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Bird>> getAllBirds() {
        return new ResponseEntity<>(birdService.getBirds(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bird> getBirdById(@PathVariable Long id) {
        Bird bird = birdService.getBirdById(id);
        return bird != null ? new ResponseEntity<>(bird, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBird(@RequestBody BirdDTO birdDTO) {
        Bird bird = new Bird(birdDTO.getName(), birdDTO.isCanFly(), birdDTO.getWeight());
        birdService.createBird(bird);
        return new ResponseEntity<>("Bird created successfully", HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateBirdWeight(@PathVariable Long id) {
        birdService.updateBird(id);
        return new ResponseEntity<>("Bird weight increased successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBird(@PathVariable Long id) {
        birdService.deleteBird(id);
        return new ResponseEntity<>("Bird deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/{birdId}/add-food")
    public ResponseEntity<String> addFoodToBird(@PathVariable Long birdId, @RequestParam Long foodId) {
        Bird bird = birdService.getBirdById(birdId);
        Food food = foodService.getFoodById(foodId);

        if (bird == null || food == null) {
            return new ResponseEntity<>("Bird or Food not found", HttpStatus.NOT_FOUND);
        }

        if (!bird.getFoods().contains(food)) {
            bird.getFoods().add(food);
            birdService.createBird(bird);
            return new ResponseEntity<>("Food added to bird successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Food already exists for this bird", HttpStatus.CONFLICT);
        }
    }
}
