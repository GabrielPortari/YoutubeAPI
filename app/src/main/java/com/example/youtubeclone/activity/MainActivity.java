package com.example.youtubeclone.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.youtubeclone.R;
import com.example.youtubeclone.adapter.AdapterVideo;
import com.example.youtubeclone.api.YoutubeService;
import com.example.youtubeclone.helper.RecyclerItemClickListener;
import com.example.youtubeclone.helper.YoutubeConfiguration;
import com.example.youtubeclone.model.Item;
import com.example.youtubeclone.model.Resultado;
import com.example.youtubeclone.model.Video;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerVideos;
    private AdapterVideo adapterVideo;
    private Retrofit retrofit;
    private Resultado resultado;
    private List<Item> videos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerVideos = findViewById(R.id.recyclerVideos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("YoutubeClone");
        setSupportActionBar(toolbar);

        //configuração do recyclerview
        recuperarVideos();
        configurarRecyclerView();
    }

    private void recuperarVideos(){
        YoutubeService youtubeService = retrofit.create(YoutubeService.class);
        youtubeService.recuperarVideos(
            "snipper", "date", "10", YoutubeConfiguration.CHAVE_YOUTUBE_API, YoutubeConfiguration.CANAL_ID
        ).enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Log.d("INFO", "Response" + response.toString());
                if(response.isSuccessful()){
                    resultado = response.body();
                    videos = resultado.items;
                }
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

            }
        });
    }
    public void configurarRecyclerView(){
        adapterVideo = new AdapterVideo(videos, this);
        recyclerVideos.setHasFixedSize(true);
        recyclerVideos.setLayoutManager(new LinearLayoutManager(this));
        recyclerVideos.setAdapter(adapterVideo);

        recyclerVideos.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerVideos, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Item video = videos.get(position);
                String idVideo = video.id.videoId;

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("idVideo", idVideo);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }
}