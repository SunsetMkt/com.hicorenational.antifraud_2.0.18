package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.SurveyPeopleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import util.C7292k1;

/* compiled from: VictimDetialActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020(J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020.H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006/"}, m23546d2 = {"Lui/activity/VictimDetialActivity;", "Lui/activity/BaseActivity;", "()V", "documNumber", "", "getDocumNumber", "()Ljava/lang/String;", "setDocumNumber", "(Ljava/lang/String;)V", "mEtPeopCredentNumber", "Landroid/widget/TextView;", "getMEtPeopCredentNumber", "()Landroid/widget/TextView;", "setMEtPeopCredentNumber", "(Landroid/widget/TextView;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mTvPeopCredentType", "getMTvPeopCredentType", "setMTvPeopCredentType", "mTvPeopName", "getMTvPeopName", "setMTvPeopName", "mTvPeopPhone", "getMTvPeopPhone", "setMTvPeopPhone", "mTvTitle", "getMTvTitle", "setMTvTitle", "stepTwoBean", "Lbean/SurveyPeopleBean;", "getStepTwoBean", "()Lbean/SurveyPeopleBean;", "setStepTwoBean", "(Lbean/SurveyPeopleBean;)V", "initPage", "", "initViewData", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class VictimDetialActivity extends BaseActivity {

    /* renamed from: a */
    @InterfaceC5817e
    private SurveyPeopleBean f23377a;

    /* renamed from: b */
    @InterfaceC5816d
    private String f23378b = "";

    @BindView(C2113R.id.et_peop_credent_number)
    @InterfaceC5816d
    public TextView mEtPeopCredentNumber;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.tv_peop_credent_type)
    @InterfaceC5816d
    public TextView mTvPeopCredentType;

    @BindView(C2113R.id.tv_peop_name)
    @InterfaceC5816d
    public TextView mTvPeopName;

    @BindView(C2113R.id.tv_num_phone)
    @InterfaceC5816d
    public TextView mTvPeopPhone;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* renamed from: a */
    public final void m25393a(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mEtPeopCredentNumber = textView;
    }

    /* renamed from: b */
    public final void m25395b(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPeopName = textView;
    }

    /* renamed from: c */
    public final void m25396c(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPeopPhone = textView;
    }

    @InterfaceC5816d
    public final TextView getMEtPeopCredentNumber() {
        TextView textView = this.mEtPeopCredentNumber;
        if (textView == null) {
            C5544i0.m22554k("mEtPeopCredentNumber");
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

    @InterfaceC5816d
    public final TextView getMTvPeopCredentType() {
        TextView textView = this.mTvPeopCredentType;
        if (textView == null) {
            C5544i0.m22554k("mTvPeopCredentType");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvPeopName() {
        TextView textView = this.mTvPeopName;
        if (textView == null) {
            C5544i0.m22554k("mTvPeopName");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvPeopPhone() {
        TextView textView = this.mTvPeopPhone;
        if (textView == null) {
            C5544i0.m22554k("mTvPeopPhone");
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

    @InterfaceC5817e
    public final SurveyPeopleBean getStepTwoBean() {
        return this.f23377a;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("事主信息详情");
        initViewData();
    }

    public final void initViewData() {
        this.f23377a = (SurveyPeopleBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        if (this.f23377a != null) {
            TextView textView = this.mTvPeopName;
            if (textView == null) {
                C5544i0.m22554k("mTvPeopName");
            }
            SurveyPeopleBean surveyPeopleBean = this.f23377a;
            textView.setText(surveyPeopleBean != null ? surveyPeopleBean.getPeopleName() : null);
            TextView textView2 = this.mTvPeopPhone;
            if (textView2 == null) {
                C5544i0.m22554k("mTvPeopPhone");
            }
            SurveyPeopleBean surveyPeopleBean2 = this.f23377a;
            textView2.setText(surveyPeopleBean2 != null ? surveyPeopleBean2.getPeoplePhone() : null);
            TextView textView3 = this.mTvPeopCredentType;
            if (textView3 == null) {
                C5544i0.m22554k("mTvPeopCredentType");
            }
            SurveyPeopleBean surveyPeopleBean3 = this.f23377a;
            textView3.setText(surveyPeopleBean3 != null ? surveyPeopleBean3.getDocumentName() : null);
            SurveyPeopleBean surveyPeopleBean4 = this.f23377a;
            this.f23378b = String.valueOf(surveyPeopleBean4 != null ? surveyPeopleBean4.getDocumentNumber() : null);
            TextView textView4 = this.mEtPeopCredentNumber;
            if (textView4 == null) {
                C5544i0.m22554k("mEtPeopCredentNumber");
            }
            textView4.setText(this.f23378b);
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_victim_detail;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvPeopCredentType(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPeopCredentType = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setStepTwoBean(@InterfaceC5817e SurveyPeopleBean surveyPeopleBean) {
        this.f23377a = surveyPeopleBean;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final String m25392a() {
        return this.f23378b;
    }

    /* renamed from: a */
    public final void m25394a(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.f23378b = str;
    }
}
