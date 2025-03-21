package androidx.core.os;

import androidx.exifinterface.media.ExifInterface;
import org.android.agoo.common.AgooConstants;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Trace.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m23546d2 = {AgooConstants.MESSAGE_TRACE, ExifInterface.GPS_DIRECTION_TRUE, "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(@InterfaceC5816d String str, @InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(str, "sectionName");
        C5544i0.m22546f(interfaceC5495a, "block");
        TraceCompat.beginSection(str);
        try {
            return interfaceC5495a.invoke();
        } finally {
            C5535f0.m22474b(1);
            TraceCompat.endSection();
            C5535f0.m22471a(1);
        }
    }
}
