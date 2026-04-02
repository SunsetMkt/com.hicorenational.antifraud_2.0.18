package h.a.t0;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SchedulerSupport.java */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10423h = "none";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10424i = "custom";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10425j = "io.reactivex:computation";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10426k = "io.reactivex:io";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10427l = "io.reactivex:new-thread";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10428m = "io.reactivex:trampoline";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @e
    public static final String f10429n = "io.reactivex:single";

    String value();
}
