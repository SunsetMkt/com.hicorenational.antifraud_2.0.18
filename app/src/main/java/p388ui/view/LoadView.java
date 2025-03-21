package p388ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class LoadView extends FrameLayout {

    /* renamed from: a */
    private View f24547a;

    /* renamed from: b */
    private View f24548b;

    /* renamed from: c */
    private View f24549c;

    /* renamed from: d */
    private Button f24550d;

    /* renamed from: e */
    private Handler f24551e;

    /* renamed from: f */
    private EnumC7176d f24552f;

    /* renamed from: ui.view.LoadView$a */
    class ViewOnClickListenerC7173a implements View.OnClickListener {
        ViewOnClickListenerC7173a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoadView.this.m25778a();
        }
    }

    /* renamed from: ui.view.LoadView$b */
    class RunnableC7174b implements Runnable {

        /* renamed from: ui.view.LoadView$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadView.this.m25776b();
            }
        }

        RunnableC7174b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object netData = LoadView.this.getNetData();
            LoadView loadView = LoadView.this;
            loadView.f24552f = loadView.m25772a(netData);
            LoadView.this.m25779a((Runnable) new a());
        }
    }

    /* renamed from: ui.view.LoadView$c */
    static /* synthetic */ class C7175c {

        /* renamed from: a */
        static final /* synthetic */ int[] f24556a = new int[EnumC7176d.values().length];

        static {
            try {
                f24556a[EnumC7176d.loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24556a[EnumC7176d.success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24556a[EnumC7176d.error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: ui.view.LoadView$d */
    public enum EnumC7176d {
        loading,
        success,
        error
    }

    public LoadView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m25776b() {
        this.f24547a.setVisibility(8);
        this.f24548b.setVisibility(8);
        this.f24549c.setVisibility(8);
        int i2 = C7175c.f24556a[this.f24552f.ordinal()];
        if (i2 == 1) {
            this.f24547a.setVisibility(0);
        } else if (i2 == 2) {
            this.f24548b.setVisibility(0);
        } else {
            if (i2 != 3) {
                return;
            }
            this.f24549c.setVisibility(0);
        }
    }

    /* renamed from: c */
    private void m25777c() {
        this.f24547a = View.inflate(getContext(), C2113R.layout.page_loading, null);
        this.f24548b = getSuccess();
        this.f24549c = View.inflate(getContext(), C2113R.layout.page_error, null);
        this.f24550d = (Button) this.f24549c.findViewById(C2113R.id.btn_reload);
        this.f24550d.setOnClickListener(new ViewOnClickListenerC7173a());
        addView(this.f24547a);
        addView(this.f24548b);
        addView(this.f24549c);
        m25776b();
        m25778a();
    }

    protected abstract Object getNetData();

    public abstract View getSuccess();

    public LoadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f24551e = new Handler(Looper.getMainLooper());
        this.f24552f = EnumC7176d.loading;
        m25777c();
    }

    /* renamed from: a */
    public void m25779a(Runnable runnable) {
        this.f24551e.post(runnable);
    }

    /* renamed from: a */
    public void m25778a() {
        new Thread(new RunnableC7174b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public EnumC7176d m25772a(Object obj) {
        if (obj == null) {
            return EnumC7176d.error;
        }
        if (obj instanceof List) {
            if (((List) obj).size() > 0) {
                return EnumC7176d.success;
            }
            return EnumC7176d.error;
        }
        return EnumC7176d.success;
    }
}
