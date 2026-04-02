package com.hihonor.honorid.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.a.a.a.c;
import l.a.a.a.j.e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: SDKAccountXmlImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static void a(Context context, HonorAccount honorAccount, boolean z, XmlSerializer xmlSerializer) {
        c.a(xmlSerializer, d.c.a.b.a.a.q, honorAccount.q() + "");
        String strD = honorAccount.d();
        if (strD == null) {
            strD = "";
        }
        c.a(xmlSerializer, "accountType", strD);
        String strO = honorAccount.o();
        if (z) {
            strO = com.hihonor.honorid.d.a.b.b(context, strO);
        }
        if (strO == null) {
            strO = "";
        }
        c.a(xmlSerializer, d.c.a.b.a.a.F, strO);
        String strU = honorAccount.u();
        String strB = z ? com.hihonor.honorid.d.a.b.b(context, strU) : strU;
        if (strB == null) {
            strB = "";
        }
        c.a(xmlSerializer, "uuid", strB);
        String strA = honorAccount.a();
        if (!TextUtils.isEmpty(strA)) {
            strA = com.hihonor.honorid.d.a.b.b(context, strA);
        }
        if (TextUtils.isEmpty(strA)) {
            strA = "";
        }
        c.a(xmlSerializer, d.c.a.b.a.a.f10078k, strA);
        String strE = honorAccount.e();
        if (!TextUtils.isEmpty(strE)) {
            strE = com.hihonor.honorid.d.a.b.b(context, strE);
        }
        if (TextUtils.isEmpty(strE)) {
            strE = "";
        }
        c.a(xmlSerializer, d.c.a.b.a.a.f10079l, strE);
        String strP = honorAccount.p();
        if (!TextUtils.isEmpty(strP)) {
            strP = com.hihonor.honorid.d.a.b.b(context, strP);
        }
        if (TextUtils.isEmpty(strP)) {
            strP = "";
        }
        c.a(xmlSerializer, d.c.a.b.a.a.f10080m, strP);
        c.a(xmlSerializer, d.c.a.b.a.a.o, com.hihonor.honorid.d.a.b.b(context, honorAccount.h() + "") + "");
        String strK = honorAccount.k();
        if (TextUtils.isEmpty(strK)) {
            strK = "";
        }
        c.a(xmlSerializer, "lastUpdateTime", strK);
    }

    private static void b(Context context, HonorAccount honorAccount, boolean z, XmlSerializer xmlSerializer) throws IOException {
        e.b("SDKAccountXmlImpl", "SDKAccountXmlImpl start.", true);
        if (honorAccount == null) {
            e.a("SDKAccountXmlImpl", "account is null.", true);
            return;
        }
        xmlSerializer.startTag("", d.c.a.b.a.a.P);
        xmlSerializer.attribute("", "appId", honorAccount.t());
        String strC = honorAccount.c();
        if (z) {
            strC = com.hihonor.honorid.d.a.b.b(context, strC);
        }
        c.a(xmlSerializer, d.c.a.b.a.a.H, strC);
        String strW = honorAccount.w();
        if (z) {
            strW = com.hihonor.honorid.d.a.b.b(context, strW);
        }
        c.a(xmlSerializer, "userId", strW);
        String strF = honorAccount.f();
        if (z) {
            strF = com.hihonor.honorid.d.a.b.b(context, strF);
        }
        if (strF == null) {
            strF = "";
        }
        c.a(xmlSerializer, "deviceId", strF);
        String strR = honorAccount.r();
        if (z) {
            strR = com.hihonor.honorid.d.a.b.b(context, strR);
        }
        if (strR == null) {
            strR = "";
        }
        c.a(xmlSerializer, d.c.a.b.a.a.t, strR);
        String strG = honorAccount.g();
        if (strG == null) {
            strG = "";
        }
        c.a(xmlSerializer, "deviceType", strG);
        c.a(xmlSerializer, d.c.a.b.a.a.N, com.hihonor.honorid.d.a.b.b(context, honorAccount.s()));
        c.a(xmlSerializer, "loginUserName", com.hihonor.honorid.d.a.b.b(context, honorAccount.l()));
        c.a(xmlSerializer, d.c.a.b.a.a.D, com.hihonor.honorid.d.a.b.b(context, honorAccount.j()));
        a(context, honorAccount, z, xmlSerializer);
        xmlSerializer.endTag("", d.c.a.b.a.a.P);
    }

    private static void c(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if (d.c.a.b.a.a.f10080m.equals(str)) {
            String strA = com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText());
            if (!com.hihonor.honorid.f.a.c(strA)) {
                strA = "";
            }
            honorAccount.r(strA);
            return;
        }
        if (d.c.a.b.a.a.o.equals(str)) {
            try {
                honorAccount.a(Integer.parseInt(com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText())));
            } catch (NumberFormatException unused) {
                e.d("SDKAccountXmlImpl", "NumberFormatException: read accounts.xml parseInt error", true);
            } catch (Exception unused2) {
                e.d("SDKAccountXmlImpl", "sdk read accounts.xml parseInt error", true);
            }
        }
    }

    private static void b(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) throws XmlPullParserException, IOException {
        if ("loginUserName".equals(str)) {
            String strNextText = xmlPullParser.nextText();
            if (z) {
                strNextText = com.hihonor.honorid.d.a.b.a(context, strNextText);
            }
            honorAccount.l(strNextText);
            return;
        }
        if (d.c.a.b.a.a.D.equals(str)) {
            String strNextText2 = xmlPullParser.nextText();
            if (z) {
                strNextText2 = com.hihonor.honorid.d.a.b.a(context, strNextText2);
            }
            honorAccount.j(strNextText2);
            return;
        }
        if (d.c.a.b.a.a.F.equals(str)) {
            String strNextText3 = xmlPullParser.nextText();
            if (z) {
                strNextText3 = com.hihonor.honorid.d.a.b.a(context, strNextText3);
            }
            honorAccount.q(strNextText3);
            return;
        }
        if ("uuid".equals(str)) {
            String strNextText4 = xmlPullParser.nextText();
            if (z) {
                strNextText4 = com.hihonor.honorid.d.a.b.a(context, strNextText4);
            }
            honorAccount.v(strNextText4);
            return;
        }
        if (d.c.a.b.a.a.f10078k.equals(str)) {
            String strA = com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText());
            if (!com.hihonor.honorid.f.a.c(strA)) {
                strA = "";
            }
            honorAccount.a(strA);
            return;
        }
        if (d.c.a.b.a.a.f10079l.equals(str)) {
            String strA2 = com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText());
            if (!com.hihonor.honorid.f.a.c(strA2)) {
                strA2 = "";
            }
            honorAccount.e(strA2);
            return;
        }
        c(xmlPullParser, context, z, honorAccount, str);
    }

    public static void a(Context context, String str, List<HonorAccount> list, boolean z) {
        List<HonorAccount> listA = a(list);
        if (listA != null && !listA.isEmpty() && list != null && !list.isEmpty()) {
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    xmlSerializerNewSerializer.setOutput(stringWriter);
                                    xmlSerializerNewSerializer.startDocument("UTF-8", true);
                                    xmlSerializerNewSerializer.startTag("", "accounts");
                                    xmlSerializerNewSerializer.attribute("", "size", list.size() + "");
                                    Iterator<HonorAccount> it = list.iterator();
                                    while (it.hasNext()) {
                                        b(context, it.next(), z, xmlSerializerNewSerializer);
                                    }
                                    xmlSerializerNewSerializer.endTag("", "accounts");
                                    xmlSerializerNewSerializer.endDocument();
                                    boolean zA = c.a(context.getFilesDir().getCanonicalPath() + "/", str, com.hihonor.honorid.f.a.b(stringWriter.toString()));
                                    e.b("SDKAccountXmlImpl", "write accounts into file :" + zA, true);
                                    if (z && zA) {
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
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<HonorAccount> a(String str, Context context, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        ?? r2 = 0;
        try {
            try {
                File file = new File(context.getFilesDir().getCanonicalPath() + "/" + str);
                if (!file.exists()) {
                    e.b("SDKAccountXmlImpl", " sdk filepath not exist", true);
                    return new ArrayList<>();
                }
                fileInputStream = new FileInputStream(file);
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream, null);
                    ArrayList<HonorAccount> arrayListA = a(xmlPullParserNewPullParser, context, z);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                        e.a("SDKAccountXmlImpl", "IOException  ", true);
                    }
                    return arrayListA;
                } catch (FileNotFoundException unused2) {
                    e.a("SDKAccountXmlImpl", "FileNotFoundException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            e.a("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList;
                } catch (IOException unused4) {
                    e.a("SDKAccountXmlImpl", "IOException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList2 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                            e.a("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList2;
                } catch (RuntimeException unused6) {
                    e.a("SDKAccountXmlImpl", "RuntimeException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList3 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                            e.a("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList3;
                } catch (XmlPullParserException unused8) {
                    e.a("SDKAccountXmlImpl", "XmlPullParserException read xml failed!", true);
                    ArrayList<HonorAccount> arrayList4 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused9) {
                            e.a("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList4;
                } catch (Exception unused10) {
                    e.a("SDKAccountXmlImpl", "Exception read xml failed!", true);
                    ArrayList<HonorAccount> arrayList5 = new ArrayList<>();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused11) {
                            e.a("SDKAccountXmlImpl", "IOException  ", true);
                        }
                    }
                    return arrayList5;
                }
            } catch (FileNotFoundException unused12) {
                fileInputStream = null;
            } catch (IOException unused13) {
                fileInputStream = null;
            } catch (RuntimeException unused14) {
                fileInputStream = null;
            } catch (XmlPullParserException unused15) {
                fileInputStream = null;
            } catch (Exception unused16) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (r2 == 0) {
                }
            }
        } catch (Throwable th2) {
            r2 = str;
            th = th2;
            if (r2 == 0) {
                try {
                    r2.close();
                    throw th;
                } catch (IOException unused17) {
                    e.a("SDKAccountXmlImpl", "IOException  ", true);
                    throw th;
                }
            }
            throw th;
        }
    }

    private static void a(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) throws XmlPullParserException, IOException {
        if ("deviceId".equals(str)) {
            String strNextText = xmlPullParser.nextText();
            if (z) {
                strNextText = com.hihonor.honorid.d.a.b.a(context, strNextText);
            }
            honorAccount.g(strNextText);
            return;
        }
        if (d.c.a.b.a.a.t.equals(str)) {
            String strNextText2 = xmlPullParser.nextText();
            if (z) {
                strNextText2 = com.hihonor.honorid.d.a.b.a(context, strNextText2);
            }
            honorAccount.s(strNextText2);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.h(xmlPullParser.nextText());
            return;
        }
        if (d.c.a.b.a.a.N.equals(str)) {
            honorAccount.t(com.hihonor.honorid.d.a.b.a(context, xmlPullParser.nextText()));
            return;
        }
        if (d.c.a.b.a.a.q.equals(str)) {
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

    private static ArrayList<HonorAccount> a(XmlPullParser xmlPullParser, Context context, boolean z) throws XmlPullParserException, IOException {
        e.b("SDKAccountXmlImpl", "sdkaccount xml parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 2) {
                if (eventType == 3 && d.c.a.b.a.a.P.equals(name)) {
                    e.b("SDKAccountXmlImpl", "parseAccountsFromXml add account:", true);
                    arrayList.add(honorAccount);
                    honorAccount = new HonorAccount();
                }
            } else if (d.c.a.b.a.a.P.equals(name)) {
                String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                if (TextUtils.isEmpty(attributeValue)) {
                    e.c("SDKAccountXmlImpl", "sdk authTokenType is null", true);
                    attributeValue = com.hihonor.honorid.f.a.d(context);
                }
                honorAccount.u(attributeValue);
            } else if (d.c.a.b.a.a.H.equals(name)) {
                String strNextText = xmlPullParser.nextText();
                if (z) {
                    strNextText = com.hihonor.honorid.d.a.b.a(context, strNextText);
                }
                honorAccount.c(strNextText);
            } else if ("userId".equals(name)) {
                String strNextText2 = xmlPullParser.nextText();
                if (z) {
                    strNextText2 = com.hihonor.honorid.d.a.b.a(context, strNextText2);
                }
                honorAccount.x(strNextText2);
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
