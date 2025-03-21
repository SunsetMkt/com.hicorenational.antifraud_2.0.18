package p388ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import bean.CallBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import java.io.Serializable;
import java.util.List;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5724b0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.Hicore;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: SignCallDetailActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u001bH\u0007J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000200H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001e\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001e\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\b¨\u00066"}, m23546d2 = {"Lui/activity/SignCallDetailActivity;", "Lui/activity/BaseActivity;", "()V", "mAudioNum", "Landroid/widget/TextView;", "getMAudioNum", "()Landroid/widget/TextView;", "setMAudioNum", "(Landroid/widget/TextView;)V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mCallBean", "Lbean/CallBean;", "mEtPhone", "Landroid/widget/EditText;", "getMEtPhone", "()Landroid/widget/EditText;", "setMEtPhone", "(Landroid/widget/EditText;)V", "mEtVictimPhone", "getMEtVictimPhone", "setMEtVictimPhone", "mLlClause", "Landroid/view/View;", "getMLlClause", "()Landroid/view/View;", "setMLlClause", "(Landroid/view/View;)V", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvDuration", "getMTvDuration", "setMTvDuration", "mTvOccurTime", "getMTvOccurTime", "setMTvOccurTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onViewClicked", "view", "setLayoutView", "", "showData", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCallDetailActivity extends BaseActivity {

    /* renamed from: a */
    private CallBean f23096a;

    @BindView(C2113R.id.tv_audio_num)
    @InterfaceC5816d
    public TextView mAudioNum;

    @BindView(C2113R.id.btn_confirm)
    @InterfaceC5816d
    public Button mBtnConfirm;

    @BindView(C2113R.id.et_phone)
    @InterfaceC5816d
    public EditText mEtPhone;

    @BindView(C2113R.id.et_victim_phone)
    @InterfaceC5816d
    public EditText mEtVictimPhone;

    @BindView(C2113R.id.ll_clause)
    @InterfaceC5816d
    public View mLlClause;

    @BindView(C2113R.id.cb_select)
    @InterfaceC5816d
    public CheckBox mTCbSelect;

    @BindView(C2113R.id.tv_duration)
    @InterfaceC5816d
    public TextView mTvDuration;

    @BindView(C2113R.id.tv_occur_time)
    @InterfaceC5816d
    public TextView mTvOccurTime;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    private final void showData() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            C5544i0.m22554k("mBtnConfirm");
        }
        if (button == null) {
            C5544i0.m22545f();
        }
        button.setVisibility(8);
        EditText editText = this.mEtPhone;
        if (editText == null) {
            C5544i0.m22554k("mEtPhone");
        }
        if (editText == null) {
            C5544i0.m22545f();
        }
        editText.setFocusable(false);
        TextView textView = this.mTvOccurTime;
        if (textView == null) {
            C5544i0.m22554k("mTvOccurTime");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setEnabled(false);
        TextView textView2 = this.mTvDuration;
        if (textView2 == null) {
            C5544i0.m22554k("mTvDuration");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setEnabled(false);
        EditText editText2 = this.mEtVictimPhone;
        if (editText2 == null) {
            C5544i0.m22554k("mEtVictimPhone");
        }
        if (editText2 == null) {
            C5544i0.m22545f();
        }
        editText2.setEnabled(false);
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        if (checkBox == null) {
            C5544i0.m22545f();
        }
        checkBox.setEnabled(false);
        TextView textView3 = this.mTvOccurTime;
        if (textView3 == null) {
            C5544i0.m22554k("mTvOccurTime");
        }
        if (textView3 == null) {
            C5544i0.m22545f();
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView4 = this.mTvDuration;
        if (textView4 == null) {
            C5544i0.m22554k("mTvDuration");
        }
        if (textView4 == null) {
            C5544i0.m22545f();
        }
        textView4.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView5 = this.mAudioNum;
        if (textView5 == null) {
            C5544i0.m22554k("mAudioNum");
        }
        if (textView5 == null) {
            C5544i0.m22545f();
        }
        textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        EditText editText3 = this.mEtVictimPhone;
        if (editText3 == null) {
            C5544i0.m22554k("mEtVictimPhone");
        }
        if (editText3 == null) {
            C5544i0.m22545f();
        }
        CallBean callBean = this.f23096a;
        if (callBean == null) {
            C5544i0.m22545f();
        }
        editText3.setText(callBean.getVictimMobile());
        EditText editText4 = this.mEtPhone;
        if (editText4 == null) {
            C5544i0.m22554k("mEtPhone");
        }
        if (editText4 == null) {
            C5544i0.m22545f();
        }
        CallBean callBean2 = this.f23096a;
        if (callBean2 == null) {
            C5544i0.m22545f();
        }
        editText4.setText(callBean2.getSuspectMobile());
        CallBean callBean3 = this.f23096a;
        if ((callBean3 != null ? callBean3.getSwindleTelTypeText() : null) != null) {
            CallBean callBean4 = this.f23096a;
            if (C5724b0.m23631c(callBean4 != null ? callBean4.getSwindleTelTypeText() : null, "FaceTime", true)) {
                View view = this.mLlClause;
                if (view == null) {
                    C5544i0.m22554k("mLlClause");
                }
                if (view != null) {
                    view.setVisibility(0);
                }
                CheckBox checkBox2 = this.mTCbSelect;
                if (checkBox2 == null) {
                    C5544i0.m22554k("mTCbSelect");
                }
                if (checkBox2 != null) {
                    checkBox2.setChecked(true);
                }
            }
        }
        TextView textView6 = this.mTvOccurTime;
        if (textView6 == null) {
            C5544i0.m22554k("mTvOccurTime");
        }
        if (textView6 == null) {
            C5544i0.m22545f();
        }
        CallBean callBean5 = this.f23096a;
        textView6.setText(callBean5 != null ? callBean5.getTalkTime() : null);
        TextView textView7 = this.mTvDuration;
        if (textView7 == null) {
            C5544i0.m22554k("mTvDuration");
        }
        if (textView7 == null) {
            C5544i0.m22545f();
        }
        CallBean callBean6 = this.f23096a;
        textView7.setText(callBean6 != null ? callBean6.getCallDuration() : null);
        CallBean callBean7 = this.f23096a;
        if (callBean7 == null) {
            C5544i0.m22545f();
        }
        if (callBean7.getCallTelDetails() == null) {
            TextView textView8 = this.mAudioNum;
            if (textView8 == null) {
                C5544i0.m22554k("mAudioNum");
            }
            textView8.setText("");
            return;
        }
        TextView textView9 = this.mAudioNum;
        if (textView9 == null) {
            C5544i0.m22554k("mAudioNum");
        }
        StringBuilder sb = new StringBuilder();
        CallBean callBean8 = this.f23096a;
        List<UploadFileBean> callTelDetails = callBean8 != null ? callBean8.getCallTelDetails() : null;
        if (callTelDetails == null) {
            C5544i0.m22545f();
        }
        sb.append(String.valueOf(callTelDetails.size()));
        sb.append("条");
        textView9.setText(sb.toString());
        TextView textView10 = this.mAudioNum;
        if (textView10 == null) {
            C5544i0.m22554k("mAudioNum");
        }
        textView10.setTextColor(Color.parseColor("#333333"));
    }

    @InterfaceC5816d
    public final TextView getMAudioNum() {
        TextView textView = this.mAudioNum;
        if (textView == null) {
            C5544i0.m22554k("mAudioNum");
        }
        return textView;
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
    public final EditText getMEtPhone() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            C5544i0.m22554k("mEtPhone");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtVictimPhone() {
        EditText editText = this.mEtVictimPhone;
        if (editText == null) {
            C5544i0.m22554k("mEtVictimPhone");
        }
        return editText;
    }

    @InterfaceC5816d
    public final View getMLlClause() {
        View view = this.mLlClause;
        if (view == null) {
            C5544i0.m22554k("mLlClause");
        }
        return view;
    }

    @InterfaceC5816d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        return checkBox;
    }

    @InterfaceC5816d
    public final TextView getMTvDuration() {
        TextView textView = this.mTvDuration;
        if (textView == null) {
            C5544i0.m22554k("mTvDuration");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvOccurTime() {
        TextView textView = this.mTvOccurTime;
        if (textView == null) {
            C5544i0.m22554k("mTvOccurTime");
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
        textView.setText("通话类嫌疑人电话详情");
        this.f23096a = (CallBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        showData();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_audio_num})
    public final void onViewClicked(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        Hicore app = Hicore.getApp();
        C5544i0.m22521a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
            return;
        }
        if (id != C2113R.id.tv_audio_num) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SurveyAudioActivity.class);
        CallBean callBean = this.f23096a;
        if (callBean == null) {
            C5544i0.m22545f();
        }
        if (callBean.getCallTelDetails() != null) {
            CallBean callBean2 = this.f23096a;
            if (callBean2 == null) {
                C5544i0.m22545f();
            }
            if (callBean2.getCallTelDetails().size() > 0) {
                CallBean callBean3 = this.f23096a;
                if (callBean3 == null) {
                    C5544i0.m22545f();
                }
                List<UploadFileBean> callTelDetails = callBean3.getCallTelDetails();
                if (callTelDetails == null) {
                    throw new C5226e1("null cannot be cast to non-null type java.io.Serializable");
                }
                intent.putExtra(C7292k1.f25426p, (Serializable) callTelDetails);
                startActivity(intent);
            }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_call_criminal_add;
    }

    public final void setMAudioNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mAudioNum = textView;
    }

    public final void setMBtnConfirm(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtPhone(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtPhone = editText;
    }

    public final void setMEtVictimPhone(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtVictimPhone = editText;
    }

    public final void setMLlClause(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlClause = view;
    }

    public final void setMTCbSelect(@InterfaceC5816d CheckBox checkBox) {
        C5544i0.m22546f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvDuration(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvDuration = textView;
    }

    public final void setMTvOccurTime(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvOccurTime = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
