import { useState } from 'react'
import './App.css'
import { ServiceTabs } from './modules/api-gateway/components/ServiceTabs'
import { ModelManagementPage } from './modules/model-management-service/pages/ModelManagementPage'
import { StatisticsDashboardPage } from './modules/statistics-service/pages/StatisticsDashboardPage'

function App() {
  const [activeTab, setActiveTab] = useState('models')
  const [statisticsRefreshSignal, setStatisticsRefreshSignal] = useState(0)

  function handleRetrainSuccess() {
    setStatisticsRefreshSignal((prev) => prev + 1)
  }

  return (
    <div className="container">
      <header className="header">
        <h1>He thong nhan dang va thong bao bien bao giao thong</h1>
      </header>

      <ServiceTabs activeTab={activeTab} onChange={setActiveTab} />

      {activeTab === 'models' && <ModelManagementPage onRetrainSuccess={handleRetrainSuccess} />}
      {activeTab === 'statistics' && <StatisticsDashboardPage refreshSignal={statisticsRefreshSignal} />}
    </div>
  )
}

export default App
