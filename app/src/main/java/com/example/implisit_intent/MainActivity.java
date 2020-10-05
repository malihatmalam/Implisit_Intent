package com.example.implisit_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText EditUrlWeb;
    private EditText EditUrlloc;
    private EditText EditUrlShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditUrlWeb = findViewById(R.id.EditText_Website);
        EditUrlloc = findViewById(R.id.EditText_Location);
        EditUrlShare = findViewById(R.id.EditText_Share);
    }

    public void openWebsite(View view) {
        String url = EditUrlWeb.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if(intent != null) {
            startActivity(intent);
        }else {
            Log.d("implicitIntent", "Can't handle this intent");
        }
    }

    public void openLocation(View view) {
        String Location = EditUrlloc.getText().toString ();
        Uri AddressUri = Uri.parse("geo:0,7q"+Location);
        Intent intent = new Intent (Intent.ACTION_VIEW);
        if(intent != null) {
            startActivity(intent);
        }else {
            Log.d("implicitIntent", "Can't handle this intent");
        }
    }

    public void openShare(View view) {
        String share =EditUrlShare.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle("Share tetx with:")
                .setText(share).setType("text/plain")
                .startChooser();
    }
}
