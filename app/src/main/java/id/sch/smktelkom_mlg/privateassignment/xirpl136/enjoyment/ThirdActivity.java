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

public class ThirdActivity extends AppCompatActivity {
    private static final String URL_DATA = "https://gateway.marvel.com/v1/public/characters?ts=3000&apikey=354a328397f01f4fd5454051cae612ff&hash=24d634225a32eca497ac21eb970c6d8b";
    public TextView textViewNamaMarvel;
    public TextView textViewModifMarvel;
    public TextView textViewDescMarvel;
    public ImageView imageViewDetailMarvel;
    private Integer mPostkey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
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


        textViewNamaMarvel = (TextView) findViewById(R.id.textViewNamaMarvel);
        textViewModifMarvel = (TextView) findViewById(R.id.textViewModifMarvel);
        textViewDescMarvel = (TextView) findViewById(R.id.textViewDescMarvel);
        imageViewDetailMarvel = (ImageView) findViewById(R.id.imageViewDetailMarvel);
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
                            JSONArray array = jsonObject.getJSONObject("data").getJSONArray("results");
                            JSONObject o = array.getJSONObject(mPostkey);


                            setTitle(" ");


                            textViewNamaMarvel.setText(o.getString("name"));
                            textViewModifMarvel.setText(o.getString("modified"));
                            textViewDescMarvel.setText(o.getString("description"));

//                            url = o.getJSONObject("link").getString("url");

                            Glide

                                    .with(ThirdActivity.this)
                                    .load(o.getJSONObject("thumbnail").getString("path") + "." + o.getJSONObject("thumbnail").getString("extension"))
                                    .into(imageViewDetailMarvel);

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
