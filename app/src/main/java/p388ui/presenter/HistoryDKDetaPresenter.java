package p388ui.presenter;

import android.app.Activity;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.HistoryDetailInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.callview.HistoryDetailCallView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class HistoryDKDetaPresenter extends ModelPresent<HistoryDetailCallView> {

    /* renamed from: ui.presenter.HistoryDKDetaPresenter$a */
    class C6996a extends MiddleSubscriber<APIresult<HistoryDetailInfo>> {
        C6996a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HistoryDetailInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HistoryDetailCallView) HistoryDKDetaPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HistoryDetailInfo> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((HistoryDetailCallView) HistoryDKDetaPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
        }
    }

    public HistoryDKDetaPresenter(Activity activity, HistoryDetailCallView historyDetailCallView) {
        super(activity, historyDetailCallView);
    }

    public void getDetail(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        uploadParam(hashMap, "url", new C6996a());
    }

    public void uploadParam(HashMap<String, String> hashMap, String str, MiddleSubscriber<APIresult<HistoryDetailInfo>> middleSubscriber) {
        getReportdetail(hashMap, str, middleSubscriber);
    }
}
