package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.a */
public final class C0147a {

    /* renamed from: b */
    private static CameraManager f175b = null;

    /* renamed from: c */
    private static String[] f176c = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Semaphore f177e = new Semaphore(1);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0157d f178a = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CameraDevice f179d;

    /* renamed from: f */
    private HandlerThread f180f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f181g;

    /* renamed from: h */
    private Rect f182h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Range f183i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ImageReader f184j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CaptureRequest.Builder f185k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CameraCaptureSession f186l;

    /* renamed from: m */
    private final CameraDevice.StateCallback f187m = new CameraDevice.StateCallback() {
        public final void onClosed(CameraDevice cameraDevice) {
            C0160g.Log(4, "Camera2: CameraDevice closed.");
            C0147a.f177e.release();
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            CameraDevice unused = C0147a.this.f179d = null;
            C0160g.Log(5, "Camera2: CameraDevice disconnected.");
            C0147a.f177e.release();
        }

        public final void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            CameraDevice unused = C0147a.this.f179d = null;
            C0160g.Log(6, "Camera2: Error opeining CameraDevice " + i);
            C0147a.f177e.release();
        }

        public final void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = C0147a.this.f179d = cameraDevice;
            C0160g.Log(4, "Camera2: CameraDevice opened.");
            C0147a.f177e.release();
        }
    };

    /* renamed from: n */
    private final ImageReader.OnImageAvailableListener f188n = new ImageReader.OnImageAvailableListener() {
        public final void onImageAvailable(ImageReader imageReader) {
            if (C0147a.f177e.tryAcquire()) {
                Image acquireLatestImage = imageReader.acquireLatestImage();
                if (acquireLatestImage != null) {
                    Image.Plane[] planes = acquireLatestImage.getPlanes();
                    if (acquireLatestImage.getFormat() == 35 && planes != null && planes.length == 3) {
                        C0147a.this.f178a.mo1478a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                    } else {
                        C0160g.Log(6, "Camera2: Wrong image format.");
                    }
                    acquireLatestImage.close();
                }
                C0147a.f177e.release();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: o */
    public CameraCaptureSession.CaptureCallback f189o = new CameraCaptureSession.CaptureCallback() {
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        }

        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            C0160g.Log(5, "Camera2: Capture session failed " + captureFailure.getReason());
        }

        public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            C0160g.Log(4, "Camera2: Capture sequence aborted.");
        }

        public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            C0160g.Log(4, "Camera2: Capture sequence completed.");
        }
    };

    protected C0147a(C0157d dVar) {
        this.f178a = dVar;
        m126f();
    }

    /* renamed from: a */
    public static int m109a(Context context) {
        return m121c(context).length;
    }

    /* renamed from: a */
    public static int m110a(Context context, int i) {
        try {
            return ((Integer) m117b(context).getCameraCharacteristics(m121c(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            C0160g.Log(6, "Camera2: CameraAccessException " + e);
            return 0;
        }
    }

    /* renamed from: a */
    private static Rect m111a(Size[] sizeArr, double d, double d2) {
        int i = 0;
        int i2 = 0;
        double d3 = Double.MAX_VALUE;
        for (int i3 = 0; i3 < sizeArr.length; i3++) {
            int width = sizeArr[i3].getWidth();
            int height = sizeArr[i3].getHeight();
            double abs = Math.abs(Math.log(d / ((double) width))) + Math.abs(Math.log(d2 / ((double) height)));
            if (abs < d3) {
                d3 = abs;
                i2 = height;
                i = width;
            }
            C0160g.Log(4, "Camera2: FrameSize " + width + " x " + height + " [" + abs + "]");
        }
        return new Rect(0, 0, i, i2);
    }

    /* renamed from: a */
    private static Range m116a(Range[] rangeArr, double d) {
        double d2 = Double.MAX_VALUE;
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 >= rangeArr.length) {
                return rangeArr[i2];
            }
            int intValue = ((Integer) rangeArr[i3].getLower()).intValue();
            int intValue2 = ((Integer) rangeArr[i3].getUpper()).intValue();
            double abs = Math.abs(Math.log(d / ((double) intValue))) + Math.abs(Math.log(d / ((double) intValue2)));
            if (abs < d2) {
                d2 = abs;
                i2 = i3;
            }
            C0160g.Log(4, "Camera2: Frame rate[" + i3 + "] = " + intValue + "-" + intValue2 + " [" + abs + "]");
            i = i3 + 1;
        }
    }

    /* renamed from: b */
    private static CameraManager m117b(Context context) {
        if (f175b == null) {
            f175b = (CameraManager) context.getSystemService("camera");
        }
        return f175b;
    }

    /* renamed from: b */
    public static boolean m119b(Context context, int i) {
        try {
            return ((Integer) m117b(context).getCameraCharacteristics(m121c(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            C0160g.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* renamed from: c */
    private static String[] m121c(Context context) {
        if (f176c == null) {
            try {
                f176c = m117b(context).getCameraIdList();
            } catch (CameraAccessException e) {
                C0160g.Log(6, "Camera2: CameraAccessException " + e);
                f176c = new String[0];
            }
        }
        return f176c;
    }

    /* renamed from: f */
    private void m126f() {
        this.f180f = new HandlerThread("CameraBackground");
        this.f180f.start();
        this.f181g = new Handler(this.f180f.getLooper());
    }

    /* renamed from: g */
    private void m128g() {
        this.f180f.quit();
        try {
            this.f180f.join(4000);
            this.f180f = null;
            this.f181g = null;
        } catch (InterruptedException e) {
            this.f180f.interrupt();
            C0160g.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e);
        }
    }

    /* renamed from: h */
    private void m130h() {
        try {
            if (!f177e.tryAcquire(4, TimeUnit.SECONDS)) {
                C0160g.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f179d.close();
            try {
                if (!f177e.tryAcquire(4, TimeUnit.SECONDS)) {
                    C0160g.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e) {
                C0160g.Log(6, "Camera2: Interrupted while waiting to close camera " + e);
            }
            f177e.release();
        } catch (InterruptedException e2) {
            C0160g.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e2);
        }
    }

    /* renamed from: a */
    public final Rect mo1638a() {
        return this.f182h;
    }

    /* renamed from: a */
    public final boolean mo1639a(Context context, int i, int i2, int i3, int i4) {
        try {
            CameraCharacteristics cameraCharacteristics = f175b.getCameraCharacteristics(m121c(context)[i]);
            C0160g.Log(4, "Camera2: Hardware level: " + cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL));
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                C0160g.Log(5, "Camera2: only LEGACY hardware level is supported.");
                return false;
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                C0160g.Log(6, "Camera2: configuration map is not available.");
                return false;
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes == null || outputSizes.length == 0) {
                C0160g.Log(6, "Camera2: output sizes for YUV_420_888 format are not avialable.");
                return false;
            }
            this.f182h = m111a(outputSizes, (double) i2, (double) i3);
            Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null || rangeArr.length == 0) {
                C0160g.Log(6, "Camera2: target FPS ranges are not avialable.");
                return false;
            }
            this.f183i = m116a(rangeArr, (double) i4);
            try {
                if (!f177e.tryAcquire(4, TimeUnit.SECONDS)) {
                    C0160g.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                    return false;
                }
                try {
                    f175b.openCamera(m121c(context)[i], this.f187m, this.f181g);
                    try {
                        if (!f177e.tryAcquire(4, TimeUnit.SECONDS)) {
                            C0160g.Log(5, "Camera2: Timeout waiting to open camera.");
                            return false;
                        }
                        f177e.release();
                        return this.f179d != null;
                    } catch (InterruptedException e) {
                        C0160g.Log(6, "Camera2: Interrupted while waiting to open camera " + e);
                    }
                } catch (CameraAccessException e2) {
                    C0160g.Log(6, "Camera2: CameraAccessException " + e2);
                    f177e.release();
                    return false;
                }
            } catch (InterruptedException e3) {
                C0160g.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e3);
                return false;
            }
        } catch (CameraAccessException e4) {
            C0160g.Log(6, "Camera2: CameraAccessException " + e4);
            return false;
        }
    }

    /* renamed from: b */
    public final void mo1640b() {
        C0160g.Log(4, "Camera2: Close.");
        if (this.f179d != null) {
            mo1642d();
            m130h();
            this.f179d = null;
            this.f184j.close();
            this.f184j = null;
        }
        m128g();
    }

    /* renamed from: c */
    public final void mo1641c() {
        C0160g.Log(4, "Camera2: Start preview.");
        if (this.f184j == null) {
            this.f184j = ImageReader.newInstance(this.f182h.width(), this.f182h.height(), 35, 2);
            this.f184j.setOnImageAvailableListener(this.f188n, this.f181g);
        }
        try {
            this.f179d.createCaptureSession(Arrays.asList(new Surface[]{this.f184j.getSurface()}), new CameraCaptureSession.StateCallback() {
                public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    C0160g.Log(6, "Camera2: CaptureSession configuration failed.");
                }

                public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    C0160g.Log(4, "Camera2: CaptureSession is configured.");
                    if (C0147a.this.f179d != null) {
                        CameraCaptureSession unused = C0147a.this.f186l = cameraCaptureSession;
                        try {
                            CaptureRequest.Builder unused2 = C0147a.this.f185k = C0147a.this.f179d.createCaptureRequest(1);
                            C0147a.this.f185k.addTarget(C0147a.this.f184j.getSurface());
                            C0147a.this.f185k.set(CaptureRequest.CONTROL_AF_MODE, 4);
                            C0147a.this.f185k.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, C0147a.this.f183i);
                            C0147a.this.f186l.setRepeatingRequest(C0147a.this.f185k.build(), C0147a.this.f189o, C0147a.this.f181g);
                        } catch (CameraAccessException e) {
                            C0160g.Log(6, "Camera2: CameraAccessException " + e);
                        }
                    }
                }
            }, this.f181g);
        } catch (CameraAccessException e) {
            C0160g.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* renamed from: d */
    public final void mo1642d() {
        C0160g.Log(4, "Camera2: Stop preview.");
        if (this.f186l != null) {
            try {
                this.f186l.abortCaptures();
            } catch (CameraAccessException e) {
                C0160g.Log(6, "Camera2: CameraAccessException " + e);
            }
            this.f186l.close();
            this.f186l = null;
        }
    }
}
