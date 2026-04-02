package com.sina.weibo.sdk.net;

import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bundle f5693j = new Bundle();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Bundle f5694k = new Bundle();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, Object<File>> f5695l = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<String, byte[]> f5696m = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f5697n;
    private int o;

    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f5698i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Bundle f5699j = new Bundle();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Bundle f5700k = new Bundle();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Map<String, Object<File>> f5701l = new HashMap();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Map<String, byte[]> f5702m = new HashMap();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f5703n = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        int o = 60000;

        public final a a(String str, Object obj) {
            a(this.f5699j, str, obj);
            return this;
        }

        public final a b(String str, Object obj) {
            a(this.f5700k, str, obj);
            return this;
        }

        public final e e() {
            return new e(this);
        }

        private void a(Bundle bundle, String str, Object obj) {
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
                    this.f5702m.put(str, (byte[]) obj);
                } else {
                    if (!(obj instanceof Serializable)) {
                        throw new IllegalArgumentException("Unsupported params type!");
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }

    public e(a aVar) {
        this.f5692i = aVar.f5698i;
        this.f5693j.putAll(aVar.f5699j);
        this.f5694k.putAll(aVar.f5700k);
        this.f5695l.putAll(aVar.f5701l);
        this.f5696m.putAll(aVar.f5702m);
        this.f5697n = aVar.f5703n;
        this.o = aVar.o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle d() {
        return this.f5694k;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getConnectTimeout() {
        return this.f5697n;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle getParams() {
        return this.f5693j;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getReadTimeout() {
        return this.o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final String getUrl() {
        return this.f5692i;
    }
}
