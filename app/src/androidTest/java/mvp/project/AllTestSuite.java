package mvp.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Bhavin on 8/21/2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses ({
        LoginPresenterTest.class,
        MoviesPresenterTest.class,
        MovieDetailPresenterTest.class
})
public class AllTestSuite {

}
