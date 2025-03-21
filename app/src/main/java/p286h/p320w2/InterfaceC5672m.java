package p286h.p320w2;

import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: KProperty.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u000e\u000fR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\u000bR\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u000b¨\u0006\u0010"}, m23546d2 = {"Lkotlin/reflect/KProperty;", "R", "Lkotlin/reflect/KCallable;", "getter", "Lkotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "isConst", "", "isConst$annotations", "()V", "()Z", "isLateinit", "isLateinit$annotations", "Accessor", "Getter", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.w2.m */
/* loaded from: classes2.dex */
public interface InterfaceC5672m<R> extends InterfaceC5661b<R> {

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.m$a */
    public interface a<R> {
        @InterfaceC5816d
        /* renamed from: a */
        InterfaceC5672m<R> m23257a();
    }

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.m$b */
    public static final class b {
        @InterfaceC5610t0(version = "1.1")
        /* renamed from: a */
        public static /* synthetic */ void m23258a() {
        }

        @InterfaceC5610t0(version = "1.1")
        /* renamed from: b */
        public static /* synthetic */ void m23259b() {
        }
    }

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.m$c */
    public interface c<R> extends a<R>, InterfaceC5666g<R> {
    }

    @InterfaceC5816d
    c<R> getGetter();

    boolean isConst();

    boolean isLateinit();
}
