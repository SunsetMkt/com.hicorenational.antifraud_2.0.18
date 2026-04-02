package i.z2;

/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
final class r {

    @i.q2.c
    @j.c.a.d
    public static final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f12439b = new r();

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        a = new o("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private r() {
    }
}
