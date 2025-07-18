/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.webgpu;

import org.jspecify.annotations.*;
import org.lwjgl.system.*;
import java.nio.*;

import static org.lwjgl.system.APIUtil.*;
import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;
import static org.lwjgl.system.MemoryUtil.*;

public final class GPU {

    private static @Nullable FunctionProvider functionProvider;

    static {
        Library.loadSystem(System::load, System::loadLibrary, GPU.class, GPU.class.getPackageName(),
                Platform.mapLibraryNameBundled("wgpu_native"));

        if (!Configuration.OPENGL_EXPLICIT_INIT.get(false)) {
            create();
        }
    }

    private GPU() {
    }

    /** Ensures that the lwjgl_opengl shared library has been loaded. */
    static void initialize() {
        // intentionally empty to trigger static initializer
    }

    /** Loads the OpenGL native library, using the default library name. */
    public static void create() {
        SharedLibrary GPU = null;

        String contextAPI = Configuration.OPENGL_CONTEXT_API.get();

        if (GPU == null) {
            GPU = loadNative();
        }

        if (GPU == null) {
            throw new IllegalStateException("There is no WebGPU context management API available.");
        }

        create(GPU);
    }

    private static @Nullable SharedLibrary loadNative() {
        try {
            return Library.loadNative(GPU.class, GPU.class.getPackageName(), Configuration.OPENGL_LIBRARY_NAME,
                    Configuration.OPENGL_LIBRARY_NAME_DEFAULTS());
        } catch (Throwable ignored) {
            apiLog("[GPU] Failed to initialize context management based on native WebGPU platform API");
            return null;
        }
    }

    /**
     * Loads the OpenGL native library, using the specified library name.
     *
     * @param libName the native library name
     */
    public static void create(String libName) {
        create(Library.loadNative(GPU.class, GPU.class.getPackageName(), libName));
    }

    private static void create(SharedLibrary WEB_GPU) {
        try {
            create((FunctionProvider) new SharedLibrary.Delegate(WEB_GPU) {
                private final long GetProcAddress;

                {
                    long GetProcAddress = NULL;

                    switch (Platform.get()) {
                        case FREEBSD:
                        case LINUX:
                            GetProcAddress = library.getFunctionAddress("glXGetProcAddress");
                            if (GetProcAddress == NULL) {
                                GetProcAddress = library.getFunctionAddress("glXGetProcAddressARB");
                            }
                            break;
                        case WINDOWS:
                            GetProcAddress = library.getFunctionAddress("wglGetProcAddress");
                            break;
                    }
                    if (GetProcAddress == NULL) {
                        GetProcAddress = library.getFunctionAddress("eglGetProcAddress");
                    }
                    if (GetProcAddress == NULL) {
                        GetProcAddress = library.getFunctionAddress("OSMesaGetProcAddress");
                    }

                    this.GetProcAddress = GetProcAddress;
                }

                @Override
                public long getFunctionAddress(ByteBuffer functionName) {
                    long address = GetProcAddress == NULL ? NULL : callPP(memAddress(functionName), GetProcAddress);
                    if (address == NULL) {
                        address = library.getFunctionAddress(functionName);
                        if (address == NULL && DEBUG_FUNCTIONS) {
                            apiLogMissing("GPU", functionName);
                        }
                    }

                    return address;
                }
            });
        } catch (RuntimeException e) {
            WEB_GPU.free();
            throw e;
        }
    }

    /**
     * Initializes OpenGL with the specified {@link FunctionProvider}. This method
     * can be used to implement custom OpenGL library loading.
     *
     * @param functionProvider the provider of OpenGL function addresses
     */
    public static void create(FunctionProvider functionProvider) {
        if (GPU.functionProvider != null) {
            throw new IllegalStateException("OpenGL library has already been loaded.");
        }

        GPU.functionProvider = functionProvider;
        // ThreadLocalUtil.setFunctionMissingAddresses(GLCapabilities.ADDRESS_BUFFER_SIZE);
    }

    /** Unloads the OpenGL native library. */
    public static void destroy() {
        if (functionProvider == null) {
            return;
        }

        ThreadLocalUtil.setFunctionMissingAddresses(0);

        if (functionProvider instanceof NativeResource) {
            ((NativeResource) functionProvider).free();
        }
        functionProvider = null;
    }

    /** Returns the {@link FunctionProvider} for the OpenGL native library. */
    public static @Nullable FunctionProvider getFunctionProvider() {
        return functionProvider;
    }

