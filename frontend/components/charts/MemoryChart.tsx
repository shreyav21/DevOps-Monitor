"use client";

import { ResponsiveContainer, PieChart, Pie, Cell, Tooltip } from "recharts";

import { memoryData } from "@/data/chartData";

const COLORS = ["#22c55e", "#e5e7eb"];

export function MemoryChart() {
  return (
    <div className="rounded-xl border bg-card p-5">
      <h3 className="mb-4 text-lg font-semibold">Memory Usage</h3>

      <div className="h-80">
        <ResponsiveContainer width="100%" height="100%">
          <PieChart>
            <Pie data={memoryData} dataKey="value" outerRadius={110} label>
              {memoryData.map((_, index) => (
                <Cell key={index} fill={COLORS[index]} />
              ))}
            </Pie>

            <Tooltip />
          </PieChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
}
