package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import java.io.File;
import java.util.ArrayList;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import p388ui.callview.VirusKillingCallView;
import p388ui.presenter.VirusKillingPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7316r1;
import util.C7328v1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class VirusDetailActivity extends BaseActivity {

    /* renamed from: a */
    private AppInfoBean f23391a = null;

    /* renamed from: b */
    private VirusKillingPresenter f23392b = null;

    @BindView(C2113R.id.imageview)
    ImageView mImageview;

    @BindView(C2113R.id.tv_app_name)
    TextView mTvAppName;

    @BindView(C2113R.id.tv_app_version)
    TextView mTvAppVersion;

    @BindView(C2113R.id.tv_delete)
    TextView mTvDelete;

    @BindView(C2113R.id.tv_describe)
    TextView mTvDescribe;

    @BindView(C2113R.id.tv_risk_flag)
    TextView mTvRiskFlag;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.tv_name)
    TextView mTvVirusName;

    /* renamed from: ui.activity.VirusDetailActivity$a */
    class C6664a implements VirusKillingCallView {
        C6664a() {
        }

        @Override // p388ui.callview.VirusKillingCallView
        public void onAppealSuccess() {
            C7257b1.m26186a((Activity) VirusDetailActivity.this, false, 1, "错误信息上报成功", C2113R.drawable.iv_comit_succ);
        }
    }

    /* renamed from: ui.activity.VirusDetailActivity$b */
    class C6665b implements IClickListener {
        C6665b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ArrayList arrayList = new ArrayList();
            AppVirusBean appVirusBean = new AppVirusBean();
            appVirusBean.setAppName(VirusDetailActivity.this.f23391a.getName());
            appVirusBean.setFileMd5(VirusDetailActivity.this.f23391a.getAppMD5());
            appVirusBean.setVersionCode(VirusDetailActivity.this.f23391a.getVersionCode() + "");
            appVirusBean.setPkgName(VirusDetailActivity.this.f23391a.getPkgName());
            appVirusBean.setSignHash(VirusDetailActivity.this.f23391a.getSignHash());
            appVirusBean.setFindTime(C7328v1.m26646a(System.currentTimeMillis()));
            appVirusBean.setVirusDescription(VirusDetailActivity.this.f23391a.getVirusDescription());
            appVirusBean.setVirusName(VirusDetailActivity.this.f23391a.getVirusName());
            int virusLevel = VirusDetailActivity.this.f23391a.getVirusLevel();
            if (virusLevel == 1) {
                appVirusBean.setVirusLevel(1);
                appVirusBean.setIllegalType("病毒");
            } else if (virusLevel == 2) {
                appVirusBean.setVirusLevel(2);
                appVirusBean.setIllegalType("风险");
            }
            arrayList.add(appVirusBean);
            VirusDetailActivity.this.f23392b.appealApp(arrayList);
        }
    }

    /* renamed from: ui.activity.VirusDetailActivity$c */
    class C6666c implements IOneClickListener {
        C6666c() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            VirusDetailActivity.this.m25398a();
        }
    }

    private void appealSelect() {
        C7257b1.m26183a(this.mActivity, "确定上报应用错误信息吗", "", "取消", "确定", C2113R.color._A8B4F7, C2113R.color.blue_dark, (IClickListener) new C6665b());
    }

    private void deleteSelect() {
        AppInfoBean appInfoBean = this.f23391a;
        if (appInfoBean == null) {
            return;
        }
        if (appInfoBean.isTypeIsApp()) {
            uninstall(this.f23391a.getPkgName());
            return;
        }
        File file = new File(this.f23391a.getPkgPath());
        try {
            if (file.exists() && file.isFile() && file.delete()) {
                C7257b1.m26210b(this.mActivity, "已删除“" + this.f23391a.getName() + "”安装包", "确定", new C6666c());
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

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("风险详情");
        C6049c.m24987f().m25001e(this);
        AppInfoBean appInfoBean = VirusKillingActivity.mIntentBean;
        if (appInfoBean != null) {
            this.f23391a = appInfoBean;
            if (this.f23391a.isTypeIsApp()) {
                this.mTvDelete.setText("卸载应用");
            } else {
                this.mTvDelete.setText("删除安装包");
            }
            if (this.f23391a.getVirusLevel() == 1) {
                this.mTvRiskFlag.setText("高危");
                this.mTvRiskFlag.setTextColor(getResources().getColor(C2113R.color.colorRedRiskFlag));
                this.mTvRiskFlag.setBackgroundResource(C2113R.drawable.shape_red);
            } else {
                this.mTvRiskFlag.setText("风险");
                this.mTvRiskFlag.setTextColor(getResources().getColor(C2113R.color.dark_orange));
                this.mTvRiskFlag.setBackgroundResource(C2113R.drawable.shape_orange);
            }
            this.mImageview.setImageDrawable(this.f23391a.getAppIcon());
            this.mTvAppName.setText(this.f23391a.getName());
            this.mTvAppVersion.setText("版本号：" + this.f23391a.getVersionName());
            this.mTvVirusName.setText(this.f23391a.getDealVirusName());
            this.mTvDescribe.setText(this.f23391a.getDealVirusDescription());
        }
        this.f23392b = new VirusKillingPresenter((Activity) this, (VirusKillingCallView) new C6664a());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        AppInfoBean appInfoBean;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1000 || (appInfoBean = this.f23391a) == null || C7316r1.m26551d(appInfoBean.getPkgName())) {
            return;
        }
        m25398a();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventWornThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 26) {
            return;
        }
        C6049c.m24987f().m25002f(c7265a);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_delete, C2113R.id.tv_appeal})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
        } else if (id == C2113R.id.tv_appeal) {
            appealSelect();
        } else {
            if (id != C2113R.id.tv_delete) {
                return;
            }
            deleteSelect();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_risk_detail;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25398a() {
        setResult(-1);
        finish();
    }
}
