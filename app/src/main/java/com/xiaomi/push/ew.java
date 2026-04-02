package com.xiaomi.push;

import com.taobao.accs.utl.BaseMonitor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
public class ew {
    private XmlPullParser a;

    ew() {
        try {
            this.a = XmlPullParserFactory.newInstance().newPullParser();
            this.a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    fo a(byte[] bArr, fa faVar) throws XmlPullParserException, fi, IOException {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return fw.a(this.a);
        }
        if (name.equals("iq")) {
            return fw.a(this.a, faVar);
        }
        if (name.equals("presence")) {
            return fw.m438a(this.a);
        }
        if (this.a.getName().equals("stream")) {
            return null;
        }
        if (this.a.getName().equals("error")) {
            throw new fi(fw.m439a(this.a));
        }
        if (!this.a.getName().equals("warning")) {
            this.a.getName().equals(BaseMonitor.ALARM_POINT_BIND);
            return null;
        }
        this.a.next();
        this.a.getName().equals("multi-login");
        return null;
    }
}
