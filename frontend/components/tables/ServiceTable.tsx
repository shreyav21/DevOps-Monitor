import { services } from "@/data/services";
import { StatusBadge } from "../shared/StatusBadge";

export function ServiceTable() {
  return (
    <div className="rounded-xl border bg-card p-5">
      <h3 className="mb-5 text-lg font-semibold">Service Health</h3>

      <table className="w-full">
        <thead>
          <tr className="border-b">
            <th className="py-3 text-left">Service</th>
            <th className="text-left">Status</th>
            <th className="text-left">Response</th>
            <th className="text-left">Uptime</th>
          </tr>
        </thead>

        <tbody>
          {services.map((service) => (
            <tr key={service.name} className="border-b last:border-none">
              <td className="py-4">{service.name}</td>

              <td>
                <StatusBadge status={service.status} />
              </td>

              <td>{service.responseTime}</td>

              <td>{service.uptime}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
