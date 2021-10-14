package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity {

    private TextView username,pageName;
    int[] images = {
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
    };
    ViewFlipper viewFlipper;

    ListView topSellingList;
    String[] albumTitles = {
            "LILAC",
            "Gajah",
            "The Album"
    };

    String[] artistName = {"IU", "Tulus", "Blackpink"};

    String [] category = {"K-pop", "Jazz, Pop", "Pop, R&B"};

    String[] price = {"Rp 370.000", "Rp 40.000", "Rp 350.000"};

    String[] totalSold = {"21.934", "19.253", "16.436"};

    int[] albumCovers = {
            R.drawable.iu,
            R.drawable.tulus,
            R.drawable.blackpink
    };

    ImageButton homeBtn, albumBtn, aboutUsBtn, logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initialize();

        String pageNameIntent = getIntent().getStringExtra("PAGENAME");
        pageName.setText(pageNameIntent);
        String usernameIntent = getIntent().getStringExtra("USERNAME");
        username.setText("Welcome, " + usernameIntent);
//        username.setText("Welcome" + LoginActivity.user.getUsername());

        for(int image : images){
            slideImages(image);
        }

        CustomAdapter customAdapter = new CustomAdapter();
        topSellingList.setAdapter(customAdapter);

        topSellingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, AlbumDetailsActivity.class);
                intent.putExtra("ALBUM_IMG", albumCovers[position]);
                intent.putExtra("ALBUM_TITLE", albumTitles[position]);
                intent.putExtra("ARTIST_NAME", artistName[position]);
                intent.putExtra("CATEGORY", category[position]);
                intent.putExtra("PRICE", price[position]);
                intent.putExtra("TOTAL_SOLD", totalSold[position]);
                startActivity(intent);
            }
        });


    }

    private void initialize() {
        viewFlipper = findViewById(R.id.vfHome);
        this.username = findViewById(R.id.usernameInput);
        this.topSellingList = findViewById(R.id.listView);
        this.homeBtn = findViewById(R.id.homeBtn);
        this.albumBtn = findViewById(R.id.albumBtn);
        this.aboutUsBtn = findViewById(R.id.aboutUsBtn);
        this.logOutBtn = findViewById(R.id.logOutBtn);
        pageName = findViewById(R.id.title);
    }

    private void slideImages(int image){
        ImageView imageView = new ImageView(HomeActivity.this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(HomeActivity.this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(HomeActivity.this, android.R.anim.slide_out_right);
    }

    public void goHome(View view) {

    }

    public void goAlbum(View view) {
        Intent intentAlbum = new Intent(HomeActivity.this, AlbumActivity.class);
        intentAlbum.putExtra("PAGENAME", "Album");
        intentAlbum.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        startActivity(intentAlbum);
    }

    public void goAboutUs(View view) {
        Intent intentAboutUs = new Intent(HomeActivity.this, AboutUsActivity.class);
        intentAboutUs.putExtra("PAGENAME", "About Us");
        String usernamePass = getIntent().getStringExtra("USERNAME");
        intentAboutUs.putExtra("USERNAME", usernamePass);
        startActivity(intentAboutUs);
    }

    public void goLogOut(View view) {
        Intent intentLogOut = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intentLogOut);
    }


    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return albumCovers.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.albumlist, null);
            ImageView imageView = convertView.findViewById(R.id.ivList);
            TextView textView = convertView.findViewById(R.id.tvList);
            TextView textViewArtistName = convertView.findViewById(R.id.tvListArtisName);
            TextView textViewCategory = convertView.findViewById(R.id.tvListCategory);
            TextView textViewPrice = convertView.findViewById(R.id.tvListPrice);
            TextView textViewTotalSold = convertView.findViewById(R.id.tvListTotalSold);

            imageView.setImageResource(albumCovers[position]);
            textView.setText(albumTitles[position]);
            textViewArtistName.setText(artistName[position]);
            textViewCategory.setText(category[position]);
            textViewPrice.setText(price[position]);
            textViewTotalSold.setText(totalSold[position]);

            return convertView;
        }
    }
}