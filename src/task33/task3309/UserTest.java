package task33.task3309;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    private User user1;
    private User user2;

    private User userNotAdd;
    private User userNotAdd1;




    public static List<User> actual = new ArrayList<>();
    @Before
    public void setUp() {
       user = new User("Евгений", 35, Sex.MALE);
       user1 = new User("Марина", 34, Sex.FEMALE);
       user2 = new User("Алина", 7, Sex.FEMALE);

       userNotAdd = new User("", 0, null);
       userNotAdd1 = new User(null, 0, null);


        addNotNULL(user);
        addNotNULL(user1);
        addNotNULL(user2);
        addNotNULL(userNotAdd);
        addNotNULL(userNotAdd1);
        
    }

    public void addNotNULL(User user) {
        if (user.getName() != null && !user.getName().isEmpty() && user.getAge() > 0 && user.getSex() != null) {
            actual.add(user);
        }
    }

    @Test
    public void newUser_EMPTY_NAME() {
        for (User user : User.getAllUsers()) {
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создать пользователя с пустым именем");
            }
        }
    }

    @Test
    public void newUser_AGE_ZERO() {
        for (User user : User.getAllUsers()) {
            if (user.getAge() == 0) {
                Assert.fail("Попытка создать пользователя с нулевым возрастом");
            }
        }
    }

    @Test
    public void newUser_SEX_NULL() {
        for (User user : User.getAllUsers()) {
            if (user.getSex() == null) {
                Assert.fail("Попытка создать пользователя с без пола");
            }
        }
    }



    @Test
    public void getAllUsers() {

        List<User> expected = User.getAllUsers();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsersSex() {
        int countActualMan = 1;
        int countExpected = User.getAllUsers(Sex.MALE).size();
        Assert.assertEquals(countExpected, countActualMan);
    }



}