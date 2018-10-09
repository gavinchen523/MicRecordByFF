package com.example.gavin.micrecordbyff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("avcodec");
        System.loadLibrary("avdevice");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
    }

    private TextView in_device;
    private TextView out_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in_device = (TextView)findViewById(R.id.inputDev);
        out_device = (TextView) findViewById(R.id.outputDev);

        in_device.setText(stringFromJNI());
        out_device.setText(stringFromJNI());
    }

    public void inputdev(View view) {
        in_device.setText(inputdev());

    }

    public void outpudev (View view) {
//        out_device.setText(outpudev());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String inputdev();
    public native String outputdev();
}
