package i;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({})
@i.f2.c
@i.f2.f(allowedTargets = {})
@Documented
@Retention(RetentionPolicy.CLASS)
@i.f2.e(i.f2.a.BINARY)
public @interface o0 {
    String expression();

    String[] imports();
}
