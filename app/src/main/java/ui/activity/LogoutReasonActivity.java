package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.umeng.analytics.pro.bh;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: LogoutReasonActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0010H\u0007J\b\u00103\u001a\u00020\u001cH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u000e\u0010,\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lui/activity/LogoutReasonActivity;", "Lui/activity/BaseActivity;", "()V", "mConfim", "Landroid/widget/Button;", "getMConfim", "()Landroid/widget/Button;", "setMConfim", "(Landroid/widget/Button;)V", "mEtOtherReson", "Landroid/widget/EditText;", "getMEtOtherReson", "()Landroid/widget/EditText;", "setMEtOtherReson", "(Landroid/widget/EditText;)V", "mFlOtherEdit", "Landroid/view/View;", "getMFlOtherEdit", "()Landroid/view/View;", "setMFlOtherEdit", "(Landroid/view/View;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mMaxCount", "", "mRbGroup", "Landroid/widget/RadioGroup;", "getMRbGroup", "()Landroid/widget/RadioGroup;", "setMRbGroup", "(Landroid/widget/RadioGroup;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvWords", "getMTvWords", "setMTvWords", "reaseon", "", "initListener", "", "initPage", "onClick", "view", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class LogoutReasonActivity extends BaseActivity {
    private final int a = 500;

    /* JADX INFO: renamed from: b */
    private String f13466b = "\u5b89\u5168/\u9690\u79c1\u987e\u8651";

    @BindView(R.id.confirm)
    @j.c.a.d
    public Button mConfim;

    @BindView(R.id.et_other_reson)
    @j.c.a.d
    public EditText mEtOtherReson;

    @BindView(R.id.fl_other_edit)
    @j.c.a.d
    public View mFlOtherEdit;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.rg_group)
    @j.c.a.d
    public RadioGroup mRbGroup;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.tv_words)
    @j.c.a.d
    public TextView mTvWords;

    /* JADX INFO: compiled from: LogoutReasonActivity.kt */
    static final class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            switch (i2) {
                case R.id.rb_app /* 2131297269 */:
                    LogoutReasonActivity.this.f13466b = "\u4ea7\u54c1\u4f7f\u7528\u4f53\u9a8c\u95ee\u9898";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
                case R.id.rb_not_me /* 2131297272 */:
                    LogoutReasonActivity.this.f13466b = "\u975e\u672c\u4eba\u6ce8\u518c\u7684\u8d26\u53f7";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
                case R.id.rb_other /* 2131297273 */:
                    LogoutReasonActivity.this.f13466b = "";
                    LogoutReasonActivity.this.b().setVisibility(0);
                    break;
                case R.id.rb_regist_new /* 2131297278 */:
                    LogoutReasonActivity.this.f13466b = "\u9700\u8981\u6ce8\u518c\u65b0\u7684\u8d26\u53f7";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
                case R.id.rb_safety /* 2131297279 */:
                    LogoutReasonActivity.this.f13466b = "\u5b89\u5168/\u9690\u79c1\u987e\u8651";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: LogoutReasonActivity.kt */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@j.c.a.d Editable editable) {
            i.q2.t.i0.f(editable, bh.aE);
            LogoutReasonActivity.this.f13466b = editable.toString();
            int length = editable.length();
            if (!TextUtils.isEmpty(i.z2.b0.a(editable.toString(), d.c.a.b.a.a.f10074g, "", false, 4, (Object) null)) && length > LogoutReasonActivity.this.a) {
                LogoutReasonActivity.this.a().setText(editable.subSequence(0, LogoutReasonActivity.this.a));
                LogoutReasonActivity.this.a().requestFocus();
                LogoutReasonActivity.this.a().setSelection(LogoutReasonActivity.this.a);
            }
            LogoutReasonActivity.this.d().setText(length + "/500");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@j.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            i.q2.t.i0.f(charSequence, bh.aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@j.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            i.q2.t.i0.f(charSequence, bh.aE);
        }
    }

    @j.c.a.d
    public final RadioGroup c() {
        RadioGroup radioGroup = this.mRbGroup;
        if (radioGroup == null) {
            i.q2.t.i0.k("mRbGroup");
        }
        return radioGroup;
    }

    @j.c.a.d
    public final TextView d() {
        TextView textView = this.mTvWords;
        if (textView == null) {
            i.q2.t.i0.k("mTvWords");
        }
        return textView;
    }

    @j.c.a.d
    public final Button getMConfim() {
        Button button = this.mConfim;
        if (button == null) {
            i.q2.t.i0.k("mConfim");
        }
        return button;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    public final void initListener() {
        RadioGroup radioGroup = this.mRbGroup;
        if (radioGroup == null) {
            i.q2.t.i0.k("mRbGroup");
        }
        radioGroup.setOnCheckedChangeListener(new a());
        EditText editText = this.mEtOtherReson;
        if (editText == null) {
            i.q2.t.i0.k("mEtOtherReson");
        }
        util.h1.a(editText, this.a);
        EditText editText2 = this.mEtOtherReson;
        if (editText2 == null) {
            i.q2.t.i0.k("mEtOtherReson");
        }
        editText2.addTextChangedListener(new b());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u6ce8\u9500\u8d26\u53f7");
        initListener();
    }

    @OnClick({R.id.iv_back, R.id.confirm})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.confirm) {
            if (id != R.id.iv_back) {
                return;
            }
            a();
        } else {
            Intent intent = new Intent(this.mActivity, (Class<?>) LogoutSmsCodeActivity.class);
            intent.putExtra(util.p1.f0, this.f13466b);
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_logout_reason;
    }

    public final void setMConfim(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mConfim = button;
    }

    public final void setMFlOtherEdit(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mFlOtherEdit = view;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    @j.c.a.d
    public final View b() {
        View view = this.mFlOtherEdit;
        if (view == null) {
            i.q2.t.i0.k("mFlOtherEdit");
        }
        return view;
    }

    public final void a(@j.c.a.d RadioGroup radioGroup) {
        i.q2.t.i0.f(radioGroup, "<set-?>");
        this.mRbGroup = radioGroup;
    }

    @j.c.a.d
    public final EditText a() {
        EditText editText = this.mEtOtherReson;
        if (editText == null) {
            i.q2.t.i0.k("mEtOtherReson");
        }
        return editText;
    }

    public final void a(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtOtherReson = editText;
    }

    public final void a(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvWords = textView;
    }
}
