package thinhle.intentproblem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNhapA;
    private EditText edtNhapB;
    private Button btnKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNhapA.getText().toString().isEmpty() || edtNhapB.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "input không hợp lệ!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    int getA = Integer.parseInt(edtNhapA.getText().toString());
                    int getB = Integer.parseInt(edtNhapB.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putInt("so A", getA);
                    bundle.putInt("so B", getB);
                    intent.putExtra("my package", bundle);
                    startActivity(intent);
                }
            }
        });
    }

    public void initView()
    {
        edtNhapA = (EditText) findViewById(R.id.nhap_a);
        edtNhapB = (EditText) findViewById(R.id.nhap_b);
        btnKetQua = (Button) findViewById(R.id.ket_qua);
    }
}
