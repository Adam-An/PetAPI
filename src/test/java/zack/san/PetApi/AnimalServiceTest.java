package zack.san.PetApi;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.animal.AnimalRepository;
import zack.san.PetApi.animal.AnimalServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;
    @InjectMocks
    private AnimalServiceImpl animalService;


    private Animal animal;

    private List<Animal> mockItems;


    @Before
    public void setUp(){

        Animal animal1 = new Animal();
        animal1.setName("Fluffy");
        animal1.setSpeciesName("Dog");
        animal1.setBreedType("Poodle");
        animal1.setGender("Male");
        animal1.setAge(3);
        animal1.setImgPath("/images/animal1.jpg");

        Animal animal2 = new Animal();
        animal2.setName("Whiskers");
        animal2.setSpeciesName("Cat");
        animal2.setBreedType("Siamese");
        animal2.setGender("Female");
        animal2.setAge(2);
        animal2.setImgPath("/images/animal2.jpg");

        animal = animal1;
        mockItems = Arrays.asList(animal1,animal2);
    }


    @Test
    public void testSaveAnimalFromRepository(){
        //Arrange
        Mockito.when(animalRepository.save(animal)).thenReturn(animal);
        Animal savedAnimal = animalService.save(animal);
        Assert.assertEquals(animal,savedAnimal);


    }

    @Test
    public void testFindAllAnimalFromAnimalRepository(){

        //Arrange
        Mockito.when(animalRepository.findAll()).thenReturn(mockItems);
        //Act
        List<Animal> result = animalService.findAll();
        //Assert
        Assert.assertTrue(result.size() == 2);
        Assert.assertTrue(result.get(0).getName() == "Fluffy");


    }










}
