# WEBGPU for java

# This project provides a Java binding for the WebGPU API, allowing developers to leverage modern graphics capabilities in Java applications

## Primary Goals:
- Compute shader support.
- WEBGPU API support.

## Not Goals:
- Async API

## Maybe Goals:
- Graphics Goals

## Build Instructions:
1. Ensure you have JDK 22 installed. (note: I am working on JDK 21 support, maven issue)
2. Copy the shared library that you need into `org.webgpu.api.WGPU` load library method.

## What is working:

- Instance creation
- Adapter creation
- Device creation

## Needs improvement:
- StringView support (Note: this is likely from allocating the StringView and deallocating it to quickly)