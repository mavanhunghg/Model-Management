import { useEffect, useMemo, useState } from 'react'
import './App.css'

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080'
const PAGE_SIZE = 10
const TASK_TYPES = ['CLASSIFICATION', 'DETECTION', 'SEGMENTATION']
const MODEL_STATUSES = ['ACTIVE', 'INACTIVE', 'DEPRECATED', 'RETRAINING']
const SESSION_STATUSES = ['PENDING', 'RUNNING', 'COMPLETED', 'FAILED', 'CANCELLED']
const DATASET_OPTIONS = [1, 2, 3, 4, 5]

const emptyModelForm = {
  name: '',
  version: '',
  taskType: 'CLASSIFICATION',
  framework: '',
  algorithm: '',
  description: '',
}

const emptyRetrainForm = {
  datasetId: '1',
  learningRate: '0.001',
  epochs: '100',
  batchSize: '32',
  note: '',
}

async function request(path, options = {}) {
  const response = await fetch(`${API_BASE_URL}${path}`, {
    headers: { 'Content-Type': 'application/json', ...(options.headers || {}) },
    ...options,
  })

  if (!response.ok) {
    let message = `Request failed (${response.status})`
    try {
      const body = await response.json()
      message = body.message || body.error || message
    } catch {
      // ignore
    }
    throw new Error(message)
  }

  if (response.status === 204) return null
  return response.json()
}

function formatDate(value) {
  if (!value) return 'N/A'
  const d = new Date(value)
  if (Number.isNaN(d.getTime())) return 'N/A'
  return d.toLocaleString('vi-VN')
}

function formatPercent(value) {
  if (value === null || value === undefined) return 'N/A'
  return `${(Number(value) * 100).toFixed(1)}%`
}

function formatDuration(seconds) {
  if (seconds === null || seconds === undefined) return 'N/A'
  const total = Number(seconds)
  const h = Math.floor(total / 3600)
  const m = Math.floor((total % 3600) / 60)
  const s = total % 60
  if (h > 0) return `${h}h ${m}m ${s}s`
  if (m > 0) return `${m}m ${s}s`
  return `${s}s`
}

