package androidx.camera.view;

import android.os.Build;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;

/* loaded from: classes.dex */
final class SurfaceViewImplementation implements PreviewView.Implementation {
    private static final String TAG = "SurfaceViewPreviewView";
    TransformableSurfaceView mSurfaceView;
    final SurfaceRequestCallback mSurfaceRequestCallback = new SurfaceRequestCallback();
    private Preview.SurfaceProvider mSurfaceProvider = new C04281();

    /* renamed from: androidx.camera.view.SurfaceViewImplementation$1 */
    class C04281 implements Preview.SurfaceProvider {
        C04281() {
        }

        /* renamed from: a */
        public /* synthetic */ void m377a(@NonNull SurfaceRequest surfaceRequest) {
            SurfaceViewImplementation.this.mSurfaceRequestCallback.setSurfaceRequest(surfaceRequest);
        }

        @Override // androidx.camera.core.Preview.SurfaceProvider
        public void onSurfaceRequested(@NonNull final SurfaceRequest surfaceRequest) {
            SurfaceViewImplementation.this.mSurfaceView.post(new Runnable() { // from class: androidx.camera.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceViewImplementation.C04281.this.m377a(surfaceRequest);
                }
            });
        }
    }

    class SurfaceRequestCallback implements SurfaceHolder.Callback {

        @Nullable
        private Size mCurrentSurfaceSize;

        @Nullable
        private SurfaceRequest mSurfaceRequest;

        @Nullable
        private Size mTargetSize;

        SurfaceRequestCallback() {
        }

        /* renamed from: a */
        static /* synthetic */ void m378a(SurfaceRequest.Result result) {
        }

        @UiThread
        private void cancelPreviousRequest() {
            if (this.mSurfaceRequest != null) {
                String str = "Request canceled: " + this.mSurfaceRequest;
                this.mSurfaceRequest.willNotProvideSurface();
                this.mSurfaceRequest = null;
            }
            this.mTargetSize = null;
        }

        @UiThread
        private boolean tryToComplete() {
            Size size;
            Surface surface = SurfaceViewImplementation.this.mSurfaceView.getHolder().getSurface();
            if (this.mSurfaceRequest == null || (size = this.mTargetSize) == null || !size.equals(this.mCurrentSurfaceSize)) {
                return false;
            }
            this.mSurfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(SurfaceViewImplementation.this.mSurfaceView.getContext()), new Consumer() { // from class: androidx.camera.view.c
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    SurfaceViewImplementation.SurfaceRequestCallback.m378a((SurfaceRequest.Result) obj);
                }
            });
            this.mSurfaceRequest = null;
            this.mTargetSize = null;
            return true;
        }

        @UiThread
        void setSurfaceRequest(@NonNull SurfaceRequest surfaceRequest) {
            cancelPreviousRequest();
            this.mSurfaceRequest = surfaceRequest;
            Size resolution = surfaceRequest.getResolution();
            this.mTargetSize = resolution;
            if (tryToComplete() || Build.VERSION.SDK_INT < 21) {
                return;
            }
            SurfaceViewImplementation.this.mSurfaceView.getHolder().setFixedSize(resolution.getWidth(), resolution.getHeight());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            String str = "Surface changed. Size: " + i3 + "x" + i4;
            this.mCurrentSurfaceSize = new Size(i3, i4);
            tryToComplete();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.mCurrentSurfaceSize = null;
            cancelPreviousRequest();
        }
    }

    SurfaceViewImplementation() {
    }

    @Override // androidx.camera.view.PreviewView.Implementation
    @NonNull
    public Preview.SurfaceProvider getSurfaceProvider() {
        return this.mSurfaceProvider;
    }

    @Override // androidx.camera.view.PreviewView.Implementation
    public void init(@NonNull FrameLayout frameLayout) {
        this.mSurfaceView = new TransformableSurfaceView(frameLayout.getContext());
        this.mSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.mSurfaceView);
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceRequestCallback);
    }

    @Override // androidx.camera.view.PreviewView.Implementation
    public void onDisplayChanged() {
    }
}
