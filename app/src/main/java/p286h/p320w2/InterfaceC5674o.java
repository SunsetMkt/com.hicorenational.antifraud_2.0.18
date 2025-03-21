package p286h.p320w2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p320w2.InterfaceC5672m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: KProperty.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u000eJ\u0015\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00028\u0000H'¢\u0006\u0002\u0010\u000bR\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, m23546d2 = {"Lkotlin/reflect/KProperty1;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function1;", "getter", "Lkotlin/reflect/KProperty1$Getter;", "getGetter", "()Lkotlin/reflect/KProperty1$Getter;", "get", SocialConstants.PARAM_RECEIVER, "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "Getter", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.w2.o */
/* loaded from: classes2.dex */
public interface InterfaceC5674o<T, R> extends InterfaceC5672m<R>, InterfaceC5506l<T, R> {

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.o$a */
    public interface a<T, R> extends InterfaceC5672m.c<R>, InterfaceC5506l<T, R> {
    }

    R get(T t);

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    Object getDelegate(T t);

    @Override // p286h.p320w2.InterfaceC5672m
    @InterfaceC5816d
    a<T, R> getGetter();
}
