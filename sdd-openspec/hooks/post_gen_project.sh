#!/usr/bin/env bash
# cookiecutter post-generation hook.
# Runs in the freshly generated project root and stands it up in place:
# pinned toolchain (mise) -> OpenSpec (Claude-only) -> git + git-flow-next.
# Best-effort: if the environment can't do it (no mise, offline, …),
# it warns and leaves the scaffold intact instead of failing generation.

set -u

warn() {
	echo "post-gen: $1 — automatic setup skipped." >&2
	echo "post-gen: finish it with: mise install && mise exec -- openspec init --tools claude --force && git init && mise exec -- git flow init --force --preset=classic --defaults && mise exec -- git flow config sync" >&2
	exit 0
}

command -v mise >/dev/null 2>&1 || warn "mise not found on PATH"

mise trust >/dev/null 2>&1 || warn "mise trust failed"
mise install || warn "mise install failed"

# Agent skills (petr-korobeinikov/skills) → .claude/skills/ — best-effort, non-blocking.
mise exec -- npx skills add petr-korobeinikov/skills --skill '*' --copy --agent claude-code -y \
	|| echo "post-gen: skills install failed — see README.md to install them." >&2

# OpenSpec — Claude only.
# Generates openspec/ + .claude/commands/opsx + .claude/skills/openspec-*.
mise exec -- openspec init --tools claude --force || warn "openspec init failed"

# git + git-flow-next.
# The branch model itself ships in the committed .gitflow (feature and bugfix branches
# rebase-collapsed on finish), so it survives cloning — .git/config does not.
# `init --force` only lays down main + develop and leaves .gitflow untouched;
# `config sync` then copies the shipped model into .git/config.
git rev-parse --is-inside-work-tree >/dev/null 2>&1 || git init -q || warn "git init failed"
mise exec -- git flow init --force --preset=classic --defaults || warn "git flow init failed"
mise exec -- git flow config sync || warn "git flow config sync failed"

echo "post-gen: OpenSpec (Claude-only) + git-flow-next initialized."
