package p388ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.HistoryReportEvdCallView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class HistoryReportEvdPresenter extends ModelPresent<HistoryReportEvdCallView> {
    private Activity mActivity;

    /* renamed from: ui.presenter.HistoryReportEvdPresenter$a */
    class C6998a extends MiddleSubscriber<APIresult<HistoryListInfo>> {
        C6998a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HistoryListInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HistoryReportEvdCallView) HistoryReportEvdPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HistoryListInfo> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((HistoryReportEvdCallView) HistoryReportEvdPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public HistoryReportEvdPresenter(Activity activity, HistoryReportEvdCallView historyReportEvdCallView) {
        super(activity, historyReportEvdCallView);
    }

    public void getReportList(int i2, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("submitterID", AccountManager.getAccountId());
        hashMap.put("objectType", "0");
        hashMap.put("page", i2 + "");
        hashMap.put("rows", i3 + "");
        uploadParam(hashMap, C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17045U), new C6998a());
    }

    public void uploadParam(HashMap<String, String> hashMap, String str, MiddleSubscriber<APIresult<HistoryListInfo>> middleSubscriber) {
        getReportHistorys(hashMap, str, middleSubscriber);
    }
}
