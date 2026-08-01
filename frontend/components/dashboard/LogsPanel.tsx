"use client";

interface Alert {
  id: number;
  title: string;
  message: string;
  severity: string;
  source: string;
  status: string;
  createdAt: string;
}

interface LogsPanelProps {
  alerts: Alert[];
}

export function LogsPanel({ alerts }: LogsPanelProps) {
  return (
    <div className="rounded-xl border bg-card p-5">
      <h3 className="mb-5 text-lg font-semibold">Recent Alerts</h3>

      <div className="h-72 space-y-3 overflow-y-auto text-sm">
        {alerts.length === 0 ? (
          <div className="text-muted-foreground">No alerts available.</div>
        ) : (
          alerts.map((alert) => (
            <div key={alert.id} className="rounded-lg border bg-muted p-3">
              <div className="font-semibold">
                [{alert.severity}] {alert.title}
              </div>

              <div className="mt-1 text-muted-foreground">{alert.message}</div>

              <div className="mt-2 text-xs text-muted-foreground">
                {alert.source} • {alert.status}
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  );
}
