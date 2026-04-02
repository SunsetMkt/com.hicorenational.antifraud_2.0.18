package ui.activity;

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
import com.hicorenational.antifraud.R;
import manager.AccountManager;
import network.account.APIresult;
import network.http.AddressHttp;
import ui.callview.MinePersonalAddView;
import ui.presenter.MinePersonalAddPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: compiled from: PersonalInfoAddActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020DJ\b\u0010G\u001a\u00020DH\u0016J\u0010\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0011H\u0007J\u0016\u0010J\u001a\u00020D2\f\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u000205H\u0016J\b\u0010O\u001a\u000205H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u0012\u00104\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006Q"}, d2 = {"Lui/activity/PersonalInfoAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/MinePersonalAddView;", "()V", "hasClick", "", "getHasClick", "()Z", "setHasClick", "(Z)V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mClArea", "Landroid/view/View;", "getMClArea", "()Landroid/view/View;", "setMClArea", "(Landroid/view/View;)V", "mClAreaDetail", "getMClAreaDetail", "setMClAreaDetail", "mEtAddres", "Landroid/widget/EditText;", "getMEtAddres", "()Landroid/widget/EditText;", "setMEtAddres", "(Landroid/widget/EditText;)V", "mEtArea", "Landroid/widget/TextView;", "getMEtArea", "()Landroid/widget/TextView;", "setMEtArea", "(Landroid/widget/TextView;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/MinePersonalAddPresenter;", "getMPresenter", "()Lui/presenter/MinePersonalAddPresenter;", "setMPresenter", "(Lui/presenter/MinePersonalAddPresenter;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "pageType", "", "Ljava/lang/Integer;", "regId", "", "getRegId", "()Ljava/lang/String;", "setRegId", "(Ljava/lang/String;)V", "userInfo", "Lbean/UserInfoBean;", "getUserInfo", "()Lbean/UserInfoBean;", "setUserInfo", "(Lbean/UserInfoBean;)V", "area", "", "initIntentData", "initListener", "initPage", "onClick", "view", "onSuccModifyRequest", "resultInfo", "Lnetwork/account/APIresult;", "onSuccUpdateRequest", "page", "setLayoutView", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class PersonalInfoAddActivity extends BaseActivity implements MinePersonalAddView {
    public static final int ADDRESS_1 = 1;
    public static final int ADDRESS_11 = 11;
    public static final a Companion = new a(null);
    private boolean hasClick;

    @BindView(R.id.btn_confirm)
    @j.c.a.d
    public Button mBtnConfirm;

    @BindView(R.id.cl_area_cont)
    @j.c.a.d
    public View mClArea;

    @BindView(R.id.cl_area_detail_content)
    @j.c.a.d
    public View mClAreaDetail;

    @BindView(R.id.et_address)
    @j.c.a.d
    public EditText mEtAddres;

    @BindView(R.id.et_area)
    @j.c.a.d
    public TextView mEtArea;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @j.c.a.e
    private MinePersonalAddPresenter mPresenter;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;
    private Integer pageType = 0;

    @j.c.a.e
    private String regId;

    @j.c.a.e
    private UserInfoBean userInfo;

    /* JADX INFO: compiled from: PersonalInfoAddActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: PersonalInfoAddActivity.kt */
    public static final class b extends AddressHttp.MyPicker {
        b() {
        }

        @Override // network.http.AddressHttp.MyPicker, c.a.a.e.a.e
        public void onAddressPicked(@j.c.a.e c.a.a.d.k kVar, @j.c.a.e c.a.a.d.d dVar, @j.c.a.e c.a.a.d.e eVar) {
            if (kVar == null || dVar == null || eVar == null) {
                TextView mEtArea = PersonalInfoAddActivity.this.getMEtArea();
                if (mEtArea != null) {
                    mEtArea.setText("");
                    return;
                }
                return;
            }
            PersonalInfoAddActivity.this.setRegId(eVar.getAreaId());
            String str = kVar.getName() + dVar.getName() + eVar.getName();
            TextView mEtArea2 = PersonalInfoAddActivity.this.getMEtArea();
            if (mEtArea2 != null) {
                mEtArea2.setText(str);
            }
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onClear() {
        }
    }

    /* JADX INFO: compiled from: PersonalInfoAddActivity.kt */
    static final class c implements View.OnFocusChangeListener {
        c() {
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
        AddressHttp.getAddSint(this.mActivity).regionPickNoClear(new b());
    }

    public final boolean getHasClick() {
        return this.hasClick;
    }

    @j.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            i.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @j.c.a.d
    public final View getMClArea() {
        View view = this.mClArea;
        if (view == null) {
            i.q2.t.i0.k("mClArea");
        }
        return view;
    }

    @j.c.a.d
    public final View getMClAreaDetail() {
        View view = this.mClAreaDetail;
        if (view == null) {
            i.q2.t.i0.k("mClAreaDetail");
        }
        return view;
    }

    @j.c.a.d
    public final EditText getMEtAddres() {
        EditText editText = this.mEtAddres;
        if (editText == null) {
            i.q2.t.i0.k("mEtAddres");
        }
        return editText;
    }

    @j.c.a.d
    public final TextView getMEtArea() {
        TextView textView = this.mEtArea;
        if (textView == null) {
            i.q2.t.i0.k("mEtArea");
        }
        return textView;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.e
    public final MinePersonalAddPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @j.c.a.e
    public final String getRegId() {
        return this.regId;
    }

    @j.c.a.e
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    public final void initIntentData() {
        this.userInfo = (UserInfoBean) getIntent().getSerializableExtra(util.p1.f15011c);
        this.pageType = Integer.valueOf(getIntent().getIntExtra(util.p1.f15012d, 0));
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            TextView textView = this.mTvTitle;
            if (textView == null) {
                i.q2.t.i0.k("mTvTitle");
            }
            if (textView == null) {
                i.q2.t.i0.f();
            }
            textView.setText("\u6240\u5728\u5730\u533a");
            View view = this.mClArea;
            if (view == null) {
                i.q2.t.i0.k("mClArea");
            }
            if (view == null) {
                i.q2.t.i0.f();
            }
            view.setVisibility(0);
            UserInfoBean userInfoBean = this.userInfo;
            if (userInfoBean != null) {
                this.regId = userInfoBean != null ? userInfoBean.getRegionCode() : null;
                TextView textView2 = this.mEtArea;
                if (textView2 == null) {
                    i.q2.t.i0.k("mEtArea");
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
                i.q2.t.i0.k("mTvTitle");
            }
            if (textView3 == null) {
                i.q2.t.i0.f();
            }
            textView3.setText("\u8be6\u7ec6\u5730\u5740");
            View view2 = this.mClAreaDetail;
            if (view2 == null) {
                i.q2.t.i0.k("mClAreaDetail");
            }
            if (view2 == null) {
                i.q2.t.i0.f();
            }
            view2.setVisibility(0);
            UserInfoBean userInfoBean3 = this.userInfo;
            if (userInfoBean3 != null) {
                this.regId = userInfoBean3 != null ? userInfoBean3.getRegionCode() : null;
                EditText editText = this.mEtAddres;
                if (editText == null) {
                    i.q2.t.i0.k("mEtAddres");
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
                i.q2.t.i0.k("mEtAddres");
            }
            editText.setOnFocusChangeListener(new c());
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        this.mPresenter = new MinePersonalAddPresenter(this.mActivity, this);
        initIntentData();
        initListener();
    }

    @OnClick({R.id.iv_back, R.id.et_area, R.id.btn_confirm})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_confirm) {
            if (id == R.id.et_area) {
                area();
                return;
            } else {
                if (id != R.id.iv_back) {
                    return;
                }
                a();
                return;
            }
        }
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            TextView textView = this.mEtArea;
            if (textView == null) {
                i.q2.t.i0.k("mEtArea");
            }
            if (TextUtils.isEmpty(textView.getText().toString())) {
                e2.a("\u8bf7\u9009\u62e9\u6240\u5728\u5730\u533a");
                return;
            }
            MinePersonalAddPresenter minePersonalAddPresenter = this.mPresenter;
            if (minePersonalAddPresenter != null) {
                Integer num2 = this.pageType;
                if (num2 == null) {
                    i.q2.t.i0.f();
                }
                minePersonalAddPresenter.updateUserAddres(num2.intValue(), this.regId, "");
                return;
            }
            return;
        }
        Integer num3 = this.pageType;
        if (num3 != null && num3.intValue() == 11) {
            if (!this.hasClick) {
                a();
                return;
            }
            EditText editText = this.mEtAddres;
            if (editText == null) {
                i.q2.t.i0.k("mEtAddres");
            }
            String string = editText.getText().toString();
            if (TextUtils.isEmpty(string) || i.z2.c0.c((CharSequence) string, (CharSequence) "*", false, 2, (Object) null)) {
                e2.a("\u8bf7\u8f93\u5165\u8be6\u7ec6\u5730\u5740");
                return;
            }
            MinePersonalAddPresenter minePersonalAddPresenter2 = this.mPresenter;
            if (minePersonalAddPresenter2 != null) {
                Integer num4 = this.pageType;
                if (num4 == null) {
                    i.q2.t.i0.f();
                }
                minePersonalAddPresenter2.updateUserAddres(num4.intValue(), "", string);
            }
        }
    }

    @Override // ui.callview.MinePersonalAddView
    public void onSuccModifyRequest(@j.c.a.e APIresult<?> aPIresult) {
        Integer numValueOf = aPIresult != null ? Integer.valueOf(aPIresult.getCode()) : null;
        if (numValueOf == null || numValueOf.intValue() != 0) {
            e2.a(aPIresult != null ? aPIresult.getMsg() : null);
            return;
        }
        TextView textView = this.mEtArea;
        if (textView == null) {
            i.q2.t.i0.k("mEtArea");
        }
        AccountManager.setRegion(textView.getText().toString());
    }

    @Override // ui.callview.MinePersonalAddView
    public void onSuccUpdateRequest(int i2) {
        UserInfoBean userInfoBean = (UserInfoBean) util.u1.a(util.u1.f15089l, UserInfoBean.class);
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            i.q2.t.i0.a((Object) userInfoBean, "userInfoBean");
            userInfoBean.setRegionCode(this.regId);
            TextView textView = this.mEtArea;
            if (textView == null) {
                i.q2.t.i0.k("mEtArea");
            }
            userInfoBean.setRegion(textView.getText().toString());
        } else {
            Integer num2 = this.pageType;
            if (num2 != null && num2.intValue() == 11) {
                i.q2.t.i0.a((Object) userInfoBean, "userInfoBean");
                EditText editText = this.mEtAddres;
                if (editText == null) {
                    i.q2.t.i0.k("mEtAddres");
                }
                userInfoBean.setAddr(editText.getText().toString());
            }
        }
        util.u1.a(util.u1.f15089l, userInfoBean);
        finish();
    }

    public final void setHasClick(boolean z) {
        this.hasClick = z;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_persona_infol;
    }

    public final void setMBtnConfirm(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMClArea(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mClArea = view;
    }

    public final void setMClAreaDetail(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mClAreaDetail = view;
    }

    public final void setMEtAddres(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtAddres = editText;
    }

    public final void setMEtArea(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mEtArea = textView;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e MinePersonalAddPresenter minePersonalAddPresenter) {
        this.mPresenter = minePersonalAddPresenter;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setRegId(@j.c.a.e String str) {
        this.regId = str;
    }

    public final void setUserInfo(@j.c.a.e UserInfoBean userInfoBean) {
        this.userInfo = userInfoBean;
    }
}
