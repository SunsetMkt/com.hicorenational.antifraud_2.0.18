package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";

    @NonNull
    private final LifecycleOwner mLifecycleOwner;

    @NonNull
    private final LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        @Nullable
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;

        @NonNull
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        LoaderInfo(int i2, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.mId = i2;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            this.mLoader.registerListener(i2, this);
        }

        @MainThread
        Loader<D> destroy(boolean z) {
            if (LoaderManagerImpl.DEBUG) {
                String str = "  Destroying: " + this;
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z) {
                    loaderObserver.reset();
                }
            }
            this.mLoader.unregisterListener(this);
            if ((loaderObserver == null || loaderObserver.hasDeliveredData()) && !z) {
                return this.mLoader;
            }
            this.mLoader.reset();
            return this.mPriorLoader;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            this.mLoader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.mObserver != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                this.mObserver.dump(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(getLoader().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        @NonNull
        Loader<D> getLoader() {
            return this.mLoader;
        }

        boolean isCallbackWaitingForData() {
            LoaderObserver<D> loaderObserver;
            return (!hasActiveObservers() || (loaderObserver = this.mObserver) == null || loaderObserver.hasDeliveredData()) ? false : true;
        }

        void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (lifecycleOwner == null || loaderObserver == null) {
                return;
            }
            super.removeObserver(loaderObserver);
            observe(lifecycleOwner, loaderObserver);
        }

        @Override // androidx.lifecycle.LiveData
        protected void onActive() {
            if (LoaderManagerImpl.DEBUG) {
                String str = "  Starting: " + this;
            }
            this.mLoader.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        protected void onInactive() {
            if (LoaderManagerImpl.DEBUG) {
                String str = "  Stopping: " + this;
            }
            this.mLoader.stopLoading();
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d2) {
            if (LoaderManagerImpl.DEBUG) {
                String str = "onLoadComplete: " + this;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d2);
            } else {
                boolean z = LoaderManagerImpl.DEBUG;
                postValue(d2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@NonNull Observer<? super D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @NonNull
        @MainThread
        Loader<D> setCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.mLoader, loaderCallbacks);
            observe(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.mObserver;
            if (loaderObserver2 != null) {
                removeObserver(loaderObserver2);
            }
            this.mLifecycleOwner = lifecycleOwner;
            this.mObserver = loaderObserver;
            return this.mLoader;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d2) {
            super.setValue(d2);
            Loader<D> loader = this.mPriorLoader;
            if (loader != null) {
                loader.reset();
                this.mPriorLoader = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    static class LoaderObserver<D> implements Observer<D> {

        @NonNull
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData = false;

        @NonNull
        private final Loader<D> mLoader;

        LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.mDeliveredData);
        }

        boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable D d2) {
            if (LoaderManagerImpl.DEBUG) {
                String str = "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(d2);
            }
            this.mCallback.onLoadFinished(this.mLoader, d2);
            this.mDeliveredData = true;
        }

        @MainThread
        void reset() {
            if (this.mDeliveredData) {
                if (LoaderManagerImpl.DEBUG) {
                    String str = "  Resetting: " + this.mLoader;
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public String toString() {
            return this.mCallback.toString();
        }
    }

    static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        private SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<>();
        private boolean mCreatingLoader = false;

        LoaderViewModel() {
        }

        @NonNull
        static LoaderViewModel getInstance(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(LoaderViewModel.class);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.mLoaders.size(); i2++) {
                    LoaderInfo valueAt = this.mLoaders.valueAt(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i2));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        <D> LoaderInfo<D> getLoader(int i2) {
            return this.mLoaders.get(i2);
        }

        boolean hasRunningLoaders() {
            int size = this.mLoaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mLoaders.valueAt(i2).isCallbackWaitingForData()) {
                    return true;
                }
            }
            return false;
        }

        boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        void markForRedelivery() {
            int size = this.mLoaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mLoaders.valueAt(i2).markForRedelivery();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        protected void onCleared() {
            super.onCleared();
            int size = this.mLoaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mLoaders.valueAt(i2).destroy(true);
            }
            this.mLoaders.clear();
        }

        void putLoader(int i2, @NonNull LoaderInfo loaderInfo) {
            this.mLoaders.put(i2, loaderInfo);
        }

        void removeLoader(int i2) {
            this.mLoaders.remove(i2);
        }

        void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = LoaderViewModel.getInstance(viewModelStore);
    }

    @NonNull
    @MainThread
    private <D> Loader<D> createAndInstallLoader(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        try {
            this.mLoaderViewModel.startCreatingLoader();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i2, bundle);
            if (onCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
            }
            LoaderInfo loaderInfo = new LoaderInfo(i2, bundle, onCreateLoader, loader);
            if (DEBUG) {
                String str = "  Created new loader " + loaderInfo;
            }
            this.mLoaderViewModel.putLoader(i2, loaderInfo);
            this.mLoaderViewModel.finishCreatingLoader();
            return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
        } catch (Throwable th) {
            this.mLoaderViewModel.finishCreatingLoader();
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @MainThread
    public void destroyLoader(int i2) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        if (DEBUG) {
            String str = "destroyLoader in " + this + " of " + i2;
        }
        LoaderInfo loader = this.mLoaderViewModel.getLoader(i2);
        if (loader != null) {
            loader.destroy(true);
            this.mLoaderViewModel.removeLoader(i2);
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mLoaderViewModel.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.LoaderManager
    @Nullable
    public <D> Loader<D> getLoader(int i2) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i2);
        if (loader != null) {
            return loader.getLoader();
        }
        return null;
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> initLoader(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i2);
        if (DEBUG) {
            String str = "initLoader in " + this + ": args=" + bundle;
        }
        if (loader == null) {
            return createAndInstallLoader(i2, bundle, loaderCallbacks, null);
        }
        if (DEBUG) {
            String str2 = "  Re-using existing loader " + loader;
        }
        return loader.setCallback(this.mLifecycleOwner, loaderCallbacks);
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> restartLoader(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        if (DEBUG) {
            String str = "restartLoader in " + this + ": args=" + bundle;
        }
        LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i2);
        return createAndInstallLoader(i2, bundle, loaderCallbacks, loader != null ? loader.destroy(false) : null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }
}
