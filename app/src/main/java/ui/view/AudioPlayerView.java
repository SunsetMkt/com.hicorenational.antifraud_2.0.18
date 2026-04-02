package ui.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import com.just.agentweb.DefaultWebClient;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import util.a1;

/* JADX INFO: loaded from: classes2.dex */
public class AudioPlayerView extends LinearLayout {
    private ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SeekBar f14481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f14482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f14483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MediaPlayer f14484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f14486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f14487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f14488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f14489j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AudioPlayerView.this.f14485f || AudioPlayerView.this.f14484e == null) {
                return;
            }
            AudioPlayerView.this.j();
            AudioPlayerView.this.f14486g.postDelayed(this, 1000L);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AudioPlayerView.this.f14488i == null) {
                if (AudioPlayerView.this.f14489j != null) {
                    AudioPlayerView.this.f14489j.onError("\u8bf7\u5148\u8bbe\u7f6e\u97f3\u9891\u6587\u4ef6");
                }
            } else if (AudioPlayerView.this.f14485f) {
                AudioPlayerView.this.b();
            } else {
                AudioPlayerView.this.c();
            }
        }
    }

    class c implements SeekBar.OnSeekBarChangeListener {
        c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (!z || AudioPlayerView.this.f14484e == null) {
                return;
            }
            AudioPlayerView.this.f14484e.seekTo(i2);
            AudioPlayerView.this.c(i2);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            AudioPlayerView.this.f14486g.removeCallbacks(AudioPlayerView.this.f14487h);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (AudioPlayerView.this.f14485f) {
                AudioPlayerView.this.f14486g.post(AudioPlayerView.this.f14487h);
            }
        }
    }

    class d implements MediaPlayer.OnPreparedListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AudioPlayerView.this.f14481b.setMax(mediaPlayer.getDuration());
            AudioPlayerView.this.d(mediaPlayer.getDuration());
            mediaPlayer.start();
            AudioPlayerView.this.f14485f = true;
            AudioPlayerView.this.i();
            AudioPlayerView.this.f14486g.post(AudioPlayerView.this.f14487h);
            if (AudioPlayerView.this.f14489j != null) {
                AudioPlayerView.this.f14489j.onPlay();
            }
        }
    }

    class e implements MediaPlayer.OnCompletionListener {
        e() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioPlayerView.this.f14485f = false;
            AudioPlayerView.this.i();
            AudioPlayerView.this.f14481b.setProgress(0);
            AudioPlayerView.this.c(0);
            AudioPlayerView.this.f14486g.removeCallbacks(AudioPlayerView.this.f14487h);
            if (AudioPlayerView.this.f14489j != null) {
                AudioPlayerView.this.f14489j.a();
            }
        }
    }

    class f implements MediaPlayer.OnErrorListener {
        f() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            String str;
            AudioPlayerView.this.f14485f = false;
            AudioPlayerView.this.i();
            AudioPlayerView.this.f14486g.removeCallbacks(AudioPlayerView.this.f14487h);
            if (i2 == 1) {
                str = "\u64ad\u653e\u9519\u8bef: \u672a\u77e5\u9519\u8bef";
            } else if (i2 != 100) {
                str = "\u64ad\u653e\u9519\u8bef: \u9519\u8bef\u7801: " + i2;
            } else {
                str = "\u64ad\u653e\u9519\u8bef: \u670d\u52a1\u5f02\u5e38";
            }
            if (AudioPlayerView.this.f14489j != null) {
                AudioPlayerView.this.f14489j.onError(str);
            }
            return true;
        }
    }

    public interface g {
        void a();

        void onError(String str);

        void onPause();

        void onPlay();
    }

    public AudioPlayerView(Context context) {
        super(context);
        this.f14485f = false;
        this.f14486g = new Handler();
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        MediaPlayer mediaPlayer = this.f14484e;
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            this.f14481b.setProgress(currentPosition);
            c(currentPosition);
        }
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f14484e;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        MediaPlayer mediaPlayer = this.f14484e;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public void setAudioFile(File file) {
        this.f14488i = file;
        try {
            if (this.f14484e.isPlaying()) {
                this.f14484e.stop();
            }
            this.f14484e.reset();
            this.f14484e.setDataSource(file.getAbsolutePath());
            this.f14481b.setProgress(0);
            this.f14482c.setText("00:00");
            this.f14483d.setText(a1.b(file.getPath()));
            this.f14485f = false;
            i();
        } catch (IOException e2) {
            e2.printStackTrace();
            g gVar = this.f14489j;
            if (gVar != null) {
                gVar.onError("\u6587\u4ef6\u52a0\u8f7d\u5931\u8d25: " + e2.getMessage());
            }
        }
    }

    public void setAudioSource(String str) {
        try {
            if (this.f14484e.isPlaying()) {
                this.f14484e.stop();
            }
            this.f14484e.reset();
            if (str.startsWith(DefaultWebClient.HTTP_SCHEME) || str.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                this.f14484e.setDataSource(str);
            } else {
                this.f14484e.setDataSource(str);
            }
            this.f14481b.setProgress(0);
            this.f14482c.setText("00:00");
            this.f14483d.setText("00:00");
            this.f14485f = false;
            i();
        } catch (IOException e2) {
            e2.printStackTrace();
            g gVar = this.f14489j;
            if (gVar != null) {
                gVar.onError("\u97f3\u9891\u6e90\u52a0\u8f7d\u5931\u8d25: " + e2.getMessage());
            }
        }
    }

    public void setAudioUrl(String str) {
        setAudioSource(str);
    }

    public void setOnPlaybackStateListener(g gVar) {
        this.f14489j = gVar;
    }

    private void g() {
        this.a = (ImageView) findViewById(R.id.btn_play_pause);
        this.f14481b = (SeekBar) findViewById(R.id.seekbar);
        this.f14482c = (TextView) findViewById(R.id.tv_current_time);
        this.f14483d = (TextView) findViewById(R.id.tv_total_time);
        this.a.setOnClickListener(new b());
        this.f14481b.setOnSeekBarChangeListener(new c());
    }

    private void h() {
        this.f14484e.setOnPreparedListener(new d());
        this.f14484e.setOnCompletionListener(new e());
        this.f14484e.setOnErrorListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f14485f) {
            this.a.setImageResource(R.mipmap.ic_ai_pause);
        } else {
            this.a.setImageResource(R.mipmap.ic_ai_play);
        }
    }

    public void c() {
        if (this.f14488i == null) {
            g gVar = this.f14489j;
            if (gVar != null) {
                gVar.onError("\u6ca1\u6709\u8bbe\u7f6e\u97f3\u9891\u6587\u4ef6");
                return;
            }
            return;
        }
        if (!this.f14484e.isPlaying()) {
            try {
                if (!this.f14484e.isPlaying()) {
                    this.f14484e.prepareAsync();
                    this.f14485f = true;
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                try {
                    this.f14484e.reset();
                    this.f14484e.setDataSource(this.f14488i.getAbsolutePath());
                    this.f14484e.prepareAsync();
                    this.f14485f = true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    g gVar2 = this.f14489j;
                    if (gVar2 != null) {
                        gVar2.onError("\u64ad\u653e\u5931\u8d25: " + e3.getMessage());
                    }
                }
            }
        }
        i();
    }

    public void d() {
        if (this.f14484e != null) {
            this.f14486g.removeCallbacks(this.f14487h);
            this.f14484e.release();
            this.f14484e = null;
        }
    }

    public void e() {
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setClickable(false);
        }
        SeekBar seekBar = this.f14481b;
        if (seekBar != null) {
            seekBar.setClickable(false);
            this.f14481b.setEnabled(false);
            this.f14481b.setOnSeekBarChangeListener(null);
        }
    }

    public void f() {
        if (this.f14484e.isPlaying()) {
            this.f14484e.pause();
            this.f14484e.stop();
            this.f14485f = false;
            i();
            this.f14481b.setProgress(0);
            c(0);
            this.f14486g.removeCallbacks(this.f14487h);
        }
    }

    public void b() {
        if (this.f14484e.isPlaying()) {
            this.f14484e.pause();
            this.f14485f = false;
            i();
            this.f14486g.removeCallbacks(this.f14487h);
            g gVar = this.f14489j;
            if (gVar != null) {
                gVar.onPause();
            }
        }
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_audio_player, (ViewGroup) this, true);
        g();
        this.f14484e = new MediaPlayer();
        this.f14487h = new a();
        h();
    }

    public AudioPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14485f = false;
        this.f14486g = new Handler();
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        this.f14483d.setText(b(i2));
    }

    public AudioPlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14485f = false;
        this.f14486g = new Handler();
        a(context);
    }

    public boolean a() {
        return this.f14485f;
    }

    private String b(int i2) {
        int i3 = i2 / 1000;
        return String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i3 / 60), Integer.valueOf(i3 % 60));
    }

    public void a(int i2) {
        MediaPlayer mediaPlayer = this.f14484e;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        this.f14482c.setText(b(i2));
    }
}
