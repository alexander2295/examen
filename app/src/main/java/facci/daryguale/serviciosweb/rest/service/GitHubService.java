package facci.daryguale.serviciosweb.rest.service;

import java.util.List;

import facci.daryguale.serviciosweb.Main2ActivityEnviar;
import facci.daryguale.serviciosweb.rest.contasts.ApiConstants;
import facci.daryguale.serviciosweb.rest.model.Owner;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GitHubService {

    @GET(ApiConstants.GITHUB_USER_ENDPOINT)
    Call<Owner> getOwner(@Path("cedulaestudiante") String owner);

    @GET(ApiConstants.GITHUB_FOLLOWERS_ENDPOINT)
    Call<List<Owner>> getOwnerFollowers(@Path("cedulaestudiante") String owner);


    @POST(ApiConstants.GITHUB_SEND)
    Call<Owner> setEnviar(@Body Main2ActivityEnviar.Enviar enviar);


}
