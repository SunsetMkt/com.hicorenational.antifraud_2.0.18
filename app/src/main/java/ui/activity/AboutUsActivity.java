package ui.activity;

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
import com.hicorenational.antifraud.R;
import interfaces.IBaseBeanCall;
import network.DownloadInfo;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.AboutUsView;
import ui.presenter.AboutUsPresenter;
import ui.presenter.WelocmPresenter;
import ui.view.swip.SwipBackLayout;
import util.UpdateUtil;
import util.e2;
import util.x1;

/* JADX INFO: loaded from: classes2.dex */
public class AboutUsActivity extends BaseActivity implements AboutUsView {

    @BindView(R.id.check_upadte)
    Button mChenkBtn;
    AboutUsPresenter mPresent;

    @BindView(R.id.tv_new_tips)
    TextView mTvAppTip;

    @BindView(R.id.tv_app_version)
    TextView mTvAppVersion;

    @BindView(R.id.tv_owner_tip)
    TextView mTvOwnerTip;

    @BindView(R.id.tv_sdk_version)
    TextView mTvSdk;

    @BindView(R.id.tv_tech_sup)
    TextView mTvTechSupor;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements IBaseBeanCall<APIresult<DownloadInfo>> {
        a() {
        }

        @Override // interfaces.IBaseBeanCall
        public void onClose() {
        }

        @Override // interfaces.IBaseBeanCall
        public void onfail() {
            e2.a("\u5df2\u662f\u6700\u65b0\u7248\u672c");
        }

        @Override // interfaces.IBaseBeanCall
        public void onsuccess(APIresult<DownloadInfo> aPIresult) {
            util.f1.a();
        }
    }

    public static void callPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    private void testTip() {
        String str;
        if (!com.hicorenational.antifraud.a.f3991n.booleanValue()) {
            this.mTvSdk.setVisibility(8);
            return;
        }
        this.mTvSdk.setVisibility(0);
        try {
            str = x1.f() + "";
        } catch (Exception e2) {
            e2.printStackTrace();
            str = b.a.u.a.f1912n;
        }
        this.mTvSdk.setText("\u56fd\u5bb6\u53cd\u8bc8v2.0.17.0224.149(code " + str + ")\n" + ("\u6e20\u9053\uff1a" + Hicore.getApp().getChannel()) + d.c.a.b.a.a.f10074g + com.hicorenational.antifraud.a.o + "release");
    }

    private void updateDlg() {
        util.f1.a("\u68c0\u6d4b\u4e2d...", true, this.mActivity);
        UpdateUtil.updateAppOnly(this.mActivity, new a());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, false);
        this.mTvTitle.setText("\u5173\u4e8e\u6211\u4eec");
        this.mPresent = new AboutUsPresenter(this.mActivity, this);
        String strB = x1.b(this);
        this.mTvAppVersion.setText("v" + strB);
        testTip();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.ll_agreement, R.id.ll_policy, R.id.check_upadte})
    public void onViewClicked(View view) {
        String str;
        String str2;
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.check_upadte /* 2131296459 */:
                updateDlg();
                break;
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.ll_agreement /* 2131296966 */:
                if (TextUtils.isEmpty(WelocmPresenter.XY_service)) {
                    str = e.a.f10142f + f.b.y;
                } else {
                    str = WelocmPresenter.XY_service;
                }
                String str3 = str + "?time=" + e.a.m();
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(util.p1.P, "\u670d\u52a1\u534f\u8bae");
                intent.putExtra(util.p1.Q, str3);
                startActivity(intent);
                break;
            case R.id.ll_policy /* 2131297016 */:
                if (TextUtils.isEmpty(WelocmPresenter.XY_conceal)) {
                    str2 = e.a.f10142f + f.b.x;
                } else {
                    str2 = WelocmPresenter.XY_conceal;
                }
                String str4 = str2 + "?time=" + e.a.m();
                Intent intent2 = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent2.putExtra(util.p1.P, "\u9690\u79c1\u653f\u7b56");
                intent2.putExtra(util.p1.Q, str4);
                startActivity(intent2);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_about_us;
    }
}
