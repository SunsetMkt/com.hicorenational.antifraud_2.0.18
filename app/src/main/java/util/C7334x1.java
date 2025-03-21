package util;

import android.app.Activity;
import android.widget.TextView;
import interfaces.PermissionsListener;
import java.util.List;
import network.DownloadInfo;
import util.permissionutil.C7310c;

/* compiled from: UpdateUtil.java */
/* renamed from: util.x1 */
/* loaded from: classes2.dex */
class C7334x1 implements PermissionsListener {

    /* renamed from: a */
    final /* synthetic */ String f25725a;

    /* renamed from: b */
    final /* synthetic */ TextView f25726b;

    /* renamed from: c */
    final /* synthetic */ DownloadInfo f25727c;

    /* renamed from: d */
    final /* synthetic */ UpdateUtil f25728d;

    C7334x1(UpdateUtil updateUtil, String str, TextView textView, DownloadInfo downloadInfo) {
        this.f25728d = updateUtil;
        this.f25725a = str;
        this.f25726b = textView;
        this.f25727c = downloadInfo;
    }

    @Override // interfaces.PermissionsListener
    public void onDenied(List<String> list, boolean z) {
        Activity activity;
        activity = UpdateUtil.mActivity;
        C7310c.m26513a(activity, list, z, false, this);
    }

    @Override // interfaces.PermissionsListener
    public void onGranted() {
        C7301n1.m26454a("hsc", "AppDownlaodUrl=====" + this.f25725a);
        this.f25728d.doUpdateApp(this.f25726b, this.f25727c, this.f25725a);
    }
}
