package p388ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bean.AppBean;
import bean.AppInfoBean;
import bean.CallBean;
import bean.CasePicBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import bean.SmsBean;
import bean.SocialAccBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.PictureFileUtils;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.LoginManager;
import network.HistoryListInfo;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p247e.C4447d;
import p357j.C5844c;
import p388ui.Hicore;
import p388ui.callview.ReportCallView;
import p388ui.presenter.ReportPresenter;
import p388ui.view.MyScrollView;
import p388ui.view.PicItemView;
import util.C7257b1;
import util.C7277f1;
import util.C7292k1;
import util.C7301n1;
import util.C7325u1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class ReportNewActivity extends BaseActivity implements ReportCallView {
    public static int REPORTNUM = 0;
    public static String REPORT_UP_ID = "";
    private static final int REQUEST_CODE_PICTURE = 1001;
    private Dialog dialogRP;
    private LocalMedia fromRecordMedia;
    private ReportZPEleBean info;
    private ArrayList<AppInfoBean> intentApps;
    private CallBean intentCallBean;
    private SmsBean intentSMSBean;

    @BindView(C2113R.id.tv_upload_app)
    TextView mAppNum;

    @BindView(C2113R.id.tv_upload_audio)
    TextView mAudioNum;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.tv_upload_call)
    TextView mCallNum;

    @BindView(C2113R.id.et_case_describe)
    TextView mEtCaseDescribe;

    @BindView(C2113R.id.fl_app_bg)
    View mFlAppBg;

    @BindView(C2113R.id.fl_audio_bg)
    View mFlAudioBg;

    @BindView(C2113R.id.fl_pic_bg)
    View mFlPicBg;

    @BindView(C2113R.id.fl_vedio_bg)
    View mFlVideoBg;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.ll_app)
    PicItemView mLlApp;

    @BindView(C2113R.id.ll_dupery_type)
    FrameLayout mLlDuperyType;

    @BindView(C2113R.id.ll_pic)
    PicItemView mLlPic;

    @BindView(C2113R.id.myScrollView)
    MyScrollView mMyScrollView;

    @BindView(C2113R.id.tv_num_tip)
    TextView mNumTip;

    @BindView(C2113R.id.tv_upload_picture)
    TextView mPicNum;
    private ReportPresenter mPresenter;

    @BindView(C2113R.id.region)
    TextView mRegion;

    @BindView(C2113R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(C2113R.id.tv_upload_sms)
    TextView mSMSNum;

    @BindView(C2113R.id.tv_social)
    TextView mSocialNum;

    @BindView(C2113R.id.tv_trad)
    TextView mTradNum;

    @BindView(C2113R.id.tv_attention)
    TextView mTvAttention;

    @BindView(C2113R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.tv_upload_url)
    TextView mUrlNum;

    @BindView(C2113R.id.tv_upload_video)
    TextView mVideoNum;
    private String mVideoPath;
    private List<LocalMedia> mLocalVideoList = new ArrayList();
    private List<LocalMedia> mLocalAudioList = new ArrayList();
    private List<UploadStateInfo> mAudioStateList = new ArrayList();
    private List<UploadStateInfo> mAppStateList = new ArrayList();
    private List<UploadStateInfo> mPictureStateList = new ArrayList();
    private List<UploadStateInfo> mVideoStateList = new ArrayList();
    private List<CallBean> mCallList = new ArrayList();
    private List<SmsBean> mSmsList = new ArrayList();
    private List<LocalMedia> mPictureList = new ArrayList();
    private List<AppInfoBean> mAppList = new ArrayList();
    private List<String> mWebUrlList = new ArrayList();
    private List<SocialAccBean> mSocialAccs = new ArrayList();
    private List<SocialAccBean> mTradlAccs = new ArrayList();
    private List<CasePicBean> mCasePic = new ArrayList();
    private List<AppBean> mApps = new ArrayList();
    private int mDefraudCode = -1;
    private boolean isFromVirusCheck = false;

    /* renamed from: ui.activity.ReportNewActivity$a */
    class RunnableC6501a implements Runnable {
        RunnableC6501a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ReportNewActivity.this.mMyScrollView.fullScroll(130);
        }
    }

    /* renamed from: ui.activity.ReportNewActivity$b */
    class C6502b implements PermissionsListener {
        C6502b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            ReportNewActivity.this.mPresenter.reportSubmit(ReportNewActivity.this.mCallList, ReportNewActivity.this.mSmsList, ReportNewActivity.this.mWebUrlList, ReportNewActivity.this.mSocialAccs, ReportNewActivity.this.mTradlAccs, ReportNewActivity.this.buildDiscCache());
        }
    }

    /* renamed from: ui.activity.ReportNewActivity$c */
    class C6503c implements IClickListener {
        C6503c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportNewActivity.this.mPresenter.cancleUploadFile(true);
            ReportNewActivity.this.cleanCacheData();
            ReportNewActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ReportNewActivity.this.saveCacheData();
            ReportNewActivity.this.cleanList();
            ReportNewActivity.this.finish();
        }
    }

    /* renamed from: ui.activity.ReportNewActivity$d */
    class C6504d implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ HistoryListInfo.RowsBean f22878a;

        C6504d(HistoryListInfo.RowsBean rowsBean) {
            this.f22878a = rowsBean;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportNewActivity.this.dialogRP.dismiss();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ReportNewActivity.this.dialogRP.dismiss();
            ReportNewActivity.this.finish();
            Intent intent = new Intent(ReportNewActivity.this.mActivity, (Class<?>) HistoryDetailActivity.class);
            intent.putExtra(C7292k1.f25335B, this.f22878a);
            ReportNewActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReportPersonBean buildDiscCache() {
        String str = getmRegionId();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String charSequence = this.mRegion.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        String charSequence2 = this.mTvDuperyType.getText().toString();
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        String charSequence3 = this.mEtCaseDescribe.getText().toString();
        String str2 = TextUtils.isEmpty(charSequence3) ? "" : charSequence3;
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic(str);
        reportPersonBean.setReportAdd(charSequence);
        reportPersonBean.setDupery(charSequence2);
        reportPersonBean.setDefraudType(this.mDefraudCode);
        reportPersonBean.setCaseDis(str2);
        return reportPersonBean;
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25531j}, new C6502b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanCacheData() {
        C7325u1.m26619a((Object) null, C7325u1.f25665c0);
        C7325u1.m26622a((List) null, C7325u1.f25667d0);
        C7325u1.m26622a((List) null, C7325u1.f25669e0);
        C7325u1.m26622a((List) null, C7325u1.f25671f0);
        C7325u1.m26622a((List) null, C7325u1.f25675h0);
        C7325u1.m26622a((List) null, C7325u1.f25681k0);
        C7325u1.m26622a((List) null, C7325u1.f25683l0);
        C7325u1.m26622a((List) null, C7325u1.f25685m0);
        C7325u1.m26622a((List) null, C7325u1.f25689o0);
        C7325u1.m26622a((List) null, C7325u1.f25691p0);
        C7325u1.m26622a((List) null, C7325u1.f25693q0);
        C7325u1.m26630b(C7325u1.f25702v, "");
        C5844c.m24594a(C5844c.f21112a);
        cleanList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanList() {
        REPORT_UP_ID = "";
        this.mCallList.clear();
        this.mSmsList.clear();
        this.mAppList.clear();
        this.mPictureList.clear();
        this.mLocalAudioList.clear();
        this.mLocalVideoList.clear();
        this.mWebUrlList.clear();
        this.mSocialAccs.clear();
        this.mTradlAccs.clear();
        this.mAudioStateList.clear();
        this.mAppStateList.clear();
        this.mPictureStateList.clear();
        this.mVideoStateList.clear();
        this.mCasePic.clear();
        this.mApps.clear();
        this.mLlApp.setAppSData(this.mApps);
        this.mLlPic.setPicListData(this.mPictureList);
        this.mTvDuperyType.setText("");
        this.mRegion.setText("");
        this.mEtCaseDescribe.setText("");
        this.info = null;
        this.mCallNum.setText("请选择");
        this.mSMSNum.setText("请选择");
        this.mAppNum.setText("请选择");
        this.mPicNum.setText("请选择");
        this.mAudioNum.setText("请选择");
        this.mVideoNum.setText("请选择");
        this.mUrlNum.setText("请填写");
        this.mSocialNum.setText("请填写");
        this.mTradNum.setText("请填写");
        this.mFlAppBg.setBackgroundResource(C2113R.drawable.white_corner);
        this.mFlPicBg.setBackgroundResource(C2113R.drawable.white_corner);
        this.mFlAudioBg.setBackgroundResource(C2113R.drawable.white_corner);
        this.mFlVideoBg.setBackgroundResource(C2113R.drawable.white_corner);
        PictureFileUtils.deleteAllCacheDirFile(this);
        TradAccountActivity.f23279c = false;
    }

    private void fixApps() {
        if (this.intentApps != null) {
            for (int i2 = 0; i2 < this.intentApps.size(); i2++) {
                this.mApps.add(AppBean.AppInfoBean2AppBean(this.intentApps.get(i2)));
                this.mAppStateList.add(new UploadStateInfo());
            }
        }
    }

    private void fixRecordMediasAudio() {
        if (C7277f1.m26363e(this.mVideoPath)) {
            this.mLocalAudioList.add(this.fromRecordMedia);
            this.mAudioNum.setText(this.mLocalAudioList.size() + "个");
            this.mAudioStateList.add(new UploadStateInfo());
        }
    }

    private void fixRecordMediasVideo() {
        if (C7277f1.m26364f(this.mVideoPath)) {
            this.mLocalVideoList.add(this.fromRecordMedia);
            this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
            this.mVideoStateList.add(new UploadStateInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCacheBean, reason: merged with bridge method [inline-methods] */
    public void m25313a() {
        List<SocialAccBean> list;
        REPORT_UP_ID = C7325u1.m26625b(C7325u1.f25702v);
        ReportPersonBean reportPersonBean = (ReportPersonBean) C7325u1.m26615a(C7325u1.f25665c0, ReportPersonBean.class);
        if (reportPersonBean != null) {
            this.mEtCaseDescribe.setText(reportPersonBean.getCaseDis());
            this.mRegion.setText(reportPersonBean.getReportAdd());
            this.mTvDuperyType.setText(reportPersonBean.getDupery());
            this.mDefraudCode = reportPersonBean.getDefraudType();
            setRegionId(reportPersonBean.getReportDic());
        }
        List<CallBean> m26626b = C7325u1.m26626b(C7325u1.f25667d0, CallBean.class);
        List<SmsBean> m26626b2 = C7325u1.m26626b(C7325u1.f25669e0, SmsBean.class);
        List<AppBean> m26626b3 = C7325u1.m26626b(C7325u1.f25671f0, AppBean.class);
        List<CasePicBean> m26626b4 = C7325u1.m26626b(C7325u1.f25675h0, CasePicBean.class);
        List<LocalMedia> m26626b5 = C7325u1.m26626b(C7325u1.f25681k0, LocalMedia.class);
        List<LocalMedia> m26626b6 = C7325u1.m26626b(C7325u1.f25685m0, LocalMedia.class);
        List<String> m26626b7 = C7325u1.m26626b(C7325u1.f25689o0, String.class);
        List<SocialAccBean> m26626b8 = C7325u1.m26626b(C7325u1.f25691p0, SocialAccBean.class);
        List<SocialAccBean> m26626b9 = C7325u1.m26626b(C7325u1.f25693q0, SocialAccBean.class);
        List<UploadStateInfo> m26626b10 = C7325u1.m26626b(C7325u1.f25683l0, UploadStateInfo.class);
        List<UploadStateInfo> m26626b11 = C7325u1.m26626b(C7325u1.f25673g0, UploadStateInfo.class);
        List<UploadStateInfo> m26626b12 = C7325u1.m26626b(C7325u1.f25679j0, UploadStateInfo.class);
        List<UploadStateInfo> m26626b13 = C7325u1.m26626b(C7325u1.f25687n0, UploadStateInfo.class);
        if (m26626b == null || m26626b.size() <= 0) {
            list = m26626b9;
            CallBean callBean = this.intentCallBean;
            if (callBean != null) {
                this.mCallList.add(callBean);
                this.mCallNum.setText(this.mCallList.size() + "个");
            }
        } else {
            this.mCallList = m26626b;
            CallBean callBean2 = this.intentCallBean;
            if (callBean2 != null) {
                this.mCallList.add(callBean2);
            }
            TextView textView = this.mCallNum;
            StringBuilder sb = new StringBuilder();
            list = m26626b9;
            sb.append(this.mCallList.size());
            sb.append("个");
            textView.setText(sb.toString());
        }
        if (m26626b2 == null || m26626b2.size() <= 0) {
            SmsBean smsBean = this.intentSMSBean;
            if (smsBean != null) {
                this.mSmsList.add(smsBean);
                this.mSMSNum.setText(this.mSmsList.size() + "条");
            }
        } else {
            this.mSmsList = m26626b2;
            SmsBean smsBean2 = this.intentSMSBean;
            if (smsBean2 != null) {
                this.mSmsList.add(smsBean2);
            }
            this.mSMSNum.setText(this.mSmsList.size() + "条");
        }
        if (m26626b5 == null || m26626b5.size() <= 0) {
            fixRecordMediasAudio();
            if (this.mLocalAudioList.size() > 0) {
                this.mAudioNum.setText(this.mLocalAudioList.size() + "个");
            }
        } else {
            this.mLocalAudioList = m26626b5;
            this.mAudioStateList = m26626b10;
            fixRecordMediasAudio();
            this.mAudioNum.setText(this.mLocalAudioList.size() + "个");
        }
        if (m26626b6 == null || m26626b6.size() <= 0) {
            fixRecordMediasVideo();
            if (this.mLocalVideoList.size() > 0) {
                this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
            }
        } else {
            this.mLocalVideoList = m26626b6;
            this.mVideoStateList = m26626b13;
            fixRecordMediasVideo();
            this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
        }
        if (m26626b3 == null || m26626b3.size() <= 0) {
            ArrayList<AppInfoBean> arrayList = this.intentApps;
            if (arrayList == null || arrayList.size() <= 0) {
                C6049c.m24987f().m25000d(new C7265a(1, null));
            } else {
                fixApps();
                this.mLlApp.setAppSData(this.mApps);
                this.mAppNum.setText(this.mApps.size() + "个");
            }
        } else {
            this.mAppList.clear();
            this.mApps = m26626b3;
            this.mAppStateList = m26626b11;
            fixApps();
            this.mLlApp.setAppSData(this.mApps);
            this.mAppNum.setText(this.mApps.size() + "个");
        }
        if (m26626b4 != null && m26626b4.size() > 0) {
            this.mPictureList.clear();
            this.mCasePic = m26626b4;
            this.mPictureStateList = m26626b12;
            this.mPicNum.setText(this.mCasePic.size() + "个");
            for (int i2 = 0; i2 < this.mCasePic.size(); i2++) {
                LocalMedia localMedia = new LocalMedia();
                localMedia.setPath(this.mCasePic.get(i2).getPath());
                this.mPictureList.add(localMedia);
            }
            this.mLlPic.setPicListData(this.mPictureList);
        }
        if (m26626b7 != null && m26626b7.size() > 0) {
            this.mWebUrlList = m26626b7;
            this.mUrlNum.setText(this.mWebUrlList.size() + "个");
        }
        if (m26626b8 != null && m26626b8.size() > 0) {
            this.mSocialAccs = m26626b8;
            this.mSocialNum.setText(this.mSocialAccs.size() + "个");
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mTradlAccs = list;
        this.mTradNum.setText(this.mTradlAccs.size() + "个");
    }

    private void getRecordInfo() {
        this.mVideoPath = getIntent().getStringExtra("video_path");
        if (this.mVideoPath != null) {
            this.fromRecordMedia = new LocalMedia();
            this.fromRecordMedia.setPath(this.mVideoPath);
        }
    }

    private boolean hasData() {
        return this.mTvDuperyType.getText().toString().length() > 0 || this.mRegion.getText().toString().length() > 0 || this.mEtCaseDescribe.getText().toString().length() > 0 || this.mCallList.size() > 0 || this.mSmsList.size() > 0 || this.mApps.size() > 0 || this.mAppList.size() > 0 || this.mCasePic.size() > 0 || this.mPictureList.size() > 0 || this.mLocalVideoList.size() > 0 || this.mLocalAudioList.size() > 0 || this.mWebUrlList.size() > 0 || this.mSocialAccs.size() > 0 || this.mTradlAccs.size() > 0;
    }

    private boolean hasReportData() {
        return this.mCallList.size() > 0 || this.mSmsList.size() > 0 || this.mWebUrlList.size() > 0 || this.mSocialAccs.size() > 0 || this.mTradlAccs.size() > 0;
    }

    private int hasUpFileId() {
        if (this.mApps.size() <= 0 && this.mAppList.size() <= 0 && this.mCasePic.size() <= 0 && this.mPictureList.size() <= 0 && this.mLocalAudioList.size() <= 0 && this.mLocalVideoList.size() <= 0) {
            return 0;
        }
        if (!TextUtils.isEmpty(REPORT_UP_ID)) {
            return upFileFail();
        }
        upFileFail();
        return 1;
    }

    private void initScanData(Intent intent) {
        this.intentCallBean = (CallBean) intent.getSerializableExtra("intecepte_phone_number");
        this.intentSMSBean = (SmsBean) intent.getSerializableExtra(C7292k1.f25436u);
        this.intentApps = getIntent().getParcelableArrayListExtra(C7292k1.f25434t);
        ArrayList<AppInfoBean> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(C7292k1.f25442x);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
            return;
        }
        this.intentApps = parcelableArrayListExtra;
        this.isFromVirusCheck = true;
    }

    private void initView() {
        C7257b1.m26172a(this, 3, "110", getString(C2113R.string.report_time_tips), "", "我知道了", (IOneClickListener) null);
        this.mTvTitle.setText(C2113R.string.one_key_report);
        this.mNumTip.setText(Html.fromHtml("今日剩余可举报次数<font color=#2B4CFF>" + REPORTNUM + "</font>次"));
        this.mPresenter = new ReportPresenter(this, this);
        if (isNeedSaveOrClear()) {
            this.mMyScrollView.post(new RunnableC6501a());
        } else {
            showProgressDialog("加载中...", true);
            C7337y1.f25731b.post(new Runnable() { // from class: ui.activity.x0
                @Override // java.lang.Runnable
                public final void run() {
                    ReportNewActivity.this.m25313a();
                }
            });
        }
    }

    private boolean isNeedSaveOrClear() {
        return TradAccountActivity.f23279c;
    }

    private boolean reportDisct() {
        return this.mTvDuperyType.getText().toString().length() > 0 || this.mRegion.getText().toString().length() > 0 || this.mEtCaseDescribe.getText().toString().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCacheData() {
        C7325u1.m26630b(C7325u1.f25702v, REPORT_UP_ID);
        C7325u1.m26619a(buildDiscCache(), C7325u1.f25665c0);
        C7325u1.m26622a((List) this.mCallList, C7325u1.f25667d0);
        C7325u1.m26622a((List) this.mSmsList, C7325u1.f25669e0);
        C7325u1.m26622a((List) this.mLocalAudioList, C7325u1.f25681k0);
        C7325u1.m26622a((List) this.mLocalVideoList, C7325u1.f25685m0);
        C7325u1.m26622a((List) this.mWebUrlList, C7325u1.f25689o0);
        C7325u1.m26622a((List) this.mSocialAccs, C7325u1.f25691p0);
        C7325u1.m26622a((List) this.mTradlAccs, C7325u1.f25693q0);
        C7325u1.m26622a((List) this.mAudioStateList, C7325u1.f25683l0);
        C7325u1.m26622a((List) this.mAppStateList, C7325u1.f25673g0);
        C7325u1.m26622a((List) this.mPictureStateList, C7325u1.f25679j0);
        C7325u1.m26622a((List) this.mVideoStateList, C7325u1.f25687n0);
        this.mCasePic.clear();
        this.mApps.clear();
        for (int i2 = 0; i2 < this.mPictureList.size(); i2++) {
            CasePicBean casePicBean = new CasePicBean();
            casePicBean.setPath(this.mPictureList.get(i2).getPath());
            this.mCasePic.add(casePicBean);
        }
        for (int i3 = 0; i3 < this.mAppList.size(); i3++) {
            C5844c.m24592a(C5844c.m24588a(this.mAppList.get(i3).getAppIcon()), this.mAppList.get(i3).getName(), this.mAppList.get(i3).getVersionName(), C5844c.f21112a);
            this.mApps.add(AppBean.AppInfoBean2AppBean(this.mAppList.get(i3)));
        }
        C7325u1.m26622a((List) this.mApps, C7325u1.f25671f0);
        C7325u1.m26622a((List) this.mCasePic, C7325u1.f25675h0);
    }

    private void saveDataCache() {
        if (!hasData()) {
            cleanCacheData();
            finish();
        } else if (!isNeedSaveOrClear()) {
            C7257b1.m26184a((Activity) this, "将此次编辑保留", "", "不保留", "保留", C2113R.color._353536, -1, true, (IClickListener) new C6503c());
        } else {
            cleanList();
            finish();
        }
    }

    private int upFileFail() {
        this.mFlAppBg.setBackgroundResource(C2113R.drawable.white_corner);
        this.mFlPicBg.setBackgroundResource(C2113R.drawable.white_corner);
        this.mFlAudioBg.setBackgroundResource(C2113R.drawable.white_corner);
        this.mFlVideoBg.setBackgroundResource(C2113R.drawable.white_corner);
        if (this.mAppStateList.size() > 0) {
            Iterator<UploadStateInfo> it = this.mAppStateList.iterator();
            while (it.hasNext()) {
                if (it.next().getUploadState() != 2) {
                    this.mFlAppBg.setBackgroundResource(C2113R.drawable.red_corner);
                    return 3;
                }
            }
        }
        if (this.mPictureStateList.size() > 0) {
            Iterator<UploadStateInfo> it2 = this.mPictureStateList.iterator();
            while (it2.hasNext()) {
                if (it2.next().getUploadState() != 2) {
                    this.mFlPicBg.setBackgroundResource(C2113R.drawable.red_corner);
                    return 4;
                }
            }
        }
        if (this.mAudioStateList.size() > 0) {
            Iterator<UploadStateInfo> it3 = this.mAudioStateList.iterator();
            while (it3.hasNext()) {
                if (it3.next().getUploadState() != 2) {
                    this.mFlAudioBg.setBackgroundResource(C2113R.drawable.red_corner);
                    return 5;
                }
            }
        }
        if (this.mVideoStateList.size() > 0) {
            Iterator<UploadStateInfo> it4 = this.mVideoStateList.iterator();
            while (it4.hasNext()) {
                if (it4.next().getUploadState() != 2) {
                    this.mFlVideoBg.setBackgroundResource(C2113R.drawable.red_corner);
                    return 6;
                }
            }
        }
        return 2;
    }

    public void doKeyBack() {
        saveDataCache();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17165l);
        C6049c.m24987f().m25001e(this);
        initScanData(getIntent());
        getRecordInfo();
        initView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (Jzvd.m2437C()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 16) {
                this.mSocialAccs.clear();
                this.mSocialNum.setText("请填写");
                ArrayList arrayList = (ArrayList) c7265a.m26300b();
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                this.mSocialAccs = arrayList;
                this.mSocialNum.setText(this.mSocialAccs.size() + "个");
            }
            if (m26297a == 19) {
                this.mTradlAccs.clear();
                this.mTradNum.setText("请填写");
                ArrayList arrayList2 = (ArrayList) c7265a.m26300b();
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    return;
                }
                this.mTradlAccs = arrayList2;
                this.mTradNum.setText(this.mTradlAccs.size() + "个");
                return;
            }
            switch (m26297a) {
                case 1:
                    hideProgressDialog();
                    List<AppInfoBean> list = (List) c7265a.m26300b();
                    if (list != null) {
                        this.mAppList = list;
                        break;
                    }
                    break;
                case 2:
                    this.mEtCaseDescribe.setText((String) c7265a.m26300b());
                    break;
                case 3:
                    this.info = (ReportZPEleBean) c7265a.m26300b();
                    ReportZPEleBean reportZPEleBean = this.info;
                    if (reportZPEleBean != null) {
                        this.mTvDuperyType.setText(reportZPEleBean.getName());
                        this.mDefraudCode = this.info.getCode();
                        break;
                    }
                    break;
                case 4:
                    this.mLocalAudioList.clear();
                    this.mAudioStateList.clear();
                    this.mAudioNum.setText("请选择");
                    List<LocalMedia> list2 = (List) c7265a.m26300b();
                    if (list2 != null && list2.size() > 0) {
                        this.mAudioNum.setText(list2.size() + "个");
                        this.mLocalAudioList = list2;
                    }
                    List<UploadStateInfo> list3 = (List) c7265a.m26304d();
                    if (list3 != null && list3.size() > 0) {
                        this.mAudioStateList = list3;
                    }
                    upFileFail();
                    break;
                case 5:
                    this.mApps.clear();
                    this.mAppList.clear();
                    this.mAppStateList.clear();
                    this.mAppNum.setText("请选择");
                    this.mLlApp.setAppListData(this.mAppList);
                    List<AppInfoBean> list4 = (List) c7265a.m26300b();
                    if (list4 != null && list4.size() > 0) {
                        this.mAppList = list4;
                        this.mAppNum.setText(this.mAppList.size() + "个");
                        this.mLlApp.setAppListData(this.mAppList);
                    }
                    List<UploadStateInfo> list5 = (List) c7265a.m26304d();
                    if (list5 != null && list5.size() > 0) {
                        this.mAppStateList = list5;
                    }
                    upFileFail();
                    break;
                case 6:
                    this.mCasePic.clear();
                    this.mPictureList.clear();
                    this.mPictureStateList.clear();
                    this.mPicNum.setText("请选择");
                    this.mLlPic.setPicListData(this.mPictureList);
                    List<LocalMedia> list6 = (List) c7265a.m26300b();
                    if (list6 != null && list6.size() > 0) {
                        this.mPictureList = list6;
                        this.mPicNum.setText(this.mPictureList.size() + "个");
                        this.mLlPic.setPicListData(this.mPictureList);
                    }
                    List<UploadStateInfo> list7 = (List) c7265a.m26304d();
                    if (list7 != null && list7.size() > 0) {
                        this.mPictureStateList = list7;
                    }
                    upFileFail();
                    break;
                case 7:
                    this.mLocalVideoList.clear();
                    this.mVideoStateList.clear();
                    this.mVideoNum.setText("请选择");
                    List<LocalMedia> list8 = (List) c7265a.m26300b();
                    if (list8 != null && list8.size() > 0) {
                        this.mLocalVideoList = list8;
                        this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
                    }
                    List<UploadStateInfo> list9 = (List) c7265a.m26304d();
                    if (list9 != null && list9.size() > 0) {
                        this.mVideoStateList = list9;
                    }
                    upFileFail();
                    break;
                case 8:
                    this.mWebUrlList.clear();
                    this.mUrlNum.setText("请填写");
                    ArrayList arrayList3 = (ArrayList) c7265a.m26300b();
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        this.mWebUrlList = arrayList3;
                        this.mUrlNum.setText(this.mWebUrlList.size() + "个");
                        break;
                    }
                    break;
                case 9:
                    this.mCallList.clear();
                    this.mCallNum.setText("请选择");
                    ArrayList arrayList4 = (ArrayList) c7265a.m26300b();
                    if (arrayList4 != null && arrayList4.size() > 0) {
                        this.mCallList = arrayList4;
                        this.mCallNum.setText(arrayList4.size() + "个");
                        break;
                    }
                    break;
                case 10:
                    this.mSmsList.clear();
                    this.mSMSNum.setText("请选择");
                    ArrayList arrayList5 = (ArrayList) c7265a.m26300b();
                    if (arrayList5 != null && arrayList5.size() > 0) {
                        this.mSmsList = arrayList5;
                        this.mSMSNum.setText(this.mSmsList.size() + "个");
                        break;
                    }
                    break;
            }
        }
    }

    @InterfaceC6059m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventWornThread(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 11) {
                C6049c.m24987f().m25002f(c7265a);
                SmsBean smsBean = (SmsBean) c7265a.m26300b();
                if (smsBean != null) {
                    this.mSmsList.add(smsBean);
                    this.mSMSNum.setText(this.mSmsList.size() + "个");
                    return;
                }
                return;
            }
            if (m26297a != 12) {
                return;
            }
            C6049c.m24987f().m25002f(c7265a);
            List list = (List) c7265a.m26300b();
            if (list != null && list.size() > 0) {
                this.mAppList.addAll(list);
                try {
                    this.mAppNum.setText(this.mAppList.size() + "个");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    C7301n1.m26456b(e2.getMessage());
                }
                this.mLlApp.setAppListData(this.mAppList);
            }
            List list2 = (List) c7265a.m26304d();
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            this.mAppStateList.addAll(list2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        doKeyBack();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17165l);
        this.isFromVirusCheck = false;
        setIntent(intent);
        initScanData(getIntent());
        getRecordInfo();
        initView();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Jzvd.m2440F();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Hicore.fromPageReport = true;
    }

    @Override // p388ui.callview.ReportCallView
    public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
        hideProgressDialog();
        if (this.isFromVirusCheck) {
            ArrayList arrayList = new ArrayList();
            List<AppInfoBean> list = this.mAppList;
            if (list != null && list.size() > 0) {
                for (AppInfoBean appInfoBean : this.mAppList) {
                    if (appInfoBean.getSource() == 1) {
                        arrayList.add(appInfoBean);
                    }
                }
            }
            C6049c.m24987f().m25000d(new C7265a(26, arrayList));
        }
        if (isNeedSaveOrClear()) {
            cleanList();
        } else {
            cleanCacheData();
        }
        TextView textView = this.mNumTip;
        StringBuilder sb = new StringBuilder();
        sb.append("今日剩余可举报次数<font color=#2B4CFF>");
        int i2 = REPORTNUM - 1;
        REPORTNUM = i2;
        sb.append(i2);
        sb.append("</font>次");
        textView.setText(Html.fromHtml(sb.toString()));
        this.dialogRP = C7257b1.m26167a(REPORTNUM, this.mActivity, "举报成功", "感谢您的举报，我们将尽快处理", "继续举报", "查看举报", new C6504d(rowsBean));
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit, C2113R.id.tv_upload_video, C2113R.id.tv_upload_call, C2113R.id.tv_upload_audio, C2113R.id.tv_upload_sms, C2113R.id.tv_upload_app, C2113R.id.tv_upload_picture, C2113R.id.region, C2113R.id.et_case_describe, C2113R.id.tv_record_help, C2113R.id.tv_upload_url, C2113R.id.ll_dupery_type, C2113R.id.tv_social, C2113R.id.tv_trad})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    if (hasUpFileId() == 0 && !hasReportData()) {
                        C7257b1.m26210b(this.mActivity, "请至少填写一项举报信息", "知道了", null);
                        break;
                    } else if (hasUpFileId() != 1 && hasUpFileId() != 3 && hasUpFileId() != 4 && hasUpFileId() != 5 && hasUpFileId() != 6) {
                        if (this.mDefraudCode != -1 && !TextUtils.isEmpty(this.mTvDuperyType.getText())) {
                            checkPermission();
                            break;
                        } else {
                            C7331w1.m26688a("请选择诈骗类型");
                            break;
                        }
                    } else {
                        C7331w1.m26688a("请先上传文件");
                        break;
                    }
                }
                break;
            case C2113R.id.et_case_describe /* 2131296552 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) EvidenceDiscActivity.class);
                intent.putExtra("disc", this.mEtCaseDescribe.getText().toString());
                intent.putExtra("title", "举报描述");
                startActivity(intent);
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                saveDataCache();
                break;
            case C2113R.id.ll_dupery_type /* 2131296944 */:
                Intent intent2 = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                ReportZPEleBean reportZPEleBean = this.info;
                if (reportZPEleBean != null) {
                    intent2.putExtra(C7292k1.f25361O, reportZPEleBean);
                }
                startActivity(intent2);
                break;
            case C2113R.id.region /* 2131297159 */:
                regionShow(this.mRegion, this.mActivity);
                break;
            case C2113R.id.tv_record_help /* 2131297677 */:
                startActivity(new Intent(this.mActivity, (Class<?>) RecordHelpActivity.class));
                break;
            case C2113R.id.tv_social /* 2131297716 */:
                Intent intent3 = new Intent(this, (Class<?>) SocialAccountActivity.class);
                intent3.putExtra(C7292k1.f25424o, (Serializable) this.mSocialAccs);
                startActivity(intent3);
                break;
            case C2113R.id.tv_trad /* 2131297766 */:
                Intent intent4 = new Intent(this, (Class<?>) TradAccountActivity.class);
                intent4.putExtra(C7292k1.f25430r, (Serializable) this.mTradlAccs);
                startActivity(intent4);
                break;
            case C2113R.id.tv_upload_app /* 2131297786 */:
                startActivity(new Intent(this, (Class<?>) AppActivity.class));
                List<AppInfoBean> list = this.mAppList;
                if (list != null && list.size() > 0) {
                    C6049c.m24987f().m25000d(new C7265a(50, this.mAppList, this.mAppStateList));
                    break;
                }
                break;
            case C2113R.id.tv_upload_audio /* 2131297787 */:
                startActivity(new Intent(this, (Class<?>) AudioActivity.class));
                List<LocalMedia> list2 = this.mLocalAudioList;
                if (list2 != null && list2.size() > 0) {
                    C6049c.m24987f().m25000d(new C7265a(40, this.mLocalAudioList, this.mAudioStateList));
                    break;
                }
                break;
            case C2113R.id.tv_upload_call /* 2131297788 */:
                Intent intent5 = new Intent(this, (Class<?>) CallNewActivity.class);
                List<CallBean> list3 = this.mCallList;
                if (list3 != null && list3.size() > 0) {
                    intent5.putExtra(C7292k1.f25432s, (Serializable) this.mCallList);
                }
                startActivity(intent5);
                break;
            case C2113R.id.tv_upload_picture /* 2131297789 */:
                startActivity(new Intent(this, (Class<?>) PictureActivity.class));
                List<LocalMedia> list4 = this.mPictureList;
                if (list4 != null && list4.size() > 0) {
                    C6049c.m24987f().m25000d(new C7265a(60, this.mPictureList, this.mPictureStateList));
                    break;
                }
                break;
            case C2113R.id.tv_upload_sms /* 2131297790 */:
                Intent intent6 = new Intent(this, (Class<?>) SmsActivity.class);
                List<SmsBean> list5 = this.mSmsList;
                if (list5 != null && list5.size() > 0) {
                    intent6.putExtra(C7292k1.f25436u, (Serializable) this.mSmsList);
                }
                startActivity(intent6);
                break;
            case C2113R.id.tv_upload_url /* 2131297792 */:
                Intent intent7 = new Intent(this, (Class<?>) WebsiteActivity.class);
                intent7.putStringArrayListExtra(C7292k1.f25422n, (ArrayList) this.mWebUrlList);
                startActivity(intent7);
                break;
            case C2113R.id.tv_upload_video /* 2131297793 */:
                startActivity(new Intent(this, (Class<?>) VideoActivity.class));
                List<LocalMedia> list6 = this.mLocalVideoList;
                if (list6 != null && list6.size() > 0) {
                    C6049c.m24987f().m25000d(new C7265a(70, this.mLocalVideoList, this.mVideoStateList));
                    break;
                }
                break;
        }
    }

    @Override // p388ui.callview.ReportCallView
    public void onfailRequest() {
        C7257b1.m26186a((Activity) this, false, 1, "提交失败请重新提交", C2113R.drawable.iv_comit_fail);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_new;
    }
}
