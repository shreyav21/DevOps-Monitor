interface Props {
  status: string;
}

export function StatusBadge({ status }: Props) {
  let color = "bg-green-500";

  if (status === "Warning") {
    color = "bg-yellow-500";
  }

  if (status === "Down") {
    color = "bg-red-500";
  }

  return (
    <span className="flex items-center gap-2">
      <span className={`h-3 w-3 rounded-full ${color}`} />

      {status}
    </span>
  );
}
