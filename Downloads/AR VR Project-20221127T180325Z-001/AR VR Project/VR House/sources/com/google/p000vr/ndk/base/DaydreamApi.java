package com.google.p000vr.ndk.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.p000vr.cardboard.VrParamsProvider;
import com.google.p000vr.cardboard.VrParamsProviderFactory;
import com.google.p000vr.cardboard.VrSettingsProviderContract;
import com.google.p000vr.cardboard.annotations.UsedByReflection;
import com.google.p000vr.sdk.proto.nano.CardboardDevice;
import com.google.p000vr.sdk.proto.nano.Preferences;
import com.google.p000vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.p000vr.vrcore.base.api.VrCoreUtils;
import com.google.p000vr.vrcore.common.api.IDaydreamManager;
import com.google.p000vr.vrcore.common.api.ITransitionCallbacks;
import com.google.p000vr.vrcore.common.api.IVrCoreSdkService;
import com.google.p000vr.vrcore.common.api.SdkServiceConsts;
import java.util.ArrayList;
import java.util.List;

@TargetApi(24)
@UsedByReflection("IAP")
/* renamed from: com.google.vr.ndk.base.DaydreamApi */
public class DaydreamApi implements AutoCloseable {
    private static final String DAYDREAM_CATEGORY = "com.google.intent.category.DAYDREAM";
    private static final String EXTRA_KEY_VR_CONTENT_INTENT = "vrContentIntent";
    private static final int MIN_API_FOR_EXIT_VR2 = 23;
    private static final int MIN_API_FOR_HEADSET_INSERTION = 11;
    private static final int MIN_VRCORE_API_VERSION = 8;
    private static final String TAG = "DaydreamApi";
    private static volatile Boolean bootsToVr = null;
    private boolean closed;
    /* access modifiers changed from: private */
    public final ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IVrCoreSdkService unused = DaydreamApi.this.vrCoreSdkService = IVrCoreSdkService.Stub.asInterface(iBinder);
            try {
                IDaydreamManager unused2 = DaydreamApi.this.daydreamManager = DaydreamApi.this.vrCoreSdkService.getDaydreamManager();
            } catch (RemoteException e) {
                Log.e(DaydreamApi.TAG, "RemoteException in onServiceConnected");
            }
            if (DaydreamApi.this.daydreamManager == null) {
                Log.w(DaydreamApi.TAG, "Daydream service component unavailable.");
            }
            ArrayList access$200 = DaydreamApi.this.queuedRunnables;
            int size = access$200.size();
            int i = 0;
            while (i < size) {
                Object obj = access$200.get(i);
                i++;
                ((Runnable) obj).run();
            }
            DaydreamApi.this.queuedRunnables.clear();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            IVrCoreSdkService unused = DaydreamApi.this.vrCoreSdkService = null;
        }
    };
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public IDaydreamManager daydreamManager;
    /* access modifiers changed from: private */
    public ArrayList<Runnable> queuedRunnables = new ArrayList<>();
    /* access modifiers changed from: private */
    public int vrCoreApiVersion;
    /* access modifiers changed from: private */
    public IVrCoreSdkService vrCoreSdkService;

    @UsedByReflection("IAP")
    public static DaydreamApi create(Context context2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("DaydreamApi must only be used from the main thread.");
        } else if (!DaydreamUtils.isDaydreamPhone(context2)) {
            Log.i(TAG, "Phone is not Daydream-compatible");
            return null;
        } else {
            DaydreamApi daydreamApi = new DaydreamApi(context2);
            if (daydreamApi.init()) {
                return daydreamApi;
            }
            Log.w(TAG, "Failed to initialize DaydreamApi object.");
            return null;
        }
    }

    public static boolean isDaydreamReadyPlatform(Context context2) {
        return DaydreamUtils.isDaydreamPhone(context2);
    }

    public int getCurrentViewerType() {
        checkNotClosed();
        if (!isDaydreamReadyPlatform(this.context)) {
            return 0;
        }
        VrParamsProvider create = VrParamsProviderFactory.create(this.context);
        try {
            CardboardDevice.DeviceParams readDeviceParams = create.readDeviceParams();
            if (readDeviceParams == null) {
                return 0;
            }
            if (DaydreamUtils.isDaydreamViewer(readDeviceParams)) {
                create.close();
                return 1;
            }
            create.close();
            return 0;
        } finally {
            create.close();
        }
    }

    public static CardboardDevice.DeviceParamsList getRecentHeadsets(Context context2) {
        CardboardDevice.DeviceParamsList deviceParamsList;
        VrParamsProvider create = VrParamsProviderFactory.create(context2);
        try {
            deviceParamsList = create.readRecentHeadsets();
        } catch (Exception e) {
            Log.e(TAG, "Error when getting recent headsets", e);
            deviceParamsList = new CardboardDevice.DeviceParamsList();
            deviceParamsList.params = new CardboardDevice.DeviceParams[0];
        } finally {
            create.close();
        }
        return deviceParamsList;
    }

    public static boolean isUserRightHanded(Context context2) {
        VrParamsProvider create = VrParamsProviderFactory.create(context2);
        try {
            Preferences.UserPrefs readUserPrefs = create.readUserPrefs();
            return readUserPrefs == null || readUserPrefs.getControllerHandedness() == 0;
        } finally {
            create.close();
        }
    }

    public static void setUserRightHanded(Context context2, boolean z) {
        int i;
        Preferences.UserPrefs userPrefs = new Preferences.UserPrefs();
        if (z) {
            i = 0;
        } else {
            i = 1;
        }
        userPrefs.setControllerHandedness(i);
        VrParamsProvider create = VrParamsProviderFactory.create(context2);
        try {
            create.updateUserPrefs(userPrefs);
        } finally {
            create.close();
        }
    }

    public static boolean isCaptureEnabled(Context context2) {
        return SdkConfigurationReader.getParams(context2).screenCaptureConfig != null && SdkConfigurationReader.getParams(context2).screenCaptureConfig.allowCasting.booleanValue();
    }

    /* JADX INFO: finally extract failed */
    public static boolean isVrUser(Context context2) {
        VrParamsProvider create = VrParamsProviderFactory.create(context2);
        try {
            if (create.readDeviceParams() == null) {
                create.close();
                return false;
            }
            create.close();
            return true;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public void registerDaydreamIntent(final PendingIntent pendingIntent) {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() {
            public void run() {
                if (DaydreamApi.this.daydreamManager == null) {
                    Log.w(DaydreamApi.TAG, "Can't register/unregister daydream intent: no DaydreamManager.");
                    return;
                }
                try {
                    if (pendingIntent != null) {
                        DaydreamApi.this.daydreamManager.registerDaydreamIntent(pendingIntent);
                    } else {
                        DaydreamApi.this.daydreamManager.unregisterDaydreamIntent();
                    }
                } catch (RemoteException e) {
                    Log.e(DaydreamApi.TAG, "Error when attempting to register/unregister daydream intent: ", e);
                }
            }
        });
    }

    public void unregisterDaydreamIntent() {
        checkNotClosed();
        registerDaydreamIntent((PendingIntent) null);
    }

    public static boolean setDaydreamSetupCompleted(Context context2, boolean z) {
        VrParamsProviderFactory.ContentProviderClientHandle tryToGetContentProviderClientHandle = VrParamsProviderFactory.tryToGetContentProviderClientHandle(context2);
        if (tryToGetContentProviderClientHandle == null) {
            Log.e(TAG, "No ContentProvider available for Daydream setup.");
            return false;
        }
        Uri createUri = VrSettingsProviderContract.createUri(tryToGetContentProviderClientHandle.authority, VrSettingsProviderContract.DAYDREAM_SETUP_COMPLETED);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(VrSettingsProviderContract.SETTING_VALUE_KEY, Boolean.valueOf(z));
            if (tryToGetContentProviderClientHandle.client.update(createUri, contentValues, (String) null, (String[]) null) > 0) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to indicate Daydream setup completion to ContentProvider", e);
            return false;
        } catch (SecurityException e2) {
            Log.e(TAG, "Insufficient permissions to indicate Daydream setup completion to ContentProvider", e2);
            return false;
        }
    }

    public static boolean getDaydreamSetupCompleted(Context context2) {
        return getBooleanSetting(context2, VrSettingsProviderContract.DAYDREAM_SETUP_COMPLETED, false);
    }

    public static boolean isDashboardEnabled(Context context2) {
        return getBooleanSetting(context2, VrSettingsProviderContract.DASHBOARD_ENABLED, false);
    }

    public static boolean bootsToVr(Context context2) {
        if (bootsToVr == null) {
            bootsToVr = Boolean.valueOf(getBooleanSetting(context2, VrSettingsProviderContract.BOOTS_TO_VR, false));
        }
        return bootsToVr.booleanValue();
    }

    public static boolean supports2dInVr(Context context2) {
        Boolean bool = SdkConfigurationReader.getParams(context2).allowVrcoreCompositing;
        return bool != null && bool.booleanValue();
    }

    public static boolean isInVrSession(Context context2) {
        if (!DaydreamUtils.isDaydreamPhone(context2)) {
            return false;
        }
        return getBooleanSetting(context2, VrSettingsProviderContract.IS_IN_VR_SESSION, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean getBooleanSetting(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            r6 = 1
            r7 = 0
            r8 = 0
            com.google.vr.cardboard.VrParamsProviderFactory$ContentProviderClientHandle r0 = com.google.p000vr.cardboard.VrParamsProviderFactory.tryToGetContentProviderClientHandle(r9)
            if (r0 != 0) goto L_0x0025
            java.lang.String r1 = "DaydreamApi"
            java.lang.String r2 = "No ContentProvider available for "
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x001f
            java.lang.String r0 = r2.concat(r0)
        L_0x001b:
            android.util.Log.e(r1, r0)
        L_0x001e:
            return r11
        L_0x001f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            goto L_0x001b
        L_0x0025:
            java.lang.String r1 = r0.authority     // Catch:{ RemoteException -> 0x0054, SecurityException -> 0x0084 }
            android.net.Uri r1 = com.google.p000vr.cardboard.VrSettingsProviderContract.createUri(r1, r10)     // Catch:{ RemoteException -> 0x0054, SecurityException -> 0x0084 }
            android.content.ContentProviderClient r0 = r0.client     // Catch:{ RemoteException -> 0x0054, SecurityException -> 0x0084 }
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ RemoteException -> 0x0054, SecurityException -> 0x0084 }
            if (r1 == 0) goto L_0x004e
            boolean r0 = r1.moveToFirst()     // Catch:{ RemoteException -> 0x00c1, SecurityException -> 0x00be }
            if (r0 == 0) goto L_0x004e
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch:{ RemoteException -> 0x00c1, SecurityException -> 0x00be }
            if (r0 != r6) goto L_0x004c
            r0 = r6
        L_0x0045:
            if (r1 == 0) goto L_0x004a
            r1.close()
        L_0x004a:
            r11 = r0
            goto L_0x001e
        L_0x004c:
            r0 = r7
            goto L_0x0045
        L_0x004e:
            if (r1 == 0) goto L_0x001e
            r1.close()
            goto L_0x001e
        L_0x0054:
            r0 = move-exception
            r1 = r8
        L_0x0056:
            java.lang.String r2 = "DaydreamApi"
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x00bb }
            int r3 = r3.length()     // Catch:{ all -> 0x00bb }
            int r3 = r3 + 42
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r4.<init>(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "Failed to read "
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.StringBuilder r3 = r3.append(r10)     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = " state from ContentProvider"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00bb }
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x00bb }
            if (r1 == 0) goto L_0x001e
            r1.close()
            goto L_0x001e
        L_0x0084:
            r0 = move-exception
        L_0x0085:
            java.lang.String r1 = "DaydreamApi"
            java.lang.String r2 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x00b4 }
            int r2 = r2.length()     // Catch:{ all -> 0x00b4 }
            int r2 = r2 + 60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r3.<init>(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "Insufficient permissions to read "
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = " state from ContentProvider"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b4 }
            android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x00b4 }
            if (r8 == 0) goto L_0x001e
            r8.close()
            goto L_0x001e
        L_0x00b4:
            r0 = move-exception
        L_0x00b5:
            if (r8 == 0) goto L_0x00ba
            r8.close()
        L_0x00ba:
            throw r0
        L_0x00bb:
            r0 = move-exception
            r8 = r1
            goto L_0x00b5
        L_0x00be:
            r0 = move-exception
            r8 = r1
            goto L_0x0085
        L_0x00c1:
            r0 = move-exception
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.DaydreamApi.getBooleanSetting(android.content.Context, java.lang.String, boolean):boolean");
    }

    @UsedByReflection("IAP")
    public void launchInVr(PendingIntent pendingIntent) {
        checkNotClosed();
        launchInVr(pendingIntent, (ComponentName) null);
    }

    private void launchInVr(final PendingIntent pendingIntent, final ComponentName componentName) {
        runWhenServiceConnected(new Runnable() {
            public void run() {
                if (DaydreamApi.this.daydreamManager != null) {
                    try {
                        DaydreamApi.this.daydreamManager.launchInVr(pendingIntent, componentName);
                    } catch (RemoteException e) {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching PendingIntent in VR.", e);
                    }
                } else {
                    Log.w(DaydreamApi.TAG, "Can't launch PendingIntent via DaydreamManager: not available.");
                    try {
                        pendingIntent.send();
                    } catch (Exception e2) {
                        Log.e(DaydreamApi.TAG, "Couldn't launch PendingIntent: ", e2);
                    }
                }
            }
        });
    }

    private void launchTransitionCallbackInVr(final ITransitionCallbacks iTransitionCallbacks) {
        runWhenServiceConnected(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:5:0x0017  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    r1 = 0
                    com.google.vr.ndk.base.DaydreamApi r0 = com.google.p000vr.ndk.base.DaydreamApi.this
                    com.google.vr.vrcore.common.api.IDaydreamManager r0 = r0.daydreamManager
                    if (r0 == 0) goto L_0x002c
                    com.google.vr.ndk.base.DaydreamApi r0 = com.google.p000vr.ndk.base.DaydreamApi.this     // Catch:{ RemoteException -> 0x0024 }
                    com.google.vr.vrcore.common.api.IDaydreamManager r0 = r0.daydreamManager     // Catch:{ RemoteException -> 0x0024 }
                    com.google.vr.vrcore.common.api.ITransitionCallbacks r2 = r2     // Catch:{ RemoteException -> 0x0024 }
                    boolean r0 = r0.launchVrTransition(r2)     // Catch:{ RemoteException -> 0x0024 }
                L_0x0015:
                    if (r0 != 0) goto L_0x0023
                    java.lang.String r0 = "DaydreamApi"
                    java.lang.String r1 = "Can't launch callbacks via DaydreamManager, sending manually"
                    android.util.Log.w(r0, r1)
                    com.google.vr.vrcore.common.api.ITransitionCallbacks r0 = r2     // Catch:{ RemoteException -> 0x002e }
                    r0.onTransitionComplete()     // Catch:{ RemoteException -> 0x002e }
                L_0x0023:
                    return
                L_0x0024:
                    r0 = move-exception
                    java.lang.String r2 = "DaydreamApi"
                    java.lang.String r3 = "RemoteException while launching VR transition: "
                    android.util.Log.e(r2, r3, r0)
                L_0x002c:
                    r0 = r1
                    goto L_0x0015
                L_0x002e:
                    r0 = move-exception
                    goto L_0x0023
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.p000vr.ndk.base.DaydreamApi.C00564.run():void");
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchVrHomescreen() {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() {
            public void run() {
                if (DaydreamApi.this.daydreamManager == null) {
                    Log.e(DaydreamApi.TAG, "Can't launch VR homescreen via DaydreamManager. Giving up trying to leave current VR activity...");
                    return;
                }
                try {
                    if (!DaydreamApi.this.daydreamManager.launchVrHome()) {
                        Log.e(DaydreamApi.TAG, "There is no VR homescreen installed.");
                    }
                } catch (RemoteException e) {
                    String valueOf = String.valueOf(e);
                    Log.e(DaydreamApi.TAG, new StringBuilder(String.valueOf(valueOf).length() + 47).append("RemoteException while launching VR homescreen: ").append(valueOf).toString());
                }
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchInVr(Intent intent) throws ActivityNotFoundException {
        checkNotClosed();
        if (intent == null) {
            throw new IllegalArgumentException("Null argument 'intent' passed to launchInVr");
        }
        checkIntent(intent);
        launchInVr(PendingIntent.getActivity(this.context, 0, intent, 1207959552), intent.getComponent());
    }

    @UsedByReflection("IAP")
    public void launchInVr(ComponentName componentName) throws ActivityNotFoundException {
        checkNotClosed();
        if (componentName == null) {
            throw new IllegalArgumentException("Null argument 'componentName' passed to launchInVr");
        }
        Intent createVrIntent = createVrIntent(componentName);
        checkIntent(createVrIntent);
        launchInVr(PendingIntent.getActivity(this.context, 0, createVrIntent, 1073741824), createVrIntent.getComponent());
    }

    @UsedByReflection("IAP")
    public void launchInVrForResult(final Activity activity, final PendingIntent pendingIntent, final int i) {
        checkNotClosed();
        launchTransitionCallbackInVr(new ITransitionCallbacks.Stub(this) {
            public void onTransitionComplete() {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, (Intent) null, 0, 0, 0);
                        } catch (IntentSender.SendIntentException e) {
                            String valueOf = String.valueOf(e);
                            Log.e(DaydreamApi.TAG, new StringBuilder(String.valueOf(valueOf).length() + 43).append("Exception while starting next VR activity: ").append(valueOf).toString());
                        }
                    }
                });
            }
        });
    }

    @UsedByReflection("IAP")
    public static Intent createVrIntent(ComponentName componentName) {
        Intent intent = new Intent();
        intent.setComponent(componentName);
        return setupVrIntent(intent);
    }

    @UsedByReflection("IAP")
    public static Intent setupVrIntent(Intent intent) {
        intent.addCategory("com.google.intent.category.DAYDREAM");
        intent.addFlags(335609856);
        return intent;
    }

    @UsedByReflection("IAP")
    public void exitFromVr(Activity activity, int i, Intent intent) {
        exitFromVr(activity, i, intent, (String) null);
    }

    public void exitFromVr(Activity activity, int i, Intent intent, final String str) {
        checkNotClosed();
        if (intent == null) {
            intent = new Intent();
        }
        final PendingIntent createPendingResult = activity.createPendingResult(i, intent, 1073741824);
        final C00607 r1 = new Runnable(this) {
            public void run() {
                try {
                    createPendingResult.send(0);
                } catch (Exception e) {
                    String valueOf = String.valueOf(e);
                    Log.e(DaydreamApi.TAG, new StringBuilder(String.valueOf(valueOf).length() + 31).append("Couldn't launch PendingIntent: ").append(valueOf).toString());
                }
            }
        };
        runWhenServiceConnected(new Runnable() {
            public void run() {
                if (DaydreamApi.this.daydreamManager == null) {
                    Log.w(DaydreamApi.TAG, "Failed to exit VR: Daydream service unavailable.");
                    r1.run();
                    return;
                }
                try {
                    if (DaydreamApi.this.vrCoreApiVersion >= 23) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(SdkServiceConsts.EXIT_FROM_VR_KEY_INTENT, createPendingResult);
                        bundle.putString(SdkServiceConsts.EXIT_FROM_VR_KEY_TEXT, str);
                        if (!DaydreamApi.this.daydreamManager.exitFromVr2(bundle)) {
                            Log.w(DaydreamApi.TAG, "Failed to exit VR: Invalid request.");
                            r1.run();
                        }
                    } else if (!DaydreamApi.this.daydreamManager.deprecatedExitFromVr(createPendingResult)) {
                        Log.w(DaydreamApi.TAG, "Failed to exit VR: Invalid request.");
                        r1.run();
                    }
                } catch (RemoteException e) {
                    String valueOf = String.valueOf(e);
                    Log.e(DaydreamApi.TAG, new StringBuilder(String.valueOf(valueOf).length() + 49).append("Failed to exit VR: RemoteException while exiting:").append(valueOf).toString());
                    r1.run();
                }
            }
        });
    }

    public void setInhibitSystemButtons(final ComponentName componentName, final boolean z) {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() {
            public void run() {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(SdkServiceConsts.OPTION_INHIBIT_SYSTEM_BUTTONS, z);
                    if (!DaydreamApi.this.vrCoreSdkService.setClientOptions(componentName, bundle)) {
                        Log.w(DaydreamApi.TAG, "Failed to set client options to inhibit system button.");
                    }
                } catch (RemoteException e) {
                    Log.e(DaydreamApi.TAG, "RemoteException while setting client options.", e);
                }
            }
        });
    }

    public void handleInsertionIntoHeadset(final byte[] bArr) {
        runWhenServiceConnected(new Runnable() {
            public void run() {
                if (DaydreamApi.this.vrCoreApiVersion < 11) {
                    Log.e(DaydreamApi.TAG, new StringBuilder(94).append("Can't handle insertion of phone into headset: VrCore API too old. Need: 11, found: ").append(DaydreamApi.this.vrCoreApiVersion).toString());
                } else if (DaydreamApi.this.daydreamManager == null) {
                    Log.e(DaydreamApi.TAG, "Can't handle insertion of phone into headset: no DaydreamManager.");
                } else {
                    try {
                        DaydreamApi.this.daydreamManager.handleInsertionIntoHeadset(bArr);
                    } catch (SecurityException e) {
                        Log.e(DaydreamApi.TAG, "SecurityException when notifying phone insertion. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", e);
                    } catch (RemoteException e2) {
                        Log.e(DaydreamApi.TAG, "RemoteException while notifying phone insertion.", e2);
                    }
                }
            }
        });
    }

    public void handleRemovalFromHeadset() {
        runWhenServiceConnected(new Runnable() {
            public void run() {
                if (DaydreamApi.this.vrCoreApiVersion < 11) {
                    Log.e(DaydreamApi.TAG, new StringBuilder(92).append("Can't handle removal of phone from headset: VrCore API too old. Need: 11, found: ").append(DaydreamApi.this.vrCoreApiVersion).toString());
                } else if (DaydreamApi.this.daydreamManager == null) {
                    Log.e(DaydreamApi.TAG, "Can't handle removal of phone from headset: no DaydreamManager.");
                } else {
                    try {
                        DaydreamApi.this.daydreamManager.handleRemovalFromHeadset();
                    } catch (SecurityException e) {
                        Log.e(DaydreamApi.TAG, "SecurityException when notifying phone removal. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", e);
                    } catch (RemoteException e2) {
                        Log.e(DaydreamApi.TAG, "RemoteException while notifying phone removal.", e2);
                    }
                }
            }
        });
    }

    public static void setVrContentIntent(Bundle bundle) {
        bundle.putBoolean(EXTRA_KEY_VR_CONTENT_INTENT, true);
    }

    public static boolean hasVrContentIntent(Bundle bundle) {
        return bundle.getBoolean(EXTRA_KEY_VR_CONTENT_INTENT);
    }

    @UsedByReflection("IAP")
    public void close() {
        if (!this.closed) {
            this.closed = true;
            runWhenServiceConnected(new Runnable() {
                public void run() {
                    DaydreamApi.this.context.unbindService(DaydreamApi.this.connection);
                    IVrCoreSdkService unused = DaydreamApi.this.vrCoreSdkService = null;
                }
            });
        }
    }

    protected DaydreamApi(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public boolean init() {
        try {
            this.vrCoreApiVersion = VrCoreUtils.getVrCoreClientApiVersion(this.context);
            if (this.vrCoreApiVersion < 8) {
                Log.e(TAG, new StringBuilder(69).append("VrCore out of date, current version: ").append(this.vrCoreApiVersion).append(", required version: 8").toString());
                return false;
            }
            Intent intent = new Intent(SdkServiceConsts.BIND_INTENT_ACTION);
            intent.setPackage("com.google.vr.vrcore");
            if (this.context.bindService(intent, this.connection, 1)) {
                return true;
            }
            Log.e(TAG, "Unable to bind to VrCoreSdkService");
            return false;
        } catch (VrCoreNotAvailableException e) {
            String valueOf = String.valueOf(e);
            Log.e(TAG, new StringBuilder(String.valueOf(valueOf).length() + 22).append("VrCore not available: ").append(valueOf).toString());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void runWhenServiceConnected(Runnable runnable) {
        if (this.vrCoreSdkService != null) {
            runnable.run();
        } else {
            this.queuedRunnables.add(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public IDaydreamManager getDaydreamManager() {
        return this.daydreamManager;
    }

    private void checkIntent(Intent intent) throws ActivityNotFoundException {
        List<ResolveInfo> queryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            String valueOf = String.valueOf(intent);
            throw new ActivityNotFoundException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("No activity is available to handle intent: ").append(valueOf).toString());
        }
    }

    private void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("DaydreamApi object is closed and can no longer be used.");
        }
    }
}
