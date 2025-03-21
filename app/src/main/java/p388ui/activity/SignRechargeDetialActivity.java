package p388ui.activity;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bean.RechargeBean;
import bean.RechargePlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.Hicore;
import p388ui.callview.RechargeView;
import p388ui.presenter.RechargePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignRechargeDetialActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0007J\u0006\u0010+\u001a\u00020'J\b\u0010,\u001a\u00020-H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m23546d2 = {"Lui/activity/SignRechargeDetialActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RechargeView;", "()V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mEtRechargePhone", "Landroid/widget/EditText;", "getMEtRechargePhone", "()Landroid/widget/EditText;", "setMEtRechargePhone", "(Landroid/widget/EditText;)V", "mEtRechargePlat", "Landroid/widget/TextView;", "getMEtRechargePlat", "()Landroid/widget/TextView;", "setMEtRechargePlat", "(Landroid/widget/TextView;)V", "mEtRechargePlatName", "getMEtRechargePlatName", "setMEtRechargePlatName", "mEtRechargeSum", "getMEtRechargeSum", "setMEtRechargeSum", "mEtRechargeTime", "getMEtRechargeTime", "setMEtRechargeTime", "mPresenter", "Lui/presenter/RechargePresenter;", "mTvTitle", "getMTvTitle", "setMTvTitle", "rechargeBean", "Lbean/RechargeBean;", "initPage", "", "onViewClicked", "view", "Landroid/view/View;", "redisplayData", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignRechargeDetialActivity extends BaseActivity implements RechargeView {

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
    private RechargePresenter mPresenter;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private RechargeBean rechargeBean;

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
        this.mPresenter = new RechargePresenter(this, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("充值类嫌疑人电话详情");
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        if (button == null) {
            C5544i0.m22545f();
        }
        button.setVisibility(8);
        redisplayData();
    }

    @Override // p388ui.callview.RechargeView
    public void onItemDelet(int i2) {
        RechargeView.C6816a.m25466a(this, i2);
    }

    @Override // p388ui.callview.RechargeView
    public void onItemEdit(int i2) {
        RechargeView.C6816a.m25468b(this, i2);
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
    }

    @Override // p388ui.callview.RechargeView
    public void onSuccessSave() {
        RechargeView.C6816a.m25465a(this);
    }

    @OnClick({C2113R.id.iv_back})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    public final void redisplayData() {
        this.rechargeBean = (RechargeBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        if (this.rechargeBean != null) {
            TextView textView = this.mEtRechargePlat;
            if (textView == null) {
                C5544i0.m22554k("mEtRechargePlat");
            }
            if (textView == null) {
                C5544i0.m22545f();
            }
            RechargeBean rechargeBean = this.rechargeBean;
            if (rechargeBean == null) {
                C5544i0.m22545f();
            }
            textView.setText(rechargeBean.getPlatformText());
            EditText editText = this.mEtRechargePhone;
            if (editText == null) {
                C5544i0.m22554k("mEtRechargePhone");
            }
            if (editText == null) {
                C5544i0.m22545f();
            }
            RechargeBean rechargeBean2 = this.rechargeBean;
            if (rechargeBean2 == null) {
                C5544i0.m22545f();
            }
            editText.setText(rechargeBean2.getSuspectMobile());
            EditText editText2 = this.mEtRechargeSum;
            if (editText2 == null) {
                C5544i0.m22554k("mEtRechargeSum");
            }
            if (editText2 == null) {
                C5544i0.m22545f();
            }
            RechargeBean rechargeBean3 = this.rechargeBean;
            if (rechargeBean3 == null) {
                C5544i0.m22545f();
            }
            editText2.setText(rechargeBean3.getAmount());
            TextView textView2 = this.mEtRechargeTime;
            if (textView2 == null) {
                C5544i0.m22554k("mEtRechargeTime");
            }
            if (textView2 == null) {
                C5544i0.m22545f();
            }
            RechargeBean rechargeBean4 = this.rechargeBean;
            if (rechargeBean4 == null) {
                C5544i0.m22545f();
            }
            textView2.setText(rechargeBean4.getChargeTime());
            TextView textView3 = this.mEtRechargePlat;
            if (textView3 == null) {
                C5544i0.m22554k("mEtRechargePlat");
            }
            if (textView3 == null) {
                C5544i0.m22545f();
            }
            textView3.setEnabled(false);
            EditText editText3 = this.mEtRechargePlatName;
            if (editText3 == null) {
                C5544i0.m22554k("mEtRechargePlatName");
            }
            if (editText3 == null) {
                C5544i0.m22545f();
            }
            editText3.setEnabled(false);
            EditText editText4 = this.mEtRechargePhone;
            if (editText4 == null) {
                C5544i0.m22554k("mEtRechargePhone");
            }
            if (editText4 == null) {
                C5544i0.m22545f();
            }
            editText4.setEnabled(false);
            EditText editText5 = this.mEtRechargeSum;
            if (editText5 == null) {
                C5544i0.m22554k("mEtRechargeSum");
            }
            if (editText5 == null) {
                C5544i0.m22545f();
            }
            editText5.setEnabled(false);
            TextView textView4 = this.mEtRechargeTime;
            if (textView4 == null) {
                C5544i0.m22554k("mEtRechargeTime");
            }
            if (textView4 == null) {
                C5544i0.m22545f();
            }
            textView4.setEnabled(false);
            TextView textView5 = this.mEtRechargePlat;
            if (textView5 == null) {
                C5544i0.m22554k("mEtRechargePlat");
            }
            if (textView5 == null) {
                C5544i0.m22545f();
            }
            textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView6 = this.mEtRechargeTime;
            if (textView6 == null) {
                C5544i0.m22554k("mEtRechargeTime");
            }
            if (textView6 == null) {
                C5544i0.m22545f();
            }
            textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
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

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
