package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JZMediaSystem extends JZMediaInterface implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public MediaPlayer mediaPlayer;

    public JZMediaSystem(Jzvd jzvd) {
        super(jzvd);
    }

    public /* synthetic */ void a(long j2) {
        try {
            this.mediaPlayer.seekTo((int) j2);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void b() {
        this.jzvd.onPrepared();
    }

    public /* synthetic */ void c() {
        this.jzvd.onSeekComplete();
    }

    public /* synthetic */ void d() {
        this.mediaPlayer.pause();
    }

    public /* synthetic */ void e() {
        try {
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setLooping(this.jzvd.jzDataSource.looping);
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.setOnBufferingUpdateListener(this);
            this.mediaPlayer.setScreenOnWhilePlaying(true);
            this.mediaPlayer.setOnSeekCompleteListener(this);
            this.mediaPlayer.setOnErrorListener(this);
            this.mediaPlayer.setOnInfoListener(this);
            this.mediaPlayer.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.mediaPlayer, this.jzvd.jzDataSource.getCurrentUrl().toString(), this.jzvd.jzDataSource.headerMap);
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setSurface(new Surface(JZMediaInterface.SAVED_SURFACE));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void f() {
        this.mediaPlayer.start();
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        if (this.mediaPlayer != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getDuration() {
        if (this.mediaPlayer != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i2) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.g
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(i2);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.k
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(i2, i3);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.e
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(i2, i3);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.m
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.j
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        SurfaceTexture surfaceTexture2 = JZMediaInterface.SAVED_SURFACE;
        if (surfaceTexture2 != null) {
            this.jzvd.textureView.setSurfaceTexture(surfaceTexture2);
        } else {
            JZMediaInterface.SAVED_SURFACE = surfaceTexture;
            prepare();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.l
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(i2, i3);
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause() {
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.i
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void prepare() {
        release();
        this.mMediaHandlerThread = new HandlerThread("JZVD");
        this.mMediaHandlerThread.start();
        this.mMediaHandler = new Handler(this.mMediaHandlerThread.getLooper());
        this.handler = new Handler();
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.a
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void release() {
        final HandlerThread handlerThread;
        final MediaPlayer mediaPlayer;
        Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        JZMediaInterface.SAVED_SURFACE = null;
        handler.post(new Runnable() { // from class: cn.jzvd.h
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.a(mediaPlayer, handlerThread);
            }
        });
        this.mediaPlayer = null;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void seekTo(final long j2) {
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(j2);
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    @RequiresApi(api = 23)
    public void setSpeed(float f2) {
        PlaybackParams playbackParams = this.mediaPlayer.getPlaybackParams();
        playbackParams.setSpeed(f2);
        this.mediaPlayer.setPlaybackParams(playbackParams);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSurface(Surface surface) {
        this.mediaPlayer.setSurface(surface);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setVolume(final float f2, final float f3) {
        Handler handler = this.mMediaHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: cn.jzvd.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(f2, f3);
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void start() {
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.f
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        });
    }

    public /* synthetic */ void b(int i2, int i3) {
        this.jzvd.onInfo(i2, i3);
    }

    public /* synthetic */ void c(int i2, int i3) {
        this.jzvd.onVideoSizeChanged(i2, i3);
    }

    static /* synthetic */ void a(MediaPlayer mediaPlayer, HandlerThread handlerThread) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        handlerThread.quit();
    }

    public /* synthetic */ void a(float f2, float f3) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f3);
        }
    }

    public /* synthetic */ void a() {
        this.jzvd.onAutoCompletion();
    }

    public /* synthetic */ void a(int i2) {
        this.jzvd.setBufferProgress(i2);
    }

    public /* synthetic */ void a(int i2, int i3) {
        this.jzvd.onError(i2, i3);
    }
}
