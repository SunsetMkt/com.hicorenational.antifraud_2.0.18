package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import java.util.Map;

/* compiled from: JZMediaSystem.java */
/* renamed from: cn.jzvd.x */
/* loaded from: classes.dex */
public class C1282x extends AbstractTextureViewSurfaceTextureListenerC1281w implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: f */
    public MediaPlayer f2871f;

    public C1282x(Jzvd jzvd) {
        super(jzvd);
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: a */
    public void mo2526a(final long j2) {
        this.f2868b.post(new Runnable() { // from class: cn.jzvd.c
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2539b(j2);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m2539b(long j2) {
        try {
            this.f2871f.seekTo((int) j2);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: c */
    public boolean mo2529c() {
        return this.f2871f.isPlaying();
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: d */
    public void mo2530d() {
        this.f2868b.post(new Runnable() { // from class: cn.jzvd.i
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2544k();
            }
        });
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: e */
    public void mo2531e() {
        mo2532f();
        this.f2867a = new HandlerThread("JZVD");
        this.f2867a.start();
        this.f2868b = new Handler(this.f2867a.getLooper());
        this.f2869c = new Handler();
        this.f2868b.post(new Runnable() { // from class: cn.jzvd.a
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2545l();
            }
        });
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: f */
    public void mo2532f() {
        final HandlerThread handlerThread;
        final MediaPlayer mediaPlayer;
        Handler handler = this.f2868b;
        if (handler == null || (handlerThread = this.f2867a) == null || (mediaPlayer = this.f2871f) == null) {
            return;
        }
        AbstractTextureViewSurfaceTextureListenerC1281w.f2866e = null;
        handler.post(new Runnable() { // from class: cn.jzvd.h
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.m2534a(mediaPlayer, handlerThread);
            }
        });
        this.f2871f = null;
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: g */
    public void mo2533g() {
        this.f2868b.post(new Runnable() { // from class: cn.jzvd.f
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2546m();
            }
        });
    }

    /* renamed from: h */
    public /* synthetic */ void m2541h() {
        this.f2870d.mo2474j();
    }

    /* renamed from: i */
    public /* synthetic */ void m2542i() {
        this.f2870d.m2475k();
    }

    /* renamed from: j */
    public /* synthetic */ void m2543j() {
        this.f2870d.m2476l();
    }

    /* renamed from: k */
    public /* synthetic */ void m2544k() {
        this.f2871f.pause();
    }

    /* renamed from: l */
    public /* synthetic */ void m2545l() {
        try {
            this.f2871f = new MediaPlayer();
            this.f2871f.setAudioStreamType(3);
            this.f2871f.setLooping(this.f2870d.f2759c.f2864e);
            this.f2871f.setOnPreparedListener(this);
            this.f2871f.setOnCompletionListener(this);
            this.f2871f.setOnBufferingUpdateListener(this);
            this.f2871f.setScreenOnWhilePlaying(true);
            this.f2871f.setOnSeekCompleteListener(this);
            this.f2871f.setOnErrorListener(this);
            this.f2871f.setOnInfoListener(this);
            this.f2871f.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.f2871f, this.f2870d.f2759c.m2522c().toString(), this.f2870d.f2759c.f2863d);
            this.f2871f.prepareAsync();
            this.f2871f.setSurface(new Surface(AbstractTextureViewSurfaceTextureListenerC1281w.f2866e));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: m */
    public /* synthetic */ void m2546m() {
        this.f2871f.start();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i2) {
        this.f2869c.post(new Runnable() { // from class: cn.jzvd.g
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2535a(i2);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f2869c.post(new Runnable() { // from class: cn.jzvd.k
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2541h();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.f2869c.post(new Runnable() { // from class: cn.jzvd.d
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2536a(i2, i3);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.f2869c.post(new Runnable() { // from class: cn.jzvd.e
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2538b(i2, i3);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f2869c.post(new Runnable() { // from class: cn.jzvd.m
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2542i();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.f2869c.post(new Runnable() { // from class: cn.jzvd.j
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2543j();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        SurfaceTexture surfaceTexture2 = AbstractTextureViewSurfaceTextureListenerC1281w.f2866e;
        if (surfaceTexture2 != null) {
            this.f2870d.f2777u.setSurfaceTexture(surfaceTexture2);
        } else {
            AbstractTextureViewSurfaceTextureListenerC1281w.f2866e = surfaceTexture;
            mo2531e();
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
        this.f2869c.post(new Runnable() { // from class: cn.jzvd.l
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2540c(i2, i3);
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m2534a(MediaPlayer mediaPlayer, HandlerThread handlerThread) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        handlerThread.quit();
    }

    /* renamed from: c */
    public /* synthetic */ void m2540c(int i2, int i3) {
        this.f2870d.m2467c(i2, i3);
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: b */
    public long mo2528b() {
        if (this.f2871f != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: a */
    public long mo2523a() {
        if (this.f2871f != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    /* renamed from: b */
    public /* synthetic */ void m2537b(float f2, float f3) {
        MediaPlayer mediaPlayer = this.f2871f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f3);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m2538b(int i2, int i3) {
        this.f2870d.m2465b(i2, i3);
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: a */
    public void mo2525a(final float f2, final float f3) {
        Handler handler = this.f2868b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: cn.jzvd.b
            @Override // java.lang.Runnable
            public final void run() {
                C1282x.this.m2537b(f2, f3);
            }
        });
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    @RequiresApi(api = 23)
    /* renamed from: a */
    public void mo2524a(float f2) {
        PlaybackParams playbackParams = this.f2871f.getPlaybackParams();
        playbackParams.setSpeed(f2);
        this.f2871f.setPlaybackParams(playbackParams);
    }

    /* renamed from: a */
    public /* synthetic */ void m2535a(int i2) {
        this.f2870d.setBufferProgress(i2);
    }

    /* renamed from: a */
    public /* synthetic */ void m2536a(int i2, int i3) {
        this.f2870d.m2451a(i2, i3);
    }

    @Override // cn.jzvd.AbstractTextureViewSurfaceTextureListenerC1281w
    /* renamed from: a */
    public void mo2527a(Surface surface) {
        this.f2871f.setSurface(surface);
    }
}
