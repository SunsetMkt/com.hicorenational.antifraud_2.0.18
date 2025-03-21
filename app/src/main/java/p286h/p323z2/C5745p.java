package p286h.p323z2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5253d0;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5642k;
import p286h.p319v2.C5648q;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Regex.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, m23546d2 = {"fromInt", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/text/FlagEnum;", "", SurveyH5Bean.VALUE, "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.z2.p */
/* loaded from: classes2.dex */
public final class C5745p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Regex.kt */
    /* renamed from: h.z2.p$a */
    public static final class a<T> extends AbstractC5547j0 implements InterfaceC5506l<T, Boolean> {
        final /* synthetic */ int $value$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(1);
            this.$value$inlined = i2;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((Enum) obj));
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean invoke(Enum r3) {
            InterfaceC5737i interfaceC5737i = (InterfaceC5737i) r3;
            return (this.$value$inlined & interfaceC5737i.getMask()) == interfaceC5737i.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Regex.kt */
    /* renamed from: h.z2.p$b */
    public static final class b<T> extends AbstractC5547j0 implements InterfaceC5506l<T, Boolean> {
        final /* synthetic */ int $value$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(1);
            this.$value$inlined = i2;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((Enum) obj));
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean invoke(Enum r3) {
            InterfaceC5737i interfaceC5737i = (InterfaceC5737i) r3;
            return (this.$value$inlined & interfaceC5737i.getMask()) == interfaceC5737i.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final /* synthetic */ <T extends Enum<T> & InterfaceC5737i> Set<T> m24057b(int i2) {
        C5544i0.m22518a(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet allOf = EnumSet.allOf(Enum.class);
        C5253d0.m19674b((Iterable) allOf, (InterfaceC5506l) new b(i2));
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        C5544i0.m22521a((Object) unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final InterfaceC5742m m24055b(@InterfaceC5816d Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new C5743n(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final InterfaceC5742m m24056b(@InterfaceC5816d Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new C5743n(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final C5642k m24053b(@InterfaceC5816d MatchResult matchResult) {
        C5642k m23151d;
        m23151d = C5648q.m23151d(matchResult.start(), matchResult.end());
        return m23151d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final C5642k m24054b(@InterfaceC5816d MatchResult matchResult, int i2) {
        C5642k m23151d;
        m23151d = C5648q.m23151d(matchResult.start(i2), matchResult.end(i2));
        return m23151d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final int m24052b(@InterfaceC5816d Iterable<? extends InterfaceC5737i> iterable) {
        Iterator<? extends InterfaceC5737i> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 |= it.next().getValue();
        }
        return i2;
    }
}
