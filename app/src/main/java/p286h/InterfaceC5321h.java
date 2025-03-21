package p286h;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p286h.p288f2.EnumC5231a;
import p286h.p288f2.EnumC5232b;
import p286h.p288f2.InterfaceC5235e;
import p286h.p288f2.InterfaceC5236f;

/* compiled from: Experimental.kt */
@Target({ElementType.ANNOTATION_TYPE})
@InterfaceC5216c(message = "Please use RequiresOptIn instead.")
@Retention(RetentionPolicy.CLASS)
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009120\u0001¨\u0006\u0006"}, m23546d2 = {"Lkotlin/Experimental;", "", "level", "Lkotlin/Experimental$Level;", "()Lkotlin/Experimental$Level;", "Level", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5236f(allowedTargets = {EnumC5232b.ANNOTATION_CLASS})
@InterfaceC5610t0(version = "1.2")
@InterfaceC5235e(EnumC5231a.BINARY)
/* renamed from: h.h */
/* loaded from: classes2.dex */
public @interface InterfaceC5321h {

    /* compiled from: Experimental.kt */
    /* renamed from: h.h$a */
    public enum a {
        WARNING,
        ERROR
    }

    a level() default a.ERROR;
}
