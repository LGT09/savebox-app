package com.traxxiontech.savebox.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.traxxiontech.savebox.R;

public class DownloadActivity extends AppCompatActivity {

    private ImageView thumbnail;
    private TextView title;
    private TextView platform;
    private TextView fileSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        initViews();
        loadDownloadData();
    }

    private void initViews() {
        thumbnail = findViewById(R.id.iv_thumbnail);
        title = findViewById(R.id.tv_title);
        platform = findViewById(R.id.tv_platform);
        fileSize = findViewById(R.id.tv_file_size);
    }

    private void loadDownloadData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String titleStr = extras.getString("title", "Unknown");
            String platformStr = extras.getString("platform", "Unknown");
            String sizeStr = extras.getString("fileSize", "Unknown");
            String thumbUrl = extras.getString("thumbnail");

            title.setText(titleStr);
            platform.setText("Platform: " + platformStr);
            fileSize.setText("Size: " + sizeStr);

            // Load thumbnail using Glide
            // Glide.with(this).load(thumbUrl).into(thumbnail);
        }
    }
}