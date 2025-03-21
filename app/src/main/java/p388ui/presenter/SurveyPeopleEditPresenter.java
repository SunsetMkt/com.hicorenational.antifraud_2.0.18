package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import bean.CaseDivisonBean;
import bean.SurveyPeopleBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p023b.p024a.p025a.p027e.C0922h;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.SurveyPeopEditView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class SurveyPeopleEditPresenter extends ModelPresent<SurveyPeopEditView> {
    private List<CaseDivisonBean> credentTypeBeans;

    /* renamed from: ui.presenter.SurveyPeopleEditPresenter$a */
    class C7092a extends C0922h.a {

        /* renamed from: a */
        final /* synthetic */ TextView f24335a;

        C7092a(TextView textView) {
            this.f24335a = textView;
        }

        @Override // p023b.p024a.p025a.p027e.C0922h.a
        /* renamed from: b */
        public void mo971b(int i2, String str) {
            this.f24335a.setText(str);
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = SurveyPeopleEditPresenter.this;
            ((SurveyPeopEditView) surveyPeopleEditPresenter.mvpView).onSuccessDocum((CaseDivisonBean) surveyPeopleEditPresenter.credentTypeBeans.get(i2));
        }
    }

    /* renamed from: ui.presenter.SurveyPeopleEditPresenter$b */
    class C7093b extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* renamed from: a */
        final /* synthetic */ boolean f24337a;

        /* renamed from: ui.presenter.SurveyPeopleEditPresenter$b$a */
        class a extends C2049a<List<CaseDivisonBean>> {
            a() {
            }
        }

        C7093b(boolean z) {
            this.f24337a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CaseDivisonBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                return;
            }
            SurveyPeopleEditPresenter.this.credentTypeBeans = aPIresult.getData();
            if (this.f24337a) {
                for (int i2 = 0; i2 < SurveyPeopleEditPresenter.this.credentTypeBeans.size(); i2++) {
                    if (TextUtils.equals("身份证", ((CaseDivisonBean) SurveyPeopleEditPresenter.this.credentTypeBeans.get(i2)).getName())) {
                        SurveyPeopleEditPresenter surveyPeopleEditPresenter = SurveyPeopleEditPresenter.this;
                        ((SurveyPeopEditView) surveyPeopleEditPresenter.mvpView).onSuccessDocum((CaseDivisonBean) surveyPeopleEditPresenter.credentTypeBeans.get(i2));
                    }
                }
            }
        }
    }

    /* renamed from: ui.presenter.SurveyPeopleEditPresenter$c */
    class C7094c extends MiddleSubscriber<APIresult> {
        C7094c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                ((SurveyPeopEditView) SurveyPeopleEditPresenter.this.mvpView).onSuccessHandle(2);
            } else {
                C7331w1.m26688a(aPIresult.getMsg());
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    public SurveyPeopleEditPresenter(Activity activity, SurveyPeopEditView surveyPeopEditView) {
        super(activity, surveyPeopEditView);
        this.credentTypeBeans = new ArrayList();
    }

    private void editPersonInfoHttp(HashMap<String, String> hashMap) {
        surveyAddCasePerson(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17073c1), hashMap, new C7094c());
    }

    public void editPersonInfo(SurveyPeopleBean surveyPeopleBean) {
        C7257b1.m26203a("请稍后...", true, this.mActivity);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("victimInfoID", surveyPeopleBean.getVictimInfoID());
        hashMap.put(CommonNetImpl.NAME, surveyPeopleBean.getPeopleName());
        hashMap.put("mobileNumber", surveyPeopleBean.getPeoplePhone());
        hashMap.put("documentType", TextUtils.isEmpty(surveyPeopleBean.getDocumentType()) ? "0" : surveyPeopleBean.getDocumentType());
        hashMap.put("documentTypeText", surveyPeopleBean.getDocumentName());
        hashMap.put("documentNumber", surveyPeopleBean.getDocumentNumber());
        hashMap.put("caseInfoID", surveyPeopleBean.getCaseInfoID());
        editPersonInfoHttp(hashMap);
    }

    public void httpCredentType(boolean z) {
        surveyCredentType(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17085f1), new C7093b(z));
    }

    public void showCredentPiker(TextView textView) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.credentTypeBeans.size(); i2++) {
            arrayList.add(this.credentTypeBeans.get(i2).getName());
        }
        if (arrayList.size() == 0) {
            return;
        }
        C0922h c0922h = new C0922h(this.mActivity, arrayList);
        c0922h.m1017x(3);
        c0922h.m979E(0);
        c0922h.m998C(15);
        c0922h.setOnOptionPickListener(new C7092a(textView));
        c0922h.m1045m();
    }
}