    /**
     * Sets the {@link GLCapabilities} of the OpenGL context that is current in the
     * current thread.
     *
     * <p>
     * This {@code GLCapabilities} instance will be used by any OpenGL call in the
     * current thread, until {@code setCapabilities} is called again with a
     * different value.
     * </p>
     */
    // public static void setCapabilities(@Nullable GLCapabilities caps) {
    // capabilitiesTLS.set(caps);
    // ThreadLocalUtil.setCapabilities(caps == null ? NULL :
    // memAddress(caps.addresses));
    // icd.set(caps);
    // }

    /**
     * Returns the {@link GLCapabilities} of the OpenGL context that is current in
     * the current thread.
     *
     * @throws IllegalStateException if {@link #setCapabilities} has never been
     *                               called in the current thread or was last called
     *                               with a {@code null} value
     */
    // public static GLCapabilities getCapabilities() {
    // return checkCapabilities(capabilitiesTLS.get());
    // }

    // private static GLCapabilities checkCapabilities(@Nullable GLCapabilities
    // caps) {
    // if (CHECKS && caps == null) {
    // throw new IllegalStateException(
    // "No GLCapabilities instance set for the current thread. Possible
    // solutions:\n" +
    // "\ta) Call GPU.createCapabilities() after making a context current in the
    // current thread.\n"
    // +
    // "\tb) Call GPU.setCapabilities() if a GLCapabilities instance already exists
    // for the current context.");
    // }
    // // noinspection ConstantConditions
    // return caps;
    // }

    /**
     * Returns the WGL capabilities.
     *
     * <p>
     * This method may only be used on Windows.
     * </p>
     */
    // public static WGLCapabilities getCapabilitiesWGL() {
    // if (capabilitiesWGL == null) {
    // capabilitiesWGL = createCapabilitiesWGLDummy();
    // }

    // return capabilitiesWGL;
    // }

    // /** Returns the GLX client capabilities. */
    // static GLXCapabilities getCapabilitiesGLXClient() {
    // if (capabilitiesGLXClient == null) {
    // capabilitiesGLXClient = initCapabilitiesGLX(true);
    // }

    // return capabilitiesGLXClient;
    // }

    /**
     * Returns the GLX capabilities.
     *
     * <p>
     * This method may only be used on Linux.
     * </p>
     */
    // public static GLXCapabilities getCapabilitiesGLX() {
    // if (capabilitiesGLX == null) {
    // capabilitiesGLX = initCapabilitiesGLX(false);
    // }

    // return capabilitiesGLX;
    // }

    // private static GLXCapabilities initCapabilitiesGLX(boolean client) {
    // long display = nXOpenDisplay(NULL);
    // try {
    // return createCapabilitiesGLX(display, client ? -1 : XDefaultScreen(display));
    // } finally {
    // XCloseDisplay(display);
    // }
    // }

    /**
     * Creates a new {@link GLCapabilities} instance for the OpenGL context that is
     * current in the current thread.
     *
     * <p>
     * Depending on the current context, the instance returned may or may not
     * contain the deprecated functionality removed since OpenGL version 3.1.
     * </p>
     *
     * <p>
     * This method calls {@link #setCapabilities(GLCapabilities)} with the new
     * instance before returning.
     * </p>
     *
     * @return the GLCapabilities instance
     */
    // public static GLCapabilities createCapabilities() {
    // return createCapabilities(null);
    // }

    /**
     * Creates a new {@link GLCapabilities} instance for the OpenGL context that is
     * current in the current thread.
     *
     * <p>
     * Depending on the current context, the instance returned may or may not
     * contain the deprecated functionality removed since OpenGL version 3.1.
     * </p>
     *
     * <p>
     * This method calls {@link #setCapabilities(GLCapabilities)} with the new
     * instance before returning.
     * </p>
     *
     * @param bufferFactory a function that allocates a {@link PointerBuffer} given
     *                      a size. The buffer must be filled with zeroes. If
     *                      {@code null}, LWJGL will
     *                      allocate a GC-managed buffer internally.
     *
     * @return the GLCapabilities instance
     */
    // public static GLCapabilities createCapabilities(@Nullable
    // IntFunction<PointerBuffer> bufferFactory) {
    // return createCapabilities(false, bufferFactory);
    // }

