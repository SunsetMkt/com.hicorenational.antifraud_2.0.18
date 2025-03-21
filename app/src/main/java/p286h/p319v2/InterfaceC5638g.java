package p286h.p319v2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import java.lang.Comparable;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Range.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, m23546d2 = {"Lkotlin/ranges/ClosedRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "contains", "", SurveyH5Bean.VALUE, "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.v2.g */
/* loaded from: classes2.dex */
public interface InterfaceC5638g<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    /* renamed from: h.v2.g$a */
    public static final class a {
        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m23020a(InterfaceC5638g<T> interfaceC5638g, @InterfaceC5816d T t) {
            C5544i0.m22546f(t, SurveyH5Bean.VALUE);
            return t.compareTo(interfaceC5638g.getStart()) >= 0 && t.compareTo(interfaceC5638g.getEndInclusive()) <= 0;
        }

        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m23019a(InterfaceC5638g<T> interfaceC5638g) {
            return interfaceC5638g.getStart().compareTo(interfaceC5638g.getEndInclusive()) > 0;
        }
    }

    boolean contains(@InterfaceC5816d T t);

    @InterfaceC5816d
    T getEndInclusive();

    @InterfaceC5816d
    T getStart();

    boolean isEmpty();
}
