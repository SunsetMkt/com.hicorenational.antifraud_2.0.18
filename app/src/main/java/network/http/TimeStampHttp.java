package network.http;

import android.app.Activity;
import android.text.TextUtils;
import bean.TellNumHtyBean;
import com.google.gson.d0.a;
import com.google.gson.e;
import com.google.gson.k;
import com.google.gson.o;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import network.account.APIresult;
import network.gson.ResponseDataTypeAdaptor;
import ui.Hicore;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.n1;
import util.u0;

/* loaded from: classes2.dex */
public class TimeStampHttp<T> extends ModelPresent {
    static TimeStampHttp stampHttp;
    private String TAG;

    public interface TimeStampCallback {
        void onSuccess(HashMap hashMap);

        void onfail(String str);
    }

    private TimeStampHttp() {
        super((Activity) null, (BaseView) null);
        this.TAG = TimeStampHttp.class.getSimpleName();
    }

    public static <V> List<APIresult<V>> analyzeListParam(APIresult<List<V>> aPIresult, Class<V> cls) {
        ArrayList arrayList = new ArrayList();
        if (!(aPIresult instanceof APIresult)) {
            systemError(aPIresult);
            return null;
        }
        String str = aPIresult.getsData();
        String timestamp = aPIresult.getTimestamp();
        String lowerCase = u0.c(aPIresult.getSign()).toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        String str2 = "";
        sb.append("");
        try {
            str2 = u0.a(str, lowerCase, u0.d(sb.toString()).toLowerCase());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e buildGson = ResponseDataTypeAdaptor.buildGson();
        APIresult aPIresult2 = (APIresult) buildGson.a(str2, (Class) APIresult.class);
        if (cls != null) {
            try {
                k kVar = new o().a(str2).getAsJsonObject().get("data");
                if (kVar != null) {
                    Iterator<k> it = new o().a(kVar.toString()).getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        arrayList.add(buildGson.a(it.next(), (Type) cls));
                    }
                    aPIresult2.setData(arrayList);
                } else {
                    aPIresult2.setData(null);
                }
            } catch (Exception unused) {
            }
        }
        systemError(aPIresult2);
        return arrayList;
    }

    public static <V> APIresult<V> analyzeParam(APIresult<V> aPIresult) {
        return analyzeParam(aPIresult, null);
    }

    public static <V> APIresult<V> analyzeParamList(APIresult<V> aPIresult) {
        return analyzeParamList(aPIresult, new a<V>() { // from class: network.http.TimeStampHttp.1
        }.getType());
    }

    private void failDeal(TimeStampCallback timeStampCallback, String str) {
        if (timeStampCallback != null) {
            if (TextUtils.isEmpty(str)) {
                str = Hicore.getApp().getResources().getString(R.string.err_system);
            }
            timeStampCallback.onfail(str);
        }
    }

    public static TimeStampHttp getInstance() {
        stampHttp = new TimeStampHttp();
        return stampHttp;
    }

    private static <V> void systemError(APIresult<V> aPIresult) {
        if (aPIresult.getCode() == 999) {
            aPIresult.setMsg(Hicore.getApp().getResources().getString(R.string.err_system));
        }
    }

