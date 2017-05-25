package com.toi.imagehotspot;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.toi.imagehotspot.geometry.Point;

public class MainActivity extends AppCompatActivity {
    private Context _context;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _context = this;
        imageView = (ImageView) this.findViewById(R.id.imageView);
        textView = (TextView) this.findViewById(R.id.textView);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // normalized x and y value
                    float xn = event.getX() / v.getWidth();
                    float yn = event.getY() / v.getHeight();
                    String s = String.format("XY Norm = %.2f, %.2f", xn, yn);
                    textView.setText(s);
                    int area = Hotspot.getHotspot(new Point(xn, yn));
                    Toast.makeText(_context, Hotspot.hotspotName(area), Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int w = getScreenWidth();
        int h = getScreenHeight();
        Toast.makeText(getBaseContext(), "Screen wh = " + w + "," + h, Toast.LENGTH_SHORT).show();
        if (h > w) {
            imageView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            imageView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        if (h < w) {
            imageView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            imageView.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
    }

    public int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
