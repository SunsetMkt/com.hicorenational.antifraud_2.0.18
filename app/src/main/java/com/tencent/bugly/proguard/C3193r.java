package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p205ui.C3094e;
import com.tencent.bugly.beta.p205ui.C3096g;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.Iterator;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.r */
/* loaded from: classes2.dex */
public class C3193r {
    /* renamed from: a */
    public static synchronized void m10142a(Context context) {
        String str;
        File[] listFiles;
        String m9956a;
        synchronized (C3193r.class) {
            final C3082e c3082e = C3082e.f9867G;
            String absolutePath = context.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
            String absolutePath2 = context.getDir("tmpPatch", 32768).getAbsolutePath();
            c3082e.f9876I = new File(absolutePath, TinkerManager.PATCH_NAME);
            if (TextUtils.isEmpty(C3078a.m9337b("PatchFile", ""))) {
                C3078a.m9329a("PatchFile", c3082e.f9876I.getAbsolutePath());
            }
            c3082e.f9877J = new File(absolutePath2, "tmpPatch.apk");
            if (c3082e.f9876I != null && TextUtils.isEmpty(C3078a.m9337b("PatchFile", ""))) {
                C3078a.m9329a("PatchFile", c3082e.f9876I.getAbsolutePath());
            }
            c3082e.f9878K = context.getDir("tmpPatch", 0);
            if (c3082e.f9878K != null && TextUtils.isEmpty(C3078a.m9337b("PatchTmpDir", ""))) {
                C3078a.m9329a("PatchTmpDir", c3082e.f9876I.getAbsolutePath());
            }
            BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C3078a.m9326a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (betaGrayStrategy == null || betaGrayStrategy.f9988a == null || betaGrayStrategy.f9988a.f10847p != 3) {
                if (TinkerManager.getInstance().getPatchDirectory(c3082e.f9919u) != null && !TinkerManager.getInstance().getPatchDirectory(c3082e.f9919u).exists()) {
                    C3078a.m9330a("IS_PATCH_ROLL_BACK", false);
                }
                if (C3078a.m9338b("IS_PATCH_ROLL_BACK", false)) {
                    TinkerManager.getInstance().onPatchRollback(false);
                }
            } else {
                if (betaGrayStrategy.f9988a.f10843l != null) {
                    c3082e.f9882O = betaGrayStrategy.f9988a.f10843l.get("H2");
                }
                c3082e.f9883P = C3078a.m9338b("PatchResult", false);
                c3082e.f9884Q = Integer.valueOf(C3078a.m9337b("PATCH_MAX_TIMES", "0")).intValue();
                if (c3082e.f9883P) {
                    C3151an.m9915a("[patch] inject success", new Object[0]);
                    if (!C3078a.m9338b("UPLOAD_PATCH_RESULT", false)) {
                        C3078a.m9330a("UPLOAD_PATCH_RESULT", true);
                        if (C3191p.f10775a.m10131a(new C3198w("active", System.currentTimeMillis(), (byte) 0, 0L, null, betaGrayStrategy.f9988a.f10844m, betaGrayStrategy.f9988a.f10847p, null))) {
                            C3151an.m9915a("save patch success event success!", new Object[0]);
                        } else {
                            C3151an.m9923e("save patch success event failed!", new Object[0]);
                        }
                    }
                } else {
                    C3151an.m9915a("[patch] inject failure", new Object[0]);
                    if (!C3078a.m9338b("UPLOAD_PATCH_RESULT", false)) {
                        C3078a.m9330a("UPLOAD_PATCH_RESULT", true);
                        if (C3191p.f10775a.m10131a(new C3198w("active", System.currentTimeMillis(), (byte) 1, 0L, null, betaGrayStrategy.f9988a.f10844m, betaGrayStrategy.f9988a.f10847p, null))) {
                            C3151an.m9915a("save patch failed event success!", new Object[0]);
                        } else {
                            C3151an.m9923e("save patch failed event failed!", new Object[0]);
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(TinkerManager.getNewTinkerId())) {
                C3151an.m9922d("[patch] tinker new id is null ,so patch version is invalid", new Object[0]);
                c3082e.f9882O = "";
            }
            C3154aq.m9986b("G15", c3082e.f9882O);
            File file = C3082e.f9867G.f9877J;
            if (file != null && file.exists() && file.delete()) {
                C3151an.m9915a("[patch] delete tmpPatch.apk success", new Object[0]);
            }
            File file2 = C3082e.f9867G.f9876I;
            if (file2 != null && file2.exists() && (m9956a = C3154aq.m9956a(file2, "SHA")) != null) {
                C3082e.f9867G.f9881N = m9956a;
            }
            if (TinkerManager.isTinkerManagerInstalled()) {
                if (TextUtils.isEmpty(c3082e.f9879L)) {
                    c3082e.f9879L = TinkerManager.getTinkerId();
                }
                C3151an.m9915a("TINKER_ID:" + c3082e.f9879L, new Object[0]);
                c3082e.f9880M = TinkerManager.getNewTinkerId();
                C3151an.m9915a("NEW_TINKER_ID:" + c3082e.f9880M, new Object[0]);
                TinkerManager.getInstance().setTinkerListener(new TinkerManager.TinkerListener() { // from class: com.tencent.bugly.proguard.r.1
                    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                    public void onApplyFailure(String str2) {
                        C3082e.this.f9883P = false;
                        C3078a.m9330a("PatchResult", false);
                        C3078a.m9330a("IS_PATCHING", false);
                        C3151an.m9915a("Tinker patch failure, result: " + str2, new Object[0]);
                        BetaPatchListener betaPatchListener = C3082e.this.f9892Y;
                        if (betaPatchListener != null) {
                            betaPatchListener.onApplyFailure(str2);
                        }
                    }

                    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                    public void onApplySuccess(String str2) {
                        C3082e c3082e2 = C3082e.this;
                        c3082e2.f9898ae = false;
                        c3082e2.f9883P = true;
                        C3078a.m9330a("IS_PATCHING", false);
                        C3078a.m9330a("PatchResult", true);
                        C3151an.m9915a("Tinker patch success, result: " + str2, new Object[0]);
                        if (C3082e.this.f9893Z) {
                            C3096g.m9360a(new C3094e(), true);
                        }
                        BetaPatchListener betaPatchListener = C3082e.this.f9892Y;
                        if (betaPatchListener != null) {
                            betaPatchListener.onApplySuccess(str2);
                        }
                    }

                    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                    public void onDownloadFailure(String str2) {
                        BetaPatchListener betaPatchListener = C3082e.this.f9892Y;
                        if (betaPatchListener != null) {
                            betaPatchListener.onDownloadFailure(str2);
                        }
                    }

                    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                    public void onDownloadSuccess(String str2) {
                        BetaPatchListener betaPatchListener = C3082e.this.f9892Y;
                        if (betaPatchListener != null) {
                            betaPatchListener.onDownloadSuccess(str2);
                        }
                    }

                    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                    public void onPatchRollback() {
                        C3151an.m9915a("patch rollback callback.", new Object[0]);
                        BetaPatchListener betaPatchListener = C3082e.this.f9892Y;
                        if (betaPatchListener != null) {
                            betaPatchListener.onPatchRollback();
                        }
                        if (TinkerManager.getInstance().getPatchDirectory(C3082e.this.f9919u) == null || TinkerManager.getInstance().getPatchDirectory(C3082e.this.f9919u).exists()) {
                            return;
                        }
                        C3078a.m9330a("IS_PATCH_ROLL_BACK", false);
                    }

                    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
                    public void onPatchStart() {
                        C3082e.this.f9898ae = true;
                        C3078a.m9330a("IS_PATCHING", true);
                    }
                });
            }
            if (TextUtils.isEmpty(C3078a.m9337b("BaseArchName", "")) && (str = c3082e.f9919u.getApplicationInfo().nativeLibraryDir) != null && (listFiles = new File(str).listFiles()) != null && listFiles.length > 0) {
                boolean z = false;
                for (File file3 : listFiles) {
                    if (file3.getName().endsWith(".so")) {
                        String replace = file3.getName().replace(".so", "");
                        if (replace.startsWith("lib")) {
                            replace = replace.substring(replace.indexOf("lib") + 3);
                        }
                        C3151an.m9915a("libName:" + replace, new Object[0]);
                        String absolutePath3 = file3.getAbsolutePath();
                        C3151an.m9915a("soFilePath:" + absolutePath3, new Object[0]);
                        Iterator<String> it = c3082e.f9896ac.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (replace.equals(it.next())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (!z) {
                            String m9336b = C3078a.m9336b(absolutePath3);
                            C3151an.m9915a("archName:" + m9336b, new Object[0]);
                            if (m9336b != null && m9336b.equals("armeabi-v5te")) {
                                m9336b = "armeabi";
                            }
                            C3078a.m9329a(replace, m9336b);
                            if (TextUtils.isEmpty(C3078a.m9337b("BaseArchName", ""))) {
                                C3078a.m9329a("BaseArchName", m9336b);
                            }
                            z = false;
                        }
                    }
                }
            }
        }
    }
}
