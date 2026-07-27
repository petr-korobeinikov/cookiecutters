# cookiecutters

Cookiecutters for various projects.

## Usage

Execute cookiecutter with the chosen template directory:

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory <directory-name>
```

### Spec Driven Development :: OpenSpec

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory sdd-openspec
```

Scaffolds a spec-driven-development project built on [OpenSpec](https://github.com/Fission-AI/OpenSpec),
driven entirely through Claude Code
(the `/opsx:*` commands and `openspec-*` skills — no other AI-tool integration).
A post-generation hook stands the project up automatically via [mise](https://mise.jdx.dev):
it materializes the pinned toolchain
(Node — LTS — for the OpenSpec CLI, the OpenSpec CLI itself, and git-flow-next),
runs `openspec init --tools claude`,
and initializes the classic Gitflow branch model
(`main` + `develop`, feature branches rebased onto `develop`).

Skills pinned in `skills-lock.json` aren't committed —
Claude Code restores them from the lockfile on the first session
(the `npx skills` workflow).

### LeetCode :: Go

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-go
```

### LeetCode :: Kotlin

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-kotlin
```

### LeetCode :: PostgreSQL

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-postgresql
```

Spins up PostgreSQL 16 via Docker Compose. Put the problem schema and sample data in `init/schema.sql` (loaded on container startup) and write the query in `solution.sql`:

```shell
cd <slug>
docker compose up -d
docker compose exec -T postgres psql -U leetcode -d leetcode < solution.sql
docker compose down
```

Supplementary notes (deep-dives on a SQL function, a planner parameter, etc.) go in a `reference/` subfolder — one topic per Markdown file — added per problem when needed.

### LeetCode :: Rust

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-rust
```

### LeetCode :: Scala

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-scala
```

### LeetCode :: Swift

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-swift
```

## LeetCode environment

LeetCode runs each language on a specific toolchain version.
Before relying on a local run, check the current versions against the official LeetCode documentation:
https://support.leetcode.com/hc/en-us/articles/360011833974-What-are-the-environments-for-the-programming-languages

## Install `cookiecutter`

`cookiecutter` is pinned in `mise.toml` at the repo root,
so [mise](https://mise.jdx.dev) provides it —
no manual install needed.
From a clone of this repo, run:

```shell
mise install
```

That fetches the pinned `cookiecutter` (and the Python it runs on)
into an isolated environment.
With mise activated in your shell,
`cookiecutter` is then on your `PATH`;
otherwise prefix commands with `mise exec --`.
