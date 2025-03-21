package p375l.p380s;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: HTTP.java */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: l.s.h */
/* loaded from: classes2.dex */
public @interface InterfaceC5908h {
    boolean hasBody() default false;

    String method();

    String path() default "";
}
