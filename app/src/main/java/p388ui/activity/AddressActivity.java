package p388ui.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IResultCallback;
import java.util.ArrayList;
import manager.AccountManager;
import network.account.AccountInfo;
import network.http.AddressHttp;
import network.http.RegionConfigHttp;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p023b.p024a.p025a.p026d.C0906d;
import p023b.p024a.p025a.p026d.C0907e;
import p023b.p024a.p025a.p026d.C0913k;
import p247e.C4447d;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.C6813c;
import p388ui.callview.AddressCallview;
import p388ui.presenter.AddressPresenter;
import p388ui.presenter.RegisterPresenter;
import p388ui.view.RegionWheelView;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class AddressActivity extends BaseActivity {

    /* renamed from: a */
    protected C0907e f21798a = null;

    /* renamed from: b */
    protected C0906d f21799b = null;

    /* renamed from: c */
    protected int f21800c;

    /* renamed from: d */
    private AddressPresenter f21801d;

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.ll_region)
    RegionWheelView mLlRegion;

    /* renamed from: ui.activity.AddressActivity$a */
    class C6117a extends AddressHttp.MyPicker {
        C6117a() {
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onData(ArrayList<C0913k> arrayList) {
            if (AddressActivity.this.mLlRegion == null || 1 >= AddressHttp.getMaxAddressVersion()) {
                return;
            }
            AddressActivity.this.mLlRegion.m25840a(arrayList);
        }
    }

    /* renamed from: ui.activity.AddressActivity$b */
    class C6118b implements AddressCallview {
        C6118b() {
        }

        @Override // p388ui.callview.AddressCallview
        public void onSuccessRegister(@InterfaceC5816d AccountInfo accountInfo, @InterfaceC5816d String str, @InterfaceC5816d String str2) {
            if (accountInfo != null) {
                accountInfo.setRegisterRegionName(str);
                accountInfo.setRegisterRegionCode(str2);
                AccountManager.saveAccount(accountInfo);
            }
            C6813c.m25437i().m25450e();
            C7337y1.m26748a((Context) AddressActivity.this.mActivity, (Class<?>) MainActivity.class);
            AddressActivity.this.finish();
        }
    }

    /* renamed from: b */
    private void m25196b() {
        int i2 = this.f21800c;
        if ((i2 == 1 || i2 == 5) && this.f21801d == null) {
            this.f21801d = new AddressPresenter(this.mActivity, new C6118b());
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25197a(RegionMudelBean regionMudelBean) {
        startActivity(RegisterActivity.class);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17159f);
        this.f21800c = getIntent().getIntExtra(C7292k1.f25380X0, 0);
        AddressHttp.getAddSint(this.mActivity).getPickData(new C6117a());
        getPushData();
        m25196b();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 211) {
            return;
        }
        finish();
    }

    @OnClick({C2113R.id.confirm})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (!isDouble() && view.getId() == C2113R.id.confirm) {
            this.f21798a = this.mLlRegion.getCounty();
            this.f21799b = this.mLlRegion.getCity();
            C0907e c0907e = this.f21798a;
            if (c0907e == null || TextUtils.isEmpty(c0907e.getAreaId())) {
                C7331w1.m26688a("请选择您的注册地区");
                return;
            }
            RegionConfigHttp.setNodeRegion(this.mLlRegion.getSelectedProvince().getAreaName(), this.f21798a.getAreaName(), this.f21798a.getAreaId());
            int i2 = this.f21800c;
            if (i2 == 1) {
                m25195a();
                return;
            }
            if (i2 == 5) {
                m25195a();
                return;
            }
            if (i2 == 6) {
                m25195a();
            } else if (i2 == 3) {
                finish();
            } else {
                LocalModuelConfig.getInstance().getConfigMude(this.f21798a.getAreaId(), new IResultCallback() { // from class: ui.activity.a
                    @Override // interfaces.IResultCallback
                    public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                        AddressActivity.this.m25197a(regionMudelBean);
                    }
                });
            }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_address;
    }

    /* renamed from: a */
    private void m25195a() {
        final AccountInfo accountInfo = (AccountInfo) getIntent().getSerializableExtra(C7292k1.f25391c);
        LocalModuelConfig.getInstance().getConfigMude(this.f21798a.getAreaId(), new IResultCallback() { // from class: ui.activity.b
            @Override // interfaces.IResultCallback
            public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                AddressActivity.this.m25198a(accountInfo, regionMudelBean);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25198a(AccountInfo accountInfo, RegionMudelBean regionMudelBean) {
        AddressPresenter addressPresenter;
        int i2 = this.f21800c;
        if (i2 == 6) {
            new RegisterPresenter(this.mActivity, null).silentlyreg(accountInfo);
        } else {
            if ((i2 != 1 && i2 != 5) || (addressPresenter = this.f21801d) == null || accountInfo == null) {
                return;
            }
            addressPresenter.addRegisterRegion(accountInfo, this.f21798a.getAreaName(), this.f21798a.getAreaId());
        }
    }
}
