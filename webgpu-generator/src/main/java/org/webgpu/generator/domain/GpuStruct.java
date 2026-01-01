package org.webgpu.generator.domain;

import java.util.ArrayList;
import java.util.List;

public class GpuStruct {
    String name;
    String doc;
    String type;
    List<Member> members = new ArrayList<>();
    boolean free_members = false;
    List<String> extendz = new ArrayList<>();


    

    @Override
    public String toString() {
        return "GpuStruct [name=" + name + ", doc=" + doc + ", type=" + type + ", members=" + members
                + ", free_members=" + free_members + ", extendz=" + extendz + "]";
    }




    public static class Member {
        String name;
        String doc;
        String type;
        boolean optional = false;
        String pointer = null;
        @Override
        public String toString() {
            return "Member [name=" + name + ", doc=" + doc + ", type=" + type + ", optional=" + optional + ", pointer="
                    + pointer + "]";
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
        /**
         * @return the pointer
         */
        public String getPointer() {
            return pointer;
        }
        /**
         * @param pointer the pointer to set
         */
        public void setPointer(String pointer) {
            this.pointer = pointer;
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
	 * @return the members
	 */
	public List<Member> getMembers() {
		return members;
	}




	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Member> members) {
		this.members = members;
	}




	/**
	 * @return the free_members
	 */
	public boolean isFree_members() {
		return free_members;
	}




	/**
	 * @param free_members the free_members to set
	 */
	public void setFree_members(boolean free_members) {
		this.free_members = free_members;
	}




	/**
	 * @return the extendz
	 */
	public List<String> getExtendz() {
		return extendz;
	}




	/**
	 * @param extendz the extendz to set
	 */
	public void setExtendz(List<String> extendz) {
		this.extendz = extendz;
	}
}
