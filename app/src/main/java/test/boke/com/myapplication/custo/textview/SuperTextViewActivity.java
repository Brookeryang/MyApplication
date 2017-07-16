package test.boke.com.myapplication.custo.textview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import test.boke.com.myapplication.R;

public class SuperTextViewActivity extends Activity {

    private SuperTextView2 tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_text_view);
        //setOnSuperTextViewClickListener
        tv = (SuperTextView2) findViewById(R.id.usernaem);
        tv.setOnSuperTextViewClickListener(new SuperTextView2.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener() {
                Toast.makeText(SuperTextViewActivity.this, "aaaaaaaaaaa", Toast.LENGTH_LONG).show();
            }
        });

    }
}
