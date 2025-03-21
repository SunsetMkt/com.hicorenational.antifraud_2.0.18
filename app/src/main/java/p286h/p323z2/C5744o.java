package p286h.p323z2;

import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5253d0;
import p286h.p289g2.C5312x;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5529d0;
import p286h.p309q2.p311t.C5542h1;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p319v2.C5648q;
import p286h.p320w2.InterfaceC5665f;
import p286h.p321x2.C5705s;
import p286h.p321x2.InterfaceC5699m;
import p286h.p323z2.C5745p;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Regex.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002,-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\"J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, m23546d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.z2.o */
/* loaded from: classes2.dex */
public final class C5744o implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends EnumC5746q> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* renamed from: h.z2.o$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public final int m24041a(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final String m24044b(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "literal");
            String quoteReplacement = Matcher.quoteReplacement(str);
            C5544i0.m22521a((Object) quoteReplacement, "Matcher.quoteReplacement(literal)");
            return quoteReplacement;
        }

        @InterfaceC5816d
        /* renamed from: c */
        public final C5744o m24045c(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "literal");
            return new C5744o(str, EnumC5746q.LITERAL);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final String m24043a(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "literal");
            String quote = Pattern.quote(str);
            C5544i0.m22521a((Object) quote, "Pattern.quote(literal)");
            return quote;
        }
    }

    /* compiled from: Regex.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m23546d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", Constants.KEY_FLAGS, "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: h.z2.o$b */
    private static final class b implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;

        @InterfaceC5816d
        private final String pattern;

        /* compiled from: Regex.kt */
        /* renamed from: h.z2.o$b$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(C5586v c5586v) {
                this();
            }
        }

        public b(@InterfaceC5816d String str, int i2) {
            C5544i0.m22546f(str, "pattern");
            this.pattern = str;
            this.flags = i2;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            C5544i0.m22521a((Object) compile, "Pattern.compile(pattern, flags)");
            return new C5744o(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @InterfaceC5816d
        public final String getPattern() {
            return this.pattern;
        }
    }

    /* compiled from: Regex.kt */
    /* renamed from: h.z2.o$c */
    static final class c extends AbstractC5547j0 implements InterfaceC5495a<InterfaceC5742m> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i2) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p286h.p309q2.p310s.InterfaceC5495a
        @InterfaceC5817e
        public final InterfaceC5742m invoke() {
            return C5744o.this.find(this.$input, this.$startIndex);
        }
    }

    /* compiled from: Regex.kt */
    /* renamed from: h.z2.o$d */
    static final /* synthetic */ class d extends C5529d0 implements InterfaceC5506l<InterfaceC5742m, InterfaceC5742m> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        @Override // p286h.p309q2.p311t.AbstractC5564p, p286h.p320w2.InterfaceC5661b
        public final String getName() {
            return "next";
        }

        @Override // p286h.p309q2.p311t.AbstractC5564p
        public final InterfaceC5665f getOwner() {
            return C5542h1.m22496b(InterfaceC5742m.class);
        }

        @Override // p286h.p309q2.p311t.AbstractC5564p
        public final String getSignature() {
            return "next()Lkotlin/text/MatchResult;";
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5817e
        public final InterfaceC5742m invoke(@InterfaceC5816d InterfaceC5742m interfaceC5742m) {
            C5544i0.m22546f(interfaceC5742m, "p1");
            return interfaceC5742m.next();
        }
    }

    @InterfaceC5440n0
    public C5744o(@InterfaceC5816d Pattern pattern) {
        C5544i0.m22546f(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ InterfaceC5742m find$default(C5744o c5744o, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return c5744o.find(charSequence, i2);
    }

    public static /* synthetic */ InterfaceC5699m findAll$default(C5744o c5744o, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return c5744o.findAll(charSequence, i2);
    }

    public static /* synthetic */ List split$default(C5744o c5744o, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return c5744o.split(charSequence, i2);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        C5544i0.m22521a((Object) pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @InterfaceC5817e
    public final InterfaceC5742m find(@InterfaceC5816d CharSequence charSequence, int i2) {
        InterfaceC5742m m24055b;
        C5544i0.m22546f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        C5544i0.m22521a((Object) matcher, "nativePattern.matcher(input)");
        m24055b = C5745p.m24055b(matcher, i2, charSequence);
        return m24055b;
    }

    @InterfaceC5816d
    public final InterfaceC5699m<InterfaceC5742m> findAll(@InterfaceC5816d CharSequence charSequence, int i2) {
        InterfaceC5699m<InterfaceC5742m> m23353a;
        C5544i0.m22546f(charSequence, "input");
        m23353a = C5705s.m23353a((InterfaceC5495a) new c(charSequence, i2), (InterfaceC5506l) d.INSTANCE);
        return m23353a;
    }

    @InterfaceC5816d
    public final Set<EnumC5746q> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(EnumC5746q.class);
        C5253d0.m19674b((Iterable) allOf, (InterfaceC5506l) new C5745p.a(flags));
        Set<EnumC5746q> unmodifiableSet = Collections.unmodifiableSet(allOf);
        C5544i0.m22521a((Object) unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    @InterfaceC5816d
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        C5544i0.m22521a((Object) pattern, "nativePattern.pattern()");
        return pattern;
    }

    @InterfaceC5817e
    public final InterfaceC5742m matchEntire(@InterfaceC5816d CharSequence charSequence) {
        InterfaceC5742m m24056b;
        C5544i0.m22546f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        C5544i0.m22521a((Object) matcher, "nativePattern.matcher(input)");
        m24056b = C5745p.m24056b(matcher, charSequence);
        return m24056b;
    }

    public final boolean matches(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @InterfaceC5816d
    public final String replace(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d String str) {
        C5544i0.m22546f(charSequence, "input");
        C5544i0.m22546f(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        C5544i0.m22521a((Object) replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @InterfaceC5816d
    public final String replaceFirst(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d String str) {
        C5544i0.m22546f(charSequence, "input");
        C5544i0.m22546f(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        C5544i0.m22521a((Object) replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @InterfaceC5816d
    public final List<String> split(@InterfaceC5816d CharSequence charSequence, int i2) {
        C5544i0.m22546f(charSequence, "input");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (!matcher.find() || i2 == 1) {
            return C5312x.m21750a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i2 > 0 ? C5648q.m23101b(i2, 10) : 10);
        int i4 = i2 - 1;
        do {
            arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
            i3 = matcher.end();
            if (i4 >= 0 && arrayList.size() == i4) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    @InterfaceC5816d
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @InterfaceC5816d
    public String toString() {
        String pattern = this.nativePattern.toString();
        C5544i0.m22521a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C5744o(@p324i.p336c.p337a.InterfaceC5816d java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            p286h.p309q2.p311t.C5544i0.m22546f(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            p286h.p309q2.p311t.C5544i0.m22521a(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p286h.p323z2.C5744o.<init>(java.lang.String):void");
    }

    @InterfaceC5816d
    public final String replace(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d InterfaceC5506l<? super InterfaceC5742m, ? extends CharSequence> interfaceC5506l) {
        C5544i0.m22546f(charSequence, "input");
        C5544i0.m22546f(interfaceC5506l, "transform");
        int i2 = 0;
        InterfaceC5742m find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            if (find$default == null) {
                C5544i0.m22545f();
            }
            sb.append(charSequence, i2, find$default.mo24021d().getStart().intValue());
            sb.append(interfaceC5506l.invoke(find$default));
            i2 = find$default.mo24021d().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i2 >= length) {
                break;
            }
        } while (find$default != null);
        if (i2 < length) {
            sb.append(charSequence, i2, length);
        }
        String sb2 = sb.toString();
        C5544i0.m22521a((Object) sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C5744o(@p324i.p336c.p337a.InterfaceC5816d java.lang.String r2, @p324i.p336c.p337a.InterfaceC5816d p286h.p323z2.EnumC5746q r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            p286h.p309q2.p311t.C5544i0.m22546f(r2, r0)
            java.lang.String r0 = "option"
            p286h.p309q2.p311t.C5544i0.m22546f(r3, r0)
            h.z2.o$a r0 = p286h.p323z2.C5744o.Companion
            int r3 = r3.getValue()
            int r3 = p286h.p323z2.C5744o.a.m24042a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            p286h.p309q2.p311t.C5544i0.m22521a(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p286h.p323z2.C5744o.<init>(java.lang.String, h.z2.q):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C5744o(@p324i.p336c.p337a.InterfaceC5816d java.lang.String r2, @p324i.p336c.p337a.InterfaceC5816d java.util.Set<? extends p286h.p323z2.EnumC5746q> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            p286h.p309q2.p311t.C5544i0.m22546f(r2, r0)
            java.lang.String r0 = "options"
            p286h.p309q2.p311t.C5544i0.m22546f(r3, r0)
            h.z2.o$a r0 = p286h.p323z2.C5744o.Companion
            int r3 = p286h.p323z2.C5745p.m24046a(r3)
            int r3 = p286h.p323z2.C5744o.a.m24042a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            p286h.p309q2.p311t.C5544i0.m22521a(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p286h.p323z2.C5744o.<init>(java.lang.String, java.util.Set):void");
    }
}
