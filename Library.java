import java.util.ArrayList;
import java.util.List;

/**
 * Lớp Library dùng để quản lý danh sách các tài liệu.
 */
public class Library {
    private List<LibraryItem> items;

    /**
     * Khởi tạo thư viện rỗng.
     */
    public Library() {
        items = new ArrayList<>();
    }

    /**
     * Thêm một tài liệu vào thư viện.
     * @param item tài liệu cần thêm
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Xóa một tài liệu khỏi thư viện.
     * @param item tài liệu cần xóa
     */
    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    /**
     * Trả về danh sách các tài liệu có cùng tác giả.
     * @param author tên tác giả cần tìm
     * @return danh sách tài liệu
     */
    public List<LibraryItem> getItemsByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.author.equalsIgnoreCase(author)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Tính tổng phí trễ của tất cả tài liệu trong thư viện.
     * @param days số ngày bị trễ
     * @return tổng phí
     */
    public double getTotalLateFee(int days) {
        double total = 0;
        for (LibraryItem item : items) {
            total += item.calculateLateFee(days);
        }
        return total;
    }

    /**
     * Trả về thông tin toàn bộ tài liệu trong thư viện.
     * @return chuỗi thông tin
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder("Library Inventory:\n");
        for (LibraryItem item : items) {
            sb.append(item.getInfo()).append("\n");
        }
        return sb.toString().trim();
    }
}
