import { AppSidebar } from "./Sidebar";
import { TopHeader } from "./Header";

export function DashboardLayout() {
  return (
    <div className="flex h-screen bg-background text-foreground">
      <AppSidebar />

      <div className="flex flex-1 flex-col overflow-hidden">
        <TopHeader />

        <main className="flex-1 overflow-y-auto p-6">
          <div className="grid gap-6">
            <div>
              <h1 className="text-3xl font-bold">DevOps Dashboard</h1>

              <p className="text-muted-foreground mt-2">
                AI Powered DevOps Monitoring Platform
              </p>
            </div>

            <div className="grid gap-4 md:grid-cols-2 xl:grid-cols-4">
              <div className="rounded-xl border p-6">CPU Usage</div>

              <div className="rounded-xl border p-6">Memory Usage</div>

              <div className="rounded-xl border p-6">Disk Usage</div>

              <div className="rounded-xl border p-6">Network</div>
            </div>

            <div className="rounded-xl border h-96 flex items-center justify-center">
              Charts Coming Soon
            </div>

            <div className="rounded-xl border h-72 flex items-center justify-center">
              Recent Logs
            </div>
          </div>
        </main>
      </div>
    </div>
  );
}
