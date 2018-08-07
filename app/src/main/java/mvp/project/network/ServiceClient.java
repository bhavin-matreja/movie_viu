package mvp.project.network;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import retrofit.RestAdapter;
import retrofit.client.OkClient;


public class ServiceClient {
    private static ServiceClient instance;
    private RestAdapter mRestAdapter;
    private Map<String, Object> mClients = new HashMap<String, Object>();
    private String SERVER_BASE_URL="https://viu-android-test.herokuapp.com";

    private ServiceClient() {
    }

    public static ServiceClient getInstance() {
        if (null == instance) {
            instance = new ServiceClient();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getClient(Class<T> clazz) {

        if (mRestAdapter == null) {

            mRestAdapter = new RestAdapter.Builder()
                    .setEndpoint(SERVER_BASE_URL)
                    .setClient(new OkClient( getClient()))
                    .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {

                @Override
                public void log(String arg0) {
                    Log.d("** ServiceClient ** ", arg0);
                }
            }).build();

        }
        T client = null;
        if ((client = (T) mClients.get(clazz.getCanonicalName())) != null) {
            return client;
        }
        client = mRestAdapter.create(clazz);
        mClients.put(clazz.getCanonicalName(), client);

        return client;
    }

    private OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(1, TimeUnit.MINUTES);
        client.setReadTimeout(1, TimeUnit.MINUTES);
        return client;
    }
}
