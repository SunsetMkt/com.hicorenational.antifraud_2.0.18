package p286h.p320w2;

import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p320w2.InterfaceC5672m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: KProperty.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fJ\r\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH'R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m23546d2 = {"Lkotlin/reflect/KProperty0;", "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function0;", "getter", "Lkotlin/reflect/KProperty0$Getter;", "getGetter", "()Lkotlin/reflect/KProperty0$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "", "Getter", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.w2.n */
/* loaded from: classes2.dex */
public interface InterfaceC5673n<R> extends InterfaceC5672m<R>, InterfaceC5495a<R> {

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.n$a */
    public interface a<R> extends InterfaceC5672m.c<R>, InterfaceC5495a<R> {
    }

    R get();

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5817e
    Object getDelegate();

    @Override // p286h.p320w2.InterfaceC5672m
    @InterfaceC5816d
    a<R> getGetter();
}
