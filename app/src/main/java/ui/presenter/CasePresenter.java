package ui.presenter;

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
import ui.callview.CaseCallView;
import ui.model.ModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CasePresenter extends ModelPresent<CaseCallView> {
    private boolean isShowExitAlready;

    class a extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19816a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19817b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19818c;

        a(String str, String str2, String str3) {
            this.f19816a = str;
            this.f19817b = str2;
            this.f19818c = str3;
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
                w1.e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                String data = aPIresult.getData();
                if (aPIresult.getData() != null && !TextUtils.isEmpty(data)) {
                    ((CaseCallView) CasePresenter.this.mvpView).onCreateSuccessRequest(data, this.f19816a, this.f19817b, this.f19818c);
                    return;
                }
            }
            onErrorMiddle(APIException.getApiExcept(aPIresult));
        }
    }

    class b extends MiddleSubscriber<APIresult<CaseHistoryBean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19820a;

        b(int i2) {
            this.f19820a = i2;
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
                ((CaseCallView) CasePresenter.this.mvpView).onHistorySuccessRequest(null, this.f19820a);
                w1.e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CaseHistoryBean> aPIresult) {
            CaseHistoryBean data;
            if (aPIresult == null || aPIresult.getCode() != 0 || (data = aPIresult.getData()) == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onHistorySuccessRequest(data, this.f19820a);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseHistoryBean.Rows f19822a;

        c(CaseHistoryBean.Rows rows) {
            this.f19822a = rows;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (CasePresenter.this.isShowExitAlready) {
                return;
            }
            if (super.dealPoliceExit(aPIException)) {
                CasePresenter.this.isShowExitAlready = true;
            } else {
                w1.e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onDeleteSuccessRequest(this.f19822a);
            }
        }
    }

    class d extends MiddleSubscriber<APIresult> {
        d() {
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
                w1.e(aPIException.getMessage());
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
        caseHistoryList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.Q0), hashMap, new b(i2));
    }

    private void createCaseHttp(HashMap<String, String> hashMap, String str, String str2, String str3) {
        savexc(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.P0), hashMap, new a(str, str2, str3));
    }

    public void caseHistory(int i2, int i3, int i4) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("policeMobile", d.b.b());
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
        hashMap.put("policeMobile", d.b.b());
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.V0), hashMap, new d());
    }

    public void createCase(String str, String str2, long j2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("policeMobile", d.b.b());
        hashMap.put("caseName", str);
        hashMap.put("caseNumber", str2);
        hashMap.put("caseCategory", j2 + "");
        createCaseHttp(hashMap, str, str2, str3);
    }

    public void deleteCase(CaseHistoryBean.Rows rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", rows.getId());
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.R0), hashMap, new c(rows));
    }
}
