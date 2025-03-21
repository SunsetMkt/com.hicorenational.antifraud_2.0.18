package util;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.List;
import p023b.p024a.p025a.p027e.C0918d;
import p023b.p024a.p025a.p027e.C0923i;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: PickUtil.java */
/* renamed from: util.s1 */
/* loaded from: classes2.dex */
public class C7319s1 {

    /* compiled from: PickUtil.java */
    /* renamed from: util.s1$a */
    static class a implements C0918d.m {

        /* renamed from: a */
        final /* synthetic */ TextView f25590a;

        /* renamed from: b */
        final /* synthetic */ C0918d.m f25591b;

        a(TextView textView, C0918d.m mVar) {
            this.f25590a = textView;
            this.f25591b = mVar;
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.m
        /* renamed from: a */
        public void mo880a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + AbstractC1191a.f2568g + str4 + Constants.COLON_SEPARATOR + str5;
            TextView textView = this.f25590a;
            if (textView != null) {
                textView.setText(str6);
            }
            C0918d.m mVar = this.f25591b;
            if (mVar != null) {
                mVar.mo880a(str, str2, str3, str4, str5);
            }
        }
    }

    /* compiled from: PickUtil.java */
    /* renamed from: util.s1$b */
    static class b implements C0923i.b<String> {

        /* renamed from: a */
        final /* synthetic */ C0923i.b f25592a;

        b(C0923i.b bVar) {
            this.f25592a = bVar;
        }

        @Override // p023b.p024a.p025a.p027e.C0923i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo970a(int i2, String str) {
            C0923i.b bVar = this.f25592a;
            if (bVar != null) {
                bVar.mo970a(i2, str);
            }
        }
    }

    /* compiled from: PickUtil.java */
    /* renamed from: util.s1$c */
    static class c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C0923i f25593a;

        c(C0923i c0923i) {
            this.f25593a = c0923i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f25593a.m1021a();
        }
    }

    /* compiled from: PickUtil.java */
    /* renamed from: util.s1$d */
    static class d implements C0923i.b<String> {

        /* renamed from: a */
        final /* synthetic */ C0923i.b f25594a;

        d(C0923i.b bVar) {
            this.f25594a = bVar;
        }

        @Override // p023b.p024a.p025a.p027e.C0923i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo970a(int i2, String str) {
            C0923i.b bVar = this.f25594a;
            if (bVar != null) {
                bVar.mo970a(i2, str);
            }
        }
    }

    /* compiled from: PickUtil.java */
    /* renamed from: util.s1$e */
    static class e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C0923i f25595a;

        e(C0923i c0923i) {
            this.f25595a = c0923i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f25595a.m1021a();
        }
    }

    /* renamed from: a */
    public static void m26565a(Activity activity, TextView textView) {
        m26566a(activity, textView, (C0918d.m) null);
    }

    /* renamed from: a */
    public static void m26566a(Activity activity, TextView textView, C0918d.m mVar) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        C0918d c0918d = new C0918d(activity, 0, 3);
        c0918d.mo869g(2018, 2055);
        c0918d.mo860a(i2, i3, i4, i5, i6);
        c0918d.setOnDateTimePickListener(new a(textView, mVar));
        c0918d.m1045m();
    }

    /* renamed from: a */
    public static void m26568a(Activity activity, String[] strArr, C0923i.b bVar) {
        if (strArr == null) {
            return;
        }
        C0923i c0923i = new C0923i(activity, strArr);
        c0923i.setOnItemPickListener(new b(bVar));
        TextView textView = new TextView(c0923i.m1032d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setTextColor(activity.getResources().getColor(C2113R.color.black_light));
        textView.setOnClickListener(new c(c0923i));
        c0923i.m1045m();
    }

    /* renamed from: a */
    public static void m26567a(Activity activity, List<String> list, C0923i.b<String> bVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        C0923i c0923i = new C0923i(activity, list);
        c0923i.setOnItemPickListener(new d(bVar));
        TextView textView = new TextView(c0923i.m1032d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setTextColor(activity.getResources().getColor(C2113R.color.black_light));
        textView.setOnClickListener(new e(c0923i));
        c0923i.m1045m();
    }
}
