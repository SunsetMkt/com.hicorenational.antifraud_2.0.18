package p031c.p035b.p043c;

import java.util.Map;
import p031c.p035b.p043c.p044a0.C0955b;
import p031c.p035b.p043c.p053d0.C1019b;
import p031c.p035b.p043c.p053d0.C1021d;
import p031c.p035b.p043c.p053d0.C1023f;
import p031c.p035b.p043c.p053d0.C1026i;
import p031c.p035b.p043c.p053d0.C1028k;
import p031c.p035b.p043c.p053d0.C1031n;
import p031c.p035b.p043c.p053d0.C1037t;
import p031c.p035b.p043c.p057e0.C1048d;
import p031c.p035b.p043c.p062f0.C1073b;
import p031c.p035b.p043c.p066x.C1115c;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: MultiFormatWriter.java */
/* renamed from: c.b.c.l */
/* loaded from: classes.dex */
public final class C1101l implements InterfaceC1111v {

    /* compiled from: MultiFormatWriter.java */
    /* renamed from: c.b.c.l$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2203a = new int[EnumC0953a.values().length];

        static {
            try {
                f2203a[EnumC0953a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2203a[EnumC0953a.EAN_13.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2203a[EnumC0953a.UPC_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2203a[EnumC0953a.QR_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2203a[EnumC0953a.CODE_39.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2203a[EnumC0953a.CODE_128.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2203a[EnumC0953a.ITF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2203a[EnumC0953a.PDF_417.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2203a[EnumC0953a.CODABAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2203a[EnumC0953a.DATA_MATRIX.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2203a[EnumC0953a.AZTEC.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1189a(String str, EnumC0953a enumC0953a, int i2, int i3) throws C1112w {
        return mo1190a(str, enumC0953a, i2, i3, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        InterfaceC1111v c1028k;
        switch (a.f2203a[enumC0953a.ordinal()]) {
            case 1:
                c1028k = new C1028k();
                break;
            case 2:
                c1028k = new C1026i();
                break;
            case 3:
                c1028k = new C1037t();
                break;
            case 4:
                c1028k = new C1073b();
                break;
            case 5:
                c1028k = new C1023f();
                break;
            case 6:
                c1028k = new C1021d();
                break;
            case 7:
                c1028k = new C1031n();
                break;
            case 8:
                c1028k = new C1048d();
                break;
            case 9:
                c1028k = new C1019b();
                break;
            case 10:
                c1028k = new C0955b();
                break;
            case 11:
                c1028k = new C1115c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + enumC0953a);
        }
        return c1028k.mo1190a(str, enumC0953a, i2, i3, map);
    }
}
