package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.CriminalSmsBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.CriminalSmsCallView;
import p388ui.model.OSSModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CriminalSmsPresenter extends OSSModelPresent<CriminalSmsCallView> {

    /* renamed from: ui.presenter.CriminalSmsPresenter$a */
    class C6963a extends MiddleSubscriber<APIresult<List<CriminalSmsBean>>> {

        /* renamed from: ui.presenter.CriminalSmsPresenter$a$a */
        class a extends C2049a<List<CriminalSmsBean>> {
            a() {
            }
        }

        C6963a() {
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
        protected void onNextMiddle(APIresult<List<CriminalSmsBean>> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((CriminalSmsCallView) ((OSSModelPresent) CriminalSmsPresenter.this).mvpView).onSuccess(aPIresult.getData());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    /* renamed from: ui.presenter.CriminalSmsPresenter$b */
    class C6964b extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ int f24037a;

        C6964b(int i2) {
            this.f24037a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((CriminalSmsCallView) ((OSSModelPresent) CriminalSmsPresenter.this).mvpView).onSuccessDelete(this.f24037a);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public CriminalSmsPresenter(Activity activity, CriminalSmsCallView criminalSmsCallView) {
        super(activity, criminalSmsCallView);
    }

    public void deleteHttp(CriminalSmsBean criminalSmsBean, int i2) {
        String caseInfoID = criminalSmsBean.getCaseInfoID();
        String smsInfoID = criminalSmsBean.getSmsInfoID();
        if (TextUtils.isEmpty(caseInfoID) || TextUtils.isEmpty(smsInfoID)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", caseInfoID);
        hashMap.put("smsInfoID", smsInfoID);
        postOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17038R1), hashMap, new C6964b(i2));
    }

    public void http(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        smsList(hashMap, C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17032P1), new C6963a());
    }
}
