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
/* renamed from: com.tencent.open.b */
/* loaded from: classes2.dex */
public class C3258b {

    /* renamed from: a */
    protected HashMap<String, b> f11161a = new HashMap<>();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b$b */
    public static class b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        
            r13.mo10438a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call(java.lang.String r11, java.util.List<java.lang.String> r12, com.tencent.open.C3258b.a r13) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.C3258b.b.call(java.lang.String, java.util.List, com.tencent.open.b$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    /* renamed from: a */
    public void m10429a(b bVar, String str) {
        this.f11161a.put(str, bVar);
    }

    /* renamed from: a */
    public void mo10430a(String str, String str2, List<String> list, a aVar) {
        SLog.m10506v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        b bVar = this.f11161a.get(str);
        if (bVar != null) {
            SLog.m10498d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, aVar);
        } else {
            SLog.m10498d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (aVar != null) {
                aVar.mo10437a();
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b$a */
    public static class a {

        /* renamed from: a */
        protected WeakReference<WebView> f11163a;

        /* renamed from: b */
        protected long f11164b;

        /* renamed from: c */
        protected String f11165c;

        public a(WebView webView, long j2, String str) {
            this.f11163a = new WeakReference<>(webView);
            this.f11164b = j2;
            this.f11165c = str;
        }

        /* renamed from: a */
        public void mo10438a(Object obj) {
            String obj2;
            WebView webView = this.f11163a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                obj2 = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) ? obj.toString() : obj instanceof Boolean ? obj.toString() : "'undefined'";
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f11164b + ",{'r':0,'result':" + obj2 + "});");
        }

        /* renamed from: a */
        public void mo10437a() {
            WebView webView = this.f11163a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f11164b + ",{'r':1,'result':'no such method'})");
        }

        /* renamed from: a */
        public void mo10439a(String str) {
            WebView webView = this.f11163a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* renamed from: a */
    public boolean mo10431a(WebView webView, String str) {
        SLog.m10506v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
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
        mo10430a(str2, str3, subList, aVar);
        return true;
    }
}
