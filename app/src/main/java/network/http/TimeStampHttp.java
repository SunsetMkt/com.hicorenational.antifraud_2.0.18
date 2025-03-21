package network.http;

import android.app.Activity;
import android.text.TextUtils;
import bean.TellNumHtyBean;
import com.google.gson.AbstractC2063k;
import com.google.gson.C2051e;
import com.google.gson.C2067o;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import network.account.APIresult;
import network.gson.ResponseDataTypeAdaptor;
import p388ui.Hicore;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7301n1;
import util.C7324u0;

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
        String lowerCase = C7324u0.m26608c(aPIresult.getSign()).toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        String str2 = "";
        sb.append("");
        try {
            str2 = C7324u0.m26598a(str, lowerCase, C7324u0.m26610d(sb.toString()).toLowerCase());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        C2051e buildGson = ResponseDataTypeAdaptor.buildGson();
        APIresult aPIresult2 = (APIresult) buildGson.m5569a(str2, (Class) APIresult.class);
        if (cls != null) {
            try {
                AbstractC2063k abstractC2063k = new C2067o().m5677a(str2).getAsJsonObject().get("data");
                if (abstractC2063k != null) {
                    Iterator<AbstractC2063k> it = new C2067o().m5677a(abstractC2063k.toString()).getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        arrayList.add(buildGson.m5564a(it.next(), (Type) cls));
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
        return analyzeParamList(aPIresult, new C2049a<V>() { // from class: network.http.TimeStampHttp.1
        }.getType());
    }

    private void failDeal(TimeStampCallback timeStampCallback, String str) {
        if (timeStampCallback != null) {
            if (TextUtils.isEmpty(str)) {
                str = Hicore.getApp().getResources().getString(C2113R.string.err_system);
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
            aPIresult.setMsg(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        }
    }

    public HashMap<String, String> buildParam(String str, T t) {
        String str2;
        if (t == null) {
            throw new NullPointerException("This orignalParam is Null");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String m5572a = ResponseDataTypeAdaptor.buildGson().m5572a(t);
            String lowerCase = C7324u0.m26608c(m5572a).toLowerCase();
            String lowerCase2 = C7324u0.m26608c(lowerCase).toLowerCase();
            String lowerCase3 = C7324u0.m26610d(str + "").toLowerCase();
            try {
                str2 = C7324u0.m26605b(m5572a, lowerCase2, lowerCase3);
                try {
                    C7301n1.m26457b("jsonStr encrypt-->", m5572a);
                    C7301n1.m26457b("signMD5 encrypt-->", lowerCase2);
                    C7301n1.m26457b("16MD5 encrypt-->", lowerCase3);
                    C7301n1.m26457b("jsonAES encrypt-->", str2);
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
            aPIresult = new APIresult<>(Hicore.getApp().getResources().getString(C2113R.string.err_system));
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
            return new APIresult<>(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        }
        String lowerCase = C7324u0.m26608c(sign).toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        String str2 = "";
        sb.append("");
        String lowerCase2 = C7324u0.m26610d(sb.toString()).toLowerCase();
        try {
            str2 = C7324u0.m26598a(str, lowerCase, lowerCase2);
            C7301n1.m26457b("jsonStr decrypt-->", str2);
            C7301n1.m26457b("signMD5 decrypt-->", lowerCase);
            C7301n1.m26457b("16MD5 decrypt-->", lowerCase2);
            C7301n1.m26457b("jsonAES decrypt-->", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        C2051e buildGson = ResponseDataTypeAdaptor.buildGson();
        TellNumHtyBean tellNumHtyBean = (APIresult<V>) ((APIresult) buildGson.m5569a(str2, (Class) APIresult.class));
        if (cls != null) {
            try {
                AbstractC2063k abstractC2063k = new C2067o().m5677a(str2).getAsJsonObject().get("data");
                if (abstractC2063k != null) {
                    tellNumHtyBean.setData(buildGson.m5570a(abstractC2063k.toString(), (Type) cls));
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
            aPIresult = new APIresult<>(Hicore.getApp().getResources().getString(C2113R.string.err_system));
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
            return new APIresult<>(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        }
        String lowerCase = C7324u0.m26608c(sign).toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        String str2 = "";
        sb.append("");
        String lowerCase2 = C7324u0.m26610d(sb.toString()).toLowerCase();
        try {
            str2 = C7324u0.m26598a(str, lowerCase, lowerCase2);
            C7301n1.m26457b("jsonStr decrypt-->", str2);
            C7301n1.m26457b("signMD5 decrypt-->", lowerCase);
            C7301n1.m26457b("16MD5 decrypt-->", lowerCase2);
            C7301n1.m26457b("jsonAES decrypt-->", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        C2051e buildGson = ResponseDataTypeAdaptor.buildGson();
        TellNumHtyBean tellNumHtyBean = (APIresult<V>) ((APIresult) buildGson.m5569a(str2, (Class) APIresult.class));
        if (type != null) {
            try {
                AbstractC2063k abstractC2063k = new C2067o().m5677a(str2).getAsJsonObject().get("data");
                if (abstractC2063k != null) {
                    tellNumHtyBean.setData(buildGson.m5570a(abstractC2063k.toString(), type));
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
