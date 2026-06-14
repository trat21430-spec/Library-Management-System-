# 🤖 Nhật Ký Sử Dụng AI — Member Management

> **Dự án:** Library Management System
> **Module:** Member Management
> **Phương pháp:** Lập trình hướng đối tượng (OOP) — 4 tính chất đầy đủ
> **Công cụ AI:** Claude Sonnet
> **Tổng thời gian:** ~5 giờ | **Số sessions:** 11

---

## 📌 Các tính chất OOP áp dụng

| Tính chất | Màu nhận diện | Thể hiện chính |
|---|---|---|
| Encapsulation | 🔴 | Private fields, getter/setter, tách class UI |
| Inheritance | 🟠 | `RegularMember` & `PremiumMember` extends `Member` |
| Polymorphism | 🔵 | `Map<String, Member>`, gọi method qua kiểu cha |
| Abstraction | 🟣 | Abstract class `Member`, 2 abstract method |

---

## Giai đoạn 1 — Phân tích & Thiết kế

### Session 1 — Thiết kế class diagram
> 🟠 Inheritance · 🟣 Abstraction · ⏱ ~25 phút

**Prompt gửi AI:**
> Tôi cần thiết kế class diagram cho phần Member Management. Có 2 loại thành viên: Regular (mượn tối đa 3 cuốn, phí 5.000đ/ngày) và Premium (5 cuốn, phí 2.500đ/ngày). Giúp tôi áp dụng đúng OOP, đặc biệt là Abstraction và Inheritance.

**AI đã hỗ trợ:**
- ✅ Đề xuất abstract class `Member` — không thể tạo đối tượng trực tiếp, buộc phải dùng qua subclass *(Abstraction)*
- ✅ Thiết kế quan hệ kế thừa: `RegularMember extends Member`, `PremiumMember extends Member` *(Inheritance)*
- ✅ Xác định thuộc tính chung đặt ở lớp cha: `memberId`, `name`, `phone`, `email`, `borrowedBooks`
- ✅ Xác định method abstract: `getBorrowLimit()` và `calculateFine()` — mỗi subclass tự override

**Ghi chú cá nhân:**
> Lần đầu tiếp cận abstract class. AI giải thích rõ: abstract dùng khi lớp cha không đủ thông tin để implement hàm — chỉ khai báo "phải có", con tự quyết định "làm thế nào". Hiểu ngay.

---

## Giai đoạn 2 — Lập trình các lớp cơ bản

### Session 2 — Viết abstract class Member
> 🔴 Encapsulation · 🟣 Abstraction · ⏱ ~40 phút

**Prompt gửi AI:**
> Viết abstract class Member trong Java với đầy đủ private fields, getter/setter, constructor. Áp dụng Encapsulation chặt chẽ. Khai báo 2 abstract method: getBorrowLimit() và calculateFine().

**AI đã hỗ trợ:**
- ✅ Toàn bộ fields đặt `private`, chỉ truy cập qua getter/setter — đúng chuẩn Encapsulation
- ✅ Khai báo `abstract long calculateFine(long days)` và `abstract int getBorrowLimit()` không có thân hàm
- ✅ Thêm validation trong setter: `name` không được rỗng, `email` phải chứa "@"
- ✅ Override `toString()` để in thông tin member dạng bảng

**Kết quả code (đã chỉnh sửa một phần):**

```java
public abstract class Member {
    private String memberId;
    private String name;
    private String phone;
    private String email;
    private List<String> borrowedBooks;

    // Encapsulation: chỉ truy cập qua getter/setter
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Tên không được rỗng");
        this.name = name;
    }

    // Abstraction: subclass bắt buộc phải override
    public abstract int getBorrowLimit();
    public abstract long calculateFine(long daysOverdue);
}
```

---

### Session 3 — Viết RegularMember và PremiumMember
> 🟠 Inheritance · 🔵 Polymorphism · ⏱ ~35 phút

**Prompt gửi AI:**
> Viết 2 subclass RegularMember và PremiumMember kế thừa Member. Override getBorrowLimit() và calculateFine() cho từng loại. PremiumMember tính phí giảm 50%.

**AI đã hỗ trợ:**
- ✅ Cả 2 class dùng `extends Member`, gọi `super(id, name, phone, email)` trong constructor *(Inheritance)*
- ✅ Override `calculateFine()`: Regular = `days × 5000`, Premium = `days × 2500` *(Polymorphism)*
- ✅ Override `getBorrowLimit()`: Regular trả về 3, Premium trả về 5
- ✅ Thêm annotation `@Override` để trình biên dịch kiểm tra đúng tên method

**Kết quả code:**

```java
public class PremiumMember extends Member {
    public PremiumMember(String id, String name,
                          String phone, String email) {
        super(id, name, phone, email); // Inheritance
    }

    @Override
    public int getBorrowLimit() { return 5; } // Polymorphism

    @Override
    public long calculateFine(long daysOverdue) {
        return daysOverdue * 2500; // giảm 50%
    }
}
```

