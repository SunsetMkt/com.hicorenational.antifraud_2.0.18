package p388ui.activity;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bean.RechargeBean;
import bean.RechargePlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import manager.AccountManager;
import p023b.p024a.p025a.p027e.C0918d;
import p023b.p024a.p025a.p027e.C0922h;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.Hicore;
import p388ui.callview.RechargeView;
import p388ui.presenter.RechargePresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;

/* compiled from: RechargeAddActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\u0002062\f\u0010>\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\b\u0010?\u001a\u000206H\u0016J\u0010\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020\"H\u0007J\u0006\u0010B\u001a\u000206J\u0006\u0010C\u001a\u000206J\b\u0010D\u001a\u000206H\u0002J\b\u0010E\u001a\u00020:H\u0016J\u0012\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00050-j\b\u0012\u0004\u0012\u00020\u0005`.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, m23546d2 = {"Lui/activity/RechargeAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RechargeView;", "()V", "caseInfoId", "", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mEtRechargePhone", "Landroid/widget/EditText;", "getMEtRechargePhone", "()Landroid/widget/EditText;", "setMEtRechargePhone", "(Landroid/widget/EditText;)V", "mEtRechargePlat", "Landroid/widget/TextView;", "getMEtRechargePlat", "()Landroid/widget/TextView;", "setMEtRechargePlat", "(Landroid/widget/TextView;)V", "mEtRechargePlatName", "getMEtRechargePlatName", "setMEtRechargePlatName", "mEtRechargeSum", "getMEtRechargeSum", "setMEtRechargeSum", "mEtRechargeTime", "getMEtRechargeTime", "setMEtRechargeTime", "mLlOtherPlatName", "Landroid/view/View;", "getMLlOtherPlatName", "()Landroid/view/View;", "setMLlOtherPlatName", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/RechargePresenter;", "mTvTitle", "getMTvTitle", "setMTvTitle", "pickTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "platList", "", "Lbean/RechargePlatBean;", "platformCode", "rechargeBean", "Lbean/RechargeBean;", "initPage", "", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSuccessPlatList", "list", "onSuccessSave", "onViewClicked", "view", "onkeyback", "redisplayData", "saveHttpApi", "setLayoutView", "showPlatPiker", "tvView", "showTimePiker", "timePk", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RechargeAddActivity extends BaseActivity implements RechargeView {

    @BindView(C2113R.id.btn_confirm)
    @InterfaceC5816d
    public Button mBtnConfirm;

    @BindView(C2113R.id.et_recharge_phone)
    @InterfaceC5816d
    public EditText mEtRechargePhone;

    @BindView(C2113R.id.et_recharge_plat)
    @InterfaceC5816d
    public TextView mEtRechargePlat;

    @BindView(C2113R.id.et_recharge_name)
    @InterfaceC5816d
    public EditText mEtRechargePlatName;

    @BindView(C2113R.id.et_recharge_sum)
    @InterfaceC5816d
    public EditText mEtRechargeSum;

    @BindView(C2113R.id.tv_recharge_time)
    @InterfaceC5816d
    public TextView mEtRechargeTime;

    @BindView(C2113R.id.ll_recharge_plat)
    @InterfaceC5816d
    public View mLlOtherPlatName;
    private RechargePresenter mPresenter;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private List<? extends RechargePlatBean> platList;
    private String platformCode;
    private RechargeBean rechargeBean;
    private String caseInfoId = "";
    private ArrayList<String> pickTypes = new ArrayList<>();

    /* compiled from: RechargeAddActivity.kt */
    /* renamed from: ui.activity.RechargeAddActivity$a */
    public static final class C6459a implements IClickListener {
        C6459a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            RechargeAddActivity.this.saveHttpApi();
        }
    }

    /* compiled from: RechargeAddActivity.kt */
    /* renamed from: ui.activity.RechargeAddActivity$b */
    public static final class C6460b implements IClickListener {
        C6460b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RechargeAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* compiled from: RechargeAddActivity.kt */
    /* renamed from: ui.activity.RechargeAddActivity$c */
    public static final class C6461c extends C0922h.a {

        /* renamed from: b */
        final /* synthetic */ TextView f22773b;

        C6461c(TextView textView) {
            this.f22773b = textView;
        }

        @Override // p023b.p024a.p025a.p027e.C0922h.a
        /* renamed from: b */
        public void mo971b(int i2, @InterfaceC5816d String str) {
            C5544i0.m22546f(str, "item");
            List list = RechargeAddActivity.this.platList;
            if (list == null) {
                C5544i0.m22545f();
            }
            RechargePlatBean rechargePlatBean = (RechargePlatBean) list.get(i2);
            RechargeAddActivity.this.platformCode = rechargePlatBean.getPlatform();
            if (C5544i0.m22531a((Object) rechargePlatBean.getEx(), (Object) "1")) {
                RechargeAddActivity.this.getMLlOtherPlatName().setVisibility(0);
            } else {
                RechargeAddActivity.this.getMLlOtherPlatName().setVisibility(8);
            }
            TextView textView = this.f22773b;
            if (textView == null) {
                C5544i0.m22545f();
            }
            textView.setText(str);
        }
    }

    /* compiled from: RechargeAddActivity.kt */
    /* renamed from: ui.activity.RechargeAddActivity$d */
    static final class C6462d implements C0918d.m {

        /* renamed from: a */
        final /* synthetic */ TextView f22774a;

        C6462d(TextView textView) {
            this.f22774a = textView;
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public final void mo880a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + '-' + str2 + '-' + str3 + ' ' + str4 + ':' + str5;
            TextView textView = this.f22774a;
            if (textView == null) {
                C5544i0.m22545f();
            }
            textView.setText(str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveHttpApi() {
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter == null) {
            C5544i0.m22545f();
        }
        rechargePresenter.saveRechargeTel(this.rechargeBean);
    }

    private final void showPlatPiker(TextView textView) {
        if (this.pickTypes.size() == 0) {
            return;
        }
        C0922h c0922h = new C0922h(this.mActivity, this.pickTypes);
        c0922h.m1017x(3);
        c0922h.m979E(0);
        c0922h.m998C(15);
        c0922h.setOnOptionPickListener(new C6461c(textView));
        c0922h.m1045m();
    }

    private final void showTimePiker(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        C0918d c0918d = new C0918d(this, 0, 3);
        c0918d.mo869g(2018, 2055);
        c0918d.mo860a(i2, i3, i4, i5, i6);
        c0918d.setOnDateTimePickListener(new C6462d(textView));
        c0918d.m1045m();
    }

    @InterfaceC5816d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        return button;
    }

    @InterfaceC5816d
    public final EditText getMEtRechargePhone() {
        EditText editText = this.mEtRechargePhone;
        if (editText == null) {
            C5544i0.m22554k("mEtRechargePhone");
        }
        return editText;
    }

    @InterfaceC5816d
    public final TextView getMEtRechargePlat() {
        TextView textView = this.mEtRechargePlat;
        if (textView == null) {
            C5544i0.m22554k("mEtRechargePlat");
        }
        return textView;
    }

    @InterfaceC5816d
    public final EditText getMEtRechargePlatName() {
        EditText editText = this.mEtRechargePlatName;
        if (editText == null) {
            C5544i0.m22554k("mEtRechargePlatName");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtRechargeSum() {
        EditText editText = this.mEtRechargeSum;
        if (editText == null) {
            C5544i0.m22554k("mEtRechargeSum");
        }
        return editText;
    }

    @InterfaceC5816d
    public final TextView getMEtRechargeTime() {
        TextView textView = this.mEtRechargeTime;
        if (textView == null) {
            C5544i0.m22554k("mEtRechargeTime");
        }
        return textView;
    }

    @InterfaceC5816d
    public final View getMLlOtherPlatName() {
        View view = this.mLlOtherPlatName;
        if (view == null) {
            C5544i0.m22554k("mLlOtherPlatName");
        }
        return view;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mPresenter = new RechargePresenter(this, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("充值类嫌疑人电话详情");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.rechargeBean = (RechargeBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter == null) {
            C5544i0.m22545f();
        }
        rechargePresenter.getPlatList();
        EditText editText = this.mEtRechargeSum;
        if (editText == null) {
            C5544i0.m22554k("mEtRechargeSum");
        }
        C7337y1.m26752a(editText);
    }

    @Override // p388ui.callview.RechargeView
    public void onItemDelet(int i2) {
        RechargeView.C6816a.m25466a(this, i2);
    }

    @Override // p388ui.callview.RechargeView
    public void onItemEdit(int i2) {
        RechargeView.C6816a.m25468b(this, i2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @InterfaceC5816d KeyEvent keyEvent) {
        C5544i0.m22546f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.callview.RechargeView
    public void onSuccessList(@InterfaceC5816d List<? extends RechargeBean> list) {
        C5544i0.m22546f(list, "list");
        RechargeView.C6816a.m25467a(this, list);
    }

    @Override // p388ui.callview.RechargeView
    public void onSuccessPlatList(@InterfaceC5816d List<? extends RechargePlatBean> list) {
        C5544i0.m22546f(list, "list");
        RechargeView.C6816a.m25469b(this, list);
        if (list.size() > 0) {
            this.platList = list;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pickTypes.add(list.get(i2).getPlatformText());
                String platform = list.get(i2).getPlatform();
                RechargeBean rechargeBean = this.rechargeBean;
                if (C5544i0.m22531a((Object) platform, (Object) (rechargeBean != null ? rechargeBean.getPlatform() : null))) {
                    if (C5544i0.m22531a((Object) list.get(i2).getEx(), (Object) "1")) {
                        RechargeBean rechargeBean2 = this.rechargeBean;
                        if (rechargeBean2 == null) {
                            C5544i0.m22545f();
                        }
                        rechargeBean2.setEx(1);
                    } else {
                        RechargeBean rechargeBean3 = this.rechargeBean;
                        if (rechargeBean3 == null) {
                            C5544i0.m22545f();
                        }
                        rechargeBean3.setEx(0);
                    }
                }
            }
            redisplayData();
        }
    }

    @Override // p388ui.callview.RechargeView
    public void onSuccessSave() {
        RechargeBean rechargeBean = this.rechargeBean;
        if (rechargeBean != null) {
            if (rechargeBean == null) {
                C5544i0.m22545f();
            }
            if (!TextUtils.isEmpty(rechargeBean.getChargeTelInfoID())) {
                C7331w1.m26688a("修改成功");
                finish();
            }
        }
        C7331w1.m26688a("添加成功");
        finish();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.et_recharge_plat, C2113R.id.tv_recharge_time, C2113R.id.btn_confirm})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_confirm /* 2131296396 */:
                TextView textView = this.mEtRechargePlat;
                if (textView == null) {
                    C5544i0.m22554k("mEtRechargePlat");
                }
                if (textView == null) {
                    C5544i0.m22545f();
                }
                String obj = textView.getText().toString();
                EditText editText = this.mEtRechargePlatName;
                if (editText == null) {
                    C5544i0.m22554k("mEtRechargePlatName");
                }
                if (editText == null) {
                    C5544i0.m22545f();
                }
                String obj2 = editText.getText().toString();
                EditText editText2 = this.mEtRechargePhone;
                if (editText2 == null) {
                    C5544i0.m22554k("mEtRechargePhone");
                }
                if (editText2 == null) {
                    C5544i0.m22545f();
                }
                String obj3 = editText2.getText().toString();
                EditText editText3 = this.mEtRechargeSum;
                if (editText3 == null) {
                    C5544i0.m22554k("mEtRechargeSum");
                }
                if (editText3 == null) {
                    C5544i0.m22545f();
                }
                String obj4 = editText3.getText().toString();
                TextView textView2 = this.mEtRechargeTime;
                if (textView2 == null) {
                    C5544i0.m22554k("mEtRechargeTime");
                }
                if (textView2 == null) {
                    C5544i0.m22545f();
                }
                String obj5 = textView2.getText().toString();
                View view2 = this.mLlOtherPlatName;
                if (view2 == null) {
                    C5544i0.m22554k("mLlOtherPlatName");
                }
                if (view2.isShown()) {
                    if (obj2.length() == 0) {
                        C7331w1.m26688a("请输入充值平台名称");
                        break;
                    }
                }
                if (!(obj.length() == 0)) {
                    if (!(obj3.length() == 0)) {
                        if (!(obj4.length() == 0)) {
                            if (!(obj5.length() == 0)) {
                                RechargeBean rechargeBean = this.rechargeBean;
                                if (rechargeBean == null) {
                                    this.rechargeBean = new RechargeBean();
                                    RechargeBean rechargeBean2 = this.rechargeBean;
                                    if (rechargeBean2 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean2.setCaseInfoID(this.caseInfoId);
                                    RechargeBean rechargeBean3 = this.rechargeBean;
                                    if (rechargeBean3 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean3.setPlatform(this.platformCode);
                                    View view3 = this.mLlOtherPlatName;
                                    if (view3 == null) {
                                        C5544i0.m22554k("mLlOtherPlatName");
                                    }
                                    if (view3.isShown()) {
                                        RechargeBean rechargeBean4 = this.rechargeBean;
                                        if (rechargeBean4 == null) {
                                            C5544i0.m22545f();
                                        }
                                        rechargeBean4.setPlatformText(obj2);
                                    } else {
                                        RechargeBean rechargeBean5 = this.rechargeBean;
                                        if (rechargeBean5 == null) {
                                            C5544i0.m22545f();
                                        }
                                        rechargeBean5.setPlatformText(obj);
                                    }
                                    RechargeBean rechargeBean6 = this.rechargeBean;
                                    if (rechargeBean6 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean6.setSuspectMobile(obj3);
                                    RechargeBean rechargeBean7 = this.rechargeBean;
                                    if (rechargeBean7 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean7.setAmount(obj4);
                                    RechargeBean rechargeBean8 = this.rechargeBean;
                                    if (rechargeBean8 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean8.setChargeTime(obj5);
                                } else {
                                    if (rechargeBean == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean.setCaseInfoID(this.caseInfoId);
                                    RechargeBean rechargeBean9 = this.rechargeBean;
                                    if (rechargeBean9 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean9.setPlatform(this.platformCode);
                                    View view4 = this.mLlOtherPlatName;
                                    if (view4 == null) {
                                        C5544i0.m22554k("mLlOtherPlatName");
                                    }
                                    if (view4.isShown()) {
                                        RechargeBean rechargeBean10 = this.rechargeBean;
                                        if (rechargeBean10 == null) {
                                            C5544i0.m22545f();
                                        }
                                        rechargeBean10.setPlatformText(obj2);
                                    } else {
                                        RechargeBean rechargeBean11 = this.rechargeBean;
                                        if (rechargeBean11 == null) {
                                            C5544i0.m22545f();
                                        }
                                        rechargeBean11.setPlatformText(obj);
                                    }
                                    RechargeBean rechargeBean12 = this.rechargeBean;
                                    if (rechargeBean12 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean12.setSuspectMobile(obj3);
                                    RechargeBean rechargeBean13 = this.rechargeBean;
                                    if (rechargeBean13 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean13.setAmount(obj4);
                                    RechargeBean rechargeBean14 = this.rechargeBean;
                                    if (rechargeBean14 == null) {
                                        C5544i0.m22545f();
                                    }
                                    rechargeBean14.setChargeTime(obj5);
                                }
                                if (!C5544i0.m22531a((Object) obj3, (Object) AccountManager.getVisiblePhone())) {
                                    saveHttpApi();
                                    break;
                                } else {
                                    C7257b1.m26183a(this.mActivity, "添加的充值手机号码是您的登录号码，确定添加个人号码为诈骗号码?", "", "取消", "确定", -1, -1, (IClickListener) new C6459a());
                                    break;
                                }
                            } else {
                                C7331w1.m26688a("请选择充值时间");
                                break;
                            }
                        } else {
                            C7331w1.m26688a("请输入充值金额");
                            break;
                        }
                    } else {
                        C7331w1.m26688a("请填写被充值的手机号码");
                        break;
                    }
                } else {
                    C7331w1.m26688a("请选择充值平台");
                    break;
                }
            case C2113R.id.et_recharge_plat /* 2131296581 */:
                TextView textView3 = this.mEtRechargePlat;
                if (textView3 == null) {
                    C5544i0.m22554k("mEtRechargePlat");
                }
                showPlatPiker(textView3);
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case C2113R.id.tv_recharge_time /* 2131297673 */:
                TextView textView4 = this.mEtRechargeTime;
                if (textView4 == null) {
                    C5544i0.m22554k("mEtRechargeTime");
                }
                showTimePiker(textView4);
                break;
        }
    }

    public final void onkeyback() {
        C7257b1.m26211b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new C6460b());
    }

    public final void redisplayData() {
        EditText editText = this.mEtRechargePhone;
        if (editText == null) {
            C5544i0.m22554k("mEtRechargePhone");
        }
        if (editText == null) {
            C5544i0.m22545f();
        }
        RechargeBean rechargeBean = this.rechargeBean;
        if (rechargeBean == null) {
            C5544i0.m22545f();
        }
        editText.setText(rechargeBean.getSuspectMobile());
        EditText editText2 = this.mEtRechargeSum;
        if (editText2 == null) {
            C5544i0.m22554k("mEtRechargeSum");
        }
        if (editText2 == null) {
            C5544i0.m22545f();
        }
        RechargeBean rechargeBean2 = this.rechargeBean;
        if (rechargeBean2 == null) {
            C5544i0.m22545f();
        }
        editText2.setText(rechargeBean2.getAmount());
        TextView textView = this.mEtRechargeTime;
        if (textView == null) {
            C5544i0.m22554k("mEtRechargeTime");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        RechargeBean rechargeBean3 = this.rechargeBean;
        if (rechargeBean3 == null) {
            C5544i0.m22545f();
        }
        textView.setText(rechargeBean3.getChargeTime());
        RechargeBean rechargeBean4 = this.rechargeBean;
        if (rechargeBean4 == null) {
            C5544i0.m22545f();
        }
        if (rechargeBean4.getEx() == 1) {
            View view = this.mLlOtherPlatName;
            if (view == null) {
                C5544i0.m22554k("mLlOtherPlatName");
            }
            view.setVisibility(0);
            TextView textView2 = this.mEtRechargePlat;
            if (textView2 == null) {
                C5544i0.m22554k("mEtRechargePlat");
            }
            if (textView2 == null) {
                C5544i0.m22545f();
            }
            ArrayList<String> arrayList = this.pickTypes;
            textView2.setText(arrayList.get(arrayList.size() - 1));
            EditText editText3 = this.mEtRechargePlatName;
            if (editText3 == null) {
                C5544i0.m22554k("mEtRechargePlatName");
            }
            if (editText3 == null) {
                C5544i0.m22545f();
            }
            RechargeBean rechargeBean5 = this.rechargeBean;
            if (rechargeBean5 == null) {
                C5544i0.m22545f();
            }
            editText3.setText(rechargeBean5.getPlatformText());
        } else {
            View view2 = this.mLlOtherPlatName;
            if (view2 == null) {
                C5544i0.m22554k("mLlOtherPlatName");
            }
            view2.setVisibility(8);
            TextView textView3 = this.mEtRechargePlat;
            if (textView3 == null) {
                C5544i0.m22554k("mEtRechargePlat");
            }
            if (textView3 == null) {
                C5544i0.m22545f();
            }
            RechargeBean rechargeBean6 = this.rechargeBean;
            if (rechargeBean6 == null) {
                C5544i0.m22545f();
            }
            textView3.setText(rechargeBean6.getPlatformText());
        }
        RechargeBean rechargeBean7 = this.rechargeBean;
        if (rechargeBean7 == null) {
            C5544i0.m22545f();
        }
        this.platformCode = rechargeBean7.getPlatform();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_recharge_add;
    }

    public final void setMBtnConfirm(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtRechargePhone(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtRechargePhone = editText;
    }

    public final void setMEtRechargePlat(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtRechargePlat = textView;
    }

    public final void setMEtRechargePlatName(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtRechargePlatName = editText;
    }

    public final void setMEtRechargeSum(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtRechargeSum = editText;
    }

    public final void setMEtRechargeTime(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtRechargeTime = textView;
    }

    public final void setMLlOtherPlatName(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlOtherPlatName = view;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
