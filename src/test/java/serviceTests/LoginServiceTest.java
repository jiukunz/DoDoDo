package serviceTests;

import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class LoginServiceTest {
    @InjectMocks
    LoginService loginService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

    }

    @Test
    public void shouldReturnTrueWhenUserIsCorrect() throws Exception {
//        String actual = loginService.validateUser(username, password);

    }
}
