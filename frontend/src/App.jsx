import './App.css'
import { ModelManagementPage } from './modules/model-management-service/pages/ModelManagementPage'

function App() {
  return (
    <div className="container">
      <header className="header">
        <h1>Hệ thống nhận dạng biển báo giao thông</h1>
      </header>

      <ModelManagementPage />
    </div>
  )
}

export default App
