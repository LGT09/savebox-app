package com.traxxiontech.savebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.traxxiontech.savebox.R;

public class ComplianceActivity extends AppCompatActivity {

    private CheckBox complianceCheckbox;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliance);

        complianceCheckbox = findViewById(R.id.compliance_checkbox);
        continueButton = findViewById(R.id.btn_continue);

        continueButton.setOnClickListener(v -> {
            if (complianceCheckbox.isChecked()) {
                getSharedPreferences("SaveBox", MODE_PRIVATE)
                        .edit()
                        .putBoolean("compliance_accepted", true)
                        .apply();
                startActivity(new Intent(ComplianceActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Please accept the terms to continue", Toast.LENGTH_SHORT).show();
            }
        });
    }
}