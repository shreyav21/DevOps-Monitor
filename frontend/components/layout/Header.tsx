"use client";

import { Bell, Search } from "lucide-react";

export function TopHeader() {
  return (
    <header className="flex h-16 items-center justify-between border-b bg-background px-6">
      <div className="flex items-center gap-3 rounded-lg border px-3 py-2 w-80">
        <Search size={18} />

        <input
          className="w-full bg-transparent outline-none"
          placeholder="Search..."
        />
      </div>

      <div className="flex items-center gap-4">
        <button className="rounded-lg border p-2">
          <Bell size={20} />
        </button>

        <div className="h-10 w-10 rounded-full bg-primary" />
      </div>
    </header>
  );
}
