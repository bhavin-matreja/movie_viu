package mvp.project;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mvp.project.ui.login.LoginContract;
import mvp.project.ui.login.LoginPresenter;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Bhavin on 8/19/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginContract.ILoginView view;

    @InjectMocks
    LoginPresenter loginPresenter = new LoginPresenter(view);

    @Test
    public void passSucess() {
        Assert.assertEquals(1,1);
    }

    @Test
    public void shouldShowEmailEmptyError(){
        loginPresenter.validateCredentials("","");
        verify(view).setEmailEmptyError(R.string.error_email_empty);
    }

    @Test public void shouldShowPasswordEmptyError(){
        loginPresenter.validateCredentials("email","");
        verify(view).setPasswordEmptyError(R.string.error_password_empty);
    }
}
