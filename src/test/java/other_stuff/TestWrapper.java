package other_stuff;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {Test_01.class})
public class TestWrapper {

    @Before
    public void beforeSimple(){
        String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println( functionName );
    }

    @After
    public void afterSimple(){
        String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println( functionName );
    }
}
