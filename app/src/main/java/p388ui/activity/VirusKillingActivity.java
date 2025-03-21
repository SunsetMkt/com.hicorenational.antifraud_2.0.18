package p388ui.activity;

import adapter.RiskAppSelectAdapter;
import adapter.ScanAppAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppBean;
import bean.AppInfoBean;
import bean.AppVirusBean;
import bean.ScanResultInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.p137r.C1829h;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p247e.C4447d;
import p357j.C5844c;
import p357j.C5845d;
import p388ui.Hicore;
import p388ui.callview.VirusKillingCallView;
import p388ui.p390e.C6823b;
import p388ui.p390e.InterfaceC6824c;
import p388ui.presenter.BasePagePresenter;
import p388ui.presenter.VirusKillingPresenter;
import p388ui.presenter.WelocmPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.SwitchButton;
import util.C7257b1;
import util.C7301n1;
import util.C7316r1;
import util.C7325u1;
import util.C7328v1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class VirusKillingActivity extends BaseActivity implements VirusKillingCallView, BaseQuickAdapter.InterfaceC1895i {
    public static final int LIMITE_APK = 9;
    private static final int SCAN_STATE_FINISH = 3;
    private static final int SCAN_STATE_FINISH_RISK = 4;
    public static final int SCAN_STATE_LOADING = -1;
    public static final int SCAN_STATE_RISK = 2;
    public static final int SCAN_STATE_SAFE = 0;
    private static final int SCAN_STATE_SCAN = 1;
    private static final int SCAN_STATE_UNFINISH = 2;
    public static final int SCAN_STATE_VIRUS = 1;
    private static final int SCAN_STATE_WAIT = 0;
    public static AppInfoBean mIntentBean;
    private ScanAppAdapter mAdapter;
    private ScanAppAdapter mAdapter1;
    BasePagePresenter mBasePresenter;

    @BindView(C2113R.id.iv_apk_states)
    ImageView mIvApkStates;

    @BindView(C2113R.id.iv_app_states)
    ImageView mIvAppStates;

    @BindView(C2113R.id.iv_circle)
    ImageView mIvCircle;

    @BindView(C2113R.id.iv_circle_center)
    ImageView mIvCircleCenter;

    @BindView(C2113R.id.layout_risk_btn)
    ConstraintLayout mLayoutRiskBtn;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.recyclerview1)
    RecyclerView mRecyclerview1;

    @BindView(C2113R.id.recyclerview_risk)
    RecyclerView mRecyclerviewRisk;

    @BindView(C2113R.id.rl_risk_result)
    RelativeLayout mRlRiskResult;

    @BindView(C2113R.id.rl_safe_result)
    RelativeLayout mRlSafeResult;

    @BindView(C2113R.id.safe_space)
    Group mSafeSpace;

    @BindView(C2113R.id.scan_app)
    TextView mScanApp;

    @BindView(C2113R.id.scan_app_count)
    TextView mScanAppCount;

    @BindView(C2113R.id.scan_layout)
    ConstraintLayout mScanLayout;

    @BindView(C2113R.id.scan_package)
    TextView mScanPackage;

    @BindView(C2113R.id.scan_package_count)
    TextView mScanPackageCount;

    @BindView(C2113R.id.scan_result_tip)
    TextView mScanResultTip;

    @BindView(C2113R.id.scan_state)
    TextView mScanState;

    @BindView(C2113R.id.stop_scan)
    TextView mStopScan;

    @BindView(C2113R.id.switch_app)
    SwitchButton mSwitchApp;

    @BindView(C2113R.id.tv_app)
    TextView mTvApp;

    @BindView(C2113R.id.tv_app_count)
    TextView mTvAppCount;

    @BindView(C2113R.id.tv_appeal)
    TextView mTvAppeal;

    @BindView(C2113R.id.tv_delete)
    TextView mTvDelete;

    @BindView(C2113R.id.tv_package_count)
    TextView mTvPackageCount;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.view_bg)
    View mViewBg;
    C1829h options;
    private VirusKillingPresenter mPresenter = null;
    private ArrayList<ScanResultInfo> mAppParent = new ArrayList<>();
    private ArrayList<ScanResultInfo> mPackageParent = new ArrayList<>();
    private ArrayList<ArrayList<AppInfoBean>> mAppChild = new ArrayList<>();
    private ArrayList<ArrayList<AppInfoBean>> mPackageChild = new ArrayList<>();
    private ArrayList<AppInfoBean> virusList = null;
    private ArrayList<AppInfoBean> warnList = null;
    private ArrayList<AppInfoBean> okList = null;
    private InterfaceC6824c mAppScanListener = null;
    private InterfaceC6824c mPackageScanListener = null;
    private int currentState = -1;
    private boolean isStopScan = false;
    private boolean isAllFinishScan = false;
    private boolean isAppScanning = false;
    private boolean isPackageScanning = false;
    private RiskAppSelectAdapter mRiskAdapter = null;
    private int mSelectLimit = 9;
    private ArrayList<AppInfoBean> mAllSelectList = new ArrayList<>();
    private int mUninstallPosition = -1;
    private ArrayList<AppInfoBean> mAllRiskList = new ArrayList<>();
    private boolean isReportBack = false;
    private boolean isToOpenFlow = false;
    private boolean isToOpenStorage = false;

    /* renamed from: ui.activity.VirusKillingActivity$a */
    class C6670a implements CompoundButton.OnCheckedChangeListener {
        C6670a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (TextUtils.equals(WelocmPresenter.VIRAPWARN, "0")) {
                VirusKillingActivity.this.mSwitchApp.setChecked(!z);
                C7331w1.m26688a(WelocmPresenter.VIRSTMSG);
                return;
            }
            if (z) {
                VirusKillingActivity.this.mSwitchApp.setChecked(false);
                VirusKillingActivity.this.isToOpenFlow = true;
                VirusKillingActivity.this.checkPermissionSwitch();
            } else {
                VirusKillingActivity.this.isToOpenFlow = false;
                C7325u1.m26631b(C7325u1.f25637H, false);
            }
            StatisticsHttp.getInstance().trackWarnApp(VirusKillingActivity.this.mSwitchApp.isChecked() ? "1" : "0", null);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity$b */
    class C6671b implements PermissionsListener {

        /* renamed from: ui.activity.VirusKillingActivity$b$a */
        class a implements IOneClickListener {
            a() {
            }

            @Override // interfaces.IOneClickListener
            public void clickOKBtn() {
                VirusKillingActivity.this.isToOpenStorage = true;
            }
        }

        C6671b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7325u1.m26631b(C7325u1.f25637H, false);
            C7310c.m26514a(VirusKillingActivity.this.mActivity, list, z, true, this, new a());
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            VirusKillingActivity.this.isToOpenStorage = false;
            VirusKillingActivity.this.dealCheck();
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity$c */
    class C6672c implements PermissionsListener {
        C6672c() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7325u1.m26631b(C7325u1.f25637H, false);
            VirusKillingActivity.this.mSwitchApp.setChecked(false);
            C7310c.m26513a(VirusKillingActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!VirusKillingActivity.this.mBasePresenter.isOpenFlowPrim()) {
                C7310c.m26517a(VirusKillingActivity.this.mActivity, false, "", "", "", "", null);
                return;
            }
            VirusKillingActivity.this.mSwitchApp.setChecked(true);
            C7325u1.m26631b(C7325u1.f25637H, true);
            StatisticsHttp.getInstance().trackPageClick("1");
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity$d */
    class C6673d implements RiskAppSelectAdapter.InterfaceC0071b {
        C6673d() {
        }

        @Override // adapter.RiskAppSelectAdapter.InterfaceC0071b
        public void onItemClickListener(int i2, List<AppInfoBean> list) {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            VirusKillingActivity.mIntentBean = list.get(i2);
            VirusKillingActivity.this.startActivityForResult(new Intent(VirusKillingActivity.this, (Class<?>) VirusDetailActivity.class), 1001);
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity$e */
    class C6674e implements IClickListener {
        C6674e() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (VirusKillingActivity.this.hasSelect()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = VirusKillingActivity.this.mAllSelectList.iterator();
                while (it.hasNext()) {
                    AppInfoBean appInfoBean = (AppInfoBean) it.next();
                    AppVirusBean appVirusBean = new AppVirusBean();
                    appVirusBean.setAppName(appInfoBean.getName());
                    appVirusBean.setFileMd5(appInfoBean.getAppMD5());
                    appVirusBean.setVersionCode(appInfoBean.getVersionCode() + "");
                    appVirusBean.setPkgName(appInfoBean.getPkgName());
                    appVirusBean.setSignHash(appInfoBean.getSignHash());
                    appVirusBean.setFindTime(C7328v1.m26646a(System.currentTimeMillis()));
                    appVirusBean.setVirusDescription(appInfoBean.getVirusDescription());
                    appVirusBean.setVirusName(appInfoBean.getVirusName());
                    int virusLevel = appInfoBean.getVirusLevel();
                    if (virusLevel == 1) {
                        appVirusBean.setVirusLevel(1);
                        appVirusBean.setIllegalType("病毒");
                    } else if (virusLevel == 2) {
                        appVirusBean.setVirusLevel(2);
                        appVirusBean.setIllegalType("风险");
                    }
                    arrayList.add(appVirusBean);
                }
                VirusKillingActivity.this.mPresenter.appealApp(arrayList);
            }
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity$f */
    class C6675f implements IOneClickListener {
        C6675f() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            VirusKillingActivity.this.nextUninstall();
        }
    }

    private void appealSelect() {
        C7257b1.m26183a(this.mActivity, "确定上报应用错误信息吗", "", "取消", "确定", C2113R.color._A8B4F7, C2113R.color.blue_dark, (IClickListener) new C6674e());
    }

    private void beginScan() {
        ArrayList<ScanResultInfo> arrayList;
        this.isStopScan = false;
        this.isAllFinishScan = false;
        changeScanState(1);
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        RecyclerView recyclerView2 = this.mRecyclerview1;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        if (!this.isAppScanning && !this.isPackageScanning && this.mRiskAdapter != null && this.mRecyclerviewRisk != null && (arrayList = this.mAppParent) != null && this.mAppChild != null && this.mPackageParent != null && this.mPackageChild != null) {
            arrayList.clear();
            this.mAppChild.clear();
            this.mPackageParent.clear();
            this.mPackageChild.clear();
            this.mRecyclerviewRisk.setVisibility(8);
        }
        if (this.isPackageScanning) {
            scanPackage();
        } else {
            scanApp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDeal() {
        if (this.mScanState == null || this.mStopScan == null) {
            return;
        }
        int i2 = this.currentState;
        if (i2 == 1) {
            changeScanState(2);
            this.isStopScan = true;
            pauseScanApp();
        } else if (i2 == 2) {
            beginScan();
        } else if (i2 == 3) {
            finish();
        } else {
            if (i2 != 4) {
                return;
            }
            riskLayoutDeal();
        }
    }

    private void changeReportState(boolean z) {
        if (z) {
            this.mTvAppeal.setBackgroundResource(C2113R.drawable.button_bg_blue_ligth_1);
            this.mTvAppeal.setTextColor(getResources().getColor(C2113R.color.blue_dark));
            this.mTvAppeal.setEnabled(true);
            this.mTvDelete.setAlpha(1.0f);
            this.mTvDelete.setEnabled(true);
            return;
        }
        this.mTvAppeal.setBackgroundResource(C2113R.drawable.button_bg_gray);
        this.mTvAppeal.setTextColor(getResources().getColor(C2113R.color.colorGray));
        this.mTvAppeal.setEnabled(false);
        this.mTvDelete.setAlpha(0.5f);
        this.mTvDelete.setEnabled(false);
    }

    private void changeScanState(int i2) {
        TextView textView;
        if (this.mScanState == null || (textView = this.mStopScan) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(C2113R.color.colorWhite));
        this.mIvCircleCenter.setVisibility(8);
        this.mScanResultTip.setVisibility(8);
        this.mScanState.setVisibility(8);
        this.mStopScan.setVisibility(8);
        this.mLayoutRiskBtn.setVisibility(8);
        if (i2 == 0) {
            this.mScanState.setText("等待检测");
            this.mScanState.setVisibility(0);
            this.mIvCircleCenter.setVisibility(0);
            stopGif2Img(C2113R.mipmap.ic_scan_rotate);
            return;
        }
        if (i2 == 1) {
            this.mViewBg.setBackground(getResources().getDrawable(C2113R.mipmap.ic_blue_bg_big));
            this.mIvCircleCenter.setVisibility(0);
            this.mIvCircle.setImageResource(C2113R.mipmap.ic_scan_rotate);
            C7337y1.m26747a(this.mActivity, C2113R.anim.scan_app_anim, this.mIvCircle);
            this.mStopScan.setText("停止检测");
            this.mStopScan.setTextColor(getResources().getColor(C2113R.color.black_dark));
            this.mStopScan.setBackground(getResources().getDrawable(C2113R.drawable.button_bg_gray));
            this.mStopScan.setVisibility(0);
            this.currentState = 1;
            return;
        }
        if (i2 == 2) {
            this.mViewBg.setBackground(getResources().getDrawable(C2113R.mipmap.ic_blue_bg_big));
            stopGif2Img(C2113R.mipmap.ic_scan_unfinish);
            this.mScanResultTip.setText("暂停检测应用/安装包");
            this.mScanResultTip.setVisibility(0);
            this.mStopScan.setText("继续检测");
            this.mStopScan.setBackground(getResources().getDrawable(C2113R.drawable.button_bg_them));
            this.mStopScan.setVisibility(0);
            this.currentState = 2;
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            stopGif2Img(C2113R.mipmap.ic_scan_finish_virus);
            this.mViewBg.setBackgroundTintList(ColorStateList.valueOf(-1289424));
            this.mScanState.setText("建议定期检测清理，国家反诈中心实时守护您的网络安全");
            this.mScanState.setBackground(getResources().getDrawable(C2113R.drawable.button_bg_red_dark));
            this.mScanState.setVisibility(0);
            this.mScanLayout.setVisibility(8);
            this.mRlRiskResult.setVisibility(0);
            this.mLayoutRiskBtn.setVisibility(0);
            this.mTvDelete.setText("一键清除");
            riskLayoutDeal();
            refreshRiskCount();
            this.mScanResultTip.setVisibility(0);
            this.currentState = 4;
            return;
        }
        this.mViewBg.setBackground(getResources().getDrawable(C2113R.mipmap.ic_blue_bg_big));
        this.mViewBg.setBackgroundTintList(ColorStateList.valueOf(-13479169));
        stopGif2Img(C2113R.mipmap.ic_scan_finish);
        this.mScanResultTip.setText("安全");
        this.mScanResultTip.setVisibility(0);
        this.mScanState.setText("建议定期检测清理，国家反诈中心实时守护您的网络安全");
        this.mScanState.setBackground(getResources().getDrawable(C2113R.drawable.button_bg_blue_dark));
        this.mScanState.setVisibility(0);
        this.mStopScan.setText("安全返回");
        this.mStopScan.setBackground(getResources().getDrawable(C2113R.drawable.button_bg_them));
        this.mStopScan.setVisibility(0);
        this.mScanLayout.setVisibility(8);
        this.mRlRiskResult.setVisibility(8);
        this.mRlSafeResult.setVisibility(0);
        this.mSafeSpace.setVisibility(0);
        int size = hasSingleData(this.mAppChild, 2) ? this.mAppChild.get(2).size() : 0;
        this.mTvAppCount.setText(size + "");
        int size2 = hasSingleData(this.mPackageChild, 2) ? this.mPackageChild.get(2).size() : 0;
        this.mTvPackageCount.setText(size2 + "");
        this.currentState = 3;
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6671b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermissionSwitch() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6672c());
    }

    private void cleanCacheData() {
        C7325u1.m26622a((List) null, C7325u1.f25628C0);
        C7325u1.m26622a((List) null, C7325u1.f25630D0);
        C7325u1.m26622a((List) null, C7325u1.f25632E0);
        C7325u1.m26622a((List) null, C7325u1.f25634F0);
        C7325u1.m26622a((List) null, C7325u1.f25636G0);
        C7325u1.m26622a((List) null, C7325u1.f25638H0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealCheck() {
        boolean m26623a = C7325u1.m26623a(C7325u1.f25624A0, false);
        boolean m26623a2 = C7325u1.m26623a(C7325u1.f25626B0, false);
        if (m26623a && m26623a2) {
            C7325u1.m26631b(C7325u1.f25626B0, false);
            getRiskDate();
            scanResult();
        } else {
            C7325u1.m26631b(C7325u1.f25624A0, true);
            if (m26623a2) {
                C7325u1.m26631b(C7325u1.f25626B0, false);
                cleanCacheData();
            }
            beginScan();
        }
    }

    private void dealScanBegin(ArrayList<ScanResultInfo> arrayList, ArrayList<ArrayList<AppInfoBean>> arrayList2, String str) {
        try {
            arrayList2.add(new ArrayList<>());
            arrayList2.add(new ArrayList<>());
            arrayList2.add(new ArrayList<>());
            arrayList.add(new ScanResultInfo("恶意" + str, 0));
            arrayList.add(new ScanResultInfo("风险" + str, 0));
            arrayList.add(new ScanResultInfo("安全" + str, 0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealScanResult(ArrayList<ScanResultInfo> arrayList, ArrayList<ArrayList<AppInfoBean>> arrayList2, ArrayList<AppInfoBean> arrayList3, ArrayList<AppInfoBean> arrayList4, ArrayList<AppInfoBean> arrayList5, String str) {
        try {
            arrayList.add(new ScanResultInfo("恶意" + str, arrayList3.size()));
            arrayList.add(new ScanResultInfo("风险" + str, arrayList4.size()));
            arrayList.add(new ScanResultInfo("安全" + str, arrayList5.size()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void deleteSelect() {
        if (hasSelect()) {
            Iterator it = ((ArrayList) this.mAllSelectList.clone()).iterator();
            String str = "";
            while (it.hasNext()) {
                AppInfoBean appInfoBean = (AppInfoBean) it.next();
                if (!appInfoBean.isTypeIsApp()) {
                    File file = new File(appInfoBean.getPkgPath());
                    try {
                        if (needDelete(appInfoBean) && file.exists() && file.isFile() && file.delete()) {
                            str = str + "“" + appInfoBean.getName() + "”、";
                            this.mAllSelectList.remove(appInfoBean);
                            this.mAllRiskList.remove(appInfoBean);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                nextUninstall();
                return;
            }
            refreshAfterDelete();
            String substring = str.substring(0, str.length() - 1);
            C7257b1.m26210b(this.mActivity, "已删除" + substring + "安装包", "确定", new C6675f());
        }
    }

    private ArrayList<AppInfoBean> getRiskData(String str, boolean z) {
        ArrayList<AppInfoBean> arrayList = new ArrayList<>();
        for (AppBean appBean : C7325u1.m26626b(str, AppBean.class)) {
            arrayList.add(AppBean.AppBean2AppInfoBean(appBean, z ? new BitmapDrawable(C5844c.m24589a(appBean.getName(), appBean.getVersionName(), C5844c.f21114c)) : null, appBean.getVirusName(), appBean.getVirusDescription(), appBean.isScaned(), appBean.getLastTime()));
        }
        return arrayList;
    }

    private void getRiskDate() {
        this.mAppChild.clear();
        this.mPackageChild.clear();
        this.mAppChild.add(getRiskData(C7325u1.f25628C0, true));
        this.mAppChild.add(getRiskData(C7325u1.f25630D0, true));
        this.mAppChild.add(getRiskData(C7325u1.f25632E0, false));
        this.mPackageChild.add(getRiskData(C7325u1.f25634F0, true));
        this.mPackageChild.add(getRiskData(C7325u1.f25636G0, true));
        this.mPackageChild.add(getRiskData(C7325u1.f25638H0, false));
        cleanCacheData();
    }

    private boolean hasRiskData(ArrayList<ArrayList<AppInfoBean>> arrayList) {
        if (arrayList != null && arrayList.size() == 3) {
            if (arrayList.get(0) != null && arrayList.get(0).size() > 0) {
                return true;
            }
            if (arrayList.get(1) != null && arrayList.get(1).size() > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasSelect() {
        ArrayList<AppInfoBean> arrayList = this.mAllSelectList;
        return arrayList != null && arrayList.size() > 0;
    }

    private boolean hasSingleData(ArrayList<ArrayList<AppInfoBean>> arrayList, int i2) {
        return arrayList != null && arrayList.size() == 3 && arrayList.get(i2) != null && arrayList.get(i2).size() > 0;
    }

    private RiskAppSelectAdapter initRecycleView(RecyclerView recyclerView, List<AppInfoBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RiskAppSelectAdapter riskAppSelectAdapter = new RiskAppSelectAdapter(C2113R.layout.recyclerview_app_select_risk, list);
        riskAppSelectAdapter.m5103a(recyclerView);
        recyclerView.setAdapter(riskAppSelectAdapter);
        riskAppSelectAdapter.setOnItemChildClickListener(this);
        riskAppSelectAdapter.setOnItemClickListener(new C6673d());
        return riskAppSelectAdapter;
    }

    private void initReport() {
    }

    private void initRiskLayout() {
        this.mRiskAdapter = initRecycleView(this.mRecyclerviewRisk, new ArrayList());
    }

    private void initWarn() {
        this.mBasePresenter = new BasePagePresenter(this.mActivity);
        this.mTvApp.setTypeface(this.typ_ME);
        boolean m26623a = C7325u1.m26623a(C7325u1.f25637H, false);
        if (ContextCompat.checkSelfPermission(this, C7308a.f25547z) == 0 && this.mBasePresenter.isOpenFlowPrim() && m26623a) {
            this.mSwitchApp.setChecked(true);
        } else {
            this.mSwitchApp.setChecked(false);
            C7325u1.m26631b(C7325u1.f25637H, false);
        }
        this.mSwitchApp.setOnCheckedChangeListener(new C6670a());
    }

    private void itemClick(int i2, List<AppInfoBean> list, RiskAppSelectAdapter riskAppSelectAdapter) {
        AppInfoBean appInfoBean = list.get(i2);
        if (appInfoBean.getFileSize() > 209715200) {
            C7331w1.m26688a("200M以上文件不可选择");
            return;
        }
        if (appInfoBean.isSelect()) {
            appInfoBean.setSelect(false);
            this.mAllSelectList.remove(appInfoBean);
        } else {
            if (this.mAllSelectList.size() == this.mSelectLimit) {
                C7331w1.m26688a("最多选择" + this.mSelectLimit + "个");
                return;
            }
            appInfoBean.setSelect(true);
            if (!this.mAllSelectList.contains(appInfoBean)) {
                this.mAllSelectList.add(appInfoBean);
            }
        }
        riskAppSelectAdapter.notifyDataSetChanged();
        if (hasSelect()) {
            changeReportState(true);
        } else {
            changeReportState(false);
        }
    }

    private boolean needDelete(AppInfoBean appInfoBean) {
        return !this.isReportBack || appInfoBean.getSource() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextUninstall() {
        boolean z;
        if (!hasSelect()) {
            changeReportState(false);
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.mAllSelectList.size()) {
                z = false;
                break;
            }
            AppInfoBean appInfoBean = this.mAllSelectList.get(i2);
            if (needDelete(appInfoBean) && appInfoBean.isTypeIsApp() && !appInfoBean.isCancleUninstall()) {
                uninstall(appInfoBean.getPkgName());
                this.mUninstallPosition = i2;
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return;
        }
        this.isReportBack = false;
        this.mUninstallPosition = -1;
        if (!hasSelect()) {
            changeReportState(false);
            return;
        }
        Iterator<AppInfoBean> it = this.mAllSelectList.iterator();
        while (it.hasNext()) {
            AppInfoBean next = it.next();
            if (next.isTypeIsApp()) {
                next.setCancleUninstall(false);
            }
        }
        changeReportState(true);
    }

    private void pauseScanApp() {
        C6823b.m25505e().m25520c();
    }

    private void refreshAfterDelete() {
        this.mRiskAdapter.setNewData(this.mAllRiskList);
        ArrayList<AppInfoBean> arrayList = this.mAllRiskList;
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                refreshRiskCount();
            } else {
                this.isReportBack = false;
                changeScanState(3);
            }
        }
    }

    private void refreshRiskCount() {
        ArrayList<AppInfoBean> arrayList = this.mAllRiskList;
        int size = (arrayList == null || arrayList.size() <= 0) ? 0 : this.mAllRiskList.size();
        this.mScanResultTip.setText("发现" + size + "项可疑应用");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(TextView textView, ScanAppAdapter scanAppAdapter, RecyclerView recyclerView, List<AppInfoBean> list, AppInfoBean appInfoBean) {
        if (list == null) {
            scanAppAdapter.m5112a((ScanAppAdapter) appInfoBean);
        } else {
            scanAppAdapter.m5113a((Collection) list);
        }
        textView.setText(scanAppAdapter.getItemCount() + "");
        scanAppAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(scanAppAdapter.getItemCount() + (-1));
    }

    private void riskLayoutDeal() {
        this.mAllRiskList.clear();
        this.mAllRiskList.addAll(this.mAppChild.get(0));
        this.mAllRiskList.addAll(this.mAppChild.get(1));
        this.mAllRiskList.addAll(this.mPackageChild.get(0));
        this.mAllRiskList.addAll(this.mPackageChild.get(1));
        updataRidkLayout(this.mRiskAdapter, this.mAllRiskList);
        this.mRecyclerviewRisk.setVisibility(0);
        changeReportState(false);
    }

    private void scanApp() {
        if (!this.isAppScanning) {
            this.isAppScanning = true;
            C5845d.m24605a(this.mIvAppStates, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
            dealScanBegin(this.mAppParent, this.mAppChild, "应用");
            this.virusList = this.mAppChild.get(0);
            this.warnList = this.mAppChild.get(1);
            this.okList = this.mAppChild.get(2);
            RecyclerView recyclerView = this.mRecyclerview;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
        }
        if (this.mAppScanListener == null) {
            this.mAppScanListener = new C6676g();
        }
        C6823b.m25505e().m25515a(this, 1, this.mAppScanListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanPackage() {
        if (isFinishing()) {
            return;
        }
        this.isAppScanning = false;
        if (!this.isPackageScanning) {
            this.isPackageScanning = true;
            C5845d.m24605a(this.mIvApkStates, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
            dealScanBegin(this.mPackageParent, this.mPackageChild, "安装包");
            this.virusList = this.mPackageChild.get(0);
            this.warnList = this.mPackageChild.get(1);
            this.okList = this.mPackageChild.get(2);
        }
        if (this.mPackageScanListener == null) {
            this.mPackageScanListener = new C6677h();
        }
        C6823b.m25505e().m25518b(this, 1, this.mPackageScanListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanResult() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        RecyclerView recyclerView2 = this.mRecyclerview1;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        if (hasRiskData(this.mAppChild) || hasRiskData(this.mPackageChild)) {
            changeScanState(4);
        } else {
            changeScanState(3);
        }
    }

    private void stopGif2Img(int i2) {
        try {
            if (this.mIvCircle != null) {
                if (this.mIvCircle.getDrawable() != null) {
                    this.mIvCircle.clearAnimation();
                }
                this.mIvCircle.setImageResource(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mIvCircle.setImageResource(i2);
        }
    }

    private void stopScanApp() {
        this.isStopScan = true;
        C6823b.m25505e().m25517b();
    }

    private void uninstall(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        startActivityForResult(intent, 1000);
    }

    private void updataRidkLayout(RiskAppSelectAdapter riskAppSelectAdapter, List<AppInfoBean> list) {
        for (AppInfoBean appInfoBean : list) {
            appInfoBean.setSelect(false);
            appInfoBean.setCancleUninstall(false);
        }
        if (riskAppSelectAdapter == null || list == null || list.size() <= 0) {
            return;
        }
        riskAppSelectAdapter.setNewData(list);
    }

    /* renamed from: a */
    public /* synthetic */ void m25401a() {
        if (isFinishing()) {
            return;
        }
        boolean isOpenFlowPrim = this.mBasePresenter.isOpenFlowPrim();
        if (this.isToOpenFlow && isOpenFlowPrim) {
            this.isToOpenFlow = false;
            if (ContextCompat.checkSelfPermission(this, C7308a.f25547z) == 0) {
                this.mSwitchApp.setChecked(true);
                C7325u1.m26631b(C7325u1.f25637H, true);
            } else {
                this.mSwitchApp.setChecked(false);
                C7325u1.m26631b(C7325u1.f25637H, false);
            }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        if (!AccountManager.isLogin()) {
            finish();
            return;
        }
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17169p);
        this.mTvTitle.setText("APP自检");
        this.mTvTitle.setTypeface(this.typ_ME);
        C7161b.m25698a((Activity) this, true, false);
        initRiskLayout();
        C6049c.m24987f().m25001e(this);
        this.mPresenter = new VirusKillingPresenter((Activity) this, (VirusKillingCallView) this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new ScanAppAdapter(C2113R.layout.recyclerview_app_scan);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mRecyclerview1.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter1 = new ScanAppAdapter(C2113R.layout.recyclerview_app_scan);
        this.mAdapter1.m5103a(this.mRecyclerview1);
        this.mRecyclerview1.setAdapter(this.mAdapter1);
        this.options = new C1829h();
        this.options.m4753a(AbstractC1665j.f4538b);
        changeScanState(0);
        try {
            this.mScanApp.setText("等待检测应用");
            this.mScanPackage.setText("等待检测安装包");
            C5845d.m24605a(this.mIvAppStates, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
            C5845d.m24605a(this.mIvApkStates, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        initWarn();
        checkPermission();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<AppInfoBean> arrayList;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1000) {
            if (i2 == 1001 && i3 == -1) {
                this.mAllSelectList.remove(mIntentBean);
                this.mAllRiskList.remove(mIntentBean);
                mIntentBean = null;
                refreshAfterDelete();
                return;
            }
            return;
        }
        if (this.mUninstallPosition == -1 || (arrayList = this.mAllSelectList) == null) {
            return;
        }
        int size = arrayList.size();
        int i4 = this.mUninstallPosition;
        if (size > i4) {
            AppInfoBean appInfoBean = this.mAllSelectList.get(i4);
            if (C7316r1.m26551d(appInfoBean.getPkgName())) {
                appInfoBean.setCancleUninstall(true);
                if (this.isReportBack) {
                    appInfoBean.setSource(0);
                }
            } else {
                this.mAllSelectList.remove(appInfoBean);
                this.mAllRiskList.remove(appInfoBean);
                this.mUninstallPosition = -1;
                refreshAfterDelete();
            }
            nextUninstall();
        }
    }

    @Override // p388ui.callview.VirusKillingCallView
    public void onAppealSuccess() {
        C7257b1.m26186a((Activity) this, false, 1, "错误信息上报成功", C2113R.drawable.iv_comit_succ);
        this.mAllSelectList.clear();
        changeReportState(false);
        Iterator<AppInfoBean> it = this.mAllRiskList.iterator();
        while (it.hasNext()) {
            it.next().setSelect(false);
        }
        refreshAfterDelete();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        stopScanApp();
        finish();
        super.onBackPressed();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
        C5844c.m24594a(C5844c.f21114c);
        this.isStopScan = true;
        C6823b.m25505e().m25517b();
    }

    @InterfaceC6059m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventWornThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 26) {
            return;
        }
        C6049c.m24987f().m25002f(c7265a);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!Hicore.getApp().isDouble() && view.getId() == C2113R.id.iv_checkbox) {
            itemClick(i2, this.mAllRiskList, this.mRiskAdapter);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C7337y1.f25731b.postDelayed(new Runnable() { // from class: ui.activity.m1
            @Override // java.lang.Runnable
            public final void run() {
                VirusKillingActivity.this.m25401a();
            }
        }, 500L);
        if (this.isToOpenStorage && ContextCompat.checkSelfPermission(this, C7308a.f25547z) == 0) {
            this.isToOpenStorage = false;
            dealCheck();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.layout_app, C2113R.id.layout_apk, C2113R.id.stop_scan, C2113R.id.tv_appeal, C2113R.id.tv_delete, C2113R.id.tv_appeal_wb})
    public void onViewClicked(View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.layout_apk /* 2131296880 */:
                if (this.isAllFinishScan && (recyclerView = this.mRecyclerview1) != null) {
                    if (recyclerView.getVisibility() != 8) {
                        this.mRecyclerview1.setVisibility(8);
                        break;
                    } else {
                        this.mRecyclerview1.setVisibility(0);
                        break;
                    }
                }
                break;
            case C2113R.id.layout_app /* 2131296881 */:
                if (this.isAllFinishScan && (recyclerView2 = this.mRecyclerview) != null) {
                    if (recyclerView2.getVisibility() != 8) {
                        this.mRecyclerview.setVisibility(8);
                        break;
                    } else {
                        this.mRecyclerview.setVisibility(0);
                        break;
                    }
                }
                break;
            case C2113R.id.stop_scan /* 2131297304 */:
                btnDeal();
                break;
            case C2113R.id.tv_appeal /* 2131297426 */:
                appealSelect();
                break;
            case C2113R.id.tv_appeal_wb /* 2131297427 */:
                C7257b1.m26168a(this.mActivity);
                break;
            case C2113R.id.tv_delete /* 2131297512 */:
                deleteSelect();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        if (AccountManager.isLogin()) {
            return C2113R.layout.activity_virus_killing;
        }
        finish();
        return C2113R.layout.activity_virus_killing;
    }

    /* renamed from: ui.activity.VirusKillingActivity$g */
    class C6676g implements InterfaceC6824c {
        C6676g() {
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25403a(int i2) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            C7301n1.m26459c("Scanner", "APP总数=" + i2);
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: b */
        public void mo25406b() {
            C7301n1.m26459c("Scanner", "检测应用-----------------scanStop");
            try {
                VirusKillingActivity.this.btnDeal();
                if (VirusKillingActivity.this.mIvAppStates != null) {
                    C5845d.m24605a(VirusKillingActivity.this.mIvAppStates, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: c */
        public void mo25407c() {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            C7301n1.m26459c("Scanner", "开始检测");
            try {
                VirusKillingActivity.this.mScanApp.setText("正在检测应用");
                VirusKillingActivity.this.mScanPackage.setText("等待检测安装包");
                C5845d.m24605a(VirusKillingActivity.this.mIvAppStates, Integer.valueOf(C2113R.mipmap.ic_scan_loading));
                C5845d.m24605a(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25405a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            VirusKillingActivity virusKillingActivity = VirusKillingActivity.this;
            virusKillingActivity.refreshUI(virusKillingActivity.mScanAppCount, virusKillingActivity.mAdapter, VirusKillingActivity.this.mRecyclerview, list, appInfoBean);
            C7301n1.m26457b("scanSingleIng-->", "data " + VirusKillingActivity.this.mAdapter.m5134c().size());
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25404a(List<AppInfoBean> list) {
            try {
                for (AppInfoBean appInfoBean : list) {
                    appInfoBean.setFlag(1);
                    appInfoBean.setSelect(false);
                    appInfoBean.setTypeIsApp(true);
                    int virusLevel = appInfoBean.getVirusLevel();
                    if (virusLevel == 1) {
                        VirusKillingActivity.this.virusList.add(appInfoBean);
                    } else if (virusLevel == 2) {
                        VirusKillingActivity.this.warnList.add(appInfoBean);
                    } else {
                        appInfoBean.setVirusLevel(0);
                        VirusKillingActivity.this.okList.add(appInfoBean);
                    }
                    C7301n1.m26459c("Scanner", "检测完成应用=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25402a() {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            C7301n1.m26459c("Scanner", "检测完成");
            VirusKillingActivity.this.mAdapter.notifyDataSetChanged();
            VirusKillingActivity virusKillingActivity = VirusKillingActivity.this;
            virusKillingActivity.dealScanResult(virusKillingActivity.mAppParent, VirusKillingActivity.this.mAppChild, VirusKillingActivity.this.virusList, VirusKillingActivity.this.warnList, VirusKillingActivity.this.okList, "应用");
            VirusKillingActivity virusKillingActivity2 = VirusKillingActivity.this;
            TextView textView = virusKillingActivity2.mScanApp;
            if (textView != null && virusKillingActivity2.mIvAppStates != null) {
                textView.setText("检测应用完成");
                C5845d.m24612b(VirusKillingActivity.this.mIvAppStates, Integer.valueOf(C2113R.mipmap.ic_scan_ok));
            }
            VirusKillingActivity.this.scanPackage();
        }
    }

    /* renamed from: ui.activity.VirusKillingActivity$h */
    class C6677h implements InterfaceC6824c {
        C6677h() {
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25403a(int i2) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            C7301n1.m26459c("Scanner", "开始检测安装包个数=====" + i2);
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: b */
        public void mo25406b() {
            C7301n1.m26459c("Scanner", "检测安装包       scanStop=====");
            try {
                VirusKillingActivity.this.btnDeal();
                if (VirusKillingActivity.this.mIvApkStates != null) {
                    C5845d.m24605a(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(C2113R.mipmap.ic_scan_wait));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: c */
        public void mo25407c() {
            C7301n1.m26459c("Scanner", "开始检测安装包=====");
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            RecyclerView recyclerView = VirusKillingActivity.this.mRecyclerview;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            try {
                VirusKillingActivity.this.mScanPackage.setText("正在检测安装包");
                C5845d.m24605a(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(C2113R.mipmap.ic_scan_loading));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25405a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            VirusKillingActivity virusKillingActivity = VirusKillingActivity.this;
            virusKillingActivity.refreshUI(virusKillingActivity.mScanPackageCount, virusKillingActivity.mAdapter1, VirusKillingActivity.this.mRecyclerview1, list, appInfoBean);
        }

        @Override // p388ui.p390e.InterfaceC6824c
        /* renamed from: a */
        public void mo25404a(List<AppInfoBean> list) {
            try {
                for (AppInfoBean appInfoBean : list) {
                    appInfoBean.setFlag(1);
                    appInfoBean.setSelect(false);
                    appInfoBean.setTypeIsApp(false);
                    int virusLevel = appInfoBean.getVirusLevel();
                    if (virusLevel == 1) {
                        VirusKillingActivity.this.virusList.add(appInfoBean);
                    } else if (virusLevel == 2) {
                        VirusKillingActivity.this.warnList.add(appInfoBean);
                    } else {
                        appInfoBean.setVirusLevel(0);
                        if (appInfoBean.getAppIcon() != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                            VirusKillingActivity.this.okList.add(appInfoBean);
                        }
                    }
                    C7301n1.m26459c("Scanner", "检测完成安装包=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // p388ui.p390e.InterfaceC6824c
        @SuppressLint({"RestrictedApi"})
        /* renamed from: a */
        public void mo25402a() {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            try {
                VirusKillingActivity.this.mScanPackage.setText("检测安装包完成");
                C5845d.m24612b(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(C2113R.mipmap.ic_scan_ok));
                VirusKillingActivity.this.dealScanResult(VirusKillingActivity.this.mPackageParent, VirusKillingActivity.this.mPackageChild, VirusKillingActivity.this.virusList, VirusKillingActivity.this.warnList, VirusKillingActivity.this.okList, "安装包");
                VirusKillingActivity.this.scanResult();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            VirusKillingActivity.this.isPackageScanning = false;
            VirusKillingActivity.this.isAllFinishScan = true;
        }
    }
}
