import { logs } from "@/data/logs";

export function LogsPanel() {
  return (
    <div className="rounded-xl border bg-card p-5">
      <h3 className="mb-5 text-lg font-semibold">Recent Logs</h3>

      <div className="h-72 overflow-y-auto space-y-3 text-sm font-mono">
        {logs.map((log, index) => (
          <div key={index} className="rounded bg-muted p-2">
            {log}
          </div>
        ))}
      </div>
    </div>
  );
}