    /**
     * Creates a new {@link GLCapabilities} instance for the OpenGL context that is
     * current in the current thread.
     *
     * <p>
     * Depending on the current context, the instance returned may or may not
     * contain the deprecated functionality removed since OpenGL version 3.1. The
     * {@code forwardCompatible} flag will force LWJGL to not load the deprecated
     * functions, even if the current context exposes them.
     * </p>
     *
     * <p>
     * This method calls {@link #setCapabilities(GLCapabilities)} with the new
     * instance before returning.
     * </p>
     *
     * @param forwardCompatible if true, LWJGL will create forward compatible
     *                          capabilities
     *
     * @return the GLCapabilities instance
     */
    // public static GLCapabilities createCapabilities(boolean forwardCompatible) {
    // return createCapabilities(forwardCompatible, null);
    // }

    /**
     * Creates a new {@link GLCapabilities} instance for the OpenGL context that is
     * current in the current thread.
     *
     * <p>
     * Depending on the current context, the instance returned may or may not
     * contain the deprecated functionality removed since OpenGL version 3.1. The
     * {@code forwardCompatible} flag will force LWJGL to not load the deprecated
     * functions, even if the current context exposes them.
     * </p>
     *
     * <p>
     * This method calls {@link #setCapabilities(GLCapabilities)} with the new
     * instance before returning.
     * </p>
     *
     * @param forwardCompatible if true, LWJGL will create forward compatible
     *                          capabilities
     * @param bufferFactory     a function that allocates a {@link PointerBuffer}
     *                          given a size. If {@code null}, LWJGL will allocate a
     *                          GC-managed buffer
     *                          internally.
     *
     * @return the GLCapabilities instance
     */
    // @SuppressWarnings("AssignmentToMethodParameter")
    // public static GLCapabilities createCapabilities(boolean forwardCompatible,
    // @Nullable IntFunction<PointerBuffer> bufferFactory) {
    // FunctionProvider functionProvider = GPU.functionProvider;
    // if (functionProvider == null) {
    // throw new IllegalStateException("OpenGL library has not been loaded.");
    // }

    // // We don't have a current ContextCapabilities when this method is called
    // // so we have to use the native bindings directly.
    // long GetError = functionProvider.getFunctionAddress("glGetError");
    // long GetString = functionProvider.getFunctionAddress("glGetString");
    // long GetIntegerv = functionProvider.getFunctionAddress("glGetIntegerv");

    // if (GetError == NULL || GetString == NULL || GetIntegerv == NULL) {
    // throw new IllegalStateException(
    // "Core OpenGL functions could not be found. Make sure that the OpenGL library
    // has been loaded correctly.");
    // }

    // int errorCode = callI(GetError);
    // if (errorCode != GL_NO_ERROR) {
    // apiLog(String.format(
    // "An OpenGL context was in an error state before the creation of its
    // capabilities instance. Error: 0x%X",
    // errorCode));
    // }

    // int majorVersion;
    // int minorVersion;

    // try (MemoryStack stack = stackPush()) {
    // IntBuffer version = stack.ints(0);

    // // Try the 3.0+ version query first
    // callPV(GL_MAJOR_VERSION, memAddress(version), GetIntegerv);
    // if (callI(GetError) == GL_NO_ERROR && 3 <= (majorVersion = version.get(0))) {
    // // We're on an 3.0+ context.
    // callPV(GL_MINOR_VERSION, memAddress(version), GetIntegerv);
    // minorVersion = version.get(0);
    // } else {
    // // Fallback to the string query.
    // String versionString = memUTF8Safe(callP(GL_VERSION, GetString));
    // if (versionString == null || callI(GetError) != GL_NO_ERROR) {
    // throw new IllegalStateException("There is no OpenGL context current in the
    // current thread.");
    // }

    // APIVersion apiVersion = apiParseVersion(versionString);

    // majorVersion = apiVersion.major;
    // minorVersion = apiVersion.minor;
    // }
    // }

    // if (majorVersion < 1 || (majorVersion == 1 && minorVersion < 1)) {
    // throw new IllegalStateException("OpenGL 1.1 is required.");
    // }

    // int[] GL_VERSIONS = {
    // 5, // OpenGL 1.1 to 1.5
    // 1, // OpenGL 2.0 to 2.1
    // 3, // OpenGL 3.0 to 3.3
    // 6, // OpenGL 4.0 to 4.6
    // };

    // Set<String> supportedExtensions = new HashSet<>(512);

