package it.gov.liceosilvestri.corsoapp.prova;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PeersAdapter extends ArrayAdapter<Peer> {

    private Peer[] peers;
    private Context ctx;

    public PeersAdapter(Context context, Peer[] peers) {
        super(context, R.layout.item_peer, peers);

        this.peers = peers;
        this.ctx = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_peer, parent, false);

        TextView textViewPeerName = rowView.findViewById(R.id.textViewPeerName);
        TextView textViewPeerAddress = rowView.findViewById(R.id.textViewAddress);
        ImageView imgViewStatus = rowView.findViewById(R.id.imageViewStatus);

        Peer p = peers[position];
        textViewPeerName.setText(p.getName());
        textViewPeerAddress.setText(p.getAddress());

        int resId;
        switch (p.getStatus()) {
            case Peer.STATUS_CONNECTED:
                resId = android.R.color.holo_green_light;
                break;
            case Peer.STATUS_CONNECTING:
                resId = android.R.color.holo_orange_light;
                break;
            case Peer.STATUS_DISCONNECTED:
                resId = android.R.color.holo_red_dark;
                break;
            case Peer.STATUS_NOT_FOUND:
                resId = android.R.color.darker_gray;
                break;
            default:
                resId = android.R.color.transparent;
                break;
        }
        imgViewStatus.setImageResource(resId);

        return rowView;
    }
}
