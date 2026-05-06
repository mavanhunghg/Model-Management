import { MODEL_STATUSES, TASK_TYPES } from '../../../shared/constants/domainConstants'

export function ModelToolbar({
  searchText,
  setSearchText,
  modelTaskType,
  setModelTaskType,
  modelStatus,
  setModelStatus,
}) {
  return (
    <div className="toolbar">
      <input
        placeholder="Tìm nhanh theo tên / version / framework..."
        value={searchText}
        onChange={(e) => setSearchText(e.target.value)}
      />
      <select value={modelTaskType} onChange={(e) => setModelTaskType(e.target.value)}>
        <option value="">Tất cả task</option>
        {TASK_TYPES.map((item) => (
          <option key={item} value={item}>
            {item}
          </option>
        ))}
      </select>
      <select value={modelStatus} onChange={(e) => setModelStatus(e.target.value)}>
        <option value="">Tất cả trạng thái</option>
        {MODEL_STATUSES.map((item) => (
          <option key={item} value={item}>
            {item}
          </option>
        ))}
      </select>
    </div>
  )
}
