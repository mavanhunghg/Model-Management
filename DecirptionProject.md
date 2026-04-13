TRƯỜNG ĐẠI HỌC

**KHOA CÔNG NGHỆ THÔNG TIN**

────────────────────────────────────

**BÁO CÁO ĐỒ ÁN MÔN HỌC**

Kiến Trúc và Thiết Kế Phần Mềm

**NHẬN DẠNG VÀ THÔNG BÁO BIỂN BÁO GIAO THÔNG**

| **Module báo cáo:**      | (1) Quản lý mô hình đã huấn luyện             |
| ------------------------ | --------------------------------------------- |
|                          | (2) Thống kê mô hình học máy                  |
| **Kiến trúc:**           | Microservices - Spring Boot · ReactJS · MySQL |
| **Ràng buộc kiến trúc:** | **Không sử dụng DTO - trả thẳng Entity**      |

# MỤC LỤC

[MỤC LỤC 2](#_Toc226989604)

[PHẦN 1: MÔ TẢ HOẠT ĐỘNG CÁC MODULE 4](#_Toc226989605)

[1.1. Module 1 - Quản Lý Mô Hình Đã Huấn Luyện 4](#_Toc226989606)

[1.1.1. Mục Đích 4](#_Toc226989607)

[1.1.2. Tác Nhân (Actor) 4](#_Toc226989608)

[1.1.3. Điều Kiện Tiên Quyết 4](#_Toc226989609)

[1.1.4. Luồng Hoạt Động Chính (Happy Path) 4](#_Toc226989610)

[UC-M1-01: Xem Danh Sách Mô Hình 4](#_Toc226989611)

[UC-M1-02: Thêm Mới Mô Hình (Manual Entry) 4](#_Toc226989612)

[UC-M1-03: Cập Nhật Thông Tin Mô Hình 5](#_Toc226989613)

[UC-M1-04: Xóa Mô Hình 5](#_Toc226989614)

[UC-M1-05: Kích Hoạt Mô Hình (Set Active) - Chức Năng Quan Trọng Nhất 5](#_Toc226989615)

[UC-M1-06: Retrain Mô Hình - Huấn Luyện Lại Từ Mô Hình Hiện Có 6](#_Toc226989616)

[1.1.5. Luồng Ngoại Lệ 7](#_Toc226989617)

[1.2. Module 2 - Thống Kê Mô Hình Học Máy 7](#_Toc226989618)

[1.2.1. Mục Đích 7](#_Toc226989619)

[1.2.2. Tác Nhân 7](#_Toc226989620)

[1.2.3. Điều Kiện Tiên Quyết 8](#_Toc226989621)

[1.2.4. Luồng Hoạt Động Chính 8](#_Toc226989622)

[1.2.5. Luồng Ngoại Lệ 8](#_Toc226989623)

[PHẦN 2: THIẾT KẾ THỰC THỂ (ENTITY DESIGN) 9](#_Toc226989624)

[2.1. Chi Tiết Entity - Model Management Service 9](#_Toc226989625)

[Entity: Model 9](#_Toc226989626)

[Entity: ModelArtifact 10](#_Toc226989627)

[2.2. Chi Tiết Entity - Statistics Service 10](#_Toc226989628)

[Entity: TrainingSession 10](#_Toc226989629)

[2.3. Biểu Đồ Lớp Entity - Model Management Service 11](#_Toc226989630)

[2.4. Biểu Đồ Lớp Entity - Statistics Service 12](#_Toc226989631)

[2.5. Biểu Đồ Tổng Quan - Quan Hệ Giữa Các Service 13](#_Toc226989632)

[PHẦN 3: THIẾT KẾ CƠ SỞ DỮ LIỆU 15](#_Toc226989633)

[3.1. Pattern Database-per-Service 15](#_Toc226989634)

[3.2. Schema model_mgmt_db 15](#_Toc226989635)

[Bảng: models 15](#_Toc226989636)

[Bảng: model_artifacts 16](#_Toc226989637)

[3.3. Schema statistics_db 16](#_Toc226989638)

[Bảng: training_sessions 16](#_Toc226989639)

[PHẦN 4: THIẾT KẾ CHI TIẾT - MODULE 1 (QUẢN LÝ MÔ HÌNH) 18](#_Toc226989640)

[4.1. Thiết Kế Giao Diện 18](#_Toc226989641)

[4.1.1. Màn Hình Danh Sách Mô Hình 18](#_Toc226989642)

[4.1.2. Form Thêm Mới / Chỉnh Sửa (Modal Dialog) 18](#_Toc226989643)

[4.1.3. Nút Kích Hoạt, Retrain và Xóa 18](#_Toc226989644)

[4.1.4. Modal Retrain 19](#_Toc226989645)

[4.2. Thiết Kế Biểu Đồ Lớp - Module 1 19](#_Toc226989646)

[4.2.1. Phân Tích Builder Pattern 19](#_Toc226989647)

[4.2.2. Mã Mermaid - Biểu Đồ Lớp Module 1 20](#_Toc226989648)

[4.3. Thiết Kế Biểu Đồ Tuần Tự - Module 1 22](#_Toc226989649)

[4.4. Thiết Kế Biểu Đồ Tuần Tự - Luồng Retrain Mô Hình 22](#_Toc226989650)

[PHẦN 5: THIẾT KẾ CHI TIẾT - MODULE 2 (THỐNG KÊ MÔ HÌNH) 25](#_Toc226989651)

[5.1. Thiết Kế Giao Diện Dashboard 25](#_Toc226989652)

[5.1.1. Khu Vực Thẻ KPI Số (4 thẻ ngang) 25](#_Toc226989653)

[5.1.2. Bảng Data Table Chi Tiết 25](#_Toc226989654)

[5.2. Thiết Kế Biểu Đồ Lớp - Module 2 25](#_Toc226989655)

[5.2.1. Phân Tích Facade Pattern 25](#_Toc226989656)

[5.2.2. Phân Tích Singleton Pattern 26](#_Toc226989657)

[5.2.3. Mã Mermaid - Biểu Đồ Lớp Module 2 26](#_Toc226989658)

[5.3. Thiết Kế Biểu Đồ Tuần Tự - Module 2 28](#_Toc226989659)

[KẾT LUẬN 30](#_Toc226989660)

# PHẦN 1: MÔ TẢ HOẠT ĐỘNG CÁC MODULE

Phần này đặc tả hành vi nghiệp vụ của từng module theo chuẩn Use Case Description, bao gồm: mục đích, tác nhân, điều kiện tiên quyết, luồng chính (Happy Path) và luồng ngoại lệ.

## 1.1. Module 1 - Quản Lý Mô Hình Đã Huấn Luyện

### 1.1.1. Mục Đích

Module cung cấp giao diện quản trị toàn bộ vòng đời của mô hình AI nhận dạng biển báo: từ khi Asynchronous Training Worker ghi kết quả huấn luyện vào database, qua các bước xem xét, cập nhật thông tin mô tả, cho đến khi mô hình được kích hoạt (Set Active) để hệ thống nhận dạng sử dụng, hoặc bị xóa/thay thế bởi phiên bản cải tiến.

### 1.1.2. Tác Nhân (Actor)

- **Admin / Quản trị viên:** Tác nhân chính, thực hiện toàn bộ thao tác CRUD và kích hoạt mô hình.
- **Asynchronous Training Worker:** Tác nhân hệ thống (Python script chạy offline), tự động ghi bản ghi mô hình mới vào database sau mỗi phiên huấn luyện.
- **API Gateway (Spring Cloud Gateway):** Trung gian xác thực JWT và định tuyến HTTP request từ ReactJS Client xuống Model Management Service.

### 1.1.3. Điều Kiện Tiên Quyết

- Admin đã đăng nhập và sở hữu JWT token hợp lệ với quyền ROLE_ADMIN.
- Model Management Service đang hoạt động và kết nối thành công đến schema model_mgmt_db.
- Ít nhất một phiên huấn luyện đã hoàn thành và Worker đã ghi dữ liệu mô hình vào database.

### 1.1.4. Luồng Hoạt Động Chính (Happy Path)

#### UC-M1-01: Xem Danh Sách Mô Hình

- Admin truy cập trang Quản lý mô hình trên giao diện ReactJS.
- Client gửi GET /api/models (kèm query params: taskType, status, page, size) đến API Gateway.
- Gateway xác thực JWT, định tuyến đến Model Management Service.
- Controller gọi ModelService.findAll(), trả về List&lt;Model&gt; (không qua DTO).
- Client nhận JSON array và render bảng dữ liệu với phân trang, bộ lọc trạng thái.

#### UC-M1-02: Thêm Mới Mô Hình (Manual Entry)

Dùng khi Admin cần đăng ký thủ công một mô hình nhập khẩu từ nguồn ngoài, ngoài luồng tự động của Worker.

- Admin nhấn "Thêm mới", điền form: tên, phiên bản, taskType, framework, algorithm, mô tả.
- Client gửi POST /api/models với JSON body.
- ModelService nhận Map&lt;String,Object&gt; requestBody, dùng Model.Builder để khởi tạo đối tượng Model qua từng bước (xem Mục 4.2).
- ModelRepository.save(model) - lưu DB, trạng thái mặc định INACTIVE.
- Controller trả về Model entity vừa lưu (HTTP 201) - không bọc DTO.
- Client cập nhật danh sách ngay lập tức.

#### UC-M1-03: Cập Nhật Thông Tin Mô Hình

- Admin chọn bản ghi, nhấn "Chỉnh sửa" - form hiện dữ liệu hiện tại.
- Admin thay đổi các trường cho phép (description, framework, version) và nhấn "Lưu".
- Client gửi PUT /api/models/{id}.
- Service tìm entity theo id, cập nhật trường thay đổi, gọi repository.save().
- Controller trả về Model entity đã cập nhật (HTTP 200).

#### UC-M1-04: Xóa Mô Hình

- Admin chọn bản ghi, nhấn "Xóa" - hệ thống hiển thị Confirmation Dialog.
- Admin xác nhận, Client gửi DELETE /api/models/{id}.
- Service kiểm tra is_active: nếu TRUE → từ chối (HTTP 409); nếu FALSE → tiếp tục.
- Service thực hiện soft-delete (cập nhật is_deleted = true, không xóa dữ liệu vật lý).
- Controller trả về HTTP 200 kèm thông báo thành công.

#### UC-M1-05: Kích Hoạt Mô Hình (Set Active) - Chức Năng Quan Trọng Nhất

Chính sách hệ thống: Tại mỗi thời điểm, chỉ tồn tại DUY NHẤT một mô hình ở trạng thái ACTIVE cho mỗi loại tác vụ (TaskType). Luồng này thực thi ràng buộc đó.

- Admin chọn mô hình INACTIVE, nhấn nút "Kích hoạt".
- Client gửi PATCH /api/models/{id}/activate.
- Service mở một @Transactional, thực hiện tuần tự:
  - Truy vấn tất cả Model có cùng taskType đang is_active = true.
  - Cập nhật toàn bộ chúng sang is_active = false, status = INACTIVE.
  - Cập nhật Model mục tiêu sang is_active = true, status = ACTIVE.
- Commit transaction; Controller trả về Model entity đã ACTIVE (HTTP 200).
- Client cập nhật badge trạng thái sang màu xanh "Đang hoạt động".

**➤ Lý do dùng @Transactional bắt buộc:**

Ba bước 3a-3c phải được thực thi như một đơn vị nguyên tử (atomic unit).

Nếu bước 3c thất bại sau khi 3b đã deactivate các mô hình khác, hệ thống sẽ

rơi vào trạng thái không có mô hình nào ACTIVE - gây lỗi nghiêm trọng cho

dịch vụ nhận dạng thực tế. Transaction đảm bảo rollback toàn bộ khi có lỗi.

#### UC-M1-06: Retrain Mô Hình - Huấn Luyện Lại Từ Mô Hình Hiện Có

Chức năng cho phép Admin yêu cầu huấn luyện lại một mô hình hiện có với dataset mới hoặc cấu hình hyperparameter khác, thay vì phải tạo mới hoàn toàn. Hệ thống sẽ tạo một phiên TrainingSession loại RETRAIN và dispatch sang Asynchronous Worker - toàn bộ quá trình huấn luyện vẫn chạy offline, ngoài luồng HTTP request.

- Admin chọn mô hình muốn retrain (bất kể trạng thái ACTIVE/INACTIVE), nhấn nút "Retrain".
- Hệ thống mở Modal Retrain, hiển thị thông tin mô hình gốc (tên, phiên bản, taskType) ở chế độ read-only.
- Admin chọn Dataset mới (Dropdown) và điền cấu hình hyperparameters (Learning Rate, Epochs, Batch Size) theo dạng JSON hoặc form fields. Nhấn "Bắt đầu Retrain".
- Client gửi POST /api/models/{id}/retrain với body: { datasetId, config: {...} }.
- Model Management Service thực hiện:
  - Validate mô hình gốc tồn tại và không đang trong trạng thái RETRAINING.
  - Cập nhật status của mô hình gốc → RETRAINING (để khóa, tránh retrain đồng thời).
  - Ghi bản ghi TrainingSession mới (trainingType=RETRAIN, parentModelId={id}, status=PENDING) vào statistics_db thông qua inter-service call sang Statistics Service.
  - Gửi message/task vào hàng đợi (Queue) để Asynchronous Worker nhận và bắt đầu huấn luyện.
- Controller trả về HTTP 202 Accepted kèm Model entity (status=RETRAINING) - không chờ kết quả huấn luyện.
- Client hiển thị badge "Đang retrain..." trên hàng mô hình, không block giao diện.
- (Nền) Worker hoàn thành huấn luyện, ghi kết quả vào TrainingSession, cập nhật status mô hình gốc về INACTIVE (phiên bản mới nếu có thì tạo Model record riêng).

**➤ Thiết kế luồng Retrain - điểm khác biệt so với train mới:**

1\. HTTP 202 ACCEPTED (không phải 200 OK): Retrain là tác vụ bất đồng bộ.

Client nhận phản hồi ngay lập tức, không chờ Worker chạy xong.

2\. STATUS RETRAINING: Model entity có thêm trạng thái RETRAINING để

ngăn Admin kích hoạt hay xóa mô hình trong khi đang huấn luyện lại.

3\. parentModelId: TrainingSession lưu ID mô hình gốc để truy vết lịch sử.

Khi retrain xong, Worker có thể tạo Model mới với version tăng lên,

hoặc cập nhật lại Model cũ - tuỳ chiến lược versioning của dự án.

4\. KHÔNG CHẠY CODE AI TRONG SERVICE: Service chỉ dispatch task sang Queue.

Worker Python nhận task từ Queue và thực thi script huấn luyện offline.

### 1.1.5. Luồng Ngoại Lệ

| **Tình huống**                        | **Điều kiện kích hoạt**                   | **Xử lý của hệ thống**                            |
| ------------------------------------- | ----------------------------------------- | ------------------------------------------------- |
| Mô hình không tồn tại                 | ID không hợp lệ hoặc is_deleted=true      | HTTP 404 Not Found                                |
| Xóa mô hình đang ACTIVE               | is_active = true khi gọi DELETE           | HTTP 409 Conflict - yêu cầu deactivate trước      |
| Retrain mô hình đang RETRAINING       | status = RETRAINING khi gọi POST /retrain | HTTP 409 Conflict - đã có phiên retrain đang chạy |
| Kích hoạt/Xóa mô hình đang RETRAINING | status = RETRAINING                       | HTTP 409 Conflict - chờ retrain hoàn thành        |
| Dataset không tồn tại khi retrain     | datasetId không hợp lệ                    | HTTP 400 Bad Request                              |
| Dữ liệu đầu vào thiếu/sai định dạng   | Thiếu trường bắt buộc hoặc sai kiểu       | HTTP 400 Bad Request + message chi tiết           |
| Lỗi database                          | Timeout hoặc connection refused           | HTTP 503 Service Unavailable                      |
| Transaction thất bại giữa chừng       | Lỗi khi ACTIVE mô hình mới                | Rollback toàn bộ, không thay đổi trạng thái       |

## 1.2. Module 2 - Thống Kê Mô Hình Học Máy

### 1.2.1. Mục Đích

Module cung cấp trang Dashboard phân tích hiệu suất tổng hợp của các phiên huấn luyện AI. Dữ liệu được Asynchronous Worker ghi trực tiếp vào bảng training_sessions (schema statistics_db); Statistics Service chỉ đọc, tính toán và trình bày - không bao giờ thực thi code huấn luyện. Để hiển thị tên mô hình đầy đủ (thay vì chỉ model_id), service thực hiện inter-service call đến Model Management Service.

### 1.2.2. Tác Nhân

- **Admin / Analyst:** Xem Dashboard để ra quyết định kích hoạt mô hình nào.
- **Statistics Service:** Truy vấn DB nội bộ, tính toán KPI, gọi API sang Model Management Service.
- **Model Management Service:** Phản hồi yêu cầu tra cứu tên mô hình theo model_id từ Statistics Service.
- **Asynchronous Training Worker:** Ghi dữ liệu accuracy, loss, duration vào bảng training_sessions sau mỗi phiên.

### 1.2.3. Điều Kiện Tiên Quyết

- Bảng training_sessions có ít nhất một bản ghi với status = COMPLETED.
- Statistics Service kết nối được đến statistics_db.
- Model Management Service đang online (nếu offline, hệ thống vẫn chạy với tên fallback).

### 1.2.4. Luồng Hoạt Động Chính

- Admin truy cập trang Dashboard Thống kê.
- Client gửi đồng thời: GET /api/statistics/summary và GET /api/statistics/sessions?page=0&size=20.
- API Gateway định tuyến cả hai đến Statistics Service.
- StatisticFacade điều phối: gọi TrainingSessionService.aggregate() lấy dữ liệu thô từ statistics_db.
- Với danh sách model_id thu được, ModelNameResolver gọi API nội bộ đến Model Management Service: GET /internal/models/names?ids=1,2,5.
- Model Management Service tra cứu model_mgmt_db, trả về Map&lt;Long,String&gt; { id→name }.
- StatisticFacade ghép tên vào dữ liệu thống kê, trả về thẳng List&lt;TrainingSession&gt; đã enrich (không DTO).
- Client render: 4 thẻ KPI số + bảng Data Table chi tiết.

### 1.2.5. Luồng Ngoại Lệ

| **Tình huống**             | **Điều kiện kích hoạt**            | **Xử lý**                                        |
| -------------------------- | ---------------------------------- | ------------------------------------------------ |
| Chưa có dữ liệu            | Bảng training_sessions rỗng        | KPI trả về 0, bảng trống kèm gợi ý               |
| Model Mgmt Service timeout | Feign client vượt ngưỡng 3s        | Fallback: hiển thị 'Model #ID', không lỗi trang  |
| Dữ liệu metrics null       | Worker ghi thiếu accuracy/loss     | Hiển thị 'N/A', không ảnh hưởng các bản ghi khác |
| Dữ liệu quá lớn            | training_sessions > 10,000 bản ghi | Áp dụng phân trang; KPI tính trên toàn bộ        |

# PHẦN 2: THIẾT KẾ THỰC THỂ (ENTITY DESIGN)

Theo nguyên lý Microservices, mỗi service sở hữu tập entity của riêng mình. Không service nào được truy cập trực tiếp vào entity của service khác. Bảng dưới đây phân định rõ ràng sở hữu entity theo từng service.

| **Entity**      | **Thuộc Service**         | **Vai trò nghiệp vụ**                                                  |
| --------------- | ------------------------- | ---------------------------------------------------------------------- |
| Model           | Model Management Service  | Thông tin mô hình AI (tên, phiên bản, framework, trạng thái kích hoạt) |
| ModelArtifact   | Model Management Service  | File vật lý đính kèm mô hình (weights, config, log)                    |
| TrainingSession | Statistics Service        | Kết quả mỗi phiên huấn luyện: accuracy, loss, duration - do Worker ghi |
| Sign            | Sign Service (riêng biệt) | Danh mục biển báo; hai service trên chỉ tham chiếu qua sign_id (Long)  |

**➤ Nguyên tắc Data Isolation bắt buộc:**

TrainingSession chỉ lưu model_id (kiểu Long) - không nhúng entity Model vào schema

của Statistics Service. Tên mô hình được lấy khi cần thông qua API call nội bộ.

Đây là 'Logical Foreign Key' - ràng buộc do ứng dụng quản lý, không phải DB engine.

## 2.1. Chi Tiết Entity - Model Management Service

### Entity: Model

| **Thuộc tính** | **Kiểu Java**      | **Ràng buộc**                    | **Mô tả**                                                  |
| -------------- | ------------------ | -------------------------------- | ---------------------------------------------------------- |
| id             | Long               | @Id, @GeneratedValue             | Khóa chính tự tăng                                         |
| name           | String             | @NotNull                         | Tên gợi nhớ của mô hình                                    |
| version        | String             | @NotNull                         | Phiên bản: 1.0, 2.1, …                                     |
| taskType       | TaskType (enum)    | @NotNull                         | CLASSIFICATION / DETECTION / SEGMENTATION                  |
| framework      | String             | @NotNull                         | YOLOv8, TensorFlow, PyTorch, …                             |
| algorithm      | String             | @NotNull                         | Thuật toán học máy cụ thể                                  |
| status         | ModelStatus (enum) | DEFAULT INACTIVE                 | ACTIVE / INACTIVE / DEPRECATED / RETRAINING                |
| isActive       | Boolean            | DEFAULT false                    | Cờ nhanh; cùng ý nghĩa với status                          |
| description    | String             | @Column(columnDefinition="TEXT") | Ghi chú mở rộng                                            |
| createdAt      | LocalDateTime      | @CreationTimestamp               | Tạo tự động                                                |
| isDeleted      | Boolean            | DEFAULT false                    | Soft-delete flag                                           |
| parentModelId  | Long               | @Nullable                        | ID mô hình gốc nếu được tạo từ Retrain; null nếu train mới |

### Entity: ModelArtifact

| **Thuộc tính** | **Kiểu Java**       | **Ràng buộc**        | **Mô tả**                                   |
| -------------- | ------------------- | -------------------- | ------------------------------------------- |
| id             | Long                | @Id, @GeneratedValue | Khóa chính                                  |
| model          | Model               | @ManyToOne, @NotNull | Mô hình cha (cascade ALL, lazy)             |
| artifactType   | ArtifactType (enum) | @NotNull             | WEIGHTS / ONNX / TORCHSCRIPT / CONFIG / LOG |
| filePath       | String              | @NotNull             | Đường dẫn file tương đối                    |
| fileSize       | Long                | @Nullable            | Kích thước bytes                            |
| createdAt      | LocalDateTime       | @CreationTimestamp   | Tạo tự động                                 |

## 2.2. Chi Tiết Entity - Statistics Service

### Entity: TrainingSession

| **Thuộc tính**  | **Kiểu Java**         | **Ràng buộc**        | **Mô tả**                               |
| --------------- | --------------------- | -------------------- | --------------------------------------- |
| id              | Long                  | @Id, @GeneratedValue | Khóa chính                              |
| modelId         | Long                  | @NotNull, @Index     | Logic FK sang Model Management Service  |
| datasetId       | Long                  | @NotNull             | Logic FK sang Dataset Service           |
| taskType        | TaskType (enum)       | @NotNull             | Loại tác vụ                             |
| trainingType    | TrainingType (enum)   | @NotNull             | NEW / RETRAIN                           |
| status          | TrainingStatus (enum) | @NotNull             | PENDING/RUNNING/COMPLETED/FAILED        |
| accuracy        | Float                 | @Nullable            | Độ chính xác 0.0-1.0                    |
| loss            | Float                 | @Nullable            | Giá trị hàm mất mát                     |
| precision       | Float                 | @Nullable            | Precision metric                        |
| recall          | Float                 | @Nullable            | Recall metric                           |
| f1Score         | Float                 | @Nullable            | F1-score                                |
| durationSeconds | Long                  | @Nullable            | Thời gian chạy (giây)                   |
| startTime       | LocalDateTime         | @NotNull             | Thời điểm bắt đầu                       |
| endTime         | LocalDateTime         | @Nullable            | Thời điểm kết thúc (null nếu đang chạy) |
| config          | String                | @Column(TEXT)        | JSON hyperparameters của phiên          |
| trainLogPath    | String                | @Nullable            | Đường dẫn log file                      |
| createdAt       | LocalDateTime         | @CreationTimestamp   | Tạo tự động                             |

## 2.3. Biểu Đồ Lớp Entity - Model Management Service

Biểu đồ dưới đây thể hiện cấu trúc các entity thuộc Model Management Service, mối quan hệ giữa chúng, và các enum liên quan. Đây là biểu đồ entity thuần túy - không có lớp Controller hay Service.

Hình 2.1 - Entity Class Diagram: Model Management Service

**\`\`\`mermaid**

classDiagram

%% ═══ ENTITIES - Model Management Service ═══════════

class Model {

&lt;<Entity&gt;>

+Long id

+String name

+String version

+TaskType taskType

+String framework

+String algorithm

+ModelStatus status

+Boolean isActive

+String description

+LocalDateTime createdAt

+Boolean isDeleted

+List~ModelArtifact~ artifacts

}

class ModelArtifact {

&lt;<Entity&gt;>

+Long id

+Model model

+ArtifactType artifactType

+String filePath

+Long fileSize

+LocalDateTime createdAt

}

%% ═══ ENUMS ══════════════════════════════════════════

class TaskType {

&lt;<enumeration&gt;>

CLASSIFICATION

DETECTION

SEGMENTATION

}

class ModelStatus {

&lt;<enumeration&gt;>

ACTIVE

INACTIVE

DEPRECATED

RETRAINING

}

class ArtifactType {

&lt;<enumeration&gt;>

WEIGHTS

ONNX

TORCHSCRIPT

CONFIG

LOG

}

%% ═══ RELATIONSHIPS ══════════════════════════════════

Model "1" \*-- "0..\*" ModelArtifact : owns (cascade ALL)

Model --> TaskType : has

Model --> ModelStatus : has

ModelArtifact --> ArtifactType : has

%% NOTE: Model.id được tham chiếu logic từ Statistics Service

%% nhưng KHÔNG có quan hệ JPA xuyên service

**\`\`\`**

## 2.4. Biểu Đồ Lớp Entity - Statistics Service

Biểu đồ dưới đây thể hiện entity TrainingSession thuộc Statistics Service. Lưu ý đặc biệt: modelId và datasetId là kiểu Long (Logical FK) - không phải quan hệ @ManyToOne JPA xuyên service. Trường modelName là @Transient, không map vào DB, chỉ được populate lúc runtime qua inter-service call.

Hình 2.2 - Entity Class Diagram: Statistics Service

**\`\`\`mermaid**

classDiagram

%% ═══ ENTITY - Statistics Service ═══════════════════

class TrainingSession {

&lt;<Entity&gt;>

+Long id

+Long modelId

+Long datasetId

+TaskType taskType

+TrainingType trainingType

+TrainingStatus status

+Float accuracy

+Float loss

+Float precision

+Float recall

+Float f1Score

+Long durationSeconds

+LocalDateTime startTime

+LocalDateTime endTime

+@JsonIgnore String config

+String trainLogPath

+LocalDateTime createdAt

+@Transient String modelName

}

%% ═══ ENUMS ══════════════════════════════════════════

class TaskType {

&lt;<enumeration&gt;>

CLASSIFICATION

DETECTION

SEGMENTATION

}

class TrainingType {

&lt;<enumeration&gt;>

NEW

RETRAIN

}

class TrainingStatus {

&lt;<enumeration&gt;>

PENDING

RUNNING

COMPLETED

FAILED

CANCELLED

}

%% ═══ RELATIONSHIPS ══════════════════════════════════

TrainingSession --> TaskType : has

TrainingSession --> TrainingType : has

TrainingSession --> TrainingStatus : has

%% ═══ LOGICAL REFERENCE (không phải JPA) ════════════

class Model {

&lt;<External Entity - Model Mgmt Service&gt;>

+Long id

+String name

}

TrainingSession ..> Model : modelId refs (Logical FK\\nresolved via API call)

**\`\`\`**

## 2.5. Biểu Đồ Tổng Quan - Quan Hệ Giữa Các Service

Biểu đồ sau thể hiện toàn cảnh entity của hai service và cách chúng liên kết với nhau qua Logical FK và API call, minh họa rõ nguyên tắc Data Isolation.

Hình 2.3 - Tổng quan Entity và Data Isolation giữa hai service

**\`\`\`mermaid**

classDiagram

namespace ModelManagementService {

class Model {

&lt;<Entity&gt;>

+Long id

+String name

+String version

+TaskType taskType

+ModelStatus status

+Boolean isActive

}

class ModelArtifact {

&lt;<Entity&gt;>

+Long id

+Long modelId FK

+ArtifactType artifactType

+String filePath

}

}

namespace StatisticsService {

class TrainingSession {

&lt;<Entity&gt;>

+Long id

+Long modelId LogicalFK

+TrainingStatus status

+Float accuracy

+Float loss

+Long durationSeconds

+@Transient String modelName

}

}

%% ═══ QUAN HỆ NỘI BỘ (cùng service - JPA) ══════════

Model "1" \*-- "0..\*" ModelArtifact : owns

%% ═══ QUAN HỆ NGOẠI SERVICE (API call - không JPA) ══

TrainingSession "\*" ..> "1" Model : modelId via HTTP API

note for TrainingSession "modelId là Long, không phải @ManyToOne\\nTên mô hình lấy qua Feign Client\\n→ gán vào @Transient modelName"

**\`\`\`**

# PHẦN 3: THIẾT KẾ CƠ SỞ DỮ LIỆU

## 3.1. Pattern Database-per-Service

Hệ thống áp dụng triệt để pattern Database-per-Service: mỗi Microservice sở hữu một MySQL schema riêng biệt, không service nào được JOIN trực tiếp vào bảng của service khác.

| **Service**              | **MySQL Schema** | **Bảng chính**          | **Port** |
| ------------------------ | ---------------- | ----------------------- | -------- |
| Model Management Service | model_mgmt_db    | models, model_artifacts | 3306     |
| Statistics Service       | statistics_db    | training_sessions       | 3306     |
| Sign Service             | sign_db          | signs                   | 3306     |

**➤ Tại sao Database-per-Service là bắt buộc trong Microservices?**

1\. ĐỘC LẬP TRIỂN KHAI: Thay đổi schema của Statistics Service (thêm cột loss)

không yêu cầu deploy lại Model Management Service.

2\. LỰA CHỌN CÔNG NGHỆ: Statistics Service sau này có thể chuyển sang

InfluxDB (time-series) mà không ảnh hưởng service khác.

3\. CÁCH LY LỖI: statistics_db bị lỗi không làm gián đoạn quản lý mô hình.

4\. KHÔNG JOIN XEO-SCHEMA: Tên mô hình không được JOIN từ model_mgmt_db vào

statistics_db. Dữ liệu này phải lấy qua HTTP API call nội bộ.

## 3.2. Schema model_mgmt_db

### Bảng: models

| **Tên cột**     | **Kiểu MySQL**                                      | **Ràng buộc**                 | **Ghi chú**                                                      |
| --------------- | --------------------------------------------------- | ----------------------------- | ---------------------------------------------------------------- |
| id              | BIGINT UNSIGNED                                     | PK, AUTO_INCREMENT            |                                                                  |
| name            | VARCHAR(255)                                        | NOT NULL                      |                                                                  |
| version         | VARCHAR(50)                                         | NOT NULL                      |                                                                  |
| task_type       | ENUM('CLASSIFICATION','DETECTION','SEGMENTATION')   | NOT NULL                      |                                                                  |
| framework       | VARCHAR(100)                                        | NOT NULL                      |                                                                  |
| algorithm       | VARCHAR(100)                                        | NOT NULL                      |                                                                  |
| status          | ENUM('ACTIVE','INACTIVE','DEPRECATED','RETRAINING') | NOT NULL, DEFAULT 'INACTIVE'  | RETRAINING: khóa mô hình khi đang retrain                        |
| is_active       | TINYINT(1)                                          | NOT NULL, DEFAULT 0           | Được đánh INDEX riêng                                            |
| description     | TEXT                                                | NULL                          |                                                                  |
| created_at      | DATETIME                                            | NOT NULL, DEFAULT NOW()       |                                                                  |
| updated_at      | DATETIME                                            | DEFAULT NOW() ON UPDATE NOW() |                                                                  |
| is_deleted      | TINYINT(1)                                          | NOT NULL, DEFAULT 0           | Soft-delete                                                      |
| parent_model_id | BIGINT UNSIGNED                                     | NULL, INDEX                   | Logic FK tự tham chiếu - ID mô hình gốc khi được tạo qua Retrain |

**Index quan trọng:** INDEX idx_task_active (task_type, is_active) - tối ưu truy vấn khi kích hoạt mô hình cần tìm nhanh tất cả bản ghi cùng TaskType đang ACTIVE.

**Self-referencing quan hệ Retrain:** Cột parent_model_id tự tham chiếu về bảng models.id (Logical Self-FK). Mô hình được tạo từ Retrain sẽ có parent_model_id = ID mô hình gốc, cho phép truy vết lịch sử toàn bộ cây phiên bản (version lineage).

### Bảng: model_artifacts

| **Tên cột**   | **Kiểu MySQL**                                      | **Ràng buộc**                               | **Ghi chú**         |
| ------------- | --------------------------------------------------- | ------------------------------------------- | ------------------- |
| id            | BIGINT UNSIGNED                                     | PK, AUTO_INCREMENT                          |                     |
| model_id      | BIGINT UNSIGNED                                     | NOT NULL, FK → models(id) ON DELETE CASCADE |                     |
| artifact_type | ENUM('WEIGHTS','ONNX','TORCHSCRIPT','CONFIG','LOG') | NOT NULL                                    |                     |
| file_path     | VARCHAR(500)                                        | NOT NULL                                    | Đường dẫn tương đối |
| file_size     | BIGINT                                              | NULL                                        | Bytes               |
| created_at    | DATETIME                                            | NOT NULL, DEFAULT NOW()                     |                     |

## 3.3. Schema statistics_db

### Bảng: training_sessions

| **Tên cột**      | **Kiểu MySQL**                                             | **Ràng buộc**           | **Ghi chú**                                  |
| ---------------- | ---------------------------------------------------------- | ----------------------- | -------------------------------------------- |
| id               | BIGINT UNSIGNED                                            | PK, AUTO_INCREMENT      |                                              |
| model_id         | BIGINT UNSIGNED                                            | NOT NULL, INDEX         | Logic FK - không có DB-level FK xuyên schema |
| dataset_id       | BIGINT UNSIGNED                                            | NOT NULL, INDEX         | Logic FK sang dataset service                |
| task_type        | ENUM(...)                                                  | NOT NULL                |                                              |
| training_type    | ENUM('NEW','RETRAIN')                                      | NOT NULL                |                                              |
| status           | ENUM('PENDING','RUNNING','COMPLETED','FAILED','CANCELLED') | NOT NULL                |                                              |
| accuracy         | FLOAT                                                      | NULL                    | 0.0 - 1.0                                    |
| loss             | FLOAT                                                      | NULL                    |                                              |
| precision_val    | FLOAT                                                      | NULL                    | Tránh trùng keyword SQL                      |
| recall_val       | FLOAT                                                      | NULL                    |                                              |
| f1_score         | FLOAT                                                      | NULL                    |                                              |
| duration_seconds | BIGINT                                                     | NULL                    | Thời gian chạy giây                          |
| start_time       | DATETIME                                                   | NOT NULL                |                                              |
| end_time         | DATETIME                                                   | NULL                    | NULL khi đang chạy                           |
| config           | TEXT                                                       | NULL                    | JSON hyperparameters                         |
| train_log_path   | VARCHAR(500)                                               | NULL                    |                                              |
| created_at       | DATETIME                                                   | NOT NULL, DEFAULT NOW() |                                              |

**CHÚ Ý - Không có FOREIGN KEY vật lý xuyên schema:**

Cột model_id trong training_sessions là Logical FK. Ứng dụng tự đảm bảo

tính nhất quán qua API call, không dựa vào DB-level constraint.

Đây là sự đánh đổi có chủ đích: loose coupling quan trọng hơn strong consistency

trong kiến trúc Microservices.

# PHẦN 4: THIẾT KẾ CHI TIẾT - MODULE 1 (QUẢN LÝ MÔ HÌNH)

## 4.1. Thiết Kế Giao Diện

### 4.1.1. Màn Hình Danh Sách Mô Hình

| **Khu vực**       | **Thành phần UI**                                                                             | **Chức năng**                  |
| ----------------- | --------------------------------------------------------------------------------------------- | ------------------------------ |
| Toolbar trên cùng | Search input + Dropdown (TaskType, Status) + Nút "Thêm mới" (Primary)                         | Lọc nhanh và tạo mô hình mới   |
| Bảng dữ liệu      | Cột: STT / Tên / Phiên bản / TaskType / Framework / Status Badge / Ngày tạo / Thao tác        | Hiển thị, hỗ trợ sort theo cột |
| Cột Status        | Badge màu: Xanh=ACTIVE, Xám=INACTIVE, Đỏ=DEPRECATED, Vàng=RETRAINING                          | Nhận biết trạng thái nhanh     |
| Cột Thao tác      | 4 nút: Sửa (icon bút) / Kích hoạt-Toggle (icon ⚡) / Retrain (icon 🔄) / Xóa (icon thùng rác) | Hành động trực tiếp trên hàng  |
| Phân trang        | Dropdown 10/20/50 + Prev/Next + số trang                                                      | Xử lý danh sách lớn            |

### 4.1.2. Form Thêm Mới / Chỉnh Sửa (Modal Dialog)

Form hiển thị dạng Modal 2 cột khi Admin nhấn "Thêm mới" hoặc "Sửa":

| **Trường**   | **Component**                                   | **Bắt buộc** | **Ghi chú validation**      |
| ------------ | ----------------------------------------------- | ------------ | --------------------------- |
| Tên mô hình  | Text Input                                      | Có           | Tối đa 255 ký tự            |
| Phiên bản    | Text Input                                      | Có           | Định dạng x.y (VD: 1.0)     |
| Loại tác vụ  | Dropdown: CLASSIFICATION/DETECTION/SEGMENTATION | Có           |                             |
| Framework    | Text Input                                      | Có           | VD: YOLOv8, PyTorch         |
| Thuật toán   | Text Input                                      | Có           |                             |
| Mô tả        | Textarea (4 dòng)                               | Không        | Tối đa 2000 ký tự           |
| Footer modal | Nút "Lưu" (Primary) + Nút "Hủy" (Secondary)     | -            | Lưu gọi API; Hủy đóng modal |

### 4.1.3. Nút Kích Hoạt, Retrain và Xóa

- **Nút "Kích hoạt":** Màu xanh lá với icon ⚡ khi mô hình INACTIVE. Khi đang ACTIVE, chuyển thành "Vô hiệu hóa" màu cam. Bị disabled khi status = RETRAINING.
- **Nút "Retrain":** Màu tím với icon 🔄, luôn hiển thị với mọi trạng thái ACTIVE/INACTIVE/DEPRECATED. Bị disabled (xám) chỉ khi status = RETRAINING (đã có phiên đang chạy). Tooltip: "Huấn luyện lại mô hình này với dataset/config mới".
- **Nút "Xóa":** Màu đỏ; bị disabled nếu is_active=true hoặc status=RETRAINING. Khi click, hiện Confirmation Dialog xác nhận trước khi gọi DELETE.

### 4.1.4. Modal Retrain

Khi Admin nhấn "Retrain", hệ thống mở Modal Retrain gồm 2 vùng:

| **Vùng**                          | **Trường / Thành phần**                         | **Loại**            | **Ghi chú**                               |
| --------------------------------- | ----------------------------------------------- | ------------------- | ----------------------------------------- |
| Thông tin mô hình gốc (read-only) | Tên mô hình                                     | Text (disabled)     | Hiển thị để Admin xác nhận đúng mô hình   |
|                                   | Phiên bản hiện tại                              | Text (disabled)     | VD: 1.2                                   |
|                                   | Loại tác vụ                                     | Badge (disabled)    | CLASSIFICATION / DETECTION / SEGMENTATION |
| Cấu hình retrain (editable)       | Chọn Dataset mới                                | Dropdown (bắt buộc) | Danh sách dataset từ Dataset Service      |
|                                   | Learning Rate                                   | Number Input        | VD: 0.001                                 |
|                                   | Epochs                                          | Number Input        | VD: 100                                   |
|                                   | Batch Size                                      | Number Input        | VD: 32                                    |
|                                   | Ghi chú phiên retrain                           | Textarea            | Tùy chọn - lý do retrain                  |
| Footer                            | "Bắt đầu Retrain" (Primary) + "Hủy" (Secondary) | Buttons             | Gửi POST /api/models/{id}/retrain         |

## 4.2. Thiết Kế Biểu Đồ Lớp - Module 1

### 4.2.1. Phân Tích Builder Pattern

Đối tượng Model có ≥6 tham số khởi tạo (name, version, taskType, framework, algorithm, description). Sử dụng constructor thông thường dẫn đến anti-pattern Telescoping Constructor: khó đọc, dễ nhầm vị trí tham số, không tường minh. Builder Pattern giải quyết:

- **Khởi tạo từng bước có tên rõ ràng:** Model.builder().name("YOLOv8-v2").version("1.0").taskType(DETECTION).build().
- **Tham số tùy chọn có giá trị mặc định:** description mặc định là rỗng, không cần truyền null.
- **Tăng tính bất biến:** Sau khi build(), đối tượng Model được khởi tạo hoàn chỉnh, các field bắt buộc đã được kiểm tra trong build().
- **Không ảnh hưởng Entity class:** Builder là inner static class, không làm phức tạp JPA entity mapping.

**CHÚ Ý - Không dùng DTO:**

Toàn bộ biểu đồ lớp dưới đây KHÔNG sử dụng bất kỳ lớp \*DTO, \*Request hay

\*Response nào. Controller nhận Map&lt;String,Object&gt; hoặc @RequestBody trực tiếp

và trả về Entity hoặc List&lt;Entity&gt;. Các @JsonIgnore/@JsonView được đặt trực tiếp

trên Entity để kiểm soát field nào được serialize ra ngoài.

### 4.2.2. Mã Mermaid - Biểu Đồ Lớp Module 1

Hình 4.1 - Class Diagram: Model Management Service với Builder Pattern (Không có DTO)

**\`\`\`mermaid**

classDiagram

%% ═══ CONTROLLER LAYER ═══════════════════════════════

class ModelController {

\-ModelService modelService

+getAll(taskType, status, page, size) ResponseEntity~List~Model~~

+getById(id) ResponseEntity~Model~

+create(body Map) ResponseEntity~Model~

+update(id, body Map) ResponseEntity~Model~

+delete(id) ResponseEntity~Void~

+activate(id) ResponseEntity~Model~

+deactivate(id) ResponseEntity~Model~

+retrain(id, body Map) ResponseEntity~Model~

+getArtifacts(modelId) ResponseEntity~List~ModelArtifact~~

+uploadArtifact(modelId, file, type) ResponseEntity~ModelArtifact~

}

%% ═══ SERVICE LAYER ══════════════════════════════════

class ModelService {

\-ModelRepository modelRepo

\-ModelArtifactRepository artifactRepo

\-RetrainWorkerClient workerClient

+findAll(taskType, status, pageable) List~Model~

+findById(id) Model

+create(body Map) Model

+update(id, body Map) Model

+softDelete(id) void

+activate(id) Model

+deactivate(id) Model

+retrain(id, body Map) Model

\-deactivateAllSameTaskType(taskType) void

\-validateNotRetraining(model) void

}

%% ═══ FEIGN CLIENT → Async Worker ═══════════════════

class RetrainWorkerClient {

&lt;<FeignClient url=training-worker&gt;>

+dispatchRetrainTask(modelId Long, datasetId Long, config String) void

}

%% ═══ REPOSITORY LAYER ═══════════════════════════════

class ModelRepository {

&lt;<interface&gt;>

+findByTaskTypeAndIsActiveAndIsDeletedFalse(t, a) List~Model~

+findByTaskTypeAndStatusAndIsDeletedFalse(t, s, p) Page~Model~

+findByIdAndIsDeletedFalse(id) Optional~Model~

}

class ModelArtifactRepository {

&lt;<interface&gt;>

+findByModelId(modelId) List~ModelArtifact~

+deleteByModelId(modelId) void

}

%% ═══ BUILDER PATTERN ════════════════════════════════

class Model {

+Long id

+String name

+String version

+TaskType taskType

+String framework

+String algorithm

+ModelStatus status

+Boolean isActive

+String description

+LocalDateTime createdAt

+Boolean isDeleted

+Long parentModelId

\-Model(Builder b)

+static builder() Builder

}

class Builder {

&lt;<static inner&gt;>

\-String name

\-String version

\-TaskType taskType

\-String framework

\-String algorithm

\-String description = empty

+name(v) Builder

+version(v) Builder

+taskType(v) Builder

+framework(v) Builder

+algorithm(v) Builder

+description(v) Builder

+build() Model

}

class ModelArtifact {

+Long id

+Model model

+ArtifactType artifactType

+String filePath

+Long fileSize

+LocalDateTime createdAt

}

%% ═══ ENUMS ══════════════════════════════════════════

class TaskType {

&lt;<enumeration&gt;>

CLASSIFICATION

DETECTION

SEGMENTATION

}

class ModelStatus {

&lt;<enumeration&gt;>

ACTIVE

INACTIVE

DEPRECATED

RETRAINING

}

class ArtifactType {

&lt;<enumeration&gt;>

WEIGHTS

ONNX

TORCHSCRIPT

CONFIG

LOG

}

%% ═══ RELATIONSHIPS ══════════════════════════════════

ModelController --> ModelService : calls

ModelService --> ModelRepository : uses

ModelService --> ModelArtifactRepository : uses

ModelService --> RetrainWorkerClient : dispatches task

ModelService ..> Builder : creates via

Builder ..> Model : builds

ModelRepository --> Model : persists

ModelArtifactRepository --> ModelArtifact : persists

Model \*-- ModelArtifact : owns 0..\*

Model --> Model : parentModelId (self-ref retrain lineage)

Model --> TaskType

Model --> ModelStatus

ModelArtifact --> ArtifactType

%% NOTE: Không có ModelDTO, ModelRequest hay ModelResponse

**\`\`\`**

## 4.3. Thiết Kế Biểu Đồ Tuần Tự - Module 1

Biểu đồ mô tả luồng UC-M1-05: Kích hoạt mô hình - luồng phức tạp nhất và quan trọng nhất của module, thể hiện rõ kiến trúc 4 node và cơ chế transaction.

Hình 4.2 - Sequence Diagram: Luồng Kích Hoạt Mô Hình

**\`\`\`mermaid**

sequenceDiagram

autonumber

actor A as Admin (ReactJS Client)

participant GW as API Gateway

participant MS as Model Management Service

participant DB as model_mgmt_db (MySQL)

A->>GW: PATCH /api/models/{id}/activate

Note over GW: Validate JWT · Route /api/models/\*\* → MS

GW->>MS: PATCH /models/{id}/activate

MS->>DB: SELECT \* FROM models WHERE id={id} AND is_deleted=0

DB-->>MS: Model entity (hoặc null)

alt Model không tồn tại

MS-->>GW: 404 Not Found

GW-->>A: Lỗi: Không tìm thấy mô hình

end

Note over MS: Bắt đầu @Transactional

MS->>DB: UPDATE models SET is_active=0, status='INACTIVE'

Note right of DB: WHERE task_type={taskType} AND is_active=1

DB-->>MS: N rows updated (deactivate các mô hình cùng loại)

MS->>DB: UPDATE models SET is_active=1, status='ACTIVE'

Note right of DB: WHERE id={id}

DB-->>MS: 1 row updated

MS->>DB: COMMIT

DB-->>MS: OK

Note over MS: @Transactional kết thúc - toàn bộ thành công

MS->>DB: SELECT \* FROM models WHERE id={id}

DB-->>MS: Model entity (status=ACTIVE, isActive=true)

MS-->>GW: 200 OK - Model entity JSON (không có DTO bao ngoài)

GW-->>A: 200 OK - Model JSON

Note over A: Cập nhật UI: Badge → Xanh 'ACTIVE'

**\`\`\`**

## 4.4. Thiết Kế Biểu Đồ Tuần Tự - Luồng Retrain Mô Hình

Biểu đồ dưới đây mô tả luồng UC-M1-06: Admin nhấn nút Retrain. Điểm đặc biệt so với các luồng khác: hệ thống trả về HTTP 202 Accepted ngay lập tức (không chờ Worker), và toàn bộ quá trình huấn luyện diễn ra bất đồng bộ ngoài luồng HTTP request. Sơ đồ cũng thể hiện inter-service call sang Statistics Service để ghi TrainingSession.

Hình 4.3 - Sequence Diagram: Luồng Retrain Mô Hình (Async)

**\`\`\`mermaid**

sequenceDiagram

autonumber

actor A as Admin (ReactJS Client)

participant GW as API Gateway

participant MS as Model Management Service

participant DB as model_mgmt_db (MySQL)

participant SS as Statistics Service

participant WK as Async Training Worker (Python)

A->>GW: POST /api/models/{id}/retrain

Note right of A: body: { datasetId, config: {lr, epochs, batchSize} }

Note over GW: Validate JWT · Route → MS

GW->>MS: POST /models/{id}/retrain

MS->>DB: SELECT \* FROM models WHERE id={id} AND is_deleted=0

DB-->>MS: Model entity

alt Model không tồn tại

MS-->>GW: 404 Not Found

GW-->>A: Lỗi: Không tìm thấy mô hình

end

alt Model đang RETRAINING

MS-->>GW: 409 Conflict

GW-->>A: Lỗi: Mô hình đang có phiên retrain chạy

end

rect rgb(240,248,255)

Note over MS,DB: Bước 1 - Khóa mô hình gốc

MS->>DB: UPDATE models SET status='RETRAINING'

Note right of DB: WHERE id={id}

DB-->>MS: 1 row updated

end

rect rgb(224,245,238)

Note over MS,SS: Bước 2 - Ghi TrainingSession (inter-service call)

MS->>SS: POST /internal/training-sessions

Note right of MS: body: { modelId:{id}, datasetId, trainingType:'RETRAIN',

Note right of MS: parentModelId:{id}, status:'PENDING', config:... }

SS-->>MS: TrainingSession { id: sessionId, status: PENDING }

end

rect rgb(255,248,225)

Note over MS,WK: Bước 3 - Dispatch task sang Worker (async, không chờ)

MS--)WK: dispatchRetrainTask(modelId, datasetId, sessionId, config)

Note over WK: Worker nhận task từ Queue

Note over WK: Không block HTTP thread

end

MS-->>GW: 202 Accepted - Model entity (status=RETRAINING)

GW-->>A: 202 Accepted - Model JSON

Note over A: UI hiển thị badge vàng 'Đang retrain...'

Note over A: Nút Retrain + Kích hoạt + Xóa → disabled

Note over WK: ════ LUỒNG ASYNC (ngoài HTTP) ════

WK->>WK: Chạy script Python huấn luyện lại

WK->>SS: PATCH /internal/training-sessions/{sessionId}

Note right of WK: { status:'RUNNING', startTime: now() }

WK->>WK: ... Huấn luyện tiếp diễn ...

WK->>SS: PATCH /internal/training-sessions/{sessionId}

Note right of WK: { status:'COMPLETED', accuracy:0.97,

Note right of WK: loss:0.031, durationSeconds:7200 }

WK->>DB: UPDATE models SET status='INACTIVE'

Note right of DB: WHERE id={id} (mô hình gốc về INACTIVE)

WK->>DB: INSERT INTO models (name,version,...,parent_model_id={id})

Note right of DB: Tạo Model mới với version tăng, parentModelId=gốc

Note over WK: Retrain hoàn tất - Model mới sẵn sàng để Admin kích hoạt

**\`\`\`**

# PHẦN 5: THIẾT KẾ CHI TIẾT - MODULE 2 (THỐNG KÊ MÔ HÌNH)

## 5.1. Thiết Kế Giao Diện Dashboard

### 5.1.1. Khu Vực Thẻ KPI Số (4 thẻ ngang)

| **Thẻ KPI**                   | **Giá trị hiển thị**            | **Công thức tính**                         | **Màu chủ đạo** |
| ----------------------------- | ------------------------------- | ------------------------------------------ | --------------- |
| Tổng số phiên huấn luyện      | Số nguyên (VD: 42)              | COUNT(\*) FROM training_sessions           | Xanh dương      |
| Thời gian huấn luyện tổng     | Xh Ym (VD: 127h 34m)            | SUM(duration_seconds) → format             | Xanh teal       |
| Mô hình độ chính xác cao nhất | Tên + % (VD: YOLOv8-v2 · 96.4%) | MAX(accuracy) → inter-service call lấy tên | Vàng amber      |
| Tỷ lệ phiên thành công        | % (VD: 88.1%)                   | COUNT(COMPLETED)/COUNT(\*)×100             | Xanh lá         |

### 5.1.2. Bảng Data Table Chi Tiết

| **Cột**        | **Nguồn dữ liệu**                             | **Định dạng hiển thị**                            |
| -------------- | --------------------------------------------- | ------------------------------------------------- |
| STT            | -                                             | Số nguyên tăng dần                                |
| Tên mô hình    | Inter-service call → Model Management Service | Text; fallback: 'Model #ID'                       |
| Loại tác vụ    | training_sessions.task_type                   | Badge màu (Classification/Detection/Segmentation) |
| Loại phiên     | training_sessions.training_type               | Badge: NEW (xanh) / RETRAIN (cam)                 |
| Trạng thái     | training_sessions.status                      | Badge: COMPLETED(xanh)/FAILED(đỏ)/RUNNING(vàng)   |
| Độ chính xác   | training_sessions.accuracy                    | Phần trăm: 95.3%                                  |
| Loss           | training_sessions.loss                        | Số thập phân: 0.0423                              |
| Thời gian chạy | training_sessions.duration_seconds            | Định dạng: 2h 30m 15s                             |
| Ngày bắt đầu   | training_sessions.start_time                  | DD/MM/YYYY HH:mm                                  |
| Xem log        | -                                             | Nút 'Log' mở modal hiển thị train_log_path        |

## 5.2. Thiết Kế Biểu Đồ Lớp - Module 2

### 5.2.1. Phân Tích Facade Pattern

StatisticsController cần phối hợp 4 nguồn logic: truy vấn DB thô, tính toán KPI, gọi API nội bộ lấy tên mô hình, và ghép dữ liệu kết quả. Đặt tất cả vào Controller tạo ra God Controller phụ thuộc quá nhiều class, khó test và bảo trì. Facade Pattern giải quyết:

- **Gom logic phức tạp vào StatisticFacade:** Controller chỉ gọi facade.getSummary() và facade.getSessionPage() - một điểm vào duy nhất.
- **Che giấu inter-service communication:** Controller không biết có HTTP call nội bộ sang service khác; Facade xử lý hoàn toàn bên trong.
- **Dễ mở rộng:** Thêm nguồn dữ liệu mới (metrics từ service khác) chỉ cần sửa Facade, không đụng Controller.
- **Tăng testability:** Mock Facade trong unit test của Controller cực kỳ đơn giản.

### 5.2.2. Phân Tích Singleton Pattern

DatabaseConnectionPool quản lý tập hợp các kết nối MySQL tái sử dụng. Tạo nhiều instance pool sẽ lãng phí bộ nhớ và vượt giới hạn kết nối DB. Singleton Pattern đảm bảo:

- **Chỉ một instance toàn ứng dụng:** Tránh tạo nhiều pool dư thừa, tiết kiệm bộ nhớ heap và kết nối DB.
- **Thread-safe:** Cài đặt double-checked locking hoặc ủy thác cho Spring IoC Container (@Bean với scope singleton mặc định) đảm bảo an toàn đa luồng.
- **Điểm quản lý tập trung:** Toàn bộ service lấy connection từ một nguồn duy nhất; dễ monitor pool stats (active connections, idle, waiting).

**CHÚ Ý - Không dùng DTO (áp dụng cho cả Module 2):**

StatisticsController trả thẳng List&lt;TrainingSession&gt; hoặc Map&lt;String,Object&gt;

cho summary. Không có lớp StatisticsSummaryResponse hay SessionRowDTO.

TrainingSession entity dùng @JsonIgnore trên trường config (TEXT dài) và

@JsonProperty để alias cột precision_val → 'precision' khi serialize.

### 5.2.3. Mã Mermaid - Biểu Đồ Lớp Module 2

Hình 5.1 - Class Diagram: Statistics Service với Facade + Singleton (Không có DTO)

**\`\`\`mermaid**

classDiagram

%% ═══ CONTROLLER LAYER ═══════════════════════════════

class StatisticsController {

\-StatisticFacade facade

+getSummary() ResponseEntity~Map~

+getSessionPage(page, size, filters) ResponseEntity~List~TrainingSession~~

+getSessionById(id) ResponseEntity~TrainingSession~

}

%% ═══ FACADE PATTERN ════════════════════════════════

class StatisticFacade {

&lt;<Facade&gt;>

\-TrainingSessionService sessionService

\-KPICalculator kpiCalc

\-ModelNameResolver nameResolver

+getSummary() Map~String-Object~

+getSessionPage(page, size, filters) List~TrainingSession~

\-enrichSessionsWithNames(sessions) void

}

%% ═══ INTERNAL COMPONENTS ════════════════════════════

class TrainingSessionService {

\-TrainingSessionRepository repo

+findAll(filters, pageable) Page~TrainingSession~

+findById(id) TrainingSession

+countAll() Long

+sumDuration() Long

+countByStatus(status) Long

+findMaxAccuracy() Optional~TrainingSession~

}

class KPICalculator {

+formatDuration(totalSeconds Long) String

+calcSuccessRate(completed Long, total Long) Double

+buildSummaryMap(total, duration, rate, best) Map~String-Object~

}

class ModelNameResolver {

\-ModelManagementClient feignClient

+resolveNames(modelIds List~Long~) Map~Long-String~

}

%% ═══ FEIGN CLIENT (Inter-service) ═══════════════════

class ModelManagementClient {

&lt;<FeignClient url=model-mgmt-service&gt;>

+getModelNames(ids List~Long~) Map~Long-String~

}

%% ═══ REPOSITORY LAYER ═══════════════════════════════

class TrainingSessionRepository {

&lt;<interface&gt;>

+findAllWithFilters(spec, pageable) Page~TrainingSession~

+sumDurationSecondsByStatus(status) Long

+countByStatus(status) Long

+findFirstByOrderByAccuracyDesc() Optional~TrainingSession~

}

%% ═══ SINGLETON PATTERN ══════════════════════════════

class DatabaseConnectionPool {

&lt;<Singleton&gt;>

\-static volatile instance DatabaseConnectionPool

\-HikariDataSource dataSource

\-DatabaseConnectionPool()

+static getInstance() DatabaseConnectionPool

+getConnection() Connection

+releaseConnection(conn Connection) void

+getActiveCount() int

}

%% ═══ ENTITY (Không có DTO) ══════════════════════════

class TrainingSession {

+Long id

+Long modelId

+Long datasetId

+TaskType taskType

+TrainingType trainingType

+TrainingStatus status

+Float accuracy

+Float loss

+Float f1Score

+Long durationSeconds

+LocalDateTime startTime

+LocalDateTime endTime

+@JsonIgnore String config

+@Transient String modelName

}

%% ═══ RELATIONSHIPS ══════════════════════════════════

StatisticsController --> StatisticFacade : delegates

StatisticFacade --> TrainingSessionService : queries

StatisticFacade --> KPICalculator : calculates

StatisticFacade --> ModelNameResolver : resolves

ModelNameResolver --> ModelManagementClient : HTTP call

TrainingSessionService --> TrainingSessionRepository : uses

TrainingSessionRepository --> TrainingSession : manages

TrainingSessionRepository ..> DatabaseConnectionPool : uses

%% NOTE: Không có SessionDTO, SummaryResponseDTO hay bất kỳ \*DTO nào

**\`\`\`**

## 5.3. Thiết Kế Biểu Đồ Tuần Tự - Module 2

Biểu đồ thể hiện luồng tải Dashboard, đặc biệt nhấn mạnh Inter-service Communication giữa Statistics Service và Model Management Service để giải quyết bài toán Data Isolation. Kết quả trả về là List&lt;TrainingSession&gt; entity trực tiếp - không bọc DTO.

Hình 5.2 - Sequence Diagram: Dashboard Thống Kê + Inter-service Communication

**\`\`\`mermaid**

sequenceDiagram

autonumber

actor A as Admin (ReactJS Client)

participant GW as API Gateway

participant SS as Statistics Service (StatisticFacade)

participant SDB as statistics_db (MySQL)

participant MMS as Model Management Service

participant MDB as model_mgmt_db (MySQL)

A->>GW: GET /api/statistics/summary

GW->>SS: GET /statistics/summary

rect rgb(235,245,255)

Note over SS,SDB: Bước 1 - Truy vấn dữ liệu nội bộ Statistics Service

SS->>SDB: SELECT COUNT(\*) total FROM training_sessions

SDB-->>SS: { total: 42 }

SS->>SDB: SELECT SUM(duration_seconds) FROM training_sessions

SDB-->>SS: { totalSec: 459240 }

SS->>SDB: SELECT model_id FROM training_sessions

Note right of SDB: ORDER BY accuracy DESC LIMIT 1

SDB-->>SS: { bestModelId: 7, accuracy: 0.964 }

SS->>SDB: SELECT COUNT(\*) FROM training_sessions

Note right of SDB: WHERE status = 'COMPLETED'

SDB-->>SS: { completed: 37 }

end

rect rgb(224,245,238)

Note over SS,MDB: Bước 2 - Inter-service Communication

Note over SS,MDB: Giải quyết Data Isolation: lấy tên mô hình từ service chủ sở hữu

SS->>MMS: GET /internal/models/names?ids=7

Note over MMS: Xử lý internal endpoint&lt;br/&gt;(không qua Gateway công khai)

MMS->>MDB: SELECT id, name FROM models WHERE id IN (7)

MDB-->>MMS: \[{ id:7, name:'YOLOv8-v2' }\]

MMS-->>SS: Map { 7: 'YOLOv8-v2' }

end

Note over SS: KPICalculator.buildSummaryMap()

Note over SS: Ghép tên mô hình vào summary

SS-->>GW: 200 OK - Map~String,Object~ JSON

Note right of SS: { total:42, duration:'127h34m',

Note right of SS: bestModel:'YOLOv8-v2·96.4%',

Note right of SS: successRate:'88.1%' }

GW-->>A: 200 OK - Summary JSON

Note over A: Render 4 thẻ KPI số

A->>GW: GET /api/statistics/sessions?page=0&size=20

GW->>SS: GET /statistics/sessions?page=0&size=20

SS->>SDB: SELECT \* FROM training_sessions LIMIT 20 OFFSET 0

SDB-->>SS: List~TrainingSession~ (20 records)

SS->>MMS: GET /internal/models/names?ids=1,2,5,7,...

MMS->>MDB: SELECT id, name FROM models WHERE id IN (1,2,5,7,...)

MDB-->>MMS: List of {id, name}

MMS-->>SS: Map~Long,String~

Note over SS: Gán session.modelName = map.get(session.modelId)

Note over SS: Dùng @Transient String modelName trong Entity

SS-->>GW: 200 OK - List~TrainingSession~ JSON (entity trực tiếp, không DTO)

GW-->>A: 200 OK - Session list JSON

Note over A: Render bảng Data Table chi tiết

alt Model Management Service timeout (>3s)

SS->>SS: Feign fallback: modelName = 'Model #' + modelId

SS-->>GW: 200 OK (với tên fallback, trang không bị lỗi)

GW-->>A: Dashboard hiển thị bình thường

end

**\`\`\`**

**➤ Phân tích kỹ thuật Inter-service Communication trong biểu đồ:**

VẤN ĐỀ: Statistics Service chỉ biết model_id. Tên mô hình là dữ liệu thuộc

quyền sở hữu của Model Management Service (Single Source of Truth).

Statistics Service KHÔNG ĐƯỢC lưu tên mô hình vào statistics_db - đó sẽ là

vi phạm nguyên tắc Data Isolation.

GIẢI PHÁP - API Composition Pattern:

Statistics Service gọi nội bộ POST /internal/models/names (Feign Client).

Endpoint nội bộ này chỉ trả Map&lt;Long,String&gt; {id → name} - không qua Gateway.

KỸ THUẬT TRẢ DỮ LIỆU KHÔNG DTO:

Tên mô hình được gán vào @Transient String modelName trong entity TrainingSession.

Field @Transient không map với DB column - chỉ tồn tại trong memory khi serialize.

Đây là cách inject dữ liệu ngoài entity mà không cần lớp DTO bao ngoài.

RESILIENCE: Feign Client có @FeignClient fallback - nếu MMS timeout,

modelName = 'Model #ID'. Dashboard không bị lỗi, người dùng vẫn xem được thống kê.

# KẾT LUẬN

Báo cáo đã trình bày đầy đủ thiết kế kiến trúc và chi tiết kỹ thuật cho hai module Quản Lý Mô Hình và Thống Kê Mô Hình trong hệ thống nhận dạng biển báo giao thông, với các điểm thiết kế nổi bật:

- **Tuân thủ Microservices triệt để:** Database-per-Service, Logical FK, inter-service communication qua API - không JOIN xuyên schema.
- **Không sử dụng DTO ở bất kỳ đâu:** Controller trả thẳng Entity hoặc Map&lt;String,Object&gt;. Kiểm soát field serialize bằng @JsonIgnore và @Transient ngay trên Entity class.
- **Builder Pattern (Module 1):** Khởi tạo đối tượng Model phức tạp theo từng bước, tránh Telescoping Constructor, không ảnh hưởng JPA mapping.
- **Facade Pattern (Module 2):** StatisticFacade gom toàn bộ logic phức tạp - truy vấn DB, tính KPI, inter-service call - ẩn khỏi Controller.
- **Singleton Pattern (Module 2):** DatabaseConnectionPool đảm bảo một instance duy nhất toàn service, tối ưu bộ nhớ và kết nối DB.
- **Resilience:** Feign Client fallback đảm bảo Dashboard Thống kê hoạt động ngay cả khi Model Management Service tạm thời không phản hồi.
- **Tách biệt Training và Serving:** Asynchronous Worker ghi dữ liệu offline; Web Service chỉ đọc và điều phối trạng thái - thiết kế đúng cho hệ thống AI production.