package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import bean.CaseHistoryBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p245d.C4441b;
import p247e.C4445b;
import p388ui.callview.CaseCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CasePresenter extends ModelPresent<CaseCallView> {
    private boolean isShowExitAlready;

    /* renamed from: ui.presenter.CasePresenter$a */
    class C6942a extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a */
        final /* synthetic */ String f24003a;

        /* renamed from: b */
        final /* synthetic */ String f24004b;

        /* renamed from: c */
        final /* synthetic */ String f24005c;

        C6942a(String str, String str2, String str3) {
            this.f24003a = str;
            this.f24004b = str2;
            this.f24005c = str3;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (CasePresenter.this.isShowExitAlready) {
                return;
            }
            if (super.dealPoliceExit(aPIException)) {
                CasePresenter.this.isShowExitAlready = true;
            } else {
                C7331w1.m26696e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                String data = aPIresult.getData();
                if (aPIresult.getData() != null && !TextUtils.isEmpty(data)) {
                    ((CaseCallView) CasePresenter.this.mvpView).onCreateSuccessRequest(data, this.f24003a, this.f24004b, this.f24005c);
                    return;
                }
            }
            onErrorMiddle(APIException.getApiExcept(aPIresult));
        }
    }

    /* renamed from: ui.presenter.CasePresenter$b */
    class C6943b extends MiddleSubscriber<APIresult<CaseHistoryBean>> {

        /* renamed from: a */
        final /* synthetic */ int f24007a;

        C6943b(int i2) {
            this.f24007a = i2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CaseHistoryBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (CasePresenter.this.isShowExitAlready) {
                return;
            }
            if (super.dealPoliceExit(aPIException)) {
                CasePresenter.this.isShowExitAlready = true;
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onHistorySuccessRequest(null, this.f24007a);
                C7331w1.m26696e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CaseHistoryBean> aPIresult) {
            CaseHistoryBean data;
            if (aPIresult == null || aPIresult.getCode() != 0 || (data = aPIresult.getData()) == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onHistorySuccessRequest(data, this.f24007a);
            }
        }
    }

    /* renamed from: ui.presenter.CasePresenter$c */
    class C6944c extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ CaseHistoryBean.Rows f24009a;

        C6944c(CaseHistoryBean.Rows rows) {
            this.f24009a = rows;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (CasePresenter.this.isShowExitAlready) {
                return;
            }
            if (super.dealPoliceExit(aPIException)) {
                CasePresenter.this.isShowExitAlready = true;
            } else {
                C7331w1.m26696e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onDeleteSuccessRequest(this.f24009a);
            }
        }
    }

    /* renamed from: ui.presenter.CasePresenter$d */
    class C6945d extends MiddleSubscriber<APIresult> {
        C6945d() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.TYPE;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (CasePresenter.this.isShowExitAlready) {
                return;
            }
            if (super.dealPoliceExit(aPIException)) {
                CasePresenter.this.isShowExitAlready = true;
            } else {
                C7331w1.m26696e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onStatusSuccessRequest(((Boolean) aPIresult.getData()).booleanValue());
            }
        }
    }

    public CasePresenter(Activity activity, CaseCallView caseCallView) {
        super(activity, caseCallView);
        this.isShowExitAlready = false;
    }

    private void caseHistoryHttp(HashMap<String, String> hashMap, int i2) {
        caseHistoryList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17034Q0), hashMap, new C6943b(i2));
    }

    private void createCaseHttp(HashMap<String, String> hashMap, String str, String str2, String str3) {
        savexc(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17031P0), hashMap, new C6942a(str, str2, str3));
    }

    public void caseHistory(int i2, int i3, int i4) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("policeMobile", C4441b.m16414b());
        hashMap.put(NotificationCompat.CATEGORY_STATUS, i2 + "");
        hashMap.put("page", i3 + "");
        hashMap.put("rows", i4 + "");
        hashMap.put("sort", "");
        hashMap.put("order", "");
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        caseHistoryHttp(hashMap, i2);
    }

    public void caseStatus() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("policeMobile", C4441b.m16414b());
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17049V0), hashMap, new C6945d());
    }

    public void createCase(String str, String str2, long j2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("policeMobile", C4441b.m16414b());
        hashMap.put("caseName", str);
        hashMap.put("caseNumber", str2);
        hashMap.put("caseCategory", j2 + "");
        createCaseHttp(hashMap, str, str2, str3);
    }

    public void deleteCase(CaseHistoryBean.Rows rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", rows.getId());
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17037R0), hashMap, new C6944c(rows));
    }
}
