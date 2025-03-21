package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.SurveyPeopEditView;
import p388ui.presenter.SurveyPeopleEditPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* compiled from: VictimActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010=\u001a\u00020>H\u0016J\u0006\u0010?\u001a\u00020>J\u0010\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u00020>2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020FH\u0016J\u0006\u0010N\u001a\u00020>J\b\u0010O\u001a\u00020FH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001e\u0010.\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001e\u00101\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u00104\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006P"}, m23546d2 = {"Lui/activity/VictimActivity;", "Lui/activity/BaseActivity;", "Lui/callview/SurveyPeopEditView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "documCode", "getDocumCode", "setDocumCode", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mEtPeopCredentNumber", "Landroid/widget/EditText;", "getMEtPeopCredentNumber", "()Landroid/widget/EditText;", "setMEtPeopCredentNumber", "(Landroid/widget/EditText;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/SurveyPeopleEditPresenter;", "getMPresenter", "()Lui/presenter/SurveyPeopleEditPresenter;", "setMPresenter", "(Lui/presenter/SurveyPeopleEditPresenter;)V", "mTvPeopCredentType", "Landroid/widget/TextView;", "getMTvPeopCredentType", "()Landroid/widget/TextView;", "setMTvPeopCredentType", "(Landroid/widget/TextView;)V", "mTvPeopName", "getMTvPeopName", "setMTvPeopName", "mTvPeopPhone", "getMTvPeopPhone", "setMTvPeopPhone", "mTvTitle", "getMTvTitle", "setMTvTitle", "peopId", "getPeopId", "setPeopId", "stepTwoBean", "Lbean/SurveyPeopleBean;", "getStepTwoBean", "()Lbean/SurveyPeopleBean;", "setStepTwoBean", "(Lbean/SurveyPeopleBean;)V", "initPage", "", "initViewData", "onClick", "view", "Landroid/view/View;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSuccessDocum", "bean", "Lbean/CaseDivisonBean;", "onSuccessHandle", "type", "onkeyback", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class VictimActivity extends BaseActivity implements SurveyPeopEditView {

    @BindView(C2113R.id.btn_commit)
    @InterfaceC5816d
    public Button mBtnCommit;

    @BindView(C2113R.id.et_peop_credent_number)
    @InterfaceC5816d
    public EditText mEtPeopCredentNumber;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private SurveyPeopleEditPresenter mPresenter;

    @BindView(C2113R.id.tv_peop_credent_type)
    @InterfaceC5816d
    public TextView mTvPeopCredentType;

    @BindView(C2113R.id.tv_peop_name)
    @InterfaceC5816d
    public EditText mTvPeopName;

    @BindView(C2113R.id.tv_num_phone)
    @InterfaceC5816d
    public EditText mTvPeopPhone;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5817e
    private SurveyPeopleBean stepTwoBean;

    @InterfaceC5816d
    private String caseInfoId = "";

    @InterfaceC5816d
    private String peopId = "";

    @InterfaceC5816d
    private String documCode = "0";

    /* compiled from: VictimActivity.kt */
    /* renamed from: ui.activity.VictimActivity$a */
    public static final class C6656a implements IClickListener {
        C6656a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            VictimActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @InterfaceC5816d
    public final String getDocumCode() {
        return this.documCode;
    }

    @InterfaceC5816d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            C5544i0.m22554k("mBtnCommit");
        }
        return button;
    }

    @InterfaceC5816d
    public final EditText getMEtPeopCredentNumber() {
        EditText editText = this.mEtPeopCredentNumber;
        if (editText == null) {
            C5544i0.m22554k("mEtPeopCredentNumber");
        }
        return editText;
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
    public final SurveyPeopleEditPresenter getMPresenter() {
        return this.mPresenter;
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
    public final EditText getMTvPeopName() {
        EditText editText = this.mTvPeopName;
        if (editText == null) {
            C5544i0.m22554k("mTvPeopName");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMTvPeopPhone() {
        EditText editText = this.mTvPeopPhone;
        if (editText == null) {
            C5544i0.m22554k("mTvPeopPhone");
        }
        return editText;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5816d
    public final String getPeopId() {
        return this.peopId;
    }

    @InterfaceC5817e
    public final SurveyPeopleBean getStepTwoBean() {
        return this.stepTwoBean;
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
        textView.setText("事主信息");
        this.mPresenter = new SurveyPeopleEditPresenter(this, this);
        initViewData();
    }

    public final void initViewData() {
        String str;
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.stepTwoBean = (SurveyPeopleBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        if (this.stepTwoBean == null) {
            TextView textView = this.mTvPeopCredentType;
            if (textView == null) {
                C5544i0.m22554k("mTvPeopCredentType");
            }
            textView.setText("身份证");
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = this.mPresenter;
            if (surveyPeopleEditPresenter != null) {
                surveyPeopleEditPresenter.httpCredentType(true);
                return;
            }
            return;
        }
        EditText editText = this.mTvPeopName;
        if (editText == null) {
            C5544i0.m22554k("mTvPeopName");
        }
        SurveyPeopleBean surveyPeopleBean = this.stepTwoBean;
        editText.setText(surveyPeopleBean != null ? surveyPeopleBean.getPeopleName() : null);
        EditText editText2 = this.mTvPeopPhone;
        if (editText2 == null) {
            C5544i0.m22554k("mTvPeopPhone");
        }
        SurveyPeopleBean surveyPeopleBean2 = this.stepTwoBean;
        editText2.setText(surveyPeopleBean2 != null ? surveyPeopleBean2.getPeoplePhone() : null);
        EditText editText3 = this.mEtPeopCredentNumber;
        if (editText3 == null) {
            C5544i0.m22554k("mEtPeopCredentNumber");
        }
        SurveyPeopleBean surveyPeopleBean3 = this.stepTwoBean;
        editText3.setText(String.valueOf(surveyPeopleBean3 != null ? surveyPeopleBean3.getDocumentNumber() : null));
        TextView textView2 = this.mTvPeopCredentType;
        if (textView2 == null) {
            C5544i0.m22554k("mTvPeopCredentType");
        }
        SurveyPeopleBean surveyPeopleBean4 = this.stepTwoBean;
        textView2.setText(surveyPeopleBean4 != null ? surveyPeopleBean4.getDocumentName() : null);
        SurveyPeopleBean surveyPeopleBean5 = this.stepTwoBean;
        this.peopId = String.valueOf(surveyPeopleBean5 != null ? surveyPeopleBean5.getVictimInfoID() : null);
        SurveyPeopleBean surveyPeopleBean6 = this.stepTwoBean;
        if (surveyPeopleBean6 == null || (str = surveyPeopleBean6.getDocumentType()) == null) {
            str = "0";
        }
        this.documCode = str;
        SurveyPeopleEditPresenter surveyPeopleEditPresenter2 = this.mPresenter;
        if (surveyPeopleEditPresenter2 != null) {
            surveyPeopleEditPresenter2.httpCredentType(false);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_peop_credent_type, C2113R.id.btn_commit})
    public final void onClick(@InterfaceC5816d View view) {
        boolean m23774c;
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id == C2113R.id.iv_back) {
                onkeyback();
                return;
            }
            if (id != C2113R.id.tv_peop_credent_type) {
                return;
            }
            EditText editText = this.mEtPeopCredentNumber;
            if (editText == null) {
                C5544i0.m22554k("mEtPeopCredentNumber");
            }
            editText.clearFocus();
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = this.mPresenter;
            if (surveyPeopleEditPresenter != null) {
                TextView textView = this.mTvPeopCredentType;
                if (textView == null) {
                    C5544i0.m22554k("mTvPeopCredentType");
                }
                surveyPeopleEditPresenter.showCredentPiker(textView);
                return;
            }
            return;
        }
        EditText editText2 = this.mTvPeopName;
        if (editText2 == null) {
            C5544i0.m22554k("mTvPeopName");
        }
        String obj = editText2.getText().toString();
        EditText editText3 = this.mTvPeopPhone;
        if (editText3 == null) {
            C5544i0.m22554k("mTvPeopPhone");
        }
        String obj2 = editText3.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请填写姓名");
            return;
        }
        if (TextUtils.isEmpty(obj2)) {
            C7331w1.m26688a("请填写电话号码");
            return;
        }
        TextView textView2 = this.mTvPeopCredentType;
        if (textView2 == null) {
            C5544i0.m22554k("mTvPeopCredentType");
        }
        String obj3 = textView2.getText().toString();
        EditText editText4 = this.mEtPeopCredentNumber;
        if (editText4 == null) {
            C5544i0.m22554k("mEtPeopCredentNumber");
        }
        String obj4 = editText4.getText().toString();
        if (TextUtils.isEmpty(obj3)) {
            C7331w1.m26688a("请选择证件类型");
            return;
        }
        if (TextUtils.isEmpty(obj4)) {
            C7331w1.m26688a("请填写证件号");
            return;
        }
        int length = obj4.length();
        m23774c = C5726c0.m23774c((CharSequence) obj3, (CharSequence) "身份证", false, 2, (Object) null);
        if (m23774c && (length < 15 || (length > 15 && length != 18))) {
            C7331w1.m26688a("证件号格式不正确");
            return;
        }
        SurveyPeopleBean surveyPeopleBean = new SurveyPeopleBean();
        surveyPeopleBean.setVictimInfoID(this.peopId);
        surveyPeopleBean.setCaseInfoID(this.caseInfoId);
        surveyPeopleBean.setPeopleName(obj);
        surveyPeopleBean.setPeoplePhone(obj2);
        surveyPeopleBean.setDocumentType(this.documCode);
        surveyPeopleBean.setDocumentName(obj3);
        surveyPeopleBean.setDocumentNumber(obj4);
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
    public boolean onKeyDown(int i2, @InterfaceC5816d KeyEvent keyEvent) {
        C5544i0.m22546f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.callview.SurveyPeopEditView
    public void onSuccessDocum(@InterfaceC5817e CaseDivisonBean caseDivisonBean) {
        if (caseDivisonBean == null) {
            C5544i0.m22545f();
        }
        String id = caseDivisonBean.getId();
        C5544i0.m22521a((Object) id, "bean!!.id");
        this.documCode = id;
    }

    @Override // p388ui.callview.SurveyPeopEditView
    public void onSuccessHandle(int i2) {
        if (this.stepTwoBean != null) {
            C7331w1.m26688a("修改成功");
        } else {
            C7331w1.m26688a("添加成功");
        }
        finish();
    }

    public final void onkeyback() {
        C7257b1.m26211b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new C6656a());
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setDocumCode(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.documCode = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_victim;
    }

    public final void setMBtnCommit(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMEtPeopCredentNumber(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtPeopCredentNumber = editText;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e SurveyPeopleEditPresenter surveyPeopleEditPresenter) {
        this.mPresenter = surveyPeopleEditPresenter;
    }

    public final void setMTvPeopCredentType(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPeopCredentType = textView;
    }

    public final void setMTvPeopName(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mTvPeopName = editText;
    }

    public final void setMTvPeopPhone(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mTvPeopPhone = editText;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setPeopId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.peopId = str;
    }

    public final void setStepTwoBean(@InterfaceC5817e SurveyPeopleBean surveyPeopleBean) {
        this.stepTwoBean = surveyPeopleBean;
    }
}
