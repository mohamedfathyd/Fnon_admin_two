package epl.eldaf_electrony.fnon_admin.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import epl.eldaf_electrony.fnon_admin.Adapter.RecyclerAdapter_deletefirst;
import epl.eldaf_electrony.fnon_admin.Adapter.RecyclerAdapter_deletefirst_student;
import epl.eldaf_electrony.fnon_admin.Model.ApiConfigration;
import epl.eldaf_electrony.fnon_admin.Model.Response_api;
import epl.eldaf_electrony.fnon_admin.Model.contact_student;
import epl.eldaf_electrony.fnon_admin.Model.contact_teacher;
import epl.eldaf_electrony.fnon_admin.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delete_student extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter_deletefirst_student recyclerAdapter_secondry;
    private List<contact_student> contactList;
    private Response_api apiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        recyclerView = (RecyclerView) findViewById(R.id.review);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInfo();
    }
    public void fetchInfo() {
        apiinterface = ApiConfigration.getapiClient().create(Response_api.class);
        Call<List<contact_student>> call = ((Response_api) apiinterface).getcontacts_student();
        call.enqueue(new Callback<List<contact_student>>() {
            @Override
            public void onResponse(Call<List<contact_student>> call, Response<List<contact_student>> response) {
                contactList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerAdapter_secondry = new RecyclerAdapter_deletefirst_student(Delete_student.this, contactList);
                recyclerView.setAdapter(recyclerAdapter_secondry);


            }

            @Override
            public void onFailure(Call<List<contact_student>> call, Throwable t) {

            }
        });
    }
}
