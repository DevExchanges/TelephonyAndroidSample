package info.devexchanges.telephony;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {

    private Button btnSend;
    private EditText txtPhoneNumber;
    private EditText txtMessageContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        btnSend = (Button) findViewById(R.id.btnSendSMS);
        txtPhoneNumber = (EditText) findViewById(R.id.txt_phone);
        txtMessageContent = (EditText) findViewById(R.id.sms_content);

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {
        String phoneNo = txtPhoneNumber.getText().toString().trim();
        String message = txtMessageContent.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("address", phoneNo);
        intent.putExtra("sms_body", message);
        intent.setData(Uri.parse("smsto:" + phoneNo));
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }
}