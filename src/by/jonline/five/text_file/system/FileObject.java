package by.jonline.five.text_file.system;

public abstract class FileObject {
	protected String name;
	protected String type;
	
	protected FileObject(String name, String type) {
		this.name = name;
		this.type = type;
		
	}

	protected String getName() {
		return name;
	}
	
	protected String getType() {
		return type;
	}
	
	protected abstract String getBody();
	protected abstract <T1> void add(T1 body);

	protected abstract void setName(String name);
}
