import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    public void EveryBranch() {
        User user1 = new User("borche","nesto","borche@gmail.com");
        User user2 = new User("dean@gmail.com","nesto","dean@gmail.com");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertFalse(() -> SILab2.function(new User(null, "dean", "dean@gmail.com"),users));
        assertFalse(() -> SILab2.function(new User("dean", "deki1234&5", "deangmailcom"),users));
        assertFalse(() -> SILab2.function(new User("dean", "deki 123 4&5", "deangmailcom"),users));
        assertFalse(() -> SILab2.function(new User("dean", "deki12345", "deangmailcom"),users));
    }

    @Test
    public void MultipleCondition(){
        assertThrows(RuntimeException.class, () -> SILab2.function(null,null));
        assertThrows(RuntimeException.class, () -> SILab2.function(new User("Dean",null,"dean.nastevski@students.finki.ukim.mk"),null));
        assertThrows(RuntimeException.class, () -> SILab2.function(new User("Dean","deki123UwU",null),null));

        User user1 = new User("borche","nesto","borche@gmail.com");
        User user2 = new User("dean@gmail.com","nesto","dean@gmail.com");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        assertFalse(() -> SILab2.function(new User("Dean","deki123UwU","dean.nastevski@students.finki.ukim.mk"),users));

    }
}