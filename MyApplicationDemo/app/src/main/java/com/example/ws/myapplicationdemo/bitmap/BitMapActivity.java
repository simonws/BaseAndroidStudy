package com.example.ws.myapplicationdemo.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.ws.myapplicationdemo.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BitMapActivity extends AppCompatActivity {
    String TAG = "BitMap_Activity";
    ImageView compressImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_map);
        ImageView imageView = (ImageView) findViewById(R.id.test_img);
        BitmapDrawable drawable = (BitmapDrawable) getDrawable(R.drawable.action_icon_big);
        Bitmap preCompressBitmap = drawable.getBitmap();
        imageView.setImageBitmap(preCompressBitmap);
//        Log.d(TAG, "onCreate1 " + preCompressBitmap.getByteCount());
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        boolean isCompressOk = preCompressBitmap.compress(Bitmap.CompressFormat.JPEG, 10, out);
//        int compressedLen = out.toByteArray().length; // 这里out.toByteArray()所返回的byte[]数组大小确实变小了！
//        ByteArrayInputStream isBm = new ByteArrayInputStream(out.toByteArray());
//        Bitmap compressedBm = BitmapFactory.decodeStream(isBm, null, null);
//
//        Log.d(TAG,
//                "onCreate2 " + isCompressOk + " == " + compressedLen + " == " + compressedBm.getByteCount());

        compressImageView = (ImageView) findViewById(R.id.compressed_img);
        Bitmap bitmap = sizeCompress(preCompressBitmap);
        compressImageView.setImageBitmap(bitmap);
//        compressedBm.compress(Bitmap.CompressFormat.JPEG, 100, out);
        Log.d(TAG, "onCreate３ " + compressImageView.getWidth() + " == " + compressImageView.getHeight()
                + " == " + bitmap.getWidth() + " == " + bitmap.getHeight());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart " + compressImageView.getWidth() + " == "
                + compressImageView.getLayoutParams().width);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume0 " + compressImageView.getWidth() + " == "
                + compressImageView.getDrawable().getIntrinsicHeight());

        compressImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG,
                        "onResume1 " + compressImageView.getWidth() + " == "
                                + compressImageView.getDrawable().getIntrinsicWidth() + " == "
                                + compressImageView.getMeasuredWidth());
            }
        }, 1000);
    }

    /**
     * 4.尺寸压缩（通过缩放图片像素来减少图片占用内存大小）
     *
     * @param bmp
     */

    public Bitmap sizeCompress(Bitmap bmp) {
        // 尺寸压缩倍数,值越大，图片尺寸越小
        int ratio = 2;
        // 压缩Bitmap到对应尺寸
        Bitmap result = Bitmap.createBitmap(bmp.getWidth() / ratio, bmp.getHeight() / ratio,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Rect rect = new Rect(0, 0, bmp.getWidth() / ratio, bmp.getHeight() / ratio);
        canvas.drawBitmap(bmp, null, rect, null);
        return result;
    }
}
