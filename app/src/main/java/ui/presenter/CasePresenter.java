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
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CasePresenter extends ModelPresent<CaseCallView> {
    private boolean isShowExitAlready;

    class a extends MiddleSubscriber<APIresult<String>> {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14293c;

        a(String str, String str2, String str3) {
            this.a = str;
            this.f14292b = str2;
            this.f14293c = str3;
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
                e2.e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                String data = aPIresult.getData();
                if (aPIresult.getData() != null && !TextUtils.isEmpty(data)) {
                    ((CaseCallView) CasePresenter.this.mvpView).onCreateSuccessRequest(data, this.a, this.f14292b, this.f14293c);
                    return;
                }
            }
            onErrorMiddle(APIException.getApiExcept(aPIresult));
        }
    }

    class b extends MiddleSubscriber<APIresult<CaseHistoryBean>> {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
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
                ((CaseCallView) CasePresenter.this.mvpView).onHistorySuccessRequest(null, this.a);
                e2.e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CaseHistoryBean> aPIresult) {
            CaseHistoryBean data;
            if (aPIresult == null || aPIresult.getCode() != 0 || (data = aPIresult.getData()) == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onHistorySuccessRequest(data, this.a);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        final /* synthetic */ CaseHistoryBean.Rows a;

        c(CaseHistoryBean.Rows rows) {
            this.a = rows;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (CasePresenter.this.isShowExitAlready) {
                return;
            }
            if (super.dealPoliceExit(aPIException)) {
                CasePresenter.this.isShowExitAlready = true;
            } else {
                e2.e(aPIException.getMessage());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseCallView) CasePresenter.this.mvpView).onDeleteSuccessRequest(this.a);
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
                e2.e(aPIException.getMessage());
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

    private void caseHistoryHttp(HashMap<String, String> map, int i2) {
        caseHistoryList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.R0), map, new b(i2));
    }

    private void createCaseHttp(HashMap<String, String> map, String str, String str2, String str3) {
        savexc(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.Q0), map, new a(str, str2, str3));
    }

    public void caseHistory(int i2, int i3, int i4) {
        HashMap<String, String> map = new HashMap<>();
        map.put("policeMobile", e.b.b());
        map.put(NotificationCompat.CATEGORY_STATUS, i2 + "");
        map.put("page", i3 + "");
        map.put("rows", i4 + "");
        map.put("sort", "");
        map.put("order", "");
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        caseHistoryHttp(map, i2);
    }

    public void caseStatus() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("policeMobile", e.b.b());
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.W0), map, new d());
    }

    public void createCase(String str, String str2, long j2, String str3) {
        HashMap<String, String> map = new HashMap<>();
        map.put("policeMobile", e.b.b());
        map.put("caseName", str);
        map.put("caseNumber", str2);
        map.put("caseCategory", j2 + "");
        createCaseHttp(map, str, str2, str3);
    }

    public void deleteCase(CaseHistoryBean.Rows rows) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", rows.getId());
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.S0), map, new c(rows));
    }
}
