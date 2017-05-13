package id.sch.smktelkom_mlg.privateassignment.xirpl136.enjoyment;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Yuzron on 13/05/2017.
 */
public class HomeAdapter3 extends RecyclerView.Adapter<HomeAdapter3.ViewHolder> {

    private List<HomeListItem3> homeListItems3;
    private Context context;

    //model dari HomeList
    public HomeAdapter3(List<HomeListItem3> homeListItems3, Context context) {
        this.homeListItems3 = homeListItems3;
        this.context = context;
    }

//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.home_item, parent, false);
//        return new ViewHolder(v);
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.third_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final HomeListItem3 homeListItem3 = homeListItems3.get(position);

//        holder.textViewJudulTV.setText(homeListItem2.getJudul());
//        //holder.imageViewOtof.setImageURI(homeListItem.getImageUrl());
        //glide ini nnt

//
//
//        }
//        );
        Glide
                .with(context)
                .load(homeListItem3.getImage())
                .into(holder.imageViewMarvel);
        holder.imageViewMarvel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //            Toast.makeText(context, homeListItem3.getNama() + " dipilih", Toast.LENGTH_LONG).show();
                Intent singleBlogIntent = new Intent(context, ThirdActivity.class);
                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                singleBlogIntent.putExtra("blog_id", position);
                context.startActivity(singleBlogIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return homeListItems3.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        //        public TextView textViewJudulTV;
        public ImageView imageViewMarvel;

        public ViewHolder(View itemView) {
            super(itemView);

//            textViewJudulTV = (TextView) itemView.findViewById(R.id.textViewJudulTV);
            imageViewMarvel = (ImageView) itemView.findViewById(R.id.imageViewMarvel);


        }
    }
}
