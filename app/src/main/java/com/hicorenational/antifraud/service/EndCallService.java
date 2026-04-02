package com.hicorenational.antifraud.service;

import android.app.AlertDialog;
import android.app.Service;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import d.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class EndCallService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3995c = "HTC";
    private TelephonyManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f3996b;

    private class b extends PhoneStateListener {

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                EndCallService.this.c();
                Toast.makeText(EndCallService.this.getApplicationContext(), "\u6302\u65ad\u7535\u8bdd", 0).show();
            }
        }

        /* JADX INFO: renamed from: com.hicorenational.antifraud.service.EndCallService$b$b, reason: collision with other inner class name */
        class DialogInterfaceOnClickListenerC0085b implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0085b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                EndCallService endCallService = EndCallService.this;
                endCallService.startService(new Intent(endCallService.getApplicationContext(), (Class<?>) RecorderService.class));
                Toast.makeText(EndCallService.this.getApplicationContext(), "\u5f00\u542f\u7535\u8bdd\u5f55\u97f3", 0).show();
                EndCallService.this.a();
            }
        }

        class c extends ContentObserver {
            final /* synthetic */ ContentResolver a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Uri f3997b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f3998c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(Handler handler, ContentResolver contentResolver, Uri uri, String str) {
                super(handler);
                this.a = contentResolver;
                this.f3997b = uri;
                this.f3998c = str;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                this.a.delete(this.f3997b, "number=?", new String[]{this.f3998c});
                this.a.unregisterContentObserver(this);
            }
        }

        private b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            super.onCallStateChanged(i2, str);
            if (i2 == 1) {
                EndCallService.this.c();
                AlertDialog alertDialogCreate = new AlertDialog.Builder(EndCallService.this.getApplicationContext()).setTitle("title").setMessage("\u8fd9\u662f\u8bc8\u9a97\u7535\u8bdd").setCancelable(false).setPositiveButton("\u5f00\u542f\u7535\u8bdd\u5f55\u97f3", new DialogInterfaceOnClickListenerC0085b()).setNegativeButton("\u6302\u65ad", new a()).create();
                alertDialogCreate.getWindow().setType(2003);
                alertDialogCreate.show();
                Toast.makeText(EndCallService.this.getApplicationContext(), "\u62e6\u622a\u53f7\u7801:" + str, 0).show();
                ContentResolver contentResolver = EndCallService.this.getContentResolver();
                Uri uri = Uri.parse("content://call_log/calls");
                contentResolver.registerContentObserver(uri, true, new c(new Handler(), contentResolver, uri, str));
            }
        }
    }

    public void a() {
        try {
            a.AbstractBinderC0154a.a((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "phone")).i();
        } catch (Exception unused) {
            b();
        }
    }

    public void b() {
    }

    public void c() {
        try {
            a.AbstractBinderC0154a.a((IBinder) EndCallService.class.getClassLoader().loadClass("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "phone")).h();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = (TelephonyManager) getSystemService("phone");
        this.f3996b = new b();
        this.a.listen(this.f3996b, 32);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.a.listen(this.f3996b, 0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 3;
    }
}
