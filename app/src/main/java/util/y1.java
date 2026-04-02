package util;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.a.e.d;
import c.a.a.e.i;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: compiled from: PickUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class y1 {

    /* JADX INFO: compiled from: PickUtil.java */
    static class a implements d.m {
        final /* synthetic */ TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.m f15112b;

        a(TextView textView, d.m mVar) {
            this.a = textView;
            this.f15112b = mVar;
        }

        @Override // c.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + d.c.a.b.a.a.f10074g + str4 + Constants.COLON_SEPARATOR + str5;
            TextView textView = this.a;
            if (textView != null) {
                textView.setText(str6);
            }
            d.m mVar = this.f15112b;
            if (mVar != null) {
                mVar.a(str, str2, str3, str4, str5);
            }
        }
    }

    /* JADX INFO: compiled from: PickUtil.java */
    static class b implements i.b<String> {
        final /* synthetic */ i.b a;

        b(i.b bVar) {
            this.a = bVar;
        }

        @Override // c.a.a.e.i.b
        public void a(int i2, String str) {
            i.b bVar = this.a;
            if (bVar != null) {
                bVar.a(i2, str);
            }
        }
    }

    /* JADX INFO: compiled from: PickUtil.java */
    static class c implements View.OnClickListener {
        final /* synthetic */ c.a.a.e.i a;

        c(c.a.a.e.i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a();
        }
    }

    /* JADX INFO: compiled from: PickUtil.java */
    static class d implements i.b<String> {
        final /* synthetic */ i.b a;

        d(i.b bVar) {
            this.a = bVar;
        }

        @Override // c.a.a.e.i.b
        public void a(int i2, String str) {
            i.b bVar = this.a;
            if (bVar != null) {
                bVar.a(i2, str);
            }
        }
    }

    /* JADX INFO: compiled from: PickUtil.java */
    static class e implements View.OnClickListener {
        final /* synthetic */ c.a.a.e.i a;

        e(c.a.a.e.i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a();
        }
    }

    public static void a(Activity activity, TextView textView) {
        a(activity, textView, (d.m) null);
    }

    public static void a(Activity activity, TextView textView, d.m mVar) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        c.a.a.e.d dVar = new c.a.a.e.d(activity, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new a(textView, mVar));
        dVar.m();
    }

    public static void a(Activity activity, String[] strArr, i.b bVar) {
        if (strArr == null) {
            return;
        }
        c.a.a.e.i iVar = new c.a.a.e.i(activity, strArr);
        iVar.setOnItemPickListener(new b(bVar));
        TextView textView = new TextView(iVar.d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setTextColor(activity.getResources().getColor(R.color.black_light));
        textView.setOnClickListener(new c(iVar));
        iVar.m();
    }

    public static void a(Activity activity, List<String> list, i.b<String> bVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        c.a.a.e.i iVar = new c.a.a.e.i(activity, list);
        iVar.setOnItemPickListener(new d(bVar));
        TextView textView = new TextView(iVar.d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setTextColor(activity.getResources().getColor(R.color.black_light));
        textView.setOnClickListener(new e(iVar));
        iVar.m();
    }
}
