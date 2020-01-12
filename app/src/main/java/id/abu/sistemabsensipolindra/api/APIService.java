package id.abu.sistemabsensipolindra.api;
import java.util.List;

import id.abu.sistemabsensipolindra.models.Result;

import id.abu.sistemabsensipolindra.models.Schedule;
import id.abu.sistemabsensipolindra.models.Schedules;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIService {

    //Cal SignIn
    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("identity") String identity,
            @Field("password") String password
    );

//    @GET("schedules")
//    Call<Schedules> getSchedules();

    @GET("schedules")
    Call<List<Schedules>> getSchedules(@Header("Content-Range") String contentRange);

}
