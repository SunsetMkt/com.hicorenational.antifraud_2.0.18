package p286h.p323z2;

import bean.SurveyH5Bean;
import java.util.LinkedHashMap;
import java.util.Map;
import p286h.C5629v;
import p286h.InterfaceC5604s;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5248b1;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5586v;
import p286h.p319v2.C5648q;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CharDirectionality.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, m23546d2 = {"Lkotlin/text/CharDirectionality;", "", SurveyH5Bean.VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.z2.b */
/* loaded from: classes2.dex */
public enum EnumC5723b {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);

    public static final b Companion = new b(null);

    /* renamed from: b */
    private static final InterfaceC5604s f20669b;
    private final int value;

    /* compiled from: CharDirectionality.kt */
    /* renamed from: h.z2.b$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5495a<Map<Integer, ? extends EnumC5723b>> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5495a
        @InterfaceC5816d
        public final Map<Integer, ? extends EnumC5723b> invoke() {
            int m19562b;
            int m23050a;
            EnumC5723b[] values = EnumC5723b.values();
            m19562b = C5248b1.m19562b(values.length);
            m23050a = C5648q.m23050a(m19562b, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(m23050a);
            for (EnumC5723b enumC5723b : values) {
                linkedHashMap.put(Integer.valueOf(enumC5723b.getValue()), enumC5723b);
            }
            return linkedHashMap;
        }
    }

    /* compiled from: CharDirectionality.kt */
    /* renamed from: h.z2.b$b */
    public static final class b {
        private b() {
        }

        /* renamed from: a */
        private final Map<Integer, EnumC5723b> m23567a() {
            InterfaceC5604s interfaceC5604s = EnumC5723b.f20669b;
            b bVar = EnumC5723b.Companion;
            return (Map) interfaceC5604s.getValue();
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final EnumC5723b m23568a(int i2) {
            EnumC5723b enumC5723b = m23567a().get(Integer.valueOf(i2));
            if (enumC5723b != null) {
                return enumC5723b;
            }
            throw new IllegalArgumentException("Directionality #" + i2 + " is not defined.");
        }

        public /* synthetic */ b(C5586v c5586v) {
            this();
        }
    }

    static {
        InterfaceC5604s m22990a;
        m22990a = C5629v.m22990a(a.INSTANCE);
        f20669b = m22990a;
    }

    EnumC5723b(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
