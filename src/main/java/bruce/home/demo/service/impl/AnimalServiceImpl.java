package bruce.home.demo.service.impl;

import bruce.home.demo.dao.AnimalMapper;
import bruce.home.demo.entity.Animal;
import bruce.home.demo.service.AnimalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AnimalServiceImpl extends ServiceImpl<AnimalMapper, Animal> implements AnimalService {
    @Resource
    private AnimalMapper animalMapper;

    @Override
    @Transactional//(rollbackFor = Exception.class)
    public int insertAnimal() throws CloneNotSupportedException {
        Animal animal = Animal.builder()
                .name("牛")
                .price(100)
                .date(LocalDateTime.now()).build();
        int count = animalMapper.insert(animal);
        System.out.println(count);
        // int i = 1 / 0; // 會回滾

        // try catch 事務就失效了，但使用 throws 可以，但要注意是不是檢查例外，非檢查(RunTimeException) 預設會回滾，而檢查例外預設不會回滾
        xxx(); // 不會回滾，想回滾要加上 rollbackFor = Exception.class 才會回滾
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Animal> getAllAnimal() {
        List<Animal> animals1 = animalMapper.selectList(null);
        System.out.println("one=" + animals1);

        try {
            TimeUnit.SECONDS.sleep(10); // 趁這空檔去 DB 改值，有加 @Transactional 時，在這個方法裡多次查詢的值都會是一樣的
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Animal> animals2 = animalMapper.selectList(null);
        System.out.println("two=" + animals2);

        // readOnly 為 true 時，寫資料庫會報錯
//        animalMapper.insert(Animal.builder()
//                .name("牛")
//                .price(100)
//                .date(LocalDateTime.now()).build());

        return null;
    }

    private void xxx() throws CloneNotSupportedException {
        this.clone();
    }
}
