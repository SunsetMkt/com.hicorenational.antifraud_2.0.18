package zxing.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import com.hicorenational.antifraud.C2113R;
import java.util.Collection;
import java.util.Map;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p381m.p382a.C5929d;
import zxing.view.ViewfinderView;

/* loaded from: classes2.dex */
public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {

    /* renamed from: k */
    public static final int f25792k = 0;

    /* renamed from: l */
    public static final String f25793l = "codedContent";

    /* renamed from: m */
    private static final String f25794m = CaptureActivity.class.getSimpleName();

    /* renamed from: a */
    private C5929d f25795a;

    /* renamed from: b */
    private HandlerC7342a f25796b;

    /* renamed from: c */
    private ViewfinderView f25797c;

    /* renamed from: d */
    private boolean f25798d;

    /* renamed from: e */
    private EnumC7345d f25799e;

    /* renamed from: f */
    private Collection<EnumC0953a> f25800f;

    /* renamed from: g */
    private Map<EnumC1044e, ?> f25801g;

    /* renamed from: h */
    private String f25802h;

    /* renamed from: i */
    private C7344c f25803i;

    /* renamed from: j */
    private ImageButton f25804j;

    /* renamed from: zxing.android.CaptureActivity$a */
    class ViewOnClickListenerC7341a implements View.OnClickListener {
        ViewOnClickListenerC7341a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CaptureActivity.this.finish();
        }
    }

    /* renamed from: a */
    private void m26816a(Context context) {
    }

    /* renamed from: e */
    private void m26818e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(C2113R.string.app_name));
        builder.setMessage(getString(C2113R.string.msg_camera_framework_bug));
        builder.setPositiveButton(C2113R.string.button_ok, new DialogInterfaceOnClickListenerC7343b(this));
        builder.setOnCancelListener(new DialogInterfaceOnClickListenerC7343b(this));
        builder.show();
    }

    /* renamed from: a */
    public void m26819a() {
        this.f25797c.m26838a();
    }

    /* renamed from: b */
    public C5929d m26821b() {
        return this.f25795a;
    }

    /* renamed from: c */
    public Handler m26822c() {
        return this.f25796b;
    }

    /* renamed from: d */
    public ViewfinderView m26823d() {
        return this.f25797c;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(C2113R.layout.capture);
        this.f25798d = false;
        this.f25803i = new C7344c(this);
        this.f25804j = (ImageButton) findViewById(C2113R.id.capture_imageview_back);
        this.f25804j.setOnClickListener(new ViewOnClickListenerC7341a());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f25803i.m26834d();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        HandlerC7342a handlerC7342a = this.f25796b;
        if (handlerC7342a != null) {
            handlerC7342a.m26824a();
            this.f25796b = null;
        }
        this.f25803i.m26832b();
        this.f25795a.m24899a();
        if (!this.f25798d) {
            ((SurfaceView) findViewById(C2113R.id.preview_view)).getHolder().removeCallback(this);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f25795a = new C5929d(getApplication());
        this.f25797c = (ViewfinderView) findViewById(C2113R.id.viewfinder_view);
        this.f25797c.setCameraManager(this.f25795a);
        this.f25796b = null;
        SurfaceHolder holder = ((SurfaceView) findViewById(C2113R.id.preview_view)).getHolder();
        if (this.f25798d) {
            m26817a(holder);
        } else {
            holder.addCallback(this);
        }
        this.f25803i.m26833c();
        this.f25799e = EnumC7345d.NONE;
        this.f25800f = null;
        this.f25802h = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f25798d) {
            return;
        }
        this.f25798d = true;
        m26817a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f25798d = false;
    }

    /* renamed from: a */
    public void m26820a(C1107r c1107r, Bitmap bitmap, float f2) {
        this.f25803i.m26831a();
        if (c1107r != null) {
            m26816a(this);
            Intent intent = getIntent();
            intent.putExtra(f25793l, c1107r.m1917e());
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: a */
    private void m26817a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            if (this.f25795a.m24906d()) {
                return;
            }
            try {
                this.f25795a.m24903a(surfaceHolder);
                if (this.f25796b == null) {
                    this.f25796b = new HandlerC7342a(this, this.f25800f, this.f25801g, this.f25802h, this.f25795a);
                    return;
                }
                return;
            } catch (Exception unused) {
                m26818e();
                return;
            }
        }
        throw new IllegalStateException("No SurfaceHolder provided");
    }
}
