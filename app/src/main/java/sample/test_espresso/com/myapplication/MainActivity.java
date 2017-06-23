package sample.test_espresso.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;
import com.microsoft.azure.mobile.push.Push;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Push.setListener(new MyPushListener());
        MobileCenter.start(getApplication(), "7800c652-e38a-406e-a6ec-35f242576409",
                Analytics.class, Crashes.class, Push.class);

        Analytics.trackEvent("Click_NewButton");
        Analytics.trackEvent("Click_Cancel");
        Analytics.trackEvent("EnterText");
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.inputField);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeText:
                editText.setText("Lalala");
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("input", editText.getText().toString());
                startActivity(intent);
                break;
        }

    }
}
