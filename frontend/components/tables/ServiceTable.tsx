"use client";

import { StatusBadge } from "../shared/StatusBadge";

interface Service {
  id: number;
  name: string;
  status: string;
  cpuUsage: number;
  memoryUsage: number;
  uptime: number;
  lastUpdated: string;
}

interface ServiceTableProps {
  services: Service[];
}

export function ServiceTable({ services }: ServiceTableProps) {
  return (
    <div className="rounded-xl border bg-card p-5">
      <h3 className="mb-5 text-lg font-semibold">Service Health</h3>

      {services.length === 0 ? (
        <div className="py-8 text-center text-muted-foreground">
          No services available.
        </div>
      ) : (
        <table className="w-full">
          <thead>
            <tr className="border-b">
              <th className="py-3 text-left">Service</th>
              <th className="text-left">Status</th>
              <th className="text-left">CPU</th>
              <th className="text-left">Memory</th>
              <th className="text-left">Uptime</th>
            </tr>
          </thead>

          <tbody>
            {services.map((service) => (
              <tr key={service.id} className="border-b last:border-none">
                <td className="py-4">{service.name}</td>

                <td>
                  <StatusBadge status={service.status} />
                </td>

                <td>{service.cpuUsage}%</td>

                <td>{service.memoryUsage}%</td>

                <td>{service.uptime}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
