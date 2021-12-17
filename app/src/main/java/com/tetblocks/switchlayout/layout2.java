package com.tetblocks.switchlayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class layout2 extends AppCompatActivity
{


    ActivityResultLauncher <Intent> activityResultLauncher = registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    int result= activityResult.getResultCode();
                    Intent data = activityResult.getData();

                    if(result == RESULT_OK)
                    {
                        String title = data.getStringExtra("title");
                        setTitle(title);
                        Toast.makeText(layout2.this, "Title Modified", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(layout2.this, "Operation canceled", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);



         Button next = (Button) findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);

                activityResultLauncher.launch(myIntent);
              //  startActivityForResult(myIntent, 0);

            }

        });







    }


}