**Ghi chú cá nhân:**
> Lần đầu dùng `@Override` — AI giải thích: nếu viết sai tên hàm thì compiler báo lỗi ngay, thay vì âm thầm tạo hàm mới. Rất hữu ích.

---

## Giai đoạn 3 — Xây dựng MemberManager

### Session 4 — Viết class MemberManager
> 🔵 Polymorphism · 🔴 Encapsulation · ⏱ ~40 phút

**Prompt gửi AI:**
> Viết class MemberManager dùng HashMap lưu trữ. Các method: addMember, updateMember, removeMember, searchByName, searchById, getAllMembers. Dùng kiểu Member ở chỗ nào có thể để tận dụng Polymorphism.

**AI đã hỗ trợ:**
- ✅ Khai báo `Map<String, Member>` — key là memberId, value kiểu `Member` để chứa cả Regular lẫn Premium *(Polymorphism)*
- ✅ Method `addMember(Member m)` nhận vào kiểu cha — không cần biết cụ thể là loại nào
- ✅ Custom exception: `MemberNotFoundException`, `DuplicateMemberException`
- ✅ `removeMember()` kiểm tra `borrowedBooks.isEmpty()` trước khi xóa (BR3)
- ✅ `searchByName()` dùng stream, so sánh không phân biệt hoa thường

**Kết quả code:**

```java
// Polymorphism: dùng kiểu cha Member
private Map<String, Member> members = new HashMap<>();

public void addMember(Member member) throws DuplicateMemberException {
    if (members.containsKey(member.getMemberId()))
        throw new DuplicateMemberException("ID đã tồn tại: " + member.getMemberId());
    members.put(member.getMemberId(), member);
}

// Khi gọi calculateFine() — Java tự chọn đúng version
public long calcFine(String memberId, long days) {
    Member m = members.get(memberId);
    return m.calculateFine(days); // Polymorphism tại đây
}
```

---

### Session 5 — Tích hợp Business Rules vào MemberManager
> 🔴 Encapsulation · ⏱ ~30 phút

**Prompt gửi AI:**
> Viết phần kiểm tra Business Rules trong MemberManager: BR1 (ID duy nhất), BR2 (tên không rỗng), BR5 (không vượt giới hạn mượn). Tích hợp validate vào từng method.

**AI đã hỗ trợ:**
- ✅ Method private `validateMember(Member m)` gom toàn bộ kiểm tra vào một chỗ *(Encapsulation)*
- ✅ BR5: `member.getBorrowedBooks().size() >= member.getBorrowLimit()` — gọi qua interface chung
- ✅ Ném `IllegalArgumentException` với message rõ ràng khi vi phạm

---

## Giai đoạn 4 — Xử lý lỗi & Debug

### Session 6 — Debug NullPointerException
> ⏱ ~20 phút

**Prompt gửi AI:**
> Bị lỗi NullPointerException ở dòng members.put() khi thêm thành viên đầu tiên. Stack trace: [dán vào]. Tìm giúp tôi.

**AI đã hỗ trợ:**
- ✅ Chỉ ra: `members` chưa được khởi tạo trong constructor của `MemberManager`
- ✅ Fix: thêm `this.members = new HashMap<>();` vào constructor
- ✅ Gợi ý: dùng field initializer `= new HashMap<>()` ngay khi khai báo để tránh quên

**Ghi chú cá nhân:**
> Lỗi đơn giản nhưng mất 15 phút tự tìm không ra vì nhìn mãi vào dòng `put()` thay vì nhìn vào khai báo. AI chỉ đúng chỗ ngay lần đầu.

---

### Session 7 — Debug lỗi Polymorphism bị phá vỡ
> 🔵 Polymorphism · ⏱ ~25 phút

**Prompt gửi AI:**
> Khi tính phí phạt, cả Regular lẫn Premium đều ra cùng mức phí. Tôi đã override calculateFine() rồi mà vẫn vậy. [dán code]

**AI đã hỗ trợ:**
- ✅ Phát hiện: code đang gọi `((RegularMember) member).calculateFine()` — ép kiểu cứng nên luôn dùng Regular
- ✅ Fix: bỏ ép kiểu, gọi thẳng `member.calculateFine(days)` qua biến kiểu cha — Java tự dispatch đúng version
- ✅ Giải thích dynamic dispatch: JVM quyết định gọi hàm nào lúc chạy dựa trên kiểu thực tế của object

**Ghi chú cá nhân:**
> Đây là bug giúp hiểu sâu nhất về Polymorphism. Ép kiểu thủ công là phá vỡ polymorphism — cần để Java tự xử lý.

---

## Giai đoạn 5 — File I/O & Giao diện Console

### Session 8 — Lưu/đọc dữ liệu Member từ file
> 🔵 Polymorphism · ⏱ ~35 phút

**Prompt gửi AI:**
> Viết hàm lưu/đọc dữ liệu Member từ file txt. Khi đọc phải phân biệt RegularMember hay PremiumMember và tạo đúng đối tượng tương ứng.

