package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4354af;
import com.xiaomi.push.service.C4355ag;
import com.xiaomi.push.service.C4402x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.dx */
/* loaded from: classes2.dex */
public abstract class AbstractNotificationBuilderC4176dx extends NotificationBuilderC4174dv {

    /* renamed from: a */
    private int f15048a;

    /* renamed from: a */
    protected Bitmap f15049a;

    /* renamed from: a */
    private RemoteViews f15050a;

    /* renamed from: a */
    protected CharSequence f15051a;

    /* renamed from: a */
    private String f15052a;

    /* renamed from: a */
    private ArrayList<Notification.Action> f15053a;

    /* renamed from: a */
    protected Map<String, String> f15054a;

    /* renamed from: a */
    private boolean f15055a;

    /* renamed from: b */
    private int f15056b;

    /* renamed from: b */
    protected CharSequence f15057b;

    /* renamed from: b */
    private boolean f15058b;

    public AbstractNotificationBuilderC4176dx(Context context, String str) {
        this(context, 0, str);
    }

    /* renamed from: c */
    private boolean m14560c() {
        Map<String, String> map = this.f15054a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    /* renamed from: d */
    private void m14561d() {
        super.setContentTitle(this.f15051a);
        super.setContentText(this.f15057b);
    }

    /* renamed from: e */
    private boolean m14563e() {
        return m14562d() && m14564f();
    }

    /* renamed from: f */
    private boolean m14564f() {
        List<StatusBarNotification> m15897b;
        if (Build.VERSION.SDK_INT >= 20 && (m15897b = C4354af.m15874a(m14548a(), this.f15052a).m15897b()) != null && !m15897b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : m15897b) {
                if (statusBarNotification.getId() == this.f15048a) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC4176dx setContentTitle(CharSequence charSequence) {
        this.f15051a = charSequence;
        return this;
    }

    /* renamed from: a */
    protected abstract String mo14541a();

    /* renamed from: a */
    protected void m14572a(int i2, Notification.Action action) {
    }

    /* renamed from: a */
    protected abstract boolean mo14543a();

    @Override // android.app.Notification.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC4176dx setContentText(CharSequence charSequence) {
        this.f15057b = charSequence;
        return this;
    }

    /* renamed from: b */
    protected abstract String mo14545b();

    public AbstractNotificationBuilderC4176dx(Context context, int i2, String str) {
        super(context);
        this.f15053a = new ArrayList<>();
        this.f15056b = 0;
        this.f15052a = str;
        this.f15048a = i2;
        m14559c();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC4176dx setLargeIcon(Bitmap bitmap) {
        this.f15049a = bitmap;
        return this;
    }

    /* renamed from: b */
    protected final void m14575b() {
        super.setContentTitle(this.f15051a);
        super.setContentText(this.f15057b);
        Bitmap bitmap = this.f15049a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: d */
    private boolean m14562d() {
        return (TextUtils.isEmpty(mo14545b()) || TextUtils.isEmpty(this.f15052a)) ? false : true;
    }

    @Override // com.xiaomi.push.NotificationBuilderC4174dv
    /* renamed from: a */
    public NotificationBuilderC4174dv mo14551a(Map<String, String> map) {
        this.f15054a = map;
        return this;
    }

    /* renamed from: c */
    private void m14559c() {
        int m14546a = m14546a(m14548a().getResources(), m14558c(), "layout", m14548a().getPackageName());
        if (m14546a != 0) {
            this.f15050a = new RemoteViews(m14548a().getPackageName(), m14546a);
            this.f15055a = mo14543a();
        } else {
            AbstractC4022b.m13347a("create RemoteViews failed, no such layout resource was found");
        }
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC4176dx addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i2, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC4176dx addAction(Notification.Action action) {
        if (action != null) {
            this.f15053a.add(action);
        }
        int i2 = this.f15056b;
        this.f15056b = i2 + 1;
        m14572a(i2, action);
        return this;
    }

    /* renamed from: b */
    protected final boolean m14576b() {
        return this.f15055a;
    }

    @Override // com.xiaomi.push.NotificationBuilderC4174dv
    /* renamed from: a */
    protected void mo14542a() {
        super.mo14542a();
        Bundle bundle = new Bundle();
        if (m14562d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f15058b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", m14547a("large_icon"));
        if (this.f15053a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f15053a.size()];
            this.f15053a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (!m14560c() && C4355ag.m15916a(m14548a().getContentResolver())) {
            bundle.putCharSequence("mipush.customTitle", this.f15051a);
            bundle.putCharSequence("mipush.customContent", this.f15057b);
        } else {
            m14561d();
        }
        addExtras(bundle);
    }

    /* renamed from: c */
    private String m14558c() {
        this.f15058b = m14563e();
        return this.f15058b ? mo14545b() : mo14541a();
    }

    /* renamed from: a */
    public final RemoteViews m14567a() {
        return this.f15050a;
    }

    /* renamed from: a */
    protected void m14571a(int i2) {
        Bitmap m14557a = m14557a();
        if (m14557a != null) {
            m14567a().setImageViewBitmap(i2, m14557a);
            return;
        }
        int m14936b = C4233g.m14936b(m14548a(), this.f15052a);
        if (m14936b != 0) {
            m14567a().setImageViewResource(i2, m14936b);
        }
    }

    /* renamed from: a */
    private Bitmap m14557a() {
        return C4402x.m16300a(C4233g.m14927a(m14548a(), this.f15052a));
    }

    /* renamed from: a */
    protected int m14565a(float f2) {
        return (int) ((f2 * m14548a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    protected Bitmap m14566a(Bitmap bitmap, float f2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a */
    protected final boolean m14573a(int i2) {
        return ((((double) Color.red(i2)) * 0.299d) + (((double) Color.green(i2)) * 0.587d)) + (((double) Color.blue(i2)) * 0.114d) < 192.0d;
    }
}
