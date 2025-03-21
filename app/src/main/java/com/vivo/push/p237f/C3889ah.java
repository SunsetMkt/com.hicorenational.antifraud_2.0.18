package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.AbstractRunnableC3971s;
import p388ui.activity.BaseProgressUploadActivity;

/* compiled from: PushClientTaskFactory.java */
/* renamed from: com.vivo.push.f.ah */
/* loaded from: classes2.dex */
public final class C3889ah {
    /* renamed from: a */
    public static AbstractRunnableC3971s m12962a(AbstractC4016v abstractC4016v) {
        int m13325b = abstractC4016v.m13325b();
        if (m13325b == 20) {
            return new C3888ag(abstractC4016v);
        }
        if (m13325b == 100) {
            return new C3892b(abstractC4016v);
        }
        if (m13325b == 101) {
            return new C3893c(abstractC4016v);
        }
        switch (m13325b) {
            case 0:
                break;
            case 1:
                return new C3883ab(abstractC4016v);
            case 2:
                return new C3902l(abstractC4016v);
            case 3:
                return new C3910t(abstractC4016v);
            case 4:
                return new C3911u(abstractC4016v);
            case 5:
                return new C3914x(abstractC4016v);
            case 6:
                return new C3915y(abstractC4016v);
            case 7:
                return new C3908r(abstractC4016v);
            case 8:
                return new C3906p(abstractC4016v);
            case 9:
                return new C3901k(abstractC4016v);
            case 10:
                return new C3898h(abstractC4016v);
            case 11:
                return new C3886ae(abstractC4016v);
            case 12:
                return new C3900j(abstractC4016v);
            default:
                switch (m13325b) {
                    case 2000:
                    case BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1 /* 2001 */:
                    case BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 /* 2002 */:
                    case 2003:
                    case 2004:
                    case 2005:
                    case 2008:
                    case 2009:
                    case 2010:
                    case 2011:
                    case 2012:
                    case 2013:
                    case 2014:
                    case 2015:
                        break;
                    case 2006:
                        return new C3881a(abstractC4016v);
                    case 2007:
                        return new C3891aj(abstractC4016v);
                    default:
                        return null;
                }
        }
        return new C3890ai(abstractC4016v);
    }

    /* renamed from: b */
    public static AbstractC3882aa m12963b(AbstractC4016v abstractC4016v) {
        int m13325b = abstractC4016v.m13325b();
        if (m13325b == 20) {
            return new C3888ag(abstractC4016v);
        }
        if (m13325b == 2016) {
            return new C3905o(abstractC4016v);
        }
        switch (m13325b) {
            case 1:
                return new C3883ab(abstractC4016v);
            case 2:
                return new C3902l(abstractC4016v);
            case 3:
                return new C3910t(abstractC4016v);
            case 4:
                return new C3911u(abstractC4016v);
            case 5:
                return new C3914x(abstractC4016v);
            case 6:
                return new C3915y(abstractC4016v);
            case 7:
                return new C3908r(abstractC4016v);
            case 8:
                return new C3906p(abstractC4016v);
            case 9:
                return new C3901k(abstractC4016v);
            case 10:
                return new C3898h(abstractC4016v);
            case 11:
                return new C3886ae(abstractC4016v);
            default:
                return null;
        }
    }
}
