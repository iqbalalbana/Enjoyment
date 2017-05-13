package id.sch.smktelkom_mlg.privateassignment.xirpl136.enjoyment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class HomeActivity extends AppCompatActivity {

    private static final String URL_DATA = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=cf48be249b4ace270b61684fe3644bae";
    public TextView textViewJudul;
    public TextView textViewTerbit;
    public TextView textViewOverview;
    public ImageView imageViewDetail;

    private Integer mPostkey = null;

//    public Button btnRate;
//    public Spinner spinnerRating;
//    public boolean isNew;
//    public Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPostkey = getIntent().getExtras().getInt("blog_id");


        loadRecyclerViewData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
//
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//
//                startActivity(intent);

            }

        });


        textViewJudul = (TextView) findViewById(R.id.textViewJudul);
        textViewTerbit = (TextView) findViewById(R.id.textViewTerbit);
        textViewOverview = (TextView) findViewById(R.id.textViewOverview);
        imageViewDetail = (ImageView) findViewById(R.id.imageViewDetail);

//        spinnerRating = (Spinner) findViewById(R.id.spinnerRating);
//        findViewById(R.id.btnRate).setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        doRate();
//                    }
//                }
//        );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
//    private void fillData() {
//        spinnerRating.setSelected(place.rate);
//    }
//    private void doRate() {
//        String rate = spinnerRating.getSelectedItem().toString();
//
//        if (rate.isEmpty())
//        {
//        //    Snackbar.make(findViewById(R.id.spinnerRating), place.ra + " Terhapus", Snackbar.LENGTH_LONG)
//        }
//        else
//        {
//            if (isNew){
//                place = new Place(rate);
//                place.save();
//            }
//        }
//    }


    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("results");
                            JSONObject o = array.getJSONObject(mPostkey);


                            setTitle(" ");


                            textViewJudul.setText(o.getString("title"));
                            textViewTerbit.setText(o.getString("release_date"));
                            textViewOverview.setText(o.getString("overview"));

//                            url = o.getJSONObject("link").getString("url");

                            Glide

                                    .with(HomeActivity.this)
                                    .load("https://image.tmdb.org/t/p/w500" + o.getString("poster_path"))
                                    .into(imageViewDetail);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
