package network.gson;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2058f;
import com.google.gson.p147b0.C2016i;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ObjectTypeAdapter extends AbstractC2077y<Object> {
    private static final C2051e gson = new C2051e();
    private AbstractC2077y objectTypeAdapter = gson.m5559a(Object.class);

    /* renamed from: network.gson.ObjectTypeAdapter$2 */
    static /* synthetic */ class C59542 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[EnumC2054c.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC2054c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC2054c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC2054c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC2054c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC2054c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC2054c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static C2051e buildNewGson() {
        C2058f c2058f = new C2058f();
        c2058f.m5644a(new C2049a<Map<String, Object>>() { // from class: network.gson.ObjectTypeAdapter.1
        }.getType(), new ObjectTypeAdapter());
        c2058f.m5647b();
        return c2058f.m5631a();
    }

    @Override // com.google.gson.AbstractC2077y
    public Object read(C2052a c2052a) throws IOException {
        switch (C59542.$SwitchMap$com$google$gson$stream$JsonToken[c2052a.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                c2052a.mo5417c();
                while (c2052a.mo5423j()) {
                    arrayList.add(read(c2052a));
                }
                c2052a.mo5419f();
                return arrayList;
            case 2:
                C2016i c2016i = new C2016i();
                c2052a.mo5418d();
                while (c2052a.mo5423j()) {
                    c2016i.put(c2052a.mo5428q(), read(c2052a));
                }
                c2052a.mo5420g();
                return c2016i;
            case 3:
                return c2052a.mo5430s();
            case 4:
                String mo5430s = c2052a.mo5430s();
                return (mo5430s.contains(".") || mo5430s.contains("e") || mo5430s.contains(ExifInterface.LONGITUDE_EAST)) ? Double.valueOf(Double.parseDouble(mo5430s)) : Long.valueOf(Long.parseLong(mo5430s));
            case 5:
                return Boolean.valueOf(c2052a.mo5424m());
            case 6:
                c2052a.mo5429r();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.AbstractC2077y
    public void write(C2055d c2055d, Object obj) throws IOException {
        this.objectTypeAdapter.write(c2055d, obj);
    }
}
