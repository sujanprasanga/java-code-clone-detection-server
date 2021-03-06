package lk.ac.mrt.cse.mscresearch.codeclones.bytecode;
public class OpCode {
		
		public enum Category{
			PRIMITIVE_OP,
			OTHER,
			INVOKE,
			CONDITIONAL,
			FIELD,
			TYPE_CHECK,
			RETURN,
			NEW_ARRAY,
			SWITCH,
			INVOKE_DYNAMIC
		}
		
		private int label;
		private int lineNumber;
		private String code;
		private String targetClass;
		private String targetMethod;
		private String targetField;
		private int optionalDepth;
		private int loopDepth;
		private boolean arrayOp;
		private int[] targetInstructions;
		private Category category;
		public int getLabel() {
			return label;
		}
		public void setLabel(int label) {
			this.label = label;
		}
		public int getLineNumber() {
			return lineNumber;
		}
		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getTargetClass() {
			return targetClass;
		}
		public void setTargetClass(String targetClass) {
			this.targetClass = targetClass;
		}
		public String getTargetMethod() {
			return targetMethod;
		}
		public void setTargetMethod(String targetMethod) {
			this.targetMethod = targetMethod;
		}
		public String getTargetField() {
			return targetField;
		}
		public void setTargetField(String targetField) {
			this.targetField = targetField;
		}
		public int getOptionalDepth() {
			return optionalDepth;
		}
		public void setOptionalDepth(int d) {
			this.optionalDepth = d;
		}
		public int getLoopDepth() {
			return loopDepth;
		}
		public void setLoopDepth(int d) {
			this.loopDepth = d;
		}
		public boolean isArrayOp() {
			return arrayOp;
		}
		public void setArrayOp(boolean arrayOp) {
			this.arrayOp = arrayOp;
		}
		public int[] getTargetInstructions() {
			return targetInstructions;
		}
		public void setTargetInstructions(int[] targetInstructions) {
			this.targetInstructions = targetInstructions;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}

	}