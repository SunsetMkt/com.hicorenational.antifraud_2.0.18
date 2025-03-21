package com.luck.picture.lib;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.tools.DateUtils;

@Deprecated
/* loaded from: classes.dex */
public class PicturePlayAudioActivity extends PictureBaseActivity implements View.OnClickListener {
    private String audio_path;
    private MediaPlayer mediaPlayer;
    private SeekBar musicSeekBar;
    private TextView tv_PlayPause;
    private TextView tv_Quit;
    private TextView tv_Stop;
    private TextView tv_musicStatus;
    private TextView tv_musicTime;
    private TextView tv_musicTotal;
    private boolean isPlayAudio = false;
    public Handler handler = new Handler();
    public Runnable runnable = new Runnable() { // from class: com.luck.picture.lib.PicturePlayAudioActivity.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (PicturePlayAudioActivity.this.mediaPlayer != null) {
                    PicturePlayAudioActivity.this.tv_musicTime.setText(DateUtils.formatDurationTime(PicturePlayAudioActivity.this.mediaPlayer.getCurrentPosition()));
                    PicturePlayAudioActivity.this.musicSeekBar.setProgress(PicturePlayAudioActivity.this.mediaPlayer.getCurrentPosition());
                    PicturePlayAudioActivity.this.musicSeekBar.setMax(PicturePlayAudioActivity.this.mediaPlayer.getDuration());
                    PicturePlayAudioActivity.this.tv_musicTotal.setText(DateUtils.formatDurationTime(PicturePlayAudioActivity.this.mediaPlayer.getDuration()));
                    PicturePlayAudioActivity.this.handler.postDelayed(PicturePlayAudioActivity.this.runnable, 200L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    private void initPlayer(String str) {
        this.mediaPlayer = new MediaPlayer();
        try {
            this.mediaPlayer.setDataSource(str);
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            playAudio();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void playAudio() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            this.musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        if (this.tv_PlayPause.getText().toString().equals(getString(C2639R.string.picture_play_audio))) {
            this.tv_PlayPause.setText(getString(C2639R.string.picture_pause_audio));
            this.tv_musicStatus.setText(getString(C2639R.string.picture_play_audio));
            playOrPause();
        } else {
            this.tv_PlayPause.setText(getString(C2639R.string.picture_play_audio));
            this.tv_musicStatus.setText(getString(C2639R.string.picture_pause_audio));
            playOrPause();
        }
        if (this.isPlayAudio) {
            return;
        }
        this.handler.post(this.runnable);
        this.isPlayAudio = true;
    }

    /* renamed from: a */
    public /* synthetic */ void m8104a() {
        initPlayer(this.audio_path);
    }

    /* renamed from: b */
    public /* synthetic */ void m8105b() {
        stop(this.audio_path);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return C2639R.layout.picture_play_audio;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.audio_path = getIntent().getStringExtra(PictureConfig.EXTRA_AUDIO_PATH);
        this.tv_musicStatus = (TextView) findViewById(C2639R.id.tv_musicStatus);
        this.tv_musicTime = (TextView) findViewById(C2639R.id.tv_musicTime);
        this.musicSeekBar = (SeekBar) findViewById(C2639R.id.musicSeekBar);
        this.tv_musicTotal = (TextView) findViewById(C2639R.id.tv_musicTotal);
        this.tv_PlayPause = (TextView) findViewById(C2639R.id.tv_PlayPause);
        this.tv_Stop = (TextView) findViewById(C2639R.id.tv_Stop);
        this.tv_Quit = (TextView) findViewById(C2639R.id.tv_Quit);
        this.handler.postDelayed(new Runnable() { // from class: com.luck.picture.lib.m
            @Override // java.lang.Runnable
            public final void run() {
                PicturePlayAudioActivity.this.m8104a();
            }
        }, 30L);
        this.tv_PlayPause.setOnClickListener(this);
        this.tv_Stop.setOnClickListener(this);
        this.tv_Quit.setOnClickListener(this);
        this.musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.luck.picture.lib.PicturePlayAudioActivity.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    PicturePlayAudioActivity.this.mediaPlayer.seekTo(i2);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void m8092a() {
        super.m8092a();
        closeActivity();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C2639R.id.tv_PlayPause) {
            playAudio();
        }
        if (id == C2639R.id.tv_Stop) {
            this.tv_musicStatus.setText(getString(C2639R.string.picture_stop_audio));
            this.tv_PlayPause.setText(getString(C2639R.string.picture_play_audio));
            stop(this.audio_path);
        }
        if (id == C2639R.id.tv_Quit) {
            this.handler.removeCallbacks(this.runnable);
            new Handler().postDelayed(new Runnable() { // from class: com.luck.picture.lib.n
                @Override // java.lang.Runnable
                public final void run() {
                    PicturePlayAudioActivity.this.m8105b();
                }
            }, 30L);
            try {
                closeActivity();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Handler handler;
        super.onDestroy();
        if (this.mediaPlayer == null || (handler = this.handler) == null) {
            return;
        }
        handler.removeCallbacks(this.runnable);
        this.mediaPlayer.release();
        this.mediaPlayer = null;
    }

    public void playOrPause() {
        try {
            if (this.mediaPlayer != null) {
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.pause();
                } else {
                    this.mediaPlayer.start();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stop(String str) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.mediaPlayer.reset();
                this.mediaPlayer.setDataSource(str);
                this.mediaPlayer.prepare();
                this.mediaPlayer.seekTo(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
