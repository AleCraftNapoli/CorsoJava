package it.gov.liceosilvestri.corsoapp.prova;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

public class PizzaService extends Service {

    private static final String ACTION_PROVA = "it.gov.liceosilvestri.corsoapp.prova.pizza.prova";
    private HandlerThread mThread;
    private PizzaHandler mHandler;
    private Looper mLooper;

    @Override
    public void onCreate() {
        mThread = new HandlerThread("PizzaThread", Process.THREAD_PRIORITY_BACKGROUND);
        mThread.start();

        mLooper = mThread.getLooper();
        mHandler = new PizzaHandler(mLooper);
    }

    private static class PizzaHandler extends Handler {

        public static final int MSGWHAT_PROVA = 1;

        public PizzaHandler(Looper looper) { super(looper); }

        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case MSGWHAT_PROVA:

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    //ERROR
                    break;
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Message msg = mHandler.obtainMessage();
        msg.arg1 = startId;

        switch (intent.getAction()) {
            case ACTION_PROVA:
                msg.obj = intent.getStringExtra("input");
                msg.what = PizzaHandler.MSGWHAT_PROVA;
                break;
            default:

                break;
        }

        mHandler.sendMessage(msg);
        return Service.START_STICKY;
    }

    private void sayIt(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() { mThread.quitSafely(); }

    @Override
    public IBinder onBind(Intent intent) { return null; }
}
