package IO流;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p> 2023/2/19 </p>
 * 读取文件内容
 *
 * @author Fqq
 */
public class ReadFile {
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    private static final String FILE_OF_TXT = PROJECT_DIR + "\\img\\IO.txt";
    private static final String IMG = "./img";

    public static void main(String[] args) {
        ReadFile demo = new ReadFile();
        demo.readOneLine();
        demo.bufferReader();
        demo.readAllBytes();
        demo.readDirectoryOfFiles();
        demo.directoryStreamJDK8();
        demo.depthDirectory(2);
        demo.listFilesUsingFileWalkAndVisitor(IMG);
    }

    /**
     * 每次读取一行
     */
    void readOneLine() {
        try {
            try (Stream<String> lines = Files.lines(Paths.get(FILE_OF_TXT))) {
                lines.forEach(v -> System.out.println(v));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 经典管道流 读取文件内容
     */
    void bufferReader() {
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_OF_TXT))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取所有字节流
     */
    void readAllBytes() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(FILE_OF_TXT));
            String content = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取一个文件夹的文件列表，一次性读取整个目录，因此目录文件过多时可能会出现问题，不建议！
     */
    @Deprecated
    void readDirectoryOfFiles() {
        File directory = new File(IMG);
        File[] files = directory.listFiles();
        Objects.requireNonNull(files);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    /**
     * java 8 流式处理文件夹列表
     */
    void directoryStreamJDK8() {
        try {
            try (Stream<Path> list = Files.list(Paths.get(IMG))) {
                list
                        .filter(d -> !Files.isDirectory(d))
                        .forEach(path -> {
                            System.out.println(path);
                            System.out.println(path.getFileName().toString());
                        });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 深度遍历文件夹内容
     */
    void depthDirectory(int depth) {
        try {
            try (Stream<Path> walk = Files.walk(Paths.get(IMG), depth)) {
                Set<String> collect = walk
                        .filter(path -> !Files.isDirectory(path))
                        .map(path -> path.getFileName())
                        .map(path -> path.toString())
                        .collect(Collectors.toSet());
                System.out.println(collect);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 遍历文件夹做一些操作，使用 walkFileTree
     */
    void listFilesUsingFileWalkAndVisitor(String dir) {
        try {
            Set<String> fileList = new HashSet<>();
            Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (!Files.isDirectory(file)) {
                        fileList.add(file.getFileName().toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println(fileList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
