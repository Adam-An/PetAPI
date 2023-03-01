package zack.san.PetApi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserRepository;
import zack.san.PetApi.user.UserServiceImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private List<User> mockItems;

    @Before
    public void setUp() {
        User user1 = new User(1L,
                "user1",
                "John",
                "Doe",
                "user1@example.com",
                "password");
        User user2 = new User(1L,
                "user2",
                "Jane",
                "Torie",
                "user2@example.com",
                "password");
        user = user1;
        mockItems = Arrays.asList(user1,user2);
    }

    @Test
    public void testFindAllReturnsAllUsersFromRepository(){
        //Arrange
        Mockito.when(userRepositoryMock.findAll()).thenReturn(mockItems);
        //Act
        List<User> result = userService.findAll();

        //Assert
        Assert.assertTrue(result.size() == 2);
        Assert.assertTrue(result.get(0).getUserId() == 1L);

    }

    @Test
    public void testFindByIdFromRepository() {
        //Arrange
        Mockito.when(userRepositoryMock.findById(1L)).thenReturn(Optional.of(user));
        //Act
        User result = userService.findById(1L);
        //Assert
        Assert.assertEquals(user,result);
    }

    @Test
    public void testUpdateUserFromRepository(){
        //Arrange
        Mockito.when(userRepositoryMock.findById(1L)).thenReturn(Optional.of(user));

        //Act
        user.setUsername("userUpdated");
        userService.update(user);
        Optional<User> updatedUser = userRepositoryMock.findById(1L);

        //Assert
        // Assert.assertEquals(1L,updatedUser.getUserId().longValue());
        Assert.assertEquals("userUpdated",updatedUser.get().getUsername());
        Mockito.verify(userRepositoryMock).save(user);

    }


    @Test
    public void testSaveUserFromRepository(){

        //Arrange
        Mockito.when(userRepositoryMock.save(user)).thenReturn(user);
        //Act
        User savedUser = userService.save(user);
        //Assert
        Assert.assertEquals(user,savedUser);


    }


    @Test
    public void testDeleteUserFromRepository()
    {
        UserServiceImpl userService = Mockito.mock(UserServiceImpl.class);
        userService.delete(user);
        Mockito.verify(userService,Mockito.times(1)).delete(user);


    }










}
