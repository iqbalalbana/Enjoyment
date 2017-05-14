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

public class SecondActivity extends AppCompatActivity {
    private static final String URL_DATA = "https://api.themoviedb.org/3/tv/popular?api_key=cf48be249b4ace270b61684fe3644bae";
    public TextView textViewJudulTV;
    public TextView textViewTerbitTV;
    public TextView textViewOverviewTV;
    public ImageView imageViewDetailTV;
    private Integer mPostkey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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


        textViewJudulTV = (TextView) findViewById(R.id.textViewJudulTV);
        textViewTerbitTV = (TextView) findViewById(R.id.textViewTerbitTV);
        textViewOverviewTV = (TextView) findViewById(R.id.textViewOverviewTV);
        imageViewDetailTV = (ImageView) findViewById(R.id.imageViewDetailTV);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

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


                            setTitle("");


                            textViewJudulTV.setText(o.getString("original_name"));
                            textViewTerbitTV.setText(o.getString("first_air_date"));
                            textViewOverviewTV.setText(o.getString("overview"));

//                            url = o.getJSONObject("link").getString("url");

                            Glide

                                    .with(SecondActivity.this)
                                    .load("https://image.tmdb.org/t/p/w500" + o.getString("backdrop_path"))
                                    .into(imageViewDetailTV);

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
