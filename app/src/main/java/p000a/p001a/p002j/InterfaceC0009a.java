package p000a.p001a.p002j;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: a.a.j.a */
/* loaded from: classes.dex */
public interface InterfaceC0009a {

    /* compiled from: Taobao */
    /* renamed from: a.a.j.a$a */
    public static class a implements Serializable {
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, List<String>> responseHeaders = Collections.EMPTY_MAP;
        public long serverDate;
        public long ttl;

        public boolean isFresh() {
            return System.currentTimeMillis() <= this.ttl;
        }
    }

    void clear();

    a get(String str);

    void put(String str, a aVar);

    void remove(String str);
}
