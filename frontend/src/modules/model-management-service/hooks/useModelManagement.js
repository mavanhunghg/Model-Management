import { useEffect, useMemo, useState } from 'react'
import { listModels, updateModel } from '../api/modelManagementApi'
import { emptyModelForm } from '../../../shared/constants/domainConstants'

export function useModelManagement() {
  const [models, setModels] = useState([])
  const [loadingModels, setLoadingModels] = useState(false)
  const [error, setError] = useState('')

  const [modelTaskType, setModelTaskType] = useState('')
  const [modelStatus, setModelStatus] = useState('')
  const [searchText, setSearchText] = useState('')

  const [modelModalOpen, setModelModalOpen] = useState(false)
  const [editingModel, setEditingModel] = useState(null)
  const [modelForm, setModelForm] = useState(emptyModelForm)

  const filteredModels = useMemo(() => {
    if (!searchText.trim()) return models
    const query = searchText.trim().toLowerCase()

    return models.filter((model) =>
      [model.name, model.version, model.framework, model.algorithm, model.taskType, model.status]
        .filter(Boolean)
        .join(' ')
        .toLowerCase()
        .includes(query),
    )
  }, [models, searchText])

  async function loadModels() {
    try {
      setLoadingModels(true)
      setError('')
      const data = await listModels({
        taskType: modelTaskType,
        status: modelStatus,
      })
      const normalizedModels = Array.isArray(data) ? data : data?.content
      setModels(normalizedModels || [])
    } catch (err) {
      setError(err.message)
    } finally {
      setLoadingModels(false)
    }
  }

  useEffect(() => {
    loadModels()
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [modelTaskType, modelStatus])

  function openEditModal(model) {
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
      if (editingModel) {
        await updateModel(editingModel.id, {
          version: modelForm.version,
          framework: modelForm.framework,
          description: modelForm.description,
        })
      }
      setModelModalOpen(false)
      await loadModels()
    } catch (err) {
      setError(err.message)
    }
  }

  return {
    models: filteredModels,
    loadingModels,
    error,
    modelTaskType,
    setModelTaskType,
    modelStatus,
    setModelStatus,
    searchText,
    setSearchText,
    modelModalOpen,
    modelForm,
    setModelForm,
    openEditModal,
    submitModel,
    closeModelModal: () => setModelModalOpen(false),
  }
}
