package epl.eldaf_electrony.fnon_admin.View;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import epl.eldaf_electrony.fnon_admin.Adapter.RecyclerAdapter_deleteannonce;
import epl.eldaf_electrony.fnon_admin.Model.ApiConfigration;
import epl.eldaf_electrony.fnon_admin.Model.Response_api;
import epl.eldaf_electrony.fnon_admin.Model.contact_annonce;
import epl.eldaf_electrony.fnon_admin.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delete_annonce extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter_deleteannonce recyclerAdapter_secondry;
    private List<contact_annonce> contactList;
    private Response_api apiinterface;
    int id = 0;
    String name;
    int sec_id;
    Typeface myTypeface;
    Intent intent;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_annonce);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        textView = (TextView) findViewById(R.id.toolbar_title);
        progressBar.setVisibility(View.VISIBLE);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        intent = getIntent();
        name = intent.getStringExtra("name");
        id = intent.getIntExtra("id", 0);

//        myTypeface = Typeface.createFromAsset(getAssets(), "fonts/flat.ttf");
        textView.setText("مسح خبر");
        textView.setTypeface(myTypeface);

        this.setTitle("");
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
        Call<List<contact_annonce>> call = apiinterface.getcontacts_annonce();
        call.enqueue(new Callback<List<contact_annonce>>() {
            @Override
            public void onResponse(Call<List<contact_annonce>> call, Response<List<contact_annonce>> response) {
                contactList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerAdapter_secondry = new RecyclerAdapter_deleteannonce(Delete_annonce.this, contactList);
                recyclerView.setAdapter(recyclerAdapter_secondry);


            }

            @Override
            public void onFailure(Call<List<contact_annonce>> call, Throwable t) {

            }
        });
    }
}