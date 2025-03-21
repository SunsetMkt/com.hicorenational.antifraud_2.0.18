package p388ui.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bean.GuideBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.hicorenational.antifraud.service.WarnGuidService;
import interfaces.IOneClickListener;
import org.greenrobot.eventbus.C6049c;
import p245d.C4443d;
import p357j.C5845d;
import p388ui.Hicore;
import p388ui.presenter.BasePagePresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7328v1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class WarnGuideActivity extends BaseActivity {

    /* renamed from: d */
    BasePagePresenter f23444d;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.iv_warn_guide)
    ImageView mIvWarnGuide;

    @BindView(C2113R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: a */
    private ServiceConnection f23441a = null;

    /* renamed from: b */
    private int f23442b = -1;

    /* renamed from: c */
    private GuideBean f23443c = null;

    /* renamed from: e */
    private boolean f23445e = false;

    /* renamed from: ui.activity.WarnGuideActivity$a */
    class ServiceConnectionC6686a implements ServiceConnection {
        ServiceConnectionC6686a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: ui.activity.WarnGuideActivity$b */
    class C6687b implements IOneClickListener {
        C6687b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
        }
    }

    /* renamed from: a */
    private void m25408a() {
        this.f23441a = new ServiceConnectionC6686a();
        Intent intent = new Intent(this, (Class<?>) WarnGuidService.class);
        bindService(intent, this.f23441a, 1);
        GuideBean guideBean = this.f23443c;
        if (guideBean != null) {
            intent.putExtra(WarnGuidService.f6337w, guideBean.getContent());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    /* renamed from: b */
    private void m25409b() {
        switch (this.f23442b) {
            case 10001:
                this.f23445e = true;
                if (!Build.BRAND.equalsIgnoreCase("vivo")) {
                    this.f23444d.checkOtherPerssion(null);
                    break;
                } else if (!C7292k1.m26399c(this.mActivity)) {
                    C7292k1.m26401e(this.mActivity);
                    break;
                }
                break;
            case 10002:
            case 10003:
            case GuideBean.GUIDE_CODE_SMS /* 10004 */:
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + Hicore.getApp().getPackageName()));
                startActivity(intent);
                break;
            case GuideBean.GUIDE_CODE_AUTO /* 10005 */:
                C7328v1.m26667h(this.mActivity);
                break;
            case 10006:
                C7328v1.m26665g(this.mActivity);
                break;
            case 10007:
                m25410c();
                break;
        }
    }

    /* renamed from: c */
    private void m25410c() {
        C7257b1.m26210b(this.mActivity, "请手动前往系统设置，完成开启", "确定", new C6687b());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, false);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mRlTitle.setBackgroundColor(getResources().getColor(C2113R.color.blue));
        this.f23444d = new BasePagePresenter(this.mActivity);
        try {
            this.f23442b = getIntent().getIntExtra(WarnPrimessActivity.EXTRA_GUIDE_CODE, -1);
            this.f23443c = (GuideBean) getIntent().getSerializableExtra(WarnPrimessActivity.EXTRA_GUIDE_DATA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        GuideBean guideBean = this.f23443c;
        if (guideBean != null) {
            C5845d.m24610a(guideBean.getImgUrl(), this.mIvWarnGuide, Integer.valueOf(C2113R.drawable.iv_blue_bg));
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ServiceConnection serviceConnection = this.f23441a;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
            this.f23441a = null;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C6049c.m24987f().m25000d(new C7265a(156, null));
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C7328v1.m26654b(getApplicationContext(), C4443d.f16961j)) {
            stopService(new Intent(this, (Class<?>) WarnGuidService.class));
            finish();
        } else if (this.f23442b == 10001 && this.f23445e) {
            this.f23445e = false;
            this.f23442b = -1;
            finish();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_go_setting})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
            return;
        }
        if (id != C2113R.id.tv_go_setting) {
            return;
        }
        int i2 = this.f23442b;
        if (i2 != 10001 && i2 != 10007) {
            m25408a();
        }
        m25409b();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_warn_guide;
    }
}
