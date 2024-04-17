package 百家姓与名;

import 数据库操作.entity.Student;
import 数据库操作.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p> 2024/4/17 </p>
 * 随机生成数据插入到 Student 表中
 *
 * @author Fqq
 */
public class InsertStudentDatabase {
    private static final Random random = new Random();
    private static Connection connection;

    public static void connect() throws Exception {
        connection = JDBCUtils.getConnection();
    }

    public static void main(String[] args) throws Exception {
        connect();
        // 每一次批量新增的数据量
        int batchLength = 2000;
        // 新增多少次
        int multiple = 1000;
        InsertStudentDatabase instance = new InsertStudentDatabase();
        for (int i = 0; i < multiple; i++) {
            String sql = instance.insertIntoStudent(batchLength);
            System.out.println("sql: " + sql);
            insert(sql);
        }
    }

    /**
     * 生成用于批量插入的 SQL 语句，数据量由 batchLength 决定
     *
     * @param batchLength 数据量
     * @return SQL
     */
    private String insertIntoStudent(int batchLength) {
        List<String> course = List.of("语文", "数学", "英语", "物理", "化学", "生物", "政治", "历史", "地理", "体育");

        ArrayList<Student> students = new ArrayList<>(batchLength);
        for (int i = 0; i < batchLength; i++) {
            Student student = new Student();
            student.setName(NameUtil.getXing() + NameUtil.getMing());
            student.setCourse(course.get(random.nextInt(course.size())));
            student.setGrade(random.nextInt(101));
            student.setIsPassed(random.nextInt(0, 2) == 0 ? "false" : "true");
            students.add(student);
        }
        return generateSQLForBatchInsert(Student.class.getSimpleName(), students);
    }


    /**
     * 执行语句
     *
     * @param sql SQL
     */
    private static void insert(String sql) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int count = statement.executeUpdate();
            System.out.println("insert count: " + count);
        }
    }

    /**
     * 根据对象数组生成批量插入的 SQL 语句
     *
     * @param tableName 表名
     * @param instances 对象数组
     * @return SQL 语句
     */
    private <T> String generateSQLForBatchInsert(String tableName, List<T> instances) {
        if (instances == null || instances.isEmpty()) {
            throw new IllegalArgumentException("Cannot insert empty value");
        }
        Class<?> instanceClass = instances.get(1).getClass();
        List<Field> allFields = getAllFields(instanceClass);
        allFields.forEach(InsertStudentDatabase::setAccessible);

        // 拼接表字段列
        String tableColumnSegment = allFields.stream()
            .map(field -> toUnderscoreCase(field.getName()))
            .collect(Collectors.joining(",", "(", ")"));

        // 拼接要新增的数据
        String values = instances.stream()
            .map(instance ->
                allFields.stream()
                    .map(field -> {
                        try {
                            Object value = field.get(instance);
                            // 除了数字类型，其它类型统一加上双引号
                            if (value instanceof Number) {
                                return value.toString();
                            }
                            return "\"" + value + "\"";
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.joining(",", "(", ")"))
            ).collect(Collectors.joining(","));
        return String.format("insert into %s %s values %s", tableName, tableColumnSegment, values);
    }

    private static void setAccessible(Field field) {
        field.setAccessible(true);
    }

    /**
     * Get all fields include superclass
     *
     * @param clazz to get fields
     * @return all fields
     */
    private static <T> List<Field> getAllFields(Class<T> clazz) {
        ArrayList<Field> fields = new ArrayList<>();
        Class<?> currentClass = clazz;
        while (currentClass != Object.class) {
            fields.addAll(List.of(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        }
        return fields;
    }

    /**
     * Convert camelcase to underscore case
     */
    public static String toUnderscoreCase(String fieldName) {
        StringBuilder stringBuilder = new StringBuilder();
        // Do not add "_" for the first character.
        stringBuilder.append(Character.toLowerCase(fieldName.charAt(0)));
        for (int i = 1; i < fieldName.length(); i++) {
            char c = fieldName.charAt(i);
            if (Character.isLowerCase(c)) {
                stringBuilder
                    .append(c);
            } else {
                stringBuilder
                    .append("_")
                    .append(Character.toLowerCase(c));
            }
        }
        return stringBuilder.toString();
    }
}
