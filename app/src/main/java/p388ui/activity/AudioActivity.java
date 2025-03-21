package p388ui.activity;

import adapter.AudioRecordDeleteAdapter;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.PermissionsListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import manager.MediaPlayerManager;
import network.ReportAppInfo;
import org.greenrobot.eventbus.C6049c;
import p000a.p001a.p014u.C0052a;
import p357j.C5846e;
import p388ui.presenter.AudioPresenter;
import util.C7301n1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class AudioActivity extends BaseUploadActivity implements BaseQuickAdapter.InterfaceC1895i, MediaPlayer.OnCompletionListener {
    private AudioRecordDeleteAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;
    private MediaPlayer mMediaPlayer;
    private AudioPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(C2113R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private int mMaxSelectNum = 9;
    public int oldClickPosition = -1;
    private ImageView mCurrentPlay = null;
    private String mEndStr = "条录音";

    /* renamed from: ui.activity.AudioActivity$a */
    class C6132a implements MediaPlayer.OnPreparedListener {
        C6132a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            C7301n1.m26459c(C0052a.f162n, "onPrepared        开始播放          ");
            AudioActivity.this.mMediaPlayer.start();
        }
    }

    /* renamed from: ui.activity.AudioActivity$b */
    class C6133b implements PermissionsListener {
        C6133b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(AudioActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(AudioActivity.this.mActivity, 200L, PictureMimeType.ofAudio(), AudioActivity.this.mMaxSelectNum - AudioActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6133b());
    }

    private ReportAppInfo createReport() {
        int i2;
        ReportAppInfo reportAppInfo = new ReportAppInfo();
        String childPath = getChildPath();
        reportAppInfo.setSource(getChildSource());
        reportAppInfo.setFileLocalPath(childPath);
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            reportAppInfo.setFilePath(this.mUploadStateList.get(i2).getFilePath());
            reportAppInfo.setFileMd5(this.mUploadStateList.get(this.mCurrentUploadIndex).getFileMd5());
        }
        return reportAppInfo;
    }

    private void playAudio(int i2, ImageView imageView) {
        int i3 = this.oldClickPosition;
        if (i3 == i2) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    stopPlay(i2, imageView);
                    return;
                }
                this.mMediaPlayer.start();
                this.mUploadStateList.get(i2).setPlayState(true);
                ((AnimationDrawable) imageView.getBackground()).start();
                return;
            }
            return;
        }
        if (i3 != -1) {
            int size = this.mUploadStateList.size();
            int i4 = this.oldClickPosition;
            if (size > i4) {
                this.mUploadStateList.get(i4).setPlayState(false);
            }
        }
        this.oldClickPosition = i2;
        try {
            if (this.mMediaPlayer != null) {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.stop();
                }
                this.mMediaPlayer.reset();
                this.mMediaPlayer.setDataSource(this.mLocalMedia.get(i2).getPath());
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setOnPreparedListener(new C6132a());
                this.mMediaPlayer.prepareAsync();
                this.mMediaPlayer.setOnCompletionListener(this);
                this.mUploadStateList.get(i2).setPlayState(true);
                this.mAdapter.notifyDataSetChanged();
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
        this.mUploadStateList.get(i2).setPlayState(false);
        imageView.setBackground(null);
        imageView.setBackground(getResources().getDrawable(C2113R.drawable.anim_defraud_play));
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (isFinishing() || this.mBtnCommit == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mBtnCommit.setText(str);
        }
        this.mBtnCommit.setEnabled(z);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void doUpload() {
        this.mPresenter.doAudioUpload(createReport(), this.info);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public String getChildPath() {
        try {
            return this.mLocalMedia.get(this.mCurrentUploadIndex).getPath();
        } catch (Exception unused) {
            changeBtnCommit("确定", true);
            return "";
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public int getChildSource() {
        return 2;
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加录音");
        this.mTvSelectTip.setText("添加");
        this.mTvCommitTip.setText(getResources().getString(C2113R.string.commit_tip_start_str) + this.mMaxSelectNum + this.mEndStr);
        this.mPresenter = new AudioPresenter(this);
        this.mPresenter.attachView(this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new AudioRecordDeleteAdapter(C2113R.layout.recyclerview_audio_record, this.mLocalMedia, this.mUploadStateList);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
        MediaPlayerManager.getInstance();
        this.mMediaPlayer = MediaPlayerManager.getMediaPlayer();
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        List<LocalMedia> obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(obtainMultipleResult);
        }
        deleteDoubleElement(this.mLocalMedia, C7337y1.m26741a(obtainMultipleResult), null);
        if (this.mUploadStateList.size() <= 0) {
            for (int i4 = 0; i4 < this.mLocalMedia.size(); i4++) {
                this.mUploadStateList.add(new UploadStateInfo());
            }
        }
        this.mAdapter.notifyDataSetChanged();
        if (isAllSuccess()) {
            changeBtnCommit("确定", true);
        } else {
            changeBtnCommit("文件上传", true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (backPressedUpload()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        C7301n1.m26459c(C0052a.f162n, "onCompletion              音频播放完成 复位");
        mediaPlayer.stop();
        this.mMediaPlayer.reset();
        this.mUploadStateList.get(this.oldClickPosition).setPlayState(false);
        this.oldClickPosition = -1;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == C2113R.id.iv_audio) {
            this.mCurrentPlay = (ImageView) baseQuickAdapter.m5094a(i2, C2113R.id.img_defraud_play);
            playAudio(i2, this.mCurrentPlay);
        } else {
            if (id != C2113R.id.iv_clear) {
                return;
            }
            deleteDialog(i2);
        }
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mUploadStateList.get(this.oldClickPosition).setPlayState(false);
        this.mAdapter.notifyDataSetChanged();
        this.oldClickPosition = -1;
        this.mMediaPlayer.pause();
        this.mMediaPlayer.reset();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.btn_commit) {
            if (LoginManager.getInstance().isLogOut()) {
                return;
            }
            List<LocalMedia> list = this.mLocalMedia;
            if (list == null || list.size() <= 0) {
                onBackPressed();
                return;
            } else {
                commitDeal();
                return;
            }
        }
        if (id == C2113R.id.iv_back) {
            onBackPressed();
            return;
        }
        if (id == C2113R.id.ll_select && !rejuctOperation(false)) {
            List<LocalMedia> list2 = this.mLocalMedia;
            if (list2 == null || list2.size() != this.mMaxSelectNum) {
                checkPermission();
                return;
            }
            C7331w1.m26688a(getResources().getString(C2113R.string.select_warn_start_str) + this.mMaxSelectNum + this.mEndStr);
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void redisplayData(C7265a c7265a) {
        List list = (List) c7265a.m26300b();
        if (list != null && list.size() > 0) {
            this.mLocalMedia.addAll(list);
        }
        List list2 = (List) c7265a.m26304d();
        if (list2 != null && list2.size() > 0) {
            this.mUploadStateList.addAll(list2);
        }
        this.mAdapter.notifyDataSetChanged();
        if (isAllSuccess()) {
            return;
        }
        changeBtnCommit("上传文件", true);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void removeLocalData(int i2) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            stopPlay(i2, this.mCurrentPlay);
        }
        this.mLocalMedia.remove(i2);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void sendData() {
        C6049c.m24987f().m25000d(new C7265a(4, this.mLocalMedia, this.mUploadStateList));
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_audio;
    }
}
