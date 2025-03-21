package p324i.p333b.p334a.p335a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p324i.p336c.p337a.InterfaceC5815c;

/* compiled from: Flow.java */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* renamed from: i.b.a.a.a */
/* loaded from: classes2.dex */
public @interface InterfaceC5803a {

    /* renamed from: o */
    @InterfaceC5815c
    public static final String f20937o = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    /* renamed from: p */
    @InterfaceC5815c
    public static final String f20938p = "this";

    /* renamed from: q */
    @InterfaceC5815c
    public static final String f20939q = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    /* renamed from: r */
    @InterfaceC5815c
    public static final String f20940r = "The return value of this method";

    /* renamed from: s */
    @InterfaceC5815c
    public static final String f20941s = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
