package network.gson;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2058f;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.C2016i;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class ResponseDataTypeAdaptor extends AbstractC2077y<ResponseData> {
    public static final InterfaceC2078z FACTORY = new InterfaceC2078z() { // from class: network.gson.ResponseDataTypeAdaptor.1
        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            if (c2049a.getRawType() == ResponseData.class) {
                return new ResponseDataTypeAdaptor(c2051e);
            }
            return null;
        }
    };
    private final C2051e gson;

    /* renamed from: network.gson.ResponseDataTypeAdaptor$2 */
    static /* synthetic */ class C59562 {
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

    ResponseDataTypeAdaptor(C2051e c2051e) {
        this.gson = c2051e;
    }

    public static C2051e buildGson() {
        C2058f c2058f = new C2058f();
        c2058f.m5641a(FACTORY);
        c2058f.m5647b();
        return c2058f.m5631a();
    }

    private Object readInternal(C2052a c2052a) throws IOException {
        switch (C59562.$SwitchMap$com$google$gson$stream$JsonToken[c2052a.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                c2052a.mo5417c();
                while (c2052a.mo5423j()) {
                    arrayList.add(readInternal(c2052a));
                }
                c2052a.mo5419f();
                return arrayList;
            case 2:
                C2016i c2016i = new C2016i();
                c2052a.mo5418d();
                while (c2052a.mo5423j()) {
                    c2016i.put(c2052a.mo5428q(), readInternal(c2052a));
                }
                c2052a.mo5420g();
                return c2016i;
            case 3:
                return c2052a.mo5430s();
            case 4:
                String mo5430s = c2052a.mo5430s();
                return (mo5430s.contains(".") || mo5430s.contains("e") || mo5430s.contains(ExifInterface.LONGITUDE_EAST)) ? Double.valueOf(Double.parseDouble(mo5430s)) : Long.parseLong(mo5430s) <= 2147483647L ? Integer.valueOf(Integer.parseInt(mo5430s)) : Long.valueOf(Long.parseLong(mo5430s));
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
    public ResponseData read(C2052a c2052a) throws IOException {
        ResponseData responseData = new ResponseData();
        Map map = (Map) readInternal(c2052a);
        responseData.setStatus((Integer) map.get(NotificationCompat.CATEGORY_STATUS));
        responseData.setMsg((String) map.get("msg"));
        responseData.setData(map.get("data"));
        return responseData;
    }

    @Override // com.google.gson.AbstractC2077y
    public void write(C2055d c2055d, ResponseData responseData) throws IOException {
        if (responseData == null) {
            c2055d.mo5448j();
            return;
        }
        c2055d.mo5443d();
        c2055d.mo5441b(NotificationCompat.CATEGORY_STATUS);
        this.gson.m5559a(Integer.class).write(c2055d, responseData.getStatus());
        c2055d.mo5441b("msg");
        this.gson.m5559a(String.class).write(c2055d, responseData.getMsg());
        c2055d.mo5441b("data");
        this.gson.m5559a(Object.class).write(c2055d, responseData.getData());
        c2055d.mo5447f();
    }
}