    // int maxMajor = min(majorVersion, GL_VERSIONS.length);
    // if (MAX_VERSION != null) {
    // maxMajor = min(MAX_VERSION.major, maxMajor);
    // }
    // for (int M = 1; M <= maxMajor; M++) {
    // int maxMinor = GL_VERSIONS[M - 1];
    // if (M == majorVersion) {
    // maxMinor = min(minorVersion, maxMinor);
    // }
    // if (MAX_VERSION != null && M == MAX_VERSION.major) {
    // maxMinor = min(MAX_VERSION.minor, maxMinor);
    // }

    // for (int m = M == 1 ? 1 : 0; m <= maxMinor; m++) {
    // supportedExtensions.add("OpenGL" + M + m);
    // }
    // }

    // if (majorVersion < 3) {
    // // Parse EXTENSIONS string
    // String extensionsString = memASCIISafe(callP(GL_EXTENSIONS, GetString));
    // if (extensionsString != null) {
    // StringTokenizer tokenizer = new StringTokenizer(extensionsString);
    // while (tokenizer.hasMoreTokens()) {
    // supportedExtensions.add(tokenizer.nextToken());
    // }
    // }
    // } else {
    // // Use indexed EXTENSIONS
    // try (MemoryStack stack = stackPush()) {
    // IntBuffer pi = stack.ints(0);

    // callPV(GL_NUM_EXTENSIONS, memAddress(pi), GetIntegerv);
    // int extensionCount = pi.get(0);

    // long GetStringi = apiGetFunctionAddress(functionProvider, "glGetStringi");
    // for (int i = 0; i < extensionCount; i++) {
    // supportedExtensions.add(memASCII(callP(GL_EXTENSIONS, i, GetStringi)));
    // }

    // // In real drivers, we may encounter the following weird scenarios:
    // // - 3.1 context without GL_ARB_compatibility but with deprecated
    // functionality
    // // exposed and working.
    // // - Core or forward-compatible context with GL_ARB_compatibility exposed,
    // but
    // // not working when used.
    // // We ignore these and go by the spec.

    // // Force forwardCompatible to true if the context is a forward-compatible
    // // context.
    // callPV(GL_CONTEXT_FLAGS, memAddress(pi), GetIntegerv);
    // if ((pi.get(0) & GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT) != 0) {
    // forwardCompatible = true;
    // } else {
    // // Force forwardCompatible to true if the context is a core profile context.
    // if ((3 < majorVersion || 1 <= minorVersion)) { // OpenGL 3.1+
    // if (3 < majorVersion || 2 <= minorVersion) { // OpenGL 3.2+
    // callPV(GL_CONTEXT_PROFILE_MASK, memAddress(pi), GetIntegerv);
    // if ((pi.get(0) & GL_CONTEXT_CORE_PROFILE_BIT) != 0) {
    // forwardCompatible = true;
    // }
    // } else {
    // forwardCompatible = !supportedExtensions.contains("GL_ARB_compatibility");
    // }
    // }
    // }
    // }
    // }
    // apiFilterExtensions(supportedExtensions,
    // Configuration.OPENGL_EXTENSION_FILTER);

    // GLCapabilities caps = new GLCapabilities(functionProvider,
    // supportedExtensions, forwardCompatible,
    // bufferFactory == null
    // ? BufferUtils::createPointerBuffer
    // : bufferFactory);

    // setCapabilities(caps);

    // return caps;
    // }

    /** Creates a dummy context and retrieves the WGL capabilities. */
    // private static WGLCapabilities createCapabilitiesWGLDummy() {
    // long hdc = wglGetCurrentDC(); // just use the current context if one exists
    // if (hdc != NULL) {
    // return createCapabilitiesWGL(hdc);
    // }

    // short classAtom = 0;
    // long hwnd = NULL;
    // long hglrc = NULL;
    // try (MemoryStack stack = stackPush()) {
    // IntBuffer pi = stack.mallocInt(1);

    // WNDCLASSEX wc = WNDCLASSEX.calloc(stack)
    // .cbSize(WNDCLASSEX.SIZEOF)
    // .style(CS_HREDRAW | CS_VREDRAW)
    // .hInstance(WindowsLibrary.HINSTANCE)
    // .lpszClassName(stack.UTF16("WGL"));

    // memPutAddress(
    // wc.address() + WNDCLASSEX.LPFNWNDPROC,
    // User32.Functions.DefWindowProc);

    // classAtom = RegisterClassEx(pi, wc);
    // if (classAtom == 0) {
    // windowsThrowException("Failed to register WGL window class", pi);
    // }

