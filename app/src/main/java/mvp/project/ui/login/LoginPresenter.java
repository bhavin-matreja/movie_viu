package mvp.project.ui.login;

import mvp.project.R;

/**
 * Created by Bhavin on 8/18/2017.
 */

public class LoginPresenter implements LoginContract.ILoginService.OnLoginFinishedListener {

    private LoginContract.ILoginView view;
    private LoginContract.ILoginService service;

    public LoginPresenter(LoginContract.ILoginView view) {
        this.view = view;
        service = new LoginService();
    }

    public void validateCredentials(String email, String password) {
        if(email.isEmpty()){
            view.setEmailEmptyError(R.string.error_email_empty);
            return;
        }
        if(password.isEmpty()){
            view.setPasswordEmptyError(R.string.error_password_empty);
            return;
        }

        view.showProgressDialog();
        service.login(email,password,this);
    }

    @Override
    public void onLoginSuccess() {
        view.hideProgressDialog();
        view.startMoviesActivity();
    }

    @Override
    public void onLoginFailure() {
        view.hideProgressDialog();
        view.showUnsuccessfulLoginError(R.string.error_login_unsuccessful);
    }
}
