package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.CriminalPhoneView;
import p388ui.presenter.CriminalPhonePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: AddCrimePhoneActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020)J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020)H\u0014J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000203H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001e\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u00064"}, m23546d2 = {"Lui/activity/AddCrimePhoneActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalPhoneView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mCallNum", "Landroid/widget/TextView;", "getMCallNum", "()Landroid/widget/TextView;", "setMCallNum", "(Landroid/widget/TextView;)V", "mDelivery", "getMDelivery", "setMDelivery", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "getMPresenter", "()Lui/presenter/CriminalPhonePresenter;", "setMPresenter", "(Lui/presenter/CriminalPhonePresenter;)V", "mRecharge", "getMRecharge", "setMRecharge", "mRelation", "getMRelation", "setMRelation", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onResume", "onSuccessPhoneNum", "bean", "Lbean/CriminalPhoneNumBean;", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class AddCrimePhoneActivity extends BaseActivity implements CriminalPhoneView {

    @InterfaceC5816d
    private String caseInfoId = "";

    @BindView(C2113R.id.tv_call_num)
    @InterfaceC5816d
    public TextView mCallNum;

    @BindView(C2113R.id.tv_delivery_num)
    @InterfaceC5816d
    public TextView mDelivery;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private CriminalPhonePresenter mPresenter;

    @BindView(C2113R.id.tv_recharge_num)
    @InterfaceC5816d
    public TextView mRecharge;

    @BindView(C2113R.id.tv_relation_num)
    @InterfaceC5816d
    public TextView mRelation;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @InterfaceC5816d
    public final TextView getMCallNum() {
        TextView textView = this.mCallNum;
        if (textView == null) {
            C5544i0.m22554k("mCallNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMDelivery() {
        TextView textView = this.mDelivery;
        if (textView == null) {
            C5544i0.m22554k("mDelivery");
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
    public final CriminalPhonePresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final TextView getMRecharge() {
        TextView textView = this.mRecharge;
        if (textView == null) {
            C5544i0.m22554k("mRecharge");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMRelation() {
        TextView textView = this.mRelation;
        if (textView == null) {
            C5544i0.m22554k("mRelation");
        }
        return textView;
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
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("添加嫌疑人电话");
        initView();
    }

    public final void initView() {
        Activity activity = this.mActivity;
        C5544i0.m22521a((Object) activity, "mActivity");
        this.mPresenter = new CriminalPhonePresenter(activity, this);
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.rl_type_phone, C2113R.id.rl_type_recharge, C2113R.id.rl_type_relation, C2113R.id.rl_type_delivery, C2113R.id.btn_commit})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        int id = view.getId();
        if (id == C2113R.id.btn_commit) {
            finish();
            return;
        }
        if (id == C2113R.id.iv_back) {
            finish();
            return;
        }
        switch (id) {
            case C2113R.id.rl_type_delivery /* 2131297203 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) DeliveryActivity.class);
                intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent);
                break;
            case C2113R.id.rl_type_phone /* 2131297204 */:
                Intent intent2 = new Intent(this.mActivity, (Class<?>) CallActivity.class);
                intent2.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent2);
                break;
            case C2113R.id.rl_type_recharge /* 2131297205 */:
                Intent intent3 = new Intent(this.mActivity, (Class<?>) ReChargeActivity.class);
                intent3.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent3);
                break;
            case C2113R.id.rl_type_relation /* 2131297206 */:
                Intent intent4 = new Intent(this.mActivity, (Class<?>) RelationActivity.class);
                intent4.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent4);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter != null) {
            criminalPhonePresenter.getCriminalCallNum(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccess(@InterfaceC5816d List<String> list) {
        C5544i0.m22546f(list, "CNATelList");
        CriminalPhoneView.C6814a.m25457a(this, list);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessList(@InterfaceC5816d List<? extends CallBean> list) {
        C5544i0.m22546f(list, "callBeans");
        CriminalPhoneView.C6814a.m25458b(this, list);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@InterfaceC5816d CriminalPhoneNumBean criminalPhoneNumBean) {
        C5544i0.m22546f(criminalPhoneNumBean, "bean");
        TextView textView = this.mCallNum;
        if (textView == null) {
            C5544i0.m22554k("mCallNum");
        }
        textView.setText("");
        TextView textView2 = this.mRecharge;
        if (textView2 == null) {
            C5544i0.m22554k("mRecharge");
        }
        textView2.setText("");
        TextView textView3 = this.mRelation;
        if (textView3 == null) {
            C5544i0.m22554k("mRelation");
        }
        textView3.setText("");
        TextView textView4 = this.mDelivery;
        if (textView4 == null) {
            C5544i0.m22554k("mDelivery");
        }
        textView4.setText("");
        if (criminalPhoneNumBean.getCallTelCount() > 0) {
            TextView textView5 = this.mCallNum;
            if (textView5 == null) {
                C5544i0.m22554k("mCallNum");
            }
            textView5.setText(String.valueOf(criminalPhoneNumBean.getCallTelCount()));
        }
        if (criminalPhoneNumBean.getChargeTelCount() > 0) {
            TextView textView6 = this.mRecharge;
            if (textView6 == null) {
                C5544i0.m22554k("mRecharge");
            }
            textView6.setText(String.valueOf(criminalPhoneNumBean.getChargeTelCount()));
        }
        if (criminalPhoneNumBean.getLinkTelCount() > 0) {
            TextView textView7 = this.mRelation;
            if (textView7 == null) {
                C5544i0.m22554k("mRelation");
            }
            textView7.setText(String.valueOf(criminalPhoneNumBean.getLinkTelCount()));
        }
        if (criminalPhoneNumBean.getMailingTelCount() > 0) {
            TextView textView8 = this.mDelivery;
            if (textView8 == null) {
                C5544i0.m22554k("mDelivery");
            }
            textView8.setText(String.valueOf(criminalPhoneNumBean.getMailingTelCount()));
        }
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        CriminalPhoneView.C6814a.m25454a(this);
    }

    @Override // p388ui.callview.CriminalPhoneView
    public void onSuccessSave(@InterfaceC5816d CallBean callBean) {
        C5544i0.m22546f(callBean, "callBeans");
        CriminalPhoneView.C6814a.m25455a(this, callBean);
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_add_crime_phone;
    }

    public final void setMCallNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mCallNum = textView;
    }

    public final void setMDelivery(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mDelivery = textView;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e CriminalPhonePresenter criminalPhonePresenter) {
        this.mPresenter = criminalPhonePresenter;
    }

    public final void setMRecharge(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mRecharge = textView;
    }

    public final void setMRelation(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mRelation = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
