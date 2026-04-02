package network.http;

import android.app.Activity;
import android.text.TextUtils;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import e.a;
import f.b;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticsHttp extends ModelPresent {
    private static StatisticsHttp mHttp;

    /* JADX INFO: renamed from: network.http.StatisticsHttp$1 */
    class AnonymousClass1 extends MiddleSubscriber<APIresult> {
        AnonymousClass1() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
        }
    }

    /* JADX INFO: renamed from: network.http.StatisticsHttp$2 */
    class AnonymousClass2 extends MiddleSubscriber<APIresult> {
        final /* synthetic */ CallbackComplete val$callback;

        AnonymousClass2(CallbackComplete callbackComplete) {
            callbackComplete = callbackComplete;
        }

        @Override // network.MiddleSubscriber
        protected void onCompleteMiddle() {
            CallbackComplete callbackComplete = callbackComplete;
            if (callbackComplete != null) {
                callbackComplete.onComplete();
            }
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
        }
    }

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

    private void trackWarn(String str, String str2, CallbackComplete callbackComplete) {
        RegionMudelBean regionMudelBeanJ = a.j();
        if (regionMudelBeanJ == null || TextUtils.isEmpty(regionMudelBeanJ.getLocalApi())) {
            if (callbackComplete != null) {
                callbackComplete.onComplete();
            }
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put("operation", str);
            trackData(a.b("", 8, str2), map, new MiddleSubscriber<APIresult>() { // from class: network.http.StatisticsHttp.2
                final /* synthetic */ CallbackComplete val$callback;

                AnonymousClass2(CallbackComplete callbackComplete2) {
                    callbackComplete = callbackComplete2;
                }

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
        HashMap<String, String> map = new HashMap<>();
        map.put("type", str);
        trackData(a.b(ModuelConfig.MODEL_WARN, 8, b.m0), map, new MiddleSubscriber<APIresult>() { // from class: network.http.StatisticsHttp.1
            AnonymousClass1() {
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult aPIresult) {
            }
        });
    }

    public void trackWarnApp(String str, CallbackComplete callbackComplete) {
        trackWarn(str, b.p0, callbackComplete);
    }

    public void trackWarnCall(String str, CallbackComplete callbackComplete) {
        trackWarn(str, b.n0, callbackComplete);
    }

    public void trackWarnSms(String str, CallbackComplete callbackComplete) {
        trackWarn(str, b.o0, callbackComplete);
    }
}
