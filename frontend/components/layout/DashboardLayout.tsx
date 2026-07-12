import { AppSidebar } from "./Sidebar";
import { TopHeader } from "./Header";
import { MetricCard } from "../cards/MetricCard";
import { Cpu, HardDrive, MemoryStick, Wifi } from "lucide-react";
import { CpuChart } from "../charts/CpuChart";
import { MemoryChart } from "../charts/MemoryChart";

export function DashboardLayout() {
  return (
    <div className="flex h-screen bg-background text-foreground">
      <AppSidebar />

      <div className="flex flex-1 flex-col overflow-hidden">
        <TopHeader />

        <main className="flex-1 overflow-y-auto p-6">
          <div className="mb-8">
            <h1 className="text-3xl font-bold">OpsVision Dashboard</h1>

            <p className="text-muted-foreground mt-2">
              AI Powered DevOps Monitoring Platform
            </p>
          </div>

          <div className="grid gap-6 md:grid-cols-2 xl:grid-cols-4">
            <MetricCard
              title="CPU Usage"
              value="43%"
              change="+3.2%"
              trend="up"
              icon={Cpu}
            />

            <MetricCard
              title="Memory"
              value="68%"
              change="+1.8%"
              trend="up"
              icon={MemoryStick}
            />

            <MetricCard
              title="Disk"
              value="54%"
              change="-2.1%"
              trend="down"
              icon={HardDrive}
            />

            <MetricCard
              title="Network"
              value="124 MB/s"
              change="+8.4%"
              trend="up"
              icon={Wifi}
            />
          </div>

          <div className="mt-8 grid gap-6 lg:grid-cols-2">
            <CpuChart />
            <MemoryChart />
          </div>

          <div className="mt-8 rounded-xl border h-72 flex items-center justify-center">
            Recent Logs
          </div>
        </main>
      </div>
    </div>
  );
}
