package id.abu.sistemabsensipolindra.models;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("user")
    private User user;
    @SerializedName("schedule")
    private Schedule schedule;

    public Result() {

    }

    public User getUser() {
        return user;
    }
    public Schedule getSchedule(){
        return schedule;
    }
}
