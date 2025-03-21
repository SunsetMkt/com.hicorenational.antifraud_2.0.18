package network.http;

import android.app.Activity;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.ReportNewActivity;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ReportNumHttp extends ModelPresent {
    private static ReportNumHttp mHttp;

    public interface Callback {
        void onNumSuccess();
    }

    private ReportNumHttp() {
        super((Activity) null, (BaseView) null);
    }

    public static ReportNumHttp getInstance() {
        if (mHttp == null) {
            mHttp = new ReportNumHttp();
        }
        return mHttp;
    }

    public void principalHttp(final Callback callback) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17080e0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("submitterID", AccountManager.getAccountId());
        getReportNum(m16395a, hashMap, new MiddleSubscriber<APIresult<Integer>>() { // from class: network.http.ReportNumHttp.1
            @Override // network.MiddleSubscriber
            protected Type getType() {
                return Integer.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                super.onErrorMiddle(aPIException);
                C7331w1.m26696e(aPIException.getMessage());
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<Integer> aPIresult) {
                super.onNextMiddle(aPIresult);
                if (aPIresult == null) {
                    onErrorMiddle(APIException.getApiExcept());
                    return;
                }
                if (aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                    return;
                }
                int intValue = aPIresult.getData().intValue();
                if (intValue <= 0) {
                    C7331w1.m26688a("今日举报数量超限，请明日再试");
                } else {
                    ReportNewActivity.REPORTNUM = intValue;
                    callback.onNumSuccess();
                }
            }
        });
    }
}
