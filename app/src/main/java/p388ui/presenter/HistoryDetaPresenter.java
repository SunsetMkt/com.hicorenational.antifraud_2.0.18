package p388ui.presenter;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.HistoryDetailInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.HistoryDetailCallView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class HistoryDetaPresenter extends ModelPresent<HistoryDetailCallView> {

    /* renamed from: ui.presenter.HistoryDetaPresenter$a */
    class C6997a extends MiddleSubscriber<APIresult<HistoryDetailInfo>> {
        C6997a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HistoryDetailInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HistoryDetailCallView) HistoryDetaPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HistoryDetailInfo> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((HistoryDetailCallView) HistoryDetaPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public HistoryDetaPresenter(Activity activity, HistoryDetailCallView historyDetailCallView) {
        super(activity, historyDetailCallView);
    }

    public void getDetail(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        uploadParam(hashMap, C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17048V), new C6997a());
    }

    public void uploadParam(HashMap<String, String> hashMap, String str, MiddleSubscriber<APIresult<HistoryDetailInfo>> middleSubscriber) {
        getReportdetail(hashMap, str, middleSubscriber);
    }
}
