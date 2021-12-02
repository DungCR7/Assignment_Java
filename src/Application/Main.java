package Application;
import java.util.Scanner;
import Application.Main;
import Library.Book;
import Library.Document;
import Library.Journal;
import Library.ManagerDocument;
import Library.Newspaper;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerDocument managerDocument = new ManagerDocument();
        while (true) {
            System.out.println("Application Manager Book");
            System.out.println("Nhập số 1: Chèn sách");
            System.out.println("Nhập số 2: Tìm kiếm tài liệu theo danh mục: ");
            System.out.println("Nhập số 3: Hiển thị thông tin sách:");
            System.out.println("Nhập số 4: Xóa tài liệu theo ID");
            System.out.println("Nhập số 5: Thoát ra:");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Nhập a: Chèn sách");
                    System.out.println("Nhập b: Chèn báo");
                    System.out.println("Nhập c: Chèn tạp chí");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.print("Nhập ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Nhập NXB:");
                            String nxb = scanner.nextLine();
                            System.out.print("Nhập số: ");
                            int number = scanner.nextInt();
                            System.out.print("Nhập tác giả: ");
                            scanner.nextLine();
                            String author = scanner.nextLine();
                            System.out.print("Nhập số trang: ");
                            int pageNumber = scanner.nextInt();
                            Book book = new Book(id, nxb, number, author, pageNumber);
                            managerDocument.addDocument(book);
                            System.out.println(book.toString());
                            scanner.nextLine();
                            break;

                        }
                        case "b": {
                            System.out.print("Nhập ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Nhập NXB :");
                            String nxb = scanner.nextLine();
                            System.out.print("Nhập số: ");
                            int number = scanner.nextInt();
                            System.out.print("Nhập số phát hành: ");
                            int dayIssue = scanner.nextInt();
                            Document newspaper = new Newspaper(id, nxb, number, dayIssue);
                            managerDocument.addDocument(newspaper);
                            System.out.println(newspaper.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "c": {
                            System.out.print("Nhập ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Nhập NXB:");
                            String nxb = scanner.nextLine();
                            System.out.print("Nhập số: ");
                            int number = scanner.nextInt();
                            System.out.print("Nhập số phát hành : ");
                            int issueNumber = scanner.nextInt();
                            System.out.print("Nhập tháng phát hành : ");
                            int issueMonth = scanner.nextInt();
                            Document journal = new Journal(id, nxb, number, issueNumber, issueMonth);
                            managerDocument.addDocument(journal);
                            System.out.println(journal.toString());
                            scanner.nextLine();
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "2": {
                    System.out.println("Nhập a để tìm kiếm sách");
                    System.out.println("Nhập b để tìm kiếm báo");
                    System.out.println("Nhập c để tìm kiếm tạp chí");
                    String choise = scanner.nextLine();
                    switch (choise) {
                        case "a": {
                            managerDocument.searchByBook();
                            break;
                        }
                        case "b": {
                            managerDocument.searchByNewspaper();
                            break;
                        }
                        case "c":
                            managerDocument.searchByJournal();
                            break;
                        default:
                            System.out.println("Nhập dữ liệu sai");
                            break;
                    }
                    break;
                }
                case "3": {
                    managerDocument.showInfor();
                    break;
                }
                case "4": {
                    System.out.print("Nhập ID để xóa: ");
                    String id = scanner.nextLine();
                    System.out.println(managerDocument.deleteDocument(id) ? "Done" : "Sai rồi thử lại đi");
                }
                break;
                case "5": {
                    return;
                }
                default:
                    System.out.println("Nhập dữ liệu sai");
                    continue;
            }

        }
    }
}
