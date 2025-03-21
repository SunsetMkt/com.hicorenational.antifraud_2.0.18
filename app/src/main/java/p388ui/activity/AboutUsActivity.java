package p388ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.hicorenational.antifraud.C2114a;
import interfaces.IBaseBeanCall;
import network.DownloadInfo;
import network.account.APIresult;
import p000a.p001a.p014u.C0052a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.Hicore;
import p388ui.callview.AboutUsView;
import p388ui.presenter.AboutUsPresenter;
import p388ui.presenter.WelocmPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7316r1;
import util.C7331w1;
import util.UpdateUtil;

/* loaded from: classes2.dex */
public class AboutUsActivity extends BaseActivity implements AboutUsView {

    @BindView(C2113R.id.check_upadte)
    Button mChenkBtn;
    AboutUsPresenter mPresent;

    @BindView(C2113R.id.tv_new_tips)
    TextView mTvAppTip;

    @BindView(C2113R.id.tv_app_version)
    TextView mTvAppVersion;

    @BindView(C2113R.id.tv_owner_tip)
    TextView mTvOwnerTip;

    @BindView(C2113R.id.tv_sdk_version)
    TextView mTvSdk;

    @BindView(C2113R.id.tv_tech_sup)
    TextView mTvTechSupor;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.AboutUsActivity$a */
    class C6090a implements IBaseBeanCall<APIresult<DownloadInfo>> {
        C6090a() {
        }

        @Override // interfaces.IBaseBeanCall
        public void onClose() {
        }

        @Override // interfaces.IBaseBeanCall
        public void onfail() {
            C7331w1.m26688a("已是最新版本");
        }

        @Override // interfaces.IBaseBeanCall
        public void onsuccess(APIresult<DownloadInfo> aPIresult) {
            C7257b1.m26191a();
        }
    }

    public static void callPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    private void testTip() {
        String str;
        if (!C2114a.f6317n.booleanValue()) {
            this.mTvSdk.setVisibility(8);
            return;
        }
        this.mTvSdk.setVisibility(0);
        try {
            str = C7316r1.m26553f() + "";
        } catch (Exception e2) {
            e2.printStackTrace();
            str = C0052a.f162n;
        }
        this.mTvSdk.setText("国家反诈v2.0.17.0224.149(code " + str + ")\n" + ("渠道：" + Hicore.getApp().getChannel()) + AbstractC1191a.f2568g + C2114a.f6318o + "release");
    }

    private void updateDlg() {
        C7257b1.m26203a("检测中...", true, this.mActivity);
        UpdateUtil.updateAppOnly(this.mActivity, new C6090a());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        C7161b.m25698a((Activity) this, true, false);
        this.mTvTitle.setText("关于我们");
        this.mPresent = new AboutUsPresenter(this.mActivity, this);
        String m26545b = C7316r1.m26545b(this);
        this.mTvAppVersion.setText("v" + m26545b);
        testTip();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_agreement, C2113R.id.ll_policy, C2113R.id.check_upadte})
    public void onViewClicked(View view) {
        String str;
        String str2;
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.check_upadte /* 2131296444 */:
                updateDlg();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.ll_agreement /* 2131296916 */:
                if (TextUtils.isEmpty(WelocmPresenter.XY_service)) {
                    str = C4440a.f16884f + C4445b.f17138x;
                } else {
                    str = WelocmPresenter.XY_service;
                }
                String str3 = str + "?time=" + C4440a.m16411m();
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(C7292k1.f25363P, "服务协议");
                intent.putExtra(C7292k1.f25365Q, str3);
                startActivity(intent);
                break;
            case C2113R.id.ll_policy /* 2131296966 */:
                if (TextUtils.isEmpty(WelocmPresenter.XY_conceal)) {
                    str2 = C4440a.f16884f + C4445b.f17135w;
                } else {
                    str2 = WelocmPresenter.XY_conceal;
                }
                String str4 = str2 + "?time=" + C4440a.m16411m();
                Intent intent2 = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent2.putExtra(C7292k1.f25363P, "隐私政策");
                intent2.putExtra(C7292k1.f25365Q, str4);
                startActivity(intent2);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_about_us;
    }
}
