import { ApiStatusBanner } from '../../api-gateway/components/ApiStatusBanner'
import { ModelModal } from '../components/ModelModal'
import { ModelTable } from '../components/ModelTable'
import { ModelToolbar } from '../components/ModelToolbar'
import { useModelManagement } from '../hooks/useModelManagement'

export function ModelManagementPage() {
  const {
    models,
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
    closeModelModal,

  } = useModelManagement()

  return (
    <section className="panel">
      <ModelToolbar
        searchText={searchText}
        setSearchText={setSearchText}
        modelTaskType={modelTaskType}
        setModelTaskType={setModelTaskType}
        modelStatus={modelStatus}
        setModelStatus={setModelStatus}
      />

      <ApiStatusBanner error={error} />

      {loadingModels ? (
        <p>Đang tải dữ liệu...</p>
      ) : (
        <>
          <ModelTable
            models={models}
            onEdit={openEditModal}
          />
        </>
      )}

      <ModelModal
        open={modelModalOpen}
        mode="edit"
        form={modelForm}
        setForm={setModelForm}
        onClose={closeModelModal}
        onSubmit={submitModel}
      />
    </section>
  )
}
