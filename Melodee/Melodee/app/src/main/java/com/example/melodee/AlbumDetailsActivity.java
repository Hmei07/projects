package com.example.melodee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class AlbumDetailsActivity extends AppCompatActivity {

    ImageView albumCover;
    TextView albumName, artistName, category, price, totalSold;
    NumberPicker qty;
    Button orderBtn;
    int finalqty=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        init();
        setValues();
        qty.setMaxValue(100);
        qty.setMinValue(0);
        qty.setValue(5);

        qty.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                finalqty = newVal;

            }
        });

        this.orderBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP){
                    orderBtn.setBackgroundColor(Color.parseColor("#FF8700"));
                }
                else {
                    orderBtn.setBackgroundColor(Color.parseColor("#00CCB2"));
                }
                return false;
            }
        });
    }

    private void setValues() {
        albumCover.setImageResource(getIntent().getIntExtra("ALBUM_IMG", 0));
        albumName.setText(getIntent().getStringExtra("ALBUM_TITLE"));
        artistName.setText(getIntent().getStringExtra("ARTIST_NAME"));
        category.setText(getIntent().getStringExtra("CATEGORY"));
        price.setText(getIntent().getStringExtra("PRICE"));
        totalSold.setText(getIntent().getStringExtra("TOTAL_SOLD"));
    }

    private void init(){
        albumCover = findViewById(R.id.imageView);
        this.albumName = findViewById(R.id.albumName);
        this.artistName = findViewById(R.id.artistName);
        this.category = findViewById(R.id.category);
        this.price = findViewById(R.id.price);
        totalSold = findViewById(R.id.totalSold);
        qty = findViewById(R.id.npQty);
        this.orderBtn = findViewById(R.id.orderBtn);
    }

    public void goHome(View view) {
        Intent intent = new Intent(AlbumDetailsActivity.this, HomeActivity.class);
        intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        intent.putExtra("PAGENAME", "Home");
        startActivity(intent);
    }

    public void goAlbum(View view) {
        Intent intent = new Intent(AlbumDetailsActivity.this, AlbumActivity.class);
        intent.putExtra("PAGENAME", "Album");
        intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        startActivity(intent);
    }

    public void goAboutUs(View view) {
        Intent intent = new Intent(AlbumDetailsActivity.this, AboutUsActivity.class);
        intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        intent.putExtra("PAGENAME", "About Us");
        startActivity(intent);
    }

    public void goLogOut(View view) {
        Intent intent = new Intent(AlbumDetailsActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void openDialog(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Selected number: " + finalqty);
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
        if (finalqty < 1){
            FailDialog failDialog = new FailDialog();
            failDialog.show(getSupportFragmentManager(), "");

        }
        else{
            SuccessDialog successDialog = new SuccessDialog();
            successDialog.show(getSupportFragmentManager(), "");

        }
    }
}