package task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String directory = reader.readLine();
        Path pathDirectory = Paths.get(directory);

        if (!Files.isDirectory(pathDirectory)) {
            System.out.println(pathDirectory.toString() + " - не папка");
            return;
        }

        MyFileVisitorHelper fileVisitorHelper = new MyFileVisitorHelper();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(pathDirectory, options, 20, fileVisitorHelper);

        System.out.println(String.format("Всего папок - %d \nВсего файлов - %d \nОбщий размер - %d",
          fileVisitorHelper.allDirectories.get() - 1, fileVisitorHelper.allFiles.get(), fileVisitorHelper.allBytes.get()));


    }

    public static class MyFileVisitorHelper extends SimpleFileVisitor<Path> {

        AtomicInteger allDirectories = new AtomicInteger();
        AtomicInteger allFiles = new AtomicInteger();
        AtomicLong allBytes = new AtomicLong();
        public static AtomicLong oTPallBytes = new AtomicLong();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                allFiles.getAndIncrement();
                allBytes.getAndAdd(Files.readAllBytes(file).length);

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            allDirectories.getAndIncrement();
            return FileVisitResult.CONTINUE;
        }
    }
}
