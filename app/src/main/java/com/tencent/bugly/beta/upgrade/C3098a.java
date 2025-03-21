package com.tencent.bugly.beta.upgrade;

import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.utils.C3105e;
import com.tencent.bugly.proguard.C3138aa;
import com.tencent.bugly.proguard.C3145ah;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3173bi;
import com.tencent.bugly.proguard.C3175bk;
import com.tencent.bugly.proguard.C3191p;
import com.tencent.bugly.proguard.C3192q;
import com.tencent.bugly.proguard.C3198w;
import com.tencent.bugly.proguard.C3199x;
import com.tencent.bugly.proguard.C3200y;
import com.tencent.bugly.proguard.InterfaceC3147aj;
import java.util.ArrayList;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.upgrade.a */
/* loaded from: classes2.dex */
public class C3098a implements InterfaceC3147aj {

    /* renamed from: a */
    public final int f9995a;

    /* renamed from: b */
    public final int f9996b;

    /* renamed from: c */
    public final Object[] f9997c;

    /* renamed from: d */
    public boolean f9998d = false;

    public C3098a(int i2, int i3, Object... objArr) {
        this.f9995a = i2;
        this.f9996b = i3;
        this.f9997c = objArr;
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3147aj
    /* renamed from: a */
    public void mo9370a(int i2) {
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3147aj
    /* renamed from: a */
    public synchronized void mo9371a(int i2, C3173bi c3173bi, long j2, long j3, boolean z, String str) {
        C3200y c3200y;
        C3175bk c3175bk;
        C3138aa c3138aa;
        C3138aa c3138aa2;
        try {
            if (!this.f9998d && i2 == this.f9996b) {
                Object[] objArr = new Object[4];
                objArr[0] = z ? "succ" : NotificationCompat.CATEGORY_ERROR;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(j3);
                C3151an.m9915a("upload %s:[%d] [sended %d] [recevied %d]", objArr);
                int i3 = this.f9995a;
                if (i3 == 1) {
                    boolean booleanValue = ((Boolean) this.f9997c[0]).booleanValue();
                    boolean booleanValue2 = ((Boolean) this.f9997c[1]).booleanValue();
                    if (this.f9996b != 804) {
                        return;
                    }
                    C3200y c3200y2 = null;
                    if (!z || c3173bi == null || (c3138aa = (C3138aa) C3145ah.m9853a(c3173bi.f10689c, C3138aa.class)) == null) {
                        c3200y = null;
                        c3175bk = null;
                    } else {
                        c3175bk = c3138aa.f10460a;
                        c3200y = c3138aa.f10461b;
                    }
                    C3100c.f10000a.m9381a(c3175bk);
                    BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) this.f9997c[2];
                    if (c3200y != null) {
                        c3200y2 = c3200y;
                    } else if (betaGrayStrategy != null) {
                        c3200y2 = betaGrayStrategy.f9988a;
                    }
                    if (c3200y2 != null) {
                        int i4 = c3200y2.f10847p;
                        if (i4 == 1) {
                            C3100c.f10000a.m9383a(booleanValue, booleanValue2, z ? 0 : -1, c3200y, str);
                        } else if (i4 != 2) {
                            if (i4 != 3) {
                                C3151an.m9915a("unexpected updatetype", new Object[0]);
                            } else {
                                C3192q.f10776a.m10140a(z ? 0 : -1, c3200y, false);
                                if (C3100c.f10000a.f10005f != null) {
                                    C3105e.m9461a(new RunnableC3081d(18, C3100c.f10000a.f10005f, 1, Boolean.valueOf(booleanValue)));
                                } else if (booleanValue && !booleanValue2) {
                                    C3105e.m9461a(new RunnableC3081d(5, Beta.strToastYourAreTheLatestVersion));
                                }
                            }
                        }
                    } else if (C3100c.f10000a.f10005f != null) {
                        C3105e.m9461a(new RunnableC3081d(18, C3100c.f10000a.f10005f, 1, Boolean.valueOf(booleanValue)));
                    } else if (booleanValue && !booleanValue2) {
                        C3105e.m9461a(new RunnableC3081d(5, Beta.strToastYourAreTheLatestVersion));
                    }
                } else if (i3 == 2) {
                    C3199x c3199x = (C3199x) this.f9997c[0];
                    if (this.f9996b == 803 && c3199x != null && c3199x.m10149a() != null) {
                        if (z) {
                            if (c3173bi != null && (c3138aa2 = (C3138aa) C3145ah.m9853a(c3173bi.f10689c, C3138aa.class)) != null) {
                                C3100c.f10000a.m9381a(c3138aa2.f10460a);
                            }
                            ArrayList<C3198w> m10149a = c3199x.m10149a();
                            if (m10149a.size() > 1) {
                                C3191p.f10775a.m10132b();
                            } else if (m10149a.size() == 1) {
                                C3191p.f10775a.m10126a(m10149a.get(0).f10817b);
                            }
                        }
                    }
                    return;
                }
                this.f9998d = true;
            }
        } catch (Exception e2) {
            if (!C3151an.m9919b(e2)) {
                e2.printStackTrace();
            }
        }
    }
}
