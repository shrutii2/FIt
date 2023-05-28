package com.rishav.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Disease_prediction extends AppCompatActivity {
    EditText symptom1,symptom2, symptom3, symptom4, symptom5, symptom6;
    Button predict;
    TextView result;
    String url = "https://fitness-app-1tq5.onrender.com/predict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_prediction);

        symptom1= findViewById(R.id.symptom1);
        symptom2= findViewById(R.id.symptom2);
        symptom3= findViewById(R.id.symptom3);
        symptom4= findViewById(R.id.symptom4);
        symptom5= findViewById(R.id.symptom5);
        symptom6= findViewById(R.id.symptom6);
        predict = findViewById(R.id.predict);
        result= findViewById(R.id.result);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hit the API -> Volley
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data = jsonObject.getString("predicted Disease");
                                    result.setText(data);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Disease_prediction.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){

                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();

                        params.put("symptom1",symptom1.getText().toString());
                        params.put("symptom2",symptom2.getText().toString());
                        params.put("symptom3",symptom3.getText().toString());
                        params.put("symptom4",symptom4.getText().toString());
                        params.put("symptom5",symptom5.getText().toString());
                        params.put("symptom6",symptom6.getText().toString());


                        return params;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(Disease_prediction.this);
                queue.add(stringRequest);
            }
        });

    }
}