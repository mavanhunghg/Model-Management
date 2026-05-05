# Frontend - QuanLyMoHinh

Frontend duoc tach theo service de mapping truc tiep voi backend:

- `src/modules/api-gateway`: client request chung + component UI dung chung cho giao tiep API
- `src/modules/model-management-service`: page/hook/api/components cho quan ly model
- `src/modules/statistics-service`: page/hook/api/components cho thong ke model
- `src/shared`: constants va utility dung chung

## Cau truc chinh

```text
src/
  App.jsx
  modules/
	api-gateway/
	model-management-service/
	statistics-service/
  shared/
```

## Chay du an

```cmd
npm install
npm run dev
```

## Kiem tra chat luong

```cmd
npm run lint
npm run build
```

Mac dinh frontend goi API qua `VITE_API_BASE_URL`.
Neu khong khai bao bien moi truong nay, gia tri fallback la `http://localhost:8080`.
