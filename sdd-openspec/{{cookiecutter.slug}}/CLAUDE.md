# CLAUDE.md

Spec-driven development on **OpenSpec**, Claude-only —
plan each change as an OpenSpec change before writing code,
and drive it with the `/opsx:*` commands.

Repo-specific conventions
(general mise / OpenSpec / git-flow usage lives in the installed skills):

- **One plan, one commit.**
  `/opsx:sync` runs before `/opsx:archive`,
  so `openspec/specs/` doesn't go stale,
  and `/opsx:archive` ↔ `git flow feature finish <id>`.
  A change is planned one of two ways:
  - **Ahead:** `/opsx:propose "<id>"` on `develop`,
    each plan committed alone;
    a plan may wait there, unimplemented, until its turn.
    Its implementation is then one commit on `feature/<id>`,
    with `git flow feature start <id>` right before `/opsx:apply`.
  - **Just in time:** `git flow feature start <id>` first,
    then `/opsx:propose "<id>"` and `/opsx:apply` on that branch;
    the plan, the code and the archive go in as one commit.
- **Every implementation runs in a clean session:**
  a fresh session starts it,
  and the session is cleared (`/clear`) once its branch is finished.
- `openspec/` and the `opsx` / `openspec-*` glue under `.claude/` are generated —
  regenerate via `mise exec -- openspec update`, don't hand-edit.
