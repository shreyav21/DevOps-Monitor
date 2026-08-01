"use client";

import { ResponsiveContainer, PieChart, Pie, Cell, Tooltip } from "recharts";

interface MemoryChartProps {
  data: {
    name: string;
    value: number;
  }[];
}

const COLORS = ["#22c55e", "#e5e7eb"];

export function MemoryChart({ data }: MemoryChartProps) {
  return (
    <div className="rounded-xl border bg-card p-5">
      <h3 className="mb-4 text-lg font-semibold">Memory Usage</h3>

      <div className="h-80">
        <ResponsiveContainer width="100%" height="100%">
          <PieChart>
            <Pie data={data} dataKey="value" outerRadius={110} label>
              {data.map((_, index) => (
                <Cell key={index} fill={COLORS[index % COLORS.length]} />
              ))}
            </Pie>

            <Tooltip />
          </PieChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
}
