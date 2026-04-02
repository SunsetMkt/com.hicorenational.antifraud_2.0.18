package ui.activity;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CaseDivisonBean;
import bean.SurveyPeopleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import ui.callview.SurveyPeopEditView;
import ui.presenter.SurveyPeopleEditPresenter;
import util.e2;

/* JADX INFO: compiled from: VictimActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010=\u001a\u00020>H\u0016J\u0006\u0010?\u001a\u00020>J\u0010\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u00020>2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020FH\u0016J\u0006\u0010N\u001a\u00020>J\b\u0010O\u001a\u00020FH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001e\u0010.\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001e\u00101\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u00104\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006P"}, d2 = {"Lui/activity/VictimActivity;", "Lui/activity/BaseActivity;", "Lui/callview/SurveyPeopEditView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "documCode", "getDocumCode", "setDocumCode", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mEtPeopCredentNumber", "Landroid/widget/EditText;", "getMEtPeopCredentNumber", "()Landroid/widget/EditText;", "setMEtPeopCredentNumber", "(Landroid/widget/EditText;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/SurveyPeopleEditPresenter;", "getMPresenter", "()Lui/presenter/SurveyPeopleEditPresenter;", "setMPresenter", "(Lui/presenter/SurveyPeopleEditPresenter;)V", "mTvPeopCredentType", "Landroid/widget/TextView;", "getMTvPeopCredentType", "()Landroid/widget/TextView;", "setMTvPeopCredentType", "(Landroid/widget/TextView;)V", "mTvPeopName", "getMTvPeopName", "setMTvPeopName", "mTvPeopPhone", "getMTvPeopPhone", "setMTvPeopPhone", "mTvTitle", "getMTvTitle", "setMTvTitle", "peopId", "getPeopId", "setPeopId", "stepTwoBean", "Lbean/SurveyPeopleBean;", "getStepTwoBean", "()Lbean/SurveyPeopleBean;", "setStepTwoBean", "(Lbean/SurveyPeopleBean;)V", "initPage", "", "initViewData", "onClick", "view", "Landroid/view/View;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSuccessDocum", "bean", "Lbean/CaseDivisonBean;", "onSuccessHandle", "type", "onkeyback", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class VictimActivity extends BaseActivity implements SurveyPeopEditView {

    @BindView(R.id.btn_commit)
    @j.c.a.d
    public Button mBtnCommit;

    @BindView(R.id.et_peop_credent_number)
    @j.c.a.d
    public EditText mEtPeopCredentNumber;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @j.c.a.e
    private SurveyPeopleEditPresenter mPresenter;

    @BindView(R.id.tv_peop_credent_type)
    @j.c.a.d
    public TextView mTvPeopCredentType;

    @BindView(R.id.tv_peop_name)
    @j.c.a.d
    public EditText mTvPeopName;

    @BindView(R.id.tv_num_phone)
    @j.c.a.d
    public EditText mTvPeopPhone;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @j.c.a.e
    private SurveyPeopleBean stepTwoBean;

    @j.c.a.d
    private String caseInfoId = "";

    @j.c.a.d
    private String peopId = "";

    @j.c.a.d
    private String documCode = "0";

    /* JADX INFO: compiled from: VictimActivity.kt */
    public static final class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            VictimActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @j.c.a.d
    public final String getDocumCode() {
        return this.documCode;
    }

    @j.c.a.d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            i.q2.t.i0.k("mBtnCommit");
        }
        return button;
    }

    @j.c.a.d
    public final EditText getMEtPeopCredentNumber() {
        EditText editText = this.mEtPeopCredentNumber;
        if (editText == null) {
            i.q2.t.i0.k("mEtPeopCredentNumber");
        }
        return editText;
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
    public final SurveyPeopleEditPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final TextView getMTvPeopCredentType() {
        TextView textView = this.mTvPeopCredentType;
        if (textView == null) {
            i.q2.t.i0.k("mTvPeopCredentType");
        }
        return textView;
    }

    @j.c.a.d
    public final EditText getMTvPeopName() {
        EditText editText = this.mTvPeopName;
        if (editText == null) {
            i.q2.t.i0.k("mTvPeopName");
        }
        return editText;
    }

    @j.c.a.d
    public final EditText getMTvPeopPhone() {
        EditText editText = this.mTvPeopPhone;
        if (editText == null) {
            i.q2.t.i0.k("mTvPeopPhone");
        }
        return editText;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @j.c.a.d
    public final String getPeopId() {
        return this.peopId;
    }

    @j.c.a.e
    public final SurveyPeopleBean getStepTwoBean() {
        return this.stepTwoBean;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u4e8b\u4e3b\u4fe1\u606f");
        this.mPresenter = new SurveyPeopleEditPresenter(this, this);
        initViewData();
    }

    public final void initViewData() {
        String documentType;
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.stepTwoBean = (SurveyPeopleBean) getIntent().getSerializableExtra(util.p1.f15011c);
        if (this.stepTwoBean == null) {
            TextView textView = this.mTvPeopCredentType;
            if (textView == null) {
                i.q2.t.i0.k("mTvPeopCredentType");
            }
            textView.setText("\u8eab\u4efd\u8bc1");
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = this.mPresenter;
            if (surveyPeopleEditPresenter != null) {
                surveyPeopleEditPresenter.httpCredentType(true);
                return;
            }
            return;
        }
        EditText editText = this.mTvPeopName;
        if (editText == null) {
            i.q2.t.i0.k("mTvPeopName");
        }
        SurveyPeopleBean surveyPeopleBean = this.stepTwoBean;
        editText.setText(surveyPeopleBean != null ? surveyPeopleBean.getPeopleName() : null);
        EditText editText2 = this.mTvPeopPhone;
        if (editText2 == null) {
            i.q2.t.i0.k("mTvPeopPhone");
        }
        SurveyPeopleBean surveyPeopleBean2 = this.stepTwoBean;
        editText2.setText(surveyPeopleBean2 != null ? surveyPeopleBean2.getPeoplePhone() : null);
        EditText editText3 = this.mEtPeopCredentNumber;
        if (editText3 == null) {
            i.q2.t.i0.k("mEtPeopCredentNumber");
        }
        SurveyPeopleBean surveyPeopleBean3 = this.stepTwoBean;
        editText3.setText(String.valueOf(surveyPeopleBean3 != null ? surveyPeopleBean3.getDocumentNumber() : null));
        TextView textView2 = this.mTvPeopCredentType;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvPeopCredentType");
        }
        SurveyPeopleBean surveyPeopleBean4 = this.stepTwoBean;
        textView2.setText(surveyPeopleBean4 != null ? surveyPeopleBean4.getDocumentName() : null);
        SurveyPeopleBean surveyPeopleBean5 = this.stepTwoBean;
        this.peopId = String.valueOf(surveyPeopleBean5 != null ? surveyPeopleBean5.getVictimInfoID() : null);
        SurveyPeopleBean surveyPeopleBean6 = this.stepTwoBean;
        if (surveyPeopleBean6 == null || (documentType = surveyPeopleBean6.getDocumentType()) == null) {
            documentType = "0";
        }
        this.documCode = documentType;
        SurveyPeopleEditPresenter surveyPeopleEditPresenter2 = this.mPresenter;
        if (surveyPeopleEditPresenter2 != null) {
            surveyPeopleEditPresenter2.httpCredentType(false);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_peop_credent_type, R.id.btn_commit})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id == R.id.iv_back) {
                onkeyback();
                return;
            }
            if (id != R.id.tv_peop_credent_type) {
                return;
            }
            EditText editText = this.mEtPeopCredentNumber;
            if (editText == null) {
                i.q2.t.i0.k("mEtPeopCredentNumber");
            }
            editText.clearFocus();
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = this.mPresenter;
            if (surveyPeopleEditPresenter != null) {
                TextView textView = this.mTvPeopCredentType;
                if (textView == null) {
                    i.q2.t.i0.k("mTvPeopCredentType");
                }
                surveyPeopleEditPresenter.showCredentPiker(textView);
                return;
            }
            return;
        }
        EditText editText2 = this.mTvPeopName;
        if (editText2 == null) {
            i.q2.t.i0.k("mTvPeopName");
        }
        String string = editText2.getText().toString();
        EditText editText3 = this.mTvPeopPhone;
        if (editText3 == null) {
            i.q2.t.i0.k("mTvPeopPhone");
        }
        String string2 = editText3.getText().toString();
        if (TextUtils.isEmpty(string)) {
            e2.a("\u8bf7\u586b\u5199\u59d3\u540d");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            e2.a("\u8bf7\u586b\u5199\u7535\u8bdd\u53f7\u7801");
            return;
        }
        TextView textView2 = this.mTvPeopCredentType;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvPeopCredentType");
        }
        String string3 = textView2.getText().toString();
        EditText editText4 = this.mEtPeopCredentNumber;
        if (editText4 == null) {
            i.q2.t.i0.k("mEtPeopCredentNumber");
        }
        String string4 = editText4.getText().toString();
        if (TextUtils.isEmpty(string3)) {
            e2.a("\u8bf7\u9009\u62e9\u8bc1\u4ef6\u7c7b\u578b");
            return;
        }
        if (TextUtils.isEmpty(string4)) {
            e2.a("\u8bf7\u586b\u5199\u8bc1\u4ef6\u53f7");
            return;
        }
        int length = string4.length();
        if (i.z2.c0.c((CharSequence) string3, (CharSequence) "\u8eab\u4efd\u8bc1", false, 2, (Object) null) && (length < 15 || (length > 15 && length != 18))) {
            e2.a("\u8bc1\u4ef6\u53f7\u683c\u5f0f\u4e0d\u6b63\u786e");
            return;
        }
        SurveyPeopleBean surveyPeopleBean = new SurveyPeopleBean();
        surveyPeopleBean.setVictimInfoID(this.peopId);
        surveyPeopleBean.setCaseInfoID(this.caseInfoId);
        surveyPeopleBean.setPeopleName(string);
        surveyPeopleBean.setPeoplePhone(string2);
        surveyPeopleBean.setDocumentType(this.documCode);
        surveyPeopleBean.setDocumentName(string3);
        surveyPeopleBean.setDocumentNumber(string4);
        SurveyPeopleBean surveyPeopleBean2 = this.stepTwoBean;
        if (surveyPeopleBean2 != null) {
            surveyPeopleBean.setVictimInfoID(surveyPeopleBean2 != null ? surveyPeopleBean2.getVictimInfoID() : null);
        }
        SurveyPeopleEditPresenter surveyPeopleEditPresenter2 = this.mPresenter;
        if (surveyPeopleEditPresenter2 != null) {
            surveyPeopleEditPresenter2.editPersonInfo(surveyPeopleBean);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @j.c.a.d KeyEvent keyEvent) {
        i.q2.t.i0.f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.SurveyPeopEditView
    public void onSuccessDocum(@j.c.a.e CaseDivisonBean caseDivisonBean) {
        if (caseDivisonBean == null) {
            i.q2.t.i0.f();
        }
        String id = caseDivisonBean.getId();
        i.q2.t.i0.a((Object) id, "bean!!.id");
        this.documCode = id;
    }

    @Override // ui.callview.SurveyPeopEditView
    public void onSuccessHandle(int i2) {
        if (this.stepTwoBean != null) {
            e2.a("\u4fee\u6539\u6210\u529f");
        } else {
            e2.a("\u6dfb\u52a0\u6210\u529f");
        }
        finish();
    }

    public final void onkeyback() {
        util.f1.b(this.mActivity, "\u653e\u5f03\u672c\u6b21\u4fe1\u606f\u7f16\u8f91\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", new a());
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setDocumCode(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.documCode = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_victim;
    }

    public final void setMBtnCommit(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMEtPeopCredentNumber(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtPeopCredentNumber = editText;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e SurveyPeopleEditPresenter surveyPeopleEditPresenter) {
        this.mPresenter = surveyPeopleEditPresenter;
    }

    public final void setMTvPeopCredentType(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvPeopCredentType = textView;
    }

    public final void setMTvPeopName(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mTvPeopName = editText;
    }

    public final void setMTvPeopPhone(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mTvPeopPhone = editText;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setPeopId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.peopId = str;
    }

    public final void setStepTwoBean(@j.c.a.e SurveyPeopleBean surveyPeopleBean) {
        this.stepTwoBean = surveyPeopleBean;
    }
}
