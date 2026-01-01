FROM fedora:43

WORKDIR /usr/local/build
RUN dnf install -y git

RUN git clone --recurse-submodule https://github.com/gfx-rs/wgpu-native.git

WORKDIR /usr/local/build/wgpu-native

RUN dnf install -y cargo
RUN dnf install -y clang

RUN cargo build --release
RUN make Makefile
RUN cargo test --release
RUN echo $LD_LIBRARY_PATH
WORKDIR /usr/local/build/wgpu-native/target/release
RUN cp libwgpu_native.so /usr/local/lib/libwgpu_native.so
RUN ldconfig

WORKDIR /usr/local/build
RUN rm -rf /usr/local/build/wgpu-native


# Update package lists and install the default JDK
RUN dnf install -y java-25-openjdk

# Verify the installation
RUN java -version

WORKDIR /usr/local/app
COPY . .

RUN ./mvnw clean
RUN ./mvnw validate
RUN ./mvnw compile
RUN ./mvnw package
RUN ./mvnw install