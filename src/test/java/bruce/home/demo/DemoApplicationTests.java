package bruce.home.demo;

import bruce.home.demo.entity.Animal;
import bruce.home.demo.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class DemoApplicationTests {
	@Resource
	private AnimalService animalService;


	@Test
	void insertAnimal() {
		Animal animal = Animal.builder()
				.name("老鼠")
				.price(50)
				.date(LocalDateTime.now()).build();
		boolean b = animalService.save(animal);
		System.out.println(b);
	}

	@Test
	void testService() throws CloneNotSupportedException {
		int i = animalService.insertAnimal();
		System.out.println(i);
	}
}
