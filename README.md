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

The recommended way is to use `pipx`:

```shell
pip install pipx
pipx install cookiecutter
```

See more instructions in the official repo: https://github.com/cookiecutter/cookiecutter
