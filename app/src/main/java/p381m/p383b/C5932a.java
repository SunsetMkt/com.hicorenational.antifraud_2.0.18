package p381m.p383b;

import android.content.Intent;
import android.net.Uri;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import p031c.p035b.p043c.EnumC0953a;
import zxing.android.C7346e;

/* compiled from: DecodeFormatManager.java */
/* renamed from: m.b.a */
/* loaded from: classes2.dex */
public final class C5932a {

    /* renamed from: i */
    private static final Map<String, Set<EnumC0953a>> f21417i;

    /* renamed from: a */
    private static final Pattern f21409a = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: e */
    static final Set<EnumC0953a> f21413e = EnumSet.of(EnumC0953a.QR_CODE);

    /* renamed from: f */
    static final Set<EnumC0953a> f21414f = EnumSet.of(EnumC0953a.DATA_MATRIX);

    /* renamed from: g */
    static final Set<EnumC0953a> f21415g = EnumSet.of(EnumC0953a.AZTEC);

    /* renamed from: h */
    static final Set<EnumC0953a> f21416h = EnumSet.of(EnumC0953a.PDF_417);

    /* renamed from: b */
    public static final Set<EnumC0953a> f21410b = EnumSet.of(EnumC0953a.UPC_A, EnumC0953a.UPC_E, EnumC0953a.EAN_13, EnumC0953a.EAN_8, EnumC0953a.RSS_14, EnumC0953a.RSS_EXPANDED);

    /* renamed from: c */
    static final Set<EnumC0953a> f21411c = EnumSet.of(EnumC0953a.CODE_39, EnumC0953a.CODE_93, EnumC0953a.CODE_128, EnumC0953a.ITF, EnumC0953a.CODABAR);

    /* renamed from: d */
    private static final Set<EnumC0953a> f21412d = EnumSet.copyOf((Collection) f21410b);

    static {
        f21412d.addAll(f21411c);
        f21417i = new HashMap();
        f21417i.put(C7346e.c.f25831d, f21412d);
        f21417i.put(C7346e.c.f25830c, f21410b);
        f21417i.put(C7346e.c.f25832e, f21413e);
        f21417i.put(C7346e.c.f25833f, f21414f);
        f21417i.put(C7346e.c.f25834g, f21415g);
        f21417i.put(C7346e.c.f25835h, f21416h);
    }

    private C5932a() {
    }

    /* renamed from: a */
    public static Set<EnumC0953a> m24912a(Intent intent) {
        String stringExtra = intent.getStringExtra(C7346e.c.f25836i);
        return m24914a(stringExtra != null ? Arrays.asList(f21409a.split(stringExtra)) : null, intent.getStringExtra(C7346e.c.f25829b));
    }

    /* renamed from: a */
    public static Set<EnumC0953a> m24913a(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters(C7346e.c.f25836i);
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = Arrays.asList(f21409a.split(queryParameters.get(0)));
        }
        return m24914a(queryParameters, uri.getQueryParameter(C7346e.c.f25829b));
    }

    /* renamed from: a */
    private static Set<EnumC0953a> m24914a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet noneOf = EnumSet.noneOf(EnumC0953a.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    noneOf.add(EnumC0953a.valueOf(it.next()));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f21417i.get(str);
        }
        return null;
    }
}
