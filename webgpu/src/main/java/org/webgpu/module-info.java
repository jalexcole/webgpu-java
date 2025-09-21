module org.webgpu {
    requires java.logging;
    requires org.jspecify;
    requires org.slf4j;
    requires org.webgpu.panama;


    exports org.webgpu.api;
    exports org.webgpu.exceptions;
}
