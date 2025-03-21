package com.hihonor.honorid.p166g.p167c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.p162d.p163a.C2165b;
import com.hihonor.honorid.p165f.C2171a;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p358k.p359a.p360a.p361a.C5849c;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: SDKAccountXmlImpl.java */
/* renamed from: com.hihonor.honorid.g.c.b */
/* loaded from: classes.dex */
public class C2177b {
    /* renamed from: a */
    private static void m6339a(Context context, HonorAccount honorAccount, boolean z, XmlSerializer xmlSerializer) {
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2598q, honorAccount.m6191q() + "");
        String m6165d = honorAccount.m6165d();
        if (m6165d == null) {
            m6165d = "";
        }
        C5849c.m24629a(xmlSerializer, "accountType", m6165d);
        String m6187o = honorAccount.m6187o();
        if (z) {
            m6187o = C2165b.m6303b(context, m6187o);
        }
        if (m6187o == null) {
            m6187o = "";
        }
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2497F, m6187o);
        String m6199u = honorAccount.m6199u();
        String m6303b = z ? C2165b.m6303b(context, m6199u) : m6199u;
        if (m6303b == null) {
            m6303b = "";
        }
        C5849c.m24629a(xmlSerializer, "uuid", m6303b);
        String m6156a = honorAccount.m6156a();
        if (!TextUtils.isEmpty(m6156a)) {
            m6156a = C2165b.m6303b(context, m6156a);
        }
        if (TextUtils.isEmpty(m6156a)) {
            m6156a = "";
        }
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2580k, m6156a);
        String m6167e = honorAccount.m6167e();
        if (!TextUtils.isEmpty(m6167e)) {
            m6167e = C2165b.m6303b(context, m6167e);
        }
        if (TextUtils.isEmpty(m6167e)) {
            m6167e = "";
        }
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2583l, m6167e);
        String m6189p = honorAccount.m6189p();
        if (!TextUtils.isEmpty(m6189p)) {
            m6189p = C2165b.m6303b(context, m6189p);
        }
        if (TextUtils.isEmpty(m6189p)) {
            m6189p = "";
        }
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2586m, m6189p);
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2592o, C2165b.m6303b(context, honorAccount.m6173h() + "") + "");
        String m6179k = honorAccount.m6179k();
        if (TextUtils.isEmpty(m6179k)) {
            m6179k = "";
        }
        C5849c.m24629a(xmlSerializer, "lastUpdateTime", m6179k);
    }

    /* renamed from: b */
    private static void m6342b(Context context, HonorAccount honorAccount, boolean z, XmlSerializer xmlSerializer) {
        C5863e.m24692b("SDKAccountXmlImpl", "SDKAccountXmlImpl start.", true);
        if (honorAccount == null) {
            C5863e.m24691a("SDKAccountXmlImpl", "account is null.", true);
            return;
        }
        xmlSerializer.startTag("", AbstractC1191a.f2527P);
        xmlSerializer.attribute("", "appId", honorAccount.m6197t());
        String m6163c = honorAccount.m6163c();
        if (z) {
            m6163c = C2165b.m6303b(context, m6163c);
        }
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2503H, m6163c);
        String m6203w = honorAccount.m6203w();
        if (z) {
            m6203w = C2165b.m6303b(context, m6203w);
        }
        C5849c.m24629a(xmlSerializer, "userId", m6203w);
        String m6169f = honorAccount.m6169f();
        if (z) {
            m6169f = C2165b.m6303b(context, m6169f);
        }
        if (m6169f == null) {
            m6169f = "";
        }
        C5849c.m24629a(xmlSerializer, "deviceId", m6169f);
        String m6193r = honorAccount.m6193r();
        if (z) {
            m6193r = C2165b.m6303b(context, m6193r);
        }
        if (m6193r == null) {
            m6193r = "";
        }
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2607t, m6193r);
        String m6171g = honorAccount.m6171g();
        if (m6171g == null) {
            m6171g = "";
        }
        C5849c.m24629a(xmlSerializer, "deviceType", m6171g);
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2521N, C2165b.m6303b(context, honorAccount.m6195s()));
        C5849c.m24629a(xmlSerializer, "loginUserName", C2165b.m6303b(context, honorAccount.m6181l()));
        C5849c.m24629a(xmlSerializer, AbstractC1191a.f2491D, C2165b.m6303b(context, honorAccount.m6177j()));
        m6339a(context, honorAccount, z, xmlSerializer);
        xmlSerializer.endTag("", AbstractC1191a.f2527P);
    }

    /* renamed from: c */
    private static void m6344c(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if (AbstractC1191a.f2586m.equals(str)) {
            String m6302a = C2165b.m6302a(context, xmlPullParser.nextText());
            if (!C2171a.m6325c(m6302a)) {
                m6302a = "";
            }
            honorAccount.m6194r(m6302a);
            return;
        }
        if (AbstractC1191a.f2592o.equals(str)) {
            try {
                honorAccount.m6157a(Integer.parseInt(C2165b.m6302a(context, xmlPullParser.nextText())));
            } catch (NumberFormatException unused) {
                C5863e.m24694d("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error", true);
            } catch (Exception unused2) {
                C5863e.m24694d("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error", true);
            }
        }
    }

    /* renamed from: b */
    private static void m6343b(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("loginUserName".equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z) {
                nextText = C2165b.m6302a(context, nextText);
            }
            honorAccount.m6182l(nextText);
            return;
        }
        if (AbstractC1191a.f2491D.equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z) {
                nextText2 = C2165b.m6302a(context, nextText2);
            }
            honorAccount.m6178j(nextText2);
            return;
        }
        if (AbstractC1191a.f2497F.equals(str)) {
            String nextText3 = xmlPullParser.nextText();
            if (z) {
                nextText3 = C2165b.m6302a(context, nextText3);
            }
            honorAccount.m6192q(nextText3);
            return;
        }
        if ("uuid".equals(str)) {
            String nextText4 = xmlPullParser.nextText();
            if (z) {
                nextText4 = C2165b.m6302a(context, nextText4);
            }
            honorAccount.m6202v(nextText4);
            return;
        }
        if (AbstractC1191a.f2580k.equals(str)) {
            String m6302a = C2165b.m6302a(context, xmlPullParser.nextText());
            if (!C2171a.m6325c(m6302a)) {
                m6302a = "";
            }
            honorAccount.m6158a(m6302a);
            return;
        }
        if (AbstractC1191a.f2583l.equals(str)) {
            String m6302a2 = C2165b.m6302a(context, xmlPullParser.nextText());
            if (!C2171a.m6325c(m6302a2)) {
                m6302a2 = "";
            }
            honorAccount.m6168e(m6302a2);
            return;
        }
        m6344c(xmlPullParser, context, z, honorAccount, str);
    }

    /* renamed from: a */
    public static void m6340a(Context context, String str, List<HonorAccount> list, boolean z) {
        List<HonorAccount> m6338a = m6338a(list);
        if (m6338a != null && !m6338a.isEmpty() && list != null && !list.isEmpty()) {
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
                                        m6342b(context, it.next(), z, newSerializer);
                                    }
                                    newSerializer.endTag("", "accounts");
                                    newSerializer.endDocument();
                                    boolean m24632a = C5849c.m24632a(context.getFilesDir().getCanonicalPath() + "/", str, C2171a.m6323b(stringWriter.toString()));
                                    C5863e.m24692b("SDKAccountXmlImpl", "write accounts into file :" + m24632a, true);
                                    if (z && m24632a) {
                                        C5849c.m24635c(context, String.valueOf(3));
                                    }
                                    stringWriter.close();
                                } catch (IOException unused) {
                                    C5863e.m24691a("SDKAccountXmlImpl", "IOException write accounts failed!", true);
                                    stringWriter.close();
                                } catch (IllegalStateException unused2) {
                                    C5863e.m24691a("SDKAccountXmlImpl", "IllegalStateException write accounts failed!", true);
                                    stringWriter.close();
                                }
                            } catch (IllegalArgumentException unused3) {
                                C5863e.m24691a("SDKAccountXmlImpl", "IllegalArgumentException write accounts failed!", true);
                                stringWriter.close();
                            }
                        } catch (Exception unused4) {
                            C5863e.m24691a("SDKAccountXmlImpl", "Exception write accounts failed!", true);
                            stringWriter.close();
                        }
                    } catch (RuntimeException unused5) {
                        C5863e.m24691a("SDKAccountXmlImpl", "RuntimeException write accounts failed!", true);
                        stringWriter.close();
                    }
                    return;
                } catch (Throwable th) {
                    try {
                        stringWriter.close();
                    } catch (IOException unused6) {
                        C5863e.m24691a("SDKAccountXmlImpl", "IOException ", true);
                    }
                    throw th;
                }
            } catch (IOException unused7) {
                C5863e.m24691a("SDKAccountXmlImpl", "IOException ", true);
                return;
            }
        }
        C5863e.m24692b("SDKAccountXmlImpl", "write accounts into file error", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.hihonor.honorid.core.data.HonorAccount> m6336a(java.lang.String r6, android.content.Context r7, boolean r8) {
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
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r1, r6, r3)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
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
            java.util.ArrayList r7 = m6337a(r4, r7, r8)     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            r6.close()     // Catch: java.io.IOException -> L4f
            goto L52
        L4f:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
        L52:
            return r7
        L53:
            r6 = r2
        L54:
            java.lang.String r7 = "Exception read xml failed!"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L67
            r6.close()     // Catch: java.io.IOException -> L64
            goto L67
        L64:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
        L67:
            return r7
        L68:
            r6 = r2
        L69:
            java.lang.String r7 = "RuntimeException read xml failed!"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.io.IOException -> L79
            goto L7c
        L79:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
        L7c:
            return r7
        L7d:
            r6 = r2
        L7e:
            java.lang.String r7 = "IOException read xml failed!"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.io.IOException -> L8e
            goto L91
        L8e:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
        L91:
            return r7
        L92:
            r6 = r2
        L93:
            java.lang.String r7 = "FileNotFoundException read xml failed!"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto La6
            r6.close()     // Catch: java.io.IOException -> La3
            goto La6
        La3:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
        La6:
            return r7
        La7:
            r6 = r2
        La8:
            java.lang.String r7 = "XmlPullParserException read xml failed!"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto Lbb
            r6.close()     // Catch: java.io.IOException -> Lb8
            goto Lbb
        Lb8:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
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
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
        Lc8:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hihonor.honorid.p166g.p167c.C2177b.m6336a(java.lang.String, android.content.Context, boolean):java.util.ArrayList");
    }

    /* renamed from: a */
    private static void m6341a(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("deviceId".equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z) {
                nextText = C2165b.m6302a(context, nextText);
            }
            honorAccount.m6172g(nextText);
            return;
        }
        if (AbstractC1191a.f2607t.equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z) {
                nextText2 = C2165b.m6302a(context, nextText2);
            }
            honorAccount.m6196s(nextText2);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.m6174h(xmlPullParser.nextText());
            return;
        }
        if (AbstractC1191a.f2521N.equals(str)) {
            honorAccount.m6198t(C2165b.m6302a(context, xmlPullParser.nextText()));
            return;
        }
        if (AbstractC1191a.f2598q.equals(str)) {
            try {
                honorAccount.m6161b(Integer.parseInt(xmlPullParser.nextText()));
                return;
            } catch (NumberFormatException unused) {
                C5863e.m24694d("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error", true);
                return;
            } catch (Exception unused2) {
                C5863e.m24694d("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error", true);
                return;
            }
        }
        if ("accountType".equals(str)) {
            honorAccount.m6166d(xmlPullParser.nextText());
        } else {
            m6343b(xmlPullParser, context, z, honorAccount, str);
        }
    }

    /* renamed from: a */
    private static ArrayList<HonorAccount> m6337a(XmlPullParser xmlPullParser, Context context, boolean z) {
        C5863e.m24692b("SDKAccountXmlImpl", "sdkaccount xml parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 2) {
                if (eventType == 3 && AbstractC1191a.f2527P.equals(name)) {
                    C5863e.m24692b("SDKAccountXmlImpl", "parseAccountsFromXml add account:", true);
                    arrayList.add(honorAccount);
                    honorAccount = new HonorAccount();
                }
            } else if (AbstractC1191a.f2527P.equals(name)) {
                String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                if (TextUtils.isEmpty(attributeValue)) {
                    C5863e.m24693c("SDKAccountXmlImpl", "sdk authTokenType is null", true);
                    attributeValue = C2171a.m6326d(context);
                }
                honorAccount.m6200u(attributeValue);
            } else if (AbstractC1191a.f2503H.equals(name)) {
                String nextText = xmlPullParser.nextText();
                if (z) {
                    nextText = C2165b.m6302a(context, nextText);
                }
                honorAccount.m6164c(nextText);
            } else if ("userId".equals(name)) {
                String nextText2 = xmlPullParser.nextText();
                if (z) {
                    nextText2 = C2165b.m6302a(context, nextText2);
                }
                honorAccount.m6205x(nextText2);
            } else {
                m6341a(xmlPullParser, context, z, honorAccount, name);
            }
            eventType = xmlPullParser.next();
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<HonorAccount> m6338a(List<HonorAccount> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (HonorAccount honorAccount : list) {
            if (!C2171a.m6321a(honorAccount)) {
                arrayList.add(honorAccount);
            }
        }
        try {
            if (!arrayList.isEmpty() && list.containsAll(arrayList)) {
                list.removeAll(arrayList);
            }
        } catch (Exception unused) {
            C5863e.m24691a("SDKAccountXmlImpl", LogUtils.LOG_EXCEPTION, true);
        }
        return list;
    }
}
