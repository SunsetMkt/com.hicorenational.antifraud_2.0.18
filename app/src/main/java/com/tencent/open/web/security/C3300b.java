package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.C3258b;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.security.b */
/* loaded from: classes2.dex */
public class C3300b extends C3258b {
    @Override // com.tencent.open.C3258b
    /* renamed from: a */
    public void mo10430a(String str, String str2, List<String> list, C3258b.a aVar) {
        SLog.m10506v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        C3258b.b bVar = this.f11161a.get(str);
        if (bVar != null) {
            SLog.m10498d("openSDK_LOG.SecureJsBridge", "-->handler != null");
            bVar.call(str2, list, aVar);
            return;
        }
        SLog.m10500e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + str);
        if (aVar != null) {
            aVar.mo10437a();
        }
    }

    @Override // com.tencent.open.C3258b
    /* renamed from: a */
    public boolean mo10431a(WebView webView, String str) {
        SLog.m10502i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 7) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        String str4 = (String) arrayList.get(4);
        String str5 = (String) arrayList.get(5);
        SLog.m10502i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            try {
                mo10430a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new C3301c(webView, Long.parseLong(str4), str, str5));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
