package j.b.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Language.java */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface d {
    @j.c.a.c
    String prefix() default "";

    @j.c.a.c
    String suffix() default "";

    @j.c.a.c
    String value();
}
