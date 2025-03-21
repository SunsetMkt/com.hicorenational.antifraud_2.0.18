package p286h.p320w2;

import bean.SurveyH5Bean;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p320w2.InterfaceC5667h;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: KProperty.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fJ\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m23546d2 = {"Lkotlin/reflect/KMutableProperty0;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty0$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty0$Setter;", "set", "", SurveyH5Bean.VALUE, "(Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.w2.i */
/* loaded from: classes2.dex */
public interface InterfaceC5668i<R> extends InterfaceC5673n<R>, InterfaceC5667h<R> {

    /* compiled from: KProperty.kt */
    /* renamed from: h.w2.i$a */
    public interface a<R> extends InterfaceC5667h.a<R>, InterfaceC5506l<R, C5715y1> {
    }

    @Override // p286h.p320w2.InterfaceC5667h
    @InterfaceC5816d
    a<R> getSetter();

    void set(R r);
}
