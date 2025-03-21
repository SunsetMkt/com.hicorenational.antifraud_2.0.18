package p388ui.presenter;

import adapter.AudioPreviewAdapter;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manager.MediaPlayerManager;
import p000a.p001a.p014u.C0052a;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7301n1;

/* loaded from: classes2.dex */
public class RecyclerAudioPresenter extends ModelPresent {
    private AudioPreviewAdapter mAdapter;
    private ImageView mCurrentPlay;
    private List<UploadFileBean> mList;
    private List<LocalMedia> mLocalMediaList;
    private MediaPlayer mMediaPlayer;
    private List<UploadStateInfo> mStateList;
    public int oldClickPosition;

    /* renamed from: ui.presenter.RecyclerAudioPresenter$a */
    class C7046a implements BaseQuickAdapter.InterfaceC1895i {
        C7046a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            if (view.getId() != C2113R.id.img_defraud_play) {
                return;
            }
            RecyclerAudioPresenter.this.mCurrentPlay = (ImageView) baseQuickAdapter.m5094a(i2, C2113R.id.img_defraud_play);
            RecyclerAudioPresenter recyclerAudioPresenter = RecyclerAudioPresenter.this;
            recyclerAudioPresenter.playAudio(i2, recyclerAudioPresenter.mCurrentPlay);
        }
    }

    /* renamed from: ui.presenter.RecyclerAudioPresenter$b */
    class C7047b implements MediaPlayer.OnPreparedListener {
        C7047b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            C7301n1.m26459c(C0052a.f162n, "onPrepared        开始播放          ");
            RecyclerAudioPresenter.this.mMediaPlayer.start();
        }
    }

    /* renamed from: ui.presenter.RecyclerAudioPresenter$c */
    class C7048c implements MediaPlayer.OnCompletionListener {
        C7048c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            C7301n1.m26459c(C0052a.f162n, "onCompletion              音频播放完成 复位");
            mediaPlayer.stop();
            RecyclerAudioPresenter.this.mMediaPlayer.reset();
            ((UploadStateInfo) RecyclerAudioPresenter.this.mStateList.get(RecyclerAudioPresenter.this.oldClickPosition)).setPlayState(false);
            RecyclerAudioPresenter recyclerAudioPresenter = RecyclerAudioPresenter.this;
            recyclerAudioPresenter.oldClickPosition = -1;
            recyclerAudioPresenter.notifyAdapter();
        }
    }

    public RecyclerAudioPresenter(Activity activity) {
        super(activity, (BaseView) null);
        this.mList = new ArrayList();
        this.mStateList = new ArrayList();
        this.mLocalMediaList = new ArrayList();
        this.oldClickPosition = -1;
        this.mCurrentPlay = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAudio(int i2, ImageView imageView) {
        int i3 = this.oldClickPosition;
        if (i3 == i2) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    stopPlay(i2, imageView);
                    return;
                }
                this.mMediaPlayer.start();
                this.mStateList.get(i2).setPlayState(true);
                ((AnimationDrawable) imageView.getBackground()).start();
                notifyAdapter();
                return;
            }
            return;
        }
        if (i3 != -1) {
            int size = this.mStateList.size();
            int i4 = this.oldClickPosition;
            if (size > i4) {
                this.mStateList.get(i4).setPlayState(false);
            }
        }
        this.oldClickPosition = i2;
        String path = this.mLocalMediaList.get(i2).getPath();
        if (TextUtils.isEmpty(path)) {
            return;
        }
        try {
            if (this.mMediaPlayer != null) {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.stop();
                }
                this.mMediaPlayer.reset();
                this.mMediaPlayer.setDataSource(path);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setOnPreparedListener(new C7047b());
                this.mMediaPlayer.prepareAsync();
                this.mMediaPlayer.setOnCompletionListener(new C7048c());
                this.mStateList.get(i2).setPlayState(true);
                notifyAdapter();
                ((AnimationDrawable) imageView.getBackground()).start();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void stopPlay(int i2, ImageView imageView) {
        this.oldClickPosition = -1;
        this.mMediaPlayer.pause();
        this.mMediaPlayer.reset();
        this.mStateList.get(i2).setPlayState(false);
        imageView.setBackground(null);
        imageView.setBackground(this.mActivity.getResources().getDrawable(C2113R.drawable.anim_defraud_play_blue));
        notifyAdapter();
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new AudioPreviewAdapter(this.mLocalMediaList, this.mStateList);
        this.mAdapter.m5103a(recyclerView);
        recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(new C7046a());
        MediaPlayerManager.getInstance();
        this.mMediaPlayer = MediaPlayerManager.getMediaPlayer();
    }

    public void onPause() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mStateList.get(this.oldClickPosition).setPlayState(false);
        notifyAdapter();
        this.oldClickPosition = -1;
        this.mMediaPlayer.pause();
        this.mMediaPlayer.reset();
    }

    public void setListData(List<UploadFileBean> list) {
        if (list != null) {
            this.mList.clear();
            this.mStateList.clear();
            this.mLocalMediaList.clear();
            this.mList.addAll(list);
            for (UploadFileBean uploadFileBean : this.mList) {
                UploadStateInfo uploadStateInfo = new UploadStateInfo();
                uploadStateInfo.setFileSize(uploadFileBean.getFileSize());
                uploadStateInfo.setTotal(uploadFileBean.getFileSize());
                uploadStateInfo.setProgress(uploadFileBean.getFileSize());
                this.mStateList.add(uploadStateInfo);
                LocalMedia localMedia = new LocalMedia();
                String localPath = uploadFileBean.getLocalPath();
                if (TextUtils.isEmpty(localPath) || (!TextUtils.isEmpty(localPath) && !new File(localPath).exists())) {
                    localPath = uploadFileBean.getFileUrl();
                }
                localMedia.setPath(localPath);
                localMedia.setFileName(uploadFileBean.getFileName());
                localMedia.setSize(uploadFileBean.getFileSize());
                this.mLocalMediaList.add(localMedia);
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
