import { buildQueryParams, request } from '../../api-gateway/api/gatewayClient'

export function listModels({ taskType, status }) {
  const query = buildQueryParams({ taskType, status })
  return request(`/api/models?${query}`)
}

export function updateModel(modelId, payload) {
  return request(`/api/models/${modelId}`, { method: 'PUT', body: JSON.stringify(payload) })
}
