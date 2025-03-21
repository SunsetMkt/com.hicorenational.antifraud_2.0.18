package p388ui.activity;

import adapter.RiskAppUploadAdapter;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import bean.ReportPersonBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import org.greenrobot.eventbus.C6049c;
import p357j.C5845d;
import p388ui.Hicore;
import p388ui.presenter.AppUploadPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7301n1;
import util.C7328v1;
import util.C7333x0;
import util.C7340z1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class AppUploadActivity extends BaseUploadActivity implements BaseQuickAdapter.InterfaceC1895i {
    private RiskAppUploadAdapter mAdapter;
    private AppUploadPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private List<AppInfoBean> mAppBeans = new ArrayList();
    private String description = "";
    private boolean isUploading = false;

    /* renamed from: ui.activity.AppUploadActivity$a */
    class C6128a implements IVerifyListener {
        C6128a() {
        }

        @Override // interfaces.IVerifyListener
        public void onSuccessVerify() {
            AppUploadActivity.this.isUploading = true;
            AppUploadActivity.this.upload();
        }
    }

    /* renamed from: ui.activity.AppUploadActivity$b */
    class C6129b implements IClickListener {
        C6129b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (AppUploadActivity.this.isHasUpload()) {
                AppUploadActivity.this.stopUpload();
            }
            AppUploadActivity.this.cleanList();
            AppUploadActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* renamed from: ui.activity.AppUploadActivity$c */
    class C6130c implements PermissionsListener {
        C6130c() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            AppUploadActivity.this.mPresenter.reportSubmit(AppUploadActivity.this.mPresenter.getAppFileIDs(AppUploadActivity.this.mUploadStateList), AppUploadActivity.this.buildDiscCache());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReportPersonBean buildDiscCache() {
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic("");
        reportPersonBean.setReportAdd("");
        reportPersonBean.setDupery("其他诈骗");
        reportPersonBean.setDefraudType(22);
        reportPersonBean.setCaseDis(this.description);
        return reportPersonBean;
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25531j}, new C6130c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanList() {
        ReportNewActivity.REPORT_UP_ID = "";
        this.mUploadStateList = null;
        this.mAppBeans = null;
    }

    private ReportAppInfo createReport(AppInfoBean appInfoBean) {
        int i2;
        ReportAppInfo reportAppInfo = new ReportAppInfo();
        String pkgPath = appInfoBean.getPkgPath();
        reportAppInfo.setOccurTime(C7328v1.m26646a(this.mAppBeans.get(this.mCurrentUploadIndex).getLastTime()));
        reportAppInfo.setSource(getChildSource());
        reportAppInfo.setFileLocalPath(pkgPath);
        reportAppInfo.setAppName(appInfoBean.getName());
        reportAppInfo.setAppPackage(appInfoBean.getPkgName());
        reportAppInfo.setAppVersion(appInfoBean.getVersionName());
        reportAppInfo.setAppVirus(appInfoBean.getVirusName());
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            reportAppInfo.setFileMd5(this.mUploadStateList.get(i2).getFileMd5());
            reportAppInfo.setFilePath(this.mUploadStateList.get(this.mCurrentUploadIndex).getFilePath());
        }
        return reportAppInfo;
    }

    private void initRecycleriew() {
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new RiskAppUploadAdapter(C2113R.layout.recyclerview_app_upload_risk, this.mAppBeans, this.mUploadStateList);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
    }

    private String logoBase64(Drawable drawable) {
        try {
            Bitmap m24601a = C5845d.m24601a(drawable);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m24601a.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return C7333x0.m26700a(byteArrayOutputStream);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upload() {
        List<AppInfoBean> list;
        if (LoginManager.getInstance().isLogOut() || (list = this.mAppBeans) == null || list.size() <= 0) {
            return;
        }
        commitDeal();
    }

    private void warnUpload() {
        C7340z1.m26805a(this.mActivity).m26811a(8, new C6128a());
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (TextUtils.equals("确定", str)) {
            checkPermission();
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void createCaseInfo() {
        C7301n1.m26453a("AppUploadActivity-->>createCaseInfo");
        if (this.info == null) {
            this.info = new ReportCaseInfo();
            this.info.setCaseCategory(22);
            this.info.setCaseCategoryText("其他诈骗");
            this.info.setRegion("");
            this.info.setCaseDescription(this.description);
            setUpId();
            this.info.setCommonParams();
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void doUpload() {
        this.mPresenter.doAudioUpload(createReport(this.mAppBeans.get(this.mCurrentUploadIndex)), this.info);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public String getChildPath() {
        return this.mAppBeans.get(this.mCurrentUploadIndex).getPkgPath();
    }

    @Override // p388ui.activity.BaseUploadActivity
    public int getChildSource() {
        return 1;
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("一键举报");
        this.mPresenter = new AppUploadPresenter(this, this);
        initRecycleriew();
        Hicore.fromPageReport = true;
        if (TextUtils.equals(C7292k1.f25333A, getIntent().getStringExtra(C7292k1.f25444y))) {
            this.description = "APP安装预警一键举报";
        } else {
            this.description = "防诈检测一键举报";
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void networkFail() {
        if (isHasFail()) {
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        nextUploadIndex();
        int i2 = this.mCurrentUploadIndex;
        if (i2 != -1) {
            this.mUploadStateList.get(i2).setUploadState(3);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isAllSuccess()) {
            super.onBackPressed();
        } else {
            C7257b1.m26184a(this.mActivity, "是否停止文件上传并取消我要举报？", "", "是", "否", -1, -1, true, (IClickListener) new C6129b());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == C2113R.id.iv_checkbox && this.mUploadStateList.get(i2).getUploadState() == 3 && !isHasUpload()) {
            this.mUploadStateList.get(i2).setUploadState(0);
            upload();
        }
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        List<AppInfoBean> list;
        super.onResume();
        if (this.isUploading || (list = this.mAppBeans) == null || list.size() <= 0) {
            return;
        }
        warnUpload();
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.callview.AudioCallView
    public void onSuccessRequest(APIresult aPIresult) {
        hideProgressDialog();
        C6049c.m24987f().m25000d(new C7265a(26, this.mAppBeans));
        cleanList();
        this.isUploading = false;
        C7257b1.m26186a((Activity) this, true, 1, "提交成功", C2113R.drawable.iv_comit_succ);
    }

    @OnClick({C2113R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.callview.AudioCallView
    public void onfailRequest() {
        C7257b1.m26186a((Activity) this, false, 1, "提交失败请重新提交", C2113R.drawable.iv_comit_fail);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void redisplayData(C7265a c7265a) {
        List list = (List) c7265a.m26300b();
        if (list != null && list.size() > 0) {
            this.mAppBeans.addAll(list);
        }
        for (AppInfoBean appInfoBean : this.mAppBeans) {
            this.mUploadStateList.add(new UploadStateInfo());
        }
        RiskAppUploadAdapter riskAppUploadAdapter = this.mAdapter;
        if (riskAppUploadAdapter != null) {
            riskAppUploadAdapter.notifyDataSetChanged();
        }
        List<AppInfoBean> list2 = this.mAppBeans;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        warnUpload();
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void removeLocalData(int i2) {
        this.mAppBeans.remove(i2);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void sendData() {
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_app_upload;
    }
}
