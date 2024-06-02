import com.penaltyeleven.basedatos.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    public void setup() {
        user = new User("TestUser", 100);
    }

    @Test
    public void getNombre_returnsCorrectName() {
        assertEquals("TestUser", user.getNombre());
    }

    @Test
    public void getPuntuacion_returnsCorrectScore() {
        assertEquals(100, user.getPuntuacion());
    }
}