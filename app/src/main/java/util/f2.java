package util;

import android.widget.TextView;
import interfaces.PermissionsListener;
import java.util.List;
import network.DownloadInfo;

/* JADX INFO: compiled from: UpdateUtil.java */
/* JADX INFO: loaded from: classes2.dex */
class f2 implements PermissionsListener {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextView f14884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DownloadInfo f14885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ UpdateUtil f14886d;

    f2(UpdateUtil updateUtil, String str, TextView textView, DownloadInfo downloadInfo) {
        this.f14886d = updateUtil;
        this.a = str;
        this.f14884b = textView;
        this.f14885c = downloadInfo;
    }

    @Override // interfaces.PermissionsListener
    public void onDenied(List<String> list, boolean z) {
        util.permissionutil.c.a(UpdateUtil.mActivity, list, z, false, this);
    }

    @Override // interfaces.PermissionsListener
    public void onGranted() {
        s1.a("hsc", "AppDownlaodUrl=====" + this.a);
        this.f14886d.doUpdateApp(this.f14884b, this.f14885c, this.a);
    }
}
