package com.cupcakes.my;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], int img[]) {

        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_rowlist, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {

        holder.mytxt1.setText(data1[position]);
        holder.mytxt2.setText(data2[position]);
        holder.myimage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, SecondActivity.class);
                in.putExtra("data1", data1[position]);
                in.putExtra("data2", data2[position]);
                in.putExtra("myImage", images[position]);

                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytxt1, mytxt2;
        ImageView myimage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mytxt1 = itemView.findViewById(R.id.txt1);
            mytxt2 = itemView.findViewById(R.id.txt2);
            myimage = itemView.findViewById(R.id.myimageView);
            mainLayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}
