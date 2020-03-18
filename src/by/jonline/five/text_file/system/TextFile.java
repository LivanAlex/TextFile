package by.jonline.five.text_file.system;

public class TextFile extends FileObject {

	private String data;
	
	protected TextFile(String name) {
		super(name, "txt");
		
	}

	@Override
	protected String getBody() {
		String files = "Содержимое файла \""+ name + "." + type +"\":\n";
		return files + data;
	}

	@Override
	protected <T1> void add(T1 body) {
		if (body.getClass() == String.class) {
			if(data != null) {
				data += (String) body;
			} else {
				data = (String) body;
			}
			
		} else {
			System.out.println("текст можно дополнить только текстом!");
		}	
	}
	
	@Override
	protected void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TextFile [data=" + data + ", name=" + name + "]";
	}
}
