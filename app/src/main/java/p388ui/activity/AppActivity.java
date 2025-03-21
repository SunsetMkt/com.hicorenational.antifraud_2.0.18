package p388ui.activity;

import adapter.AppDeleteAdapter;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import event.AppEventBean;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.LoginManager;
import network.ReportAppInfo;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.presenter.AppPresenter;
import util.C7301n1;
import util.C7328v1;
import util.C7331w1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class AppActivity extends BaseUploadActivity implements BaseQuickAdapter.InterfaceC1895i {
    private AppDeleteAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;
    private AppPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(C2113R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private List<AppInfoBean> mAppBeans = new ArrayList();
    private int mMaxSelectNum = 2;
    private String mEndStr = "个APP应用程序";

    /* renamed from: ui.activity.AppActivity$a */
    class C6120a implements PermissionsListener {
        C6120a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(AppActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = AppActivity.this.mAppBeans.size();
            Intent intent = new Intent(AppActivity.this, (Class<?>) AppSelectedActivity.class);
            intent.putExtra(AppSelectedActivity.f21819h, 2);
            intent.putExtra(AppSelectedActivity.f21821j, size);
            intent.putExtra("extra_select_limite", AppActivity.this.mMaxSelectNum);
            AppActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6120a());
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
            reportAppInfo.setFilePath(this.mUploadStateList.get(i2).getFilePath());
        }
        reportAppInfo.setFileMd5(appInfoBean.getAppMD5());
        return reportAppInfo;
    }

    private void deleteDoubleElement(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        if (this.mAppBeans == null) {
            this.mAppBeans = new ArrayList();
        }
        if (list == null || (list.size() <= 0 && appInfoBean != null)) {
            list = new ArrayList<>();
            list.add(appInfoBean);
        }
        Iterator<AppInfoBean> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            AppInfoBean next = it.next();
            List<AppInfoBean> list2 = this.mAppBeans;
            if (list2 != null) {
                if (list2.size() > 0) {
                    for (AppInfoBean appInfoBean2 : this.mAppBeans) {
                        if (next.getPkgName().equals(appInfoBean2.getPkgName()) && next.getPkgPath().equals(appInfoBean2.getPkgPath())) {
                            String activityName = next.getActivityName();
                            if (TextUtils.isEmpty(activityName) || activityName.equals(appInfoBean2.getActivityName())) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (!z) {
                        next.setAddNew(true);
                        this.mAppBeans.add(next);
                    }
                } else {
                    next.setAddNew(true);
                    this.mAppBeans.add(next);
                }
            }
        }
        for (int i2 = 0; i2 < this.mAppBeans.size(); i2++) {
            AppInfoBean appInfoBean3 = this.mAppBeans.get(i2);
            if (appInfoBean3.isAddNew()) {
                appInfoBean3.setAddNew(false);
                this.mUploadStateList.add(i2, new UploadStateInfo());
            }
        }
    }

    private void scanVirus() {
        int i2;
        AppInfoBean appInfoBean = this.mAppBeans.get(this.mCurrentUploadIndex);
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            appInfoBean.setAppMD5(this.mUploadStateList.get(i2).getFileMd5());
        }
        C7301n1.m26453a("mCurrentUploadIndex-->-1 文件上传请求   1" + this.mCurrentUploadIndex);
        int i3 = this.mCurrentUploadIndex;
        if (i3 <= -1 || appInfoBean != this.mAppBeans.get(i3)) {
            return;
        }
        C7301n1.m26453a("mCurrentUploadIndex-->-1 文件上传请求   2" + this.mCurrentUploadIndex);
        this.mPresenter.doAudioUpload(createReport(appInfoBean), this.info);
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
        scanVirus();
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
        this.mTvTitle.setText("添加APP应用程序");
        this.mTvSelectTip.setText("添加");
        this.mTvCommitTip.setText(getResources().getString(C2113R.string.commit_tip_start_str) + this.mMaxSelectNum + this.mEndStr);
        this.mPresenter = new AppPresenter(this);
        this.mPresenter.attachView(this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new AppDeleteAdapter(C2113R.layout.recyclerview_app_record_select, this.mAppBeans, this.mUploadStateList);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (backPressedUpload()) {
            return;
        }
        super.onBackPressed();
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEvent(AppEventBean appEventBean) {
        C6049c.m24987f().m25002f(appEventBean);
        deleteDoubleElement(appEventBean.getAppBeans(), null);
        if (this.mUploadStateList.size() <= 0) {
            for (int i2 = 0; i2 < this.mAppBeans.size(); i2++) {
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != C2113R.id.iv_clear) {
            return;
        }
        deleteDialog(i2);
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
            List<AppInfoBean> list = this.mAppBeans;
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
            List<AppInfoBean> list2 = this.mAppBeans;
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
            this.mAppBeans.addAll(list);
        }
        List<UploadStateInfo> list2 = (List) c7265a.m26304d();
        if (list2 != null && list2.size() > 0) {
            for (UploadStateInfo uploadStateInfo : list2) {
                if (uploadStateInfo.getUploadState() == 1) {
                    uploadStateInfo.setUploadState(3);
                }
            }
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
        this.mAppBeans.remove(i2);
    }

    @Override // p388ui.activity.BaseUploadActivity
    public void sendData() {
        C6049c.m24987f().m25000d(new C7265a(5, this.mAppBeans, this.mUploadStateList));
    }

    @Override // p388ui.activity.BaseUploadActivity, p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_audio;
    }
}
