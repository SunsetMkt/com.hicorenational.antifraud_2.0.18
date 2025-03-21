package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, C0130b> f9778a = new HashMap<>();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b$b, reason: collision with other inner class name */
    public static class C0130b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call(java.lang.String r11, java.util.List<java.lang.String> r12, com.tencent.open.b.a r13) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.C0130b.call(java.lang.String, java.util.List, com.tencent.open.b$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(C0130b c0130b, String str) {
        this.f9778a.put(str, c0130b);
    }

    public void a(String str, String str2, List<String> list, a aVar) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        C0130b c0130b = this.f9778a.get(str);
        if (c0130b != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            c0130b.call(str2, list, aVar);
        } else {
            SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* compiled from: ProGuard */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected WeakReference<WebView> f9780a;

        /* renamed from: b, reason: collision with root package name */
        protected long f9781b;

        /* renamed from: c, reason: collision with root package name */
        protected String f9782c;

        public a(WebView webView, long j2, String str) {
            this.f9780a = new WeakReference<>(webView);
            this.f9781b = j2;
            this.f9782c = str;
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f9780a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                obj2 = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) ? obj.toString() : obj instanceof Boolean ? obj.toString() : "'undefined'";
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f9781b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a() {
            WebView webView = this.f9780a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f9781b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f9780a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        a aVar = new a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, subList, aVar);
        return true;
    }
}
