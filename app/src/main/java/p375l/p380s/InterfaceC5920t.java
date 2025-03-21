package p375l.p380s;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Query.java */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: l.s.t */
/* loaded from: classes2.dex */
public @interface InterfaceC5920t {
    boolean encoded() default false;

    String value();
}
