package ru.belotelov.hw1.repo;

import ru.belotelov.hw1.model.Note;

import java.io.*;

public class FileRepo {
    public static final String PATH = "mynotes.dat";

    public void saveNoteToFile(Note note) {
        File file = new File(PATH);
        try (ObjectOutputStream outputStream =
                     createStream(file)) {
            outputStream.writeObject(note);
            System.out.println("Заметка сохранена в файл");
        } catch (IOException ex) {
            System.out.println("Ошибка работы с файлом");
        }
    }

    public void loadNotesFromFile() {
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(new FileInputStream(PATH))) {
            while (true) {
                System.out.println(inputStream.readObject());
            }
        } catch (EOFException ex) {
            System.out.println("Все заметки загружены");
        } catch (IOException ex) {
            System.out.println("Файл не найден");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения из файла");
        }
    }

    private static ObjectOutputStream createStream(File file) throws IOException {
        return file.exists() ? new AppendingObjectOutputStream(new FileOutputStream(file, true)) :
                new ObjectOutputStream(new FileOutputStream(file, true));
    }
}

class AppendingObjectOutputStream extends ObjectOutputStream {
    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

}
