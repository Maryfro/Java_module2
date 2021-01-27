import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurHashSetTest extends OurSetTest {

    @BeforeEach
    public void init() {
        set = new OurHashSet<>();
    }

}