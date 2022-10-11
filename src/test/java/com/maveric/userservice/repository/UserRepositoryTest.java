package com.maveric.userservice.repository;

import com.maveric.userservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static com.maveric.userservice.UserServiceApplicationTests.getUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void testSave() {
        User user = repository.save(getUser());
        assertEquals("manisha",user.getFirstName());
    }

    @Test
    public void testFindAll() {
        List<User> user = repository.findAll();
        assertNotNull(user);
        assert(user.size()>0);
    }
}
