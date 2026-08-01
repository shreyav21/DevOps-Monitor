"use client";

import { useEffect, useState } from "react";

import { AppSidebar } from "./Sidebar";
import { TopHeader } from "./Header";

import { MetricCard } from "../cards/MetricCard";
import { CpuChart } from "../charts/CpuChart";
import { MemoryChart } from "../charts/MemoryChart";
import { ServiceTable } from "../tables/ServiceTable";
import { LogsPanel } from "../dashboard/LogsPanel";

import { Cpu, HardDrive, MemoryStick, Wifi } from "lucide-react";

import { getDashboard } from "@/services/dashboardService";
import { DashboardResponse } from "@/types/dashboard";

export function DashboardLayout() {
  const [dashboard, setDashboard] = useState<DashboardResponse | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const loadDashboard = async () => {
    try {
      const response = await getDashboard();
      setDashboard(response);
      setError("");
    } catch (err) {
      console.error(err);
      setError("Failed to load dashboard.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadDashboard();

    const interval = setInterval(loadDashboard, 10000);

    return () => clearInterval(interval);
  }, []);

  if (loading) {
    return (
      <div className="flex h-screen items-center justify-center text-xl">
        Loading Dashboard...
      </div>
    );
  }

  if (error || !dashboard) {
    return (
      <div className="flex h-screen items-center justify-center text-red-500 text-xl">
        {error}
      </div>
    );
  }

  const cpuChartData = dashboard.history.map((item) => ({
    time: new Date(item.timestamp).toLocaleTimeString([], {
      hour: "2-digit",
      minute: "2-digit",
    }),
    usage: item.cpuUsage,
  }));

  const memoryChartData = [
    {
      name: "Used",
      value: dashboard.summary.memoryUsage,
    },
    {
      name: "Free",
      value: 100 - dashboard.summary.memoryUsage,
    },
  ];

  return (
    <div className="flex h-screen bg-background text-foreground">
      <AppSidebar />

      <div className="flex flex-1 flex-col overflow-hidden">
        <TopHeader />

        <main className="flex-1 overflow-y-auto p-6">
          <div className="mb-8">
            <h1 className="text-3xl font-bold">OpsVision Dashboard</h1>

            <p className="mt-2 text-muted-foreground">
              AI Powered DevOps Monitoring Platform
            </p>
          </div>

          <div className="grid gap-6 md:grid-cols-2 xl:grid-cols-4">
            <MetricCard
              title="CPU Usage"
              value={`${dashboard.summary.cpuUsage}%`}
              change="Live"
              trend="up"
              icon={Cpu}
            />

            <MetricCard
              title="Memory"
              value={`${dashboard.summary.memoryUsage}%`}
              change="Live"
              trend="up"
              icon={MemoryStick}
            />

            <MetricCard
              title="Disk"
              value={`${dashboard.summary.diskUsage}%`}
              change="Live"
              trend="up"
              icon={HardDrive}
            />

            <MetricCard
              title="Network"
              value={`${dashboard.summary.networkUsage} MB/s`}
              change="Live"
              trend="up"
              icon={Wifi}
            />
          </div>

          <div className="mt-8 grid gap-6 lg:grid-cols-2">
            <CpuChart data={cpuChartData} />

            <MemoryChart data={memoryChartData} />
          </div>

          <div className="mt-8 grid gap-6 lg:grid-cols-2">
            <ServiceTable services={dashboard.services} />

            <LogsPanel alerts={dashboard.alerts} />
          </div>
        </main>
      </div>
    </div>
  );
}
