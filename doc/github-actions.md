# Continuous Integration with GitHub Actions

Continuous Integration (CI) runs on [GitHub Actions](../doc/tools.md#github-actions).

## Conventions

Workflows and jobs are structured according to [local
conventions](../doc/decisions.md#github-actions-conventions).

## Jobs

Jobs are defined in  `.github/workflows/` and run on [Ubuntu 24.04
LTS](https://github.com/actions/runner-images/blob/main/images/ubuntu/Ubuntu2404-Readme.md).

Jobs use a few pre-defined steps to set up the build environment:

- `setup-java`: <https://github.com/actions/setup-java/tree/v4>
- `setup-sbt`: <https://github.com/sbt/setup-sbt/tree/v1>
- Other officially-supported actions: <https://github.com/actions>
