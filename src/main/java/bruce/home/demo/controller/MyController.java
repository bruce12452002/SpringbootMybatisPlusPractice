package bruce.home.demo.controller;

import bruce.home.demo.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {
    @Resource
    private AnimalService animalService;

    @RequestMapping("test")
    public int saveAnimal() throws CloneNotSupportedException {
        return animalService.insertAnimal();
    }
}
