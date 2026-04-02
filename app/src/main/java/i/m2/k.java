package i.m2;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import i.q2.t.i0;
import i.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.MatchResult;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", CommonNetImpl.NAME, "", "ReflectAddSuppressedMethod", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public class k {

    /* JADX INFO: compiled from: PlatformImplementations.kt */
    private static final class a {

        @j.c.a.e
        @i.q2.c
        public static final Method a;

        /* JADX INFO: renamed from: b */
        public static final a f12158b = new a();

        /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            i0.a((Object) methods, "throwableClass.methods");
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = methods[i2];
                i0.a((Object) method, "it");
                if (i0.a((Object) method.getName(), (Object) "addSuppressed")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    i0.a((Object) parameterTypes, "it.parameterTypes");
                    boolean z = i0.a((Class) i.g2.n.H(parameterTypes), Throwable.class);
                    if (z) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            a = method;
        }

        private a() {
        }
    }

    public void a(@j.c.a.d Throwable th, @j.c.a.d Throwable th2) throws IllegalAccessException, InvocationTargetException {
        i0.f(th, "cause");
        i0.f(th2, "exception");
        Method method = a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    @j.c.a.e
    public i.z2.j a(@j.c.a.d MatchResult matchResult, @j.c.a.d String str) {
        i0.f(matchResult, "matchResult");
        i0.f(str, CommonNetImpl.NAME);
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @j.c.a.d
    public i.u2.f a() {
        return new i.u2.b();
    }
}
