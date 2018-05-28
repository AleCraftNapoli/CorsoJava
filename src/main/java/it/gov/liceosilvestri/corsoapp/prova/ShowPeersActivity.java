package it.gov.liceosilvestri.corsoapp.prova;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Looper;

public class ShowPeersActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_peers);

        String[] addresses = { "01", "02", "03", "04", "05"};
        String[] names = {"Bec", "Andrea", "Raffaele", "Alessio", "Antonio"};
        int[] status = {1, 3, 2, 1, 4};
        Peer[] peers = new Peer[addresses.length];

        for (int i = 0; i < peers.length; i++) {
            peers[i] = new Peer(addresses[i], names[i], status[i]);
        }

        PeersAdapter adapter = new PeersAdapter(this, peers);
        setListAdapter(adapter);
    }
}
