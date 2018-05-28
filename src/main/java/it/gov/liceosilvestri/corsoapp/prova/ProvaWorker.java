package it.gov.liceosilvestri.corsoapp.prova;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class ProvaWorker implements Runnable {

    private TextView mTextViewCounter;
    private Handler mHandler;

    public ProvaWorker(TextView textView) {
        mTextViewCounter = textView;
    }

    @Override
    public void run() {
        Looper.prepare();

        mHandler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        String str = (String) msg.obj;
                        mTextViewCounter.setText(str);
                        break;
                    default:
                        break;
                }
            }
        };

        Looper.loop();

    }

    private void doCycle() {
        try {
            for (int i = 0; i < 8; i++) {
                mTextViewCounter.setText("Ciclo: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Handler getHandler() {
        return mHandler;
    }
}
