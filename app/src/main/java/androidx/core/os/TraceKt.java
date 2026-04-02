package androidx.core.os;

import androidx.exifinterface.media.ExifInterface;
import i.q2.s.a;
import i.q2.t.f0;
import i.q2.t.i0;
import i.y;
import j.c.a.d;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes.dex */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {AgooConstants.MESSAGE_TRACE, ExifInterface.GPS_DIRECTION_TRUE, "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class TraceKt {
    public static final <T> T trace(@d String str, @d a<? extends T> aVar) {
        i0.f(str, "sectionName");
        i0.f(aVar, "block");
        TraceCompat.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            f0.b(1);
            TraceCompat.endSection();
            f0.a(1);
        }
    }
}
