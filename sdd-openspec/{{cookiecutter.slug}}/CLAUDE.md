# CLAUDE.md

Spec-driven development on **OpenSpec**, Claude-only —
plan each change as an OpenSpec change before writing code,
and drive it with the `/opsx:*` commands.

Repo-specific conventions
(general mise / OpenSpec / git-flow usage lives in the installed skills):

- **One OpenSpec change ≈ one git-flow `feature/` branch:**
  `/opsx:propose "<id>"` ↔ `git flow feature start <id>`,
  `/opsx:archive` ↔ `git flow feature finish <id>`.
  Run `/opsx:sync` before archiving so `openspec/specs/` doesn't go stale.
- `openspec/` and the `opsx` / `openspec-*` glue under `.claude/` are generated —
  regenerate via `mise exec -- openspec update`, don't hand-edit.
