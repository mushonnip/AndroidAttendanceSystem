package id.abu.sistemabsensipolindra.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

import id.abu.sistemabsensipolindra.R;
import id.abu.sistemabsensipolindra.adapter.ScheduleAdapter;
import id.abu.sistemabsensipolindra.api.APIService;
import id.abu.sistemabsensipolindra.api.APIUrl;
import id.abu.sistemabsensipolindra.models.Schedules;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvSchedule);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        token =
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .header
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        APIService service = retrofit.create(APIService.class);
        APIService apiService = retrofit.create(APIService.class);
        Call<Schedules> call =  apiService.getSchedules();
        call.enqueue(new Callback<Schedules>() {
            @Override
            public void onResponse(Call<Schedules> call, Response<Schedules> response) {
                assert response.body() != null;
                adapter = new ScheduleAdapter(response.body().getSchedules(), getActivity());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Schedules> call, Throwable t) {

            }
        });




        final NavController navController =
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

    }
}
