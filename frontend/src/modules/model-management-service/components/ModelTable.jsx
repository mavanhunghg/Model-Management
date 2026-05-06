import { formatDate } from '../../../shared/utils/formatters'

export function ModelTable({ models, onEdit }) {
  return (
    <table>
      <thead>
        <tr>
          <th>STT</th>
          <th>Tên</th>
          <th>Phiên bản</th>
          <th>Task</th>
          <th>Framework</th>
          <th>Status</th>
          <th>Ngày tạo</th>
          <th>Thao tác</th>
        </tr>
      </thead>
      <tbody>
        {models.map((model, index) => (
          <tr key={model.id}>
            <td>{index + 1}</td>
            <td>{model.name}</td>
            <td>{model.version}</td>
            <td>{model.taskType}</td>
            <td>{model.framework}</td>
            <td>
              <span className={`badge ${String(model.status || '').toLowerCase()}`}>{model.status}</span>
            </td>
            <td>{formatDate(model.createdAt)}</td>
            <td className="actions">
              <button className="secondary" onClick={() => onEdit(model)}>
                Sửa
              </button>
            </td>
          </tr>
        ))}
        {models.length === 0 && (
          <tr>
            <td colSpan={8}>Không có dữ liệu</td>
          </tr>
        )}
      </tbody>
    </table>
  )
}
