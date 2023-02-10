package jdbc;

public class Book {
    private  int serial_no;
    private String BookName;

    public Book(int serial_no, String bookName) {
        this.serial_no = serial_no;
        BookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "serial_no=" + serial_no +
                ", BookName='" + BookName + '\'' +
                '}';
    }
}
