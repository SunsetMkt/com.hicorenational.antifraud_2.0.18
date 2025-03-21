package manager;

import android.media.MediaPlayer;
import p000a.p001a.p014u.C0052a;
import util.C7301n1;

/* loaded from: classes2.dex */
public class MediaPlayerManager {
    static MediaPlayer mediaPlayer;

    public static MediaPlayerManager getInstance() {
        MediaPlayerManager mediaPlayerManager = new MediaPlayerManager();
        getMediaPlayer();
        return mediaPlayerManager;
    }

    public static MediaPlayer getMediaPlayer() {
        if (mediaPlayer == null) {
            synchronized (MediaPlayerManager.class) {
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }
            }
        }
        return mediaPlayer;
    }

    public void pauseMedia() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void playMedia(String str) {
        try {
            stopMedia();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(str);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: manager.MediaPlayerManager.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    C7301n1.m26459c(C0052a.f162n, "onPrepared        开始播放          ");
                    MediaPlayerManager.mediaPlayer.start();
                }
            });
            mediaPlayer.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void releaseMedia() {
        MediaPlayer mediaPlayer2 = mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
            mediaPlayer.release();
        }
    }

    public void resumeMedia() {
        if (mediaPlayer.isPlaying()) {
            return;
        }
        mediaPlayer.start();
    }

    public void stopMedia() {
        MediaPlayer mediaPlayer2 = mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
        }
    }
}
