package n.b;

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
import zxing.android.e;

/* JADX INFO: compiled from: DecodeFormatManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<String, Set<d.b.c.a>> f12852i;
    private static final Pattern a = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Set<d.b.c.a> f12848e = EnumSet.of(d.b.c.a.QR_CODE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Set<d.b.c.a> f12849f = EnumSet.of(d.b.c.a.DATA_MATRIX);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Set<d.b.c.a> f12850g = EnumSet.of(d.b.c.a.AZTEC);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final Set<d.b.c.a> f12851h = EnumSet.of(d.b.c.a.PDF_417);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<d.b.c.a> f12845b = EnumSet.of(d.b.c.a.UPC_A, d.b.c.a.UPC_E, d.b.c.a.EAN_13, d.b.c.a.EAN_8, d.b.c.a.RSS_14, d.b.c.a.RSS_EXPANDED);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Set<d.b.c.a> f12846c = EnumSet.of(d.b.c.a.CODE_39, d.b.c.a.CODE_93, d.b.c.a.CODE_128, d.b.c.a.ITF, d.b.c.a.CODABAR);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<d.b.c.a> f12847d = EnumSet.copyOf((Collection) f12845b);

    static {
        f12847d.addAll(f12846c);
        f12852i = new HashMap();
        f12852i.put(e.c.f15147d, f12847d);
        f12852i.put(e.c.f15146c, f12845b);
        f12852i.put(e.c.f15148e, f12848e);
        f12852i.put(e.c.f15149f, f12849f);
        f12852i.put(e.c.f15150g, f12850g);
        f12852i.put(e.c.f15151h, f12851h);
    }

    private a() {
    }

    public static Set<d.b.c.a> a(Intent intent) {
        String stringExtra = intent.getStringExtra(e.c.f15152i);
        return a(stringExtra != null ? Arrays.asList(a.split(stringExtra)) : null, intent.getStringExtra(e.c.f15145b));
    }

    public static Set<d.b.c.a> a(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters(e.c.f15152i);
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = Arrays.asList(a.split(queryParameters.get(0)));
        }
        return a(queryParameters, uri.getQueryParameter(e.c.f15145b));
    }

    private static Set<d.b.c.a> a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(d.b.c.a.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(d.b.c.a.valueOf(it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f12852i.get(str);
        }
        return null;
    }
}
