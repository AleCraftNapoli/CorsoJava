package it.gov.liceosilvestri.corsoapp.prova;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonShowPeers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowPeersActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonThread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProvaWorker worker = new ProvaWorker((TextView) findViewById(R.id.textViewCounter));
                Handler h = worker.getHandler();

                Message msg = h.obtainMessage(1);
                msg.obj = "COFFEE!";
                h.sendMessage(msg);

                Thread t = new Thread(worker);
                t.start();
            }
        });
    }
}
