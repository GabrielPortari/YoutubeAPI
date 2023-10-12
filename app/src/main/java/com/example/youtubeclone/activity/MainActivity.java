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
import android.widget.Toast;

import com.example.youtubeclone.R;
import com.example.youtubeclone.adapter.AdapterVideo;
import com.example.youtubeclone.api.YoutubeService;
import com.example.youtubeclone.helper.YoutubeConfiguration;
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
    private List<Video> listaVideo = new ArrayList<>();

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
        adapterVideo = new AdapterVideo(listaVideo, this);
        recyclerVideos.setHasFixedSize(true);
        recyclerVideos.setLayoutManager(new LinearLayoutManager(this));
        recyclerVideos.setAdapter(adapterVideo);
    }

    private void recuperarVideos(){
        YoutubeService youtubeService = retrofit.create(YoutubeService.class);
        youtubeService.recuperarVideos(
            "snipper", "date", "10", YoutubeConfiguration.CHAVE_YOUTUBE_API, YoutubeConfiguration.CANAL_ID
        ).enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Log.d("INFO", "Response" + response.toString());
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_busca){
            startActivity(new Intent(getApplicationContext(), BuscaActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}