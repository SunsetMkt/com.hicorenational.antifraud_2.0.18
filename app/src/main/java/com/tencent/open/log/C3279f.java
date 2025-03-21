package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.f */
/* loaded from: classes2.dex */
public class C3279f implements Iterable<String> {

    /* renamed from: a */
    private ConcurrentLinkedQueue<String> f11274a;

    /* renamed from: b */
    private AtomicInteger f11275b;

    public C3279f() {
        this.f11274a = null;
        this.f11275b = null;
        this.f11274a = new ConcurrentLinkedQueue<>();
        this.f11275b = new AtomicInteger(0);
    }

    /* renamed from: a */
    public int m10561a(String str) {
        int length = str.length();
        this.f11274a.add(str);
        return this.f11275b.addAndGet(length);
    }

    /* renamed from: b */
    public void m10563b() {
        this.f11274a.clear();
        this.f11275b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f11274a.iterator();
    }

    /* renamed from: a */
    public void m10562a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i2 = length;
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i4 = 0;
            while (length2 > 0) {
                int i5 = i2 > length2 ? length2 : i2;
                int i6 = i4 + i5;
                next.getChars(i4, i6, cArr, i3);
                i2 -= i5;
                i3 += i5;
                length2 -= i5;
                if (i2 == 0) {
                    if (writer != null) {
                        try {
                            writer.write(cArr, 0, length);
                        } catch (Exception unused) {
                        }
                    }
                    i2 = length;
                    i4 = i6;
                    i3 = 0;
                } else {
                    i4 = i6;
                }
            }
        }
        if (i3 > 0 && writer != null) {
            try {
                writer.write(cArr, 0, i3);
            } catch (Exception unused2) {
            }
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (Exception unused3) {
            }
        }
    }

    /* renamed from: a */
    public int m10560a() {
        return this.f11275b.get();
    }
}
