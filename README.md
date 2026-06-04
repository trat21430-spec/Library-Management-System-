# 📚 Library Management System

Hệ thống quản lý thư viện cộng đồng dựa trên console, xây dựng bằng Java với các nguyên tắc OOP.

---

## 📋 Mô tả dự án

Dự án mô phỏng hệ thống quản lý thư viện cho phép nhân viên thư viện xử lý toàn bộ hoạt động hàng ngày: quản lý sách, quản lý thành viên, mượn/trả sách và tạo báo cáo thống kê. Mục tiêu là thay thế quy trình thủ công bằng một hệ thống máy tính hóa, chính xác và dễ sử dụng.

---

## ✨ Tính năng chính

### 📖 Quản lý Sách
- Thêm sách mới (ID, tiêu đề, tác giả, thể loại, năm xuất bản, số lượng)
- Cập nhật thông tin sách
- Xóa sách (chỉ khi không có ai đang mượn)
- Xem danh sách toàn bộ sách
- Tìm kiếm theo tiêu đề, tác giả hoặc thể loại

### 👤 Quản lý Thành viên
- Đăng ký thành viên mới (ID, tên, số điện thoại, email)
- Cập nhật thông tin thành viên
- Xóa thành viên (chỉ khi không còn sách đang mượn)
- Xem danh sách thành viên
- Tìm kiếm theo tên hoặc ID

### 🔄 Mượn / Trả Sách
- Ghi nhận mượn sách (ID sách, ID thành viên, ngày mượn)
- Ghi nhận trả sách và tính phí phạt nếu trễ hạn
- Xem danh sách sách đang được mượn
- Xem lịch sử mượn sách của từng thành viên

### 📊 Báo cáo
- Danh sách sách đang được mượn
- Danh sách sách quá hạn
- Sách được mượn nhiều nhất
- Thành viên mượn sách nhiều nhất

---

## ⚙️ Quy tắc nghiệp vụ

| Mã | Quy tắc |
|----|---------|
| BR1 | Book ID và Member ID phải duy nhất, không được thay đổi |
| BR2 | Tiêu đề, tác giả và thể loại sách không được để trống |
| BR3 | Thành viên phải tồn tại trước khi mượn sách |
| BR4 | Sách chỉ được mượn khi còn tồn kho (qty > 0) |
| BR5 | Mỗi thành viên không được mượn quá giới hạn cho phép (mặc định: 3 cuốn) |
| BR6 | Ngày mượn ≤ hiện tại; ngày trả phải sau ngày mượn |
| BR7 | Phí phạt trễ hạn: **5.000 VND/ngày** |
| BR8 | Số lượng sách giảm khi mượn, tăng khi trả |
| BR9 | Toàn bộ đầu vào phải được kiểm tra hợp lệ trước khi xử lý |
| BR10 | Sách phổ biến được xếp hạng theo tổng số lần mượn |

---

## 🏗️ Kiến trúc OOP

```
├── Book                        # Thông tin sách
├── Member (abstract)           # Thành viên (lớp cha)
│   ├── RegularMember           # Thành viên thường
│   └── PremiumMember           # Thành viên cao cấp (giới hạn mượn & phí phạt khác)
├── BorrowingTransaction        # Giao dịch mượn/trả
├── LibraryManager              # Quản lý tập hợp sách, thành viên, giao dịch
└── Main                        # Điểm khởi chạy & giao diện console
```

**Các khái niệm OOP áp dụng:**
- **Encapsulation** — Đóng gói dữ liệu trong các lớp `Book`, `Member`, `BorrowingTransaction`
- **Inheritance** — `RegularMember` và `PremiumMember` kế thừa từ `Member`
- **Polymorphism** — Override phương thức `calculateFine()` theo từng loại thành viên
- **Collections** — Dùng `List` / `Map` để lưu trữ dữ liệu
- **Exception Handling** — Xử lý lỗi đầu vào, sách/thành viên không tồn tại

---

## 🖥️ Giao diện Console

```
======================================
     LIBRARY MANAGEMENT SYSTEM
======================================
1. Manage Books
2. Manage Members
3. Borrowing/Returning
4. Reports
5. Exit
--------------------------------------
Choose an option: _
```

