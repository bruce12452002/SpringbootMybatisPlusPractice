package bruce.home.demo.service;

import bruce.home.demo.entity.Animal;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AnimalService extends IService<Animal> {
    int insertAnimal() throws CloneNotSupportedException;
}
