# {{cookiecutter.title}}

> {{cookiecutter.description}}

Spec-driven development on [OpenSpec](https://github.com/Fission-AI/OpenSpec),
driven from Claude Code via the `/opsx:*` commands — no other AI-tool integration.
`cookiecutter` wired up the toolchain ([mise](https://mise.jdx.dev)),
OpenSpec, git-flow-next, and prek on generation.
The template asked mise for Node's `lts`;
the post-gen hook pinned the version it resolved to, in full,
as every other tool in `mise.toml` is pinned.

## Workflow

Each change is one OpenSpec change,
and every plan is one commit.
It is planned one of two ways,
and `/opsx:sync` runs before `/opsx:archive` either way.

**Ahead.**
Each plan is proposed on `develop` and committed alone,
and may wait there, unimplemented, until its turn.
Its implementation is one commit on its own branch:

```shell
git flow feature start <id>    # right before /opsx:apply
git flow feature finish <id>   # after /opsx:sync, /opsx:archive and the commit
```

**Just in time.**
The branch comes first,
and the plan, the code and the archive go in as one commit:

```shell
git flow feature start <id>    # then /opsx:propose "<id>" and /opsx:apply on it
git flow feature finish <id>   # after /opsx:sync, /opsx:archive and the commit
```

Every implementation runs in a clean Claude Code session,
which is cleared with `/clear` once its branch is finished.

Browse specs and changes with `mise exec -- openspec view`.

The post-gen hook installs the agent skills into `.claude/skills/`.
Re-run to update them or install them in a fresh clone:

```shell
mise exec -- npx skills add petr-korobeinikov/skills --skill '*' --copy --agent claude-code -y
```

## Hooks

[prek](https://prek.j178.dev/) holds the gate before a commit is allowed.
It is pinned in `mise.toml` and configured in `prek.toml` —
prek's own TOML format, which takes precedence over a `.pre-commit-config.yaml`.

Every file-hygiene hook is one of prek's own Rust implementations —
`repo = "builtin"` — so this repository clones no hook repositories
and pins no third-party revs:
there is nothing to `prek update`, and nothing extra to audit.

One more builtin, `deny-pattern`, reads the commit message
and refuses a subject over 72 characters,
so that `git log --oneline` gives each commit one line.
The subject is the first line that is neither blank nor a comment,
counted in characters rather than bytes,
without the trailing whitespace git strips;
the lines after it are not measured,
though `git log --oneline` joins those before the first blank line to it.
This hook alone runs at `commit-msg`;
every other one runs at `pre-commit`.
`git commit --no-verify` skips it with the rest,
and git calls no hook for a revert, a cherry-pick or a rebase,
even where the message is edited, as in a squash:
only a `reword`, and a cherry-pick or revert finished after a conflict,
run both hooks.

```shell
mise exec -- prek install           # wire both git hooks
mise exec -- prek run --all-files   # every pre-commit hook over the whole tree
```

The post-gen hook runs `prek install`.
Re-run it in a fresh clone and after a prek upgrade:
the generated `.git/hooks/pre-commit` and `.git/hooks/commit-msg`
pin the path of the prek binary they were installed from,
and that path carries the version.
