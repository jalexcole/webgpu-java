@group(0) @binding(0)
var<storage, read> a : array<f32>;

@group(0) @binding(1)
var<storage, read> b : array<f32>;

@group(0) @binding(2)
var<storage, read_write> outData : array<f32>;

@compute @workgroup_size(4)
fn main(@builtin(global_invocation_id) gid : vec3<u32>) {
    let idx = gid.x;
    if (idx >= 4u) {
        return;
    }

    let row = idx / 2u;
    let col = idx % 2u;

    var sum : f32 = 0.0;
    for (var k : u32 = 0u; k < 2u; k = k + 1u) {
        sum = sum + a[row * 2u + k] * b[k * 2u + col];
    }

    outData[idx] = sum;
}