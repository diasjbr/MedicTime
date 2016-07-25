package android.pdm.ifpb.edu.br.medictime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class medicamentoActivity extends AppCompatActivity {
    public TextView tvNome, tvDose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);

        this.tvNome = (TextView) findViewById(R.id.et2Nome);
        this.tvDose = (TextView) findViewById(R.id.et2Dose);

        String l = this.getIntent().getStringExtra("NOME");
        String l2 = this.getIntent().getStringExtra("DOSE");
        tvNome.setText(l);
        tvDose.setText(l2);


    }
    public boolean onTouchEvent(MotionEvent event){
        this.finish();
        return super.onTouchEvent(event);
    }


}