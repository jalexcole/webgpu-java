package org.webgpu.generator.domain;

import java.util.ArrayList;
import java.util.List;

public class GpuBitflag {
    String name;
    String doc;
    List<Entry> entries;

    
    

    @Override
    public String toString() {
        return "GpuBitflag [name=" + name + ", doc=" + doc + ", entries=" + entries + "]";
    }



    public static class Entry {
        String name;
        String doc;
        List<String> value_combination = new ArrayList<>();

        
        @Override
        public String toString() {
            return "Entry [name=" + name + ", doc=" + doc + ", value_combination=" + value_combination + "]";
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
         * @return the value_combination
         */
        public List<String> getValue_combination() {
            return value_combination;
        }


        /**
         * @param value_combination the value_combination to set
         */
        public void setValue_combination(List<String> value_combination) {
            this.value_combination = value_combination;
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
        return doc;
    }



    /**
     * @param doc the doc to set
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }



    /**
     * @return the entries
     */
    public List<Entry> getEntries() {
        return entries;
    }



    /**
     * @param entries the entries to set
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
