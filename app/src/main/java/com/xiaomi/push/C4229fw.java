package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4219fm;
import com.xiaomi.push.C4223fq;
import com.xiaomi.push.C4225fs;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.C4366ar;
import com.xiaomi.push.service.C4386i;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p000a.p001a.p014u.C0052a;

/* renamed from: com.xiaomi.push.fw */
/* loaded from: classes2.dex */
public class C4229fw {

    /* renamed from: a */
    private static XmlPullParser f15413a;

    /* renamed from: a */
    public static AbstractC4221fo m14893a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", C3351bh.f11580aE))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            C4361am.b m15954a = C4361am.m15951a().m15954a(attributeValue, attributeValue4);
            if (m15954a == null) {
                m15954a = C4361am.m15951a().m15954a(attributeValue, attributeValue3);
            }
            if (m15954a == null) {
                throw new C4215fi("the channel id is wrong while receiving a encrypted message");
            }
            AbstractC4221fo abstractC4221fo = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!C3351bh.f11580aE.equals(xmlPullParser.getName())) {
                        throw new C4215fi("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new C4215fi("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        C4220fn c4220fn = new C4220fn();
                        c4220fn.m14868l(attributeValue);
                        c4220fn.m14839b(true);
                        c4220fn.m14872n(attributeValue3);
                        c4220fn.m14870m(attributeValue4);
                        c4220fn.m14866k(attributeValue2);
                        c4220fn.m14847f(attributeValue5);
                        C4218fl c4218fl = new C4218fl(C3351bh.f11580aE, null, null, null);
                        c4218fl.m14823a(text);
                        c4220fn.m14861a(c4218fl);
                        return c4220fn;
                    }
                    m14898a(C4366ar.m15995a(C4366ar.m15994a(m15954a.f16564h, attributeValue2), text));
                    f15413a.next();
                    abstractC4221fo = m14893a(f15413a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (abstractC4221fo != null) {
                return abstractC4221fo;
            }
            throw new C4215fi("error while receiving a encrypted message with wrong format");
        }
        C4220fn c4220fn2 = new C4220fn();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        c4220fn2.m14866k(attributeValue6);
        c4220fn2.m14870m(xmlPullParser.getAttributeValue("", "to"));
        c4220fn2.m14872n(xmlPullParser.getAttributeValue("", "from"));
        c4220fn2.m14868l(xmlPullParser.getAttributeValue("", "chid"));
        c4220fn2.m14834a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                c4220fn2.m14838b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                c4220fn2.m14841c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                c4220fn2.m14843d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", NotificationCompat.CATEGORY_STATUS);
            if (!TextUtils.isEmpty(attributeValue10)) {
                c4220fn2.m14845e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        c4220fn2.m14836a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase(C0052a.f158j));
        c4220fn2.m14847f(xmlPullParser.getAttributeValue("", "type"));
        String m14899b = m14899b(xmlPullParser);
        if (m14899b == null || "".equals(m14899b.trim())) {
            AbstractC4221fo.m14855q();
        } else {
            c4220fn2.m14853j(m14899b);
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
                    m14899b(xmlPullParser);
                    c4220fn2.m14849g(m14897a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m14897a = m14897a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        c4220fn2.m14851h(m14897a);
                    } else {
                        c4220fn2.m14835a(m14897a, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    c4220fn2.m14862a(m14896a(xmlPullParser));
                } else {
                    c4220fn2.m14861a(m14891a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        c4220fn2.m14852i(str2);
        return c4220fn2;
    }

    /* renamed from: b */
    private static String m14899b(XmlPullParser xmlPullParser) {
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i2)))) {
                return xmlPullParser.getAttributeValue(i2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m14898a(byte[] bArr) {
        if (f15413a == null) {
            try {
                f15413a = XmlPullParserFactory.newInstance().newPullParser();
                f15413a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        f15413a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: a */
    private static String m14897a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a */
    public static C4223fq m14894a(XmlPullParser xmlPullParser) {
        C4223fq.b bVar = C4223fq.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = C4223fq.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        C4223fq c4223fq = new C4223fq(bVar);
        c4223fq.m14870m(xmlPullParser.getAttributeValue("", "to"));
        c4223fq.m14872n(xmlPullParser.getAttributeValue("", "from"));
        c4223fq.m14868l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        c4223fq.m14866k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(NotificationCompat.CATEGORY_STATUS)) {
                    c4223fq.m14879a(xmlPullParser.nextText());
                } else if (name.equals(RemoteMessageConst.Notification.PRIORITY)) {
                    try {
                        c4223fq.m14876a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        c4223fq.m14876a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        c4223fq.m14877a(C4223fq.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    c4223fq.m14862a(m14896a(xmlPullParser));
                } else {
                    c4223fq.m14861a(m14891a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return c4223fq;
    }

    /* renamed from: a */
    public static C4219fm m14892a(XmlPullParser xmlPullParser, AbstractC4207fa abstractC4207fa) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        C4219fm.a m14833a = C4219fm.a.m14833a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        C4219fm c4219fm = null;
        C4225fs c4225fs = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    c4225fs = m14896a(xmlPullParser);
                } else {
                    c4219fm = new C4219fm();
                    c4219fm.m14861a(m14891a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (c4219fm == null) {
            if (C4219fm.a.f15325a != m14833a && C4219fm.a.f15326b != m14833a) {
                c4219fm = new C4219fm() { // from class: com.xiaomi.push.fw.2
                    @Override // com.xiaomi.push.C4219fm
                    /* renamed from: b */
                    public String mo14832b() {
                        return null;
                    }
                };
            } else {
                C4219fm c4219fm2 = new C4219fm() { // from class: com.xiaomi.push.fw.1
                    @Override // com.xiaomi.push.C4219fm
                    /* renamed from: b */
                    public String mo14832b() {
                        return null;
                    }
                };
                c4219fm2.m14866k(attributeValue);
                c4219fm2.m14870m(attributeValue3);
                c4219fm2.m14872n(attributeValue2);
                c4219fm2.m14830a(C4219fm.a.f15328d);
                c4219fm2.m14868l(attributeValue4);
                c4219fm2.m14862a(new C4225fs(C4225fs.a.f15389e));
                abstractC4207fa.mo14741a(c4219fm2);
                AbstractC4022b.m13361d("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        c4219fm.m14866k(attributeValue);
        c4219fm.m14870m(attributeValue2);
        c4219fm.m14868l(attributeValue4);
        c4219fm.m14872n(attributeValue3);
        c4219fm.m14830a(m14833a);
        c4219fm.m14862a(c4225fs);
        c4219fm.m14831a(hashMap);
        return c4219fm;
    }

    /* renamed from: a */
    public static C4224fr m14895a(XmlPullParser xmlPullParser) {
        C4224fr c4224fr = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                c4224fr = new C4224fr(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return c4224fr;
    }

    /* renamed from: a */
    public static C4225fs m14896a(XmlPullParser xmlPullParser) {
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
                        arrayList.add(m14891a(name, namespace, xmlPullParser));
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
        return new C4225fs(Integer.parseInt(str3), str == null ? CommonNetImpl.CANCEL : str, str2, str4, str5, arrayList);
    }

    /* renamed from: a */
    public static C4218fl m14891a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m14888a = C4228fv.m14885a().m14888a("all", "xm:chat");
        if (m14888a == null || !(m14888a instanceof C4386i)) {
            return null;
        }
        return ((C4386i) m14888a).m16110b(xmlPullParser);
    }
}
