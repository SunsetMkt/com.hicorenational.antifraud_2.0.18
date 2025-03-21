package com.hihonor.honorid.p165f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.C2151a;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.p162d.p163a.C2168e;
import com.honor.openSdk.C2244R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;
import p286h.C5230f1;
import p358k.p359a.p360a.p361a.C5851e;
import p358k.p359a.p360a.p361a.C5854h;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: BaseUtil.java */
/* renamed from: com.hihonor.honorid.f.a */
/* loaded from: classes.dex */
public class C2171a {
    /* renamed from: a */
    public static String m6318a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & C5230f1.f20085c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static byte[] m6323b(String str) {
        if (TextUtils.isEmpty(str)) {
            C5863e.m24691a("BaseUtil", "getUTF8Bytes, str is empty", true);
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            C5863e.m24691a("BaseUtil", "getBytes error", true);
            return new byte[0];
        }
    }

    /* renamed from: c */
    public static boolean m6325c(String str) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            while (i2 < bytes.length) {
                int i3 = bytes[i2] & C5230f1.f20085c;
                i2 = (i3 > 31 && i3 < 127) ? i2 + 1 : 0;
                C5863e.m24692b("BaseUtil", "byte not printable", true);
                return false;
            }
        } catch (UnsupportedEncodingException unused) {
            C5863e.m24692b("BaseUtil", "UnsupportedEncodingException", true);
        }
        return true;
    }

    /* renamed from: d */
    public static String m6326d(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    /* renamed from: e */
    public static boolean m6327e(Context context) {
        return context.getPackageName().equals(C5851e.m24637a(context).m24638a());
    }

    /* renamed from: f */
    private static List<String> m6328f(Context context) {
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xml = context.getResources().getXml(C2244R.xml.usesdk_packagename);
        if (xml == null) {
            return arrayList;
        }
        try {
            for (int eventType = xml.getEventType(); 1 != eventType; eventType = xml.next()) {
                String name = xml.getName();
                if (eventType == 2 && "package".equals(name)) {
                    arrayList.add(xml.nextText());
                }
            }
        } catch (IOException unused) {
            C5863e.m24691a("BaseUtil", "Parser xml exception: IOException", true);
        } catch (XmlPullParserException unused2) {
            C5863e.m24691a("BaseUtil", "Parser xml exception: XmlPullParserException", true);
        }
        return arrayList;
    }

    /* renamed from: b */
    public static boolean m6322b(Context context) {
        if (context == null) {
            C5863e.m24691a("BaseUtil", "context is null.", true);
            return true;
        }
        List<String> list = null;
        C2151a m6093c = C2151a.m6093c();
        if (m6093c.m6097b() == null) {
            try {
                list = m6328f(context);
                m6093c.m6096a(list);
            } catch (Exception unused) {
                C5863e.m24691a("BaseUtil", LogUtils.LOG_EXCEPTION, true);
            }
        } else {
            list = m6093c.m6097b();
        }
        return list == null || !list.contains(context.getPackageName());
    }

    /* renamed from: c */
    public static String m6324c(Context context) {
        String m24649a = C5854h.m24649a(context, 0);
        if (!TextUtils.isEmpty(m24649a) && !"NULL".equals(m24649a)) {
            return C2168e.m6313b(m24649a + m6316a());
        }
        C5863e.m24692b("BaseUtil", "TransID get imei is null", true);
        return null;
    }

    /* renamed from: a */
    public static String m6316a() {
        return m6317a("yyyyMMddHHmmssSSS");
    }

    /* renamed from: a */
    public static boolean m6321a(HonorAccount honorAccount) {
        if (honorAccount == null) {
            return false;
        }
        if (!TextUtils.isEmpty(honorAccount.m6160b())) {
            return true;
        }
        if (!TextUtils.isEmpty(honorAccount.m6163c()) && !TextUtils.isEmpty(honorAccount.m6203w()) && !TextUtils.isEmpty(honorAccount.m6197t()) && !TextUtils.isEmpty(honorAccount.m6195s())) {
            return true;
        }
        C5863e.m24692b("BaseUtil", "addHonorAccount is invalid", true);
        return false;
    }

    /* renamed from: a */
    public static boolean m6320a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(C5851e.m24637a(context).m24638a());
        if ((packageManager != null ? packageManager.queryIntentServices(intent, 0) : null) != null) {
            return !r3.isEmpty();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m6319a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            boolean z = context.getPackageManager().getApplicationInfo(C5851e.m24637a(context).m24638a(), 128) != null;
            C5863e.m24692b("BaseUtil", "result is:" + z, true);
            return z;
        } catch (PackageManager.NameNotFoundException unused) {
            C5863e.m24692b("BaseUtil", "NameNotFoundException", true);
            return false;
        }
    }

    /* renamed from: a */
    public static String m6317a(String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }
}
