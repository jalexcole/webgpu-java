package org.webgpu.generator.domain;

import java.util.ArrayList;
import java.util.List;

public class GpuObject {
    private String name;
    private String doc;
    private List<GpuFunction> methods = new ArrayList<>();
    @Override
    public String toString() {
        return "GpuObject [name=" + name + ", doc=" + doc + ", methods=" + methods + "]";
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
     * @return the doc
     */
    public String getDoc() {
        return doc;
    }
    /**
     * @param doc the doc to set
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }
    /**
     * @return the methods
     */
    public List<GpuFunction> getMethods() {
        return methods;
    }
    /**
     * @param methods the methods to set
     */
    public void setMethods(List<GpuFunction> methods) {
        this.methods = methods;
    }

    
    
}
