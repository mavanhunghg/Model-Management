export function ApiStatusBanner({ error }) {
  if (!error) return null
  return <div className="error">{error}</div>
}
