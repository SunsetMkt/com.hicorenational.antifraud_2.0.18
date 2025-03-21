package p388ui.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UserInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import manager.AccountManager;
import network.account.APIresult;
import network.http.AddressHttp;
import p023b.p024a.p025a.p026d.C0906d;
import p023b.p024a.p025a.p026d.C0907e;
import p023b.p024a.p025a.p026d.C0913k;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.MinePersonalAddView;
import p388ui.presenter.MinePersonalAddPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7307p1;
import util.C7331w1;

/* compiled from: PersonalInfoAddActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020DJ\b\u0010G\u001a\u00020DH\u0016J\u0010\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0011H\u0007J\u0016\u0010J\u001a\u00020D2\f\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u000205H\u0016J\b\u0010O\u001a\u000205H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u0012\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006Q"}, m23546d2 = {"Lui/activity/PersonalInfoAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/MinePersonalAddView;", "()V", "hasClick", "", "getHasClick", "()Z", "setHasClick", "(Z)V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mClArea", "Landroid/view/View;", "getMClArea", "()Landroid/view/View;", "setMClArea", "(Landroid/view/View;)V", "mClAreaDetail", "getMClAreaDetail", "setMClAreaDetail", "mEtAddres", "Landroid/widget/EditText;", "getMEtAddres", "()Landroid/widget/EditText;", "setMEtAddres", "(Landroid/widget/EditText;)V", "mEtArea", "Landroid/widget/TextView;", "getMEtArea", "()Landroid/widget/TextView;", "setMEtArea", "(Landroid/widget/TextView;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/MinePersonalAddPresenter;", "getMPresenter", "()Lui/presenter/MinePersonalAddPresenter;", "setMPresenter", "(Lui/presenter/MinePersonalAddPresenter;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "pageType", "", "Ljava/lang/Integer;", "regId", "", "getRegId", "()Ljava/lang/String;", "setRegId", "(Ljava/lang/String;)V", "userInfo", "Lbean/UserInfoBean;", "getUserInfo", "()Lbean/UserInfoBean;", "setUserInfo", "(Lbean/UserInfoBean;)V", "area", "", "initIntentData", "initListener", "initPage", "onClick", "view", "onSuccModifyRequest", "resultInfo", "Lnetwork/account/APIresult;", "onSuccUpdateRequest", "page", "setLayoutView", "Companion", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class PersonalInfoAddActivity extends BaseActivity implements MinePersonalAddView {
    public static final int ADDRESS_1 = 1;
    public static final int ADDRESS_11 = 11;
    public static final C6420a Companion = new C6420a(null);
    private boolean hasClick;

    @BindView(C2113R.id.btn_confirm)
    @InterfaceC5816d
    public Button mBtnConfirm;

    @BindView(C2113R.id.cl_area_cont)
    @InterfaceC5816d
    public View mClArea;

    @BindView(C2113R.id.cl_area_detail_content)
    @InterfaceC5816d
    public View mClAreaDetail;

    @BindView(C2113R.id.et_address)
    @InterfaceC5816d
    public EditText mEtAddres;

    @BindView(C2113R.id.et_area)
    @InterfaceC5816d
    public TextView mEtArea;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private MinePersonalAddPresenter mPresenter;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private Integer pageType = 0;

    @InterfaceC5817e
    private String regId;

    @InterfaceC5817e
    private UserInfoBean userInfo;

    /* compiled from: PersonalInfoAddActivity.kt */
    /* renamed from: ui.activity.PersonalInfoAddActivity$a */
    public static final class C6420a {
        private C6420a() {
        }

        public /* synthetic */ C6420a(C5586v c5586v) {
            this();
        }
    }

    /* compiled from: PersonalInfoAddActivity.kt */
    /* renamed from: ui.activity.PersonalInfoAddActivity$b */
    public static final class C6421b extends AddressHttp.MyPicker {
        C6421b() {
        }

        @Override // network.http.AddressHttp.MyPicker, p023b.p024a.p025a.p027e.C0915a.e
        public void onAddressPicked(@InterfaceC5817e C0913k c0913k, @InterfaceC5817e C0906d c0906d, @InterfaceC5817e C0907e c0907e) {
            if (c0913k == null || c0906d == null || c0907e == null) {
                TextView mEtArea = PersonalInfoAddActivity.this.getMEtArea();
                if (mEtArea != null) {
                    mEtArea.setText("");
                    return;
                }
                return;
            }
            PersonalInfoAddActivity.this.setRegId(c0907e.getAreaId());
            String str = c0913k.getName() + c0906d.getName() + c0907e.getName();
            TextView mEtArea2 = PersonalInfoAddActivity.this.getMEtArea();
            if (mEtArea2 != null) {
                mEtArea2.setText(str);
            }
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onClear() {
        }
    }

    /* compiled from: PersonalInfoAddActivity.kt */
    /* renamed from: ui.activity.PersonalInfoAddActivity$c */
    static final class ViewOnFocusChangeListenerC6422c implements View.OnFocusChangeListener {
        ViewOnFocusChangeListenerC6422c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            if (!z || PersonalInfoAddActivity.this.getHasClick()) {
                return;
            }
            PersonalInfoAddActivity.this.getMEtAddres().setText("");
            PersonalInfoAddActivity.this.setHasClick(true);
        }
    }

    private final void area() {
        AddressHttp.getAddSint(this.mActivity).regionPickNoClear(new C6421b());
    }

    public final boolean getHasClick() {
        return this.hasClick;
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
    public final View getMClArea() {
        View view = this.mClArea;
        if (view == null) {
            C5544i0.m22554k("mClArea");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMClAreaDetail() {
        View view = this.mClAreaDetail;
        if (view == null) {
            C5544i0.m22554k("mClAreaDetail");
        }
        return view;
    }

    @InterfaceC5816d
    public final EditText getMEtAddres() {
        EditText editText = this.mEtAddres;
        if (editText == null) {
            C5544i0.m22554k("mEtAddres");
        }
        return editText;
    }

    @InterfaceC5816d
    public final TextView getMEtArea() {
        TextView textView = this.mEtArea;
        if (textView == null) {
            C5544i0.m22554k("mEtArea");
        }
        return textView;
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
    public final MinePersonalAddPresenter getMPresenter() {
        return this.mPresenter;
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
    public final String getRegId() {
        return this.regId;
    }

    @InterfaceC5817e
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    public final void initIntentData() {
        this.userInfo = (UserInfoBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.pageType = Integer.valueOf(getIntent().getIntExtra(C7292k1.f25394d, 0));
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            TextView textView = this.mTvTitle;
            if (textView == null) {
                C5544i0.m22554k("mTvTitle");
            }
            if (textView == null) {
                C5544i0.m22545f();
            }
            textView.setText("所在地区");
            View view = this.mClArea;
            if (view == null) {
                C5544i0.m22554k("mClArea");
            }
            if (view == null) {
                C5544i0.m22545f();
            }
            view.setVisibility(0);
            UserInfoBean userInfoBean = this.userInfo;
            if (userInfoBean != null) {
                this.regId = userInfoBean != null ? userInfoBean.getRegionCode() : null;
                TextView textView2 = this.mEtArea;
                if (textView2 == null) {
                    C5544i0.m22554k("mEtArea");
                }
                UserInfoBean userInfoBean2 = this.userInfo;
                textView2.setText(userInfoBean2 != null ? userInfoBean2.getRegion() : null);
                return;
            }
            return;
        }
        Integer num2 = this.pageType;
        if (num2 != null && num2.intValue() == 11) {
            TextView textView3 = this.mTvTitle;
            if (textView3 == null) {
                C5544i0.m22554k("mTvTitle");
            }
            if (textView3 == null) {
                C5544i0.m22545f();
            }
            textView3.setText("详细地址");
            View view2 = this.mClAreaDetail;
            if (view2 == null) {
                C5544i0.m22554k("mClAreaDetail");
            }
            if (view2 == null) {
                C5544i0.m22545f();
            }
            view2.setVisibility(0);
            UserInfoBean userInfoBean3 = this.userInfo;
            if (userInfoBean3 != null) {
                this.regId = userInfoBean3 != null ? userInfoBean3.getRegionCode() : null;
                EditText editText = this.mEtAddres;
                if (editText == null) {
                    C5544i0.m22554k("mEtAddres");
                }
                UserInfoBean userInfoBean4 = this.userInfo;
                editText.setText(userInfoBean4 != null ? userInfoBean4.getAddr() : null);
            }
        }
    }

    public final void initListener() {
        Integer num = this.pageType;
        if (num != null && num.intValue() == 11) {
            EditText editText = this.mEtAddres;
            if (editText == null) {
                C5544i0.m22554k("mEtAddres");
            }
            editText.setOnFocusChangeListener(new ViewOnFocusChangeListenerC6422c());
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mPresenter = new MinePersonalAddPresenter(this.mActivity, this);
        initIntentData();
        initListener();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.et_area, C2113R.id.btn_confirm})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_confirm) {
            if (id == C2113R.id.et_area) {
                area();
                return;
            } else {
                if (id != C2113R.id.iv_back) {
                    return;
                }
                onBackPressed();
                return;
            }
        }
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            TextView textView = this.mEtArea;
            if (textView == null) {
                C5544i0.m22554k("mEtArea");
            }
            if (TextUtils.isEmpty(textView.getText().toString())) {
                C7331w1.m26688a("请选择所在地区");
                return;
            }
            MinePersonalAddPresenter minePersonalAddPresenter = this.mPresenter;
            if (minePersonalAddPresenter != null) {
                Integer num2 = this.pageType;
                if (num2 == null) {
                    C5544i0.m22545f();
                }
                minePersonalAddPresenter.updateUserAddres(num2.intValue(), this.regId, "");
                return;
            }
            return;
        }
        Integer num3 = this.pageType;
        if (num3 != null && num3.intValue() == 11) {
            if (!this.hasClick) {
                onBackPressed();
                return;
            }
            EditText editText = this.mEtAddres;
            if (editText == null) {
                C5544i0.m22554k("mEtAddres");
            }
            String obj = editText.getText().toString();
            if (TextUtils.isEmpty(obj) || C5726c0.m23774c((CharSequence) obj, (CharSequence) "*", false, 2, (Object) null)) {
                C7331w1.m26688a("请输入详细地址");
                return;
            }
            MinePersonalAddPresenter minePersonalAddPresenter2 = this.mPresenter;
            if (minePersonalAddPresenter2 != null) {
                Integer num4 = this.pageType;
                if (num4 == null) {
                    C5544i0.m22545f();
                }
                minePersonalAddPresenter2.updateUserAddres(num4.intValue(), "", obj);
            }
        }
    }

    @Override // p388ui.callview.MinePersonalAddView
    public void onSuccModifyRequest(@InterfaceC5817e APIresult<?> aPIresult) {
        Integer valueOf = aPIresult != null ? Integer.valueOf(aPIresult.getCode()) : null;
        if (valueOf == null || valueOf.intValue() != 0) {
            C7331w1.m26688a(aPIresult != null ? aPIresult.getMsg() : null);
            return;
        }
        TextView textView = this.mEtArea;
        if (textView == null) {
            C5544i0.m22554k("mEtArea");
        }
        AccountManager.setRegion(textView.getText().toString());
    }

    @Override // p388ui.callview.MinePersonalAddView
    public void onSuccUpdateRequest(int i2) {
        UserInfoBean userInfoBean = (UserInfoBean) C7307p1.m26476a(C7307p1.f25503l, UserInfoBean.class);
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            C5544i0.m22521a((Object) userInfoBean, "userInfoBean");
            userInfoBean.setRegionCode(this.regId);
            TextView textView = this.mEtArea;
            if (textView == null) {
                C5544i0.m22554k("mEtArea");
            }
            userInfoBean.setRegion(textView.getText().toString());
        } else {
            Integer num2 = this.pageType;
            if (num2 != null && num2.intValue() == 11) {
                C5544i0.m22521a((Object) userInfoBean, "userInfoBean");
                EditText editText = this.mEtAddres;
                if (editText == null) {
                    C5544i0.m22554k("mEtAddres");
                }
                userInfoBean.setAddr(editText.getText().toString());
            }
        }
        C7307p1.m26478a(C7307p1.f25503l, userInfoBean);
        finish();
    }

    public final void setHasClick(boolean z) {
        this.hasClick = z;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_persona_infol;
    }

    public final void setMBtnConfirm(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMClArea(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mClArea = view;
    }

    public final void setMClAreaDetail(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mClAreaDetail = view;
    }

    public final void setMEtAddres(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtAddres = editText;
    }

    public final void setMEtArea(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtArea = textView;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e MinePersonalAddPresenter minePersonalAddPresenter) {
        this.mPresenter = minePersonalAddPresenter;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setRegId(@InterfaceC5817e String str) {
        this.regId = str;
    }

    public final void setUserInfo(@InterfaceC5817e UserInfoBean userInfoBean) {
        this.userInfo = userInfoBean;
    }
}
