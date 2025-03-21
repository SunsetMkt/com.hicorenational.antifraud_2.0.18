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
import ui.view.x;
import util.n1;
import util.o1;
import util.v1;

/* compiled from: WebFullView.java */
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private Activity f20700a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f20701b;

    /* renamed from: c, reason: collision with root package name */
    private OnWebListener f20702c;

    /* renamed from: d, reason: collision with root package name */
    private b f20703d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebFullView.java */
    public class b {
        private b() {
        }

        public /* synthetic */ void a(String str) {
            x.this.f20702c.webJsParame(str);
        }

        @JavascriptInterface
        public String getHCData() {
            return MyWebView.getH5Data();
        }

        @JavascriptInterface
        public void getPageParams(String str) {
            if (x.this.f20700a == null || !TextUtils.equals("pageFinish=1", str) || x.this.f20700a == null || x.this.f20702c == null) {
                return;
            }
            x.this.f20702c.webJsFinish();
        }

        @JavascriptInterface
        public void h5callAPP(final String str) {
            if (x.this.f20702c != null) {
                x.this.f20700a.runOnUiThread(new Runnable() { // from class: ui.view.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.b.this.a(str);
                    }
                });
            }
        }

        @JavascriptInterface
        public void sendWebMsg(String str) {
            if (x.this.f20700a == null || x.this.f20702c == null || TextUtils.isEmpty(str)) {
                return;
            }
            n1.b("sendWebMsg-->" + str);
            x.this.f20702c.shouldIntercept(util.d2.c.b(str));
        }
    }

    public static String b() {
        HashMap hashMap = new HashMap();
        hashMap.put("os-version", v1.i());
        if (AccountManager.isVerified()) {
            hashMap.put("verifiedStatus", "1");
        } else {
            hashMap.put("verifiedStatus", "0");
        }
        hashMap.put("phoneNumber", o1.a(AccountManager.getVisiblePhone()));
        hashMap.put(UserLoginInfo.f6190i, AccountManager.getAccountId());
        hashMap.put("registerRegionName", AccountManager.getRegisterRegionName());
        hashMap.put("registerRegionCode", AccountManager.getRegisterRegionCode());
        RegionMudelBean j2 = d.a.j();
        if (j2 == null) {
            hashMap.put("isLocalChannel", "");
            hashMap.put("androidh5host", "");
            hashMap.put("h5Url", "");
        } else {
            hashMap.put("isLocalChannel", j2.getIsLocalChannel());
            hashMap.put("androidh5host", j2.getAndroidh5host());
            hashMap.put("h5Url", j2.getH5Url());
        }
        return ResponseDataTypeAdaptor.buildGson().a(hashMap);
    }

    public void a(Activity activity, WebView webView, OnWebListener onWebListener) {
        this.f20700a = activity;
        this.f20701b = webView;
        this.f20702c = onWebListener;
    }

    public b a() {
        if (this.f20703d == null) {
            this.f20703d = new b();
        }
        return this.f20703d;
    }
}
