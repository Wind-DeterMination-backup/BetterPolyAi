# .github 层说明

这一层只负责仓库托管平台相关自动化，不参与模组在 Mindustry 内的运行逻辑。

## 当前职责

- 存放 GitHub Actions 工作流。
- 约束“何时构建、何时升级版本、何时创建 Release”。
- 把根目录里的 `build.gradle`、`CHANGELOG.md` 和 `src/main/resources/mod.json` 当作发版元数据源进行回写。

## 实现方式

这里只有 `workflows/` 子目录，说明仓库没有 issue 模板、PR 模板或 Dependabot 配置，自动化重心完全放在发布流程。

## 层级关系

- 上游依赖根目录的 Git 历史和 Gradle 脚本。
- 下游驱动 `dist/` 风格的发布包生成，并同步回写源码层的版本信息。
