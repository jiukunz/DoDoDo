package serviceTests;

import com.thoughtworks.spring.jpa.tomcat.dao.UserDao;
import com.thoughtworks.spring.jpa.tomcat.entities.User;
import com.thoughtworks.spring.jpa.tomcat.helpers.PasswordEncoding;
import com.thoughtworks.spring.jpa.tomcat.services.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginServiceTest {
    @InjectMocks
    LoginService loginService;
    @Mock
    UserDao userDao;
    @Mock
    PasswordEncoding passwordEncoding;
    private String email;
    private String password;
    private User user;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        email = "username";
        password = "123456";
        user = new User();
    }

    @Test
    public void shouldReturnTrueWhenUserIsCorrect() throws Exception {
        user.setPassword(password);
        when(userDao.selectUserByUsername(email)).thenReturn(user);
        when(passwordEncoding.encode2hex(password)).thenReturn(password);
        Boolean actual = loginService.validateUser(email, password);
        Boolean expect = true;

        assertThat(actual, is(expect));
    }

    @Test
    public void shouldReturnFalseWhenUserIsIncorrect() throws Exception {
        user.setPassword(password);
        when(userDao.selectUserByUsername(email)).thenReturn(user);
        when(passwordEncoding.encode2hex(password)).thenReturn(password);
        String incorrectPassword = "111111";
        Boolean actual = loginService.validateUser(email, incorrectPassword);
        Boolean expect = false;

        assertThat(actual, is(expect));
    }
}
