package org.webgpu.generator.domain;

import java.util.ArrayList;
import java.util.List;

public class GpuCallback {
    String name;
    String doc;
    String style;
    List<Arg> args = new ArrayList<>();

    
    

    @Override
    public String toString() {
        return "GpuCallback [name=" + name + ", doc=" + doc + ", style=" + style + ", args=" + args + "]";
    }




    public static class Arg {
        String name;
        String doc;
        String type;
        String pointer;

        

        @Override
        public String toString() {
            return "Arg [name=" + name + ", doc=" + doc + ", type=" + type + ", pointer=" + pointer + "]";
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
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}




	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
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
}
