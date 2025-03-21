package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C3072b;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.biz.C3111b;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.C3127c;
import com.tencent.bugly.crashreport.crash.C3128d;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.p206h5.C3132b;
import com.tencent.bugly.crashreport.crash.p206h5.H5JavaScriptInterface;
import com.tencent.bugly.proguard.C3143af;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3152ao;
import com.tencent.bugly.proguard.C3154aq;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashReport {

    /* renamed from: a */
    private static Context f10077a;

    /* compiled from: BUGLY */
    public static class CrashHandleCallback extends BuglyStrategy.C3070a {
    }

    /* compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: c */
        CrashHandleCallback f10079c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.f9809a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.f9810b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i2) {
            this.f9809a = i2;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.f9810b = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f10079c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f10079c;
        }
    }

    /* compiled from: BUGLY */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void closeBugly() {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized() && f10077a != null) {
            BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
            if (buglyBroadcastReceiver != null) {
                buglyBroadcastReceiver.unregister(f10077a);
            }
            closeCrashReport();
            C3111b.m9492a(f10077a);
            C3150am m9906a = C3150am.m9906a();
            if (m9906a != null) {
                m9906a.m9910b();
            }
        }
    }

    public static void closeCrashReport() {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            C3127c.m9705a().m9718d();
        }
    }

    public static void closeNativeReport() {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            C3127c.m9705a().m9721g();
        }
    }

    public static void enableBugly(boolean z) {
        C3072b.f9832a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (C3072b.f9832a && context != null) {
            String str = "Enable identification obtaining? " + z;
            C3113a.m9531a(context).m9563b(z);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        return !C3072b.f9832a ? new HashSet() : context == null ? new HashSet() : C3113a.m9531a(context).m9539E();
    }

    public static String getAppChannel() {
        return (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) ? C3113a.m9531a(f10077a).f10211s : "unknown";
    }

    public static String getAppID() {
        return (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) ? C3113a.m9531a(f10077a).m9571f() : "unknown";
    }

    public static String getAppVer() {
        return (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) ? C3113a.m9531a(f10077a).f10208p : "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return C3113a.m9531a(context).m9564c();
        }
        C3151an.m9922d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static Proxy getHttpProxy() {
        return C3152ao.m9925a();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!C3072b.f9832a) {
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return C3113a.m9531a(f10077a).f10144K;
        }
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!C3072b.f9832a || context == null) {
            return "unknown";
        }
        if (C3154aq.m9970a(str)) {
            return null;
        }
        return C3113a.m9531a(context).m9574g(str);
    }

    public static int getUserDatasSize(Context context) {
        if (C3072b.f9832a && context != null) {
            return C3113a.m9531a(context).m9538D();
        }
        return -1;
    }

    public static String getUserId() {
        return (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) ? C3113a.m9531a(f10077a).m9573g() : "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (C3072b.f9832a && context != null) {
            return C3113a.m9531a(context).m9542H();
        }
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f10077a = context;
        if (C3113a.m9531a(context) != null && "oversea".equals(C3113a.m9531a(context).f10139F)) {
            StrategyBean.f10225b = "http://astat.bugly.qcloud.com/rqd/async";
            StrategyBean.f10226c = "http://astat.bugly.qcloud.com/rqd/async";
        }
        C3072b.m9312a(CrashModule.getInstance());
        C3072b.m9308a(context);
    }

    public static boolean isLastSessionCrash() {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            return C3127c.m9705a().m9716b();
        }
        return false;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            C3128d.m9739a(thread, i2, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || C3154aq.m9970a(str) || C3154aq.m9970a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            String.format("putSdkData key length over limit %d, will be cutted.", 50);
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            String.format("putSdkData value length over limit %d, will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        C3113a.m9531a(context).m9566c(replace, str2);
        C3151an.m9918b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (C3072b.f9832a && context != null) {
            if (str == null) {
                String str3 = "" + str;
                C3151an.m9922d("putUserData args key should not be null or empty", new Object[0]);
                return;
            }
            if (str2 == null) {
                String str4 = "" + str2;
                C3151an.m9922d("putUserData args value should not be null", new Object[0]);
                return;
            }
            if (!str.matches("[a-zA-Z[0-9]]+")) {
                C3151an.m9922d("putUserData args key should match [a-zA-Z[0-9]]+  {" + str + "}", new Object[0]);
                return;
            }
            if (str2.length() > 200) {
                C3151an.m9922d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            C3113a m9531a = C3113a.m9531a(context);
            if (m9531a.m9539E().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str2);
                }
                C3113a.m9531a(context).m9562b(str, str2);
                C3151an.m9921c("replace KV %s %s", str, str2);
                return;
            }
            if (m9531a.m9538D() >= 10) {
                C3151an.m9922d("user data size is over limit %d, it will be cutted!", 10);
                return;
            }
            if (str.length() > 50) {
                C3151an.m9922d("user data key length over limit %d , will drop this new key %s", 50, str);
                str = str.substring(0, 50);
            }
            NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
            if (nativeCrashHandler2 != null) {
                nativeCrashHandler2.putKeyValueToNative(str, str2);
            }
            C3113a.m9531a(context).m9562b(str, str2);
            C3151an.m9918b("[param] set user data: %s - %s", str, str2);
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!C3072b.f9832a || context == null) {
            return "unknown";
        }
        if (C3154aq.m9970a(str)) {
            return null;
        }
        C3151an.m9918b("[param] remove user data: %s", str);
        return C3113a.m9531a(context).m9572f(str);
    }

    public static void setAppChannel(Context context, String str) {
        if (!C3072b.f9832a || context == null || str == null) {
            return;
        }
        C3113a.m9531a(context).f10211s = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!C3072b.f9832a || context == null || str == null) {
            return;
        }
        C3113a.m9531a(context).f10196d = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!C3072b.f9832a || context == null || str == null) {
            return;
        }
        C3113a.m9531a(context).f10208p = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setAuditEnable(Context context, boolean z) {
        if (C3072b.f9832a && context != null) {
            String str = "Set audit enable: " + z;
            C3113a.m9531a(context).f10145L = z;
        }
    }

    public static void setBuglyDbName(String str) {
        if (C3072b.f9832a) {
            String str2 = "Set Bugly DB name: " + str;
            C3143af.f10501a = str;
        }
    }

    public static void setContext(Context context) {
        f10077a = context;
    }

    public static void setCrashFilter(String str) {
        if (C3072b.f9832a) {
            String str2 = "Set crash stack filter: " + str;
            C3127c.f10373n = str;
        }
    }

    public static void setCrashRegularFilter(String str) {
        if (C3072b.f9832a) {
            String str2 = "Set crash stack filter: " + str;
            C3127c.f10374o = str;
        }
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (C3072b.f9832a) {
            String str = "Should handle native crash in Java profile after handled in native profile: " + z;
            NativeCrashHandler.setShouldHandleInJava(z);
        }
    }

    public static void setHttpProxy(String str, int i2) {
        C3152ao.m9926a(str, i2);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (C3072b.f9832a) {
            if (context == null) {
                C3151an.m9922d("Context should not be null.", new Object[0]);
                return;
            }
            if (z) {
                C3151an.m9921c("App is in foreground.", new Object[0]);
            } else {
                C3151an.m9921c("App is in background.", new Object[0]);
            }
            C3113a.m9531a(context).m9558a(z);
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (C3072b.f9832a) {
            if (context == null) {
                C3151an.m9922d("Context should not be null.", new Object[0]);
                return;
            }
            if (z) {
                C3151an.m9921c("This is a development device.", new Object[0]);
            } else {
                C3151an.m9921c("This is not a development device.", new Object[0]);
            }
            C3113a.m9531a(context).f10140G = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!C3072b.f9832a || context == null || C3154aq.m9970a(str) || C3154aq.m9970a(str2)) {
            return;
        }
        C3113a.m9531a(context).m9557a(str, str2);
    }

    public static void setServerUrl(String str) {
        if (C3154aq.m9970a(str) || !C3154aq.m9995c(str)) {
            return;
        }
        C3116a.m9637a(str);
        StrategyBean.f10225b = str;
        StrategyBean.f10226c = str;
    }

    public static void setSessionIntervalMills(long j2) {
        if (C3072b.f9832a) {
            C3111b.m9491a(j2);
        }
    }

    public static void setUserId(String str) {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            setUserId(f10077a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i2) {
        if (C3072b.f9832a && context != null) {
            if (i2 <= 0) {
                C3151an.m9922d("setTag args tagId should > 0", new Object[0]);
            }
            C3113a.m9531a(context).m9555a(i2);
            C3151an.m9918b("[param] set user scene tag: %d", Integer.valueOf(i2));
        }
    }

    public static void startCrashReport() {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            C3127c.m9705a().m9717c();
        }
    }

    public static void testANRCrash() {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            C3151an.m9915a("start to create a anr crash for test!", new Object[0]);
            C3127c.m9705a().m9725k();
        }
    }

    public static void testJavaCrash() {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            C3113a m9532b = C3113a.m9532b();
            if (m9532b != null) {
                m9532b.m9560b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i2) {
        C3152ao.m9927a(inetAddress, i2);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            return false;
        }
        return setJavascriptMonitor(new WebViewInterface() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public CharSequence getContentDescription() {
                return webView.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public String getUrl() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public void loadUrl(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public void setJavaScriptEnabled(boolean z3) {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }
        }, z, z2);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            C3151an.m9915a("start to create a native crash for test!", new Object[0]);
            C3127c.m9705a().m9715a(z, z2, z3);
        }
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (C3072b.f9832a && CrashModule.getInstance().hasInitialized()) {
            if (th == null) {
                C3151an.m9922d("throwable is null, just return", new Object[0]);
                return;
            }
            if (thread == null) {
                thread = Thread.currentThread();
            }
            C3127c.m9705a().m9713a(thread, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void postException(int i2, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i2, str, str2, str3, map);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static void setUserId(Context context, String str) {
        if (C3072b.f9832a && context != null) {
            if (TextUtils.isEmpty(str)) {
                C3151an.m9922d("userId should not be null", new Object[0]);
                return;
            }
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                C3151an.m9922d("userId %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            if (str.equals(C3113a.m9531a(context).m9573g())) {
                return;
            }
            C3113a.m9531a(context).m9561b(str);
            C3151an.m9918b("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                C3111b.m9490a();
            }
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!C3072b.f9832a) {
            return new HashMap();
        }
        if (context == null) {
            C3151an.m9922d("Context should not be null.", new Object[0]);
            return null;
        }
        return C3113a.m9531a(context).f10144K;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            C3151an.m9923e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        C3151an.m9915a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!C3072b.f9832a) {
            return false;
        }
        C3151an.m9921c("URL of webview is %s", webViewInterface.getUrl());
        if (!z2 && Build.VERSION.SDK_INT < 19) {
            C3151an.m9923e("This interface is only available for Android 4.4 or later.", new Object[0]);
            return false;
        }
        C3151an.m9915a("Enable the javascript needed by webview monitor.", new Object[0]);
        webViewInterface.setJavaScriptEnabled(true);
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
        if (h5JavaScriptInterface != null) {
            C3151an.m9915a("Add a secure javascript interface to the webview.", new Object[0]);
            webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z) {
            C3151an.m9915a("Inject bugly.js(v%s) to the webview.", C3132b.m9764b());
            String m9763a = C3132b.m9763a();
            if (m9763a == null) {
                C3151an.m9923e("Failed to inject Bugly.js.", C3132b.m9764b());
                return false;
            }
            webViewInterface.loadUrl("javascript:" + m9763a);
        }
        return true;
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f10077a = context;
        if (C3113a.m9531a(context) != null && "oversea".equals(C3113a.m9531a(context).f10139F)) {
            StrategyBean.f10225b = "http://astat.bugly.qcloud.com/rqd/async";
            StrategyBean.f10226c = "http://astat.bugly.qcloud.com/rqd/async";
        }
        C3072b.m9312a(CrashModule.getInstance());
        C3072b.m9309a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        if (C3113a.m9531a(context) != null && "oversea".equals(C3113a.m9531a(context).f10139F)) {
            StrategyBean.f10225b = "http://astat.bugly.qcloud.com/rqd/async";
            StrategyBean.f10226c = "http://astat.bugly.qcloud.com/rqd/async";
        }
        f10077a = context;
        C3072b.m9312a(CrashModule.getInstance());
        C3072b.m9310a(context, str, z, userStrategy);
    }
}
