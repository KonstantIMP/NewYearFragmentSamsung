package kimp.christmas.fragment.org;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.annotation.NonNull;

public class AudioPlayer {
    private static AudioPlayer instance = null;

    public static AudioPlayer getInstance() {
        if (instance == null) instance = new AudioPlayer();
        return instance;
    }

    private MediaPlayer player;

    public AudioPlayer() {
        player = null;
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void stop() {
        if (player != null) {
            player.release(); player = null;
        }
    }

    public void play(@NonNull Context context) {
        if (player == null) {
            player = MediaPlayer.create(context, R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stop();
                }
            });
        }
        player.start();
    }

    public boolean isPlaying() {
        return player != null && player.isPlaying();
    }
}
