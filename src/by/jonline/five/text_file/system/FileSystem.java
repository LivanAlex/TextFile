package by.jonline.five.text_file.system;

import java.util.HashSet;

import by.jonline.five.text_file.system.FileType;

public class FileSystem {
	
	private Directory root;
	
	public Directory getRoot() {
		return root;
	}

	public FileSystem() {
		root = new Directory("C://");
	}
	
	public FileObject create(FileType type, String name) {

		FileObject result = null;
		switch (type) {
		case DIRECTORY: {
			result =  new Directory(name);
			break;
		}
		case TXT:{
			result = new TextFile(name);
			break;
		}
		}
		return result;
	}
	
	public void rename(FileObject file, String name) {
		file.setName(name);
	}
	
	public void show(FileObject file) {
		System.out.println(file.getBody());
	}
	public <T1> void add(FileObject file, T1 body) {
		file.add(body);
	}
	public void add(Directory dir) {
		root.add(dir);
	}
	public void delete(FileObject file) {
		if(remove(root.getData(), file)) {
			if(file.getType().equals("<dir>")) {
				System.out.printf("Директория \"%s\" успешно удалена!\n", file.getName());
			} else {
				System.out.printf("Файл \"%s\" успешно удален!\n", file.getName());
			}
		} else {
			if(file.getType().equals("<dir>")) {
				System.out.printf("Директория \"%s\" не найдена!\n", file.getName());
			} else {
				System.out.printf("Файл \"%s\" не найден!\n", file.getName());
			}
		}
	}

	private boolean remove(HashSet <FileObject> data, FileObject file) {
		if (data.remove(file)){
			return true;
		} else {
			for (FileObject f : data) {
				if(f instanceof Directory) {
					if(remove(((Directory) f).getData(), file)){
						return true;
					}
				}
			}
			return false;
		}
	}
}
