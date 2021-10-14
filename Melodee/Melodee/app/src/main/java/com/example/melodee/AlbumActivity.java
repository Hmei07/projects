package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AlbumActivity extends AppCompatActivity {

    String[] albumTitles = {
            "LILAC",
            "The Album",
            "Handmade",
            "Gajah",
            "Head in the Clouds",
            "Eyes Wide Open"
    };

    String[] artistName = {"IU", "Blackpink", "Raisa", "Tulus", "88rising", "TWICE"};

    String [] category = {"K-pop", "Pop, R&B", "Pop", "Jazz, Pop", "R&B/Soul", "Retro-pop, K-pop"};

    String[] price = {"Rp 370.000", "Rp 350.000", "Rp 140.000", "Rp 40.000", "230.000", "Rp 330.000"};

    String[] totalSold = {"21.934", "16.436", "11.123", "19.253", "15.231", "11.372"};

    int[] albumCovers = {
            R.drawable.iu,
            R.drawable.blackpink,
            R.drawable.raisa,
            R.drawable.tulus,
            R.drawable.rising,
            R.drawable.twice
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        init();

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AlbumActivity.this, AlbumDetailsActivity.class);
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

    private void init(){
        this.listView = findViewById(R.id.listView);
    }

    public void goHome(View view) {
        Intent intent = new Intent(AlbumActivity.this, HomeActivity.class);
        intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        intent.putExtra("PAGENAME", "Home");
        startActivity(intent);
    }

    public void goAlbum(View view) {

    }

    public void goAboutUs(View view) {
        Intent intent = new Intent(AlbumActivity.this, AboutUsActivity.class);
        intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        intent.putExtra("PAGENAME", "About Us");
        startActivity(intent);
    }

    public void goLogOut(View view) {
        Intent intent = new Intent(AlbumActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}