package by.jonline.five.text_file.system;

import java.util.HashSet;

public class Directory extends FileObject{
	
	private HashSet <FileObject> data;
	
	protected Directory(String name) {
		super(name, "<dir>");
		data = new HashSet<>();
	}

	protected HashSet<FileObject> getData() {
		return data;
	}

	protected void add(FileObject file) {
		data.add(file);
	}

	@Override
	protected String getBody() {
		String files = "Содержимое дирректории \""+ name +"\":\n";
		for (FileObject f : data) {
			
			files += String.format("%-15s%s\n", f.name, f.type);
		}
		return files;
	}

	@Override
	protected <T1> void add(T1 body) {
		if (body instanceof FileObject) {
			data.add((FileObject)body);
		} else {
			System.out.println("такое в папку клать нельзя!");
		}
		
	}

	@Override
	protected void setName(String name) {
		this.name = name + " <dir>";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Directory other = (Directory) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	
}
