package info.devexchanges.telephony;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialingActivity extends AppCompatActivity {

    private Button btnCall;
    private EditText txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        txtPhone = (EditText) findViewById(R.id.txt_phone);
        btnCall = (Button)findViewById(R.id.btn_call);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPhone.getText().toString().trim().equals("")) {
                    Toast.makeText(DialingActivity.this, "Please input a phone number", Toast.LENGTH_SHORT).show();
                } else {
                    String uri = "tel:"+ txtPhone.getText().toString();
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(uri));
                    startActivity(dialIntent);
                }
            }
        });
    }
}
