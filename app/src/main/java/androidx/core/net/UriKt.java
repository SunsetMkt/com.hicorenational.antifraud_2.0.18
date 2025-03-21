package androidx.core.net;

import android.net.Uri;
import java.io.File;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Uri.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, m23546d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class UriKt {
    @InterfaceC5816d
    public static final File toFile(@InterfaceC5816d Uri uri) {
        C5544i0.m22546f(uri, "$receiver");
        if (C5544i0.m22531a((Object) uri.getScheme(), (Object) "file")) {
            return new File(uri.getPath());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    @InterfaceC5816d
    public static final Uri toUri(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$receiver");
        Uri parse = Uri.parse(str);
        C5544i0.m22521a((Object) parse, "Uri.parse(this)");
        return parse;
    }

    @InterfaceC5816d
    public static final Uri toUri(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$receiver");
        Uri fromFile = Uri.fromFile(file);
        C5544i0.m22521a((Object) fromFile, "Uri.fromFile(this)");
        return fromFile;
    }
}
