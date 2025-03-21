package com.vivo.push.sdk.service;

import android.app.Activity;
import com.vivo.push.util.C4010u;

/* loaded from: classes2.dex */
public class LinkProxyActivity extends Activity {
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d0, code lost:
    
        startService(r7);
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "LinkProxyActivity"
            if (r7 != 0) goto L14
            java.lang.String r7 = "enter RequestPermissionsActivity onCreate, intent is null, finish"
            com.vivo.push.util.C4010u.m13309d(r0, r7)
            r6.finish()
            return
        L14:
            r1 = 1
            r2 = 0
            android.view.Window r3 = r6.getWindow()     // Catch: java.lang.Throwable -> L30
            r4 = 8388659(0x800033, float:1.1755015E-38)
            r3.setGravity(r4)     // Catch: java.lang.Throwable -> L30
            android.view.WindowManager$LayoutParams r4 = r3.getAttributes()     // Catch: java.lang.Throwable -> L30
            r4.x = r2     // Catch: java.lang.Throwable -> L30
            r4.y = r2     // Catch: java.lang.Throwable -> L30
            r4.height = r1     // Catch: java.lang.Throwable -> L30
            r4.width = r1     // Catch: java.lang.Throwable -> L30
            r3.setAttributes(r4)     // Catch: java.lang.Throwable -> L30
            goto L36
        L30:
            r3 = move-exception
            java.lang.String r4 = "enter onCreate error "
            com.vivo.push.util.C4010u.m13302b(r0, r4, r3)
        L36:
            java.lang.String r3 = r6.getPackageName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r6.hashCode()
            r4.append(r5)
            java.lang.String r5 = " enter onCreate "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.vivo.push.util.C4010u.m13309d(r0, r4)
            java.lang.String r4 = "com.vivo.abe"
            boolean r3 = r4.equals(r3)
            java.lang.String r4 = "previous_intent"
            if (r3 == 0) goto L94
            if (r7 != 0) goto L68
            java.lang.String r7 = "adapterToService intent is null"
            com.vivo.push.util.C4010u.m13309d(r0, r7)     // Catch: java.lang.Exception -> L8b
            goto Lea
        L68:
            android.os.Bundle r1 = r7.getExtras()     // Catch: java.lang.Exception -> L8b
            if (r1 != 0) goto L75
            java.lang.String r7 = "adapterToService getExtras() is null"
            com.vivo.push.util.C4010u.m13309d(r0, r7)     // Catch: java.lang.Exception -> L8b
            goto Lea
        L75:
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> L8b
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> L8b
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> L8b
            if (r7 != 0) goto L87
            java.lang.String r7 = "adapterToService proxyIntent is null"
            com.vivo.push.util.C4010u.m13309d(r0, r7)     // Catch: java.lang.Exception -> L8b
            goto Lea
        L87:
            com.vivo.push.util.C3990ag.m13211a(r6, r7)     // Catch: java.lang.Exception -> L8b
            goto Lea
        L8b:
            r7 = move-exception
            java.lang.String r1 = r7.toString()
            com.vivo.push.util.C4010u.m13293a(r0, r1, r7)
            goto Lea
        L94:
            android.os.Bundle r3 = r7.getExtras()     // Catch: java.lang.Exception -> Le2
            if (r3 == 0) goto Lea
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> Le2
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> Le2
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> Le2
            if (r7 == 0) goto Lce
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: java.lang.Exception -> Le2
            if (r3 == 0) goto Lce
            r4 = 576(0x240, float:8.07E-43)
            java.util.List r3 = r3.queryIntentServices(r7, r4)     // Catch: java.lang.Exception -> Le2
            if (r3 == 0) goto Lce
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Exception -> Le2
            if (r4 == 0) goto Lbb
            goto Lce
        Lbb:
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> Le2
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch: java.lang.Exception -> Le2
            if (r3 == 0) goto Lce
            android.content.pm.ServiceInfo r4 = r3.serviceInfo     // Catch: java.lang.Exception -> Le2
            if (r4 == 0) goto Lce
            android.content.pm.ServiceInfo r3 = r3.serviceInfo     // Catch: java.lang.Exception -> Le2
            boolean r3 = r3.exported     // Catch: java.lang.Exception -> Le2
            if (r3 == 0) goto Lce
            r2 = 1
        Lce:
            if (r2 == 0) goto Ld4
            r6.startService(r7)     // Catch: java.lang.Exception -> Le2
            goto Lea
        Ld4:
            java.lang.String r7 = "service's exported is "
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Le2
            java.lang.String r7 = r7.concat(r1)     // Catch: java.lang.Exception -> Le2
            com.vivo.push.util.C4010u.m13301b(r0, r7)     // Catch: java.lang.Exception -> Le2
            goto Lea
        Le2:
            r7 = move-exception
            java.lang.String r1 = r7.toString()
            com.vivo.push.util.C4010u.m13293a(r0, r1, r7)
        Lea:
            r6.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.sdk.service.LinkProxyActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C4010u.m13309d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
