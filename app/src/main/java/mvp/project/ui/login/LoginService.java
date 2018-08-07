package mvp.project.ui.login;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import mvp.project.model.LoginModel;
import mvp.project.network.ServiceApi;
import mvp.project.network.ServiceClient;

/**
 * Created by Bhavin on 8/19/2017.
 */

public class LoginService implements LoginContract.ILoginService {

    @Override
    public void login(String username, String password, final OnLoginFinishedListener listener) {

        final LoginModel loginModel = new LoginModel(username, password);

        ServiceApi.Login api = ServiceClient.getInstance().getClient(ServiceApi.Login.class);

        api.callLoginApi(loginModel, new Callback<String>() {

            @Override
            public void success(String s, Response response) {
                listener.onLoginSuccess();
            }

            @Override
            public void failure(RetrofitError error) {
               /* if(error.getResponse().getStatus()== ServiceConstants.UNAUTHORIZED){
                    listener.onLoginFailure();
                    return;
                }*/
                listener.onLoginSuccess();
            }
        });
    }
}
