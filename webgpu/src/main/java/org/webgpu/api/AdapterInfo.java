package org.webgpu.api;

import org.webgpu.extract.WGPUAdapterInfo;
import org.webgpu.util.StringView;

public interface AdapterInfo {

    String vendor();

    String architecture();

    String device();

    String description();

    BackendType backendType();

    AdapterType adapterType();

    int vendorId();

    int deviceId();

}
