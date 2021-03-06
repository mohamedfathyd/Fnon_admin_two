package epl.eldaf_electrony.fnon_admin.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.List;

import epl.eldaf_electrony.fnon_admin.Model.ApiConfigration;
import epl.eldaf_electrony.fnon_admin.Model.Response_api;
import epl.eldaf_electrony.fnon_admin.Model.contact_annonce;
import epl.eldaf_electrony.fnon_admin.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter_deleteannonce extends RecyclerView.Adapter<RecyclerAdapter_deleteannonce.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_annonce> contactslist;
     Response_api apiinterface;
    public RecyclerAdapter_deleteannonce(Context context, List<contact_annonce> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_delete_annonce,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

//        myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/flat.ttf");

        Glide.with(context).load(contactslist.get(position).getImage()).error(R.drawable.logo).into(holder.image);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new AlertDialog.Builder(context)
                       .setTitle("Fnon")
                       .setMessage("هل انت متأكد انك تريد المسح ؟")
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                           public void onClick(DialogInterface dialog, int whichButton) {
                               int id=contactslist.get(position).getId();
                               fetchInfo(id);
                           }})
                       .setNegativeButton(android.R.string.no, null).show();

           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView image;

        ImageView delete;
    public MyViewHolder(View itemView) {
        super(itemView);

        image=(ImageView)itemView.findViewById(R.id.imageView3);


    }
}
    public void fetchInfo(int id) {

        apiinterface= ApiConfigration.getapiClient().create(Response_api.class);
        Call<ResponseBody> call = null;
        call=apiinterface.delete_annonce(id);



        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Toast.makeText(context,"تم المسح",Toast.LENGTH_LONG).show();
                ((Activity)context).finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



    }
}