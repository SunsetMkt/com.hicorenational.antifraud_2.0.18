package i.z2;

import bean.SurveyH5Bean;
import i.g2.b1;
import i.q2.t.j0;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: CharDirectionality.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u00a8\u0006\u001c"}, d2 = {"Lkotlin/text/CharDirectionality;", "", SurveyH5Bean.VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public enum b {
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

    private final int value;
    public static final C0253b Companion = new C0253b(null);

    /* JADX INFO: renamed from: b */
    private static final i.s f12401b = i.v.a(a.INSTANCE);

    /* JADX INFO: compiled from: CharDirectionality.kt */
    static final class a extends j0 implements i.q2.s.a<Map<Integer, ? extends b>> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        @Override // i.q2.s.a
        @j.c.a.d
        public final Map<Integer, ? extends b> invoke() {
            b[] bVarArrValues = b.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i.v2.q.a(b1.b(bVarArrValues.length), 16));
            for (b bVar : bVarArrValues) {
                linkedHashMap.put(Integer.valueOf(bVar.getValue()), bVar);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: i.z2.b$b */
    /* JADX INFO: compiled from: CharDirectionality.kt */
    public static final class C0253b {
        private C0253b() {
        }

        private final Map<Integer, b> a() {
            i.s sVar = b.f12401b;
            C0253b c0253b = b.Companion;
            return (Map) sVar.getValue();
        }

        @j.c.a.d
        public final b a(int i2) {
            b bVar = a().get(Integer.valueOf(i2));
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalArgumentException("Directionality #" + i2 + " is not defined.");
        }

        public /* synthetic */ C0253b(i.q2.t.v vVar) {
            this();
        }
    }

    b(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