    // hwnd = nCreateWindowEx(
    // memAddress(pi),
    // 0, classAtom & 0xFFFF, NULL,
    // WS_OVERLAPPEDWINDOW | WS_CLIPCHILDREN | WS_CLIPSIBLINGS,
    // 0, 0, 1, 1,
    // NULL, NULL, NULL, NULL);
    // if (hwnd == NULL) {
    // windowsThrowException("Failed to create WGL window", pi);
    // }

    // hdc = check(GetDC(hwnd));

    // PIXELFORMATDESCRIPTOR pfd = PIXELFORMATDESCRIPTOR.calloc(stack)
    // .nSize((short) PIXELFORMATDESCRIPTOR.SIZEOF)
    // .nVersion((short) 1)
    // .dwFlags(PFD_SUPPORT_OPENGL); // we don't care about anything else

    // int pixelFormat = ChoosePixelFormat(pi, hdc, pfd);
    // if (pixelFormat == 0) {
    // windowsThrowException("Failed to choose an OpenGL-compatible pixel format",
    // pi);
    // }

    // if (DescribePixelFormat(pi, hdc, pixelFormat, pfd) == 0) {
    // windowsThrowException("Failed to obtain pixel format information", pi);
    // }

    // if (!SetPixelFormat(pi, hdc, pixelFormat, pfd)) {
    // windowsThrowException("Failed to set the pixel format", pi);
    // }

    // hglrc = check(wglCreateContext(null, hdc));
    // if (!wglMakeCurrent(pi, hdc, hglrc)) {
    // windowsThrowException("Failed to make context current", pi);
    // }

    // return createCapabilitiesWGL(hdc);
    // } finally {
    // if (hglrc != NULL) {
    // wglMakeCurrent(null, NULL, NULL);
    // wglDeleteContext(null, hglrc);
    // }

    // if (hwnd != NULL) {
    // DestroyWindow(null, hwnd);
    // }

    // if (classAtom != 0) {
    // nUnregisterClass(NULL, classAtom & 0xFFFF, WindowsLibrary.HINSTANCE);
    // }
    // }
    // }

    /**
     * Creates a {@link WGLCapabilities} instance for the context that is current in
     * the current thread.
     *
     * <p>
     * This method may only be used on Windows.
     * </p>
     */
    // public static WGLCapabilities createCapabilitiesWGL() {
    // long hdc = wglGetCurrentDC();
    // if (hdc == NULL) {
    // throw new IllegalStateException("Failed to retrieve the device context of the
    // current OpenGL context");
    // }

    // return createCapabilitiesWGL(hdc);
    // }

    /**
     * Creates a {@link WGLCapabilities} instance for the specified device context.
     *
     * @param hdc the device context handle ({@code HDC})
     */
    // private static WGLCapabilities createCapabilitiesWGL(long hdc) {
    // FunctionProvider functionProvider = GPU.functionProvider;
    // if (functionProvider == null) {
    // throw new IllegalStateException("OpenGL library has not been loaded.");
    // }

    // String extensionsString = null;

    // long wglGetExtensionsString =
    // functionProvider.getFunctionAddress("wglGetExtensionsStringARB");
    // if (wglGetExtensionsString != NULL) {
    // extensionsString = memASCII(callPP(hdc, wglGetExtensionsString));
    // } else {
    // wglGetExtensionsString =
    // functionProvider.getFunctionAddress("wglGetExtensionsStringEXT");
    // if (wglGetExtensionsString != NULL) {
    // extensionsString = memASCII(callP(wglGetExtensionsString));
    // }
    // }

    // Set<String> supportedExtensions = new HashSet<>(32);

    // if (extensionsString != null) {
    // StringTokenizer tokenizer = new StringTokenizer(extensionsString);
    // while (tokenizer.hasMoreTokens()) {
    // supportedExtensions.add(tokenizer.nextToken());
    // }
    // }

    // apiFilterExtensions(supportedExtensions,
    // Configuration.OPENGL_EXTENSION_FILTER);

    // return new WGLCapabilities(functionProvider, supportedExtensions);
    // }

    /**
     * Creates a {@link GLXCapabilities} instance for the default screen of the
     * specified X connection.
     *
     * <p>
     * This method may only be used on Linux.
     * </p>
     *
     * @param display the X connection handle ({@code DISPLAY})
     */
    // public static GLXCapabilities createCapabilitiesGLX(long display) {
    // return createCapabilitiesGLX(display, XDefaultScreen(display));
    // }

