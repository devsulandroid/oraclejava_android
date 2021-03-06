package com.devsul.a54_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int TAKE_PHOTO = 1;
    public void onBtnClick(View v){
        String dirPath = Environment.getExternalStorageDirectory()+"/devsul";
        File dir = new File(dirPath);

        if(!dir.exists()){
            // 하위 디렉토리까지 생성
            dir.mkdirs();
        }

        // 내부 저장소
        String path = dirPath + "/26.jpg";

        //암시적 인텐드
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 내부 리소스 주소 소문자 Uri
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));

        startActivityForResult(intent, TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TAKE_PHOTO){
            if(resultCode == RESULT_OK){
                String dirPath = Environment.getExternalStorageDirectory()+"/devsul";
                String path = dirPath + "/26.jpg";

                ImageView imageView = (ImageView) findViewById(R.id.btnImgView);

                //파일로 있을때
                Bitmap bitmap;
                BitmapFactory.Options options = new BitmapFactory.Options();
                //4px 당 1로 로딩
                options.inSampleSize = 4;

                bitmap = BitmapFactory.decodeFile(path, options);
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
