# 🤖 Nhật Ký Sử Dụng AI — Member Management

> **Dự án:** Library Management System  
> **Module:** Member Management  
> **Công cụ AI:** Claude Sonnet  
> **Tổng thời gian:** ~2.5 giờ | **Số sessions:** 6

---

## Session 1 — Thiết kế Class Diagram

| | |
|---|---|
| **Loại** | Thiết kế |
| **Thời lượng** | ~25 phút |

### Prompt gửi AI

> Tôi đang làm bài tập OOP Java về hệ thống thư viện. Phần Member Management cần có RegularMember và PremiumMember. Hãy giúp tôi thiết kế class diagram cho phần này, áp dụng Inheritance và Polymorphism đúng cách.

### AI hỗ trợ

- ✅ Đề xuất cấu trúc abstract class `Member` với các field cơ bản: `memberId`, `name`, `phone`, `email`, `borrowedBooks`
- ✅ Hướng dẫn tách method `calculateFine()` và `getBorrowLimit()` thành abstract để override ở subclass
- ✅ Giải thích lý do dùng `List<String>` thay vì mảng để lưu `borrowedBooks`

### Ghi chú cá nhân

> Ban đầu định để `Member` là class thường, AI giải thích vì sao nên dùng abstract → thuyết phục, áp dụng theo.

---

## Session 2 — Viết code 3 class Member

| | |
|---|---|
| **Loại** | Lập trình |
| **Thời lượng** | ~40 phút |

### Prompt gửi AI

> Viết cho tôi class Member (abstract), RegularMember và PremiumMember trong Java. PremiumMember được mượn tối đa 5 cuốn và phí phạt giảm 50% so với Regular. Áp dụng Encapsulation đầy đủ.

### AI hỗ trợ

- ✅ Sinh code đầy đủ 3 class với getter/setter, constructor, `toString()`
- ✅ Override `calculateFine(long days)`: Regular = days × 5.000, Premium = days × 2.500
- ✅ Thêm validation trong setter (email format, phone không rỗng)

### Kết quả code (đã chỉnh sửa một phần)

```java
public abstract class Member {
    private String memberId;
    private String name;
    private List<String> borrowedBooks;

    public abstract int getBorrowLimit();
    public abstract long calculateFine(long daysOverdue);
}
```

### Ghi chú cá nhân

> Code AI sinh ra dùng được ~80%, tự sửa lại phần validation email vì yêu cầu đề bài không cần phức tạp vậy.

---

## Session 3 — Viết MemberManager

| | |
|---|---|
| **Loại** | Lập trình |
| **Thời lượng** | ~30 phút |

### Prompt gửi AI

> Viết các method cho lớp MemberManager: addMember, updateMember, removeMember, searchByName, searchById. Dùng HashMap lưu trữ. Xử lý exception khi member không tồn tại hoặc ID bị trùng.

### AI hỗ trợ

- ✅ Cài đặt `HashMap<String, Member>` với key là `memberId`
- ✅ Custom exception `MemberNotFoundException` và `DuplicateMemberException`
- ✅ `searchByName` dùng stream filter, không phân biệt hoa thường
- ✅ `removeMember` kiểm tra `borrowedBooks` trống trước khi xóa (BR3)

---

## Session 4 — Debug NullPointerException

| | |
|---|---|
| **Loại** | Debug |
| **Thời lượng** | ~20 phút |

### Prompt gửi AI

> Khi chạy chương trình, sau khi nhập thông tin member và bấm Save thì bị lỗi NullPointerException ở dòng members.put(). Đây là stack trace: [dán stack trace]. Giúp tôi tìm lỗi.

### AI hỗ trợ

- ✅ Chỉ ra nguyên nhân: `HashMap` chưa được khởi tạo trong constructor của `MemberManager`
- ✅ Fix: thêm `this.members = new HashMap<>();` vào constructor
- ✅ Gợi ý thêm null-check trước khi `put` để tránh lỗi tương tự

### Ghi chú cá nhân

> Lỗi đơn giản nhưng mất 15 phút tìm không ra. AI giải thích rõ nguyên nhân giúp hiểu hơn thay vì chỉ fix.

---

## Session 5 — File I/O lưu dữ liệu Member

| | |
|---|---|
| **Loại** | Lập trình |
| **Thời lượng** | ~35 phút |

### Prompt gửi AI

> Viết phần lưu và đọc dữ liệu Member từ file txt (file I/O). Mỗi dòng lưu một member theo format CSV. Khi đọc phải phân biệt được RegularMember hay PremiumMember.

### AI hỗ trợ

- ✅ Format CSV: `TYPE,ID,NAME,PHONE,EMAIL` — TYPE là `"REGULAR"` hoặc `"PREMIUM"`
- ✅ `saveToFile()` dùng `BufferedWriter`, `loadFromFile()` dùng `BufferedReader`
- ✅ Xử lý `IOException` và gợi ý dùng try-with-resources

### Format lưu file

```
REGULAR,M001,Nguyen Van A,0901234567,a@email.com
PREMIUM,M002,Tran Thi B,0912345678,b@email.com
```

---

## Session 6 — Review toàn bộ code

| | |
|---|---|
| **Loại** | Review |
| **Thời lượng** | ~20 phút |

### Prompt gửi AI

> Review toàn bộ code phần Member Management của tôi. Kiểm tra xem đã đáp ứng đủ yêu cầu OOP (Encapsulation, Inheritance, Polymorphism) và Business Rules chưa. [dán code]

### AI hỗ trợ

- ✅ Xác nhận đã đáp ứng đủ 3 OOP concepts theo yêu cầu đề bài
- ✅ Phát hiện thiếu kiểm tra BR5 (giới hạn mượn) trong `addBorrowedBook()`
- ✅ Gợi ý đổi tên biến `lst` → `borrowedBooks` cho rõ nghĩa hơn
- ✅ Nhắc thêm Javadoc cho các public method

### Ghi chú cá nhân

> Nhờ review mới phát hiện thiếu kiểm tra BR5 — lỗi logic quan trọng mà tự đọc lại không thấy. Đã sửa ngay sau session này.

---

## Tổng kết

| Chỉ số | Kết quả |
|---|---|
| Tổng số sessions | 6 |
| Tổng thời gian | ~2.5 giờ |
| Bug được AI tìm ra | 1 (NullPointerException) |
| Business Rule bị bỏ sót | 1 (BR5 — giới hạn mượn) |

### Đánh giá chung

AI hỗ trợ hiệu quả nhất ở giai đoạn **thiết kế ban đầu** và **review cuối**. Phần sinh code cần tự chỉnh sửa khoảng 20% cho phù hợp yêu cầu cụ thể của đề bài. Không dùng AI như máy chép code — chủ yếu dùng để hiểu concept và kiểm tra lại logic.
