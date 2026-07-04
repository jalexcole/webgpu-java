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
            return doc;
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

}
