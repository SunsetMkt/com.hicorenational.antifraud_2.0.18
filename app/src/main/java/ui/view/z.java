package ui.view;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import bean.module.RegionMudelBean;
import com.hihonor.honorid.core.data.UserLoginInfo;
import interfaces.OnWebListener;
import java.util.HashMap;
import manager.AccountManager;
import network.gson.ResponseDataTypeAdaptor;
import util.d2;
import util.s1;
import util.t1;

/* JADX INFO: compiled from: WebFullView.java */
/* JADX INFO: loaded from: classes2.dex */
public class z {
    private Activity a;

    /* JADX INFO: renamed from: b */
    private WebView f14836b;

    /* JADX INFO: renamed from: c */
    private OnWebListener f14837c;

    /* JADX INFO: renamed from: d */
    private b f14838d;

    /* JADX INFO: compiled from: WebFullView.java */
    public class b {
        private b() {
        }

        public /* synthetic */ void a(String str) {
            z.this.f14837c.webJsParame(str);
        }

        @JavascriptInterface
        public String getHCData() {
            return MyWebView.getH5Data();
        }

        @JavascriptInterface
        public void getPageParams(String str) {
            if (z.this.a == null || !TextUtils.equals("pageFinish=1", str) || z.this.a == null || z.this.f14837c == null) {
                return;
            }
            z.this.f14837c.webJsFinish();
        }

        @JavascriptInterface
        public void h5callAPP(final String str) {
            if (z.this.f14837c != null) {
                z.this.a.runOnUiThread(new Runnable() { // from class: ui.view.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(str);
                    }
                });
            }
        }

        @JavascriptInterface
        public void sendWebMsg(String str) {
            if (z.this.a == null || z.this.f14837c == null || TextUtils.isEmpty(str)) {
                return;
            }
            s1.b("sendWebMsg-->" + str);
            z.this.f14837c.shouldIntercept(util.o2.c.b(str));
        }

        /* synthetic */ b(z zVar, a aVar) {
            this();
        }
    }

    public static String b() {
        HashMap map = new HashMap();
        map.put("os-version", d2.i());
        if (AccountManager.isVerified()) {
            map.put("verifiedStatus", "1");
        } else {
            map.put("verifiedStatus", "0");
        }
        map.put("phoneNumber", t1.a(AccountManager.getVisiblePhone()));
        map.put(UserLoginInfo.f4187i, AccountManager.getAccountId());
        map.put("registerRegionName", AccountManager.getRegisterRegionName());
        map.put("registerRegionCode", AccountManager.getRegisterRegionCode());
        RegionMudelBean regionMudelBeanJ = e.a.j();
        if (regionMudelBeanJ == null) {
            map.put("isLocalChannel", "");
            map.put("androidh5host", "");
            map.put("h5Url", "");
        } else {
            map.put("isLocalChannel", regionMudelBeanJ.getIsLocalChannel());
            map.put("androidh5host", regionMudelBeanJ.getAndroidh5host());
            map.put("h5Url", regionMudelBeanJ.getH5Url());
        }
        return ResponseDataTypeAdaptor.buildGson().a(map);
    }

    public void a(Activity activity, WebView webView, OnWebListener onWebListener) {
        this.a = activity;
        this.f14836b = webView;
        this.f14837c = onWebListener;
    }

    public b a() {
        if (this.f14838d == null) {
            this.f14838d = new b();
        }
        return this.f14838d;
    }
}
