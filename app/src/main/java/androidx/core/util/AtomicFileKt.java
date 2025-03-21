package androidx.core.util;

import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5731f;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: AtomicFile.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, m23546d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    @InterfaceC5816d
    public static final byte[] readBytes(@InterfaceC5816d android.util.AtomicFile atomicFile) {
        C5544i0.m22546f(atomicFile, "$receiver");
        byte[] readFully = atomicFile.readFully();
        C5544i0.m22521a((Object) readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    @InterfaceC5816d
    public static final String readText(@InterfaceC5816d android.util.AtomicFile atomicFile, @InterfaceC5816d Charset charset) {
        C5544i0.m22546f(atomicFile, "$receiver");
        C5544i0.m22546f(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        C5544i0.m22521a((Object) readFully, "readFully()");
        return new String(readFully, charset);
    }

    @RequiresApi(17)
    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@InterfaceC5816d android.util.AtomicFile atomicFile, @InterfaceC5816d InterfaceC5506l<? super FileOutputStream, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(atomicFile, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            C5544i0.m22521a((Object) startWrite, "stream");
            interfaceC5506l.invoke(startWrite);
            C5535f0.m22474b(1);
            atomicFile.finishWrite(startWrite);
            C5535f0.m22471a(1);
        } catch (Throwable th) {
            C5535f0.m22474b(1);
            atomicFile.failWrite(startWrite);
            C5535f0.m22471a(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@InterfaceC5816d android.util.AtomicFile atomicFile, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(atomicFile, "$receiver");
        C5544i0.m22546f(bArr, "array");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            C5544i0.m22521a((Object) startWrite, "stream");
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@InterfaceC5816d android.util.AtomicFile atomicFile, @InterfaceC5816d String str, @InterfaceC5816d Charset charset) {
        C5544i0.m22546f(atomicFile, "$receiver");
        C5544i0.m22546f(str, "text");
        C5544i0.m22546f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    @RequiresApi(17)
    public static /* bridge */ /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = C5731f.f20676a;
        }
        writeText(atomicFile, str, charset);
    }
}
