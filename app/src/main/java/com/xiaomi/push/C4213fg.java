package com.xiaomi.push;

import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.fg */
/* loaded from: classes2.dex */
public final class C4213fg {

    /* renamed from: a */
    private static int f15291a = 5000;

    /* renamed from: a */
    private static Vector<String> f15292a = new Vector<>();

    /* renamed from: b */
    private static int f15293b = 330000;

    /* renamed from: c */
    private static int f15294c = 600000;

    /* renamed from: d */
    private static int f15295d = 330000;

    static {
        try {
            for (ClassLoader classLoader : m14800a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = resources.nextElement().openStream();
                            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals(PushClientConstants.TAG_CLASS_NAME)) {
                                        m14799a(newPullParser);
                                    } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                        f15291a = m14797a(newPullParser, f15291a);
                                    } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                        f15293b = m14797a(newPullParser, f15293b);
                                    } else if (newPullParser.getName().equals("mechName")) {
                                        f15292a.add(newPullParser.nextText());
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                        } catch (Throwable th) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private C4213fg() {
    }

    /* renamed from: a */
    public static int m14796a() {
        return f15293b;
    }

    /* renamed from: a */
    public static String m14798a() {
        return "3.1.0";
    }

    /* renamed from: b */
    public static int m14801b() {
        return f15294c;
    }

    /* renamed from: a */
    private static void m14799a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException unused) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    /* renamed from: a */
    private static int m14797a(XmlPullParser xmlPullParser, int i2) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    /* renamed from: a */
    private static ClassLoader[] m14800a() {
        ClassLoader[] classLoaderArr = {C4213fg.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
