package other_stuff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_01 extends TestWrapper{
        @Test
        public void test_1(){
            String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
            System.out.println( functionName );
            assertEquals("aaa", "aaa");
        }

        @Test
        public void test_2(){
            String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
            System.out.println( functionName );
            assertTrue(true);
        }
}
