"use client";

import {
  ResponsiveContainer,
  AreaChart,
  Area,
  CartesianGrid,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";

import { cpuData } from "@/data/chartData";

export function CpuChart() {
  return (
    <div className="rounded-xl border bg-card p-5">
      <h3 className="mb-4 text-lg font-semibold">CPU Usage</h3>

      <div className="h-80">
        <ResponsiveContainer width="100%" height="100%">
          <AreaChart data={cpuData}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="time" />
            <YAxis unit="%" />
            <Tooltip />
            <Area
              type="monotone"
              dataKey="usage"
              stroke="#2563eb"
              fill="#3b82f6"
              fillOpacity={0.3}
            />
          </AreaChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
}
