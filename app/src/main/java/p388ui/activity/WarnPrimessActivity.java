package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import bean.GuideBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.hicorenational.antifraud.C2113R;
import com.hicorenational.antifraud.service.WarnGuidService;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p245d.C4443d;
import p247e.C4447d;
import p357j.C5845d;
import p388ui.Hicore;
import p388ui.callview.WarnPrimessCallView;
import p388ui.presenter.BasePagePresenter;
import p388ui.presenter.WarnPrimessPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7325u1;
import util.C7328v1;
import util.C7337y1;
import util.p395c2.C7265a;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class WarnPrimessActivity extends BaseActivity implements WarnPrimessCallView {
    public static final String EXTRA_GUIDE_CODE = "extra_guide_code";
    public static final String EXTRA_GUIDE_DATA = "extra_guide_data";
    BasePagePresenter mBasePresenter;

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.iv_ic)
    ImageView mIvIc;

    @BindView(C2113R.id.ll_content)
    LinearLayout mLlContent;

    @BindView(C2113R.id.open_auto)
    TextView mOpenAuto;

    @BindView(C2113R.id.open_flow)
    TextView mOpenFlow;

    @BindView(C2113R.id.open_lock)
    TextView mOpenLock;

    @BindView(C2113R.id.open_phone)
    TextView mOpenPhone;

    @BindView(C2113R.id.open_phone_record)
    TextView mOpenPhoneRecord;

    @BindView(C2113R.id.open_power)
    TextView mOpenPower;

    @BindView(C2113R.id.open_sms)
    TextView mOpenSms;

    @BindView(C2113R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(C2113R.id.tv_label)
    TextView mTvLabel;

    @BindView(C2113R.id.tv_label_small)
    TextView mTvLabelSmall;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    WarnPrimessPresenter mWarnPresenter;
    public final String COUNT_TAG_FLOW = "0";
    public final String COUNT_TAG_PHONE = "1";
    public final String COUNT_TAG_RECORD = "2";
    public final String COUNT_TAG_SMS = "3";
    private String[] permListPhone = {C7308a.f25533l};
    private String[] permListRecord = null;
    private String[] permListSms = {C7308a.f25544w, C7308a.f25543v};
    private String[] permListNormal = null;
    private int mCurrentCode = -1;
    HashMap<String, GuideBean> mGuideMap = null;
    private String mOpenCount = "";
    private int mSumCount = 4;
    private int mOldShowCount = -1;
    private BottomSheetDialog mBottomSheetDialog = null;
    private boolean isToOpenFlow = false;

    /* renamed from: ui.activity.WarnPrimessActivity$a */
    class C6690a implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ String f23455a;

        /* renamed from: b */
        final /* synthetic */ TextView f23456b;

        C6690a(String str, TextView textView) {
            this.f23455a = str;
            this.f23456b = textView;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            C7325u1.m26631b(this.f23455a, true);
            WarnPrimessActivity.this.openStateNotNecessary(this.f23456b, true);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            C7325u1.m26631b(this.f23455a, false);
            WarnPrimessActivity.this.openStateNotNecessary(this.f23456b, false);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity$b */
    class C6691b implements IClickListener {
        C6691b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            WarnPrimessActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity$c */
    class C6692c extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a */
        final /* synthetic */ BottomSheetBehavior f23459a;

        C6692c(BottomSheetBehavior bottomSheetBehavior) {
            this.f23459a = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View view, int i2) {
            if (i2 == 5) {
                WarnPrimessActivity.this.mBottomSheetDialog.dismiss();
                this.f23459a.setState(4);
            }
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity$d */
    class ViewOnClickListenerC6693d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BottomSheetBehavior f23461a;

        ViewOnClickListenerC6693d(BottomSheetBehavior bottomSheetBehavior) {
            this.f23461a = bottomSheetBehavior;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WarnPrimessActivity.this.mBottomSheetDialog.dismiss();
            this.f23461a.setState(4);
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity$e */
    class ViewOnClickListenerC6694e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BottomSheetBehavior f23463a;

        ViewOnClickListenerC6694e(BottomSheetBehavior bottomSheetBehavior) {
            this.f23463a = bottomSheetBehavior;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WarnPrimessActivity.this.mBottomSheetDialog.dismiss();
            this.f23463a.setState(4);
            WarnPrimessActivity.this.isToOpenFlow = true;
            if (!Build.BRAND.equalsIgnoreCase("vivo")) {
                WarnPrimessActivity.this.mBasePresenter.checkOtherPerssion(null);
            } else {
                if (C7292k1.m26399c(WarnPrimessActivity.this.mActivity)) {
                    return;
                }
                C7292k1.m26401e(WarnPrimessActivity.this.mActivity);
            }
        }
    }

    /* renamed from: ui.activity.WarnPrimessActivity$f */
    class C6695f implements PermissionsListener {
        C6695f() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            WarnPrimessActivity.this.checkResult(false, z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            boolean z = false;
            boolean z2 = true;
            if (C7310c.m26527g() && (!C7310c.m26522b() || !C7310c.m26519a() || !C7310c.m26523c())) {
                z = true;
                z2 = false;
            }
            WarnPrimessActivity.this.checkResult(z2, z);
        }
    }

    private void checkPermission(String[] strArr) {
        C7310c.m26518a(this.mActivity, strArr, new C6695f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkResult(boolean z, boolean z2) {
        boolean m26520a = C7310c.m26520a(this.mActivity, this.permListPhone);
        boolean m26520a2 = C7310c.m26520a(this.mActivity, this.permListRecord);
        boolean m26520a3 = C7310c.m26520a(this.mActivity, this.permListSms);
        openState(this.mOpenPhone, m26520a);
        openState(this.mOpenPhoneRecord, m26520a2);
        openState(this.mOpenSms, m26520a3);
        if (!m26520a) {
            this.mCurrentCode = 10002;
            z = false;
        } else if (!m26520a2) {
            this.mCurrentCode = 10003;
        } else {
            if (m26520a3) {
                this.mCurrentCode = -1;
                return;
            }
            this.mCurrentCode = GuideBean.GUIDE_CODE_SMS;
        }
        if (this.mCurrentCode != -1) {
            z2 = true;
            z = false;
        }
        switch (this.mCurrentCode) {
            case 10002:
                openState(this.mOpenPhone, z);
                if (z2) {
                    intentNext();
                    break;
                }
                break;
            case 10003:
                openState(this.mOpenPhoneRecord, z);
                if (z2) {
                    intentNext();
                    break;
                }
                break;
            case GuideBean.GUIDE_CODE_SMS /* 10004 */:
                openState(this.mOpenSms, z);
                if (z2) {
                    intentNext();
                    break;
                }
                break;
        }
    }

    private int getWindowHeight() {
        return this.mActivity.getResources().getDisplayMetrics().heightPixels;
    }

    private void intentNext() {
        Intent intent = new Intent(this, (Class<?>) WarnGuideActivity.class);
        intent.putExtra(EXTRA_GUIDE_CODE, this.mCurrentCode);
        HashMap<String, GuideBean> hashMap = this.mGuideMap;
        if (hashMap != null && !hashMap.isEmpty()) {
            intent.putExtra(EXTRA_GUIDE_DATA, this.mGuideMap.get(this.mCurrentCode + ""));
        }
        startActivity(intent);
    }

    private void intentNextFlow() {
        GuideBean guideBean;
        HashMap<String, GuideBean> hashMap = this.mGuideMap;
        if (hashMap == null || hashMap.isEmpty()) {
            guideBean = null;
        } else {
            guideBean = this.mGuideMap.get(this.mCurrentCode + "");
        }
        showBottomDlg(guideBean);
    }

    private void openDialog(String str, String str2, TextView textView) {
        C7257b1.m26184a(this.mActivity, "是否已经成功开启【" + str + "】权限？", "", "成功开启", "未开启", -1, -1, true, (IClickListener) new C6690a(str2, textView));
    }

    private void openState(TextView textView, boolean z) {
        String str;
        try {
            str = (String) textView.getTag();
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        openState(textView, z, true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openStateNotNecessary(TextView textView, boolean z) {
        openState(textView, z, false, "");
    }

    private void showBottomDlg(GuideBean guideBean) {
        View inflate = View.inflate(this.mActivity, C2113R.layout.layout_warn_guide_flow, null);
        ImageView imageView = (ImageView) inflate.findViewById(C2113R.id.iv_warn_guide_close);
        ImageView imageView2 = (ImageView) inflate.findViewById(C2113R.id.iv_warn_guide);
        TextView textView = (TextView) inflate.findViewById(C2113R.id.tv_go_setting);
        this.mBottomSheetDialog = new BottomSheetDialog(this.mActivity, C2113R.style.base_dialog_style);
        this.mBottomSheetDialog.setContentView(inflate);
        BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        from.setPeekHeight(getWindowHeight());
        from.setBottomSheetCallback(new C6692c(from));
        imageView.setOnClickListener(new ViewOnClickListenerC6693d(from));
        textView.setOnClickListener(new ViewOnClickListenerC6694e(from));
        if (guideBean != null) {
            C5845d.m24610a(guideBean.getImgUrl(), imageView2, Integer.valueOf(C2113R.drawable.iv_blue_bg));
        }
        this.mBottomSheetDialog.show();
    }

    private void showWindowAlpha(boolean z) {
    }

    private void titleState() {
        if (this.mIvIc == null) {
            return;
        }
        int length = this.mOpenCount.length();
        int i2 = this.mSumCount;
        if (length == i2) {
            if (this.mIvIc.getVisibility() == 0) {
                return;
            }
            this.mTvLabel.setText("预警守护中");
            this.mTvLabelSmall.setText("准确识别电信网络诈骗");
            this.mIvIc.setVisibility(0);
            this.mConfirm.setEnabled(true);
            return;
        }
        int length2 = i2 - this.mOpenCount.length();
        if (length2 < 0) {
            return;
        }
        if (this.mIvIc.getVisibility() == 8 && this.mOldShowCount == length2) {
            return;
        }
        this.mTvLabel.setText("预警需开启以下权限");
        this.mTvLabelSmall.setText("还需开启" + length2 + "项权限");
        this.mIvIc.setVisibility(8);
        this.mOldShowCount = length2;
        this.mConfirm.setEnabled(false);
    }

    /* renamed from: a */
    public /* synthetic */ void m25411a() {
        boolean isOpenFlowPrim = this.mBasePresenter.isOpenFlowPrim();
        if (this.mCurrentCode == 10001 && this.isToOpenFlow && isOpenFlowPrim) {
            this.isToOpenFlow = false;
            this.mCurrentCode = -1;
            checkPermission(this.permListNormal);
        }
        openState(this.mOpenFlow, isOpenFlowPrim);
        titleState();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17168o);
        C6049c.m24987f().m25001e(this);
        C7161b.m25698a((Activity) this, true, false);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mRlTitle.setBackgroundColor(getResources().getColor(C2113R.color.blue));
        this.mIvIc.setVisibility(8);
        this.mBasePresenter = new BasePagePresenter(this.mActivity);
        this.mWarnPresenter = new WarnPrimessPresenter(this.mActivity, this);
        this.mWarnPresenter.requestGuideConfig();
        ArrayList arrayList = new ArrayList();
        arrayList.add(C7308a.f25531j);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(C7308a.f25539r);
        }
        this.permListRecord = (String[]) arrayList.toArray(new String[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList(this.permListPhone));
        arrayList2.addAll(arrayList);
        arrayList2.addAll(Arrays.asList(this.permListSms));
        this.permListNormal = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        this.mOpenFlow.setTag("0");
        this.mOpenPhone.setTag("1");
        this.mOpenPhoneRecord.setTag("2");
        this.mOpenSms.setTag("3");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!C7310c.m26520a(this.mActivity, this.mBasePresenter.checkPermission())) {
            C7257b1.m26184a(this.mActivity, "预警权限未开启", "", "放弃使用", "去开启", -1, -1, true, (IClickListener) new C6691b());
            return;
        }
        C7325u1.m26631b(C7325u1.f25633F, true);
        C7325u1.m26631b(C7325u1.f25635G, true);
        C7325u1.m26631b(C7325u1.f25637H, true);
        Hicore.getApp().registerPhoneStateListener();
        super.onBackPressed();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 156) {
            return;
        }
        showWindowAlpha(false);
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mOpenCount = "";
        this.mOldShowCount = -1;
        if (C7328v1.m26654b(getApplicationContext(), C4443d.f16961j)) {
            stopService(new Intent(this, (Class<?>) WarnGuidService.class));
        }
        C7337y1.f25731b.postDelayed(new Runnable() { // from class: ui.activity.n1
            @Override // java.lang.Runnable
            public final void run() {
                WarnPrimessActivity.this.m25411a();
            }
        }, 500L);
        openState(this.mOpenPhone, C7310c.m26520a(this.mActivity, this.permListPhone));
        openState(this.mOpenPhoneRecord, C7310c.m26520a(this.mActivity, this.permListRecord));
        openState(this.mOpenSms, C7310c.m26520a(this.mActivity, this.permListSms));
        openStateNotNecessary(this.mOpenAuto, C7325u1.m26623a(C7325u1.f25639I, false));
        openStateNotNecessary(this.mOpenPower, C7325u1.m26623a(C7325u1.f25641J, false));
        openStateNotNecessary(this.mOpenLock, C7325u1.m26623a(C7325u1.f25643K, false));
        if (this.mCurrentCode == 10005) {
            this.mCurrentCode = -1;
            openDialog("自启动", C7325u1.f25639I, this.mOpenAuto);
        }
        if (this.mCurrentCode == 10006) {
            this.mCurrentCode = -1;
            openDialog("耗电保护", C7325u1.f25641J, this.mOpenPower);
        }
        if (this.mCurrentCode == 10007) {
            this.mCurrentCode = -1;
            openDialog("应用锁", C7325u1.f25643K, this.mOpenLock);
        }
    }

    @Override // p388ui.callview.WarnPrimessCallView
    public void onSuccessRequest(HashMap<String, GuideBean> hashMap) {
        this.mGuideMap = hashMap;
        if (this.mBasePresenter.isOpenFlowPrim()) {
            showWindowAlpha(false);
        } else {
            this.mCurrentCode = 10001;
            intentNextFlow();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.open_flow, C2113R.id.open_phone, C2113R.id.open_phone_record, C2113R.id.open_sms, C2113R.id.open_auto, C2113R.id.open_power, C2113R.id.open_lock, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            onBackPressed();
            return;
        }
        if (id == C2113R.id.iv_back) {
            onBackPressed();
            return;
        }
        switch (id) {
            case C2113R.id.open_auto /* 2131297057 */:
                this.mCurrentCode = GuideBean.GUIDE_CODE_AUTO;
                intentNext();
                break;
            case C2113R.id.open_flow /* 2131297058 */:
                this.mCurrentCode = 10001;
                BottomSheetDialog bottomSheetDialog = this.mBottomSheetDialog;
                if (bottomSheetDialog != null) {
                    bottomSheetDialog.show();
                    break;
                } else {
                    this.mWarnPresenter.requestGuideConfig();
                    break;
                }
            case C2113R.id.open_lock /* 2131297059 */:
                this.mCurrentCode = 10007;
                intentNext();
                break;
            case C2113R.id.open_phone /* 2131297060 */:
            case C2113R.id.open_phone_record /* 2131297061 */:
            case C2113R.id.open_sms /* 2131297063 */:
                checkPermission(this.permListNormal);
                break;
            case C2113R.id.open_power /* 2131297062 */:
                this.mCurrentCode = 10006;
                intentNext();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        showWindowAlpha(true);
        return C2113R.layout.activity_warn_primess;
    }

    private void openState(TextView textView, boolean z, boolean z2, String str) {
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setEnabled(false);
            textView.setText("已开启");
            textView.setTextColor(getResources().getColor(C2113R.color.colorGray));
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setBackgroundResource(C2113R.drawable.shape_gray_3);
            if (!z2 || TextUtils.isEmpty(str) || this.mOpenCount.contains(str)) {
                return;
            }
            this.mOpenCount += str;
            return;
        }
        textView.setEnabled(true);
        textView.setText("去开启");
        textView.setTextColor(getResources().getColor(C2113R.color.blue));
        textView.setBackgroundResource(C2113R.drawable.shape_blue_3);
    }
}
