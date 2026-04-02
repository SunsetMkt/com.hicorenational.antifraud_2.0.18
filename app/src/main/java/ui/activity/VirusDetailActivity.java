package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.AppVirusBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import java.io.File;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.VirusKillingCallView;
import ui.presenter.VirusKillingPresenter;
import ui.view.swip.SwipBackLayout;
import util.d2;
import util.x1;

/* JADX INFO: loaded from: classes2.dex */
public class VirusDetailActivity extends BaseActivity {
    private AppInfoBean a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VirusKillingPresenter f13974b = null;

    @BindView(R.id.imageview)
    ImageView mImageview;

    @BindView(R.id.tv_app_name)
    TextView mTvAppName;

    @BindView(R.id.tv_app_version)
    TextView mTvAppVersion;

    @BindView(R.id.tv_delete)
    TextView mTvDelete;

    @BindView(R.id.tv_describe)
    TextView mTvDescribe;

    @BindView(R.id.tv_risk_flag)
    TextView mTvRiskFlag;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_name)
    TextView mTvVirusName;

    class a implements VirusKillingCallView {
        a() {
        }

        @Override // ui.callview.VirusKillingCallView
        public void onAppealSuccess() {
            util.f1.a((Activity) VirusDetailActivity.this, false, 1, "\u9519\u8bef\u4fe1\u606f\u4e0a\u62a5\u6210\u529f", R.drawable.iv_comit_succ);
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ArrayList arrayList = new ArrayList();
            AppVirusBean appVirusBean = new AppVirusBean();
            appVirusBean.setAppName(VirusDetailActivity.this.a.getName());
            appVirusBean.setFileMd5(VirusDetailActivity.this.a.getAppMD5());
            appVirusBean.setVersionCode(VirusDetailActivity.this.a.getVersionCode() + "");
            appVirusBean.setPkgName(VirusDetailActivity.this.a.getPkgName());
            appVirusBean.setSignHash(VirusDetailActivity.this.a.getSignHash());
            appVirusBean.setFindTime(d2.a(System.currentTimeMillis()));
            appVirusBean.setVirusDescription(VirusDetailActivity.this.a.getVirusDescription());
            appVirusBean.setVirusName(VirusDetailActivity.this.a.getVirusName());
            int virusLevel = VirusDetailActivity.this.a.getVirusLevel();
            if (virusLevel == 1) {
                appVirusBean.setVirusLevel(1);
                appVirusBean.setIllegalType("\u75c5\u6bd2");
            } else if (virusLevel == 2) {
                appVirusBean.setVirusLevel(2);
                appVirusBean.setIllegalType("\u98ce\u9669");
            }
            arrayList.add(appVirusBean);
            VirusDetailActivity.this.f13974b.appealApp(arrayList);
        }
    }

    class c implements IOneClickListener {
        c() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            VirusDetailActivity.this.a();
        }
    }

    private void appealSelect() {
        util.f1.a(this.mActivity, "\u786e\u5b9a\u4e0a\u62a5\u5e94\u7528\u9519\u8bef\u4fe1\u606f\u5417", "", "\u53d6\u6d88", "\u786e\u5b9a", R.color._A8B4F7, R.color.blue_dark, (IClickListener) new b());
    }

    private void deleteSelect() {
        AppInfoBean appInfoBean = this.a;
        if (appInfoBean == null) {
            return;
        }
        if (appInfoBean.isTypeIsApp()) {
            uninstall(this.a.getPkgName());
            return;
        }
        File file = new File(this.a.getPkgPath());
        try {
            if (file.exists() && file.isFile() && file.delete()) {
                util.f1.b(this.mActivity, "\u5df2\u5220\u9664\u201c" + this.a.getName() + "\u201d\u5b89\u88c5\u5305", "\u786e\u5b9a", new c());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void uninstall(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        startActivityForResult(intent, 1000);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("\u98ce\u9669\u8be6\u60c5");
        org.greenrobot.eventbus.c.f().e(this);
        AppInfoBean appInfoBean = VirusKillingActivity.mIntentBean;
        if (appInfoBean != null) {
            this.a = appInfoBean;
            if (this.a.isTypeIsApp()) {
                this.mTvDelete.setText("\u5378\u8f7d\u5e94\u7528");
            } else {
                this.mTvDelete.setText("\u5220\u9664\u5b89\u88c5\u5305");
            }
            if (this.a.getVirusLevel() == 1) {
                this.mTvRiskFlag.setText("\u9ad8\u5371");
                this.mTvRiskFlag.setTextColor(getResources().getColor(R.color.colorRedRiskFlag));
                this.mTvRiskFlag.setBackgroundResource(R.drawable.shape_red);
            } else {
                this.mTvRiskFlag.setText("\u98ce\u9669");
                this.mTvRiskFlag.setTextColor(getResources().getColor(R.color.dark_orange));
                this.mTvRiskFlag.setBackgroundResource(R.drawable.shape_orange);
            }
            this.mImageview.setImageDrawable(this.a.getAppIcon());
            this.mTvAppName.setText(this.a.getName());
            this.mTvAppVersion.setText("\u7248\u672c\u53f7\uff1a" + this.a.getVersionName());
            this.mTvVirusName.setText(this.a.getDealVirusName());
            this.mTvDescribe.setText(this.a.getDealVirusDescription());
        }
        this.f13974b = new VirusKillingPresenter((Activity) this, (VirusKillingCallView) new a());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        AppInfoBean appInfoBean;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1000 || (appInfoBean = this.a) == null || x1.d(appInfoBean.getPkgName())) {
            return;
        }
        a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 26) {
            return;
        }
        org.greenrobot.eventbus.c.f().f(aVar);
    }

    @OnClick({R.id.iv_back, R.id.tv_delete, R.id.tv_appeal})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else if (id == R.id.tv_appeal) {
            appealSelect();
        } else {
            if (id != R.id.tv_delete) {
                return;
            }
            deleteSelect();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_risk_detail;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        setResult(-1);
        finish();
    }
}
