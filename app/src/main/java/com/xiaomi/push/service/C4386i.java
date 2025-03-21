package com.xiaomi.push.service;

import com.xiaomi.push.C4218fl;
import com.xiaomi.push.C4228fv;
import com.xiaomi.push.C4230fx;
import com.xiaomi.push.InterfaceC4227fu;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.xiaomi.push.service.i */
/* loaded from: classes2.dex */
public class C4386i implements InterfaceC4227fu {
    /* renamed from: a */
    public void m16109a() {
        C4228fv.m14885a().m14890a("all", "xm:chat", this);
    }

    /* renamed from: b */
    public C4218fl m16110b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return m16108a(xmlPullParser);
        }
        return null;
    }

    /* renamed from: a */
    public static C4218fl m16108a(XmlPullParser xmlPullParser) {
        String[] strArr;
        String[] strArr2;
        String str;
        ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                strArr3[i2] = xmlPullParser.getAttributeName(i2);
                strArr4[i2] = C4230fx.m14904b(xmlPullParser.getAttributeValue(i2));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new C4218fl(name, namespace, strArr, strArr2, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                C4218fl m16108a = m16108a(xmlPullParser);
                if (m16108a != null) {
                    arrayList.add(m16108a);
                }
            }
        }
    }
}
