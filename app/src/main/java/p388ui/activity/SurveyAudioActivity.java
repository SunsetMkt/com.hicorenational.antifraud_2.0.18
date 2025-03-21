package p388ui.activity;

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
import com.google.gson.C2051e;
import com.hicorenational.antifraud.C2113R;
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
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p000a.p001a.p014u.C0052a;
import p357j.C5846e;
import p388ui.Hicore;
import p388ui.callview.SurveyAudioCallView;
import p388ui.presenter.SurveyAudioPresenter;
import util.C7292k1;
import util.C7301n1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class SurveyAudioActivity extends BaseProgressUploadActivity implements SurveyAudioCallView, BaseQuickAdapter.InterfaceC1895i, MediaPlayer.OnCompletionListener {
    private AudioProgressBlueAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.ll_add_suspect)
    View mLlAddBtn;
    private MediaPlayer mMediaPlayer;
    private SurveyAudioPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.recyclerview_suspect)
    RecyclerView mRecyclerviewSuspect;
    private AudioProgressBlueAdapter mSecondAdapter;

    @BindView(C2113R.id.tv_add)
    TextView mTvAdd;

    @BindView(C2113R.id.tv_suspect_tip)
    TextView mTvSuspectTip;

    @BindView(C2113R.id.tv_title)
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
    private String mEndStr = "条录音";

    /* renamed from: ui.activity.SurveyAudioActivity$a */
    class C6615a implements MediaPlayer.OnPreparedListener {
        C6615a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            C7301n1.m26459c(C0052a.f162n, "onPrepared        开始播放          ");
            SurveyAudioActivity.this.mMediaPlayer.start();
        }
    }

    /* renamed from: ui.activity.SurveyAudioActivity$b */
    class C6616b implements PermissionsListener {

        /* renamed from: a */
        final /* synthetic */ List f23247a;

        /* renamed from: b */
        final /* synthetic */ int f23248b;

        C6616b(List list, int i2) {
            this.f23247a = list;
            this.f23248b = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(SurveyAudioActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24618a(SurveyAudioActivity.this.mActivity, 200L, PictureMimeType.ofAudio(), SurveyAudioActivity.this.mMaxSelectNum - this.f23247a.size(), false).forResult(this.f23248b);
        }
    }

    private void addNewBean(List<LocalMedia> list, List<LocalMedia> list2, List<UploadFileBean> list3, List<UploadStateInfo> list4, AudioProgressBlueAdapter audioProgressBlueAdapter) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(list);
        }
        deleteDoubleElement(list2, C7337y1.m26741a(list), null, list3, list4);
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
        changeBtnCommit("确定", true);
    }

    private long changeUnit(long j2) {
        return j2 / 1024;
    }

    private void changeUploadState(ImageView imageView, TextView textView, TextView textView2, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView2.setText("等待上传");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 1) {
            textView2.setText("上传中");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.black_dark));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 2) {
            textView2.setText("上传完成");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.blue));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState != 3) {
            return;
        }
        textView2.setText("上传失败");
        textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorRed));
        textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color._FF4002));
        textView.setText(changeUnit(uploadStateInfo.getProgress()) + "KB/" + changeUnit(uploadStateInfo.getFileSize()) + "KB");
        imageView.setVisibility(0);
    }

    private void checkPermission(int i2, List<LocalMedia> list) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6616b(list, i2));
    }

    private LocalMedia getCurrentItem(int i2) {
        UploadStateInfo uploadStateInfo = this.mStateList.get(i2);
        if (this.mFirstStateList.contains(uploadStateInfo)) {
            return this.mLocalMedia.get(this.mFirstStateList.indexOf(uploadStateInfo));
        }
        if (this.mSecondStateList.contains(uploadStateInfo)) {
            return this.mSecondLocalMedia.get(this.mSecondStateList.indexOf(uploadStateInfo));
        }
        C7331w1.m26688a("数据异常");
        return null;
    }

    private int getCurrentTotalPosition(BaseQuickAdapter baseQuickAdapter, int i2) {
        return (baseQuickAdapter != this.mAdapter && baseQuickAdapter == this.mSecondAdapter) ? i2 + this.mLocalMedia.size() : i2;
    }

    private void info2LocalMedia(Intent intent, List<LocalMedia> list) {
        String stringExtra = intent.getStringExtra(C7292k1.f25368R0);
        if (TextUtils.isEmpty(stringExtra)) {
            C7331w1.m26688a("文件不存在");
            return;
        }
        String stringExtra2 = intent.getStringExtra(C7292k1.f25370S0);
        long j2 = 0;
        long longExtra = intent.getLongExtra(C7292k1.f25372T0, 0L);
        try {
            File file = new File(stringExtra);
            if (file.exists()) {
                j2 = file.length();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(stringExtra);
        localMedia.setFileName(stringExtra2);
        localMedia.setDuration(longExtra);
        localMedia.setSize(j2);
        list.add(localMedia);
    }

    private AudioProgressBlueAdapter initRecycle(RecyclerView recyclerView, List<LocalMedia> list, List<UploadStateInfo> list2) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        AudioProgressBlueAdapter audioProgressBlueAdapter = new AudioProgressBlueAdapter(C2113R.layout.item_survey_audio_new, list, list2);
        audioProgressBlueAdapter.m5103a(recyclerView);
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
                this.mMediaPlayer.setOnPreparedListener(new C6615a());
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
        C6049c.m24987f().m24999c(new C7265a(4, this.mUploadList));
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
        imageView.setBackground(getResources().getDrawable(C2113R.drawable.anim_defraud_play_blue));
        notifyAdapter();
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mBtnCommit.setText(str);
        }
        this.mBtnCommit.setEnabled(z);
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public void deteleUploadHttp(String str) {
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public void doUploadHttp() {
        List<UploadStateInfo> list;
        int i2 = this.mCurrentUploadIndex;
        if (i2 <= -1 || (list = this.mStateList) == null || i2 >= list.size()) {
            return;
        }
        UploadFileBean uploadFileBean = this.mUploadList.get(this.mCurrentUploadIndex);
        C2051e buildGson = ResponseDataTypeAdaptor.buildGson();
        UploadFileBean uploadFileBean2 = (UploadFileBean) buildGson.m5569a(buildGson.m5572a(uploadFileBean), UploadFileBean.class);
        if (!TextUtils.isEmpty(this.mSuspectId)) {
            uploadFileBean2.setSuspectInfoID(this.mSuspectId);
        }
        uploadFileBean2.setId(this.caseInfoId);
        uploadFileBean2.setFileType(1);
        this.mPresenter.uploadDetail(uploadFileBean2);
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public void finishFile() {
        sendData();
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public int getChildSource() {
        return 2;
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public int getDataType() {
        return 2;
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public List<UploadFileBean> getOldData() {
        return null;
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public List<UploadFileBean> getSecondOldData() {
        return (List) getIntent().getSerializableExtra(C7292k1.f25426p);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("语音上传");
        this.mTvAdd.setText("添加事主录音");
        this.mTvSuspectTip.setText("（最多可添加" + this.mMaxSelectNum + "条嫌疑人录音）");
        this.mPresenter = new SurveyAudioPresenter(this, this);
        this.mAdapter = initRecycle(this.mRecyclerview, this.mLocalMedia, this.mFirstStateList);
        this.mSecondAdapter = initRecycle(this.mRecyclerviewSuspect, this.mSecondLocalMedia, this.mSecondStateList);
        MediaPlayerManager.getInstance();
        this.mMediaPlayer = MediaPlayerManager.getMediaPlayer();
        C6049c.m24987f().m25001e(this);
        this.caseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        this.mSuspectId = getIntent().getStringExtra(C7292k1.f25428q);
        if (TextUtils.isEmpty(this.caseInfoId)) {
            this.mLlAddBtn.setVisibility(8);
            this.mBtnCommit.setVisibility(8);
            this.mSecondAdapter.m212k(true);
        }
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
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
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        C7301n1.m26459c(C0052a.f162n, "onCompletion              音频播放完成 复位");
        mediaPlayer.stop();
        this.mMediaPlayer.reset();
        this.mStateList.get(this.oldClickPosition).setPlayState(false);
        this.oldClickPosition = -1;
        notifyAdapter();
    }

    @Override // p388ui.activity.BaseProgressUploadActivity, p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @Override // p388ui.callview.SurveyAudioCallView
    public void onDeteleSuccess() {
    }

    @Override // p388ui.callview.SurveyAudioCallView
    public void onErrorRequest() {
        resultFail();
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 201) {
            return;
        }
        ProgressBean progressBean = (ProgressBean) c7265a.m26300b();
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1) {
            try {
                UploadStateInfo uploadStateInfo = this.mStateList.get(i2);
                if (this.mFirstStateList.contains(uploadStateInfo)) {
                    if (this.mFirstStateList.indexOf(uploadStateInfo) >= 0) {
                        uploadStateInfo.setTotal(progressBean.getTotal());
                        uploadStateInfo.setProgress(progressBean.getProgress());
                        changeUploadState((ImageView) this.mAdapter.m5094a(this.mCurrentUploadIndex, C2113R.id.iv_fail), (TextView) this.mAdapter.m5094a(this.mCurrentUploadIndex, C2113R.id.tv_size_time), (TextView) this.mAdapter.m5094a(this.mCurrentUploadIndex, C2113R.id.tv_upload_state), uploadStateInfo);
                    }
                } else if (this.mSecondStateList.contains(uploadStateInfo) && this.mSecondStateList.indexOf(uploadStateInfo) >= 0) {
                    uploadStateInfo.setTotal(progressBean.getTotal());
                    uploadStateInfo.setProgress(progressBean.getProgress());
                    changeUploadState((ImageView) this.mSecondAdapter.m5094a(this.mCurrentUploadIndex, C2113R.id.iv_fail), (TextView) this.mSecondAdapter.m5094a(this.mCurrentUploadIndex, C2113R.id.tv_size_time), (TextView) this.mSecondAdapter.m5094a(this.mCurrentUploadIndex, C2113R.id.tv_upload_state), uploadStateInfo);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == C2113R.id.img_defraud_play) {
            creatAllData();
            this.mCurrentPlay = (ImageView) baseQuickAdapter.m5094a(i2, C2113R.id.img_defraud_play);
            playAudio(getCurrentTotalPosition(baseQuickAdapter, i2), this.mCurrentPlay);
        } else if (id == C2113R.id.iv_clear) {
            creatAllData();
            deleteDialog(getCurrentTotalPosition(baseQuickAdapter, i2));
        } else {
            if (id != C2113R.id.iv_fail) {
                return;
            }
            creatAllData();
            if (rejuctOperation(false)) {
                return;
            }
            UploadOneFile(getCurrentTotalPosition(baseQuickAdapter, i2));
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // p388ui.callview.SurveyAudioCallView
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

    @Override // p388ui.callview.SurveyAudioCallView
    public void onStartRequest() {
        startRequest();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_add, C2113R.id.ll_add_suspect, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        List<LocalMedia> list;
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    List<LocalMedia> list2 = this.mLocalMedia;
                    if ((list2 != null && list2.size() > 0) || ((list = this.mSecondLocalMedia) != null && list.size() > 0)) {
                        commitDeal();
                        break;
                    } else {
                        sendData();
                        break;
                    }
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.ll_add /* 2131296914 */:
                if (!rejuctOperation(false)) {
                    List<LocalMedia> list3 = this.mLocalMedia;
                    if (list3 != null && list3.size() == this.mMaxSelectNum) {
                        C7331w1.m26688a(getResources().getString(C2113R.string.select_warn_start_str) + this.mMaxSelectNum + this.mEndStr);
                        break;
                    } else {
                        checkPermission(1000, this.mLocalMedia);
                        break;
                    }
                }
                break;
            case C2113R.id.ll_add_suspect /* 2131296915 */:
                if (!rejuctOperation(false)) {
                    List<LocalMedia> list4 = this.mSecondLocalMedia;
                    if (list4 != null && list4.size() == this.mMaxSelectNum) {
                        C7331w1.m26688a(getResources().getString(C2113R.string.select_warn_start_str) + this.mMaxSelectNum + this.mEndStr);
                        break;
                    } else {
                        checkPermission(1001, this.mSecondLocalMedia);
                        break;
                    }
                }
                break;
        }
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public void redisplayData(List<UploadFileBean> list) {
        setRedisplayData(list, getOldData(), this.mFirstStateList, this.mLocalMedia);
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public void removeLocalData(int i2) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            stopPlay(i2, this.mCurrentPlay);
        }
        try {
            UploadStateInfo uploadStateInfo = this.mStateList.get(i2);
            if (this.mFirstStateList.contains(uploadStateInfo)) {
                int indexOf = this.mFirstStateList.indexOf(uploadStateInfo);
                if (indexOf >= 0) {
                    this.mLocalMedia.remove(indexOf);
                    this.mFirstUploadList.remove(indexOf);
                    this.mFirstStateList.remove(indexOf);
                    return;
                }
                return;
            }
            if (!this.mSecondStateList.contains(uploadStateInfo)) {
                C7331w1.m26688a("音频，数据异常");
                return;
            }
            int indexOf2 = this.mSecondStateList.indexOf(uploadStateInfo);
            if (indexOf2 >= 0) {
                this.mSecondLocalMedia.remove(indexOf2);
                this.mSecondUploadList.remove(indexOf2);
                this.mSecondStateList.remove(indexOf2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // p388ui.activity.BaseProgressUploadActivity
    public void secondRedisplayData(List<UploadFileBean> list) {
        setRedisplayData(list, getSecondOldData(), this.mSecondStateList, this.mSecondLocalMedia);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_survey_audio;
    }
}
