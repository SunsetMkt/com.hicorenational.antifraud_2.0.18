package p388ui.view;

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
import p245d.C4440a;
import p388ui.view.C7248x;
import util.C7301n1;
import util.C7304o1;
import util.C7328v1;
import util.p396d2.C7271c;

/* compiled from: WebFullView.java */
/* renamed from: ui.view.x */
/* loaded from: classes2.dex */
public class C7248x {

    /* renamed from: a */
    private Activity f25089a;

    /* renamed from: b */
    private WebView f25090b;

    /* renamed from: c */
    private OnWebListener f25091c;

    /* renamed from: d */
    private b f25092d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebFullView.java */
    /* renamed from: ui.view.x$b */
    public class b {
        private b() {
        }

        /* renamed from: a */
        public /* synthetic */ void m26134a(String str) {
            C7248x.this.f25091c.webJsParame(str);
        }

        @JavascriptInterface
        public String getHCData() {
            return MyWebView.getH5Data();
        }

        @JavascriptInterface
        public void getPageParams(String str) {
            if (C7248x.this.f25089a == null || !TextUtils.equals("pageFinish=1", str) || C7248x.this.f25089a == null || C7248x.this.f25091c == null) {
                return;
            }
            C7248x.this.f25091c.webJsFinish();
        }

        @JavascriptInterface
        public void h5callAPP(final String str) {
            if (C7248x.this.f25091c != null) {
                C7248x.this.f25089a.runOnUiThread(new Runnable() { // from class: ui.view.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        C7248x.b.this.m26134a(str);
                    }
                });
            }
        }

        @JavascriptInterface
        public void sendWebMsg(String str) {
            if (C7248x.this.f25089a == null || C7248x.this.f25091c == null || TextUtils.isEmpty(str)) {
                return;
            }
            C7301n1.m26456b("sendWebMsg-->" + str);
            C7248x.this.f25091c.shouldIntercept(C7271c.m26331b(str));
        }
    }

    /* renamed from: b */
    public static String m26131b() {
        HashMap hashMap = new HashMap();
        hashMap.put("os-version", C7328v1.m26668i());
        if (AccountManager.isVerified()) {
            hashMap.put("verifiedStatus", "1");
        } else {
            hashMap.put("verifiedStatus", "0");
        }
        hashMap.put("phoneNumber", C7304o1.m26467a(AccountManager.getVisiblePhone()));
        hashMap.put(UserLoginInfo.f6638i, AccountManager.getAccountId());
        hashMap.put("registerRegionName", AccountManager.getRegisterRegionName());
        hashMap.put("registerRegionCode", AccountManager.getRegisterRegionCode());
        RegionMudelBean m16408j = C4440a.m16408j();
        if (m16408j == null) {
            hashMap.put("isLocalChannel", "");
            hashMap.put("androidh5host", "");
            hashMap.put("h5Url", "");
        } else {
            hashMap.put("isLocalChannel", m16408j.getIsLocalChannel());
            hashMap.put("androidh5host", m16408j.getAndroidh5host());
            hashMap.put("h5Url", m16408j.getH5Url());
        }
        return ResponseDataTypeAdaptor.buildGson().m5572a(hashMap);
    }

    /* renamed from: a */
    public void m26133a(Activity activity, WebView webView, OnWebListener onWebListener) {
        this.f25089a = activity;
        this.f25090b = webView;
        this.f25091c = onWebListener;
    }

    /* renamed from: a */
    public b m26132a() {
        if (this.f25092d == null) {
            this.f25092d = new b();
        }
        return this.f25092d;
    }
}
