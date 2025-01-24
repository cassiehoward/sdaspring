package com.sda.sdaspring;

//import com.sda.sdaspring.models.*;
//import com.sda.sdaspring.repositories.BirdRepository;
//import com.sda.sdaspring.repositories.FoodRepository;
//import com.sda.sdaspring.repositories.NestRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import java.util.ArrayList;
//import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SdaspringApplication  {

//    private final BirdRepository birdRepository;
//    private final NestRepository nestRepository;
//    private final FoodRepository foodRepository;
//
//
//    @Autowired
//    public SdaspringApplication(BirdRepository birdRepository, NestRepository nestRepository, FoodRepository foodRepository) {
//        this.birdRepository = birdRepository;
//        this.nestRepository = nestRepository;
//        this.foodRepository = foodRepository;
//    }


    public static void main(String[] args) {
        SpringApplication.run(SdaspringApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        List<Bird> birds = new ArrayList<>(List.of(
//                new Bird("Eagle", true, 5500),
//                new Bird("Penguin", false, 4000),
//                new Bird("Sparrow", true, 25),
//                new Bird("Ostrich", false, 14000),
//                new Bird("Hawk", true, 1300),
//                new Bird("Flamingo", true, 3000),
//                new Bird("Parrot", true, 500),
//                new Bird("Albatross", true, 8000),
//                new Bird("Peacock", true, 5000),
//                new Bird("Crow", true, 400),
//                new Bird("Dove", true, 300),
//                new Bird("Pigeon", true, 500),
//                new Bird("Woodpecker", true, 200),
//                new Bird("Rooster", false, 2500),
//                new Bird("Turkey", false, 10000),
//                new Bird("Kiwi", false, 1200)
//        ));
//
//
//        List<TrackingDevice> trackingDevices = List.of(
//                new TrackingDevice("TD-001", "2024-01-01"),
//                new TrackingDevice("TD-002", "2024-02-01"),
//                new TrackingDevice("TD-003", "2024-03-01"),
//                new TrackingDevice("TD-004", "2024-04-01")
//        );
//
//        Nest nest1 = new Nest("Tree Nest", 5, "Twigs");
//        Nest nest2 = new Nest("Ground Nest", 3, "Grass");
//
//        nestRepository.save(nest1);
//        nestRepository.save(nest2);
//
//        birds.get(0).setNest(nest1);
//        birds.get(1).setNest(nest1);
//        birds.get(2).setNest(nest2);
//        birds.get(3).setNest(nest2);
//
//        Food food1 = new Food("Fish", 100);
//        Food food2 = new Food("Worms", 50);
//        Food food3 = new Food("Seeds", 10);
//        Food food4 = new Food("Berries", 25);
//        Food food5 = new Food("Insects", 30);
//
//        foodRepository.save(food1);
//        foodRepository.save(food2);
//        foodRepository.save(food3);
//        foodRepository.save(food4);
//        foodRepository.save(food5);
//
//        birds.get(0).setFoods(List.of(food1));
//        birds.get(1).setFoods(List.of(food2, food3));
//        birds.get(2).setFoods(List.of(food3, food4));
//        birds.get(3).setFoods(List.of(food1, food2, food5));
//
//        for (int i = 0; i < birds.size(); i++) {
//            Bird bird = birds.get(i);
//            if (i < trackingDevices.size()) {
//                TrackingDevice trackingDevice = trackingDevices.get(i);
//                bird.setTrackingDevice(trackingDevice);
//            }
//            birdRepository.save(bird);
//        }
//    }
}
