package ui.view;

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
import com.hicorenational.antifraud.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LoadView extends FrameLayout {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f14555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f14556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f14557f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoadView.this.a();
        }
    }

    class b implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadView.this.b();
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object netData = LoadView.this.getNetData();
            LoadView loadView = LoadView.this;
            loadView.f14557f = loadView.a(netData);
            LoadView.this.a((Runnable) new a());
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a = new int[d.values().length];

        static {
            try {
                a[d.loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum d {
        loading,
        success,
        error
    }

    public LoadView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.a.setVisibility(8);
        this.f14553b.setVisibility(8);
        this.f14554c.setVisibility(8);
        int i2 = c.a[this.f14557f.ordinal()];
        if (i2 == 1) {
            this.a.setVisibility(0);
        } else if (i2 == 2) {
            this.f14553b.setVisibility(0);
        } else {
            if (i2 != 3) {
                return;
            }
            this.f14554c.setVisibility(0);
        }
    }

    private void c() {
        this.a = View.inflate(getContext(), R.layout.page_loading, null);
        this.f14553b = getSuccess();
        this.f14554c = View.inflate(getContext(), R.layout.page_error, null);
        this.f14555d = (Button) this.f14554c.findViewById(R.id.btn_reload);
        this.f14555d.setOnClickListener(new a());
        addView(this.a);
        addView(this.f14553b);
        addView(this.f14554c);
        b();
        a();
    }

    protected abstract Object getNetData();

    public abstract View getSuccess();

    public LoadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f14556e = new Handler(Looper.getMainLooper());
        this.f14557f = d.loading;
        c();
    }

    public void a(Runnable runnable) {
        this.f14556e.post(runnable);
    }

    public void a() {
        new Thread(new b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d a(Object obj) {
        if (obj == null) {
            return d.error;
        }
        if (obj instanceof List) {
            if (((List) obj).size() > 0) {
                return d.success;
            }
            return d.error;
        }
        return d.success;
    }
}
