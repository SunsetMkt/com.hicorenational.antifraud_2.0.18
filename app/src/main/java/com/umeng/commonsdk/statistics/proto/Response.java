package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.AbstractC3386cp;
import com.umeng.analytics.pro.AbstractC3396cz;
import com.umeng.analytics.pro.AbstractC3398da;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3357bn;
import com.umeng.analytics.pro.C3366bw;
import com.umeng.analytics.pro.C3373cc;
import com.umeng.analytics.pro.C3374cd;
import com.umeng.analytics.pro.C3378ch;
import com.umeng.analytics.pro.C3380cj;
import com.umeng.analytics.pro.C3381ck;
import com.umeng.analytics.pro.C3387cq;
import com.umeng.analytics.pro.C3389cs;
import com.umeng.analytics.pro.C3391cu;
import com.umeng.analytics.pro.C3392cv;
import com.umeng.analytics.pro.C3399db;
import com.umeng.analytics.pro.InterfaceC3360bq;
import com.umeng.analytics.pro.InterfaceC3367bx;
import com.umeng.analytics.pro.InterfaceC3394cx;
import com.umeng.analytics.pro.InterfaceC3395cy;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
public class Response implements InterfaceC3360bq<Response, EnumC3522e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<EnumC3522e, C3373cc> metaDataMap;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public C3526d imprint;
    public String msg;
    private EnumC3522e[] optionals;
    public int resp_code;
    private static final C3391cu STRUCT_DESC = new C3391cu("Response");
    private static final C3381ck RESP_CODE_FIELD_DESC = new C3381ck("resp_code", (byte) 8, 1);
    private static final C3381ck MSG_FIELD_DESC = new C3381ck("msg", (byte) 11, 2);
    private static final C3381ck IMPRINT_FIELD_DESC = new C3381ck(C3351bh.f11572X, (byte) 12, 3);
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> schemes = new HashMap();

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$a */
    private static class C3518a extends AbstractC3396cz<Response> {
        private C3518a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, Response response) throws C3366bw {
            abstractC3386cp.mo11137j();
            while (true) {
                C3381ck mo11139l = abstractC3386cp.mo11139l();
                byte b2 = mo11139l.f11834b;
                if (b2 == 0) {
                    break;
                }
                short s = mo11139l.f11835c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        } else if (b2 == 12) {
                            response.imprint = new C3526d();
                            response.imprint.read(abstractC3386cp);
                            response.setImprintIsSet(true);
                        } else {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        }
                    } else if (b2 == 11) {
                        response.msg = abstractC3386cp.mo11153z();
                        response.setMsgIsSet(true);
                    } else {
                        C3389cs.m11183a(abstractC3386cp, b2);
                    }
                } else if (b2 == 8) {
                    response.resp_code = abstractC3386cp.mo11150w();
                    response.setResp_codeIsSet(true);
                } else {
                    C3389cs.m11183a(abstractC3386cp, b2);
                }
                abstractC3386cp.mo11140m();
            }
            abstractC3386cp.mo11138k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new C3387cq("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, Response response) throws C3366bw {
            response.validate();
            abstractC3386cp.mo11121a(Response.STRUCT_DESC);
            abstractC3386cp.mo11116a(Response.RESP_CODE_FIELD_DESC);
            abstractC3386cp.mo11114a(response.resp_code);
            abstractC3386cp.mo11128c();
            if (response.msg != null && response.isSetMsg()) {
                abstractC3386cp.mo11116a(Response.MSG_FIELD_DESC);
                abstractC3386cp.mo11122a(response.msg);
                abstractC3386cp.mo11128c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                abstractC3386cp.mo11116a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(abstractC3386cp);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$b */
    private static class C3519b implements InterfaceC3395cy {
        private C3519b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C3518a mo10977b() {
            return new C3518a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$c */
    private static class C3520c extends AbstractC3398da<Response> {
        private C3520c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, Response response) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3392cv.mo11114a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            c3392cv.m11187a(bitSet, 2);
            if (response.isSetMsg()) {
                c3392cv.mo11122a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(c3392cv);
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, Response response) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            response.resp_code = c3392cv.mo11150w();
            response.setResp_codeIsSet(true);
            BitSet m11188b = c3392cv.m11188b(2);
            if (m11188b.get(0)) {
                response.msg = c3392cv.mo11153z();
                response.setMsgIsSet(true);
            }
            if (m11188b.get(1)) {
                response.imprint = new C3526d();
                response.imprint.read(c3392cv);
                response.setImprintIsSet(true);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$d */
    private static class C3521d implements InterfaceC3395cy {
        private C3521d() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C3520c mo10977b() {
            return new C3520c();
        }
    }

    static {
        schemes.put(AbstractC3396cz.class, new C3519b());
        schemes.put(AbstractC3398da.class, new C3521d());
        EnumMap enumMap = new EnumMap(EnumC3522e.class);
        enumMap.put((EnumMap) EnumC3522e.RESP_CODE, (EnumC3522e) new C3373cc("resp_code", (byte) 1, new C3374cd((byte) 8)));
        enumMap.put((EnumMap) EnumC3522e.MSG, (EnumC3522e) new C3373cc("msg", (byte) 2, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) EnumC3522e.IMPRINT, (EnumC3522e) new C3373cc(C3351bh.f11572X, (byte) 2, new C3378ch((byte) 12, C3526d.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        C3373cc.m11103a(Response.class, metaDataMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new EnumC3522e[]{EnumC3522e.MSG, EnumC3522e.IMPRINT};
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new C3380cj(new C3399db(objectInputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C3380cj(new C3399db(objectOutputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public C3526d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return C3357bn.m11017a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        schemes.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    public Response setImprint(C3526d c3526d) {
        this.imprint = c3526d;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i2) {
        this.resp_code = i2;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = C3357bn.m11009a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            C3526d c3526d = this.imprint;
            if (c3526d == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c3526d);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = C3357bn.m11021b(this.__isset_bitfield, 0);
    }

    public void validate() throws C3366bw {
        C3526d c3526d = this.imprint;
        if (c3526d != null) {
            c3526d.m12040l();
        }
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        schemes.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$e */
    public enum EnumC3522e implements InterfaceC3367bx {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, C3351bh.f11572X);


        /* renamed from: d */
        private static final Map<String, EnumC3522e> f12826d = new HashMap();

        /* renamed from: e */
        private final short f12828e;

        /* renamed from: f */
        private final String f12829f;

        static {
            Iterator it = EnumSet.allOf(EnumC3522e.class).iterator();
            while (it.hasNext()) {
                EnumC3522e enumC3522e = (EnumC3522e) it.next();
                f12826d.put(enumC3522e.mo10985b(), enumC3522e);
            }
        }

        EnumC3522e(short s, String str) {
            this.f12828e = s;
            this.f12829f = str;
        }

        /* renamed from: a */
        public static EnumC3522e m11902a(int i2) {
            if (i2 == 1) {
                return RESP_CODE;
            }
            if (i2 == 2) {
                return MSG;
            }
            if (i2 != 3) {
                return null;
            }
            return IMPRINT;
        }

        /* renamed from: b */
        public static EnumC3522e m11904b(int i2) {
            EnumC3522e m11902a = m11902a(i2);
            if (m11902a != null) {
                return m11902a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: b */
        public String mo10985b() {
            return this.f12829f;
        }

        /* renamed from: a */
        public static EnumC3522e m11903a(String str) {
            return f12826d.get(str);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: a */
        public short mo10984a() {
            return this.f12828e;
        }
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public InterfaceC3360bq<Response, EnumC3522e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public EnumC3522e fieldForId(int i2) {
        return EnumC3522e.m11902a(i2);
    }

    public Response(int i2) {
        this();
        this.resp_code = i2;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new EnumC3522e[]{EnumC3522e.MSG, EnumC3522e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new C3526d(response.imprint);
        }
    }
}
