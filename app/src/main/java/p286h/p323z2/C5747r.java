package p286h.p323z2;

import p286h.p309q2.InterfaceC5479c;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: StringNumberConversionsJVM.kt */
/* renamed from: h.z2.r */
/* loaded from: classes2.dex */
final class C5747r {

    /* renamed from: a */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final C5744o f20748a;

    /* renamed from: b */
    public static final C5747r f20749b = new C5747r();

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f20748a = new C5744o("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private C5747r() {
    }
}