    /**
     * Creates a {@link GLXCapabilities} instance for the specified screen of the
     * specified X connection.
     *
     * <p>
     * This method may only be used on Linux.
     * </p>
     *
     * @param display the X connection handle ({@code DISPLAY})
     * @param screen  the screen index
     */
    // public static GLXCapabilities createCapabilitiesGLX(long display, int screen)
    // {
    // FunctionProvider functionProvider = GPU.functionProvider;
    // if (functionProvider == null) {
    // throw new IllegalStateException("OpenGL library has not been loaded.");
    // }

    // int majorVersion;
    // int minorVersion;

    // try (MemoryStack stack = stackPush()) {
    // IntBuffer piMajor = stack.ints(0);
    // IntBuffer piMinor = stack.ints(0);

    // if (!glXQueryVersion(display, piMajor, piMinor)) {
    // throw new IllegalStateException("Failed to query GLX version");
    // }

    // majorVersion = piMajor.get(0);
    // minorVersion = piMinor.get(0);
    // if (majorVersion != 1) {
    // throw new IllegalStateException("Invalid GLX major version: " +
    // majorVersion);
    // }
    // }

    // Set<String> supportedExtensions = new HashSet<>(32);

    // int[][] GLX_VERSIONS = {
    // { 1, 2, 3, 4 }
    // };

    // for (int major = 1; major <= GLX_VERSIONS.length; major++) {
    // int[] minors = GLX_VERSIONS[major - 1];
    // for (int minor : minors) {
    // if (major < majorVersion || (major == majorVersion && minor <= minorVersion))
    // {
    // supportedExtensions.add("GLX" + major + minor);
    // }
    // }
    // }

    // if (1 <= minorVersion) {
    // String extensionsString;

    // if (screen == -1) {
    // long glXGetClientString =
    // functionProvider.getFunctionAddress("glXGetClientString");
    // extensionsString = memASCIISafe(callPP(display, GLX_EXTENSIONS,
    // glXGetClientString));
    // } else {
    // long glXQueryExtensionsString =
    // functionProvider.getFunctionAddress("glXQueryExtensionsString");
    // extensionsString = memASCIISafe(callPP(display, screen,
    // glXQueryExtensionsString));
    // }

    // if (extensionsString != null) {
    // StringTokenizer tokenizer = new StringTokenizer(extensionsString);
    // while (tokenizer.hasMoreTokens()) {
    // supportedExtensions.add(tokenizer.nextToken());
    // }
    // }
    // }

    // apiFilterExtensions(supportedExtensions,
    // Configuration.OPENGL_EXTENSION_FILTER);

    // return new GLXCapabilities(functionProvider, supportedExtensions);
    // }

    // Only used by array overloads
    // static GLCapabilities getICD() {
    // return checkCapabilities(icd.get());
    // }

    /** Function pointer provider. */
    private interface ICD {
        // default void set(@Nullable GLCapabilities caps) {
        // }

        // @Nullable
        // GLCapabilities get();
    }

    /**
     * Write-once {@link ICD}.
     *
     * <p>
     * This is the default implementation that skips the thread-local lookup. When a
     * new GLCapabilities is set, we compare it to the write-once capabilities.
     * If different function pointers are found, we fall back to the expensive
     * lookup.
     * </p>
     */
    // private static class ICDStatic implements ICD {

    // private static @Nullable GLCapabilities tempCaps;

    // @SuppressWarnings("AssignmentToStaticFieldFromInstanceMethod")
    // @Override
    // public void set(@Nullable GLCapabilities caps) {
    // if (tempCaps == null) {
    // tempCaps = caps;
    // } else if (caps != null && caps != tempCaps
    // && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses,
    // caps.addresses)) {
    // apiLog("[WARNING] Incompatible context detected. Falling back to thread-local
    // lookup for GPU contexts.");
    // icd = GPU::getCapabilities; // fall back to thread/process lookup
    // }
    // }

    // @Override
    // public GLCapabilities get() {
    // return WriteOnce.caps;
    // }

    // private static final class WriteOnce {
    // // This will be initialized the first time get() above is called
    // static final GLCapabilities caps;

    // static {
    // GLCapabilities tempCaps = ICDStatic.tempCaps;
    // if (tempCaps == null) {
    // throw new IllegalStateException("No GLCapabilities instance has been set");
    // }
    // caps = tempCaps;
    // }
    // }

    // }

}