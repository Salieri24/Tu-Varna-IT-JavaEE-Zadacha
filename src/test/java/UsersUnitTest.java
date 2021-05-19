import com.example.Uni_login.Repository;
import com.example.Uni_login.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsersUnitTest {
    @Test
    public void xmlTest(){
        Repository.getInstance().saveUser(new User("name1","username1","password1"));

    }
}
