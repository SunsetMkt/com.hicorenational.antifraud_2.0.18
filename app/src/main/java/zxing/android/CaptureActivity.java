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
import com.hicorenational.antifraud.R;
import d.b.c.r;
import java.util.Collection;
import java.util.Map;
import zxing.view.ViewfinderView;

/* JADX INFO: loaded from: classes2.dex */
public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f15120k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f15121l = "codedContent";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f15122m = CaptureActivity.class.getSimpleName();
    private n.a.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zxing.android.a f15123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewfinderView f15124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f15126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Collection<d.b.c.a> f15127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<d.b.c.e, ?> f15128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f15129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f15130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageButton f15131j;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CaptureActivity.this.finish();
        }
    }

    private void a(Context context) {
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.msg_camera_framework_bug));
        builder.setPositiveButton(R.string.button_ok, new b(this));
        builder.setOnCancelListener(new b(this));
        builder.show();
    }

    public void a() {
        this.f15124c.a();
    }

    public n.a.d b() {
        return this.a;
    }

    public Handler c() {
        return this.f15123b;
    }

    public ViewfinderView d() {
        return this.f15124c;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(R.layout.capture);
        this.f15125d = false;
        this.f15130i = new c(this);
        this.f15131j = (ImageButton) findViewById(R.id.capture_imageview_back);
        this.f15131j.setOnClickListener(new a());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f15130i.d();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        zxing.android.a aVar = this.f15123b;
        if (aVar != null) {
            aVar.a();
            this.f15123b = null;
        }
        this.f15130i.b();
        this.a.a();
        if (!this.f15125d) {
            ((SurfaceView) findViewById(R.id.preview_view)).getHolder().removeCallback(this);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.a = new n.a.d(getApplication());
        this.f15124c = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.f15124c.setCameraManager(this.a);
        this.f15123b = null;
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.preview_view)).getHolder();
        if (this.f15125d) {
            a(holder);
        } else {
            holder.addCallback(this);
        }
        this.f15130i.c();
        this.f15126e = d.NONE;
        this.f15127f = null;
        this.f15129h = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f15125d) {
            return;
        }
        this.f15125d = true;
        a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f15125d = false;
    }

    public void a(r rVar, Bitmap bitmap, float f2) {
        this.f15130i.a();
        if (rVar != null) {
            a(this);
            Intent intent = getIntent();
            intent.putExtra(f15121l, rVar.e());
            setResult(-1, intent);
            finish();
        }
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            if (this.a.d()) {
                return;
            }
            try {
                this.a.a(surfaceHolder);
                if (this.f15123b == null) {
                    this.f15123b = new zxing.android.a(this, this.f15127f, this.f15128g, this.f15129h, this.a);
                    return;
                }
                return;
            } catch (Exception unused) {
                e();
                return;
            }
        }
        throw new IllegalStateException("No SurfaceHolder provided");
    }
}
