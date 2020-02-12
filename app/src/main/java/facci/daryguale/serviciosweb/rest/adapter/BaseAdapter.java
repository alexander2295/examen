package facci.daryguale.serviciosweb.rest.adapter;

import android.os.Build;

import facci.daryguale.serviciosweb.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseAdapter {

    private static Retrofit retrofit;
    private static HttpLoggingInterceptor.Level Level_Log
            = HttpLoggingInterceptor.Level.BODY;

    BaseAdapter(String baseUrl){ init(baseUrl);}

    private void init(String baseUrl) {

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(getClient()).
                    addConverterFactory(GsonConverterFactory.create()).build();

        }
    }

    private OkHttpClient getClient() {
        OkHttpClient.Builder builderClientHttp = new OkHttpClient().newBuilder();

        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(Level_Log);
            builderClientHttp.addInterceptor(interceptor);

        }
        return builderClientHttp.build();
    }
    <T> T createService(Class<T>_class){return retrofit.create(_class);}
}
