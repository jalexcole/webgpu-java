package org.webgpu.generator.generators;

import java.lang.foreign.MemorySegment;
import java.util.List;

import com.palantir.javapoet.ArrayTypeName;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.TypeName;

public class Utils {

    private Utils() {
    }
    
    public static final List<String> BASIC_TYPES = List.of("void", "int", "long", "float", "double", "boolean",
            "String");
    
    public static String addPrefix(String input) {
        return "WGPU" + input;
    }

    public static TypeName map(String type) {
        type = cleanName(type);

        if (type.endsWith("[]")) {
            return ArrayTypeName.of(map(type.replace("[]", "")));
        }

        return switch (type) {
            case "usize" -> TypeName.INT;
            case "void" -> TypeName.VOID;
            case "uint16" -> TypeName.SHORT;
            case "int" -> TypeName.INT;
            case "uint32" -> TypeName.INT;
            case "int32" -> TypeName.INT;
            case "long" -> TypeName.LONG;
            case "uint64" -> TypeName.LONG;
            case "int64" -> TypeName.LONG;
            case "float" -> TypeName.FLOAT;
            case "float32" -> TypeName.FLOAT;
            case "float64" -> TypeName.DOUBLE;
            case "double" -> TypeName.DOUBLE;
            case "bool" -> TypeName.BOOLEAN;
            case "boolean" -> TypeName.BOOLEAN;
            case "String" -> ClassName.get(String.class);
            case "out_string" -> ClassName.get(String.class);
            case "nullable_string" -> ClassName.get(String.class);
            case "string_with_default_empty" -> ClassName.get(String.class);
            case "c_void" -> ClassName.get(MemorySegment.class);
            default -> ClassName.get("org.webgpu", type);
        };

    }

    public static String toScreamingSnakeCase(String input) {
        return input.toUpperCase();
    }

    public static String cleanName(String input) {
        if (input.contains("array")) {
            StringBuilder sb = new StringBuilder();

            sb.append(input.replace("array<", "").replace(">", ""));

            sb.append("[]");

            input = sb.toString();
        }


        if (input.contains("enum.")) {
            return input.replace("enum.", "");
        } else if (input.contains("struct.")) {
            return input.replace("struct.", "");
        } else if (input.contains("object.")) {
            return input.replace("object.", "");
        } else if (input.contains("bitflag.")) {
            return input.replace("bitflag.", "");
        } else if (input.contains("callback.")) {
            return input.replace("callback.", "");
        }

        

        return input;
    }
}
