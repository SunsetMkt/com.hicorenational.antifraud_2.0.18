package p251g.p252a.p263t0;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: SchedulerSupport.java */
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: g.a.t0.h */
/* loaded from: classes2.dex */
public @interface InterfaceC4548h {

    /* renamed from: h */
    public static final String f17460h = "none";

    /* renamed from: i */
    public static final String f17461i = "custom";

    /* renamed from: j */
    public static final String f17462j = "io.reactivex:computation";

    /* renamed from: k */
    public static final String f17463k = "io.reactivex:io";

    /* renamed from: l */
    public static final String f17464l = "io.reactivex:new-thread";

    /* renamed from: m */
    public static final String f17465m = "io.reactivex:trampoline";

    /* renamed from: n */
    @InterfaceC4545e
    public static final String f17466n = "io.reactivex:single";

    String value();
}
