package d.b.c.z;

import java.util.List;

/* JADX INFO: compiled from: DecoderResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<byte[]> f10002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f10004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f10005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f10006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f10007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f10008i;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f10002c;
    }

    public String b() {
        return this.f10003d;
    }

    public Integer c() {
        return this.f10005f;
    }

    public Integer d() {
        return this.f10004e;
    }

    public Object e() {
        return this.f10006g;
    }

    public byte[] f() {
        return this.a;
    }

    public int g() {
        return this.f10007h;
    }

    public int h() {
        return this.f10008i;
    }

    public String i() {
        return this.f10001b;
    }

    public boolean j() {
        return this.f10007h >= 0 && this.f10008i >= 0;
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.a = bArr;
        this.f10001b = str;
        this.f10002c = list;
        this.f10003d = str2;
        this.f10007h = i3;
        this.f10008i = i2;
    }

    public void a(Integer num) {
        this.f10005f = num;
    }

    public void b(Integer num) {
        this.f10004e = num;
    }

    public void a(Object obj) {
        this.f10006g = obj;
    }
}
