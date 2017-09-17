package thinhle.intentproblem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by thinhle on 9/17/17.
 */

public class ResultActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = (TextView) findViewById(R.id.tv_result);
        btnBack = (Button) findViewById(R.id.btn_back);

        Intent getIntent = getIntent();
        Bundle getBundle = getIntent.getBundleExtra("my package");

        int a = getBundle.getInt("so A");
        int b = getBundle.getInt("so B");
        giaiPhuongTrinh(a, b);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(ResultActivity.this, "Welcome back to MainActivity!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void giaiPhuongTrinh(int a, int b) {

        if(a == 0)
        {
            if (b == 0)
            {
                tvResult.setText("Phương trình vô số nghiệm!");
            }
            else
            {
                tvResult.setText("Phương trình vô nghiệm!");
            }
        }
        else
        {
            tvResult.setText(String.valueOf((float) -b/a));
        }
    }
}
