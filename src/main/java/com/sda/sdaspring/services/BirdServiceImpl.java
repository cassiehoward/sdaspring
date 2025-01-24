package com.sda.sdaspring.services;

import com.sda.sdaspring.models.Bird;
import com.sda.sdaspring.repositories.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;

    @Autowired
    public BirdServiceImpl(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }


    @Override
    public List<Bird> getBirds() {
        return birdRepository.findAll();
    }

    @Override
    public Bird getBirdById(Long id) {
        return birdRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Bird with id " + id + " not found.")
        );
    }

    @Override
    public List<Bird> getBirdsByName(String search) {
        return birdRepository.findBirdsByNameContainsIgnoreCase(search);

    }

    @Override
    public void createBird(Bird bird) {
        birdRepository.save(bird);
    }

    @Override
    public void deleteBird(Long id) {
        Optional<Bird> bird = birdRepository.findById(id);
        if (bird.isPresent()) {
            birdRepository.delete(bird.get());
        }
    }

    @Override
    public void updateBird(Long id) {
        Optional<Bird> bird = birdRepository.findById(id);
        if (bird.isPresent()) {
            Bird b = bird.get();
            b.setWeight(b.getWeight() + 50);
            birdRepository.save(b);
        }
    }

    @Override
    public List<Bird> findFlyingJPQL() {
        return birdRepository.findAllFlyingBirds();
    }

    @Override
    public List<Bird> findFlyingNative() {
        return birdRepository.findAllFlyingBirdsNative();
    }

    @Override
    public List<Bird> findAllSorted(String parameter) {
        return birdRepository.findAll(Sort.by(parameter));
    }


}
