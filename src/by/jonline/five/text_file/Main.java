package by.jonline.five.text_file;

import by.jonline.five.text_file.system.Directory;
import by.jonline.five.text_file.system.FileSystem;
import by.jonline.five.text_file.system.FileType;
import by.jonline.five.text_file.system.TextFile;

public class Main {

	public static void main(String[] args) {
		FileSystem system = new FileSystem();
		
		Directory newOne = (Directory) system.create(FileType.DIRECTORY, "новая папка");
		Directory recipes = (Directory) system.create(FileType.DIRECTORY, "рецепты");
		Directory newTwo = (Directory) system.create(FileType.DIRECTORY, "новая папка2");
		Directory anime = (Directory) system.create(FileType.DIRECTORY, "анимэ");

		TextFile text1 = (TextFile) system.create(FileType.TXT, "рецепт чая");
		TextFile text2 = (TextFile) system.create(FileType.TXT, "рецепт яичницы");
		TextFile text3 = (TextFile) system.create(FileType.TXT, "анекдоты");
		
		system.add(newOne);
		system.rename(newOne, "Папка скучает");
		system.add(newOne, recipes);
		system.add(newOne, text3);
		system.add(newOne, newTwo);
		system.add(newOne, anime);
		system.show(newOne);
		
		system.delete(newTwo);
		
		system.add(recipes, text1);
		system.add(recipes, text2);
		
		system.show(recipes);

		
		system.add(text1, "1. Вскипятить литр воды\n");
		system.show(text1);
		system.add(text1, "2. Заварить чай\n");
		system.show(text1);


		system.show(newOne);

	}

}
