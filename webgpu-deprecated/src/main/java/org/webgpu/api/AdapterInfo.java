package org.webgpu.api;

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
