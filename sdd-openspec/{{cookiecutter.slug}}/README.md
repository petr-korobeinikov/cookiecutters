# {{cookiecutter.title}}

> {{cookiecutter.description}}

Spec-driven development on [OpenSpec](https://github.com/Fission-AI/OpenSpec),
driven from Claude Code via the `/opsx:*` commands — no other AI-tool integration.
`cookiecutter` wired up the toolchain ([mise](https://mise.jdx.dev)),
OpenSpec, git-flow-next, and prek on generation.

## Workflow

Each change is one OpenSpec change on one git-flow feature branch:

```shell
git flow feature start <id>    # with /opsx:propose "<id>"
git flow feature finish <id>   # with /opsx:archive — run /opsx:sync first
```

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

```shell
mise exec -- prek install           # wire the hook
mise exec -- prek run --all-files   # every hook over the whole tree
```

The post-gen hook runs `prek install`.
Re-run it in a fresh clone and after a prek upgrade:
the generated `.git/hooks/pre-commit` pins the path of the prek binary
it was installed from, and that path carries the version.
