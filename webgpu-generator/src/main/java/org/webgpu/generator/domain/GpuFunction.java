package org.webgpu.generator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GpuFunction {
    private String name;
    private String doc;
    private List<Arg> args = new ArrayList<>();
    private List<Arg> returns_async = new ArrayList<>();
    private Optional<Return> returns = Optional.empty();
    private String callback;

    public GpuFunction() {

    }

    public GpuFunction(
            String name,
            String doc,
            List<Arg> args,
            List<Arg> returns_async,
            Return returns,
            String callback
    ) {
        this.name = name;
        this.doc = doc;
        this.args = args;
        this.returns_async = returns_async;
        this.returns = Optional.ofNullable(returns);
        this.callback = callback;
    }

    

    @Override
    public String toString() {
        return "GpuFunction [name=" + name + ", doc=" + doc + ", args=" + args + ", returns_async=" + returns_async
                + ", returns=" + returns + ", callback=" + callback + "]";
    }



    public static class Return {
        String type;
        String doc;
        boolean passed_with_ownership = false;
        Optional<String> pointer = Optional.empty();
        @Override
        public String toString() {
            return "Return [type=" + type + ", doc=" + doc + ", passed_with_ownership=" + passed_with_ownership
                    + ", pointer=" + pointer + "]";
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
         * @return the passed_with_ownership
         */
        public boolean isPassed_with_ownership() {
            return passed_with_ownership;
        }
        /**
         * @param passed_with_ownership the passed_with_ownership to set
         */
        public void setPassed_with_ownership(boolean passed_with_ownership) {
            this.passed_with_ownership = passed_with_ownership;
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

	/**
	 * @return the callback
	 */
	public String getCallback() {
		return callback;
	}

	/**
	 * @param callback the callback to set
	 */
	public void setCallback(String callback) {
		this.callback = callback;
	}
}
