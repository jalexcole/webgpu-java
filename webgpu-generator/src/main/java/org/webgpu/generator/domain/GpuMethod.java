package org.webgpu.generator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.webgpu.generator.domain.GpuFunction.Return;

public class GpuMethod {
    private String name;
    private String doc;
    private List<Arg> args = new ArrayList<>();
    private List<Arg> returns_async = new ArrayList<>();
    private List<Arg> callback_args = new ArrayList<>();
    private Optional<Return> returns = Optional.empty();

    public GpuMethod() {
    }

    public GpuMethod(String name, String doc, List<Arg> args, List<Arg> returns_async, List<Arg> callback_args, Optional<Return> returns) {
        this.name = name;
        this.doc = doc;
        this.args = args;
        this.returns_async = returns_async;
        this.callback_args = callback_args;
        this.returns = returns;
    }

    @Override
    public String toString() {
        return "GpuMethod [name=" + name + ", doc=" + doc + ", args=" + args + ", returns_async=" + returns_async
                + ", callback_args=" + callback_args + ", returns=" + returns + "]";
    }

    public static class Arg {
        String name;
        String doc;
        String type;
        Optional<String> pointer = Optional.empty();
        boolean optional = false;

        @Override
        public String toString() {
            return "Arg [name=" + name + ", doc=" + doc + ", type=" + type + ", pointer=" + pointer + ", optional="
                    + optional + "]";
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
            if (doc.equals("TODO")) {
                return "";
            }

            return this.doc;
        }

        /**
         * @param doc the doc to set
         */
        public void setDoc(String doc) {
            this.doc = doc;
        }

        /**
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type the type to set
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @return the pointer
         */
        public Optional<String> getPointer() {
            return pointer;
        }

        /**
         * @param pointer the pointer to set
         */
        public void setPointer(String pointer) {
            this.pointer = Optional.ofNullable(pointer);
        }

        /**
         * @return the optional
         */
        public boolean isOptional() {
            return optional;
        }

        /**
         * @param optional the optional to set
         */
        public void setOptional(boolean optional) {
            this.optional = optional;
        }

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
        if (doc.equals("TODO")) {
            return "";
        }

        return this.doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }

    /**
     * @return the args
     */
    public List<Arg> getArgs() {
        return args;
    }

    /**
     * @param args the args to set
     */
    public void setArgs(List<Arg> args) {
        this.args = args;
    }

    /**
     * @return the returns_async
     */
    public List<Arg> getReturns_async() {
        return returns_async;
    }

    /**
     * @param returns_async the returns_async to set
     */
    public void setReturns_async(List<Arg> returns_async) {
        this.returns_async = returns_async;
    }

    /**
     * @return the callback_args
     */
    public List<Arg> getCallback_args() {
        return callback_args;
    }

    /**
     * @param callback_args the callback_args to set
     */
    public void setCallback_args(List<Arg> callback_args) {
        this.callback_args = callback_args;
    }

    /**
     * @return the returns
     */
    public Optional<Return> getReturns() {
        return returns;
    }

    /**
     * @param returns the returns to set
     */
    public void setReturns(Return returns) {
        this.returns = Optional.ofNullable(returns);
    }

}
