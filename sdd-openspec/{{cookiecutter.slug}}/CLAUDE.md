# CLAUDE.md

Spec-driven development on **OpenSpec**, Claude-only —
plan each change as an OpenSpec change before writing code,
and drive it with the `/opsx:*` commands.

Repo-specific conventions
(general mise / OpenSpec / git-flow usage lives in the installed skills):

- **A session plans or implements, never both, and ends on a clean tree.**
  A plan or a replan (`/opsx:propose`, `/opsx:update`) runs in a fresh session at effort max,
  an implementation in a fresh session at effort high.
  Before `/clear`, everything the session wrote is committed:
  no session hands uncommitted work to the next.
- **A plan is a commit of its own, and so is a replan:**
  on `develop` until the change has its branch, on `feature/<id>` from then on.
  A change is planned one of two ways:
  - **Ahead,** when it is planned now and implemented later:
    `/opsx:propose "<id>"` on `develop`, one commit per plan,
    only for a change that depends on nothing still unlanded;
    it may wait there, unimplemented, until its turn.
  - **Just in time,** when it is implemented right after it is planned,
    and always for a change that builds on one still in flight,
    once that one has landed on `develop`:
    `git flow feature start <id>` first,
    then `/opsx:propose "<id>"` on that branch,
    and `/clear` before the implementation.
- **A planning session writes the plan alone,**
  no code, not even in a scratch clone.
  A fact it cannot settle from the docs or the code is probed only with the operator's yes,
  or recorded as an assumption that the first task checks.
- **The implementation runs on `feature/<id>`,**
  started with `git flow feature start <id>` right before `/opsx:apply` for a plan made ahead.
  It lands as one commit or several split by meaning, each green, as the operator picks.
  `/opsx:sync` runs before `/opsx:archive`,
  so `openspec/specs/` doesn't go stale,
  and `/opsx:archive` ↔ `git flow feature finish <id>`.
- **A decision the plan did not make stops the implementation, and so does a change wider than its specs:**
  its code is committed on `feature/<id>` as `wip(<id>): …`,
  a fresh session replans it —
  the decision made, or the change narrowed and the rest made a change of its own,
  planned by the rules above —
  and another fresh session resumes the implementation.
  Before the finish, `wip` commits are split again by meaning,
  and code the narrowed change no longer covers leaves the branch.
- **Every commit but a `wip` one waits for the operator's review of its diff;**
  a passing hook or a request to finish does not replace it.
- **Memory keeps decisions and preferences, never the state of work:**
  what is uncommitted, under review or parked is read from git and `openspec list`.
- **Replies are concrete, dry and strictly to the point:**
  the answer first, no filler, no recap.
  A full screen is justified only by substance;
  half a screen of filler is already too much.
- `openspec/` and the `opsx` / `openspec-*` glue under `.claude/` are generated —
  regenerate via `mise exec -- openspec update`, don't hand-edit.
