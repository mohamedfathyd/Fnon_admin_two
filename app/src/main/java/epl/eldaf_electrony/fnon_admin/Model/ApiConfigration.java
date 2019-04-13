package epl.eldaf_electrony.fnon_admin.Model;


import android.provider.SyncStateContract;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfigration extends SyncStateContract.Constants {
    private static final String url="http://mano-ad.com/";
    private static Retrofit retrofit =null;
    public static Retrofit getapiClient(){
        if(retrofit== null){
            retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
