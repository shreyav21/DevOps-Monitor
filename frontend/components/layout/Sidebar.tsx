"use client";

import {
  LayoutDashboard,
  Activity,
  Boxes,
  Server,
  Bot,
  Settings,
} from "lucide-react";

const menuItems = [
  {
    title: "Dashboard",
    icon: LayoutDashboard,
  },
  {
    title: "Monitoring",
    icon: Activity,
  },
  {
    title: "Containers",
    icon: Boxes,
  },
  {
    title: "Services",
    icon: Server,
  },
  {
    title: "AI Insights",
    icon: Bot,
  },
  {
    title: "Settings",
    icon: Settings,
  },
];

export function AppSidebar() {
  return (
    <aside className="hidden w-64 border-r bg-card lg:flex lg:flex-col">
      <div className="border-b p-6">
        <h2 className="text-2xl font-bold">DevOps-Monitor</h2>

        <p className="text-sm text-muted-foreground mt-1">
          DevOps Command Center
        </p>
      </div>

      <nav className="flex-1 p-4">
        {menuItems.map((item) => {
          const Icon = item.icon;

          return (
            <button
              key={item.title}
              className="mb-2 flex w-full items-center gap-3 rounded-lg px-4 py-3 transition hover:bg-muted"
            >
              <Icon size={20} />

              <span>{item.title}</span>
            </button>
          );
        })}
      </nav>
    </aside>
  );
}
