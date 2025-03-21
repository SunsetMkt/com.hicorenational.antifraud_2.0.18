package com.sina.weibo.sdk.net;

import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.sina.weibo.sdk.net.e */
/* loaded from: classes.dex */
public final class C2934e implements InterfaceC2933d {

    /* renamed from: i */
    private String f9309i;

    /* renamed from: j */
    private Bundle f9310j = new Bundle();

    /* renamed from: k */
    private Bundle f9311k = new Bundle();

    /* renamed from: l */
    private Map<String, Object<File>> f9312l = new HashMap();

    /* renamed from: m */
    private Map<String, byte[]> f9313m = new HashMap();

    /* renamed from: n */
    private int f9314n;

    /* renamed from: o */
    private int f9315o;

    /* renamed from: com.sina.weibo.sdk.net.e$a */
    public static final class a {

        /* renamed from: i */
        public String f9316i;

        /* renamed from: j */
        Bundle f9317j = new Bundle();

        /* renamed from: k */
        Bundle f9318k = new Bundle();

        /* renamed from: l */
        Map<String, Object<File>> f9319l = new HashMap();

        /* renamed from: m */
        Map<String, byte[]> f9320m = new HashMap();

        /* renamed from: n */
        int f9321n = BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH;

        /* renamed from: o */
        int f9322o = 60000;

        /* renamed from: a */
        public final a m8856a(String str, Object obj) {
            m8855a(this.f9317j, str, obj);
            return this;
        }

        /* renamed from: b */
        public final a m8857b(String str, Object obj) {
            m8855a(this.f9318k, str, obj);
            return this;
        }

        /* renamed from: e */
        public final C2934e m8858e() {
            return new C2934e(this);
        }

        /* renamed from: a */
        private void m8855a(Bundle bundle, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof String) {
                    bundle.putString(str, String.valueOf(obj));
                    return;
                }
                if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                    return;
                }
                if (obj instanceof Short) {
                    bundle.putShort(str, ((Short) obj).shortValue());
                    return;
                }
                if (obj instanceof Character) {
                    bundle.putChar(str, ((Character) obj).charValue());
                    return;
                }
                if (obj instanceof Byte) {
                    bundle.putByte(str, ((Byte) obj).byteValue());
                    return;
                }
                if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                    return;
                }
                if (obj instanceof Float) {
                    bundle.putFloat(str, ((Float) obj).floatValue());
                    return;
                }
                if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                    return;
                }
                if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof byte[]) {
                    this.f9320m.put(str, (byte[]) obj);
                } else {
                    if (!(obj instanceof Serializable)) {
                        throw new IllegalArgumentException("Unsupported params type!");
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }

    public C2934e(a aVar) {
        this.f9309i = aVar.f9316i;
        this.f9310j.putAll(aVar.f9317j);
        this.f9311k.putAll(aVar.f9318k);
        this.f9312l.putAll(aVar.f9319l);
        this.f9313m.putAll(aVar.f9320m);
        this.f9314n = aVar.f9321n;
        this.f9315o = aVar.f9322o;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC2933d
    /* renamed from: d */
    public final Bundle mo8854d() {
        return this.f9311k;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC2933d
    public final int getConnectTimeout() {
        return this.f9314n;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC2933d
    public final Bundle getParams() {
        return this.f9310j;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC2933d
    public final int getReadTimeout() {
        return this.f9315o;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC2933d
    public final String getUrl() {
        return this.f9309i;
    }
}
