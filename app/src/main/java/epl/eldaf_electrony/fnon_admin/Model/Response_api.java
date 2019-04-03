package epl.eldaf_electrony.fnon_admin.Model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Response_api {
    @GET("Fnon_all_teacher.php")
    Call<List<contact_teacher>> getcontacts_teacher();
    @GET("Fnon_all_group.php")
    Call<List<contact_group>> getcontacts_group();
    @FormUrlEncoded
    @POST("Fnon_delete_group.php")
    Call<ResponseBody> getcontacts_delete_group(@Field("id") int id);
    @FormUrlEncoded
    @POST("Fnon_delete_teacher.php")
    Call<ResponseBody> getcontacts_delete_teacher(@Field("id") int id);
    @FormUrlEncoded
    @POST("Fnon_add_group.php")
    Call<ResponseBody> getcontacts_add_group(@Field("name") String name,@Field("teacher_id") int teacher_id,@Field("year") String year,@Field("group_name") String group_name
    ,@Field("type") String type,@Field("Stage") String Stage,@Field("num_student") int num_student,@Field("price") int price);
    @FormUrlEncoded
    @POST("Fnon_add_teacher.php")
    Call<ResponseBody> getcontacts_add_teacher(@Field("name") String name,@Field("phone") String phone,@Field("password") String password,@Field("Stage") String Stage
            ,@Field("address") String address);

}
