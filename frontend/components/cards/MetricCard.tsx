import { ArrowDown, ArrowUp, LucideIcon } from "lucide-react";

interface MetricCardProps {
  title: string;
  value: string;
  change: string;
  trend: "up" | "down";
  icon: LucideIcon;
}

export function MetricCard({
  title,
  value,
  change,
  trend,
  icon: Icon,
}: MetricCardProps) {
  const positive = trend === "up";

  return (
    <div className="rounded-xl border bg-card p-5 shadow-sm transition-all hover:shadow-md">
      <div className="flex items-center justify-between">
        <div>
          <p className="text-sm text-muted-foreground">{title}</p>

          <h2 className="mt-2 text-3xl font-bold">{value}</h2>

          <div
            className={`mt-3 flex items-center gap-1 text-sm ${
              positive ? "text-green-500" : "text-red-500"
            }`}
          >
            {positive ? <ArrowUp size={16} /> : <ArrowDown size={16} />}

            {change}
          </div>
        </div>

        <div className="rounded-xl bg-primary/10 p-3">
          <Icon className="text-primary" size={28} />
        </div>
      </div>
    </div>
  );
}
