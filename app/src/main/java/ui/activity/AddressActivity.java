package ui.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IResultCallback;
import java.util.ArrayList;
import manager.AccountManager;
import network.account.AccountInfo;
import network.http.AddressHttp;
import network.http.RegionConfigHttp;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.AddressCallview;
import ui.presenter.AddressPresenter;
import ui.presenter.RegisterPresenter;
import ui.view.RegionWheelView;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class AddressActivity extends BaseActivity {
    protected c.a.a.d.e a = null;

    /* JADX INFO: renamed from: b */
    protected c.a.a.d.d f13081b = null;

    /* JADX INFO: renamed from: c */
    protected int f13082c;

    /* JADX INFO: renamed from: d */
    private AddressPresenter f13083d;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.ll_region)
    RegionWheelView mLlRegion;

    class a extends AddressHttp.MyPicker {
        a() {
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onData(ArrayList<c.a.a.d.k> arrayList) {
            if (AddressActivity.this.mLlRegion == null || 1 >= AddressHttp.getMaxAddressVersion()) {
                return;
            }
            AddressActivity.this.mLlRegion.a(arrayList);
        }
    }

    class b implements AddressCallview {
        b() {
        }

        @Override // ui.callview.AddressCallview
        public void onSuccessRegister(@j.c.a.d AccountInfo accountInfo, @j.c.a.d String str, @j.c.a.d String str2) {
            if (accountInfo != null) {
                accountInfo.setRegisterRegionName(str);
                accountInfo.setRegisterRegionCode(str2);
                AccountManager.saveAccount(accountInfo);
            }
            ui.c.i().e();
            g2.a((Context) AddressActivity.this.mActivity, (Class<?>) MainActivity.class);
            AddressActivity.this.finish();
        }
    }

    private void b() {
        int i2 = this.f13082c;
        if ((i2 == 1 || i2 == 5) && this.f13083d == null) {
            this.f13083d = new AddressPresenter(this.mActivity, new b());
        }
    }

    public /* synthetic */ void a(RegionMudelBean regionMudelBean) {
        startActivity(RegisterActivity.class);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10206f);
        this.f13082c = getIntent().getIntExtra(util.p1.X0, 0);
        AddressHttp.getAddSint(this.mActivity).getPickData(new a());
        getPushData();
        b();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 211) {
            return;
        }
        finish();
    }

    @OnClick({R.id.confirm})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (!isDouble() && view.getId() == R.id.confirm) {
            this.a = this.mLlRegion.getCounty();
            this.f13081b = this.mLlRegion.getCity();
            c.a.a.d.e eVar = this.a;
            if (eVar == null || TextUtils.isEmpty(eVar.getAreaId())) {
                e2.a("\u8bf7\u9009\u62e9\u60a8\u7684\u6ce8\u518c\u5730\u533a");
                return;
            }
            RegionConfigHttp.setNodeRegion(this.mLlRegion.getSelectedProvince().getAreaName(), this.a.getAreaName(), this.a.getAreaId());
            int i2 = this.f13082c;
            if (i2 == 1) {
                a();
                return;
            }
            if (i2 == 5) {
                a();
                return;
            }
            if (i2 == 6) {
                a();
            } else if (i2 == 3) {
                finish();
            } else {
                LocalModuelConfig.getInstance().getConfigMude(this.a.getAreaId(), new IResultCallback() { // from class: ui.activity.c
                    @Override // interfaces.IResultCallback
                    public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                        this.a.a(regionMudelBean);
                    }
                });
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_address;
    }

    private void a() {
        final AccountInfo accountInfo = (AccountInfo) getIntent().getSerializableExtra(util.p1.f15011c);
        LocalModuelConfig.getInstance().getConfigMude(this.a.getAreaId(), new IResultCallback() { // from class: ui.activity.d
            @Override // interfaces.IResultCallback
            public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                this.a.a(accountInfo, regionMudelBean);
            }
        });
    }

    public /* synthetic */ void a(AccountInfo accountInfo, RegionMudelBean regionMudelBean) {
        AddressPresenter addressPresenter;
        int i2 = this.f13082c;
        if (i2 == 6) {
            new RegisterPresenter(this.mActivity, null).silentlyreg(accountInfo);
        } else {
            if ((i2 != 1 && i2 != 5) || (addressPresenter = this.f13083d) == null || accountInfo == null) {
                return;
            }
            addressPresenter.addRegisterRegion(accountInfo, this.a.getAreaName(), this.a.getAreaId());
        }
    }
}
