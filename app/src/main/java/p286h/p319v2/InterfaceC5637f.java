package p286h.p319v2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import java.lang.Comparable;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Ranges.kt */
@InterfaceC5610t0(version = "1.1")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, m23546d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedRange;", "contains", "", SurveyH5Bean.VALUE, "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.v2.f */
/* loaded from: classes2.dex */
public interface InterfaceC5637f<T extends Comparable<? super T>> extends InterfaceC5638g<T> {

    /* compiled from: Ranges.kt */
    /* renamed from: h.v2.f$a */
    public static final class a {
        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m23018a(InterfaceC5637f<T> interfaceC5637f, @InterfaceC5816d T t) {
            C5544i0.m22546f(t, SurveyH5Bean.VALUE);
            return interfaceC5637f.mo23014a(interfaceC5637f.getStart(), t) && interfaceC5637f.mo23014a(t, interfaceC5637f.getEndInclusive());
        }

        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m23017a(InterfaceC5637f<T> interfaceC5637f) {
            return !interfaceC5637f.mo23014a(interfaceC5637f.getStart(), interfaceC5637f.getEndInclusive());
        }
    }

    /* renamed from: a */
    boolean mo23014a(@InterfaceC5816d T t, @InterfaceC5816d T t2);

    @Override // p286h.p319v2.InterfaceC5638g
    boolean contains(@InterfaceC5816d T t);

    @Override // p286h.p319v2.InterfaceC5638g
    boolean isEmpty();
}
