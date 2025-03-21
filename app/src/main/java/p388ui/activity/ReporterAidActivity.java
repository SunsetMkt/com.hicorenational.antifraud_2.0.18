package p388ui.activity;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import bean.ReportIDInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.List;
import network.http.StatisticsHttp;
import p247e.C4447d;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ReportIDInfoView;
import p388ui.presenter.SurveyReportPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7301n1;
import util.C7331w1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;
import zxing.android.CaptureActivity;

/* compiled from: ReporterAidActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020,H\u0002J\u0006\u00102\u001a\u00020,J\b\u00103\u001a\u00020,H\u0016J\"\u00104\u001a\u00020,2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0007J\b\u0010=\u001a\u00020,H\u0014J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u000206H\u0016J\b\u0010@\u001a\u00020,H\u0016J\b\u0010A\u001a\u00020,H\u0016J\b\u0010B\u001a\u000206H\u0016J\b\u0010C\u001a\u00020,H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006D"}, m23546d2 = {"Lui/activity/ReporterAidActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportIDInfoView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresent", "Lui/presenter/SurveyReportPresenter;", "getMPresent", "()Lui/presenter/SurveyReportPresenter;", "setMPresent", "(Lui/presenter/SurveyReportPresenter;)V", "mRedDot", "getMRedDot", "setMRedDot", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "reportIDBean", "Lbean/ReportIDInfoBean;", "getReportIDBean", "()Lbean/ReportIDInfoBean;", "setReportIDBean", "(Lbean/ReportIDInfoBean;)V", "ReportIDInfoBean", "", "result", "camerPrimssDlg", "isNeverAsk", "", "goScan", "initListener", "initPage", "onActivityResult", "requestCode", "", AbstractC3059b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onClick", "view", "Landroid/view/View;", "onResume", "onSuccessCaseNum", "num", "onfailCaseNum", "onsuccessReportID", "setLayoutView", "varCamerPrims", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReporterAidActivity extends BaseActivity implements ReportIDInfoView {

    @InterfaceC5817e
    private String caseInfoId;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private SurveyReportPresenter mPresent;

    @BindView(C2113R.id.iv_red_dot)
    @InterfaceC5816d
    public ImageView mRedDot;

    @BindView(C2113R.id.cb_select)
    @InterfaceC5816d
    public CheckBox mTCbSelect;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5817e
    private ReportIDInfoBean reportIDBean;

    /* compiled from: ReporterAidActivity.kt */
    /* renamed from: ui.activity.ReporterAidActivity$a */
    public static final class C6547a implements IClickListener {
        C6547a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            SurveyReportPresenter mPresent = ReporterAidActivity.this.getMPresent();
            if (mPresent != null) {
                mPresent.ConfirmCaseInfoById(ReporterAidActivity.this.getCaseInfoId());
            }
        }
    }

    /* compiled from: ReporterAidActivity.kt */
    /* renamed from: ui.activity.ReporterAidActivity$b */
    public static final class C6548b implements IClickListener {

        /* renamed from: b */
        final /* synthetic */ boolean f23005b;

        C6548b(boolean z) {
            this.f23005b = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f23005b) {
                C7292k1.m26406j(ReporterAidActivity.this.mActivity);
            } else {
                ReporterAidActivity.this.varCamerPrims();
            }
        }
    }

    /* compiled from: ReporterAidActivity.kt */
    /* renamed from: ui.activity.ReporterAidActivity$c */
    static final class C6549c implements CompoundButton.OnCheckedChangeListener {
        C6549c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ReporterAidActivity.this.getMTCbSelect().setChecked(z);
        }
    }

    /* compiled from: ReporterAidActivity.kt */
    /* renamed from: ui.activity.ReporterAidActivity$d */
    public static final class C6550d implements PermissionsListener {
        C6550d() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@InterfaceC5816d List<String> list, boolean z) {
            C5544i0.m22546f(list, "deniedPermissions");
            ReporterAidActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!C5544i0.m22531a((Object) "vivo", (Object) Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                ReporterAidActivity.this.goScan();
            } else if (C7310c.m26526f()) {
                ReporterAidActivity.this.goScan();
            } else {
                ReporterAidActivity.this.camerPrimssDlg(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void camerPrimssDlg(boolean z) {
        C7257b1.m26230f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new C6548b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goScan() {
        startActivityForResult(new Intent(this.mActivity, (Class<?>) CaptureActivity.class), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void varCamerPrims() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25524c}, new C6550d());
    }

    @Override // p388ui.callview.ReportIDInfoView
    public void ReportIDInfoBean(@InterfaceC5817e ReportIDInfoBean reportIDInfoBean) {
        this.reportIDBean = reportIDInfoBean;
        C7257b1.m26224d(this.mActivity, reportIDInfoBean != null ? reportIDInfoBean.getCaseName() : null, reportIDInfoBean != null ? reportIDInfoBean.getProcessTime() : null, reportIDInfoBean != null ? reportIDInfoBean.getCaseNumber() : null, reportIDInfoBean != null ? reportIDInfoBean.getCaseCategoryText() : null, new C6547a());
    }

    @InterfaceC5817e
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5817e
    public final SurveyReportPresenter getMPresent() {
        return this.mPresent;
    }

    @InterfaceC5816d
    public final ImageView getMRedDot() {
        ImageView imageView = this.mRedDot;
        if (imageView == null) {
            C5544i0.m22554k("mRedDot");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        return checkBox;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5817e
    public final ReportIDInfoBean getReportIDBean() {
        return this.reportIDBean;
    }

    public final void initListener() {
        this.mPresent = new SurveyReportPresenter(this, this);
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        checkBox.setOnCheckedChangeListener(new C6549c());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17166m);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        initListener();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("报案助手");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @InterfaceC5817e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra(CaptureActivity.f25793l);
            C7301n1.m26453a("content==" + stringExtra);
            if (TextUtils.isEmpty(stringExtra)) {
                C7331w1.m26688a("二维码错误或已过期");
                return;
            }
            this.caseInfoId = stringExtra;
            SurveyReportPresenter surveyReportPresenter = this.mPresent;
            if (surveyReportPresenter != null) {
                surveyReportPresenter.getCaseInfoById(this.caseInfoId);
            }
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_report_record, C2113R.id.tv_rule, C2113R.id.fl_confirm})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.fl_confirm /* 2131296626 */:
                varCamerPrims();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.tv_report_record /* 2131297690 */:
                startActivity(new Intent(this.mActivity, (Class<?>) ReportRecordsActivity.class));
                break;
            case C2113R.id.tv_rule /* 2131297695 */:
                startActivity(new Intent(this.mActivity, (Class<?>) SurveyDealActivity.class));
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        SurveyReportPresenter surveyReportPresenter = this.mPresent;
        if (surveyReportPresenter != null) {
            surveyReportPresenter.getCaseBankNum();
        }
    }

    @Override // p388ui.callview.ReportIDInfoView
    public void onSuccessCaseNum(int i2) {
        if (i2 > 0) {
            ImageView imageView = this.mRedDot;
            if (imageView == null) {
                C5544i0.m22554k("mRedDot");
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = this.mRedDot;
        if (imageView2 == null) {
            C5544i0.m22554k("mRedDot");
        }
        imageView2.setVisibility(8);
    }

    @Override // p388ui.callview.ReportIDInfoView
    public void onfailCaseNum() {
        ImageView imageView = this.mRedDot;
        if (imageView == null) {
            C5544i0.m22554k("mRedDot");
        }
        imageView.setVisibility(8);
    }

    @Override // p388ui.callview.ReportIDInfoView
    public void onsuccessReportID() {
        Intent intent = new Intent(this.mActivity, (Class<?>) ReportCaseInfoActivity.class);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        intent.putExtra(C7292k1.f25388b, this.reportIDBean);
        startActivity(intent);
    }

    public final void setCaseInfoId(@InterfaceC5817e String str) {
        this.caseInfoId = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_aid_report;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresent(@InterfaceC5817e SurveyReportPresenter surveyReportPresenter) {
        this.mPresent = surveyReportPresenter;
    }

    public final void setMRedDot(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mRedDot = imageView;
    }

    public final void setMTCbSelect(@InterfaceC5816d CheckBox checkBox) {
        C5544i0.m22546f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setReportIDBean(@InterfaceC5817e ReportIDInfoBean reportIDInfoBean) {
        this.reportIDBean = reportIDInfoBean;
    }
}