    public HashMap<String, String> buildParam(String str, T t) {
        String str2;
        if (t == null) {
            throw new NullPointerException("This orignalParam is Null");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String a2 = ResponseDataTypeAdaptor.buildGson().a(t);
            String lowerCase = u0.c(a2).toLowerCase();
            String lowerCase2 = u0.c(lowerCase).toLowerCase();
            String lowerCase3 = u0.d(str + "").toLowerCase();
            try {
                str2 = u0.b(a2, lowerCase2, lowerCase3);
                try {
                    n1.b("jsonStr encrypt-->", a2);
                    n1.b("signMD5 encrypt-->", lowerCase2);
                    n1.b("16MD5 encrypt-->", lowerCase3);
                    n1.b("jsonAES encrypt-->", str2);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    String replaceAll = str2.replaceAll("[\\s*\t\n\r]", "");
                    hashMap.put("timestamp", str + "");
                    hashMap.put("data", replaceAll);
                    hashMap.put("sign", lowerCase);
                    return hashMap;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = "";
            }
            String replaceAll2 = str2.replaceAll("[\\s*\t\n\r]", "");
            hashMap.put("timestamp", str + "");
            hashMap.put("data", replaceAll2);
            hashMap.put("sign", lowerCase);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return hashMap;
    }

    public void principalHttp(T t, TimeStampCallback timeStampCallback) {
        if (t == null) {
            throw new NullPointerException("This orignalParam is Null");
        }
        String str = System.currentTimeMillis() + "";
        if (timeStampCallback != null) {
            timeStampCallback.onSuccess(buildParam(str, t));
        }
        stampHttp = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> APIresult<V> analyzeParam(APIresult<V> aPIresult, Class<V> cls) {
        if (aPIresult == null) {
            aPIresult = new APIresult<>(Hicore.getApp().getResources().getString(R.string.err_system));
        }
        if (!(aPIresult instanceof APIresult)) {
            systemError(aPIresult);
            return aPIresult;
        }
        String str = aPIresult.getsData();
        if (TextUtils.isEmpty(str)) {
            return aPIresult;
        }
        String timestamp = aPIresult.getTimestamp();
        String sign = aPIresult.getSign();
        if (TextUtils.isEmpty(timestamp) || TextUtils.isEmpty(sign)) {
            return new APIresult<>(Hicore.getApp().getResources().getString(R.string.err_system));
        }
        String lowerCase = u0.c(sign).toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        String str2 = "";
        sb.append("");
        String lowerCase2 = u0.d(sb.toString()).toLowerCase();
        try {
            str2 = u0.a(str, lowerCase, lowerCase2);
            n1.b("jsonStr decrypt-->", str2);
            n1.b("signMD5 decrypt-->", lowerCase);
            n1.b("16MD5 decrypt-->", lowerCase2);
            n1.b("jsonAES decrypt-->", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e buildGson = ResponseDataTypeAdaptor.buildGson();
        TellNumHtyBean tellNumHtyBean = (APIresult<V>) ((APIresult) buildGson.a(str2, (Class) APIresult.class));
        if (cls != null) {
            try {
                k kVar = new o().a(str2).getAsJsonObject().get("data");
                if (kVar != null) {
                    tellNumHtyBean.setData(buildGson.a(kVar.toString(), (Type) cls));
                } else {
                    tellNumHtyBean.setData(null);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                tellNumHtyBean.setData(null);
            }
        }
        systemError(tellNumHtyBean);
        return tellNumHtyBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> APIresult<V> analyzeParamList(APIresult<V> aPIresult, Type type) {
        if (aPIresult == null) {
            aPIresult = new APIresult<>(Hicore.getApp().getResources().getString(R.string.err_system));
        }
        if (!(aPIresult instanceof APIresult)) {
            systemError(aPIresult);
            return aPIresult;
        }
        String str = aPIresult.getsData();
        if (TextUtils.isEmpty(str)) {
            return aPIresult;
        }
        String timestamp = aPIresult.getTimestamp();
        String sign = aPIresult.getSign();
        if (TextUtils.isEmpty(timestamp) || TextUtils.isEmpty(sign)) {
            return new APIresult<>(Hicore.getApp().getResources().getString(R.string.err_system));
        }
        String lowerCase = u0.c(sign).toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        String str2 = "";
        sb.append("");
        String lowerCase2 = u0.d(sb.toString()).toLowerCase();
        try {
            str2 = u0.a(str, lowerCase, lowerCase2);
            n1.b("jsonStr decrypt-->", str2);
            n1.b("signMD5 decrypt-->", lowerCase);
            n1.b("16MD5 decrypt-->", lowerCase2);
            n1.b("jsonAES decrypt-->", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e buildGson = ResponseDataTypeAdaptor.buildGson();
        TellNumHtyBean tellNumHtyBean = (APIresult<V>) ((APIresult) buildGson.a(str2, (Class) APIresult.class));
        if (type != null) {
            try {
                k kVar = new o().a(str2).getAsJsonObject().get("data");
                if (kVar != null) {
                    tellNumHtyBean.setData(buildGson.a(kVar.toString(), type));
                } else {
                    tellNumHtyBean.setData(null);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                tellNumHtyBean.setData(null);
            }
        }
        systemError(tellNumHtyBean);
        return tellNumHtyBean;
    }
}
