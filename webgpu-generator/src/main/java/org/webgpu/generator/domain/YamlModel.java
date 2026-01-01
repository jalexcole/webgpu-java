package org.webgpu.generator.domain;

import java.util.List;

public class YamlModel {
    String copyright;
    String name;
    String enum_prefix;
    List<GpuConstant> constants;
    List<String> typedefs;
    List<GpuBitflag> bitflags;
    List<GpuStruct> structs;
    List<GpuFunction> functions;
    List<GpuObject> objects;
    List<GpuEnum> enums;
    // Used on v22
    List<GpuFunctionType> function_types;
    // Used on v23
    List<GpuCallback> callbacks;

    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copyright == null) ? 0 : copyright.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((enum_prefix == null) ? 0 : enum_prefix.hashCode());
		result = prime * result + ((constants == null) ? 0 : constants.hashCode());
		result = prime * result + ((typedefs == null) ? 0 : typedefs.hashCode());
		result = prime * result + ((bitflags == null) ? 0 : bitflags.hashCode());
		result = prime * result + ((structs == null) ? 0 : structs.hashCode());
		result = prime * result + ((functions == null) ? 0 : functions.hashCode());
		result = prime * result + ((objects == null) ? 0 : objects.hashCode());
		result = prime * result + ((enums == null) ? 0 : enums.hashCode());
		result = prime * result + ((function_types == null) ? 0 : function_types.hashCode());
		result = prime * result + ((callbacks == null) ? 0 : callbacks.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof YamlModel))
			return false;
		YamlModel other = (YamlModel) obj;
		if (copyright == null) {
			if (other.copyright != null)
				return false;
		} else if (!copyright.equals(other.copyright))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (enum_prefix == null) {
			if (other.enum_prefix != null)
				return false;
		} else if (!enum_prefix.equals(other.enum_prefix))
			return false;
		if (constants == null) {
			if (other.constants != null)
				return false;
		} else if (!constants.equals(other.constants))
			return false;
		if (typedefs == null) {
			if (other.typedefs != null)
				return false;
		} else if (!typedefs.equals(other.typedefs))
			return false;
		if (bitflags == null) {
			if (other.bitflags != null)
				return false;
		} else if (!bitflags.equals(other.bitflags))
			return false;
		if (structs == null) {
			if (other.structs != null)
				return false;
		} else if (!structs.equals(other.structs))
			return false;
		if (functions == null) {
			if (other.functions != null)
				return false;
		} else if (!functions.equals(other.functions))
			return false;
		if (objects == null) {
			if (other.objects != null)
				return false;
		} else if (!objects.equals(other.objects))
			return false;
		if (enums == null) {
			if (other.enums != null)
				return false;
		} else if (!enums.equals(other.enums))
			return false;
		if (function_types == null) {
			if (other.function_types != null)
				return false;
		} else if (!function_types.equals(other.function_types))
			return false;
		if (callbacks == null) {
			if (other.callbacks != null)
				return false;
		} else if (!callbacks.equals(other.callbacks))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "YamlModel [copyright=" + copyright + ", name=" + name + ", enum_prefix=" + enum_prefix + ", constants="
				+ constants + ", typedefs=" + typedefs + ", bitflags=" + bitflags + ", structs=" + structs
				+ ", functions=" + functions + ", objects=" + objects + ", enums=" + enums + ", function_types="
				+ function_types + ", callbacks=" + callbacks + "]";
	}
	/**
	 * @return the copyright
	 */
	public String getCopyright() {
		return copyright;
	}
	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the enum_prefix
	 */
	public String getEnum_prefix() {
		return enum_prefix;
	}
	/**
	 * @param enum_prefix the enum_prefix to set
	 */
	public void setEnum_prefix(String enum_prefix) {
		this.enum_prefix = enum_prefix;
	}
	/**
	 * @return the constants
	 */
	public List<GpuConstant> getConstants() {
		return constants;
	}
	/**
	 * @param constants the constants to set
	 */
	public void setConstants(List<GpuConstant> constants) {
		this.constants = constants;
	}
	/**
	 * @return the typedefs
	 */
	public List<String> getTypedefs() {
		return typedefs;
	}
	/**
	 * @param typedefs the typedefs to set
	 */
	public void setTypedefs(List<String> typedefs) {
		this.typedefs = typedefs;
	}
	/**
	 * @return the bitflags
	 */
	public List<GpuBitflag> getBitflags() {
		return bitflags;
	}
	/**
	 * @param bitflags the bitflags to set
	 */
	public void setBitflags(List<GpuBitflag> bitflags) {
		this.bitflags = bitflags;
	}
	/**
	 * @return the structs
	 */
	public List<GpuStruct> getStructs() {
		return structs;
	}
	/**
	 * @param structs the structs to set
	 */
	public void setStructs(List<GpuStruct> structs) {
		this.structs = structs;
	}
	/**
	 * @return the functions
	 */
	public List<GpuFunction> getFunctions() {
		return functions;
	}
	/**
	 * @param functions the functions to set
	 */
	public void setFunctions(List<GpuFunction> functions) {
		this.functions = functions;
	}
	/**
	 * @return the objects
	 */
	public List<GpuObject> getObjects() {
		return objects;
	}
	/**
	 * @param objects the objects to set
	 */
	public void setObjects(List<GpuObject> objects) {
		this.objects = objects;
	}
	/**
	 * @return the enums
	 */
	public List<GpuEnum> getEnums() {
		return enums;
	}
	/**
	 * @param enums the enums to set
	 */
	public void setEnums(List<GpuEnum> enums) {
		this.enums = enums;
	}
	/**
	 * @return the function_types
	 */
	public List<GpuFunctionType> getFunction_types() {
		return function_types;
	}
	/**
	 * @param function_types the function_types to set
	 */
	public void setFunction_types(List<GpuFunctionType> function_types) {
		this.function_types = function_types;
	}
	/**
	 * @return the callbacks
	 */
	public List<GpuCallback> getCallbacks() {
		return callbacks;
	}
	/**
	 * @param callbacks the callbacks to set
	 */
	public void setCallbacks(List<GpuCallback> callbacks) {
		this.callbacks = callbacks;
	}

    
}
