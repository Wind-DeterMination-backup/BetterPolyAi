# workflows 层说明

这一层承载 GitHub Actions 的具体工作流定义，决定仓库被推送到 `main` 后怎么自动构建和发版。

## 当前内容

- `release.yml` 是唯一工作流，因此仓库的 CI/CD 路径非常单一：推送到 `main` 时触发自动语义化发版。

## 实现细节

- 工作流使用 `actions/checkout` 拉取完整历史，原因是它需要 `git describe` 和 commit 日志来推导新版本号。
- 使用 Java 17 运行 Gradle，但输出目标仍由 `build.gradle` 约束为 Java 8 字节码。
- 通过 `android-actions/setup-android` 和 `sdkmanager` 安装 Android build-tools，再解析出 `D8_PATH`，配合本地 `dexAndroid` 任务产出 Android 包。
- 内嵌 Python 脚本按 commit message 计算 major/minor/patch 级别，只在存在 `feat`、`fix` 等“值得发布”的提交时继续执行。
- 工作流会直接修改 `build.gradle`、`src/main/resources/mod.json`、`CHANGELOG.md`，提交回仓库，再打 tag、生成 `dist/` 目录并创建 GitHub Release。

## 和其他层级的关系

- 它是 `build.gradle` 的远程执行者。
- 它回写 `src/main/resources/mod.json` 和 `CHANGELOG.md`，所以既消费源码也修改源码。
- 它生成的 `dist/*.zip` 与 `dist/*.jar` 是对外发布界面看到的最终附件。