**AI đã hỗ trợ:**
- ✅ Format CSV: `TYPE,ID,NAME,PHONE,EMAIL` — TYPE là "REGULAR" hoặc "PREMIUM"
- ✅ Khi đọc: switch theo TYPE để `new RegularMember(...)` hoặc `new PremiumMember(...)`, rồi `addMember(m)` *(Polymorphism)*
- ✅ Dùng try-with-resources cho `BufferedReader` / `BufferedWriter`
- ✅ Xử lý file không tồn tại ở lần chạy đầu tiên (không throw exception)

**Kết quả code:**

```java
// Đọc file — tạo đúng subclass theo TYPE
String type = parts[0];
Member m = switch (type) {
    case "REGULAR" -> new RegularMember(parts[1], parts[2], parts[3], parts[4]);
    case "PREMIUM" -> new PremiumMember(parts[1], parts[2], parts[3], parts[4]);
    default -> throw new IllegalArgumentException("Loại thành viên không hợp lệ");
};
manager.addMember(m);
```

**Format lưu file:**

```
REGULAR,M001,Nguyen Van A,0901234567,a@email.com
PREMIUM,M002,Tran Thi B,0912345678,b@email.com
```

---

### Session 9 — Viết giao diện console MemberUI
> 🔴 Encapsulation · ⏱ ~30 phút

**Prompt gửi AI:**
> Viết phần giao diện console cho Member Management: menu thêm/sửa/xóa/tìm kiếm, validate input từ bàn phím, hiển thị thông báo thành công/thất bại đúng format đề bài.

**AI đã hỗ trợ:**
- ✅ Tách class `MemberUI` riêng — giao diện không lẫn vào logic *(Encapsulation)*
- ✅ Dùng `Scanner` với vòng lặp do-while cho menu, thoát khi chọn "Back"
- ✅ Validate input: `trim()`, kiểm tra rỗng, parse int có try-catch
- ✅ In bảng danh sách member với format cột cố định bằng `printf`

---

## Giai đoạn 6 — Kiểm thử & Hoàn thiện

### Session 10 — Liệt kê test case
> ⏱ ~20 phút

**Prompt gửi AI:**
> Liệt kê các test case cần kiểm tra cho Member Management để chắc chắn không bỏ sót Business Rule nào.

**AI đã hỗ trợ:**
- ✅ Thêm member ID trùng → phải báo lỗi (BR1)
- ✅ Thêm member tên rỗng → phải báo lỗi (BR2)
- ✅ Xóa member đang có sách mượn → phải từ chối (BR3)
- ✅ Regular mượn quá 3 cuốn → phải từ chối (BR5)
- ✅ Premium mượn tới 5 cuốn → phải cho phép (BR5)
- ✅ Tính phí phạt Regular vs Premium cùng số ngày → phải khác nhau
- ✅ Lưu file rồi đọc lại → dữ liệu phải khớp hoàn toàn

---

### Session 11 — Review toàn bộ OOP & Business Rules
> 🔴 Encapsulation · 🟠 Inheritance · 🔵 Polymorphism · 🟣 Abstraction · ⏱ ~25 phút

**Prompt gửi AI:**
> Review toàn bộ code phần Member Management. Kiểm tra đủ 4 tính chất OOP và tất cả Business Rules BR1–BR9 chưa. [dán toàn bộ code]

**AI đã hỗ trợ:**
- ✅ Encapsulation: tất cả fields đều private, có getter/setter — ✅ đạt
- ✅ Inheritance: RegularMember và PremiumMember kế thừa đúng từ Member — ✅ đạt
- ✅ Polymorphism: `Map<String, Member>` và gọi `calculateFine()` qua kiểu cha — ✅ đạt
- ✅ Abstraction: abstract class với 2 abstract method — ✅ đạt
- ✅ Phát hiện: thiếu check tràn danh sách khi `addBorrowedBook()` — đã sửa thêm guard check size
- ✅ Gợi ý thêm Javadoc cho các public method quan trọng

**Ghi chú cá nhân:**
> Session review cuối rất quan trọng — phát hiện 1 edge case bị bỏ sót. Sau khi sửa xong, toàn bộ test case đều pass.

---

## Tổng kết

| Chỉ số | Kết quả |
|---|---|
| Tổng số sessions | 11 |
| Tổng thời gian | ~5 giờ |
| Bug được AI tìm ra | 2 (NullPointerException + Polymorphism bị phá vỡ) |
| Điểm thiếu sót phát hiện | 1 (guard check addBorrowedBook) |
| Tính chất OOP hoàn thành | 4/4 |

### Đánh giá chung

AI hỗ trợ hiệu quả nhất ở 3 giai đoạn: **thiết kế ban đầu** (giúp chọn đúng cấu trúc), **debug** (chỉ ra nguyên nhân nhanh và giải thích rõ), và **review cuối** (phát hiện điểm thiếu sót). Bug ở Session 7 (ép kiểu phá vỡ Polymorphism) là bài học đáng nhớ nhất — giúp hiểu sâu hơn về dynamic dispatch trong Java.

Không dùng AI như máy chép code — chủ yếu dùng để hiểu concept, kiểm tra logic và học từ lỗi.
