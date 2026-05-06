const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080'

function buildRequestOptions(options) {
  return {
    headers: { 'Content-Type': 'application/json', ...(options.headers || {}) },
    ...options,
  }
}

async function parseError(response) {
  let message = `Request failed (${response.status})`
  try {
    const body = await response.json()
    message = body.message || body.error || message
  } catch {
    // Ignore invalid JSON body
  }
  return new Error(message)
}

export async function request(path, options = {}) {
  const response = await fetch(`${API_BASE_URL}${path}`, buildRequestOptions(options))

  if (!response.ok) {
    throw await parseError(response)
  }

  if (response.status === 204) return null
  return response.json()
}

export function buildQueryParams(params) {
  const query = new URLSearchParams()
  Object.entries(params).forEach(([key, value]) => {
    if (value !== '' && value !== null && value !== undefined) {
      query.set(key, String(value))
    }
  })
  return query.toString()
}
