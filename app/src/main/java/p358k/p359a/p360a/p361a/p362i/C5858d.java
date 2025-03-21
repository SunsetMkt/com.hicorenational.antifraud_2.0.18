package p358k.p359a.p360a.p361a.p362i;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.p162d.p163a.C2165b;
import com.hihonor.honorid.p165f.C2171a;
import com.hihonor.honorid.p166g.p167c.C2177b;
import com.taobao.accs.AccsClientConfig;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p358k.p359a.p360a.p361a.C5849c;
import p358k.p359a.p360a.p361a.p363j.C5863e;
import p358k.p359a.p360a.p365b.p366a.C5865a;

/* compiled from: XmlFileGrade.java */
/* renamed from: k.a.a.a.i.d */
/* loaded from: classes2.dex */
public class C5858d implements InterfaceC5855a {
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
    private static java.util.ArrayList<com.hihonor.honorid.core.data.HonorAccount> m24654a(java.lang.String r6, android.content.Context r7, boolean r8) {
        /*
            java.lang.String r0 = "IOException"
            java.lang.String r1 = "XmlFileGrade"
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
            java.lang.String r6 = "xmlfilegradle sdk filepath not exist"
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
            java.util.ArrayList r7 = m24655a(r4, r7, r8)     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            r6.close()     // Catch: java.io.IOException -> L4f
            goto L52
        L4f:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r3)
        L52:
            return r7
        L53:
            r6 = r2
        L54:
            java.lang.String r7 = "readAccountsFromXml Exception"
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
            java.lang.String r7 = "readAccountsFromXml RuntimeException"
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
            java.lang.String r7 = "readAccountsFromXml IOException"
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
            java.lang.String r7 = "readAccountsFromXml FileNotFoundException"
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
            java.lang.String r7 = "XmlPullParserException readAccountsFromXmlfailed!"
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
        throw new UnsupportedOperationException("Method not decompiled: p358k.p359a.p360a.p361a.p362i.C5858d.m24654a(java.lang.String, android.content.Context, boolean):java.util.ArrayList");
    }

    /* renamed from: b */
    private static void m24659b(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("loginUserName".equals(str)) {
            honorAccount.m6182l(C2165b.m6304c(context, xmlPullParser.nextText()));
        } else if (AbstractC1191a.f2491D.equals(str)) {
            honorAccount.m6178j(C2165b.m6304c(context, xmlPullParser.nextText()));
        }
    }

    /* renamed from: b */
    private void m24658b(Context context) {
        C5863e.m24692b("XmlFileGrade", "update HnAccounts.xml when version update", true);
        C5865a m24711a = C5865a.m24711a(context);
        m24711a.m24713a("last_head_picture_url");
        C5863e.m24692b("XmlFileGrade", "delete last_head_picture_url in HonorAccount.xml", true);
        m24711a.m24713a("DEVID_1");
        C5863e.m24692b("XmlFileGrade", "delete DEVID in HonorAccount.xml", true);
        m24711a.m24713a("SUBDEVID");
        C5863e.m24692b("XmlFileGrade", "delete SUBDEVID in HonorAccount.xml", true);
        m24711a.m24713a("hasEncryptHeadPictureUrl");
        C5863e.m24692b("XmlFileGrade", "delete hasEncryptHeadPictureUrl in HonorAccount.xml", true);
        String m24712a = m24711a.m24712a("accessToken", "");
        if (!TextUtils.isEmpty(m24712a)) {
            String m6304c = C2165b.m6304c(context, m24712a);
            if (!TextUtils.isEmpty(m6304c)) {
                C5863e.m24692b("XmlFileGrade", "update accessToken in HonorAccount.xml", true);
                m24711a.m24714b("accessToken", m6304c);
            } else {
                m24711a.m24713a("accessToken");
                C5863e.m24692b("XmlFileGrade", "accessToken ecb decrypt error", true);
            }
        }
        String m24712a2 = m24711a.m24712a("UUID", "");
        if (!TextUtils.isEmpty(m24712a2)) {
            C5863e.m24692b("XmlFileGrade", "update uuid in HonorAccount.xml", true);
            m24711a.m24714b("UUID", m24712a2);
        } else {
            m24711a.m24713a("UUID");
            C5863e.m24692b("XmlFileGrade", "uuid ecb decrypt error", true);
        }
    }

    /* renamed from: a */
    private static void m24657a(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("userId".equals(str)) {
            String nextText = xmlPullParser.nextText();
            if (z) {
                nextText = C2165b.m6304c(context, nextText);
            }
            honorAccount.m6205x(nextText);
            return;
        }
        if ("deviceId".equals(str)) {
            String nextText2 = xmlPullParser.nextText();
            if (z) {
                nextText2 = C2165b.m6304c(context, nextText2);
            }
            honorAccount.m6172g(nextText2);
            return;
        }
        if (AbstractC1191a.f2607t.equals(str)) {
            String nextText3 = xmlPullParser.nextText();
            if (z) {
                nextText3 = C2165b.m6304c(context, nextText3);
            }
            honorAccount.m6196s(nextText3);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.m6174h(xmlPullParser.nextText());
            return;
        }
        if (AbstractC1191a.f2521N.equals(str)) {
            honorAccount.m6198t(C2165b.m6304c(context, xmlPullParser.nextText()));
            return;
        }
        if (AbstractC1191a.f2598q.equals(str)) {
            try {
                honorAccount.m6161b(Integer.parseInt(xmlPullParser.nextText()));
                return;
            } catch (NumberFormatException unused) {
                C5863e.m24694d("XmlFileGrade", "NumberFormatException: read accounts.xml parseInt error", true);
                return;
            } catch (Exception unused2) {
                C5863e.m24694d("XmlFileGrade", "read accounts.xml parseInt error", true);
                return;
            }
        }
        if ("accountType".equals(str)) {
            honorAccount.m6166d(xmlPullParser.nextText());
        } else {
            m24659b(xmlPullParser, context, z, honorAccount, str);
        }
    }

    /* renamed from: a */
    private static ArrayList<HonorAccount> m24655a(XmlPullParser xmlPullParser, Context context, boolean z) {
        C5863e.m24693c("XmlFileGrade", "parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 0) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        C5863e.m24693c("XmlFileGrade", AccsClientConfig.DEFAULT_CONFIGTAG, true);
                    } else if (AbstractC1191a.f2527P.equals(name)) {
                        C5863e.m24693c("XmlFileGrade", "parseAccountsFromXml account add ", true);
                        if (!TextUtils.isEmpty(honorAccount.m6163c())) {
                            arrayList.add(honorAccount);
                        } else {
                            C5863e.m24692b("XmlFileGrade", "Invalid account , not need add.", true);
                        }
                        honorAccount = new HonorAccount();
                    }
                } else if (AbstractC1191a.f2527P.equals(name)) {
                    String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                    if (TextUtils.isEmpty(attributeValue)) {
                        C5863e.m24693c("XmlFileGrade", "authTokenType is null", true);
                        attributeValue = C2171a.m6326d(context);
                    }
                    honorAccount.m6200u(attributeValue);
                } else if (AbstractC1191a.f2503H.equals(name)) {
                    String nextText = xmlPullParser.nextText();
                    if (z) {
                        nextText = C2165b.m6304c(context, nextText);
                    }
                    honorAccount.m6164c(nextText);
                } else {
                    m24657a(xmlPullParser, context, z, honorAccount, name);
                }
            }
            eventType = xmlPullParser.next();
        }
        return arrayList;
    }

    @Override // p358k.p359a.p360a.p361a.p362i.InterfaceC5855a
    /* renamed from: a */
    public void mo24651a(Context context, int i2, int i3) {
        if (i2 >= i3) {
            C5863e.m24691a("XmlFileGrade", "newVersion is less then oldVersion, onUpgrade error", true);
        } else {
            m24658b(context);
            m24656a(context);
        }
    }

    /* renamed from: a */
    private void m24656a(Context context) {
        if (C2171a.m6327e(context)) {
            return;
        }
        ArrayList<HonorAccount> m24654a = m24654a("accounts.xml", context, true);
        C5849c.m24630a(context, "accounts.xml");
        C2177b.m6340a(context, "accounts.xml", (List<HonorAccount>) m24654a, true);
    }
}
