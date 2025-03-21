package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.analytics.pro.C3351bh;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5724b0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7268d1;
import util.C7292k1;

/* compiled from: LogoutReasonActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0010H\u0007J\b\u00103\u001a\u00020\u001cH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m23546d2 = {"Lui/activity/LogoutReasonActivity;", "Lui/activity/BaseActivity;", "()V", "mConfim", "Landroid/widget/Button;", "getMConfim", "()Landroid/widget/Button;", "setMConfim", "(Landroid/widget/Button;)V", "mEtOtherReson", "Landroid/widget/EditText;", "getMEtOtherReson", "()Landroid/widget/EditText;", "setMEtOtherReson", "(Landroid/widget/EditText;)V", "mFlOtherEdit", "Landroid/view/View;", "getMFlOtherEdit", "()Landroid/view/View;", "setMFlOtherEdit", "(Landroid/view/View;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mMaxCount", "", "mRbGroup", "Landroid/widget/RadioGroup;", "getMRbGroup", "()Landroid/widget/RadioGroup;", "setMRbGroup", "(Landroid/widget/RadioGroup;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvWords", "getMTvWords", "setMTvWords", "reaseon", "", "initListener", "", "initPage", "onClick", "view", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutReasonActivity extends BaseActivity {

    /* renamed from: a */
    private final int f22488a = 500;

    /* renamed from: b */
    private String f22489b = "安全/隐私顾虑";

    @BindView(C2113R.id.confirm)
    @InterfaceC5816d
    public Button mConfim;

    @BindView(C2113R.id.et_other_reson)
    @InterfaceC5816d
    public EditText mEtOtherReson;

    @BindView(C2113R.id.fl_other_edit)
    @InterfaceC5816d
    public View mFlOtherEdit;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.rg_group)
    @InterfaceC5816d
    public RadioGroup mRbGroup;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @BindView(C2113R.id.tv_words)
    @InterfaceC5816d
    public TextView mTvWords;

    /* compiled from: LogoutReasonActivity.kt */
    /* renamed from: ui.activity.LogoutReasonActivity$a */
    static final class C6358a implements RadioGroup.OnCheckedChangeListener {
        C6358a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            switch (i2) {
                case C2113R.id.rb_app /* 2131297129 */:
                    LogoutReasonActivity.this.f22489b = "产品使用体验问题";
                    LogoutReasonActivity.this.m25279b().setVisibility(8);
                    break;
                case C2113R.id.rb_not_me /* 2131297132 */:
                    LogoutReasonActivity.this.f22489b = "非本人注册的账号";
                    LogoutReasonActivity.this.m25279b().setVisibility(8);
                    break;
                case C2113R.id.rb_other /* 2131297133 */:
                    LogoutReasonActivity.this.f22489b = "";
                    LogoutReasonActivity.this.m25279b().setVisibility(0);
                    break;
                case C2113R.id.rb_regist_new /* 2131297138 */:
                    LogoutReasonActivity.this.f22489b = "需要注册新的账号";
                    LogoutReasonActivity.this.m25279b().setVisibility(8);
                    break;
                case C2113R.id.rb_safety /* 2131297139 */:
                    LogoutReasonActivity.this.f22489b = "安全/隐私顾虑";
                    LogoutReasonActivity.this.m25279b().setVisibility(8);
                    break;
            }
        }
    }

    /* compiled from: LogoutReasonActivity.kt */
    /* renamed from: ui.activity.LogoutReasonActivity$b */
    public static final class C6359b implements TextWatcher {
        C6359b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@InterfaceC5816d Editable editable) {
            String m23580a;
            C5544i0.m22546f(editable, C3351bh.f11580aE);
            LogoutReasonActivity.this.f22489b = editable.toString();
            int length = editable.length();
            m23580a = C5724b0.m23580a(editable.toString(), AbstractC1191a.f2568g, "", false, 4, (Object) null);
            if (!TextUtils.isEmpty(m23580a) && length > LogoutReasonActivity.this.f22488a) {
                LogoutReasonActivity.this.m25275a().setText(editable.subSequence(0, LogoutReasonActivity.this.f22488a));
                LogoutReasonActivity.this.m25275a().requestFocus();
                LogoutReasonActivity.this.m25275a().setSelection(LogoutReasonActivity.this.f22488a);
            }
            LogoutReasonActivity.this.m25281d().setText(length + "/500");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@InterfaceC5816d CharSequence charSequence, int i2, int i3, int i4) {
            C5544i0.m22546f(charSequence, C3351bh.f11580aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@InterfaceC5816d CharSequence charSequence, int i2, int i3, int i4) {
            C5544i0.m22546f(charSequence, C3351bh.f11580aE);
        }
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final RadioGroup m25280c() {
        RadioGroup radioGroup = this.mRbGroup;
        if (radioGroup == null) {
            C5544i0.m22554k("mRbGroup");
        }
        return radioGroup;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public final TextView m25281d() {
        TextView textView = this.mTvWords;
        if (textView == null) {
            C5544i0.m22554k("mTvWords");
        }
        return textView;
    }

    @InterfaceC5816d
    public final Button getMConfim() {
        Button button = this.mConfim;
        if (button == null) {
            C5544i0.m22554k("mConfim");
        }
        return button;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    public final void initListener() {
        RadioGroup radioGroup = this.mRbGroup;
        if (radioGroup == null) {
            C5544i0.m22554k("mRbGroup");
        }
        radioGroup.setOnCheckedChangeListener(new C6358a());
        EditText editText = this.mEtOtherReson;
        if (editText == null) {
            C5544i0.m22554k("mEtOtherReson");
        }
        C7268d1.m26308a(editText, this.f22488a);
        EditText editText2 = this.mEtOtherReson;
        if (editText2 == null) {
            C5544i0.m22554k("mEtOtherReson");
        }
        editText2.addTextChangedListener(new C6359b());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("注销账号");
        initListener();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.confirm})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.confirm) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            onBackPressed();
        } else {
            Intent intent = new Intent(this.mActivity, (Class<?>) LogoutSmsCodeActivity.class);
            intent.putExtra(C7292k1.f25401f0, this.f22489b);
            startActivity(intent);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_logout_reason;
    }

    public final void setMConfim(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mConfim = button;
    }

    public final void setMFlOtherEdit(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlOtherEdit = view;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final View m25279b() {
        View view = this.mFlOtherEdit;
        if (view == null) {
            C5544i0.m22554k("mFlOtherEdit");
        }
        return view;
    }

    /* renamed from: a */
    public final void m25277a(@InterfaceC5816d RadioGroup radioGroup) {
        C5544i0.m22546f(radioGroup, "<set-?>");
        this.mRbGroup = radioGroup;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final EditText m25275a() {
        EditText editText = this.mEtOtherReson;
        if (editText == null) {
            C5544i0.m22554k("mEtOtherReson");
        }
        return editText;
    }

    /* renamed from: a */
    public final void m25276a(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtOtherReson = editText;
    }

    /* renamed from: a */
    public final void m25278a(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvWords = textView;
    }
}
