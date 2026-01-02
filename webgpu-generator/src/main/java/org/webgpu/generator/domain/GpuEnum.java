package org.webgpu.generator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GpuEnum {
    String name;
    String doc;
    List<Entry> entries = new ArrayList<>();

    public static class Entry {
        String name;
        String doc;
        Optional<Integer> value;
        @Override
        public String toString() {
            return "Entry [name=" + name + ", doc=" + doc + ", value=" + value + "]";
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
		 * @return the value
		 */
		public Optional<Integer> getValue() {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public void setValue(Integer value) {
			this.value = Optional.ofNullable(value);
		}
        
        
    }

    @Override
    public String toString() {
        return "GpuEnum [name=" + name + ", doc=" + doc + ", entries=" + entries + "]";
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
