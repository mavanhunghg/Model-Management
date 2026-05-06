import { TASK_TYPES } from '../../../shared/constants/domainConstants'

export function ModelModal({ open, mode, form, setForm, onClose, onSubmit }) {
  if (!open) return null

  return (
    <div className="modal-overlay" role="dialog" aria-modal="true">
      <div className="modal">
        <h3>Chỉnh sửa mô hình</h3>
        <div className="form-grid">
          <label>
            Tên mô hình
            <input
              value={form.name}
              disabled={true}
              onChange={(e) => setForm({ ...form, name: e.target.value })}
            />
          </label>
          <label>
            Phiên bản
            <input value={form.version} onChange={(e) => setForm({ ...form, version: e.target.value })} />
          </label>
          <label>
            Loại tác vụ
            <select
              value={form.taskType}
              disabled={true}
              onChange={(e) => setForm({ ...form, taskType: e.target.value })}
            >
              {TASK_TYPES.map((taskType) => (
                <option key={taskType} value={taskType}>
                  {taskType}
                </option>
              ))}
            </select>
          </label>
          <label>
            Framework
            <input value={form.framework} onChange={(e) => setForm({ ...form, framework: e.target.value })} />
          </label>
          <label>
            Thuật toán
            <input
              value={form.algorithm}
              disabled={true}
              onChange={(e) => setForm({ ...form, algorithm: e.target.value })}
            />
          </label>
          <label className="full-width">
            Mô tả
            <textarea
              rows={4}
              value={form.description}
              onChange={(e) => setForm({ ...form, description: e.target.value })}
            />
          </label>
        </div>
        <div className="modal-actions">
          <button className="secondary" onClick={onClose}>
            Hủy
          </button>
          <button className="primary" onClick={onSubmit}>
            Lưu
          </button>
        </div>
      </div>
    </div>
  )
}
