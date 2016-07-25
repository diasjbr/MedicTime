package android.pdm.ifpb.edu.br.medictime;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;


public class MainActivity extends Activity {
    private static final int NOVO = 1, SOBRE = 2, RQS_1 = 1;;
    private ListView lvLista;
    private ImageButton imageButton;
    private MedicamentosList medicamentos;
    private DAOMedicamento dm;

    public MainActivity(){
        this.medicamentos = new MedicamentosList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //linha de codigo pra tirar a janela azul de cima
        setContentView(R.layout.activity_main);
        instanciaComponentesInterface();

        this.dm = new DAOMedicamento(this);
        this.medicamentos.setMedicamentos(this.dm.get());
        Log.i("SCHULZE", Integer.toString(this.medicamentos.getMedicamentos().size()));

        ItemListAdapter adapter = new ItemListAdapter(this.dm.get(), this);
        this.lvLista.setAdapter(adapter);

        carregarMedicamentos();

        this.lvLista.setOnItemClickListener(new OnClickList());

    }
    //----------------------Instanciar componentes Inicio---------------------

    private void instanciaComponentesInterface(){
        this.lvLista = (ListView) findViewById(R.id.lvList);
        this.imageButton = (ImageButton) findViewById(R.id.addRemedio);
        this.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CriarMedActivity.class);
                startActivityForResult(it,NOVO);
            }
        });
    }
    //-----------------------Instanciar componentes Fim-----------------------

    //-----------------------------ListView Inicio----------------------------
    public void carregarMedicamentos(){
        this.lvLista.setAdapter(new ItemListAdapter(this.dm.get(), this));
    }



//-------------------------Resposta activity's inicio---------------------

    @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK){
        if (requestCode == NOVO){
            Medicamento m = new Medicamento(data.getStringExtra("NOME"),data.getStringExtra("DOSE"),
                    data.getIntExtra("HORA", 0), data.getIntExtra("MINUTOS", 0));
            MainActivity.this.dm.inserir(m);

            this.setarAlarme(m);
            this.medicamentos.setMedicamentos(this.dm.get());
            MainActivity.this.carregarMedicamentos();


        }
    }
}
    //--------------------------Resposta activity's fim-----------------------
//----------------------------Listeners Inicio----------------------------
    private class OnClickList implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent it = new Intent(MainActivity.this, medicamentoActivity.class);
            String med = parent.getAdapter().getItem(position).toString();

            medicamentos.setMedicamentos(MainActivity.this.dm.get());
            Medicamento red = medicamentos.buscarMedicamento(med);
            it.putExtra("NOME", med);
            it.putExtra("DOSE", red.getdose());
            startActivity(it);

            }
        }

    //--------------------------------Listeners Fim--------------------------------
//--------------------------------Alarme Inicio--------------------------------
    private void setarAlarme(Medicamento medicamento){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());

        cal.set(Calendar.HOUR_OF_DAY,medicamento.getHora());
        cal.set(Calendar.MINUTE, medicamento.getMinutos());


        Log.i("SCHULZE", Integer.toString(medicamento.getHora()));
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        intent.putExtra("REMEDIO", medicamento.getNome());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
        Log.i("SCHULZE", Long.toString(cal.getTimeInMillis()));


        Toast.makeText(getApplicationContext(),
                "Alarme implementado!",
                Toast.LENGTH_LONG).show();

    }

}

