# cookiecutters

Cookiecutters for various projects.

## Usage

Execute cookiecutter with the chosen template directory:

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory <directory-name>
```

### Go for LeetCode

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-go
```

### Kotlin for LeetCode

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-kotlin
```

### PostgreSQL for LeetCode

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

### Rust for LeetCode

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-rust
```

### Scala for LeetCode

```shell
cookiecutter https://github.com/petr-korobeinikov/cookiecutters/ --directory leetcode-scala
```

### Swift for LeetCode

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
