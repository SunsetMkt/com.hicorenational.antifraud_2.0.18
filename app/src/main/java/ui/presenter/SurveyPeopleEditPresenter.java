package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import bean.CaseDivisonBean;
import bean.SurveyPeopleBean;
import bean.module.ModuelConfig;
import c.a.a.e.h;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.SurveyPeopEditView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;

/* JADX INFO: loaded from: classes2.dex */
public class SurveyPeopleEditPresenter extends ModelPresent<SurveyPeopEditView> {
    private List<CaseDivisonBean> credentTypeBeans;

    class a extends h.a {
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        @Override // c.a.a.e.h.a
        public void b(int i2, String str) {
            this.a.setText(str);
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = SurveyPeopleEditPresenter.this;
            ((SurveyPeopEditView) surveyPeopleEditPresenter.mvpView).onSuccessDocum((CaseDivisonBean) surveyPeopleEditPresenter.credentTypeBeans.get(i2));
        }
    }

    class b extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {
        final /* synthetic */ boolean a;

        class a extends com.google.gson.d0.a<List<CaseDivisonBean>> {
            a() {
            }
        }

        b(boolean z) {
            this.a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CaseDivisonBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                return;
            }
            SurveyPeopleEditPresenter.this.credentTypeBeans = aPIresult.getData();
            if (this.a) {
                for (int i2 = 0; i2 < SurveyPeopleEditPresenter.this.credentTypeBeans.size(); i2++) {
                    if (TextUtils.equals("\u8eab\u4efd\u8bc1", ((CaseDivisonBean) SurveyPeopleEditPresenter.this.credentTypeBeans.get(i2)).getName())) {
                        SurveyPeopleEditPresenter surveyPeopleEditPresenter = SurveyPeopleEditPresenter.this;
                        ((SurveyPeopEditView) surveyPeopleEditPresenter.mvpView).onSuccessDocum((CaseDivisonBean) surveyPeopleEditPresenter.credentTypeBeans.get(i2));
                    }
                }
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                ((SurveyPeopEditView) SurveyPeopleEditPresenter.this.mvpView).onSuccessHandle(2);
            } else {
                e2.a(aPIresult.getMsg());
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    public SurveyPeopleEditPresenter(Activity activity, SurveyPeopEditView surveyPeopEditView) {
        super(activity, surveyPeopEditView);
        this.credentTypeBeans = new ArrayList();
    }

    private void editPersonInfoHttp(HashMap<String, String> map) {
        surveyAddCasePerson(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.d1), map, new c());
    }

    public void editPersonInfo(SurveyPeopleBean surveyPeopleBean) {
        f1.a("\u8bf7\u7a0d\u540e...", true, this.mActivity);
        HashMap<String, String> map = new HashMap<>();
        map.put("victimInfoID", surveyPeopleBean.getVictimInfoID());
        map.put(CommonNetImpl.NAME, surveyPeopleBean.getPeopleName());
        map.put("mobileNumber", surveyPeopleBean.getPeoplePhone());
        map.put("documentType", TextUtils.isEmpty(surveyPeopleBean.getDocumentType()) ? "0" : surveyPeopleBean.getDocumentType());
        map.put("documentTypeText", surveyPeopleBean.getDocumentName());
        map.put("documentNumber", surveyPeopleBean.getDocumentNumber());
        map.put("caseInfoID", surveyPeopleBean.getCaseInfoID());
        editPersonInfoHttp(map);
    }

    public void httpCredentType(boolean z) {
        surveyCredentType(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.g1), new b(z));
    }

    public void showCredentPiker(TextView textView) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.credentTypeBeans.size(); i2++) {
            arrayList.add(this.credentTypeBeans.get(i2).getName());
        }
        if (arrayList.size() == 0) {
            return;
        }
        c.a.a.e.h hVar = new c.a.a.e.h(this.mActivity, arrayList);
        hVar.x(3);
        hVar.E(0);
        hVar.C(15);
        hVar.setOnOptionPickListener(new a(textView));
        hVar.m();
    }
}
