package com.xiaomi.push;

import com.taobao.accs.utl.BaseMonitor;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.ew */
/* loaded from: classes2.dex */
public class C4202ew {

    /* renamed from: a */
    private XmlPullParser f15240a;

    C4202ew() {
        try {
            this.f15240a = XmlPullParserFactory.newInstance().newPullParser();
            this.f15240a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* renamed from: a */
    AbstractC4221fo m14734a(byte[] bArr, AbstractC4207fa abstractC4207fa) {
        this.f15240a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f15240a.next();
        int eventType = this.f15240a.getEventType();
        String name = this.f15240a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return C4229fw.m14893a(this.f15240a);
        }
        if (name.equals("iq")) {
            return C4229fw.m14892a(this.f15240a, abstractC4207fa);
        }
        if (name.equals("presence")) {
            return C4229fw.m14894a(this.f15240a);
        }
        if (this.f15240a.getName().equals("stream")) {
            return null;
        }
        if (this.f15240a.getName().equals("error")) {
            throw new C4215fi(C4229fw.m14895a(this.f15240a));
        }
        if (!this.f15240a.getName().equals("warning")) {
            this.f15240a.getName().equals(BaseMonitor.ALARM_POINT_BIND);
            return null;
        }
        this.f15240a.next();
        this.f15240a.getName().equals("multi-login");
        return null;
    }
}