function ModelModal({ open, mode, form, setForm, onClose, onSubmit }) {
  if (!open) return null
  const isEdit = mode === 'edit'

  return (
    <div className="modal-overlay" role="dialog" aria-modal="true">
      <div className="modal">
        <h3>{isEdit ? 'Chỉnh sửa mô hình' : 'Thêm mới mô hình'}</h3>
        <div className="form-grid">
          <label>
            Tên mô hình
            <input
              value={form.name}
              disabled={isEdit}
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
              disabled={isEdit}
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
              disabled={isEdit}
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

function RetrainModal({ open, model, form, setForm, onClose, onSubmit }) {
  if (!open || !model) return null

  return (
    <div className="modal-overlay" role="dialog" aria-modal="true">
      <div className="modal">
        <h3>Retrain mô hình</h3>
        <div className="form-grid">
          <label>
            Tên mô hình
            <input value={model.name} disabled />
          </label>
          <label>
            Phiên bản
            <input value={model.version} disabled />
          </label>
          <label>
            Loại tác vụ
            <input value={model.taskType} disabled />
          </label>
          <label>
            Dataset
            <select value={form.datasetId} onChange={(e) => setForm({ ...form, datasetId: e.target.value })}>
              {DATASET_OPTIONS.map((dataset) => (
                <option key={dataset} value={String(dataset)}>
                  Dataset #{dataset}
                </option>
              ))}
            </select>
          </label>
          <label>
            Learning Rate
            <input
              type="number"
              step="0.0001"
              value={form.learningRate}
              onChange={(e) => setForm({ ...form, learningRate: e.target.value })}
            />
          </label>
          <label>
            Epochs
            <input
              type="number"
              value={form.epochs}
              onChange={(e) => setForm({ ...form, epochs: e.target.value })}
            />
          </label>
          <label>
            Batch Size
            <input
              type="number"
              value={form.batchSize}
              onChange={(e) => setForm({ ...form, batchSize: e.target.value })}
            />
          </label>
          <label className="full-width">
            Ghi chú
            <textarea rows={3} value={form.note} onChange={(e) => setForm({ ...form, note: e.target.value })} />
          </label>
        </div>
        <div className="modal-actions">
          <button className="secondary" onClick={onClose}>
            Hủy
          </button>
          <button className="primary" onClick={onSubmit}>
            Bắt đầu Retrain
          </button>
        </div>
      </div>
    </div>
  )
}

function App() {
  const [activeTab, setActiveTab] = useState('models')
  const [models, setModels] = useState([])
  const [modelPage, setModelPage] = useState(0)
  const [modelTotalPages, setModelTotalPages] = useState(1)
  const [modelTaskType, setModelTaskType] = useState('')
  const [modelStatus, setModelStatus] = useState('')
  const [searchText, setSearchText] = useState('')
  const [loadingModels, setLoadingModels] = useState(false)

  const [summary, setSummary] = useState(null)
  const [sessions, setSessions] = useState([])
  const [sessionPage, setSessionPage] = useState(0)
  const [sessionTotalPages, setSessionTotalPages] = useState(1)
  const [sessionTaskType, setSessionTaskType] = useState('')
  const [sessionStatus, setSessionStatus] = useState('')
  const [loadingStats, setLoadingStats] = useState(false)

  const [error, setError] = useState('')
  const [modelModalOpen, setModelModalOpen] = useState(false)
  const [modelModalMode, setModelModalMode] = useState('create')
  const [editingModel, setEditingModel] = useState(null)
  const [modelForm, setModelForm] = useState(emptyModelForm)

  const [retrainModalOpen, setRetrainModalOpen] = useState(false)
  const [retrainModel, setRetrainModel] = useState(null)
  const [retrainForm, setRetrainForm] = useState(emptyRetrainForm)

  const filteredModels = useMemo(() => {
    if (!searchText.trim()) return models
    const query = searchText.trim().toLowerCase()
    return models.filter((m) =>
      [m.name, m.version, m.framework, m.algorithm, m.taskType, m.status]
        .filter(Boolean)
        .join(' ')
        .toLowerCase()
        .includes(query),
    )
  }, [models, searchText])

  async function loadModels(page = modelPage) {
    try {
      setError('')
      setLoadingModels(true)
      const params = new URLSearchParams({ page: String(page), size: String(PAGE_SIZE) })
      if (modelTaskType) params.set('taskType', modelTaskType)
      if (modelStatus) params.set('status', modelStatus)
      const data = await request(`/api/models?${params.toString()}`)
      setModels(data.content || [])
      setModelPage(data.number || 0)
      setModelTotalPages(Math.max(1, data.totalPages || 1))
    } catch (err) {
      setError(err.message)
    } finally {
      setLoadingModels(false)
    }
  }

  async function loadStatistics(page = sessionPage) {
    try {
      setError('')
      setLoadingStats(true)
      const [summaryData, sessionsData] = await Promise.all([
        request('/api/statistics/summary'),
        request(
          `/api/statistics/sessions?${new URLSearchParams({
            page: String(page),
            size: String(PAGE_SIZE),
            ...(sessionTaskType ? { taskType: sessionTaskType } : {}),
            ...(sessionStatus ? { status: sessionStatus } : {}),
          }).toString()}`,
        ),
      ])
      setSummary(summaryData)
      setSessions(sessionsData.content || [])
      setSessionPage(sessionsData.number || 0)
      setSessionTotalPages(Math.max(1, sessionsData.totalPages || 1))
    } catch (err) {
      setError(err.message)
    } finally {
      setLoadingStats(false)
    }
  }

  useEffect(() => {
    loadModels(0)
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [modelTaskType, modelStatus])

  useEffect(() => {
    loadStatistics(0)
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [sessionTaskType, sessionStatus])

  function openCreateModal() {
    setModelModalMode('create')
    setEditingModel(null)
    setModelForm(emptyModelForm)
    setModelModalOpen(true)
  }

  function openEditModal(model) {
    setModelModalMode('edit')
    setEditingModel(model)
    setModelForm({
      name: model.name || '',
      version: model.version || '',
      taskType: model.taskType || 'CLASSIFICATION',
      framework: model.framework || '',
      algorithm: model.algorithm || '',
      description: model.description || '',
    })
    setModelModalOpen(true)
  }

  async function submitModel() {
    try {
      setError('')
      if (modelModalMode === 'create') {
        await request('/api/models', { method: 'POST', body: JSON.stringify(modelForm) })
      } else if (editingModel) {
        await request(`/api/models/${editingModel.id}`, {
          method: 'PUT',
          body: JSON.stringify({
            version: modelForm.version,
            framework: modelForm.framework,
            description: modelForm.description,
          }),
        })
      }
      setModelModalOpen(false)
      await loadModels(0)
    } catch (err) {
      setError(err.message)
    }
  }

  async function deleteModel(model) {
    if (!window.confirm(`Xóa mô hình "${model.name}"?`)) return
    try {
      setError('')
      await request(`/api/models/${model.id}`, { method: 'DELETE' })
      await loadModels(modelPage)
    } catch (err) {
      setError(err.message)
    }
  }

  async function toggleModelActivation(model) {
    const path = model.isActive ? `/api/models/${model.id}/deactivate` : `/api/models/${model.id}/activate`
    try {
      setError('')
      await request(path, { method: 'PATCH' })
      await loadModels(modelPage)
    } catch (err) {
      setError(err.message)
    }
  }

  function openRetrainModal(model) {
    setRetrainModel(model)
    setRetrainForm(emptyRetrainForm)
    setRetrainModalOpen(true)
  }

  async function submitRetrain() {
    if (!retrainModel) return
    try {
      setError('')
      await request(`/api/models/${retrainModel.id}/retrain`, {
        method: 'POST',
        body: JSON.stringify({
          datasetId: Number(retrainForm.datasetId),
          config: {
            learningRate: Number(retrainForm.learningRate),
            epochs: Number(retrainForm.epochs),
            batchSize: Number(retrainForm.batchSize),
            note: retrainForm.note,
          },
        }),
      })
      setRetrainModalOpen(false)
      await loadModels(modelPage)
      await loadStatistics(0)
    } catch (err) {
      setError(err.message)
    }
  }

  return (
    <div className="container">
      <header className="header">
        <h1>Model Management</h1>
        <p>Quản lý mô hình đã huấn luyện & thống kê phiên huấn luyện</p>
      </header>

      <div className="tabs">
        <button className={activeTab === 'models' ? 'tab active' : 'tab'} onClick={() => setActiveTab('models')}>
          Module 1 - Models
        </button>
        <button className={activeTab === 'statistics' ? 'tab active' : 'tab'} onClick={() => setActiveTab('statistics')}>
          Module 2 - Statistics
        </button>
      </div>

      {error && <div className="error">{error}</div>}

      {activeTab === 'models' && (
        <section className="panel">
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
            <button className="primary" onClick={openCreateModal}>
              Thêm mới
            </button>
          </div>

          {loadingModels ? (
            <p>Đang tải dữ liệu...</p>
          ) : (
            <>
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
                  {filteredModels.map((model, index) => {
                    const disablingByRetraining = model.status === 'RETRAINING'
                    return (
                      <tr key={model.id}>
                        <td>{modelPage * PAGE_SIZE + index + 1}</td>
                        <td>{model.name}</td>
                        <td>{model.version}</td>
                        <td>{model.taskType}</td>
                        <td>{model.framework}</td>
                        <td>
                          <span className={`badge ${String(model.status || '').toLowerCase()}`}>{model.status}</span>
                        </td>
                        <td>{formatDate(model.createdAt)}</td>
                        <td className="actions">
                          <button className="secondary" onClick={() => openEditModal(model)}>
                            Sửa
                          </button>
                          <button
                            className={model.isActive ? 'warn' : 'success'}
                            onClick={() => toggleModelActivation(model)}
                            disabled={disablingByRetraining}
                          >
                            {model.isActive ? 'Vô hiệu hóa' : 'Kích hoạt'}
                          </button>
                          <button
                            className="purple"
                            onClick={() => openRetrainModal(model)}
                            disabled={disablingByRetraining}
                          >
                            Retrain
                          </button>
                          <button
                            className="danger"
                            onClick={() => deleteModel(model)}
                            disabled={model.isActive || disablingByRetraining}
                          >
                            Xóa
                          </button>
                        </td>
                      </tr>
                    )
                  })}
                  {filteredModels.length === 0 && (
                    <tr>
                      <td colSpan={8}>Không có dữ liệu</td>
                    </tr>
                  )}
                </tbody>
              </table>
              <div className="pagination">
                <button disabled={modelPage <= 0} onClick={() => loadModels(modelPage - 1)}>
                  Prev
                </button>
                <span>
                  Trang {modelPage + 1}/{modelTotalPages}
                </span>
                <button disabled={modelPage + 1 >= modelTotalPages} onClick={() => loadModels(modelPage + 1)}>
                  Next
                </button>
              </div>
            </>
          )}
        </section>
      )}

      {activeTab === 'statistics' && (
        <section className="panel">
          <div className="toolbar">
            <select value={sessionTaskType} onChange={(e) => setSessionTaskType(e.target.value)}>
              <option value="">Tất cả task</option>
              {TASK_TYPES.map((item) => (
                <option key={item} value={item}>
                  {item}
                </option>
              ))}
            </select>
            <select value={sessionStatus} onChange={(e) => setSessionStatus(e.target.value)}>
              <option value="">Tất cả trạng thái</option>
              {SESSION_STATUSES.map((item) => (
                <option key={item} value={item}>
                  {item}
                </option>
              ))}
            </select>
            <button className="secondary" onClick={() => loadStatistics(sessionPage)}>
              Làm mới
            </button>
          </div>

          {loadingStats ? (
            <p>Đang tải dữ liệu...</p>
          ) : (
            <>
              <div className="kpi-grid">
                <article className="kpi-card blue">
                  <h4>Tổng số phiên</h4>
                  <strong>{summary?.totalSessions ?? 0}</strong>
                </article>
                <article className="kpi-card teal">
                  <h4>Tổng thời gian</h4>
                  <strong>{formatDuration(summary?.totalDurationSeconds ?? 0)}</strong>
                </article>
                <article className="kpi-card amber">
                  <h4>Best Accuracy</h4>
                  <strong>
                    {summary?.bestModelName || 'N/A'} · {formatPercent(summary?.bestAccuracy)}
                  </strong>
                </article>
                <article className="kpi-card green">
                  <h4>Tỷ lệ thành công</h4>
                  <strong>{summary?.successRate?.toFixed?.(1) ?? '0.0'}%</strong>
                </article>
              </div>

              <table>
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>Tên mô hình</th>
                    <th>Task</th>
                    <th>Loại phiên</th>
                    <th>Trạng thái</th>
                    <th>Accuracy</th>
                    <th>Loss</th>
                    <th>Thời gian</th>
                    <th>Bắt đầu</th>
                    <th>Log</th>
                  </tr>
                </thead>
                <tbody>
                  {sessions.map((session, index) => (
                    <tr key={session.id}>
                      <td>{sessionPage * PAGE_SIZE + index + 1}</td>
                      <td>{session.modelName || `Model #${session.modelId}`}</td>
                      <td>{session.taskType}</td>
                      <td>
                        <span className={`badge ${String(session.trainingType || '').toLowerCase()}`}>
                          {session.trainingType}
                        </span>
                      </td>
                      <td>
                        <span className={`badge ${String(session.status || '').toLowerCase()}`}>{session.status}</span>
                      </td>
                      <td>{formatPercent(session.accuracy)}</td>
                      <td>{session.loss ?? 'N/A'}</td>
                      <td>{formatDuration(session.durationSeconds)}</td>
                      <td>{formatDate(session.startTime)}</td>
                      <td>{session.trainLogPath || 'N/A'}</td>
                    </tr>
                  ))}
                  {sessions.length === 0 && (
                    <tr>
                      <td colSpan={10}>Chưa có dữ liệu training session</td>
                    </tr>
                  )}
                </tbody>
              </table>
              <div className="pagination">
                <button disabled={sessionPage <= 0} onClick={() => loadStatistics(sessionPage - 1)}>
                  Prev
                </button>
                <span>
                  Trang {sessionPage + 1}/{sessionTotalPages}
                </span>
                <button
                  disabled={sessionPage + 1 >= sessionTotalPages}
                  onClick={() => loadStatistics(sessionPage + 1)}
                >
                  Next
                </button>
              </div>
            </>
          )}
        </section>
      )}

      <ModelModal
        open={modelModalOpen}
        mode={modelModalMode}
        form={modelForm}
        setForm={setModelForm}
        onClose={() => setModelModalOpen(false)}
        onSubmit={submitModel}
      />

      <RetrainModal
        open={retrainModalOpen}
        model={retrainModel}
        form={retrainForm}
        setForm={setRetrainForm}
        onClose={() => setRetrainModalOpen(false)}
        onSubmit={submitRetrain}
      />
    </div>
  )
}

export default App
