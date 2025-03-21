package p388ui.presenter;

import android.app.Activity;
import bean.ReportIDInfoBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.basemvp.BaseView;
import p388ui.callview.ReportIDInfoView;
import p388ui.model.ModelPresent;
import util.C7257b1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class SurveyReportPresenter extends ModelPresent {
    private ReportIDInfoView mView;

    /* renamed from: ui.presenter.SurveyReportPresenter$a */
    class C7095a extends MiddleSubscriber<APIresult<ReportIDInfoBean>> {
        C7095a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return ReportIDInfoBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<ReportIDInfoBean> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                SurveyReportPresenter.this.mView.ReportIDInfoBean(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.SurveyReportPresenter$b */
    class C7096b extends MiddleSubscriber<APIresult> {
        C7096b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() == 0) {
                SurveyReportPresenter.this.mView.onsuccessReportID();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    /* renamed from: ui.presenter.SurveyReportPresenter$c */
    class C7097c extends MiddleSubscriber<APIresult<Integer>> {
        C7097c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            SurveyReportPresenter.this.mView.onfailCaseNum();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Integer> aPIresult) {
            if (aPIresult.getCode() == 0) {
                SurveyReportPresenter.this.mView.onSuccessCaseNum(aPIresult.getData().intValue());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public SurveyReportPresenter(Activity activity) {
        super(activity, (BaseView) null);
    }

    private void httpCaseInfoById(HashMap<String, String> hashMap) {
        getCaseInfoById(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17065a1), hashMap, new C7095a());
    }

    private void httpConfirmCaseInfoById(HashMap<String, String> hashMap) {
        getCaseInfoById(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17069b1), hashMap, new C7096b());
    }

    public void ConfirmCaseInfoById(String str) {
        C7257b1.m26193a(this.mActivity, "请稍后...");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        httpConfirmCaseInfoById(hashMap);
    }

    public void getCaseBankNum() {
        getCaseBankNum(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17082e2), new C7097c());
    }

    public void getCaseInfoById(String str) {
        C7257b1.m26193a(this.mActivity, "请求中...");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        httpCaseInfoById(hashMap);
    }

    public SurveyReportPresenter(Activity activity, ReportIDInfoView reportIDInfoView) {
        super(activity, reportIDInfoView);
        this.mView = reportIDInfoView;
    }
}
