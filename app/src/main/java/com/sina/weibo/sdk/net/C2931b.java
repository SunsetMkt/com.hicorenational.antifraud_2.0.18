package com.sina.weibo.sdk.net;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/* renamed from: com.sina.weibo.sdk.net.b */
/* loaded from: classes.dex */
public final class C2931b implements InterfaceC2930a {
    @Override // com.sina.weibo.sdk.net.InterfaceC2930a
    /* renamed from: a */
    public final InterfaceC2935f mo8851a(InterfaceC2933d interfaceC2933d) {
        String url = interfaceC2933d.getUrl();
        Bundle params = interfaceC2933d.getParams();
        if (params != null && params.size() != 0 && !TextUtils.isEmpty(url)) {
            Uri parse = Uri.parse(url);
            if (params != null && !params.isEmpty()) {
                Uri.Builder buildUpon = parse.buildUpon();
                for (String str : params.keySet()) {
                    buildUpon.appendQueryParameter(str, String.valueOf(params.get(str)));
                }
                parse = buildUpon.build();
            }
            if (parse != null) {
                url = parse.toString();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                Bundle bundle = new Bundle();
                bundle.putString("Content-Type", "application/x-www-form-urlencoded");
                m8853a(httpURLConnection, bundle);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(interfaceC2933d.getReadTimeout());
                httpURLConnection.setConnectTimeout(interfaceC2933d.getConnectTimeout());
                httpURLConnection.connect();
                m8852a(httpURLConnection.getOutputStream(), interfaceC2933d);
                int responseCode = httpURLConnection.getResponseCode();
                return new C2936g(responseCode, responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
            } catch (Exception e2) {
                throw new Throwable(e2.getMessage());
            }
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /* renamed from: a */
    private static void m8853a(HttpURLConnection httpURLConnection, Bundle bundle) {
        for (String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
        }
    }

    /* renamed from: a */
    private static void m8852a(OutputStream outputStream, InterfaceC2933d interfaceC2933d) {
        Bundle mo8854d = interfaceC2933d.mo8854d();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : mo8854d.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String valueOf = String.valueOf(mo8854d.get(str));
            try {
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(URLEncoder.encode(valueOf, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes("UTF-8"));
            dataOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
