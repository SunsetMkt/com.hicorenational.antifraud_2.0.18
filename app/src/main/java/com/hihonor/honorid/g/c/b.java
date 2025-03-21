package com.hihonor.honorid.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.a.a.a.c;
import k.a.a.a.j.e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: SDKAccountXmlImpl.java */
/* loaded from: classes.dex */
public class b {
    private static void a(Context context, HonorAccount honorAccount, boolean z, XmlSerializer xmlSerializer) {
        c.a(xmlSerializer, c.c.a.b.a.a.q, honorAccount.q() + "");
        String d2 = honorAccount.d();
        if (d2 == null) {
            d2 = "";
        }
        c.a(xmlSerializer, "accountType", d2);
        String o = honorAccount.o();
        if (z) {
            o = com.hihonor.honorid.d.a.b.b(context, o);
        }
        if (o == null) {
            o = "";
        }
        c.a(xmlSerializer, c.c.a.b.a.a.F, o);
        String u = honorAccount.u();
        String b2 = z ? com.hihonor.honorid.d.a.b.b(context, u) : u;
        if (b2 == null) {
            b2 = "";
        }
        c.a(xmlSerializer, "uuid", b2);
        String a2 = honorAccount.a();
        if (!TextUtils.isEmpty(a2)) {
            a2 = com.hihonor.honorid.d.a.b.b(context, a2);
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        c.a(xmlSerializer, c.c.a.b.a.a.f3104k, a2);
        String e2 = honorAccount.e();
        if (!TextUtils.isEmpty(e2)) {
            e2 = com.hihonor.honorid.d.a.b.b(context, e2);
        }
        if (TextUtils.isEmpty(e2)) {
            e2 = "";
        }
        c.a(xmlSerializer, c.c.a.b.a.a.f3105l, e2);
        String p = honorAccount.p();
        if (!TextUtils.isEmpty(p)) {
            p = com.hihonor.honorid.d.a.b.b(context, p);
        }
        if (TextUtils.isEmpty(p)) {
            p = "";
        }
        c.a(xmlSerializer, c.c.a.b.a.a.f3106m, p);
        c.a(xmlSerializer, c.c.a.b.a.a.o, com.hihonor.honorid.d.a.b.b(context, honorAccount.h() + "") + "");
        String k2 = honorAccount.k();
        if (TextUtils.isEmpty(k2)) {
            k2 = "";
        }
        c.a(xmlSerializer, "lastUpdateTime", k2);
    }

    private static void b(Context context, HonorAccount honorAccount, boolean z, XmlSerializer xmlSerializer) {
        e.b("SDKAccountXmlImpl", "SDKAccountXmlImpl start.", true);
        if (honorAccount == null) {
            e.a("SDKAccountXmlImpl", "account is null.", true);
            return;
        }
        xmlSerializer.startTag("", c.c.a.b.a.a.P);
        xmlSerializer.attribute("", "appId", honorAccount.t());
        String c2 = honorAccount.c();
        if (z) {
            c2 = com.hihonor.honorid.d.a.b.b(context, c2);
        }
        c.a(xmlSerializer, c.c.a.b.a.a.H, c2);
        String w = honorAccount.w();
        if (z) {
            w = com.hihonor.honorid.d.a.b.b(context, w);
        }
        c.a(xmlSerializer, "userId", w);
        String f2 = honorAccount.f();
        if (z) {
            f2 = com.hihonor.honorid.d.a.b.b(context, f2);
        }
        if (f2 == null) {
            f2 = "";
        }
        c.a(xmlSerializer, "deviceId", f2);
        String r = honorAccount.r();
        if (z) {
            r = com.hihonor.honorid.d.a.b.b(context, r);
        }
        if (r == null) {
            r = "";
        }
        c.a(xmlSerializer, c.c.a.b.a.a.t, r);
        String g2 = honorAccount.g();
        if (g2 == null) {
            g2 = "";
        }
        c.a(xmlSerializer, "deviceType", g2);
        c.a(xmlSerializer, c.c.a.b.a.a.N, com.hihonor.honorid.d.a.b.b(context, honorAccount.s()));
        c.a(xmlSerializer, "loginUserName", com.hihonor.honorid.d.a.b.b(context, honorAccount.l()));
        c.a(xmlSerializer, c.c.a.b.a.a.D, com.hihonor.honorid.d.a.b.b(context, honorAccount.j()));
        a(context, honorAccount, z, xmlSerializer);
        xmlSerializer.endTag("", c.c.a.b.a.a.P);
    }

    private static void c(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if (c.c.a.b.a.a.f3106m.equals(str)) {
            String a2 = com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText());
            if (!com.hihonor.honorid.f.a.c(a2)) {
                a2 = "";
            }
            honorAccount.r(a2);
            return;
        }
        if (c.c.a.b.a.a.o.equals(str)) {
            try {
                honorAccount.a(Integer.parseInt(com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText())));
            } catch (NumberFormatException unused) {
                e.d("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error", true);
            } catch (Exception unused2) {
                e.d("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error", true);
            }
        }
    }

    private static void b(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("loginUserName".equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z) {
                nextText = com.hihonor.honorid.d.a.b.a(context, nextText);
            }
            honorAccount.l(nextText);
            return;
        }
        if (c.c.a.b.a.a.D.equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z) {
                nextText2 = com.hihonor.honorid.d.a.b.a(context, nextText2);
            }
            honorAccount.j(nextText2);
            return;
        }
        if (c.c.a.b.a.a.F.equals(str)) {
            String nextText3 = xmlPullParser.nextText();
            if (z) {
                nextText3 = com.hihonor.honorid.d.a.b.a(context, nextText3);
            }
            honorAccount.q(nextText3);
            return;
        }
        if ("uuid".equals(str)) {
            String nextText4 = xmlPullParser.nextText();
            if (z) {
                nextText4 = com.hihonor.honorid.d.a.b.a(context, nextText4);
            }
            honorAccount.v(nextText4);
            return;
        }
        if (c.c.a.b.a.a.f3104k.equals(str)) {
            String a2 = com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText());
            if (!com.hihonor.honorid.f.a.c(a2)) {
                a2 = "";
            }
            honorAccount.a(a2);
            return;
        }
        if (c.c.a.b.a.a.f3105l.equals(str)) {
            String a3 = com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText());
            if (!com.hihonor.honorid.f.a.c(a3)) {
                a3 = "";
            }
            honorAccount.e(a3);
            return;
        }
        c(xmlPullParser, context, z, honorAccount, str);
    }

    public static void a(Context context, String str, List<HonorAccount> list, boolean z) {
        List<HonorAccount> a2 = a(list);
        if (a2 != null && !a2.isEmpty() && list != null && !list.isEmpty()) {
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    newSerializer.setOutput(stringWriter);
                                    newSerializer.startDocument("UTF-8", true);
                                    newSerializer.startTag("", "accounts");
                                    newSerializer.attribute("", "size", list.size() + "");
                                    Iterator<HonorAccount> it = list.iterator();
                                    while (it.hasNext()) {
                                        b(context, it.next(), z, newSerializer);
                                    }
                                    newSerializer.endTag("", "accounts");
                                    newSerializer.endDocument();
                                    boolean a3 = c.a(context.getFilesDir().getCanonicalPath() + "/", str, com.hihonor.honorid.f.a.b(stringWriter.toString()));
                                    e.b("SDKAccountXmlImpl", "write accounts into file :" + a3, true);
                                    if (z && a3) {
                                        c.c(context, String.valueOf(3));
                                    }
                                    stringWriter.close();
                                } catch (IOException unused) {
                                    e.a("SDKAccountXmlImpl", "IOException write accounts failed!", true);
                                    stringWriter.close();
                                } catch (IllegalStateException unused2) {
                                    e.a("SDKAccountXmlImpl", "IllegalStateException write accounts failed!", true);
                                    stringWriter.close();
                                }
                            } catch (IllegalArgumentException unused3) {
                                e.a("SDKAccountXmlImpl", "IllegalArgumentException write accounts failed!", true);
                                stringWriter.close();
                            }
                        } catch (Exception unused4) {
                            e.a("SDKAccountXmlImpl", "Exception write accounts failed!", true);
                            stringWriter.close();
                        }
                    } catch (RuntimeException unused5) {
                        e.a("SDKAccountXmlImpl", "RuntimeException write accounts failed!", true);
                        stringWriter.close();
                    }
                    return;
                } catch (Throwable th) {
                    try {
                        stringWriter.close();
                    } catch (IOException unused6) {
                        e.a("SDKAccountXmlImpl", "IOException ", true);
                    }
                    throw th;
                }
            } catch (IOException unused7) {
                e.a("SDKAccountXmlImpl", "IOException ", true);
                return;
            }
        }
        e.b("SDKAccountXmlImpl", "write accounts into file error", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.hihonor.honorid.core.data.HonorAccount> a(java.lang.String r6, android.content.Context r7, boolean r8) {
        /*
            java.lang.String r0 = "IOException  "
            java.lang.String r1 = "SDKAccountXmlImpl"
            r2 = 0
            r3 = 1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.<init>()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.io.File r5 = r7.getFilesDir()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.lang.String r5 = r5.getCanonicalPath()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.append(r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.lang.String r5 = "/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.append(r6)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            boolean r6 = r4.exists()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            if (r6 != 0) goto L3b
            java.lang.String r6 = " sdk filepath not exist"
            k.a.a.a.j.e.b(r1, r6, r3)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r6.<init>()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            return r6
        L38:
            r6 = move-exception
            goto Lbf
        L3b:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            r4.setInput(r6, r2)     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = a(r4, r7, r8)     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            r6.close()     // Catch: java.io.IOException -> L4f
            goto L52
        L4f:
            k.a.a.a.j.e.a(r1, r0, r3)
        L52:
            return r7
        L53:
            r6 = r2
        L54:
            java.lang.String r7 = "Exception read xml failed!"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L67
            r6.close()     // Catch: java.io.IOException -> L64
            goto L67
        L64:
            k.a.a.a.j.e.a(r1, r0, r3)
        L67:
            return r7
        L68:
            r6 = r2
        L69:
            java.lang.String r7 = "RuntimeException read xml failed!"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.io.IOException -> L79
            goto L7c
        L79:
            k.a.a.a.j.e.a(r1, r0, r3)
        L7c:
            return r7
        L7d:
            r6 = r2
        L7e:
            java.lang.String r7 = "IOException read xml failed!"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.io.IOException -> L8e
            goto L91
        L8e:
            k.a.a.a.j.e.a(r1, r0, r3)
        L91:
            return r7
        L92:
            r6 = r2
        L93:
            java.lang.String r7 = "FileNotFoundException read xml failed!"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto La6
            r6.close()     // Catch: java.io.IOException -> La3
            goto La6
        La3:
            k.a.a.a.j.e.a(r1, r0, r3)
        La6:
            return r7
        La7:
            r6 = r2
        La8:
            java.lang.String r7 = "XmlPullParserException read xml failed!"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto Lbb
            r6.close()     // Catch: java.io.IOException -> Lb8
            goto Lbb
        Lb8:
            k.a.a.a.j.e.a(r1, r0, r3)
        Lbb:
            return r7
        Lbc:
            r7 = move-exception
            r2 = r6
            r6 = r7
        Lbf:
            if (r2 == 0) goto Lc8
            r2.close()     // Catch: java.io.IOException -> Lc5
            goto Lc8
        Lc5:
            k.a.a.a.j.e.a(r1, r0, r3)
        Lc8:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hihonor.honorid.g.c.b.a(java.lang.String, android.content.Context, boolean):java.util.ArrayList");
    }

    private static void a(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("deviceId".equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z) {
                nextText = com.hihonor.honorid.d.a.b.a(context, nextText);
            }
            honorAccount.g(nextText);
            return;
        }
        if (c.c.a.b.a.a.t.equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z) {
                nextText2 = com.hihonor.honorid.d.a.b.a(context, nextText2);
            }
            honorAccount.s(nextText2);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.h(xmlPullParser.nextText());
            return;
        }
        if (c.c.a.b.a.a.N.equals(str)) {
            honorAccount.t(com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText()));
            return;
        }
        if (c.c.a.b.a.a.q.equals(str)) {
            try {
                honorAccount.b(Integer.parseInt(xmlPullParser.nextText()));
                return;
            } catch (NumberFormatException unused) {
                e.d("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error", true);
                return;
            } catch (Exception unused2) {
                e.d("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error", true);
                return;
            }
        }
        if ("accountType".equals(str)) {
            honorAccount.d(xmlPullParser.nextText());
        } else {
            b(xmlPullParser, context, z, honorAccount, str);
        }
    }

    private static ArrayList<HonorAccount> a(XmlPullParser xmlPullParser, Context context, boolean z) {
        e.b("SDKAccountXmlImpl", "sdkaccount xml parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 2) {
                if (eventType == 3 && c.c.a.b.a.a.P.equals(name)) {
                    e.b("SDKAccountXmlImpl", "parseAccountsFromXml add account:", true);
                    arrayList.add(honorAccount);
                    honorAccount = new HonorAccount();
                }
            } else if (c.c.a.b.a.a.P.equals(name)) {
                String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                if (TextUtils.isEmpty(attributeValue)) {
                    e.c("SDKAccountXmlImpl", "sdk authTokenType is null", true);
                    attributeValue = com.hihonor.honorid.f.a.d(context);
                }
                honorAccount.u(attributeValue);
            } else if (c.c.a.b.a.a.H.equals(name)) {
                String nextText = xmlPullParser.nextText();
                if (z) {
                    nextText = com.hihonor.honorid.d.a.b.a(context, nextText);
                }
                honorAccount.c(nextText);
            } else if ("userId".equals(name)) {
                String nextText2 = xmlPullParser.nextText();
                if (z) {
                    nextText2 = com.hihonor.honorid.d.a.b.a(context, nextText2);
                }
                honorAccount.x(nextText2);
            } else {
                a(xmlPullParser, context, z, honorAccount, name);
            }
            eventType = xmlPullParser.next();
        }
        return arrayList;
    }

    private static List<HonorAccount> a(List<HonorAccount> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (HonorAccount honorAccount : list) {
            if (!com.hihonor.honorid.f.a.a(honorAccount)) {
                arrayList.add(honorAccount);
            }
        }
        try {
            if (!arrayList.isEmpty() && list.containsAll(arrayList)) {
                list.removeAll(arrayList);
            }
        } catch (Exception unused) {
            e.a("SDKAccountXmlImpl", LogUtils.LOG_EXCEPTION, true);
        }
        return list;
    }
}
