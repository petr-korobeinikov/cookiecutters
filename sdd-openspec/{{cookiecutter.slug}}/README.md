# {{cookiecutter.title}}

> {{cookiecutter.description}}

Spec-driven development on [OpenSpec](https://github.com/Fission-AI/OpenSpec),
driven from Claude Code via the `/opsx:*` commands — no other AI-tool integration.
`cookiecutter` wired up the toolchain ([mise](https://mise.jdx.dev)),
OpenSpec, and git-flow-next on generation.

## Workflow

Each change is one OpenSpec change on one git-flow feature branch:

```shell
git flow feature start <id>    # with /opsx:propose "<id>"
git flow feature finish <id>   # with /opsx:archive — run /opsx:sync first
```

Browse specs and changes with `mise exec -- openspec view`.
Skills aren't committed — Claude restores them from `skills-lock.json` on the first session.
