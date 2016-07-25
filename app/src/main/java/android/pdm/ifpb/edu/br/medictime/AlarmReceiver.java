package android.pdm.ifpb.edu.br.medictime;

/**
 * Created by luckschulze on 22/07/16.
 */
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
        import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(arg0, notification);
        r.play();


        Toast.makeText(arg0, "Está na hora do "+arg1.getStringExtra("REMEDIO"), Toast.LENGTH_LONG).show();


    }

}