export interface DashboardSummary {
  cpuUsage: number;
  memoryUsage: number;
  diskUsage: number;
  networkUsage: number;
  lastUpdated: string;
}

export interface DashboardHistory {
  cpuUsage: number;
  memoryUsage: number;
  diskUsage: number;
  networkUsage: number;
  timestamp: string;
}

export interface ServiceStatus {
  id: number;
  name: string;
  status: string;
  cpuUsage: number;
  memoryUsage: number;
  uptime: number;
  lastUpdated: string;
}

export interface Alert {
  id: number;
  title: string;
  message: string;
  severity: string;
  source: string;
  status: string;
  createdAt: string;
}

export interface DashboardResponse {
  summary: DashboardSummary;
  history: DashboardHistory[];
  services: ServiceStatus[];
  alerts: Alert[];
}
