package network.http;

import android.app.Activity;
import bean.module.ModuelConfig;
import e.a;
import f.b;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.ReportNewActivity;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class ReportNumHttp extends ModelPresent {
    private static ReportNumHttp mHttp;

    /* JADX INFO: renamed from: network.http.ReportNumHttp$1 */
    class AnonymousClass1 extends MiddleSubscriber<APIresult<Integer>> {
        final /* synthetic */ Callback val$callback;

        AnonymousClass1(Callback callback) {
            callback = callback;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Integer.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            e2.e(aPIException.getMessage());
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
            int iIntValue = aPIresult.getData().intValue();
            if (iIntValue <= 0) {
                e2.a("\u4eca\u65e5\u4e3e\u62a5\u6570\u91cf\u8d85\u9650\uff0c\u8bf7\u660e\u65e5\u518d\u8bd5");
            } else {
                ReportNewActivity.REPORTNUM = iIntValue;
                callback.onNumSuccess();
            }
        }
    }

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

    public void principalHttp(Callback callback) {
        String strB = a.b(ModuelConfig.MODEL_REPORT, 5, b.f0);
        HashMap<String, String> map = new HashMap<>();
        map.put("submitterID", AccountManager.getAccountId());
        getReportNum(strB, map, new MiddleSubscriber<APIresult<Integer>>() { // from class: network.http.ReportNumHttp.1
            final /* synthetic */ Callback val$callback;

            AnonymousClass1(Callback callback2) {
                callback = callback2;
            }

            @Override // network.MiddleSubscriber
            protected Type getType() {
                return Integer.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                super.onErrorMiddle(aPIException);
                e2.e(aPIException.getMessage());
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
                int iIntValue = aPIresult.getData().intValue();
                if (iIntValue <= 0) {
                    e2.a("\u4eca\u65e5\u4e3e\u62a5\u6570\u91cf\u8d85\u9650\uff0c\u8bf7\u660e\u65e5\u518d\u8bd5");
                } else {
                    ReportNewActivity.REPORTNUM = iIntValue;
                    callback.onNumSuccess();
                }
            }
        });
    }
}
