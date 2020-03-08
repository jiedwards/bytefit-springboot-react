package com.example.bytefitjava.bytefit.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

}