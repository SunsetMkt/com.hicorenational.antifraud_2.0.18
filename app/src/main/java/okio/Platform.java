package okio;

import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5731f;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: -Platform.kt */
@InterfaceC5481e(name = "-Platform")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00000\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\t*\u00020\bH\u0000*\n\u0010\u000b\"\u00020\f2\u00020\f*\n\u0010\r\"\u00020\u000e2\u00020\u000e*\n\u0010\u000f\"\u00020\u00102\u00020\u0010¨\u0006\u0011"}, m23546d2 = {"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "EOFException", "Ljava/io/EOFException;", "IOException", "Ljava/io/IOException;", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: okio.-Platform, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Platform {
    @InterfaceC5816d
    public static final byte[] asUtf8ToByteArray(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(C5731f.f20676a);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized, reason: not valid java name */
    public static final <R> R m26865synchronized(@InterfaceC5816d Object obj, @InterfaceC5816d InterfaceC5495a<? extends R> interfaceC5495a) {
        R invoke;
        C5544i0.m22546f(obj, "lock");
        C5544i0.m22546f(interfaceC5495a, "block");
        synchronized (obj) {
            try {
                invoke = interfaceC5495a.invoke();
                C5535f0.m22474b(1);
            } catch (Throwable th) {
                C5535f0.m22474b(1);
                C5535f0.m22471a(1);
                throw th;
            }
        }
        C5535f0.m22471a(1);
        return invoke;
    }

    @InterfaceC5816d
    public static final String toUtf8String(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$toUtf8String");
        return new String(bArr, C5731f.f20676a);
    }
}
