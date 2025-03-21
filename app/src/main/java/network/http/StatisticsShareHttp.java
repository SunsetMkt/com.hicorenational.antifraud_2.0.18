package network.http;

import android.app.Activity;
import java.util.HashMap;
import manager.AccountManager;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;

/* loaded from: classes2.dex */
public class StatisticsShareHttp extends ModelPresent {
    private static final String SOURCE_ARTICLE = "2";
    public static final String SOURCE_CHECK = "3";
    public static final String SOURCE_ME = "1";
    public static final String SOURCE_QUESTION = "4";
    private static StatisticsShareHttp mHttp;

    public interface Callback {
        void checkResult(boolean z);
    }

    private StatisticsShareHttp() {
        super((Activity) null, (BaseView) null);
    }

    public static StatisticsShareHttp getInstance() {
        if (mHttp == null) {
            mHttp = new StatisticsShareHttp();
        }
        return mHttp;
    }

    private void shareHttp(HashMap<String, String> hashMap) {
    }

    public void shareArticleHttp(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("source", "2");
        hashMap.put("sourceID", str);
        hashMap.put("policeUserID", AccountManager.getPoliceUserID());
        hashMap.put("pCode", AccountManager.getPoliceUserPCode());
        shareHttp(hashMap);
    }

    public void shareOtherHttp(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("source", str);
        hashMap.put("policeUserID", AccountManager.getPoliceUserID());
        hashMap.put("pCode", AccountManager.getPoliceUserPCode());
        shareHttp(hashMap);
    }
}
