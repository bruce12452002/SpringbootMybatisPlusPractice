package bruce.home.demo.service;

import bruce.home.demo.entity.Animal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface AnimalService extends IService<Animal> {
    int insertAnimal() throws CloneNotSupportedException;

    List<Animal> getAllAnimal();
}
