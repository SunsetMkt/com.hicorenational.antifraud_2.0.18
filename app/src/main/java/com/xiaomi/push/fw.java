package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.am;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class fw {

    /* renamed from: a, reason: collision with root package name */
    private static XmlPullParser f12899a;

    public static fo a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", com.umeng.analytics.pro.bh.aE))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            am.b a2 = com.xiaomi.push.service.am.a().a(attributeValue, attributeValue4);
            if (a2 == null) {
                a2 = com.xiaomi.push.service.am.a().a(attributeValue, attributeValue3);
            }
            if (a2 == null) {
                throw new fi("the channel id is wrong while receiving a encrypted message");
            }
            fo foVar = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!com.umeng.analytics.pro.bh.aE.equals(xmlPullParser.getName())) {
                        throw new fi("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new fi("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        fn fnVar = new fn();
                        fnVar.l(attributeValue);
                        fnVar.b(true);
                        fnVar.n(attributeValue3);
                        fnVar.m(attributeValue4);
                        fnVar.k(attributeValue2);
                        fnVar.f(attributeValue5);
                        fl flVar = new fl(com.umeng.analytics.pro.bh.aE, null, null, null);
                        flVar.m429a(text);
                        fnVar.a(flVar);
                        return fnVar;
                    }
                    a(com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(a2.f13351h, attributeValue2), text));
                    f12899a.next();
                    foVar = a(f12899a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (foVar != null) {
                return foVar;
            }
            throw new fi("error while receiving a encrypted message with wrong format");
        }
        fn fnVar2 = new fn();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        fnVar2.k(attributeValue6);
        fnVar2.m(xmlPullParser.getAttributeValue("", "to"));
        fnVar2.n(xmlPullParser.getAttributeValue("", "from"));
        fnVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        fnVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                fnVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fnVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fnVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", NotificationCompat.CATEGORY_STATUS);
            if (!TextUtils.isEmpty(attributeValue10)) {
                fnVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        fnVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase(a.a.u.a.f1253j));
        fnVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String b2 = b(xmlPullParser);
        if (b2 == null || "".equals(b2.trim())) {
            fo.q();
        } else {
            fnVar2.j(b2);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    fnVar2.g(m443a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m443a = m443a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        fnVar2.h(m443a);
                    } else {
                        fnVar2.a(m443a, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fnVar2.a(m442a(xmlPullParser));
                } else {
                    fnVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        fnVar2.i(str2);
        return fnVar2;
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i2)))) {
                return xmlPullParser.getAttributeValue(i2);
            }
        }
        return null;
    }

    private static void a(byte[] bArr) {
        if (f12899a == null) {
            try {
                f12899a = XmlPullParserFactory.newInstance().newPullParser();
                f12899a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        f12899a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m443a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fq m440a(XmlPullParser xmlPullParser) {
        fq.b bVar = fq.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = fq.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        fq fqVar = new fq(bVar);
        fqVar.m(xmlPullParser.getAttributeValue("", "to"));
        fqVar.n(xmlPullParser.getAttributeValue("", "from"));
        fqVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fqVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(NotificationCompat.CATEGORY_STATUS)) {
                    fqVar.a(xmlPullParser.nextText());
                } else if (name.equals(RemoteMessageConst.Notification.PRIORITY)) {
                    try {
                        fqVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fqVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fqVar.a(fq.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    fqVar.a(m442a(xmlPullParser));
                } else {
                    fqVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fqVar;
    }

    public static fm a(XmlPullParser xmlPullParser, fa faVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fm.a a2 = fm.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fm fmVar = null;
        fs fsVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    fsVar = m442a(xmlPullParser);
                } else {
                    fmVar = new fm();
                    fmVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (fmVar == null) {
            if (fm.a.f12838a != a2 && fm.a.f12839b != a2) {
                fmVar = new fm() { // from class: com.xiaomi.push.fw.2
                    @Override // com.xiaomi.push.fm
                    public String b() {
                        return null;
                    }
                };
            } else {
                fm fmVar2 = new fm() { // from class: com.xiaomi.push.fw.1
                    @Override // com.xiaomi.push.fm
                    public String b() {
                        return null;
                    }
                };
                fmVar2.k(attributeValue);
                fmVar2.m(attributeValue3);
                fmVar2.n(attributeValue2);
                fmVar2.a(fm.a.f12841d);
                fmVar2.l(attributeValue4);
                fmVar2.a(new fs(fs.a.f12888e));
                faVar.a(fmVar2);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        fmVar.k(attributeValue);
        fmVar.m(attributeValue2);
        fmVar.l(attributeValue4);
        fmVar.n(attributeValue3);
        fmVar.a(a2);
        fmVar.a(fsVar);
        fmVar.a(hashMap);
        return fmVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fr m441a(XmlPullParser xmlPullParser) {
        fr frVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                frVar = new fr(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return frVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fs m442a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = "-1";
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            if (xmlPullParser.getAttributeName(i2).equals("code")) {
                str3 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i2).equals("type")) {
                str = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i2).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new fs(Integer.parseInt(str3), str == null ? CommonNetImpl.CANCEL : str, str2, str4, str5, arrayList);
    }

    public static fl a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m438a = fv.a().m438a("all", "xm:chat");
        if (m438a == null || !(m438a instanceof com.xiaomi.push.service.i)) {
            return null;
        }
        return ((com.xiaomi.push.service.i) m438a).b(xmlPullParser);
    }
}
