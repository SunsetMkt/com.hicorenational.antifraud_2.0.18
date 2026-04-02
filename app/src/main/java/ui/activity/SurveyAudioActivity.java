package ui.activity;

import adapter.AudioProgressBlueAdapter;
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
import bean.ProgressBean;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.PermissionsListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import manager.MediaPlayerManager;
import network.gson.ResponseDataTypeAdaptor;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.SurveyAudioCallView;
import ui.presenter.SurveyAudioPresenter;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class SurveyAudioActivity extends BaseProgressUploadActivity implements SurveyAudioCallView, BaseQuickAdapter.i, MediaPlayer.OnCompletionListener {
    private AudioProgressBlueAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.ll_add_suspect)
    View mLlAddBtn;
    private MediaPlayer mMediaPlayer;
    private SurveyAudioPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.recyclerview_suspect)
    RecyclerView mRecyclerviewSuspect;
    private AudioProgressBlueAdapter mSecondAdapter;

    @BindView(R.id.tv_add)
    TextView mTvAdd;

    @BindView(R.id.tv_suspect_tip)
    TextView mTvSuspectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private final int REQUEST_CODE_VICTIM = 1000;
    private final int REQUEST_CODE_SUSPECT = 1001;
    private String caseInfoId = "";
    private String mSuspectId = "";
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private List<LocalMedia> mSecondLocalMedia = new ArrayList();
    private int mMaxSelectNum = 5;
    public int oldClickPosition = -1;
    private ImageView mCurrentPlay = null;
    private String mEndStr = "\u6761\u5f55\u97f3";

    class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            util.s1.c(b.a.u.a.f1912n, "onPrepared        \u5f00\u59cb\u64ad\u653e          ");
            SurveyAudioActivity.this.mMediaPlayer.start();
        }
    }

    class b implements PermissionsListener {
        final /* synthetic */ List a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f13889b;

        b(List list, int i2) {
            this.a = list;
            this.f13889b = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(SurveyAudioActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            k.e.a(SurveyAudioActivity.this.mActivity, 200L, PictureMimeType.ofAudio(), SurveyAudioActivity.this.mMaxSelectNum - this.a.size(), false).forResult(this.f13889b);
        }
    }

    private void addNewBean(List<LocalMedia> list, List<LocalMedia> list2, List<UploadFileBean> list3, List<UploadStateInfo> list4, AudioProgressBlueAdapter audioProgressBlueAdapter) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(list);
        }
        deleteDoubleElement(list2, g2.a(list), null, list3, list4);
        if (list4.size() <= 0) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                LocalMedia localMedia = list2.get(i2);
                UploadFileBean uploadFileBean = new UploadFileBean();
                uploadFileBean.setLocalPath(localMedia.getPath());
                uploadFileBean.setFileName(localMedia.getFileName());
                uploadFileBean.setFileSize(localMedia.getSize());
                list3.add(i2, uploadFileBean);
                list4.add(new UploadStateInfo(localMedia.getSize()));
            }
        }
        audioProgressBlueAdapter.notifyDataSetChanged();
        changeBtnCommit("\u786e\u5b9a", true);
    }

    private long changeUnit(long j2) {
        return j2 / 1024;
    }

    private void changeUploadState(ImageView imageView, TextView textView, TextView textView2, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView2.setText("\u7b49\u5f85\u4e0a\u4f20");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 1) {
            textView2.setText("\u4e0a\u4f20\u4e2d");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.black_dark));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 2) {
            textView2.setText("\u4e0a\u4f20\u5b8c\u6210");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.blue));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState != 3) {
            return;
        }
        textView2.setText("\u4e0a\u4f20\u5931\u8d25");
        textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorRed));
        textView.setTextColor(Hicore.getApp().getResources().getColor(R.color._FF4002));
        textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
        imageView.setVisibility(0);
    }

    private void checkPermission(int i2, List<LocalMedia> list) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new b(list, i2));
    }

    private LocalMedia getCurrentItem(int i2) {
        UploadStateInfo uploadStateInfo = this.mStateList.get(i2);
        if (this.mFirstStateList.contains(uploadStateInfo)) {
            return this.mLocalMedia.get(this.mFirstStateList.indexOf(uploadStateInfo));
        }
        if (this.mSecondStateList.contains(uploadStateInfo)) {
            return this.mSecondLocalMedia.get(this.mSecondStateList.indexOf(uploadStateInfo));
        }
        e2.a("\u6570\u636e\u5f02\u5e38");
        return null;
    }

    private int getCurrentTotalPosition(BaseQuickAdapter baseQuickAdapter, int i2) {
        return (baseQuickAdapter != this.mAdapter && baseQuickAdapter == this.mSecondAdapter) ? i2 + this.mLocalMedia.size() : i2;
    }

    private void info2LocalMedia(Intent intent, List<LocalMedia> list) {
        String stringExtra = intent.getStringExtra(util.p1.R0);
        if (TextUtils.isEmpty(stringExtra)) {
            e2.a("\u6587\u4ef6\u4e0d\u5b58\u5728");
            return;
        }
        String stringExtra2 = intent.getStringExtra(util.p1.S0);
        long length = 0;
        long longExtra = intent.getLongExtra(util.p1.T0, 0L);
        try {
            File file = new File(stringExtra);
            if (file.exists()) {
                length = file.length();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(stringExtra);
        localMedia.setFileName(stringExtra2);
        localMedia.setDuration(longExtra);
        localMedia.setSize(length);
        list.add(localMedia);
    }

    private AudioProgressBlueAdapter initRecycle(RecyclerView recyclerView, List<LocalMedia> list, List<UploadStateInfo> list2) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        AudioProgressBlueAdapter audioProgressBlueAdapter = new AudioProgressBlueAdapter(R.layout.item_survey_audio_new, list, list2);
        audioProgressBlueAdapter.a(recyclerView);
        recyclerView.setAdapter(audioProgressBlueAdapter);
        audioProgressBlueAdapter.setOnItemChildClickListener(this);
        return audioProgressBlueAdapter;
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
        String path = getCurrentItem(i2).getPath();
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
                this.mMediaPlayer.setOnPreparedListener(new a());
                this.mMediaPlayer.prepareAsync();
                this.mMediaPlayer.setOnCompletionListener(this);
                this.mStateList.get(i2).setPlayState(true);
                notifyAdapter();
                ((AnimationDrawable) imageView.getBackground()).start();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void sendData() {
        this.mSecondLocalMedia.clear();
        org.greenrobot.eventbus.c.f().c(new util.n2.a(4, this.mUploadList));
        finish();
    }

    private void setRedisplayData(List<UploadFileBean> list, List<UploadFileBean> list2, List<UploadStateInfo> list3, List<LocalMedia> list4) {
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        list.addAll(list2);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (UploadFileBean uploadFileBean : list) {
            UploadStateInfo uploadStateInfo = new UploadStateInfo();
            uploadStateInfo.setUploadState(2);
            uploadStateInfo.setFileSize(uploadFileBean.getFileSize());
            uploadStateInfo.setTotal(uploadFileBean.getFileSize());
            uploadStateInfo.setProgress(uploadFileBean.getFileSize());
            list3.add(uploadStateInfo);
            LocalMedia localMedia = new LocalMedia();
            String localPath = uploadFileBean.getLocalPath();
            if (TextUtils.isEmpty(localPath) || (!TextUtils.isEmpty(localPath) && !new File(localPath).exists())) {
                localPath = uploadFileBean.getFileUrl();
                if (TextUtils.isEmpty(localPath)) {
                    localPath = uploadFileBean.getFilePath();
                }
            }
            localMedia.setPath(localPath);
            localMedia.setFileName(uploadFileBean.getFileName());
            localMedia.setSize(uploadFileBean.getFileSize());
            list4.add(localMedia);
        }
    }

    private void stopPlay(int i2, ImageView imageView) {
        this.oldClickPosition = -1;
        this.mMediaPlayer.pause();
        this.mMediaPlayer.reset();
        this.mStateList.get(i2).setPlayState(false);
        imageView.setBackground(null);
        imageView.setBackground(getResources().getDrawable(R.drawable.anim_defraud_play_blue));
        notifyAdapter();
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mBtnCommit.setText(str);
        }
        this.mBtnCommit.setEnabled(z);
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void deteleUploadHttp(String str) {
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void doUploadHttp() {
        List<UploadStateInfo> list;
        int i2 = this.mCurrentUploadIndex;
        if (i2 <= -1 || (list = this.mStateList) == null || i2 >= list.size()) {
            return;
        }
        UploadFileBean uploadFileBean = this.mUploadList.get(this.mCurrentUploadIndex);
        com.google.gson.e eVarBuildGson = ResponseDataTypeAdaptor.buildGson();
        UploadFileBean uploadFileBean2 = (UploadFileBean) eVarBuildGson.a(eVarBuildGson.a(uploadFileBean), UploadFileBean.class);
        if (!TextUtils.isEmpty(this.mSuspectId)) {
            uploadFileBean2.setSuspectInfoID(this.mSuspectId);
        }
        uploadFileBean2.setId(this.caseInfoId);
        uploadFileBean2.setFileType(1);
        this.mPresenter.uploadDetail(uploadFileBean2);
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void finishFile() {
        sendData();
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public int getChildSource() {
        return 2;
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public int getDataType() {
        return 2;
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public List<UploadFileBean> getOldData() {
        return null;
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public List<UploadFileBean> getSecondOldData() {
        return (List) getIntent().getSerializableExtra(util.p1.p);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u8bed\u97f3\u4e0a\u4f20");
        this.mTvAdd.setText("\u6dfb\u52a0\u4e8b\u4e3b\u5f55\u97f3");
        this.mTvSuspectTip.setText("\uff08\u6700\u591a\u53ef\u6dfb\u52a0" + this.mMaxSelectNum + "\u6761\u5acc\u7591\u4eba\u5f55\u97f3\uff09");
        this.mPresenter = new SurveyAudioPresenter(this, this);
        this.mAdapter = initRecycle(this.mRecyclerview, this.mLocalMedia, this.mFirstStateList);
        this.mSecondAdapter = initRecycle(this.mRecyclerviewSuspect, this.mSecondLocalMedia, this.mSecondStateList);
        MediaPlayerManager.getInstance();
        this.mMediaPlayer = MediaPlayerManager.getMediaPlayer();
        org.greenrobot.eventbus.c.f().e(this);
        this.caseInfoId = getIntent().getStringExtra(util.p1.C0);
        this.mSuspectId = getIntent().getStringExtra(util.p1.q);
        if (TextUtils.isEmpty(this.caseInfoId)) {
            this.mLlAddBtn.setVisibility(8);
            this.mBtnCommit.setVisibility(8);
            this.mSecondAdapter.k(true);
        }
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void notifyAdapter() {
        super.notifyAdapter();
        if (this.mLocalMedia != null) {
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.mSecondLocalMedia != null) {
            this.mSecondAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 1000) {
                addNewBean(PictureSelector.obtainMultipleResult(intent), this.mLocalMedia, this.mFirstUploadList, this.mFirstStateList, this.mAdapter);
                return;
            }
            if (i2 == 1001) {
                try {
                    addNewBean(PictureSelector.obtainMultipleResult(intent), this.mSecondLocalMedia, this.mSecondUploadList, this.mSecondStateList, this.mSecondAdapter);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (i2 == 2001) {
                if (intent != null) {
                    ArrayList arrayList = new ArrayList();
                    info2LocalMedia(intent, arrayList);
                    addNewBean(arrayList, this.mLocalMedia, this.mFirstUploadList, this.mFirstStateList, this.mAdapter);
                    return;
                }
                return;
            }
            if (i2 == 2002 && intent != null) {
                ArrayList arrayList2 = new ArrayList();
                info2LocalMedia(intent, arrayList2);
                addNewBean(arrayList2, this.mSecondLocalMedia, this.mSecondUploadList, this.mSecondStateList, this.mSecondAdapter);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* JADX INFO: renamed from: onBackPressed */
    public void a() {
        super.a();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        util.s1.c(b.a.u.a.f1912n, "onCompletion              \u97f3\u9891\u64ad\u653e\u5b8c\u6210 \u590d\u4f4d");
        mediaPlayer.stop();
        this.mMediaPlayer.reset();
        this.mStateList.get(this.oldClickPosition).setPlayState(false);
        this.oldClickPosition = -1;
        notifyAdapter();
    }

    @Override // ui.activity.BaseProgressUploadActivity, ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @Override // ui.callview.SurveyAudioCallView
    public void onDeteleSuccess() {
    }

    @Override // ui.callview.SurveyAudioCallView
    public void onErrorRequest() {
        resultFail();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 201) {
            return;
        }
        ProgressBean progressBean = (ProgressBean) aVar.b();
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1) {
            try {
                UploadStateInfo uploadStateInfo = this.mStateList.get(i2);
                if (this.mFirstStateList.contains(uploadStateInfo)) {
                    if (this.mFirstStateList.indexOf(uploadStateInfo) >= 0) {
                        uploadStateInfo.setTotal(progressBean.getTotal());
                        uploadStateInfo.setProgress(progressBean.getProgress());
                        changeUploadState((ImageView) this.mAdapter.a(this.mCurrentUploadIndex, R.id.iv_fail), (TextView) this.mAdapter.a(this.mCurrentUploadIndex, R.id.tv_size_time), (TextView) this.mAdapter.a(this.mCurrentUploadIndex, R.id.tv_upload_state), uploadStateInfo);
                    }
                } else if (this.mSecondStateList.contains(uploadStateInfo) && this.mSecondStateList.indexOf(uploadStateInfo) >= 0) {
                    uploadStateInfo.setTotal(progressBean.getTotal());
                    uploadStateInfo.setProgress(progressBean.getProgress());
                    changeUploadState((ImageView) this.mSecondAdapter.a(this.mCurrentUploadIndex, R.id.iv_fail), (TextView) this.mSecondAdapter.a(this.mCurrentUploadIndex, R.id.tv_size_time), (TextView) this.mSecondAdapter.a(this.mCurrentUploadIndex, R.id.tv_upload_state), uploadStateInfo);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == R.id.img_defraud_play) {
            creatAllData();
            this.mCurrentPlay = (ImageView) baseQuickAdapter.a(i2, R.id.img_defraud_play);
            playAudio(getCurrentTotalPosition(baseQuickAdapter, i2), this.mCurrentPlay);
        } else if (id == R.id.iv_clear) {
            creatAllData();
            deleteDialog(getCurrentTotalPosition(baseQuickAdapter, i2));
        } else {
            if (id != R.id.iv_fail) {
                return;
            }
            creatAllData();
            if (rejuctOperation(false)) {
                return;
            }
            UploadOneFile(getCurrentTotalPosition(baseQuickAdapter, i2));
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
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

    @Override // ui.callview.SurveyAudioCallView
    public void onSaveSuccess(UploadFileBean uploadFileBean) {
        int i2 = this.mCurrentUploadIndex;
        if (i2 <= -1) {
            return;
        }
        List<UploadFileBean> list = this.mUploadList;
        if (list != null && i2 < list.size()) {
            this.mUploadList.get(this.mCurrentUploadIndex).setId(uploadFileBean.getCallTelDetailID());
            this.mUploadList.get(this.mCurrentUploadIndex).setSuspectInfoID(uploadFileBean.getCallTelDetailID());
            this.mUploadList.get(this.mCurrentUploadIndex).setFilePath(uploadFileBean.getFilePath());
            this.mUploadList.get(this.mCurrentUploadIndex).setFileMd5(uploadFileBean.getFileMd5());
            this.mUploadList.get(this.mCurrentUploadIndex).setFileSHA1(uploadFileBean.getFileSHA1());
        }
        if (TextUtils.isEmpty(this.mSuspectId)) {
            this.mSuspectId = uploadFileBean.getCallTelDetailID();
        }
        resultSuccess();
    }

    @Override // ui.callview.SurveyAudioCallView
    public void onStartRequest() {
        startRequest();
    }

    @OnClick({R.id.iv_back, R.id.ll_add, R.id.ll_add_suspect, R.id.btn_commit})
    public void onViewClicked(View view) {
        List<LocalMedia> list;
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    List<LocalMedia> list2 = this.mLocalMedia;
                    if ((list2 != null && list2.size() > 0) || ((list = this.mSecondLocalMedia) != null && list.size() > 0)) {
                        commitDeal();
                    } else {
                        sendData();
                    }
                    break;
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.ll_add /* 2131296964 */:
                if (!rejuctOperation(false)) {
                    List<LocalMedia> list3 = this.mLocalMedia;
                    if (list3 != null && list3.size() == this.mMaxSelectNum) {
                        e2.a(getResources().getString(R.string.select_warn_start_str) + this.mMaxSelectNum + this.mEndStr);
                    } else {
                        checkPermission(1000, this.mLocalMedia);
                    }
                    break;
                }
                break;
            case R.id.ll_add_suspect /* 2131296965 */:
                if (!rejuctOperation(false)) {
                    List<LocalMedia> list4 = this.mSecondLocalMedia;
                    if (list4 != null && list4.size() == this.mMaxSelectNum) {
                        e2.a(getResources().getString(R.string.select_warn_start_str) + this.mMaxSelectNum + this.mEndStr);
                    } else {
                        checkPermission(1001, this.mSecondLocalMedia);
                    }
                    break;
                }
                break;
        }
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void redisplayData(List<UploadFileBean> list) {
        setRedisplayData(list, getOldData(), this.mFirstStateList, this.mLocalMedia);
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void removeLocalData(int i2) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            stopPlay(i2, this.mCurrentPlay);
        }
        try {
            UploadStateInfo uploadStateInfo = this.mStateList.get(i2);
            if (this.mFirstStateList.contains(uploadStateInfo)) {
                int iIndexOf = this.mFirstStateList.indexOf(uploadStateInfo);
                if (iIndexOf >= 0) {
                    this.mLocalMedia.remove(iIndexOf);
                    this.mFirstUploadList.remove(iIndexOf);
                    this.mFirstStateList.remove(iIndexOf);
                    return;
                }
                return;
            }
            if (!this.mSecondStateList.contains(uploadStateInfo)) {
                e2.a("\u97f3\u9891\uff0c\u6570\u636e\u5f02\u5e38");
                return;
            }
            int iIndexOf2 = this.mSecondStateList.indexOf(uploadStateInfo);
            if (iIndexOf2 >= 0) {
                this.mSecondLocalMedia.remove(iIndexOf2);
                this.mSecondUploadList.remove(iIndexOf2);
                this.mSecondStateList.remove(iIndexOf2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // ui.activity.BaseProgressUploadActivity
    public void secondRedisplayData(List<UploadFileBean> list) {
        setRedisplayData(list, getSecondOldData(), this.mSecondStateList, this.mSecondLocalMedia);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_survey_audio;
    }
}
