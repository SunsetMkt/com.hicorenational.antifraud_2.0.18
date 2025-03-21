package network.http;

import android.app.Activity;
import android.text.TextUtils;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class StatisticsHttp extends ModelPresent {
    private static StatisticsHttp mHttp;

    public interface Callback {
        void checkResult(boolean z);
    }

    public interface CallbackComplete {
        void onComplete();
    }

    private StatisticsHttp() {
        super((Activity) null, (BaseView) null);
    }

    public static StatisticsHttp getInstance() {
        if (mHttp == null) {
            mHttp = new StatisticsHttp();
        }
        return mHttp;
    }

    private void trackWarn(String str, String str2, final CallbackComplete callbackComplete) {
        RegionMudelBean m16408j = C4440a.m16408j();
        if (m16408j == null || TextUtils.isEmpty(m16408j.getLocalApi())) {
            if (callbackComplete != null) {
                callbackComplete.onComplete();
            }
        } else {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("operation", str);
            trackData(C4440a.m16395a("", 8, str2), hashMap, new MiddleSubscriber<APIresult>() { // from class: network.http.StatisticsHttp.2
                @Override // network.MiddleSubscriber
                protected void onCompleteMiddle() {
                    CallbackComplete callbackComplete2 = callbackComplete;
                    if (callbackComplete2 != null) {
                        callbackComplete2.onComplete();
                    }
                }

                @Override // network.MiddleSubscriber
                protected void onErrorMiddle(APIException aPIException) {
                }

                @Override // network.MiddleSubscriber
                protected void onNextMiddle(APIresult aPIresult) {
                }
            });
        }
    }

    public void pageOpenHttp(String str) {
    }

    public void trackPageClick(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", str);
        trackData(C4440a.m16395a(ModuelConfig.MODEL_WARN, 8, C4445b.f17103l0), hashMap, new MiddleSubscriber<APIresult>() { // from class: network.http.StatisticsHttp.1
            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult aPIresult) {
            }
        });
    }

    public void trackWarnApp(String str, CallbackComplete callbackComplete) {
        trackWarn(str, C4445b.f17112o0, callbackComplete);
    }

    public void trackWarnCall(String str, CallbackComplete callbackComplete) {
        trackWarn(str, C4445b.f17106m0, callbackComplete);
    }

    public void trackWarnSms(String str, CallbackComplete callbackComplete) {
        trackWarn(str, C4445b.f17109n0, callbackComplete);
    }
}
