package com.tencent.bugly.beta.upgrade;

import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.bi;
import com.tencent.bugly.proguard.bk;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.ArrayList;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a implements aj {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f6076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6077d = false;

    public a(int i2, int i3, Object... objArr) {
        this.a = i2;
        this.f6075b = i3;
        this.f6076c = objArr;
    }

    @Override // com.tencent.bugly.proguard.aj
    public void a(int i2) {
    }

    @Override // com.tencent.bugly.proguard.aj
    public synchronized void a(int i2, bi biVar, long j2, long j3, boolean z, String str) {
        y yVar;
        bk bkVar;
        aa aaVar;
        aa aaVar2;
        try {
            if (!this.f6077d && i2 == this.f6075b) {
                Object[] objArr = new Object[4];
                objArr[0] = z ? "succ" : NotificationCompat.CATEGORY_ERROR;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(j3);
                an.a("upload %s:[%d] [sended %d] [recevied %d]", objArr);
                int i3 = this.a;
                if (i3 == 1) {
                    boolean zBooleanValue = ((Boolean) this.f6076c[0]).booleanValue();
                    boolean zBooleanValue2 = ((Boolean) this.f6076c[1]).booleanValue();
                    if (this.f6075b != 804) {
                        return;
                    }
                    y yVar2 = null;
                    if (!z || biVar == null || (aaVar = (aa) ah.a(biVar.f6481c, aa.class)) == null) {
                        yVar = null;
                        bkVar = null;
                    } else {
                        bkVar = aaVar.a;
                        yVar = aaVar.f6335b;
                    }
                    c.a.a(bkVar);
                    BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) this.f6076c[2];
                    if (yVar != null) {
                        yVar2 = yVar;
                    } else if (betaGrayStrategy != null) {
                        yVar2 = betaGrayStrategy.a;
                    }
                    if (yVar2 != null) {
                        int i4 = yVar2.p;
                        if (i4 == 1) {
                            c.a.a(zBooleanValue, zBooleanValue2, z ? 0 : -1, yVar, str);
                        } else if (i4 != 2) {
                            if (i4 != 3) {
                                an.a("unexpected updatetype", new Object[0]);
                            } else {
                                q.a.a(z ? 0 : -1, yVar, false);
                                if (c.a.f6082f != null) {
                                    e.a(new d(18, c.a.f6082f, 1, Boolean.valueOf(zBooleanValue)));
                                } else if (zBooleanValue && !zBooleanValue2) {
                                    e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
                                }
                            }
                        }
                    } else if (c.a.f6082f != null) {
                        e.a(new d(18, c.a.f6082f, 1, Boolean.valueOf(zBooleanValue)));
                    } else if (zBooleanValue && !zBooleanValue2) {
                        e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
                    }
                } else if (i3 == 2) {
                    x xVar = (x) this.f6076c[0];
                    if (this.f6075b == 803 && xVar != null && xVar.a() != null) {
                        if (z) {
                            if (biVar != null && (aaVar2 = (aa) ah.a(biVar.f6481c, aa.class)) != null) {
                                c.a.a(aaVar2.a);
                            }
                            ArrayList<w> arrayListA = xVar.a();
                            if (arrayListA.size() > 1) {
                                p.a.b();
                            } else if (arrayListA.size() == 1) {
                                p.a.a(arrayListA.get(0).f6586b);
                            }
                        }
                    }
                    return;
                }
                this.f6077d = true;
            }
        } catch (Exception e2) {
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
    }
}
