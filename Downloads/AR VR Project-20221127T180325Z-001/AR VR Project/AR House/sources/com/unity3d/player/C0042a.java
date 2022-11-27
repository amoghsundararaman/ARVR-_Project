package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.a */
public final class C0042a {

    /* renamed from: b */
    private static CameraManager f151b;

    /* renamed from: c */
    private static String[] f152c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Semaphore f153e = new Semaphore(1);

    /* renamed from: A */
    private CameraCaptureSession.CaptureCallback f154A = new CameraCaptureSession.CaptureCallback() {
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            C0042a.this.m113a(captureRequest.getTag());
        }

        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            C0057g.Log(5, "Camera2: Capture session failed " + captureRequest.getTag() + " reason " + captureFailure.getReason());
            C0042a.this.m113a(captureRequest.getTag());
        }

        public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        }

        public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
        }
    };

    /* renamed from: B */
    private final CameraDevice.StateCallback f155B = new CameraDevice.StateCallback() {
        public final void onClosed(CameraDevice cameraDevice) {
            C0042a.f153e.release();
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            C0057g.Log(5, "Camera2: CameraDevice disconnected.");
            C0042a.this.m111a(cameraDevice);
            C0042a.f153e.release();
        }

        public final void onError(CameraDevice cameraDevice, int i) {
            C0057g.Log(6, "Camera2: Error opeining CameraDevice " + i);
            C0042a.this.m111a(cameraDevice);
            C0042a.f153e.release();
        }

        public final void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = C0042a.this.f159d = cameraDevice;
            C0042a.f153e.release();
        }
    };

    /* renamed from: C */
    private final ImageReader.OnImageAvailableListener f156C = new ImageReader.OnImageAvailableListener() {
        public final void onImageAvailable(ImageReader imageReader) {
            if (C0042a.f153e.tryAcquire()) {
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    Image.Plane[] planes = acquireNextImage.getPlanes();
                    if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                        C0054d h = C0042a.this.f158a;
                        ByteBuffer buffer = planes[0].getBuffer();
                        ByteBuffer buffer2 = planes[1].getBuffer();
                        ByteBuffer buffer3 = planes[2].getBuffer();
                        h.mo6a(buffer, buffer2, buffer3, planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                    } else {
                        C0057g.Log(6, "Camera2: Wrong image format.");
                    }
                    if (C0042a.this.f173s != null) {
                        C0042a.this.f173s.close();
                    }
                    Image unused = C0042a.this.f173s = acquireNextImage;
                }
                C0042a.f153e.release();
            }
        }
    };

    /* renamed from: D */
    private final SurfaceTexture.OnFrameAvailableListener f157D = new SurfaceTexture.OnFrameAvailableListener() {
        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            C0042a.this.f158a.mo5a(surfaceTexture);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0054d f158a = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CameraDevice f159d;

    /* renamed from: f */
    private HandlerThread f160f;

    /* renamed from: g */
    private Handler f161g;

    /* renamed from: h */
    private Rect f162h;

    /* renamed from: i */
    private Rect f163i;

    /* renamed from: j */
    private int f164j;

    /* renamed from: k */
    private int f165k;

    /* renamed from: l */
    private float f166l = -1.0f;

    /* renamed from: m */
    private float f167m = -1.0f;

    /* renamed from: n */
    private int f168n;

    /* renamed from: o */
    private int f169o;

    /* renamed from: p */
    private boolean f170p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Range f171q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ImageReader f172r = null;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Image f173s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public CaptureRequest.Builder f174t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public CameraCaptureSession f175u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Object f176v = new Object();

    /* renamed from: w */
    private int f177w;

    /* renamed from: x */
    private SurfaceTexture f178x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public Surface f179y = null;

    /* renamed from: z */
    private int f180z = C0048a.f188c;

    /* renamed from: com.unity3d.player.a$a */
    private enum C0048a {
        ;

        static {
            f189d = new int[]{f186a, f187b, f188c};
        }
    }

    protected C0042a(C0054d dVar) {
        this.f158a = dVar;
        m128g();
    }

    /* renamed from: a */
    public static int m102a(Context context) {
        return m122c(context).length;
    }

    /* renamed from: a */
    public static int m103a(Context context, int i) {
        try {
            return ((Integer) m115b(context).getCameraCharacteristics(m122c(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e);
            return 0;
        }
    }

    /* renamed from: a */
    private static int m104a(Range[] rangeArr, int i) {
        int i2 = -1;
        double d = Double.MAX_VALUE;
        for (int i3 = 0; i3 < rangeArr.length; i3++) {
            int intValue = ((Integer) rangeArr[i3].getLower()).intValue();
            int intValue2 = ((Integer) rangeArr[i3].getUpper()).intValue();
            float f = (float) i;
            if (f + 0.1f > ((float) intValue) && f - 0.1f < ((float) intValue2)) {
                return i;
            }
            double min = (double) ((float) Math.min(Math.abs(i - intValue), Math.abs(i - intValue2)));
            if (min < d) {
                i2 = i3;
                d = min;
            }
        }
        return ((Integer) (i > ((Integer) rangeArr[i2].getUpper()).intValue() ? rangeArr[i2].getUpper() : rangeArr[i2].getLower())).intValue();
    }

    /* renamed from: a */
    private static Rect m105a(Size[] sizeArr, double d, double d2) {
        Size[] sizeArr2 = sizeArr;
        int i = 0;
        double d3 = Double.MAX_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < sizeArr2.length; i3++) {
            int width = sizeArr2[i3].getWidth();
            int height = sizeArr2[i3].getHeight();
            double abs = Math.abs(Math.log(d / ((double) width))) + Math.abs(Math.log(d2 / ((double) height)));
            if (abs < d3) {
                i2 = width;
                i = height;
                d3 = abs;
            }
        }
        return new Rect(0, 0, i2, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m111a(CameraDevice cameraDevice) {
        synchronized (this.f176v) {
            this.f175u = null;
        }
        cameraDevice.close();
        this.f159d = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m113a(Object obj) {
        if (obj == "Focus") {
            this.f170p = false;
            synchronized (this.f176v) {
                if (this.f175u != null) {
                    try {
                        this.f174t.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                        this.f174t.setTag("Regular");
                        this.f175u.setRepeatingRequest(this.f174t.build(), this.f154A, this.f161g);
                    } catch (CameraAccessException e) {
                        C0057g.Log(6, "Camera2: CameraAccessException " + e);
                    }
                }
            }
        } else if (obj == "Cancel focus") {
            synchronized (this.f176v) {
                if (this.f175u != null) {
                    m134j();
                }
            }
        }
    }

    /* renamed from: a */
    private static Size[] m114a(CameraCharacteristics cameraCharacteristics) {
        String str;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            str = "Camera2: configuration map is not available.";
        } else {
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes != null && outputSizes.length != 0) {
                return outputSizes;
            }
            str = "Camera2: output sizes for YUV_420_888 format are not avialable.";
        }
        C0057g.Log(6, str);
        return null;
    }

    /* renamed from: b */
    private static CameraManager m115b(Context context) {
        if (f151b == null) {
            f151b = (CameraManager) context.getSystemService("camera");
        }
        return f151b;
    }

    /* renamed from: b */
    private void m117b(CameraCharacteristics cameraCharacteristics) {
        this.f165k = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
        if (this.f165k > 0) {
            this.f163i = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            float width = ((float) this.f163i.width()) / ((float) this.f163i.height());
            float width2 = ((float) this.f162h.width()) / ((float) this.f162h.height());
            if (width2 > width) {
                this.f168n = 0;
                this.f169o = (int) ((((float) this.f163i.height()) - (((float) this.f163i.width()) / width2)) / 2.0f);
            } else {
                this.f169o = 0;
                this.f168n = (int) ((((float) this.f163i.width()) - (((float) this.f163i.height()) * width2)) / 2.0f);
            }
            this.f164j = Math.min(this.f163i.width(), this.f163i.height()) / 20;
        }
    }

    /* renamed from: b */
    public static boolean m119b(Context context, int i) {
        try {
            return ((Integer) m115b(context).getCameraCharacteristics(m122c(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m121c(Context context, int i) {
        try {
            return ((Integer) m115b(context).getCameraCharacteristics(m122c(context)[i]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* renamed from: c */
    private static String[] m122c(Context context) {
        if (f152c == null) {
            try {
                f152c = m115b(context).getCameraIdList();
            } catch (CameraAccessException e) {
                C0057g.Log(6, "Camera2: CameraAccessException " + e);
                f152c = new String[0];
            }
        }
        return f152c;
    }

    /* renamed from: d */
    public static int[] m124d(Context context, int i) {
        try {
            Size[] a = m114a(m115b(context).getCameraCharacteristics(m122c(context)[i]));
            if (a == null) {
                return null;
            }
            int[] iArr = new int[(a.length * 2)];
            for (int i2 = 0; i2 < a.length; i2++) {
                int i3 = i2 * 2;
                iArr[i3] = a[i2].getWidth();
                iArr[i3 + 1] = a[i2].getHeight();
            }
            return iArr;
        } catch (CameraAccessException e) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e);
            return null;
        }
    }

    /* renamed from: g */
    private void m128g() {
        this.f160f = new HandlerThread("CameraBackground");
        this.f160f.start();
        this.f161g = new Handler(this.f160f.getLooper());
    }

    /* renamed from: h */
    private void m131h() {
        this.f160f.quit();
        try {
            this.f160f.join(4000);
            this.f160f = null;
            this.f161g = null;
        } catch (InterruptedException e) {
            this.f160f.interrupt();
            C0057g.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e);
        }
    }

    /* renamed from: i */
    private void m133i() {
        try {
            if (!f153e.tryAcquire(4, TimeUnit.SECONDS)) {
                C0057g.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f159d.close();
            try {
                if (!f153e.tryAcquire(4, TimeUnit.SECONDS)) {
                    C0057g.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e) {
                C0057g.Log(6, "Camera2: Interrupted while waiting to close camera " + e);
            }
            this.f159d = null;
            f153e.release();
        } catch (InterruptedException e2) {
            C0057g.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m134j() {
        try {
            if (this.f165k != 0 && this.f166l >= 0.0f && this.f166l <= 1.0f && this.f167m >= 0.0f) {
                if (this.f167m <= 1.0f) {
                    this.f170p = true;
                    int max = Math.max(this.f164j + 1, Math.min((int) ((((float) (this.f163i.width() - (this.f168n * 2))) * this.f166l) + ((float) this.f168n)), (this.f163i.width() - this.f164j) - 1));
                    int max2 = Math.max(this.f164j + 1, Math.min((int) ((((double) (this.f163i.height() - (this.f169o * 2))) * (1.0d - ((double) this.f167m))) + ((double) this.f169o)), (this.f163i.height() - this.f164j) - 1));
                    this.f174t.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(max - this.f164j, max2 - this.f164j, this.f164j * 2, this.f164j * 2, 999)});
                    this.f174t.set(CaptureRequest.CONTROL_AF_MODE, 1);
                    this.f174t.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                    this.f174t.setTag("Focus");
                    this.f175u.capture(this.f174t.build(), this.f154A, this.f161g);
                    return;
                }
            }
            this.f174t.set(CaptureRequest.CONTROL_AF_MODE, 4);
            this.f174t.setTag("Regular");
            if (this.f175u != null) {
                this.f175u.setRepeatingRequest(this.f174t.build(), this.f154A, this.f161g);
            }
        } catch (CameraAccessException e) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* renamed from: k */
    private void m135k() {
        try {
            if (this.f175u != null) {
                this.f175u.stopRepeating();
                this.f174t.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.f174t.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.f174t.setTag("Cancel focus");
                this.f175u.capture(this.f174t.build(), this.f154A, this.f161g);
            }
        } catch (CameraAccessException e) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* renamed from: a */
    public final Rect mo169a() {
        return this.f162h;
    }

    /* renamed from: a */
    public final boolean mo170a(float f, float f2) {
        if (this.f165k <= 0) {
            return false;
        }
        if (!this.f170p) {
            this.f166l = f;
            this.f167m = f2;
            synchronized (this.f176v) {
                if (!(this.f175u == null || this.f180z == C0048a.f187b)) {
                    m135k();
                }
            }
            return true;
        }
        C0057g.Log(5, "Camera2: Setting manual focus point already started.");
        return false;
    }

    /* renamed from: a */
    public final boolean mo171a(Context context, int i, int i2, int i3, int i4, int i5) {
        try {
            CameraCharacteristics cameraCharacteristics = f151b.getCameraCharacteristics(m122c(context)[i]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                C0057g.Log(5, "Camera2: only LEGACY hardware level is supported.");
                return false;
            }
            Size[] a = m114a(cameraCharacteristics);
            if (!(a == null || a.length == 0)) {
                this.f162h = m105a(a, (double) i2, (double) i3);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr == null || rangeArr.length == 0) {
                    C0057g.Log(6, "Camera2: target FPS ranges are not avialable.");
                } else {
                    int a2 = m104a(rangeArr, i4);
                    this.f171q = new Range(Integer.valueOf(a2), Integer.valueOf(a2));
                    try {
                        if (!f153e.tryAcquire(4, TimeUnit.SECONDS)) {
                            C0057g.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                            return false;
                        }
                        try {
                            f151b.openCamera(m122c(context)[i], this.f155B, this.f161g);
                            try {
                                if (!f153e.tryAcquire(4, TimeUnit.SECONDS)) {
                                    C0057g.Log(5, "Camera2: Timeout waiting to open camera.");
                                    return false;
                                }
                                f153e.release();
                                this.f177w = i5;
                                m117b(cameraCharacteristics);
                                return this.f159d != null;
                            } catch (InterruptedException e) {
                                C0057g.Log(6, "Camera2: Interrupted while waiting to open camera " + e);
                            }
                        } catch (CameraAccessException e2) {
                            C0057g.Log(6, "Camera2: CameraAccessException " + e2);
                            f153e.release();
                            return false;
                        }
                    } catch (InterruptedException e3) {
                        C0057g.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e3);
                        return false;
                    }
                }
            }
            return false;
        } catch (CameraAccessException e4) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e4);
            return false;
        }
    }

    /* renamed from: b */
    public final void mo172b() {
        if (this.f159d != null) {
            mo175e();
            m133i();
            this.f154A = null;
            this.f179y = null;
            this.f178x = null;
            Image image = this.f173s;
            if (image != null) {
                image.close();
                this.f173s = null;
            }
            ImageReader imageReader = this.f172r;
            if (imageReader != null) {
                imageReader.close();
                this.f172r = null;
            }
        }
        m131h();
    }

    /* renamed from: c */
    public final void mo173c() {
        if (this.f172r == null) {
            this.f172r = ImageReader.newInstance(this.f162h.width(), this.f162h.height(), 35, 2);
            this.f172r.setOnImageAvailableListener(this.f156C, this.f161g);
            this.f173s = null;
            int i = this.f177w;
            if (i != 0) {
                this.f178x = new SurfaceTexture(i);
                this.f178x.setDefaultBufferSize(this.f162h.width(), this.f162h.height());
                this.f178x.setOnFrameAvailableListener(this.f157D, this.f161g);
                this.f179y = new Surface(this.f178x);
            }
        }
        try {
            if (this.f175u == null) {
                this.f159d.createCaptureSession(Arrays.asList(this.f179y != null ? new Surface[]{this.f179y, this.f172r.getSurface()} : new Surface[]{this.f172r.getSurface()}), new CameraCaptureSession.StateCallback() {
                    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                        C0057g.Log(6, "Camera2: CaptureSession configuration failed.");
                    }

                    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                        if (C0042a.this.f159d != null) {
                            synchronized (C0042a.this.f176v) {
                                CameraCaptureSession unused = C0042a.this.f175u = cameraCaptureSession;
                                try {
                                    CaptureRequest.Builder unused2 = C0042a.this.f174t = C0042a.this.f159d.createCaptureRequest(1);
                                    if (C0042a.this.f179y != null) {
                                        C0042a.this.f174t.addTarget(C0042a.this.f179y);
                                    }
                                    C0042a.this.f174t.addTarget(C0042a.this.f172r.getSurface());
                                    C0042a.this.f174t.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, C0042a.this.f171q);
                                    C0042a.this.m134j();
                                } catch (CameraAccessException e) {
                                    C0057g.Log(6, "Camera2: CameraAccessException " + e);
                                }
                            }
                        }
                    }
                }, this.f161g);
            } else if (this.f180z == C0048a.f187b) {
                this.f175u.setRepeatingRequest(this.f174t.build(), this.f154A, this.f161g);
            }
            this.f180z = C0048a.f186a;
        } catch (CameraAccessException e) {
            C0057g.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* renamed from: d */
    public final void mo174d() {
        synchronized (this.f176v) {
            if (this.f175u != null) {
                try {
                    this.f175u.stopRepeating();
                    this.f180z = C0048a.f187b;
                } catch (CameraAccessException e) {
                    C0057g.Log(6, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    /* renamed from: e */
    public final void mo175e() {
        synchronized (this.f176v) {
            if (this.f175u != null) {
                try {
                    this.f175u.abortCaptures();
                } catch (CameraAccessException e) {
                    C0057g.Log(6, "Camera2: CameraAccessException " + e);
                }
                this.f175u.close();
                this.f175u = null;
                this.f180z = C0048a.f188c;
            }
        }
    }
}
