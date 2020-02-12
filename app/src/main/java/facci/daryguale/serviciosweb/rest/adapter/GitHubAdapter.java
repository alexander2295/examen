package facci.daryguale.serviciosweb.rest.adapter;

import java.util.List;

import facci.daryguale.serviciosweb.rest.contasts.ApiConstants;
import facci.daryguale.serviciosweb.rest.model.Owner;
import facci.daryguale.serviciosweb.rest.service.GitHubService;
import retrofit2.Call;

public class GitHubAdapter extends  BaseAdapter implements GitHubService {

    private GitHubService gitHubService;
    public GitHubAdapter(){
        super(ApiConstants.BASE_GITHUB_URL);
        gitHubService = createService(GitHubService.class);


    }


    @Override
    public Call<Owner> getOwner(Integer owner) {
        return gitHubService.getOwner(owner);
    }

    @Override
    public Call<List<Owner>> getOwnerFollowers() {
        return gitHubService.getOwnerFollowers();
    }
}
