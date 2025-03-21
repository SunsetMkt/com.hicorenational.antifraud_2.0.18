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
import p031c.p032a.p033a.p034a.InterfaceC0947a;

/* loaded from: classes.dex */
public class EndCallService extends Service {

    /* renamed from: c */
    private static final String f6325c = "HTC";

    /* renamed from: a */
    private TelephonyManager f6326a;

    /* renamed from: b */
    private C2118b f6327b;

    /* renamed from: com.hicorenational.antifraud.service.EndCallService$b */
    private class C2118b extends PhoneStateListener {

        /* renamed from: com.hicorenational.antifraud.service.EndCallService$b$a */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                EndCallService.this.m5956c();
                Toast.makeText(EndCallService.this.getApplicationContext(), "挂断电话", 0).show();
            }
        }

        /* renamed from: com.hicorenational.antifraud.service.EndCallService$b$b */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                EndCallService endCallService = EndCallService.this;
                endCallService.startService(new Intent(endCallService.getApplicationContext(), (Class<?>) RecorderService.class));
                Toast.makeText(EndCallService.this.getApplicationContext(), "开启电话录音", 0).show();
                EndCallService.this.m5954a();
            }
        }

        /* renamed from: com.hicorenational.antifraud.service.EndCallService$b$c */
        class c extends ContentObserver {

            /* renamed from: a */
            final /* synthetic */ ContentResolver f6331a;

            /* renamed from: b */
            final /* synthetic */ Uri f6332b;

            /* renamed from: c */
            final /* synthetic */ String f6333c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(Handler handler, ContentResolver contentResolver, Uri uri, String str) {
                super(handler);
                this.f6331a = contentResolver;
                this.f6332b = uri;
                this.f6333c = str;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                this.f6331a.delete(this.f6332b, "number=?", new String[]{this.f6333c});
                this.f6331a.unregisterContentObserver(this);
            }
        }

        private C2118b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            super.onCallStateChanged(i2, str);
            if (i2 == 1) {
                EndCallService.this.m5956c();
                AlertDialog create = new AlertDialog.Builder(EndCallService.this.getApplicationContext()).setTitle("title").setMessage("这是诈骗电话").setCancelable(false).setPositiveButton("开启电话录音", new b()).setNegativeButton("挂断", new a()).create();
                create.getWindow().setType(2003);
                create.show();
                Toast.makeText(EndCallService.this.getApplicationContext(), "拦截号码:" + str, 0).show();
                ContentResolver contentResolver = EndCallService.this.getContentResolver();
                Uri parse = Uri.parse("content://call_log/calls");
                contentResolver.registerContentObserver(parse, true, new c(new Handler(), contentResolver, parse, str));
            }
        }
    }

    /* renamed from: a */
    public void m5954a() {
        try {
            InterfaceC0947a.a.m1181a((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "phone")).mo1180i();
        } catch (Exception unused) {
            m5955b();
        }
    }

    /* renamed from: b */
    public void m5955b() {
    }

    /* renamed from: c */
    public void m5956c() {
        try {
            InterfaceC0947a.a.m1181a((IBinder) EndCallService.class.getClassLoader().loadClass("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "phone")).mo1179h();
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
        this.f6326a = (TelephonyManager) getSystemService("phone");
        this.f6327b = new C2118b();
        this.f6326a.listen(this.f6327b, 32);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f6326a.listen(this.f6327b, 0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 3;
    }
}
