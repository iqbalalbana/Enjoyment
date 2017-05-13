package id.sch.smktelkom_mlg.privateassignment.xirpl136.enjoyment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Yuzron on 13/05/2017.
 */


public class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.ViewHolder> {

    private List<HomeListItem2> homeListItems2;
    private Context context;

    //model dari HomeList
    public HomeAdapter2(List<HomeListItem2> homeListItems2, Context context) {
        this.homeListItems2 = homeListItems2;
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
                .inflate(R.layout.second_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final HomeListItem2 homeListItem2 = homeListItems2.get(position);

//        holder.textViewJudulTV.setText(homeListItem2.getJudul());
//        //holder.imageViewOtof.setImageURI(homeListItem.getImageUrl());
        //glide ini nnt

//
//
//        }
//        );
        Glide
                .with(context)
                .load(homeListItem2.getBackdrop())
                .into(holder.imageViewTV);
        holder.imageViewTV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, homeListItem2.getJudul() + " dipilih", Toast.LENGTH_LONG).show();
                Intent singleBlogIntent = new Intent(context, SecondActivity.class);
                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                singleBlogIntent.putExtra("blog_id", position);
                context.startActivity(singleBlogIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return homeListItems2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        //        public TextView textViewJudulTV;
        public ImageView imageViewTV;

        public ViewHolder(View itemView) {
            super(itemView);

//            textViewJudulTV = (TextView) itemView.findViewById(R.id.textViewJudulTV);
            imageViewTV = (ImageView) itemView.findViewById(R.id.imageViewTV);


        }
    }
}
