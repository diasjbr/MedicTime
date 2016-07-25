package android.pdm.ifpb.edu.br.medictime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class CriarMedActivity extends AppCompatActivity {
    private EditText etNome, etDose;
    private TimePicker timePicker;
    private Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //linha de codigo pra tirar a janela azul de cima
        setContentView(R.layout.activity_criar_med);
        this.instanciaComponentesInterface();
    }

    private void instanciaComponentesInterface(){
        this.etNome = (EditText) findViewById(R.id.etNome);
        this.etDose = (EditText) findViewById(R.id.etDose);
        this.timePicker = (TimePicker) findViewById(R.id.timePicker);
        this.btOk = (Button) findViewById(R.id.btOk);

        this.btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = CriarMedActivity.this.etNome.getText().toString();
                String dose = CriarMedActivity.this.etDose.getText().toString();
                int hora = CriarMedActivity.this.timePicker.getCurrentHour();
                int minutos = CriarMedActivity.this.timePicker.getCurrentMinute();
                Intent it = new Intent();
                it.putExtra("NOME", nome);
                it.putExtra("DOSE", dose);
                it.putExtra("HORA", hora);
                it.putExtra("MINUTOS", minutos);
                setResult(RESULT_OK, it);
                finish();
            }
        });


    }
}
