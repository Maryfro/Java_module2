import org.junit.*;

import java.util.jar.JarOutputStream;

import static org.junit.Assert.*;

public class ManipulatorTest {
    Manipulator manipulator = new Manipulator();

   /* @Before
    public void init(){
        manipulator = new Manipulator();
        System.out.println("test start");
    }

    @After
    public void end(){
        System.out.println("test is over");
    }*/


    @Ignore
    @Test
    public void testCompareNumbers_FalseCase(){
        boolean b = manipulator.compareNumbers(3,5);
        Assert.assertFalse(b);
    }

    @Test
    public void testCompareNumbers_TrueCase(){
        assertTrue("True case", manipulator.compareNumbers(5,3));
    }

    @Test
    public void testConcatValue(){
        assertEquals("my test", "aabb", manipulator.concat("aa", "bb"));
    }

    @Test
    public void testConcatLengthResult(){
        String res = manipulator.concat("aa", "bb");
        assertEquals("my test", 4, res.length());
    }

    @Test
    public void testConcatNotNull(){
        String res = manipulator.concat("aa", "bb");
        assertNotNull("my test", res);

    }
}