package util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import p388ui.Hicore;
import util.permissionutil.C7308a;

/* compiled from: NetworkUtil.java */
/* renamed from: util.q1 */
/* loaded from: classes2.dex */
public class C7313q1 {

    /* renamed from: a */
    public static final int f25573a = -1;

    /* renamed from: b */
    public static final int f25574b = 0;

    /* renamed from: c */
    public static final int f25575c = 1;

    /* renamed from: d */
    static String f25576d = "";

    /* renamed from: e */
    static int f25577e = 1;

    /* compiled from: NetworkUtil.java */
    /* renamed from: util.q1$a */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C7313q1.f25577e++;
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://ip.ifcert.cn/").openConnection();
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.7 Safari/537.36");
                if (httpURLConnection.getResponseCode() == 200) {
                    String readLine = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine();
                    if (TextUtils.isEmpty(readLine)) {
                        return;
                    }
                    C7313q1.f25576d = readLine;
                    String str = "您的IP地址是：" + C7313q1.f25576d;
                }
            } catch (Exception unused) {
                C7313q1.f25576d = "";
            }
        }
    }

    /* renamed from: a */
    public static String m26529a() {
        int type;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || (type = activeNetworkInfo.getType()) == 1 || type != 0) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        int subtype = activeNetworkInfo.getSubtype();
        return subtype == 13 ? "4G" : (subtype != 3 || ((TelephonyManager) Hicore.getApp().getSystemService("phone")).isNetworkRoaming()) ? "5G" : "3G";
    }

    /* renamed from: b */
    public static int m26530b() {
        TelephonyManager telephonyManager = (TelephonyManager) Hicore.getApp().getSystemService("phone");
        int i2 = -1;
        if (ContextCompat.checkSelfPermission(Hicore.getApp(), C7308a.f25529h) != 0) {
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (Build.VERSION.SDK_INT >= 17 && allCellInfo != null) {
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo instanceof CellInfoGsm) {
                        i2 = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoCdma) {
                        i2 = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            i2 = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                        }
                    } else if (cellInfo instanceof CellInfoLte) {
                        i2 = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: c */
    public static String m26531c() {
        if (!TextUtils.isEmpty(f25576d)) {
            return f25576d;
        }
        if (f25577e > 5) {
            return "";
        }
        new Thread(new a()).start();
        return TextUtils.isEmpty(f25576d) ? C7295l1.m26407a() : f25576d;
    }

    /* renamed from: d */
    public static int m26532d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 0;
            }
        }
        return -1;
    }

    /* renamed from: e */
    public static String m26533e() {
        int type;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || (type = activeNetworkInfo.getType()) == 1 || type != 0) ? UtilityImpl.NET_TYPE_WIFI : activeNetworkInfo.getSubtypeName();
    }

    /* renamed from: f */
    public static boolean m26534f() {
        NetworkInfo activeNetworkInfo;
        if (Hicore.getApp() == null || (activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }
}
